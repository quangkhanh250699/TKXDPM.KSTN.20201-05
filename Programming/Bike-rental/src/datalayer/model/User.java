package datalayer.model;

import java.util.List;

public class User {

    private int userId;
    private String name;
    private List<Bike> rentBikes;

    public User(int userId, String name, List<Bike> rentBikes) {
        this.userId = userId;
        this.name = name;
        this.rentBikes = rentBikes;
    }

    public List<Bike> getRentBikes() {
        return rentBikes;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + this.userId +
                ", name='" + this.name + '\'' +
                '}';
    }
}
