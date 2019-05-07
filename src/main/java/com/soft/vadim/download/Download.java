package com.soft.vadim.download;


import java.io.*;

import java.net.URL;
import java.net.URLConnection;

public class Download {
    public File start() throws IOException {
        String url = "https://downloadmusicvk.ru/audio/download?aid=138499579_456239772&artist=Billie%2BEilish&title=bad%2Bguy&duration=3%3A14&secDuration=194&url=https%3A%2F%2Fcs1-68v4.vkuseraudio.net%2Fp11%2F61047b431c5cc9.mp3";

        URLConnection conn = new URL(url).openConnection();
        InputStream is = conn.getInputStream();
        File dwfile=new File("file.mp3");

        OutputStream outputStream = new FileOutputStream(dwfile);
        byte[] buffer = new byte[4096];
        int len;
        while ((len = is.read(buffer)) > 0) {
            outputStream.write(buffer, 0, len);
        }
        outputStream.close();
        return dwfile;
    }
}
