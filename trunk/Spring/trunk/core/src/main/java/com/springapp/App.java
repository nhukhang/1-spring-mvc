package com.springapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 8/27/13
 * Time: 10:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class App {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-bean.xml");
        System.out.println("**********  Done  ***********");
    }
}
