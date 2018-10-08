package contact;

import com.CoreApplication;
import com.entities.User;
import com.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by fagarcia on 07/10/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoreApplication.class)
public class UserTest {

    @Autowired
    private UserService userService;

    /**
     * Prueba para validar el guardado de usuarios
     */
    @Test
    public void saveUserTest(){
        User user = new User();
        user.setFullName("Usuario de prueba");
        user.setUsername("123");
        user.setUsername("prueba"+ new Date().getTime()+"@gmail.com");
        user.setRole("USER");
      user = this.userService.saveUser(user);
        Assert.assertTrue(user.getId() != null);

    }

    /**
     * prueba para validar la consulta por cuenta de usuario
     */
    @Test
    public void getUserByUserNameTest() {
        User user = null;
        user = this.userService.getUserByUserName("prueba@gmail.com");
        Assert.assertNotNull(user);
    }
}
