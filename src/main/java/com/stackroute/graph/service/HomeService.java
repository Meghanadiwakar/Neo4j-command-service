package com.stackroute.graph.service;

import com.stackroute.graph.model.Movie;
import com.stackroute.graph.model.Person;
import com.stackroute.graph.repository.MovieRepository;
import com.stackroute.graph.repository.PersonRepository;
import org.springframework.stereotype.Service;

//import com.stackroute.graph.model.Role;

@Service
public class HomeService {
    private MovieRepository movieRepository;
    private PersonRepository personRepository;

    public HomeService(MovieRepository movieRepository, PersonRepository personRepository) {
        this.personRepository = personRepository;
        this.movieRepository = movieRepository;
    }


    public void deletePersons() {
        personRepository.deleteAll();
    }

    public void deleteMovies() {
        movieRepository.deleteAll();
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

//    public void addRelationship(Person person,Movie movie){
//        Role role =new Role();
//        role.setMovie(movie);
//        role.setPerson(person);
//    }


}
