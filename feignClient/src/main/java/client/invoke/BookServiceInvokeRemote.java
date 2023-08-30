package client.invoke;


import com.dazao.Book;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bookService")
public interface BookServiceInvokeRemote {
    @LoadBalanced
    @GetMapping("/book/{bid}")
     Book getBookById(@PathVariable("bid") Integer bid);

}
