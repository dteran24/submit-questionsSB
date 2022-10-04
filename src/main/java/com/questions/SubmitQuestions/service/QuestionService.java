package com.questions.SubmitQuestions.service;

import com.questions.SubmitQuestions.models.Question;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


@Service
public class QuestionService {
    private static List<Question> questions = new ArrayList<>();
    private static int questionCount = 0;
    private static final String[] myAnswers = {"Dummy Answer1", "Dummy Answer2", "Dummy Answer3"};

    static {
        questions.add(new Question(questionCount++, 959061,"Daniel Teran","question", myAnswers,"answer", LocalDate.now(), 1));
        questions.add(new Question(questionCount++,959061,"Daniel Teran","question", myAnswers, "answer",LocalDate.now().minusWeeks(5), 2));
        questions.add(new Question(questionCount++,959061,"Daniel Teran","question", myAnswers, "answer",LocalDate.now().minusWeeks(3), 3));
    }
    public List<Question> showAllQuestions(){
        return questions;
    }
    public void addQuestion(int userId, String author, String question,String[]myAnswers, String answer, LocalDate creationDate, int difficulty){
        Question userQuestion = new Question(++questionCount, userId, author, question,myAnswers, answer, creationDate, difficulty);
        questions.add(userQuestion);
    }
    public void deleteQuestion(int id){
        Predicate<? super Question> predicate = question -> question.getId() == id;
        questions.removeIf(predicate);
    }
    public void updateQuestion(int id, int userId, String author, String question,String[]myAnswers, String answer, LocalDate creationDate, int difficulty){
        Predicate<? super Question> predicate = uQuestion -> uQuestion.getId() == id;
        questions.removeIf(predicate);

        Question userQuestion = new Question(++questionCount, userId, author, question,myAnswers, answer, creationDate, difficulty);
        questions.add(userQuestion);

    }
}
