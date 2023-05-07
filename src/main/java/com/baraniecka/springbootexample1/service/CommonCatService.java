package com.baraniecka.springbootexample1.service;

import com.baraniecka.springbootexample1.configuration.CatConfig;
import com.baraniecka.springbootexample1.model.CheezyCat;
import com.baraniecka.springbootexample1.model.FactCat;
import com.baraniecka.springbootexample1.model.Joke;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonCatService {

    @Autowired
    FactCatService factCatService;
    @Autowired
    CheezyCatService cheezyCatService;
    @Autowired
    CatConfig catConfig;
    @Autowired
    FactCat factCat;
    @Autowired
    CheezyCat cheezyCat;

    public List<FactCat> tellFact() {

        factCat.setCatFact(factCatService.getCatFact());

        List<FactCat> catTell = new ArrayList<>();
        catTell.add(factCat);
        return catTell;

    }

    public List<CheezyCat> tellJoke() {
        Joke joke = cheezyCatService.getJokeApi();
        cheezyCat.setSetup(joke.getSetup());
        cheezyCat.setPunchline(joke.getPunchline());

        List<CheezyCat> catTell = new ArrayList<>();
        catTell.add(cheezyCat);
        return catTell;
    }

}
