package ru.litvinov.javapool;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Assert;
import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;
import ru.litvinov.javapool.controller.AppController;
import ru.litvinov.javapool.model.entity.Auto;
import ru.litvinov.javapool.service.AutoService;

import java.util.ArrayList;
import java.util.List;

public class ControllerTest {

    @Mock
    private AutoService autoService;

    @InjectMocks
    private AppController appController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testList() {
        List<Auto> testList = new ArrayList<>();
        Auto auto = new Auto();
        auto.setId(1);
        auto.setMaxspeed(1);
        auto.setMileage(1);
        auto.setModel("a");
        when(autoService.listAuto()).thenReturn(testList);
        Assert.assertEquals("its Ok", autoService.listAuto(), testList);
    }
}
