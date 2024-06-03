package UserProvider.Dao;

import model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

// 自动去application.yml配置文件中指定的包扫描路径找对应的mapper.xml
@Mapper
@Repository
public interface UserDao {

    // 用户注册接口
    int register(
            @Param(value = "upassword") String upassword,
            @Param(value = "uname") String uname,
            @Param(value = "usex") String usex);

    //用户登录接口
    User login(@Param(value = "uname") String uname);
}
