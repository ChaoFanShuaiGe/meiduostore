package GoodsConsumer.Service;

import model.Cart;
import model.Goods;
import model.Userorder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@FeignClient(value = "goods-provider",fallback = GoodsServiceImpl.class)
public interface GoodsService {
    @RequestMapping(value = "/getAllGoods", method = RequestMethod.GET)
    public List<Goods> getAllGoods();

    @GetMapping("/getGoodsByName")
    public List<Goods> getGoodsByName(@RequestParam("gname") String gname);

    @GetMapping("/getGoodById")
    public Goods getGoodById(@RequestParam("gid") int gid);


    @GetMapping("/getAllCart")
    public List<Cart> getAllCart(@RequestParam("uid") int uid);

    //插入一条购物车
    @GetMapping("/insertCart")
    public int insertCart(
            @RequestParam("goodsname") String goodsname,
            @RequestParam("number") int number,
            @RequestParam("price") int price,
            @RequestParam("goodid") int goodid,
            @RequestParam("uid") int uid);

    //修改购物车商品数量
    @GetMapping("/updateCart")
    public int updateCart(@RequestParam("number") int number, @RequestParam("id") int id);


    @RequestMapping(value = "/deleteCart", method = RequestMethod.GET)
    public int deleteCart(@RequestParam("gid") int gid);

    @RequestMapping(value = "/insertOrder",method = RequestMethod.GET)
    public int insertOrder(
            @RequestParam("goodsname") String goodsname,
            @RequestParam("number") int number,
            @RequestParam("price") int price,
            @RequestParam("uid") int uid);

    @GetMapping("/getAllOrder")
    public List<Userorder> getAllOrder(@RequestParam("uid") int uid);
}
