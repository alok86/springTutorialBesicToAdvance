package com.softwarecafe.aopPackage;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
public class AopConfiguration {
    @Bean("demo")
    public ABC findABC(){
        return new ABC();
    }

    @Bean("pay")
    public PaymentServiceImpl getPayServ(){
        return new PaymentServiceImpl();
    }

    @Bean("vd")
    public validator getValClas(){
        return new validator();
    }
    @Bean("trackValidator")
    public TrackValidator getTrackVd(){
        return new TrackValidator();
    }

    @Bean
    public AnnotationAwareAspectJAutoProxyCreator getProxy(){
        return new AnnotationAwareAspectJAutoProxyCreator();
    }
}
