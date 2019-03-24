package com.leo.solutions.officetwitter.service;
/*
 * @author love.bisaria on 23/03/19
 */

import com.leo.solutions.officetwitter.dao.FollowedDao;
import com.leo.solutions.officetwitter.domain.FollowersInfoModel;
import com.leo.solutions.officetwitter.domain.UserFollowerResponse;
import com.leo.solutions.officetwitter.domain.UserInfoModel;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class FollowerService {

    @Inject
    private FollowedDao followedDao;

    public FollowersInfoModel addFollower(FollowersInfoModel followerModel){
        return followedDao.addFollower(followerModel);
    }

    public UserFollowerResponse getFollowers(int followedId){
        UserFollowerResponse response = new UserFollowerResponse();
        List<UserInfoModel> followers = followedDao.getFollowers(followedId);

        response.setId(followedId);
        response.setCount(followers.size());
        response.setFollowers(followers);

        return response;
    }
}
