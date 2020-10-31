package ru.litvinov.javapool.model.dao;
import org.springframework.data.domain.Page;
import ru.litvinov.javapool.model.entity.Auto;

import java.util.List;

public interface AutoDao {
    public int addAuto(Auto auto);
    public void updateAuto(Auto auto);
    public String removeAuto(int id);
    public Auto getAutoById(int id);
    public List<Auto> listAuto();
    public List<Auto> listAutoByModel(String model);
    public List<Auto> listAutoByParams(String model, int minSpeed, int maxSpeed, int minMileAge, int maxMileAge,int qCurrentPage, int qCountPage);
}
