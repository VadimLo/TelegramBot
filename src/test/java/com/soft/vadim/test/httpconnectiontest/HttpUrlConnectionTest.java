package com.soft.vadim.test.httpconnectiontest;

import com.google.common.base.Utf8;
import com.soft.vadim.director.Director;
import com.soft.vadim.httpconnection.HttpUrlConnection;
import org.junit.Test;


import java.io.*;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

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
    @Test
    public void shouldCreateDownloadUrl(){
        System.out.println(URLEncoder.encode(Director.parseJsonToObj().getSongs().get(0).getUrl(), StandardCharsets.UTF_8));
        System.out.println("http://185.58.207.19/api/song/download/get/10/Billie%20Eilish-bad%20guy-kissvk.com.mp3?origin=kissvk.com&url=https%3A%2F%2Fcs1-68v4.vkuseraudio.net%2Fp11%2Fa11cf5cb9e8594.mp3%3Fextra%3DhhYkYXYAP6wUO94KbWH7UoTPsbxfCPpIy4yKpg0302iAVr1GMJ9hVNzk132umW2ZfUqPYmpHIg1I9nCXzhVRIsY1DqcFXpGzyCSvEgaVIsG_Mkg19-CM9XXwfIcwSGB6t_yqCcGWulKcrgZR89l9ZRA&artist=Billie%20Eilish&title=bad%20guy&index=0&future_urls=");
        System.out.println("http://185.58.207.19/api/song/download/get/10/Duke%20Dumont-Ocean%20Drive-kissvk.com.mp3?origin=kissvk.com&url=https%3A%2F%2Fcs1-74v4.vkuseraudio.net%2Fp1%2F85d2894eaa2bcb.mp3%3Fextra%3DBFCLE61jQgidfhDBs6OOWAa3H80oGQ5QZ3eowCgMhc1h2e5ujr6R8wGORFJDYkLwCMtVEC6Y2_LQd0JXiBqG7WdspgDaZFu4CT-VR7TAD8RMrCfUryY6iRZb1FhLOvrYuNZ7LJ06_ZXHM9C6Axc2gDI&artist=Duke%20Dumont&title=Ocean%20Drive&index=1&future_urls=");
    }


}

