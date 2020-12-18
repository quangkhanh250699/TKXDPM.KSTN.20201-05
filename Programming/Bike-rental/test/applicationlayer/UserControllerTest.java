package applicationlayer;

import datalayer.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    private UserController userController;

    @BeforeEach
    void setUp() {
        userController = new UserController();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUser() {
        int userId = 1;
        User user = userController.getUser(userId);
        assertEquals(userId, user.getUserId());
        assertEquals(true, user.getRentBikes().size() > 0);
    }
}