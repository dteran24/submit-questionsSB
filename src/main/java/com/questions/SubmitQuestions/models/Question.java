package com.questions.SubmitQuestions.models;

import org.springframework.cglib.core.Local;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.lang.reflect.Array;
import java.time.LocalDate;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "User Id is mandatory")
    private int userId;
    @NotBlank(message = "Author is mandatory")
    private String author;
    @NotBlank(message = "Question is mandatory")
    private String question;
    @NotBlank(message = "Answer is mandatory")
    private String answer;
    @NotBlank
    private String[] myAnswers;

    private LocalDate dateOfCreation;
    @NotBlank(message = "Difficulty is mandatory")
    private int difficulty;

    public Question(int id, int userId, String author, String question, String[] myAnswers, String answer, LocalDate dateOfCreation, int difficulty) {
        this.id = id;
        this.userId = userId;
        this.author = author;
        this.myAnswers = myAnswers;
        this.question = question;
        this.answer = answer;
        this.dateOfCreation = dateOfCreation;
        this.difficulty = difficulty;
    }

    public String[] getMyAnswers() {
        return myAnswers;
    }

    public void setMyAnswers(String[] myAnswers) {
        this.myAnswers = myAnswers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
