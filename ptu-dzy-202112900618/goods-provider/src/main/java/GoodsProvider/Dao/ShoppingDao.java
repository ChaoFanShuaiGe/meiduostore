package GoodsProvider.Dao;

import model.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShoppingDao {
    //查询所有购物车
    List<Cart> getAllCart(@Param("uid") int uid);

    //插入一条购物车
    int insertCart(
      @Param("goodsname") String goodsname,
      @Param("number") int number,
      @Param("price") int price,
      @Param("goodid") int goodid,
      @Param("uid") int uid
    );

    //修改购物车商品数量
    int updateCart(@Param("number") int number, @Param("id") int id);

    //选中删除购物车中的商品
    int deleteCart(@Param("id") int id);

}
