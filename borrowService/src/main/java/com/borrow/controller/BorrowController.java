package com.borrow.controller;


import com.borrow.service.BorrowService;
import com.dazao.Book;
import com.dazao.Borrow;
import com.dazao.User;
import dto.BorrowUserBookDto;
import finalconst.OtherServiceUrl;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BorrowController {

    @Resource
    BorrowService borrowService;
    /**
     * 根据用户信息查询借阅信息
     * @return
     */
    @GetMapping("/borrow/{uid}")
    public BorrowUserBookDto getBorrowInfoByUserId(@PathVariable("uid") Integer uid){
        RestTemplate restTemplate = new RestTemplate();
        ArrayList<Book> books = new ArrayList<>();
        User userResponseEntity = restTemplate.
                getForEntity(OtherServiceUrl.UserService +"/user/"+ uid, User.class).getBody();
        if (userResponseEntity != null) {
            List<Borrow> borrowByUserId =
                    borrowService.getBorrowByUserId(userResponseEntity.getUid());
            for (Borrow borrow : borrowByUserId) {
                //获得bid
                Integer bid = borrow.getBid();
                Book bookResponseEntity = restTemplate.
                        getForEntity(OtherServiceUrl.BookService+"/book/"+bid, Book.class).getBody();
                books.add(bookResponseEntity);
            }
            return new BorrowUserBookDto().setBooks(books).setUser(userResponseEntity);
        }
        return null;
    }
}
