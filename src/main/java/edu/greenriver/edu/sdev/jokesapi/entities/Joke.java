package edu.greenriver.edu.sdev.jokesapi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Joke
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jokeId;
    private String joke;

    public Joke(String joke)
    {
        this.joke = joke;
    }
}

