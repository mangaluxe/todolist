package org.example.ex1.controller;

import org.example.ex1.model.Todo;
import org.example.ex1.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController {

    // Création d'une liste d'objet
    List<Todo> todolist = new ArrayList<>();

    // ----- Injection de dépendance -----
    private final TodoService todoService;

    @Autowired
    public TodoController(@Qualifier("todoing") TodoService todoService) {
        this.todoService = todoService;

        // Initialisation de la liste dans le constructeur
        todolist.add(new Todo(1, "Titre 1", "Exemple description 1", "Fini"));
        todolist.add(new Todo(2, "Titre 2", "Exemple description 2", "En cours"));

//        for (Todo t : todolist) {
//            System.out.println(t);
//        }
    }
    // ----- -----

    @RequestMapping("/") // URL: http://localhost:8080/
    public String home() {
        System.out.println(todoService.message());
        return "index";
    }

    @RequestMapping("/un") // URL: http://localhost:8080/un
    public String getOneTodo(Model model) {
//        System.out.println(todoService.message());
        model.addAttribute("todo", todolist.get(1));
        model.addAttribute("todolist", todolist);
        return "un";
    }


//    @RequestMapping("/tous") // URL: http://localhost:8080/tous
//    public String getAllTodos(Model model) {
//        model.addAttribute("todolist", todolist);
//        return "tous";
//    }


    // Conversion automatique de la valeur de retour en format json :
    @RequestMapping("/tous") // URL: http://localhost:8080/tous
    @ResponseBody
    public List<Todo> getAllTodos(Model model) {
        return todolist;
    }

}
