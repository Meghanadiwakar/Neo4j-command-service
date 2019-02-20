package com.stackroute.graph.service;


import com.stackroute.graph.model.Question;
import com.stackroute.graph.model.User;
import com.stackroute.graph.repository.QuestionRepository;
import com.stackroute.graph.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class HomeService {

    private UserRepository userRepository;
    private QuestionRepository questionRepository;

    public HomeService(UserRepository userRepository, QuestionRepository questionRepository) {
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
    }


    public void saveUserToDb(User user) {
        userRepository.save(user);
    }

    public Collection<User> getUsers() {
        return userRepository.getAllUsers();
    }


    public void saveQuestionToDb(Question question) {
        questionRepository.save(question);
    }


    public Collection<Question> getQuestions() {
        return questionRepository.getAllQuestions();
    }
}
