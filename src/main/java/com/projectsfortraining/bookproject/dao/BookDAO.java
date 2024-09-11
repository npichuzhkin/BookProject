package com.projectsfortraining.bookproject.dao;

import com.projectsfortraining.bookproject.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(Book newBook){
        jdbcTemplate.update("INSERT INTO Book(name, author, year_of_release) VALUES (?,?,?)", newBook.getName(), newBook.getAuthor(), newBook.getYearOfRelease());
    }

    public Book readOne(int id){
        return jdbcTemplate.query("SELECT * FROM Book WHERE book_id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public List<Book> readByPersonId(int personId){
        return jdbcTemplate.query("SELECT * FROM Book WHERE person_id=?", new Object[]{personId}, new BeanPropertyRowMapper<>(Book.class));
    }

    public List<Book> readAll(){
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public void update(int id, Book updatedBook){
        jdbcTemplate.update("UPDATE Book SET name=?, author=?, year_of_release=? WHERE book_id=?", updatedBook.getName(), updatedBook.getAuthor(), updatedBook.getYearOfRelease(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Book WHERE book_id=?", id);
    }
}