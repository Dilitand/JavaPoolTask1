package ru.litvinov.javapool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.litvinov.javapool.model.dao.AutoDao;
import ru.litvinov.javapool.model.entity.Auto;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AutoServiceImpl implements AutoService {

    private AutoDao autoDao;

    @Autowired
    public void setAutoDao(AutoDao autoDao) {
        this.autoDao = autoDao;
    }

    @Override
    public int addAuto(Auto auto) {
        return autoDao.addAuto(auto);
    }

    @Override
    public void updateAuto(Auto auto) {
        autoDao.updateAuto(auto);
    }

    @Override
    public String removeAuto(int id) {
       return autoDao.removeAuto(id);
    }

    @Override
    public Auto getAutoById(int id) {
        return autoDao.getAutoById(id);
    }

    @Override
    public List<Auto> listAuto() {
        return autoDao.listAuto();
    }

    @Override
    public List<Auto> listAutoByModel(String model) {
        return autoDao.listAutoByModel(model);
    }

    @Override
    public List<Auto> listAutoByParams(String model, String minSpeed, String maxSpeed, String minMileAge, String maxMileAge,String currentPage,String countPage) {
        String qModel = "%";
        int qMinSpeed = 0;
        int qMaxSpeed = Integer.MAX_VALUE;
        int qMinMileAge = 0;
        int qMaxMileAge = Integer.MAX_VALUE;
        int qCurrentPage = 0;
        int qCountPage = 0;

        if(model != null) {
            qModel = model;
        }
        if (minSpeed != null && minSpeed.matches("\\d+")) {
            qMinSpeed = Integer.parseInt(minSpeed);
        }
        if (maxSpeed != null && maxSpeed.matches("\\d+") && Integer.parseInt(maxSpeed) > 0) {
            qMaxSpeed = Integer.parseInt(maxSpeed);
        }
        if (minMileAge != null && minMileAge.matches("\\d+")) {
            qMinMileAge = Integer.parseInt(minMileAge);
        }
        if (maxMileAge != null && maxMileAge.matches("\\d+") && Integer.parseInt(maxMileAge) > 0) {
            qMaxMileAge = Integer.parseInt(maxMileAge);
        }

        if (currentPage != null && maxMileAge != null
                && currentPage.matches("\\d+") && countPage.matches("\\d+")
                && !currentPage.equals("0") && !countPage.equals("0")){
            qCurrentPage = Integer.parseInt(currentPage);
            qCountPage = Integer.parseInt(countPage);
        }

        return autoDao.listAutoByParams(qModel,qMinSpeed,qMaxSpeed,qMinMileAge,qMaxMileAge,qCurrentPage,qCountPage);
    }

    @Override
    public List<Auto> pagination(int firstResult, int maxResult) {
        return null;
    }
}
