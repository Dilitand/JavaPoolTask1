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
    public void addAuto(Auto auto) {
        autoDao.addAuto(auto);
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
}
