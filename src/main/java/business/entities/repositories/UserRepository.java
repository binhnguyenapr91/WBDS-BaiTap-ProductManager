package business.entities.repositories;

import business.entities.Login;
import business.entities.User;
import java.util.LinkedList;
import java.util.List;

public class UserRepository {
    private static final UserRepository NEW_INSTANCE = new UserRepository();
    private final List<User> userById;

    public static UserRepository getInstance(){
        return NEW_INSTANCE;
    }

    public UserRepository(){
        super();
        this.userById = new LinkedList<User>();
        final User user1 = new User("binhnguyen","binhnguyen","BinhNguyen","binh@gmail.com",30);
        final User user2 = new User("thinhbui","thinhbui","ThinhBui","thinh@gmail.com",25);
        final User user3 = new User("linhhoang","linhhoang","LinhHoang","linh@gmail.com",30);

        this.userById.add(user1);
        this.userById.add(user2);
        this.userById.add(user3);
    }

    public User checkLogin(Login login){
        for(User u:userById){
            if(u.getUsername().equals(login.getUsername())&&u.getPassword().equals(login.getPassword())){
                return u;
            }
        }
        return null;
    }

}
