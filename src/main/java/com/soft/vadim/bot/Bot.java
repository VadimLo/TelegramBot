package com.soft.vadim.bot;

import com.soft.vadim.director.Director;
import com.soft.vadim.download.Download;
import org.apache.log4j.Logger;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;


public class Bot extends TelegramLongPollingBot {
    private final static Logger LOG = Logger.getLogger(Bot.class);

            /**
             * Метод для приема сообщений.
             *
             * @param update Содержит сообщение от пользователя.
             */
    @Override
    public void onUpdateReceived(Update update) {

                Message message = update.getMessage();


        if (message.hasText()) {
            switch (message.getText()) {
                case "/start":
                    sendMsg(message, "Это команда старт!");


                    System.out.println(message.getText());
                    break;
                case "Команда 1":
                    sendMsg(message, Director.parseJsonToObj().getSongs().get(0).toString());
                    System.out.println(message.getText());
                    break;
                case "Команда 2":

                    sendGif(message);
                    System.out.println(message.getText());
                    break;
                default:
                    sendMsg(message, "Это дефолт! ");
                    System.out.println(message.getText());
                    break;
            }
        }
    }

    /**
     * Метод для настройки сообщения и его отправки.
     *
     * @param message id чата
     * @param s       Строка, которую необходимот отправить в качестве сообщения.
     */
    private synchronized void sendMsg(Message message, String s) {
//        String url2 = "http://94.142.138.130/api/song/download/get/10/The%20Monkees-I--39-m%20A%20Believer%20-2006%20Remastered%20Original%20Stereo%20Version--kissvk.com.mp3?origin=kissvk.com&url=https%3A%2F%2Fcs1-67v4.vkuseraudio.net%2Fp9%2Face5e89bcac96e.mp3%3Fextra%3DhDpdAw97qoRvvHYJZLEyhCFXgXFEOt9_ukYDCGLs85bmuxDApXC6MRdsPvid539BRsYIu5bqJvb3hw7YrObKvGT1SnQ_el9DlWS7ppmqgDvs5Zv4gNP5TkLpDrWyHUmKpa_90ouUENlnHhpuLH00nxFC&artist=The%20Monkees&title=I%26%2339%3Bm%20A%20Believer%20(2006%20Remastered%20Original%20Stereo%20Version)&index=4&future_urls=";
//
//        String url = "https://downloadmusicvk.ru/audio/download?aid=138499579_456239772&artist=Billie%2BEilish&title=bad%2Bguy&duration=3%3A14&secDuration=194&url=https%3A%2F%2Fcs1-68v4.vkuseraudio.net%2Fp11%2F61047b431c5cc9.mp3";
//
//        String url3 = "https://vrit.me/download.php?artist=charlie%20xcx&title=boom%20clap!&url=https://cs1-72v4.vkuseraudio.net/p10/7c583d6106a436.mp3?extra=QmqYpze_yxVrTqVTnKN2GYVdC-YXneUXalfXMYwlq2k72Rw57uf1jumVrsHbK2Mq_9XqJtH6BdfG03o3rw0DKe_ndb3PuR8NgpQZxWDO7Gjepl7apqKJ_2O3cw-wfBjBKq7bAJ1gQlqDeE07mHWTkk1U";
        String url4 = "http://185.87.49.87/api/song/download/get/10/The%20Script%20feat.%20will.i.am-Hall%20of%20Fame-kissvk.com.mp3?origin=kissvk.com&url=https%3A%2F%2Fcs1-59v4.vkuseraudio.net%2Fp22%2Fdbef5e734e97c9.mp3%3Fextra%3DxqMIm9RLUjN-Li0sFVOanhZK3H0rQc25OMXGw64XVxcswiwS1Sh3CFVrEXF2pz-4J_GsB18palnOan-NLRNB24xhjnCJUkrjw64QZrWjRZnM8VLBlgGRduHZD6usFHk8UqT-tIDE0brHw_sNbhqeWA&artist=The%20Script%20feat.%20will.i.am&title=Hall%20of%20Fame&index=6";


        SendMessage sendMessage = new SendMessage();
        SendAudio sendAudio = new SendAudio();

        sendMessage.enableMarkdown(true);

        // Создаем клавиуатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add("Команда 1");
        keyboardFirstRow.add("Команда 2");




        keyboard.add(keyboardFirstRow);

        replyKeyboardMarkup.setKeyboard(keyboard);

        sendMessage.setChatId(message.getChatId().toString());
        //sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(s);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    private synchronized void sendGif(Message message){
        SendAnimation sendAnimation =new SendAnimation();
        sendAnimation.setAnimation(new File("D:\\Java\\TelegramBot\\src\\main\\resources\\a43cf152bf5415ec9de23a8720cb2d30_187945_1556570096.gif"));
        sendAnimation.setChatId(message.getChatId());
        try {
            execute(sendAnimation);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
//        URLConnection conn = new URL(url4).openConnection();
//        InputStream is = conn.getInputStream();


    //            case "hi":
    //                LOG.info("Отправка аудио");
    //                sendAudio.setChatId(message);
    //                sendAudio.setNewAudio("bad_boy", is);
    //
    //                try {
    //                    sendAudio(sendAudio);
    //                } catch (TelegramApiException e) {
    //                    LOG.info("Exception: ", e);
    //                }
    //                break;
//        if ("1".equals(s)) {//авторизация
//            LOG.info("1 check");
//
//            sendMessage.setChatId(message.getChatId());
//            sendMessage.setText("https://oauth.vk.com/authorize?client_id=6757658&display=popup&redirect_uri=close.html&response_type=token");
//            try {
//                sendMessage(sendMessage);
//            } catch (TelegramApiException e) {
//                LOG.info("Exception: ", e);
//            }
//        } else {
//            LOG.info("default");
//            sendMessage.enableMarkdown(true);
//            sendMessage.setChatId(message.getChatId());
//            sendMessage.setText(s + word);
//            try {
//                sendMessage(sendMessage);
//            } catch (TelegramApiException e) {
//                LOG.info("Exception: ", e);
//            }
//        }


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
