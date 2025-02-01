package com.ryuu.todoList.response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse {
    private String message;
    private Object data;
}
