package cn.edu.whu.ashman.service;

import cn.edu.whu.ashman.entities.Administrator;

/**
 * @Author Liu WeiFan
 * @create 2020年7月11日 20：56
 */
public interface IAdministratorService {

    Administrator selectAdministratorByNameService(String userName);

    void insertAdministratorService(Administrator administrator);

    void updateAdministratorService(Administrator administrator);

    void deleteAdministratorService(String userName);
}
