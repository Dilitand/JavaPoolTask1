package ru.litvinov.javapool;


import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class ConfigClass {
    @Test
    public void findResources(){
        File file = new File("src\\main\\resources\\application.properties");
        File file2 = new File("classpath:");
        System.out.println(file2.getAbsolutePath());
        System.out.println(file.exists());
        Assert.assertTrue(file.exists());
    }

}
