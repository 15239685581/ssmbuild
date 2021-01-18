package com.zwb.controller;
import com.zwb.pojo.Books;
import com.zwb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dawson
 * @date 2020/11/20 - 15:34
 */
@Controller
@RequestMapping("/book")
public class BookController {
    //controller调用service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部的书籍，并且返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model)
    {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }

    //跳转到添加书籍页面
    @RequestMapping("/toAddBook")
    public String addPage()
    {
        return "addBook";
    }

    //添加书籍
    @RequestMapping("/addBook")
    public String addBook(Books book)
    {
        bookService.addBook(book);
        return "redirect:/book/allBook"; //重定向到我们的@requestMapping("/allBook")请求
    }

    //跳转到添加更新书籍页面
    @RequestMapping("/toupdate")
    public String updatePage(int id,Model model)
    {
        Books books = bookService.queryBookById(id);
        model.addAttribute("Qbook",books);
        return "updateBook";
    }

    //更新书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books)
    {
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }


    //删除书籍
    @RequestMapping("/deleteBook")
    public String deleteBook(int id)
    {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }


    //根据书名查找书籍
    @RequestMapping("/findBookByName")
    public String findBookByName(String queryBookName, Model model)
    {
        List<Books> list = new ArrayList<Books>();
        list =  bookService.queryBookByName(queryBookName);
        System.out.println(list);
        if(list.isEmpty())
        {
            list = bookService.queryAllBook();
            model.addAttribute("err","未查到书籍");
        }
        model.addAttribute("list",list);
        return "allBook";
    }

}
