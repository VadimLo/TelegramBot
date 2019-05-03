package com.soft.vadim.test.directortest;

import com.soft.vadim.director.Director;
import org.junit.Test;

public class DirectorTest {
    @Test
    public void shouldReturnList(){

        System.out.println(Director.parseJsonToObj().getSongs().get(1).getArtist());

    }
}
