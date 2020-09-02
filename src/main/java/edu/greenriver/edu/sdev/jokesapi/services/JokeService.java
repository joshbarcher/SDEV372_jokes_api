package edu.greenriver.edu.sdev.jokesapi.services;

import edu.greenriver.edu.sdev.jokesapi.entities.Joke;
import edu.greenriver.edu.sdev.jokesapi.repositories.IJokeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class JokeService {
    private IJokeRepository repo;

    public JokeService(IJokeRepository repo) {
        this.repo = repo;
    }

    public boolean jokeExists(int id) {
        return repo.findById(id).isPresent();
    }

    //GET
    public List<Joke> getJokes() {
        return repo.findAll();
    }

    //GET
    public Joke randomJoke() {
        Random random = new Random();
        List<Joke> jokes = repo.findAll();
        return jokes.get(random.nextInt(
                jokes.size()));
    }

    //GET
    public Joke getJokeById(int id) {
        return repo.findById(id).get();
    }

    //POST
    public Joke addJoke(Joke newJoke) {
        return repo.save(newJoke);
    }

    //PUT
    public Joke editJoke(int id, Joke editedJoke) {
        //get joke from DB, edit the data, save it
        Joke toEdit = repo.findById(id).get();
        toEdit.setJoke(editedJoke.getJoke());
        return repo.save(toEdit);
    }

    //DELETE
    public void deleteJoke(int id) {
        repo.deleteById(id);
    }

    //DELETE
    public void deleteAll() {
        repo.deleteAll();
    }
}

