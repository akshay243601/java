package com.java.notification.model;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class SmsInfo {
    private List<String> numbers;
    private String from;
    private String message;
}
