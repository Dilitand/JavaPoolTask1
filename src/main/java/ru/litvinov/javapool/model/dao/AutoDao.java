package ru.litvinov.javapool.model.dao;
import ru.litvinov.javapool.model.entity.Auto;

import java.util.List;

public interface AutoDao {
    public void addAuto(Auto auto);
    public void updateAuto(Auto auto);
    public String removeAuto(int id);
    public Auto getAutoById(int id);
    public List<Auto> listAuto();
    public List<Auto> listAutoByModel(String model);
}
