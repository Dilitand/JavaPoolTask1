package ru.litvinov.javapool.service;

import org.springframework.stereotype.Service;
import ru.litvinov.javapool.model.entity.Auto;

import java.util.List;

public interface AutoService {
    public String addAuto(Auto auto);
    public String updateAuto(Auto auto);
    public String removeAuto(int id);
    public Auto getAutoById(int id);
    public List<Auto> listAuto();
    public List<Auto> listAutoByModel(String model);
    public List<Auto> listAutoByParams(String model,String minSpeed,String maxSpeed,String minMileAge,String maxMileAge,String currentPage,String countPage);
    public List<Auto> pagination(int firstResult, int maxResult);
}
