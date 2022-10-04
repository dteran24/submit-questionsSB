package com.questions.SubmitQuestions.controllers;


import com.questions.SubmitQuestions.models.Question;
import com.questions.SubmitQuestions.service.QuestionService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
public class QuestionController {
    private QuestionService questionService;

    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @RequestMapping(value = "all-questions")
    public List<Question> showQuestions() {
        List<Question> questions = questionService.showAllQuestions();
        return  questions;
    }
    @RequestMapping(value = "create-question", method = RequestMethod.POST)
    public void createQuestion(@RequestBody Question question){
       questionService.addQuestion(question.getUserId(), question.getAuthor(),question.getQuestion(), question.getMyAnswers(), question.getAnswer(), LocalDate.now(), question.getDifficulty());
    }
    @RequestMapping(value = "delete-question", method = RequestMethod.DELETE)
    public void deleteQuestion(@RequestParam int id){
        questionService.deleteQuestion(id);
    }

}
