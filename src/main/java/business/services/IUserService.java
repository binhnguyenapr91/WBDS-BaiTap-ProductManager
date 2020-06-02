package business.services;

import business.entities.Login;
import business.entities.User;
import business.entities.repositories.UserRepository;
import business.services.interfaces.UserService;

public class IUserService implements UserService {
    @Override
    public User checkLogin(Login login) {
        User user = UserRepository.getInstance().checkLogin(login);
        return user;
    }
}
