package com.baraniecka.springbootexample1.configuration;

import com.baraniecka.springbootexample1.model.CheezyCat;
import com.baraniecka.springbootexample1.model.FactCat;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
@Getter
public class CatConfig {


    @Value("${kitty.fact.name}")
    private String factName;
    @Value("${kitty.fact.age}")
    private int factAge;
    @Value("${kitty.fact.goal}")
    private String factGoal;
    @Value("${kitty.cheezy.name}")
    private String cheezyName;
    @Value("${kitty.cheezy.age}")
    private int cheezyAge;
    @Value("${kitty.cheezy.goal}")
    private String cheezyGoal;
    @Autowired
    private FactCat factCat;
//    @Autowired
//    private CheezyCat cheezyCat;

    @PostConstruct
    public FactCat factCatConfig() {

        factCat.setName(factName);
        factCat.setAge(factAge);
        factCat.setLifeGoal(factGoal);
        return factCat;

    }

//    @PostConstruct
//    public CheezyCat cheezyCatConfig(){
//
//        cheezyCat.setName(cheezyName);
//        cheezyCat.setAge(cheezyAge);
//        cheezyCat.setLifeGoal(cheezyGoal);
//        return cheezyCat;
//    }
}
