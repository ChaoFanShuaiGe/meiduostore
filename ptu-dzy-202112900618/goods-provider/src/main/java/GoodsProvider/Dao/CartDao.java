package GoodsProvider.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CartDao {
    // 根据ID删除购物车
    int deleteCart(@Param(value = "gid") int gid);

    // 购买商品后添加一条订单数据
    int insertOrder(
            @Param("goodsname")
            String goodsname,
            @Param("number")
            int number,
            @Param("price")
            int price,
            @Param("uid")
            int uid);
}
