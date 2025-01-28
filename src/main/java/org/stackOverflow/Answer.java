package org.stackOverflow;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
public class Answer {
    private final String answerId;
    private final String questionId;
    private final List<Comment> comments;
    private final List<String> answerVotes;
    private final String answerTimeStamp;
    private final String answerText;

    public Answer(String questionId, String answerText) {
        this.answerId = UUID.randomUUID().toString();
        this.questionId = questionId;
        this.comments = new ArrayList<>();
        this.answerVotes = new ArrayList<>();
        this.answerTimeStamp = LocalDateTime.now().toString();
        this.answerText = answerText;
    }



}
