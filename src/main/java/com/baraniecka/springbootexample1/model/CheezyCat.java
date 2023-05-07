package com.baraniecka.springbootexample1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CheezyCat {

    private String name;
    private int age;
    private String lifeGoal;
    private String setup;
    private String punchline;
}
