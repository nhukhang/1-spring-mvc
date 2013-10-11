
import com.springapp.common.dto.CategoryDTO;
import com.springapp.service.impl.CategoryServiceImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


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
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-services.xml");
        CategoryServiceImpl categoryService = (CategoryServiceImpl)context.getBean("homeCategory");
        try{
            List<CategoryDTO> categoryDTOs = categoryService.getMainCategory();
            for(CategoryDTO categoryDTO : categoryDTOs){
                System.out.println(categoryDTO.getName()+"  "+categoryDTO.getUrl());
            }
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
    }
}
