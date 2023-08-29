package com.borrow.service;


import com.dazao.Borrow;

import java.util.List;

public interface BorrowService {
    List<Borrow> getBorrowByUserId(Integer uid);
}
