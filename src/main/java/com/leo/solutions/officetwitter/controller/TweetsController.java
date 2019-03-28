package com.leo.solutions.officetwitter.controller;
/*
 * @author love.bisaria on 23/03/19
 */


import com.leo.solutions.officetwitter.domain.TweetModel;
import com.leo.solutions.officetwitter.domain.UserTweetsResponse;
import com.leo.solutions.officetwitter.service.TweetsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tweets")
public class TweetsController {

    @Inject
    private TweetsService tweetsService;

    @RequestMapping(
            method = { RequestMethod.POST},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public TweetModel addTweet(HttpServletRequest request
                                ,@RequestBody TweetModel tweet){
        return tweetsService.addTweet(tweet);

    }
}
