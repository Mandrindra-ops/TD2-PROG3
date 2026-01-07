package school.hei;

public class Ingredient {

    private int id;
    private String name;
    private double price;
    private Double requiredQuantity;
    private CategoryEnum category;

    public Ingredient() {}

    public Ingredient(String name, double price, CategoryEnum category, Double requiredQuantity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.requiredQuantity = requiredQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Double getRequiredQuantity() {
        return requiredQuantity;
    }

    public void setRequiredQuantity(Double requiredQuantity) {
        this.requiredQuantity = requiredQuantity;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return name + " (" + price + " Ar)";
    }
}
