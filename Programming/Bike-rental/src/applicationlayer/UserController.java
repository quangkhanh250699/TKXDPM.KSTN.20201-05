package applicationlayer;

import datalayer.acessor.UserAccessor;
import datalayer.model.User;

public class UserController {
    public User getUser() {
        UserAccessor accessor = new UserAccessor();
        try {
            return accessor.getAll().get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return new User(-1, "no name");
        }
    }
}
