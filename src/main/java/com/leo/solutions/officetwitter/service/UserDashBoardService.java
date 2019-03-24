package com.leo.solutions.officetwitter.service;
/*
 * @author love.bisaria on 23/03/19
 */

import com.leo.solutions.officetwitter.domain.UserDashboardModel;
import com.leo.solutions.officetwitter.domain.UserInfoModel;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class UserDashBoardService {

    @Inject
    private UserInfoService userInfoService;

    @Inject
    private TweetsService tweetsService;

    @Inject
    private FollowerService followerService;

    public UserDashboardModel getUserDashBoard(int id){
        UserDashboardModel dashboardModel = new UserDashboardModel();

        dashboardModel.setUserInfo(userInfoService.getUserById(id));

        dashboardModel.setTweets(tweetsService.latestTweets(id, 100).getTweets());

        dashboardModel.setFollowersInfoModels(followerService.getFollowers(id).getFollowers());

        return dashboardModel;
    }

}
