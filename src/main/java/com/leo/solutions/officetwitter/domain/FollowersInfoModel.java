package com.leo.solutions.officetwitter.domain;
/*
 * @author love.bisaria on 23/03/19
 */

import java.util.Date;

public class FollowersInfoModel {

    private int id;
    private int followed;
    private int follower;
    private Date recordAddedDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFollowed() {
        return followed;
    }

    public void setFollowed(int followed) {
        this.followed = followed;
    }

    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }

    public Date getRecordAddedDate() {
        return recordAddedDate;
    }

    public void setRecordAddedDate(Date recordAddedDate) {
        this.recordAddedDate = recordAddedDate;
    }

    public FollowersInfoModel() {}
}
