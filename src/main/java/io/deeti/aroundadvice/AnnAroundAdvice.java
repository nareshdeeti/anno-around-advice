package io.deeti.aroundadvice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.deeti.aroundadvice.service.IncrAmountService;

public class AnnAroundAdvice {
    
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");

        
        System.out.println(context.getBean("ser", IncrAmountService.class)
        		.compundInstrest(10001, 1, 1));

        ((AbstractApplicationContext) context).close();

    }
}
