package UserConsumer.Service;

import model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public int register(String upassword, String uname, String usex) {
        return 0;
    }

    @Override
    public User login(String uname) {
        return null;
    }
}
