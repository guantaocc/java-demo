package com.hello.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String username;

    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private Date birth;
}
