package com.jsonplaceholder.models;

import lombok.Data;

@Data
public class CommentDTO {
    int postId;
    int id;
    String name;
    String email;
    String body;
}
