package com.gsxy.chatbot.config.database;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "chatbot.mybatis.datasource")
@Configuration
public class MybatisDataSourceProperties extends ConfigSetting {

    public MybatisDataSourceProperties() {
        super();
    }

}
