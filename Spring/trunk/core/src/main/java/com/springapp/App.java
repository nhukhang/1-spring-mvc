package com.springapp;

import com.springapp.model.Stock;
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

        /*Stock stock = new Stock();
        stock.setStockCode("7668");
        stock.setStockName("HAIO");
        stockService.save(stock);
          */
        /** select **/
        Stock stock2 = stockService.findByStockCode("7668");
        System.out.println(stock2);

        /** update **/
        stock2.setStockName("HAIO-1");
        stockService.update(stock2);

        /** delete **/
        stockService.delete(stock2);

        System.out.println("Done");
    }
}
