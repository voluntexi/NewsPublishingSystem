
import com.xh.controller.NewsDetailController;
import com.xh.pojo.NewsDetail;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@MapperScan("com.xh.dao")
public class test {
    public static void main(String[] args) throws IOException {
//        // TODO: 2021/7/1  view -> controller -> service -> mapper -> datasource -> db
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Spring-config.xml");
//        NewsDetailController newsDetailController=applicationContext.getBean(NewsDetailController.class);
//        List<NewsDetail> a=newsDetailController.findNewsList();
//        for (NewsDetail b:
//             a) {
            System.out.println(new Date());

        }
    }
