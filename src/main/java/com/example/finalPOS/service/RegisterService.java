package com.example.finalPOS.service;

import com.example.finalPOS.domain.PurchasingItem;
import com.example.finalPOS.domain.WarehousingItem;
import com.example.finalPOS.repository.MemberDao;
import com.example.finalPOS.service.requests.AddRequest;
import com.example.finalPOS.service.requests.BuyRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RegisterService {

    private MemberDao memberDao;

    @Autowired
    public RegisterService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    //상품 입고
    public void plus(AddRequest req) throws Exception {

        memberDao.insert(req);
    }
    
    //전체 상품 조회
    public List<WarehousingItem> checkAll(){
        return memberDao.selectAll();
    }


    //상품 제거
    public void delete(String name, int count){
        memberDao.delete(name,count);
    }


    //상품 구매
    public boolean buy(BuyRequest req){
        return memberDao.buy(req);
    }

    public List<PurchasingItem> selectAllforLog(){
        return memberDao.selectAllforLog();
    }







    //상품 가격 조회
    public int getPrice(String name){
        return memberDao.getPrice(name);
    }

    //총 매출액 조회
    public int getTotalPrice(){
        return memberDao.getTotalPrice();
    }
}
