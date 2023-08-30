package com.borrow.controller;

import com.borrow.invoke.BookServiceInvokeRemote;
import com.borrow.invoke.UserServiceInvokeRemote;
import com.borrow.service.BorrowService;
import com.dazao.Book;
import com.dazao.Borrow;
import com.dazao.User;
import dto.BorrowUserBookDto;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BorrowController {

    @Resource
    BorrowService borrowService;
    @Resource
    UserServiceInvokeRemote userServiceInvokeRemote;
    @Resource
    BookServiceInvokeRemote bookServiceInvokeRemote;
    /**
     * 根据用户信息查询借阅信息
     * @return
     */
    @GetMapping("/borrow/{uid}")
    public BorrowUserBookDto getBorrowInfoByUserId(@PathVariable("uid") Integer uid){
        System.out.println("方法调用");
        ArrayList<Book> books = new ArrayList<>();
        User userResponseEntity = userServiceInvokeRemote.getUserById(uid);
        if (userResponseEntity != null) {
            List<Borrow> borrowByUserId =
                    borrowService.getBorrowByUserId(userResponseEntity.getUid());
            for (Borrow borrow : borrowByUserId) {
                //获得bid
                Integer bid = borrow.getBid();
                Book bookResponseEntity = bookServiceInvokeRemote.getBookById(bid);
                books.add(bookResponseEntity);
            }
            return new BorrowUserBookDto().setBooks(books).setUser(userResponseEntity);
        }
        return null;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
