package UserConsumer.Service;

import model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "user-provider", fallback = UserServiceImpl.class)
public interface UserService {
    @RequestMapping("/register")
    int register(@RequestParam(value = "upassword") String upassword,
                 @RequestParam(value = "uname") String uname,
                 @RequestParam(value = "usex") String usex);

    @RequestMapping("/login")
    User login(@RequestParam(value = "uname") String uname);
}
