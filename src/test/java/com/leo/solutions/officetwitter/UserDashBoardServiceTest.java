package com.leo.solutions.officetwitter;
/*
 * @author love.bisaria on 27/03/19
 */

import com.leo.solutions.officetwitter.domain.TweetModel;
import com.leo.solutions.officetwitter.domain.UserDashboardModel;
import com.leo.solutions.officetwitter.domain.UserFollowerResponse;
import com.leo.solutions.officetwitter.domain.UserInfoModel;
import com.leo.solutions.officetwitter.domain.UserTweetsResponse;
import com.leo.solutions.officetwitter.service.FollowerService;
import com.leo.solutions.officetwitter.service.TweetsService;
import com.leo.solutions.officetwitter.service.UserDashBoardService;
import com.leo.solutions.officetwitter.service.UserInfoService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doReturn;


public class UserDashBoardServiceTest {

    @InjectMocks
    private UserDashBoardService userDashBoardService;

    @Mock
    private UserInfoService userInfoService;

    @Mock
    private TweetsService tweetsService;

    @Mock
    private FollowerService followerService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUserDashboard(){

        String email = "john.doe@exapmle.com";
        String handle = "JohnDoe";
        String tweet = "DummyTweet";
        String followerEmail = "some.follower@example.com";
        String followerHandle = "followerHandle@example.com";

        UserInfoModel userModel = new  UserInfoModel.Builder().withEmail(email)
                .withHandle(handle).build();

        TweetModel tweetModel = new TweetModel();
        tweetModel.setTweet(tweet);

        UserInfoModel usrInfo = new UserInfoModel.Builder().withEmail(followerEmail)
                .withHandle(followerHandle).build();

        UserTweetsResponse tweetsResponse = new UserTweetsResponse();
        tweetsResponse.setTweets(Arrays.asList(tweetModel));

        UserFollowerResponse followersResponse = new UserFollowerResponse();
        followersResponse.setFollowers(Arrays.asList(usrInfo));

        //setup mocks
        doReturn(userModel).when(userInfoService).getUserById(anyInt());
        doReturn(tweetsResponse).when(tweetsService).latestTweets(anyInt(), anyInt());
        doReturn(followersResponse).when(followerService).getFollowers(anyInt());

        UserDashboardModel dashboard = userDashBoardService.getUserDashBoard(anyInt());

        List<UserInfoModel> followers = dashboard.getFollowersInfoModels();
        List<TweetModel> tweets = dashboard.getTweets();

        assertEquals(1, followers.size());
        assertEquals(1, tweets.size());
        assertEquals(email, dashboard.getUserInfo().getEmail());
        assertEquals(handle, dashboard.getUserInfo().getHandle());
        assertEquals(followerEmail, followers.get(0).getEmail());
        assertEquals(followerHandle, followers.get(0).getHandle());
        assertEquals(tweet, tweets.get(0).getTweet());
    }
}
