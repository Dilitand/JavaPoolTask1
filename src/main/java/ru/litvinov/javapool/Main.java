package ru.litvinov.javapool;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.litvinov.javapool.config.ConfigClass;
import ru.litvinov.javapool.model.dao.AutoDao;
import ru.litvinov.javapool.model.entity.Auto;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("main");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
        AutoDao dao = context.getBean("autoDaoImpl", AutoDao.class);

        System.out.println("123".matches("\\D+"));
        System.out.println("12abc3".matches("\\D+"));

        /*
        List l = dao.listAuto();
        System.out.println(l);
        */
/*
        Auto auto = dao.getAutoById(1);
        System.out.println(auto);

 */
    }
}
