package GoodsProvider.Dao;

import model.Userorder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderDao {
    // 查询所有订单
    List<Userorder> getAllOrder(@Param("uid") int uid);
}
