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
        String url2 = "http://94.142.138.130/api/song/download/get/10/The%20Monkees-I--39-m%20A%20Believer%20-2006%20Remastered%20Original%20Stereo%20Version--kissvk.com.mp3?origin=kissvk.com&url=https%3A%2F%2Fcs1-67v4.vkuseraudio.net%2Fp9%2Face5e89bcac96e.mp3%3Fextra%3DhDpdAw97qoRvvHYJZLEyhCFXgXFEOt9_ukYDCGLs85bmuxDApXC6MRdsPvid539BRsYIu5bqJvb3hw7YrObKvGT1SnQ_el9DlWS7ppmqgDvs5Zv4gNP5TkLpDrWyHUmKpa_90ouUENlnHhpuLH00nxFC&artist=The%20Monkees&title=I%26%2339%3Bm%20A%20Believer%20(2006%20Remastered%20Original%20Stereo%20Version)&index=4&future_urls=";

        String url = "https://downloadmusicvk.ru/audio/download?aid=138499579_456239772&artist=Billie%2BEilish&title=bad%2Bguy&duration=3%3A14&secDuration=194&url=https%3A%2F%2Fcs1-68v4.vkuseraudio.net%2Fp11%2F61047b431c5cc9.mp3";

        String url3 = "https://vrit.me/download.php?artist=charlie%20xcx&title=boom%20clap!&url=https://cs1-72v4.vkuseraudio.net/p10/7c583d6106a436.mp3?extra=QmqYpze_yxVrTqVTnKN2GYVdC-YXneUXalfXMYwlq2k72Rw57uf1jumVrsHbK2Mq_9XqJtH6BdfG03o3rw0DKe_ndb3PuR8NgpQZxWDO7Gjepl7apqKJ_2O3cw-wfBjBKq7bAJ1gQlqDeE07mHWTkk1U";
        String url4 = "https://vrit.me/download.php?artist=Linkin%20Park&title=Nobody%27s%20Listening&url=https://cs1-78v4.vkuseraudio.net/p10/f013727acb2d1c.mp3?extra=o60gKNjjZslYmKvf2MMkk5T4rHPVvDEZIGqZlGjiUboYpKkpIjAd2hGS6PWrQYyYZDuDONn7_-J4oEk0bYBvTd9tCJfyWBRnIWvMZnxtOmzUldpZEey8GKkgMmVmQ-16YCWZCW7YcyaXmfhyIRboSEvB";

        String url5 ="http://94.142.142.113/api/song/user/get_songs/138499579?origin=kissvk.com&page=0";
        String word = "  а также ты ПИДОР";
        SendMessage sendMessage = new SendMessage();
        SendAudio sendAudio = new SendAudio();

        URLConnection conn = new URL(url4).openConnection();
        InputStream is = conn.getInputStream();
        switch (s) {
            case "hi":
                LOG.info("Отправка аудио");
                sendAudio.setChatId(chatId);
                sendAudio.setNewAudio("bad_boy", is);

                try {
                    sendAudio(sendAudio);
                } catch (TelegramApiException e) {
                    LOG.info("Exception: ", e);
                }
                break;

            case "1":
                LOG.info("1 check");
                //sendMessage.enableMarkdown(true);
                sendMessage.setChatId(chatId);
                sendMessage.setText("https://oauth.vk.com/authorize?client_id=6757658&display=popup&redirect_uri=close.html&response_type=token");
                try {
                    sendMessage(sendMessage);
                } catch (TelegramApiException e) {
                    LOG.info("Exception: ", e);
                }
                break;
            default:
                LOG.info("default");
                sendMessage.enableMarkdown(true);
                sendMessage.setChatId(chatId);
                sendMessage.setText(s + word);
                try {
                    sendMessage(sendMessage);
                } catch (TelegramApiException e) {
                    LOG.info("Exception: ", e);
                }
                break;
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
        return "811757014:AAFk8K3UcZ1AhuN3404qI00koKGDinzoKTc";
    }

}
