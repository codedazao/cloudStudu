package dto;


import com.dazao.Book;
import com.dazao.User;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class BorrowUserBookDto {
    User user;
    List<Book> books;
}
