package lv.tele2ssc.gamescore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
@SpringBootApplication
public class GamescoreApplication {

    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml"); 
        
        SpringApplication.run(GamescoreApplication.class, args);
    }
}
