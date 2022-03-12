package com.home.demo.appconfig;

import com.home.demo.MyWizardTelegramBot;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "telegrambot")
public class BotConfig {
    private String webHookPath;
    private String botUserName;
    private String botToken;

    @Bean
    public MyWizardTelegramBot MySuperTelegramBot() throws TelegramApiException {
        //TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

        MyWizardTelegramBot myWizardTelegramBot = new MyWizardTelegramBot();

        myWizardTelegramBot.setBotUserName(botUserName);
        myWizardTelegramBot.setBotToken(botToken);
        myWizardTelegramBot.setWebHookPath(webHookPath);

        return myWizardTelegramBot;
    }
}
