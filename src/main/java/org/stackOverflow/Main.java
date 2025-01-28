package org.stackOverflow;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        QuizManager quizManager = new QuizManager();

        quizManager.postQuestion("Vishal", "Interview",
                "What is Distributed Cache?", "Cache");
        quizManager.postQuestion("Suhail", "Interview",
                "What is Redis Cache?", "Cache");
        quizManager.postQuestion("Ankit", "Interview",
                "What is Distributed DB?", "DB");
        quizManager.postQuestion("Rajat", "Interview",
                "What is NOSQL?", "DB");
        quizManager.postQuestion("Abhishek", "Interview",
                "What is CICD?", "Devops");
        quizManager.postQuestion("Rohan", "Interview",
                "What is Performance Testing?", "Testing");

        List<Question> questions = quizManager.searchQuestions("Rohan", "Interview");
        for (Question question : questions) {
            System.out.println(question.getQuestionText());
        }

    }
}