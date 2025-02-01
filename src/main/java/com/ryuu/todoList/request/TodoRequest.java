package com.ryuu.todoList.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoRequest {
    private String title;
    private Boolean completed;
}
