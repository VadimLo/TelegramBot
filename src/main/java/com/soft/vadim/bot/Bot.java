package com.soft.vadim.bot;

import com.soft.vadim.download.Download;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.api.methods.send.SendAudio;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.media.InputMedia;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.generics.Webhook;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class Bot extends TelegramLongPollingBot {
    private final static Logger LOG = Logger.getLogger(Bot.class);

    /**
     * Метод для приема сообщений.
     *
     * @param update Содержит сообщение от пользователя.
     */
    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        try {
            sendMsg(update.getMessage().getChatId().toString(), message);
        } catch (IOException e) {
           LOG.info(e);
        }
    }

    /**
     * Метод для настройки сообщения и его отправки.
     *
     * @param chatId id чата
     * @param s      Строка, которую необходимот отправить в качестве сообщения.
     */
    private synchronized void sendMsg(String chatId, String s) throws IOException {
        String url = "https://downloadmusicvk.ru/audio/download?aid=138499579_456239772&artist=Billie%2BEilish&title=bad%2Bguy&duration=3%3A14&secDuration=194&url=https%3A%2F%2Fcs1-68v4.vkuseraudio.net%2Fp11%2F61047b431c5cc9.mp3";
        String word = "  а также ты ПИДОР";
        SendMessage sendMessage = new SendMessage();
        SendAudio sendAudio = new SendAudio();

        URLConnection conn = new URL(url).openConnection();
        InputStream is = conn.getInputStream();

        if (s.equals("hi")) {
            LOG.info("Отправка аудио");
            sendAudio.setChatId(chatId);
            sendAudio.setNewAudio("bad_boy",is);
            //sendAudio.setNewAudio(download.start());
            try {
                sendAudio(sendAudio);
            } catch (TelegramApiException e) {
                LOG.info("Exception: ", e);
            }
        } else {
            LOG.info("check else");
            sendMessage.enableMarkdown(true);
            sendMessage.setChatId(chatId);
            sendMessage.setText(s + word);
            try {
                sendMessage(sendMessage);
            } catch (TelegramApiException e) {
                LOG.info("Exception: ", e);
            }
        }

    }

    /**
     * Метод возвращает имя бота, указанное при регистрации.
     *
     * @return имя бота
     */
    @Override
    public String getBotUsername() {
        return "VkAudioBot";

    }

    /**
     * Метод возвращает token бота для связи с сервером Telegram
     *
     * @return token для бота
     */
    @Override
    public String getBotToken() {
        return "";
    }

}
