package com.example.finalPOS.repository;


import com.example.finalPOS.domain.PurchasingItem;
import com.example.finalPOS.domain.WarehousingItem;
import com.example.finalPOS.service.requests.AddRequest;
import com.example.finalPOS.service.requests.BuyRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


import javax.sql.DataSource;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class MemberDao {


    java.util.Date orderDate=new Date();
    SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
    SimpleDateFormat time = new SimpleDateFormat("a hh:mm:ss");
    String orderTime= date.format(orderDate) + time.format(orderDate);

    private JdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    //상품 입고
    public void insert(final AddRequest req) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException
                    {
                        PreparedStatement pstmt = con.prepareStatement(
                                "insert into INFO (NAME, PRICE, COUNT ,PLUSDATE ) values (?, ?, ?, ?)",
                                new String[] {"ID"} );
                        pstmt.setString(1, req.getItemName());
                        pstmt.setInt(2, req.getItemPrice());
                        pstmt.setInt(3, req.getItemCount());
                        pstmt.setString(4, orderTime);
                        return pstmt;
                    }
                },
                keyHolder );

//        Number keyValue = keyHolder.getKey();
//        item.setId(keyValue.longValue());
    }


    //전체 상품 조회
    public List<WarehousingItem> selectAll() {
        List<WarehousingItem> results = jdbcTemplate.query("select * from INFO",
                new RowMapper<WarehousingItem>() {
                    @Override
                    public WarehousingItem mapRow(ResultSet rs, int rowNum) throws SQLException {
                        WarehousingItem warehousingItem = new WarehousingItem( rs.getString("NAME"),
                                rs.getInt("PRICE"),
                                rs.getInt("COUNT"),
                                rs.getString("PLUSDATE"));

                        return warehousingItem;
                    }
                });
        return results;
    }


    //상품 삭제
    public void delete (String name , int count){

        //기존 수량을 가져옴
        int tmp = jdbcTemplate.queryForObject("select COUNT from INFO where NAME=?",Integer.class,name);

        int result=tmp-count;


        //수량이 0이면 행 자체를 삭제
        if(result==0){
            jdbcTemplate.update(
                    "DELETE FROM INFO WHERE NAME=?",name);
        }

        else{
            //업데이트 함수는 굳이 PreparedStatement객체 없이
            //이보다 더 간단하게도 가능함
            jdbcTemplate.update(
                    new PreparedStatementCreator() {
                        @Override
                        public PreparedStatement createPreparedStatement(Connection con) throws SQLException
                        {
                            PreparedStatement pstmt = con.prepareStatement(
                                    "UPDATE INFO SET COUNT=? WHERE NAME=?");
                            pstmt.setInt(1, result);
                            pstmt.setString(2, name);

                            return pstmt;
                        }
                    } );
        }

    }

    //상품 구매
    public boolean buy(final BuyRequest req){


        int count = jdbcTemplate.queryForObject("select COUNT from INFO where NAME=?",Integer.class,req.getItemName());

        if(count<req.getItemCount()){
            return false;
        }

        else{
            //구매하고자 하는 가격을 가져옴
            int price = jdbcTemplate.queryForObject("select PRICE from INFO where NAME=?",Integer.class,req.getItemName());
            int totalPrice=price*req.getItemCount();



            //구매로그DB에 추가
            //매 구매 로그는 구매마다 따로 해야 하므로 매 행에 추가가 됨
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(
                    new PreparedStatementCreator() {
                        @Override
                        public PreparedStatement createPreparedStatement(Connection con) throws SQLException
                        {
                            PreparedStatement pstmt = con.prepareStatement(
                                    "insert into PURCHASELOG (NAME, PRICE, PLUSDATE, COUNT,TOTALPRICE) values (?, ?, ?, ?, ?)",
                                    new String[] {"ID"} );
                            pstmt.setString(1, req.getItemName());
                            pstmt.setInt(2, price);
                            pstmt.setString(3, orderTime);
                            pstmt.setInt(4, req.getItemCount());
                            pstmt.setInt(5, totalPrice);
                            return pstmt;
                        }
                    },
                    keyHolder );


            //창고DB에서 수량만큼 제거
            this.delete(req.getItemName(),req.getItemCount());

            return true;
        }
    }


    //전체 상품 조회
    public List<PurchasingItem> selectAllforLog() {
        List<PurchasingItem> results = jdbcTemplate.query("select * from PURCHASELOG",
                new RowMapper<PurchasingItem>() {
                    @Override
                    public PurchasingItem mapRow(ResultSet rs, int rowNum) throws SQLException {
                        PurchasingItem purchasingItem = new PurchasingItem(
                                rs.getString("NAME"),
                                rs.getInt("PRICE"),
                                rs.getString("PLUSDATE"),
                                rs.getInt("COUNT"),
                                rs.getInt("TOTALPRICE"));
                        return purchasingItem;
                    }
                });
        return results;
    }





//가격 조회
public int getPrice (String name){
    int price = jdbcTemplate.queryForObject("select PRICE from INFO where NAME=?",Integer.class,name);
    return price;
}

//총 매출액 조회
public int getTotalPrice (){
    int totalPrice = jdbcTemplate.queryForObject("select sum(TOTALPRICE) from PURCHASELOG",Integer.class);
    return totalPrice;
}


}

