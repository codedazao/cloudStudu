package com.borrow.service.impl;

import com.borrow.mapper.BorrowMapper;
import com.borrow.service.BorrowService;
import com.dazao.Borrow;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Resource
    BorrowMapper borrowMapper;

    @Override
    public List<Borrow> getBorrowByUserId(Integer uid) {
        return borrowMapper.getBorrowByUserId(uid);
    }
}
