package com.soft.vadim.httpconnection;

import com.soft.vadim.bot.Bot;
import org.apache.log4j.Logger;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUrlConnection {
    private final static Logger LOG = Logger.getLogger(HttpUrlConnection.class);
    public void sendGet(String USER_AGENT,String url) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        LOG.info("\nSending 'GET' request to URL : " + url);



        InputStream is = new BufferedInputStream(con.getInputStream());
        File file = new File("src\\main\\resources\\request.json");

        OutputStream outputStream = new FileOutputStream(file);


        outputStream.write(is.readAllBytes());

        outputStream.close();


    }

    // HTTP POST request
    public void sendPost(String USER_AGENT,String url) throws Exception {


        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }
//    public void conService() throws IOException {
//        HttpURLConnection urlConnection = null;
//        URL urlToRequest = new URL("http://yoursite.com/yourpage?key=val&key1=val1");
//        urlConnection = (HttpURLConnection) urlToRequest.openConnection();
//        urlConnection.setConnectTimeout(CONN_TIMEOUT);
//        urlConnection.setReadTimeout(READ_TIMEOUT);
//
//
//        int statusCode = urlConnection.getResponseCode();
//        if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
//            // handle unauthorized (if service requires user login)
//        } else if (statusCode != HttpURLConnection.HTTP_OK) {
//            // handle any other errors, like 404, 500,..
//        }
//
//        InputStream in = new BufferedInputStream(urlConnection.getInputStream());    }

}
