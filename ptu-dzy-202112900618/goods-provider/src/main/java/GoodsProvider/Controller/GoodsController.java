package GoodsProvider.Controller;

import GoodsProvider.Dao.GoodsDao;
import model.Goods;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class GoodsController {
    @Resource
    GoodsDao goodsDao;

    @RequestMapping(value = "/getAllGoods", method = RequestMethod.GET)
    public List<Goods> getAllGoods(){
        return goodsDao.getAllGoods();
    }

    @GetMapping("/getGoodsByName")
    public List<Goods> getGoodsByName(@RequestParam("gname") String gname){
        return goodsDao.getGoodsByName(gname);
    }

    @GetMapping("/getGoodById")
    public Goods getGoodById(@RequestParam("gid") int gid){
        return goodsDao.getGoodById(gid);
    }

}
