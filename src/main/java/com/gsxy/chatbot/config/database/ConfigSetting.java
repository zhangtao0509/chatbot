package com.gsxy.chatbot.config.database;

import lombok.Data;

@Data
public class ConfigSetting {
    private String mysqlUrl;
    private String mysqlDriverClassName;
    private String mysqlUserName;
    private String mysqlPassword;
}
