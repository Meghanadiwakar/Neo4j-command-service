package com.stackroute.graph.service;

import com.stackroute.graph.model.Movie;
import com.stackroute.graph.model.Person;
import com.stackroute.graph.repository.MovieRepository;
import com.stackroute.graph.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class HomeService {
    private MovieRepository movieRepository;
    private PersonRepository personRepository;

    public HomeService(MovieRepository movieRepository, PersonRepository personRepository) {
        this.personRepository = personRepository;
        this.movieRepository = movieRepository;
    }


    public void deletePersons(String name) {
        personRepository.deleteByName(name);
    }

    public void deleteMovies(int released) {
        movieRepository.deleteByReleased(released);
    }

    public Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public void saveMovieToDb(Movie movie) {
        movieRepository.save(movie);
    }

    public Iterable<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public void savePersonToDb(Person person) {
        personRepository.save(person);
    }

    public Collection<Movie> getMovies() {
        return movieRepository.getAllMovies();
    }

    public Collection<Person> getPersons() {
        return personRepository.getAllPersons();
    }


}
