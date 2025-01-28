package org.stackOverflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizManager {
    public Map<String, List<Question>> keywordsQuestionMap = new HashMap<>();
    public Map<String, List<Question>> tagsQuestionMap = new HashMap<>();
    public Map<String, List<Question>> userQuestionMap = new HashMap<>();
    public Map<String, Question> questionsMap = new HashMap<>();

    public synchronized void postQuestion(String questionOwnerId, String questionTag, String questionText, String questionKeyword) {
        Question question = new Question(questionOwnerId, questionTag, questionText, questionKeyword);
        try
        {
            keywordsQuestionMap.computeIfAbsent((question.getQuestionKeyword()), k -> new ArrayList<>()).add(question);
            tagsQuestionMap.computeIfAbsent((question.getQuestionTag()), k -> new ArrayList<>()).add(question);
            userQuestionMap.computeIfAbsent((question.getQuestionOwnerId()), k -> new ArrayList<>()).add(question);
            questionsMap.put(question.getQuestionId(), question);
        }
        catch (Exception e) {
            keywordsQuestionMap.getOrDefault(question.getQuestionKeyword(), new ArrayList<>()).remove(question);
            tagsQuestionMap.getOrDefault(question.getQuestionTag(), new ArrayList<>()).remove(question);
            userQuestionMap.getOrDefault(question.getQuestionOwnerId(), new ArrayList<>()).remove(question);
            questionsMap.remove(question.getQuestionId());
            throw new RuntimeException("Error adding question, rolled back changes.", e);
        }

    }

    public synchronized List<Question> searchQuestions(String searchType, String searchText) {
        return switch (searchType) {
            case "keyword" -> keywordsQuestionMap.get(searchText);
            case "tag" -> tagsQuestionMap.get(searchText);
            case "user" -> userQuestionMap.get(searchText);
            default ->
                    throw new RuntimeException("Error searching questions, searchType " + searchType + ", searchText " + searchText);
        };

    }


    public void answerQuestion(String questionId, String answerText) {
        if(!questionsMap.containsKey(questionId)) {
            throw new RuntimeException("Question " + questionId + " not found.");
        }

        Question question = questionsMap.get(questionId);
        question.addAnswer(new Answer(questionId, answerText));
        System.out.println("Answered question " + questionId + " with answer " + answerText);
    }

    public void voteQuestion(String questionId, String userId) {
        if(!questionsMap.containsKey(questionId)) {
            throw new RuntimeException("Question " + questionId + " not found.");
        }
        Question question = questionsMap.get(questionId);
        question.addVote(userId);
        System.out.println("Voted question " + questionId + " with vote " + userId);
    }

    public void comment(String userId, String answerId, String text, long timestamp, String questionId) {
        if(!questionsMap.containsKey(questionId)) {
            throw new RuntimeException("Question " + questionId + " not found.");
        }

    }

}
