package org.example.ex1.service;

import org.springframework.stereotype.Service;


@Service("todoing")
public class TodoService {

    public String message() {
        return "A faire !";
    }

}
