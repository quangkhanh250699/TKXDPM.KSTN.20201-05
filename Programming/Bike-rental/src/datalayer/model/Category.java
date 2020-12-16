package datalayer.model;

public class Category {
    private int categoryId;
    private String name;
    private String description;
    private float cost_per_hour;
    private int n_pedals;
    private int n_seats;

    public Category(int categoryId, String name, String description, float cost_per_hour, int n_pedals, int n_seats) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.cost_per_hour = cost_per_hour;
        this.n_pedals = n_pedals;
        this.n_seats = n_seats;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getCost_per_hour() {
        return cost_per_hour;
    }

    public int getN_pedals() {
        return n_pedals;
    }

    public int getN_seats() {
        return n_seats;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost_per_hour=" + cost_per_hour +
                ", n_pedals=" + n_pedals +
                ", n_seats=" + n_seats +
                '}';
    }
}
