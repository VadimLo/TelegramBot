package com.soft.vadim.director;

import com.google.gson.Gson;
import com.soft.vadim.song.ListSongs;
import com.soft.vadim.song.Song;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Director {

    private final static Logger LOG = Logger.getLogger(Director.class);
    public ListSongs createSongs() {
        List<Song> songs = new ArrayList<>();
        Gson g = new Gson();
//        Reader reader = null;
//        try {
//            reader =new FileReader("src\\main\\resources\\request.json");
//        } catch (FileNotFoundException e) {
//           LOG.info(e);
//        }
//        assert reader != null;
//        Song person = g.fromJson(reader, Song.class);
//        songs.add(person);


//        Song p = null;
//        try {
//            p = g.fromJson(new FileReader("D:\\Java\\TelegramBot\\src\\main\\resources\\request.json"), Song.class);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        assert p != null;
//        System.out.println(p.getDuration());
//        songs.add(p);
        ListSongs listSongs = null;
        try (Reader reader = new FileReader("D:\\Java\\TelegramBot\\src\\main\\resources\\request.json")) {

            // Convert JSON File to Java Object
             listSongs = g.fromJson(reader, ListSongs.class);


        } catch (IOException e) {
            e.printStackTrace();
        }


        return listSongs ;

    }
}
