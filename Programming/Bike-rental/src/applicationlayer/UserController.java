package applicationlayer;

import datalayer.acessor.UserAccessor;
import datalayer.model.User;

public class UserController {
    public User getUser(int userId) {
        UserAccessor accessor = new UserAccessor();
        try {
            return accessor.get(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
