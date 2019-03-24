package com.leo.solutions.officetwitter.service;
/*
 * @author love.bisaria on 23/03/19
 */


import com.leo.solutions.officetwitter.dao.TweetDao;
import com.leo.solutions.officetwitter.domain.TweetModel;
import com.leo.solutions.officetwitter.domain.UserTweetsResponse;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TweetsService {

    @Inject
    private TweetDao tweetDao;

    public TweetModel addTweet(TweetModel tweet){
        return tweetDao.insertTweet(tweet);
    }

    public UserTweetsResponse latestTweets(int user, int count){
        UserTweetsResponse response = new UserTweetsResponse();
        response.setCount(count);
        response.setUserId(user);
        response.setTweets(tweetDao.getTweets(user, count));

        return response;
    }
}
