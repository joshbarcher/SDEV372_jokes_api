package edu.greenriver.edu.sdev.jokesapi.controllers;

import edu.greenriver.edu.sdev.jokesapi.entities.Joke;
import edu.greenriver.edu.sdev.jokesapi.services.JokeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jokes")
public class JokeController
{
    private JokeService service;

    public JokeController(JokeService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<Joke>> allJokes() {
        return new ResponseEntity<>(service.getJokes(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> jokeById(@PathVariable int id) {
        //check for bad index or missing joke
        if (id < 0) {
            return new ResponseEntity<>("Invalid id",
                    HttpStatus.BAD_REQUEST);
        }
        else if (!service.jokeExists(id)) {
            return new ResponseEntity<>("Joke not found",
                    HttpStatus.NOT_FOUND);
        }

        //otherwise joke is there so return it
        return new ResponseEntity<>(service.getJokeById(id),
                HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> addJoke(@RequestBody Joke joke) {
        if (joke.getJoke().isEmpty()) {
            return new ResponseEntity<>("Invalid joke submitted",
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(service.addJoke(joke),
                HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> editJoke(@PathVariable int id,
                         @RequestBody Joke joke) {
        if (!service.jokeExists(id)) {
            return new ResponseEntity<>("Joke not found",
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(service.editJoke(id, joke), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteJoke(@PathVariable int id) {
        if (!service.jokeExists(id)) {
            return new ResponseEntity<>("Joke not found",
                    HttpStatus.NOT_FOUND);
        }

        service.deleteJoke(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<Object> exceptionHandler(Exception ex) {
        String message = "Joke should be formatted: {\"joke\": \"...\"}";
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}


    /*@PostMapping("")
    public List<Joke> addAllJokes(@RequestBody List<Joke> jokes) {
        List<Joke> results = new ArrayList<>();
        for (Joke joke : jokes) {
            joke = service.addJoke(joke);
            results.add(joke);
        }
        return results;
    }*/


    /*@RequestMapping("jokes/random")
    public Joke randomJoke() {
        return service.randomJoke();
    }*/
