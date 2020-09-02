package edu.greenriver.edu.sdev.jokesapi.repositories;

import edu.greenriver.edu.sdev.jokesapi.entities.Joke;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJokeRepository extends JpaRepository<Joke, Integer>
{
}
