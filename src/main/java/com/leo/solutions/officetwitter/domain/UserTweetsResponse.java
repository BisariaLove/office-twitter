package com.leo.solutions.officetwitter.domain;
/*
 * @author love.bisaria on 23/03/19
 */

import java.util.List;

public class UserTweetsResponse {

    private int count;
    private int userId;
    private List<TweetModel> tweets;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<TweetModel> getTweets() {
        return tweets;
    }

    public void setTweets(List<TweetModel> tweets) {
        this.tweets = tweets;
    }
}
