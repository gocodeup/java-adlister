import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

public class Test {
    public static void main(String[] args) {
        User user = new User("eloys", "test", "fun");

//        DaoFactory.getUsersDao().insert(user);




        user.setId(DaoFactory.getUsersDao().findByUsername("eloys").getId());
        user.setUsername("it is definitely working");
        DaoFactory.getUsersDao().update(user);




    }
}
