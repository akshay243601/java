package com.java.notification.model;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class EmailInfo {
    private List<String> to;
    private String from;
    private String message;
    private String subject;
    private List<String> cc;
    private List<String> bcc;
}
