package cn.edu.whu.ashman.service.impl;

import cn.edu.whu.ashman.dao.IAdministratorDao;
import cn.edu.whu.ashman.entities.Administrator;
import cn.edu.whu.ashman.service.IAdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Liu WeiFan
 * @create 2020年7月11日 20：56
 */
@Service
public class AdministratorService implements IAdministratorService {

    @Autowired
    IAdministratorDao administratorDao = null;

    @Override
    public Administrator selectAdministratorByNameService(String userName) {
        return administratorDao.selectAdministratorByUserName(userName);
    }

    @Override
    public void insertAdministratorService(Administrator administrator) {
        administratorDao.insertAdministrator(administrator);
    }

    @Override
    public void updateAdministratorService(Administrator administrator) {
        administratorDao.updateAdministrator(administrator);
    }

    @Override
    public void deleteAdministratorService(String userName) {
        administratorDao.deleteAdministrator(userName);
    }
}
