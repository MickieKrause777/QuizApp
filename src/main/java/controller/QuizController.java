package controller;

import entity.Question;
import entity.Quiz;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import service.QuizService;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class QuizController implements Serializable {

    private Question question;
    private Quiz quiz = new Quiz();
    private QuizService quizService = new QuizService();

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public void addQuestion() {
        if (quiz.getQuestions() == null) {
            quiz.setQuestions(new ArrayList<>());
        }
        quiz.getQuestions().add(new Question());
    }

    public String createQuiz() {
        quizService.createQuiz(quiz);
        return "index.xhtml?faces-redirect=true";
    }

    private List<Question> questionList = new ArrayList<>();

    public void saveQuestion() {
        questionList.add(question);
        question = new Question();
        System.out.println(questionList);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Frage gespeichert!"));
    }

    public List<Question> getAllQuestions() {
        return questionList;
    }
}
