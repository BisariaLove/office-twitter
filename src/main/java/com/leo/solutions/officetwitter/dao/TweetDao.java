package com.leo.solutions.officetwitter.dao;
/*
 * @author love.bisaria on 23/03/19
 */

import com.leo.solutions.officetwitter.domain.TweetModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.leo.solutions.officetwitter.config.DefaultDatabaseConfig.MAIN_JDBCTEMPLATE;

@Repository
public class TweetDao {

    private static final Logger log = LoggerFactory.getLogger(TweetDao.class);

    @Resource(name = MAIN_JDBCTEMPLATE)
    private NamedParameterJdbcTemplate jdbcTemplate;

    private static final String ADD_TWEET = "INSERT INTO tweets(user_id, tweet, tweet_date)\n" +
            "VALUES(:userId, :tweet, :tweetDate)";

    private static final String GET_LATEST_TWEET = "SELECT * FROM tweets\n" +
            "where user_id = :userId\n" +
            "ORDER BY tweet_date DESC\n" +
            "LIMIT :count";

    public TweetModel insertTweet(TweetModel tweetModel){

        Map<String, Object> params = new HashMap<>();
        params.put("userId", tweetModel.getUserId());
        params.put("tweet", tweetModel.getTweet());

        Date curDate = new Date();

        params.put("tweetDate", curDate);

        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValues(params);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(ADD_TWEET, source, keyHolder);

        tweetModel.setId(keyHolder.getKey().intValue());
        tweetModel.setDateTime(curDate);
        return tweetModel;
    }

    public List<TweetModel> getTweets(int id, int count){

        Map<String, Object> params = new HashMap<>();
        params.put("userId", id);
        params.put("count", count);

        return jdbcTemplate.query(GET_LATEST_TWEET, params, new TweetRowMapper());
    }

    public static class TweetRowMapper implements RowMapper<TweetModel>{

        @Override
        public TweetModel mapRow(ResultSet rs, int rowNum) throws SQLException {

            return new TweetModel.Builder()
                    .withId(rs.getInt("id"))
                    .withUserId(rs.getInt("user_id"))
                    .withTweet(rs.getString("tweet"))
                    .withDateTime(rs.getDate("tweet_date"))
                    .build();
        }

    }
}
