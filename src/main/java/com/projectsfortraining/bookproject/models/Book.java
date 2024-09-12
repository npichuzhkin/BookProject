package com.projectsfortraining.bookproject.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int bookId;

    private int personId;
    @NotEmpty(message = "Название книги должно быть заполнено")
    @Size(min = 2, max = 100, message = "Название книги должно содержать от 2 до 100 символов")
    private String name;

    @NotEmpty(message = "Автор должен быть заполнен")
    @Size(min=2, max=200, message = "Имя автора должно содержать от 2 до 200 символов")
    private String author;
    private int yearOfRelease;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }
}
