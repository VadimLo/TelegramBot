package com.soft.vadim.start;

import com.soft.vadim.bot.Bot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

public class AppStart {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        Bot tBot =new Bot();

        try {
            telegramBotsApi.registerBot(tBot);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
