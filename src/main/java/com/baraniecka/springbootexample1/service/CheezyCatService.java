package com.baraniecka.springbootexample1.service;

import com.baraniecka.springbootexample1.model.Joke;
import com.jayway.jsonpath.JsonPath;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CheezyCatService {

    public Joke getJokeApi() {

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://official-joke-api.appspot.com/random_joke"))
                .build();

        HttpResponse response;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        String jokeBody = response.body().toString();
        Joke joke = new Joke();
        joke.setSetup(JsonPath.read(jokeBody, "$['setup']").toString());
        joke.setPunchline(JsonPath.read(jokeBody, "$['punchline']").toString());

        return joke;
    }

//    private List<String> getJokeBody(){
//        List<String> joke = new ArrayList<>();
//        getJokeApi();
//        joke.add(JsonPath.read(jokeDTO, "$['setup']").toString());
//        joke.add(JsonPath.read(jokeDTO, "$['punchline']").toString());
//
//        return joke;
//    }
//
//    public void getJoke(){
//        robie zart
//    }
//
//    public String getSetup() {
//        return getJokeBody().get(0);
//        zwracam setup tego zartu
//    }
//
//    public String getPunchline() {
//        return getJokeBody().get(1);
//        zwracam punchline
//    }

}
