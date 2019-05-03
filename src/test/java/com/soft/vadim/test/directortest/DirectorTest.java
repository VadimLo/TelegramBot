package com.soft.vadim.test.directortest;

import com.soft.vadim.director.Director;
import org.junit.Test;

public class DirectorTest {
    @Test
    public void shouldReturnList(){
        Director director =new Director();
        System.out.println(director.createSongs().getSongs().get(1).getArtist());

    }
}
