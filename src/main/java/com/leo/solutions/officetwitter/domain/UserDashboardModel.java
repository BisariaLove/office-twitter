package com.leo.solutions.officetwitter.domain;
/*
 * @author love.bisaria on 23/03/19
 */

import java.util.List;

public class UserDashboardModel {

    private UserInfoModel userInfo;
    private List<TweetModel> tweets;
    private List<UserInfoModel> followersInfoModels;

    public UserInfoModel getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoModel userInfo) {
        this.userInfo = userInfo;
    }

    public List<TweetModel> getTweets() {
        return tweets;
    }

    public void setTweets(List<TweetModel> tweets) {
        this.tweets = tweets;
    }

    public List<UserInfoModel> getFollowersInfoModels() {
        return followersInfoModels;
    }

    public void setFollowersInfoModels(List<UserInfoModel> followersInfoModels) {
        this.followersInfoModels = followersInfoModels;
    }

    public UserDashboardModel() {
    }
}
