package com.soft.vadim.test.httpconnectiontest;

import com.soft.vadim.httpconnection.HttpUrlConnection;
import org.junit.Test;


import java.io.*;

import java.net.URL;
import java.net.URLConnection;

public class HttpUrlConnectionTest {
    @Test
    public void shouldWork() throws IOException {
//
//
        String url = " https://downloadmusicvk.ru/audio/download?aid=138499579_456239772&artist=Billie%2BEilish&title=bad%2Bguy&duration=3%3A14&secDuration=194&url=https%3A%2F%2Fcs1-68v4.vkuseraudio.net%2Fp11%2F61047b431c5cc9.mp3";

        URLConnection conn = new URL(url).openConnection();
        InputStream is = conn.getInputStream();

        OutputStream outputstream = new FileOutputStream(new File("file.mp3"));
        byte[] buffer = new byte[4096];
        int len;
        while ((len = is.read(buffer)) > 0) {
            outputstream.write(buffer, 0, len);
        }
        outputstream.close();

//        URL website = null;
//        try {
//            website = new URL("http://www.website.com/information.asp");
//            website.op
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        assert website != null;
//        try (InputStream in = website.openStream()) {
//            Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("\nTesting 2 - Send Http POST request");
//        try {
//            http.sendPost(USER_AGENT);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    @Test
    public void shouldAuthVk() {
        String url = "http://94.142.142.113/api/song/user/get_songs/138499579?origin=kissvk.com&page=0";
        HttpUrlConnection http = new HttpUrlConnection();
        String USER_AGENT = "Chrome";
        System.out.println("Testing 1 - Send Http GET request");

        try {
            http.sendGet(USER_AGENT, url);
            //  http.sendGet(USER_AGENT,url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void shouldDowwmloadHtmlToDoc(){
        //Document doc = Jsoup.connect("http://example.com/").get();
    }
}

