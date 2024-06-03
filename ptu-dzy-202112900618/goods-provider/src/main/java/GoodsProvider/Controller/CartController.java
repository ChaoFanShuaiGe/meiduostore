package GoodsProvider.Controller;

import GoodsProvider.Dao.CartDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CartController {
    @Resource
    CartDao cartDao;

    @RequestMapping(value = "/deleteCart", method = RequestMethod.GET)
    public int deleteCart(@RequestParam("gid") int gid){
        return cartDao.deleteCart(gid);
    }

    @RequestMapping(value = "/insertOrder",method = RequestMethod.GET)
    public int insertOrder(
            @RequestParam("goodsname") String goodsname,
            @RequestParam("number") int number,
            @RequestParam("price") int price,
            @RequestParam("uid") int uid){
        return cartDao.insertOrder(goodsname, number, price, uid);
    }

}
