package com.leo.solutions.officetwitter.domain;
/*
 * @author love.bisaria on 23/03/19
 */

import java.util.Date;

public class TweetModel {

    private int id;

    private int userId;

    private String tweet;

    private Date dateTime;

    private TweetModel(Builder builder) {
        setId(builder.id);
        setUserId(builder.userId);
        setTweet(builder.tweet);
        setDateTime(builder.dateTime);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }


    public static final class Builder {
        private int id;
        private int userId;
        private String tweet;
        private Date dateTime;

        public Builder() {
        }

        public Builder(TweetModel copy) {
            this.id = copy.getId();
            this.userId = copy.getUserId();
            this.tweet = copy.getTweet();
            this.dateTime = copy.getDateTime();
        }

        public Builder withId(int val) {
            id = val;
            return this;
        }

        public Builder withUserId(int val) {
            userId = val;
            return this;
        }

        public Builder withTweet(String val) {
            tweet = val;
            return this;
        }

        public Builder withDateTime(Date val) {
            dateTime = val;
            return this;
        }

        public TweetModel build() {
            return new TweetModel(this);
        }
    }

    public TweetModel() {
    }
}
