package school.hei;
import java.util.ArrayList;
import java.util.List;

public class Dish {

    private Integer id;
    private String name;
    private DishTypeEnum dishType;
    private Double sellingPrice;
    private List<Ingredient> ingredients = new ArrayList<>();

    public Dish() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DishTypeEnum getDishType() {
        return dishType;
    }

    public void setDishType(DishTypeEnum dishType) {
        this.dishType = dishType;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Double getDishCost() {
        double totalCost = 0.0;

        for (Ingredient ingredient : ingredients) {
            if (ingredient.getRequiredQuantity() == null) {
                throw new RuntimeException(
                        "Quantité requise inconnue pour l'ingrédient : " + ingredient.getName()
                );
            }

            totalCost += ingredient.getPrice() * ingredient.getRequiredQuantity();
        }

        return totalCost;
    }

    @Override
    public String toString() {
        return "Dish { " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dishType=" + dishType +
                ", ingredients=" + ingredients.size() +
                " }";
    }
}