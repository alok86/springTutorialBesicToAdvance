package com.softwarecafe.iocPackage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
    @Bean("pro")
    public Product findProduct()
    {   Product p  = new Product();
            p.setId(102);
        p.setName("Apple phone");
        return p;
    }

}
