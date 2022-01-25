package com.company;

import com.sun.tools.javac.Main;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Application {

    private static HttpURLConnection myConnection;
    //private static final String POSTS_API_URL = "https://reqres.in/api/users?page=2";


    public static void start() throws IOException, InterruptedException {


        String line;
        BufferedReader reader;


        StringBuffer responseContent = new StringBuffer();


        try {
            URL myURL = new URL("https://reqres.in/api/users");
            myConnection = (HttpURLConnection) myURL.openConnection();

            // request setup

            myConnection.setRequestMethod("GET");
            myConnection.setConnectTimeout(10000);
            myConnection.setReadTimeout(10000);

            int statusMode = myConnection.getResponseCode();
            System.out.println(statusMode);

            if (statusMode > 299) {
                reader = new BufferedReader(new InputStreamReader(myConnection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader((new InputStreamReader(myConnection.getInputStream())));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }


            System.out.println(responseContent.toString());
            parse(String.valueOf(responseContent));


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            myConnection.disconnect();

        }
    }

//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://reqres.in/api/users/1")).build();
//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println)
//                .thenApply(Application::parse)
//                .join();


    public static User parse(String responseBody) {

        JSONObject users = new JSONObject(responseBody);


        int id = users.getInt("id");
        String name = users.getString("first_name");
        String sec_name = users.getString("last_name");
        String email = users.getString("email");


        System.out.println(id + name + sec_name);
        return new User(name, sec_name, id);
    }
};
