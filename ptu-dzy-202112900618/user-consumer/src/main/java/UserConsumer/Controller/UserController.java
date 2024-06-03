package UserConsumer.Controller;

import UserConsumer.Service.UserService;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    // 跳转到注册页面
    @GetMapping(value = "/toregister")
    public String toregister(){
        return "register";
    }

    // 用户注册服务
    @GetMapping(value = "/register")
    public String register(String upassword, String uname,String usex){
        int tmp = userService.register(upassword, uname, usex);
        if (tmp > 0 ) {
            return "login";     // 注册成功，直接跳转到登录页面
        }
        return "register";
    }

    // 跳转到登录页面
    @GetMapping(value = "/tologin")
    public String tologin(){
        return "login";
    }

    // 用户登录服务
    @GetMapping(value = "/login")
    public String login(String uname, String upassword, HttpServletRequest request){
        User loginUser = userService.login(uname);  //  根据用户名获取用户信息
        if (loginUser != null) {
            if (loginUser.getUpassword().equals(upassword)) {
                HttpSession session = request.getSession(true);
                session.setAttribute("uaccount", loginUser.getUaccount());    //登录者信息存入session
                return "redirect:http://localhost:5000/goods/getAll?uaccount="+
                        loginUser.getUaccount()+"&upassword="+loginUser.getUpassword();
            }
        }
        request.setAttribute("msg","账号密码错误");
        return "login";
    }
}
