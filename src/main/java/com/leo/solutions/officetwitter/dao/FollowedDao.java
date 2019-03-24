package com.leo.solutions.officetwitter.dao;
/*
 * @author love.bisaria on 23/03/19
 */

import com.leo.solutions.officetwitter.domain.FollowersInfoModel;
import com.leo.solutions.officetwitter.domain.UserInfoModel;
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
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.leo.solutions.officetwitter.config.DefaultDatabaseConfig.MAIN_JDBCTEMPLATE;

@Repository
public class FollowedDao {

    private static final Logger log = LoggerFactory.getLogger(FollowedDao.class);

    @Resource(name = MAIN_JDBCTEMPLATE)
    private NamedParameterJdbcTemplate jdbcTemplate;

    private static final String ADD_FOLLOWER = "INSERT INTO followers(followed, follower, date)\n" +
            "VALUES (:followed, :follower, :date)";

    private static final String GET_FOLLOWERS = "SELECT u.id, u.first_name, u.last_name, u.email, u.handle\n" +
                    "FROM users as u, followers as f\n" +
                    "WHERE f.followed = :followed\n" +
                    "AND f.follower = u.id;";

    public FollowersInfoModel addFollower(FollowersInfoModel followerModel){
        Map<String, Object> params = new HashMap<>();
        params.put("followed", followerModel.getFollowed());
        params.put("follower", followerModel.getFollower());


        Date currentDate = Date.from(Instant.now());
        params.put("date", currentDate);
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValues(params);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(ADD_FOLLOWER, source, keyHolder);

        followerModel.setId(keyHolder.getKey().intValue());

        return followerModel;
    }

    public List<UserInfoModel> getFollowers(int followed){
        Map<String, Object> params = new HashMap<>();
        params.put("followed", followed);

        return jdbcTemplate.query(GET_FOLLOWERS, params, new UsersDao.UserInfoRowMapper());
    }

    public static class FollowedRowMapper implements RowMapper<FollowersInfoModel> {

        @Override
        public FollowersInfoModel mapRow(ResultSet rs, int rowNum) throws SQLException {

            FollowersInfoModel model = new FollowersInfoModel();
            model.setId(rs.getInt("id"));
            model.setFollowed(rs.getInt("followed"));
            model.setFollower(rs.getInt("follower"));
            model.setRecordAddedDate(rs.getDate("record_date"));

            return model;

        }

    }
}
