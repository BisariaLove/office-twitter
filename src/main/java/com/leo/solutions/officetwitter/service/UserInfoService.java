package com.leo.solutions.officetwitter.service;
/*
 * @author love.bisaria on 23/03/19
 */

import com.leo.solutions.officetwitter.dao.UsersDao;
import com.leo.solutions.officetwitter.domain.UserInfoModel;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.inject.Inject;

@Service
public class UserInfoService {

    @Inject
    private UsersDao userDao;

    public UserInfoModel addUser(UserInfoModel userInfoModel){
        return userDao.addUser(userInfoModel);
    }

    public UserInfoModel updateUser(UserInfoModel userInfoModel){
        return userDao.updateUser(userInfoModel);
    }

    public UserInfoModel getUser(String email, String handle){

        if(!StringUtils.isEmpty(email)){
            return userDao.getUserByEmail(email);
        }
        return userDao.getUserByHandle(handle);
    }
}
