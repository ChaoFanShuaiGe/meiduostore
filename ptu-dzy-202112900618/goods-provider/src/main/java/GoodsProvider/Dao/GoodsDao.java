package GoodsProvider.Dao;

import model.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsDao {
    // 查询所有商品
    List<Goods> getAllGoods();

    // 根据商品名称模糊查找
    List<Goods> getGoodsByName(@Param("gname") String gname);

    // 根据id查询单个商品详情
    Goods getGoodById(@Param("gid") int gid);
}
