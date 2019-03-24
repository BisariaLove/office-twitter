package com.leo.solutions.officetwitter;
/*
 * @author love.bisaria on 23/03/19
 */

import com.leo.solutions.officetwitter.dao.UsersDao;
import com.leo.solutions.officetwitter.domain.UserInfoModel;
import com.leo.solutions.officetwitter.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
public class UserController {

    @Inject
    private UsersDao userDao;

    @RequestMapping(
            method = { RequestMethod.POST},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserInfoModel addUser(HttpServletRequest request
                                 ,@RequestBody(required = true) UserInfoModel userInfoModel){
        return userDao.addUser(userInfoModel);
    }

    @RequestMapping(
            method = { RequestMethod.PUT},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserInfoModel updateUser(HttpServletRequest request
            ,@RequestBody(required = true) UserInfoModel userInfoModel){
        return userDao.updateUser(userInfoModel);
    }

    @RequestMapping(
            method = { RequestMethod.GET},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserInfoModel getUser(HttpServletRequest request
            ,@RequestParam(name = "email", required = false) String email
            ,@RequestParam(name = "handle", required = false) String handle) throws Exception{


        if(!StringUtils.isEmpty(email)){
             return userDao.getUserByEmail(email);
        }

        if(!StringUtils.isEmpty(handle)){
            return userDao.getUserByHandle(handle);
        }

        throw new ApiException("either email or handle should be present", HttpStatus.BAD_REQUEST.value());

    }
}
