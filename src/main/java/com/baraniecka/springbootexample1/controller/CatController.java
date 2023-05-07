package com.baraniecka.springbootexample1.controller;

import com.baraniecka.springbootexample1.model.CheezyCat;
import com.baraniecka.springbootexample1.model.FactCat;
import com.baraniecka.springbootexample1.service.CommonCatService;
import com.sun.net.httpserver.Headers;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/cat")
@RequiredArgsConstructor
public class CatController {


    @Autowired
    private CommonCatService commonCatService;

    @Autowired FactCat factCat;

@CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/tell-fact")
    public ResponseEntity<FactCat> catTellFact(){
        commonCatService.tellFact();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(factCat);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/tell-joke")
    public ResponseEntity<CheezyCat> catTellJoke(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(commonCatService.tellJoke());
    }
}
