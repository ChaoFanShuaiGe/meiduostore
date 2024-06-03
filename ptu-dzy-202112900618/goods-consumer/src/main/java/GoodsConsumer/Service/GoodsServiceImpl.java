package GoodsConsumer.Service;

import model.Cart;
import model.Goods;
import model.Userorder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService{
    @Override
    public List<Goods> getAllGoods() {
        return Collections.emptyList();
    }

    @Override
    public List<Goods> getGoodsByName(String gname) {
        return Collections.emptyList();
    }

    @Override
    public Goods getGoodById(int gid) {
        return null;
    }

    @Override
    public List<Cart> getAllCart(int uid) {
        return Collections.emptyList();
    }

    @Override
    public int insertCart(String goodsname, int number, int price, int goodid, int uid) {
        return 0;
    }

    @Override
    public int updateCart(int number, int id) {
        return 0;
    }

    @Override
    public int deleteCart(int gid) {
        return 0;
    }

    @Override
    public int insertOrder(String goodsname, int number, int price, int uid) {
        return 0;
    }

    @Override
    public List<Userorder> getAllOrder(int uid) {
        return Collections.emptyList();
    }
}
