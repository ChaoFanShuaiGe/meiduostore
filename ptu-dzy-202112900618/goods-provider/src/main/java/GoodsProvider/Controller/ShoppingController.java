package GoodsProvider.Controller;

import GoodsProvider.Dao.ShoppingDao;
import model.Cart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ShoppingController {

    @Resource
    ShoppingDao shoppingDao;

    //查询所有购物车
    @GetMapping("/getAllCart")
    public List<Cart> getAllCart(@RequestParam("uid") int uid){
        return shoppingDao.getAllCart(uid);
    }

    //插入一条购物车
    @GetMapping("/insertCart")
    public int insertCart(
            @RequestParam("goodsname") String goodsname,
            @RequestParam("number") int number,
            @RequestParam("price") int price,
            @RequestParam("goodid") int goodid,
            @RequestParam("uid") int uid){
        return shoppingDao.insertCart(goodsname, number, price, goodid, uid);
    }

    //修改购物车商品数量
    @GetMapping("/updateCart")
    public int updateCart(@RequestParam("number") int number, @RequestParam("id") int id){
        return shoppingDao.updateCart(number, id);
    }

}
