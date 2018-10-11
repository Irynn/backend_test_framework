package com.jsonplaceholder.models;

import lombok.Data;

@Data
public class PostDTO {
    int userId;
    int id;
    String title;
    String body;
}
