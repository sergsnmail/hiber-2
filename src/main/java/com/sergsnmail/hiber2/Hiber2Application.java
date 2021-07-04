package com.sergsnmail.hiber2;

import com.sergsnmail.hiber2.service.CommonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Hiber2Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Hiber2Application.class, args);
        CommonService service = ctx.getBean(CommonService.class);

        System.out.println("OUTPUT START");
        System.out.println(service.getCustomerProduct(1L));
        System.out.println(service.getProductOrderedCustomer(1L));
    }

}
