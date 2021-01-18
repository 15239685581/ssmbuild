package com.zwb.service;

import com.zwb.dao.BookMapper;
import com.zwb.pojo.Books;

import java.util.List;

/**
 * @author dawson
 * @date 2020/11/18 - 22:50
 */
public class BookServiceImpl implements BookService{
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper)
    {
        this.bookMapper = bookMapper;
    }

    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    public List<Books> queryBookByName(String name) {
        return bookMapper.queryBookByName(name);
    }

}
