package com.baraniecka.springbootexample1.service;

import com.jayway.jsonpath.JsonPath;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class FactCatService {

    @PostConstruct
    private String getCatFactApi() {

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://catfact.ninja/fact"))
                .build();

        HttpResponse response;

        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response.body().toString();

    }

    public String getCatFact() {
        return JsonPath.read(getCatFactApi(), "$['fact']").toString();
    }

}
