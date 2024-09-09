package org.example.ex1.model;

public class Todo {

    // ----- Propriétés -----

    private int id;
    private String name;
    private String description;
    private String status;

    // ----- Constructeur -----

    public Todo(int id, String name, String description, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    // ----- Setters/Getters -----

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // ----- Méthodes -----

    // Méthode :
    @Override
    public String toString() { // toString() permet d'afficher ce qu'il y a dans un objet
        return "Todo {name='" + name + "', description=" + description + "', status=" + status + "}";
    }

}
