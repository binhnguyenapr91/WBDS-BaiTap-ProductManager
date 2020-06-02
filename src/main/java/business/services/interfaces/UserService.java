package business.services.interfaces;

import business.entities.Login;
import business.entities.User;

public interface UserService {
    public User checkLogin(Login login);
}
