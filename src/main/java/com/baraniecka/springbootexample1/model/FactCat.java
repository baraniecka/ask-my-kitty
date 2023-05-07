package com.baraniecka.springbootexample1.model;


import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FactCat {

    private String name;
    private int age;
    private String lifeGoal;
    private String catFact;
}
