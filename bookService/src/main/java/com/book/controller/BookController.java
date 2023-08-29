package com.book.controller;
import com.book.service.BookService;
import com.dazao.Book;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Resource
    BookService bookService;

    /**
     * 通过bid获取图书信息
     *
     * @param bid
     * @return
     */
    @GetMapping("/book/{bid}")
    public Book getBookById(@PathVariable("bid") Integer bid) {
        return bookService.getBookById(bid);
    }
}
