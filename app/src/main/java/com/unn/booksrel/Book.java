package com.unn.booksrel;

public class Book {

    private String name, authors, description;
    private int id;

    public Book(int id, String name, String authors, String description) {

        this.id = id;
        this.name = name;
        this.authors = authors;
        this.description = description;

    }


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getAuthors() {
        return authors;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {

        return "Book :id "+id+", name=" + name + ", authors=" + authors + ", description=" + description;

    }

}
