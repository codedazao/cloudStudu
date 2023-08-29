package com.book.service.impl;


import com.book.mapper.BookMapper;
import com.book.service.BookService;
import com.dazao.Book;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl  implements BookService {

    @Resource
    BookMapper bookMapper;

    @Override
    public Book getBookById(Integer bid) {
        return bookMapper.getBookById(bid);
    }
}
