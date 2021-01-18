package com.zwb.dao;

import com.zwb.pojo.Books;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dawson
 * @date 2020/11/18 - 17:29
 */
public interface BookMapper {
    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(@Param("bookID") int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(int id);

    //查询全部的书
    List<Books> queryAllBook();

    //根据书名查询书
    List<Books> queryBookByName(@Param("bookName") String name);
}
