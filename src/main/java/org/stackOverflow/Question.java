package org.stackOverflow;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
public class Question {
    private final String questionId;
    private final String questionOwnerId;
    private final List<String> questionVotes;
    private final List<Answer> answers;
    private final String questionTag;
    private final String questionText;
    private final String questionKeyword;

    public Question(String questionOwnerId, String questionTag, String questionText, String questionKeyword) {
        this.questionId = UUID.randomUUID().toString();
        this.questionOwnerId = questionOwnerId;
        this.questionVotes = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.questionTag = questionTag;
        this.questionText = questionText;
        this.questionKeyword = questionKeyword;
    }

    public void addVote(String vote) {
        this.questionVotes.add(vote);
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

}
