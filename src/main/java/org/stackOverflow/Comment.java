package org.stackOverflow;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Comment {
    private final String commentId;
    private final String userId;
    private final String answerId;
    private final String text;
    private final long timestamp;
    private final String questionId;


    public Comment(String userId, String answerId, String text, long timestamp, String questionId) {
        this.commentId = UUID.randomUUID().toString();
        this.userId = userId;
        this.answerId = answerId;
        this.text = text;
        this.timestamp = timestamp;
        this.questionId = questionId;
    }
}
