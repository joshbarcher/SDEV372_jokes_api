package edu.greenriver.edu.sdev.jokesapi.bootstrap;

import edu.greenriver.edu.sdev.jokesapi.entities.Category;
import edu.greenriver.edu.sdev.jokesapi.entities.Joke;
import edu.greenriver.edu.sdev.jokesapi.repositories.ICategoryRepository;
import edu.greenriver.edu.sdev.jokesapi.repositories.IJokeRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component
public class Dataloader implements ApplicationListener<ContextRefreshedEvent> {

    private List<String> chuckNorrisJokes = List.of(
        "Chuck Norris doesn’t read books. He stares them down until he gets the information he wants.",
        "Time waits for no man. Unless that man is Chuck Norris.",
        "If you spell Chuck Norris in Scrabble, you win. Forever.",
        "Chuck Norris breathes air … five times a day.",
        "In the Beginning there was nothing … then Chuck Norris roundhouse kicked nothing and told it to get a job.",
        "When God said, “Let there be light!” Chuck said, “Say Please.”",
        "Chuck Norris has a mug of nails instead of coffee in the morning.",
        "If Chuck Norris were to travel to an alternate dimension in which there was another Chuck Norris and they both fought, they would both win.",
        "The dinosaurs looked at Chuck Norris the wrong way once. You know what happened to them.",
        "Chuck Norris’ tears cure cancer. Too bad he has never cried.",
        "Chuck Norris once roundhouse kicked someone so hard that his foot broke the speed of light",
        "If you ask Chuck Norris what time it is, he always says, ‘Two seconds till.’ After you ask, ‘Two seconds to what?’ he roundhouse kicks you in the face.",
        "Chuck Norris appeared in the ‘Street Fighter II’ video game, but was removed by Beta Testers because every button caused him to do a roundhouse kick. When asked bout this “glitch,” Chuck Norris replied, “That’s no glitch.”",
        "Since 1940, the year Chuck Norris was born, roundhouse kick related deaths have increased 13,000 percent.",
        "Chuck Norris does not own a stove, oven, or microwave , because revenge is a dish best served cold.",
        "Chuck Norris does not sleep. He waits.",
        "There is no chin behind Chuck Norris’ beard. There is only another fist.",
        "The chief export of Chuck Norris is pain.",
        "Chuck Norris recently had the idea to sell his pee as a canned beverage. It’s now called Red Bull.",
        "If paper beats rock, rock beats scissors, and scissors beats paper, what beats all 3 at the same time? Chuck Norris."
    );
    private List<String> starWarsJokes = List.of(
        "Which program do Jedi use to open PDF files? Adobe Wan Kenobi",
        "Which website did Chewbacca get arrested for creating? Wookieleaks",
        "Why did Anakin Skywalker cross the road? To get to the Dark Side",
        "Why is Yoda such a good gardener? Because he has a green thumb.",
        "Which Star Wars character travels around the world? Globi-wan Kenobi!"
    );

    private IJokeRepository jokeRepo;
    private ICategoryRepository categoryRepo;

    public Dataloader(IJokeRepository iJokeRepo, ICategoryRepository categoryRepo)
    {
        this.jokeRepo = iJokeRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //save categories and jokes...
    }

    //create a new category
    private Category createCategory(String description) {
        return null;
    }

    //add jokes to category
    private void addToCategory(Category category, List<String> jokes) {

    }
}

