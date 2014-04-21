
import com.springapp.common.dto.CategoryDTO;
import com.springapp.jms.CategoryObjProducerMessageService;
import com.springapp.service.impl.CategoryServiceImpl;
import org.apache.activemq.command.ActiveMQDestination;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;


import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 10/8/13
 * Time: 4:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Run {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        CategoryServiceImpl categoryService = (CategoryServiceImpl)context.getBean("homeCategory");
        CategoryObjProducerMessageService categoryObjProducerMessageService = (CategoryObjProducerMessageService)context.getBean("categoryObjProducerMessageService");

        try{
            List<CategoryDTO> categoryDTOs = categoryService.getGeneralCategories();//.getMainCategories();
            for(CategoryDTO categoryDTO : categoryDTOs){
                categoryObjProducerMessageService.sendMessage(categoryDTO);
            }
        }catch (Exception e){
            System.out.print(e.getMessage());
        }


    }
}
