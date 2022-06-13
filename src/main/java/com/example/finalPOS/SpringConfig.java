package com.example.finalPOS;

import com.example.finalPOS.repository.MemberDao;
import com.example.finalPOS.service.RegisterService;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {

    @Bean
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/POS?characterEncoding=utf8&serverTimezone=UTC");
        ds.setUsername("finalPOS");
        ds.setPassword("finalPOS");

        return ds;
    }

    @Bean
    public MemberDao memberDao() {
        return new MemberDao(dataSource());
    }

    @Bean
    public RegisterService registerService() {
        return new RegisterService(memberDao());
    }

}
