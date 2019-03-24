package com.leo.solutions.officetwitter.config;
/*
 * @author love.bisaria on 23/03/19
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix="spring.datasource")
public class DefaultDatabaseConfig{

    private static final Logger log = LoggerFactory.getLogger(DefaultDatabaseConfig.class);

    public static final String MAIN_DATASOURCE = "mainDbDatasource";
    public static final String MAIN_JDBCTEMPLATE = "mainDbJdbcTemplate";

    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @Bean(name=MAIN_DATASOURCE)
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource mainDbDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name=MAIN_JDBCTEMPLATE)
    public NamedParameterJdbcTemplate mainDbJdbcTemplate() {
        log.info("Datasource : {}", databaseUrl);
        return new NamedParameterJdbcTemplate(mainDbDataSource());
    }

}
