package com.leo.solutions.officetwitter.controller;
/*
 * @author love.bisaria on 23/03/19
 */

import com.leo.solutions.officetwitter.domain.UserFollowerResponse;
import com.leo.solutions.officetwitter.domain.UserInfoModel;
import com.leo.solutions.officetwitter.exception.ApiException;
import com.leo.solutions.officetwitter.service.FollowerService;
import com.leo.solutions.officetwitter.service.UserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
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
    private UserInfoService userInfoService;

    @Inject
    private FollowerService followerService;

    @RequestMapping(
            method = { RequestMethod.POST},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserInfoModel addUser(HttpServletRequest request
                                 ,@RequestBody(required = true) UserInfoModel userInfoModel){
        return userInfoService.addUser(userInfoModel);
    }

    @RequestMapping(
            method = { RequestMethod.PUT},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserInfoModel updateUser(HttpServletRequest request
            ,@RequestBody(required = true) UserInfoModel userInfoModel){
        return userInfoService.updateUser(userInfoModel);
    }

    @RequestMapping(
            method = { RequestMethod.GET},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserInfoModel getUser(HttpServletRequest request
            ,@RequestParam(name = "email", required = false) String email
            ,@RequestParam(name = "handle", required = false) String handle){

        if(StringUtils.isEmpty(email) && StringUtils.isEmpty(handle)){
            throw new ApiException("either email or handle should be present", HttpStatus.BAD_REQUEST.value());
        }

        return userInfoService.getUser(email, handle);
    }

    @RequestMapping(value="/{id}/followers",
            method = { RequestMethod.GET},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserFollowerResponse getFollowers(HttpServletRequest request
                                            ,@PathVariable(value = "id") int id){
        return followerService.ggetFollowers(id);
    }

}
