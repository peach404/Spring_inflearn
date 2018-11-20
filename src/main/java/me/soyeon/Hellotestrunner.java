package me.soyeon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component

public class Hellotestrunner implements ApplicationRunner {

    @Autowired
    Hellotest hellotest;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        System.out.println(hellotest);
    }
}
