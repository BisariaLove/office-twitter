package com.leo.solutions.officetwitter.dao;
/*
 * @author love.bisaria on 23/03/19
 */

import com.leo.solutions.officetwitter.domain.UserInfoModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static com.leo.solutions.officetwitter.config.DefaultDatabaseConfig.MAIN_JDBCTEMPLATE;


@Repository
public class UsersDao {

    private static final Logger log = LoggerFactory.getLogger(UsersDao.class);

    private static final String ADD_USER = "INSERT INTO users(first_name, last_name, email, handle)\n" +
            "VALUES (:fName, :lName, :email, :handle)";
    private static final String UPDATE_USER = "UPDATE users\n" +
            "SET first_name= :fName, lastName= :lName, email= :email, handle= :handle\n" +
            "WHERE id = :id";
    private static final String GET_USER_BY_EMAIL= "SELECT * FROM users where email = :email";
    private static final String GET_USER_BY_HANDLE = "SELECT * FROM users where handle = :handle";
    private static final String GET_USER_BY_ID = "SELECT * FROM users where id = :id";

    @Resource(name = MAIN_JDBCTEMPLATE)
    private NamedParameterJdbcTemplate jdbcTemplate;

    public UserInfoModel addUser(UserInfoModel user){
        Map<String, String> params = new HashMap<>();
        params.put("fName", user.getFirstName());
        params.put("lName", user.getLastName());
        params.put("email", user.getEmail());
        params.put("handle",user.getHandle());

        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValues(params);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(ADD_USER, source, keyHolder);

        user.setUserId(keyHolder.getKey().intValue());
        return user;
    }

    public UserInfoModel updateUser(UserInfoModel user){
        UserInfoModel existingUser = getUSerById(user.getUserId());

        if( StringUtils.isEmpty(user.getFirstName())){
            user.setFirstName(existingUser.getFirstName());
        }

        if( StringUtils.isEmpty(user.getLastName())){
           user.setLastName(existingUser.getLastName());
        }

        if(StringUtils.isEmpty(user.getEmail())){
            user.setEmail(existingUser.getEmail());
        }

        if(StringUtils.isEmpty(user.getHandle())){
            user.setEmail(existingUser.getHandle());
        }

        Map<String, Object> params = new HashMap<>();

        params.put("id", existingUser.getUserId());
        params.put("fName", user.getFirstName());
        params.put("lName", user.getLastName());
        params.put("email", user.getEmail());
        params.put("handle",user.getHandle());

        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValues(params);

        jdbcTemplate.update(ADD_USER, source);

        return user;
    }

    public UserInfoModel getUserByEmail(String email){

        Map<String, String> params = new HashMap<>();
        params.put("email", email);

        return jdbcTemplate.queryForObject(GET_USER_BY_EMAIL, params, new UserInfoRowMapper());

    }

    public UserInfoModel getUserByHandle(String handle){

        Map<String, String> params = new HashMap<>();
        params.put("handle", handle);

        return jdbcTemplate.queryForObject(GET_USER_BY_HANDLE, params, new UserInfoRowMapper());
    }

    public UserInfoModel getUSerById(int id){
        Map<String, Integer> params = new HashMap<>();
        params.put("id", id);

        return jdbcTemplate.queryForObject(GET_USER_BY_ID, params, new UserInfoRowMapper());
    }

    public static class UserInfoRowMapper implements RowMapper<UserInfoModel> {

        @Override
        public UserInfoModel mapRow(ResultSet rs, int rowNum) throws SQLException {

            UserInfoModel.Builder builder = new UserInfoModel.Builder();
            return builder.withUserId(rs.getInt("id"))
                    .withFirstName(rs.getString("first_name"))
                    .withLastName(rs.getString("last_name"))
                    .withEmail(rs.getString("email"))
                    .withHandle(rs.getString("handle"))
                    .build();
        }

    }
}
