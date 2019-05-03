package com.soft.vadim.director;

import com.google.gson.Gson;
import com.soft.vadim.song.ListSongs;
import org.apache.log4j.Logger;

import java.io.*;

public class Director {

    private final static Logger LOG = Logger.getLogger(Director.class);

    public static ListSongs parseJsonToObj() {
        Gson g = new Gson();
        ListSongs listSongs = null;
        try (Reader reader = new FileReader("D:\\Java\\TelegramBot\\src\\main\\resources\\request.json")) {

            listSongs = g.fromJson(reader, ListSongs.class);
        } catch (IOException e) {
            LOG.info(e);
        }

        return listSongs;

    }
}
