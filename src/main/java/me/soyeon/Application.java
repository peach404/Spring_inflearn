package me.soyeon;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }

    //빈 재정의 방식으로 수정
//    @Bean
//    public Hellotest hellotest(){
//        Hellotest hellotest = new Hellotest();
//        hellotest.setName("NEWPUPPY");
//        hellotest.setAge(10);
//        return  hellotest;
//    }
}
