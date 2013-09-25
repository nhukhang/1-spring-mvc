package com.springapp;

import com.springapp.model.StockEntity;
import com.springapp.service.StockService;
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
        StockService stockService = (StockService)applicationContext.getBean("stockService");

        StockEntity stock = new StockEntity();
        stock.setStockCode("7668");
        stock.setStockName("HAIO");
        stockService.save(stock);

        /** select **/
        StockEntity stock2 = stockService.findByStockCode("7668");
        System.out.println(stock2.toString());

        /** update **/
        stock2.setStockName("HAIO-1");
        stockService.update(stock2);

        /** delete **/
        stockService.delete(stock2);

        System.out.println("**********  Done  ***********");
    }
}
