package com.leo.solutions.officetwitter.domain;
/*
 * @author love.bisaria on 23/03/19
 */

import java.util.List;

public class UserFollowerResponse {

    private int id;
    private int count;
    private List<UserInfoModel> followers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<UserInfoModel> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserInfoModel> followers) {
        this.followers = followers;
    }

    public UserFollowerResponse() {
    }
}
