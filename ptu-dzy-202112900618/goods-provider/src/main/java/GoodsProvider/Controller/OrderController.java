package GoodsProvider.Controller;

import GoodsProvider.Dao.OrderDao;
import model.Userorder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrderController {
    @Resource
    OrderDao orderDao;

    @GetMapping("/getAllOrder")
    public List<Userorder> getAllOrder(@RequestParam("uid") int uid){
        return  orderDao.getAllOrder(uid);
    }
}
