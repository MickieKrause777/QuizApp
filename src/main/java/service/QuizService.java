package service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import entity.Quiz;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.Serializable;

@Named
@ApplicationScoped
public class QuizService implements Serializable {
    @PersistenceContext
    private EntityManager em;

    public void createQuiz(Quiz quiz) {
        em.persist(quiz);
    }
}
