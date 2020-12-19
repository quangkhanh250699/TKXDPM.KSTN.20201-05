package applicationlayer;

import datalayer.acessor.UserAccessor;
import datalayer.model.RentedBike;
import datalayer.model.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserController {
    public User getUser(int userId) {
        UserAccessor accessor = new UserAccessor();
        try {
            User user = accessor.get(userId);
            List<RentedBike> bikes = new ArrayList<>();
            for (RentedBike bike :
                    user.getRentBikes()) {
                if (bike.getEnd_time() == null)
                    bikes.add(bike);
            }
            return new User(
                    user.getUserId(),
                    user.getName(),
                    bikes
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
