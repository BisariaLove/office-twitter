package com.leo.solutions.officetwitter.service;
/*
 * @author love.bisaria on 23/03/19
 */


import com.leo.solutions.officetwitter.dao.TweetDao;
import com.leo.solutions.officetwitter.domain.TweetModel;
import com.leo.solutions.officetwitter.domain.UserTweetsResponse;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TweetsService {

    @Inject
    private TweetDao tweetDao;

    public TweetModel addTweet(TweetModel tweet){
        return tweetDao.insertTweet(tweet);
    }

    public UserTweetsResponse latestTweets(int user, int count){
        List<TweetModel> result = tweetDao.getTweets(user, count);

        UserTweetsResponse response = new UserTweetsResponse();

        response.setCount(result.size());
        response.setUserId(user);
        response.setTweets(result);

        return response;
    }
}
