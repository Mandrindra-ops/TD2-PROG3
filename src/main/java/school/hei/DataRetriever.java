package school.hei;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {
    private DBConnection db = new DBConnection();


    public Dish findDishById(int id) {
        try (Connection conn = db.getConnection()) {
            String sql = "SELECT * FROM \"Dish\" WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) return null;

            Dish dish = new Dish();
            dish.setId(rs.getInt("id"));
            dish.setName(rs.getString("name"));
            dish.setDishType(DishTypeEnum.valueOf(rs.getString("dish_type")));


            String sql2 = "SELECT * FROM \"Ingredient\" WHERE id_dish = ?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, id);
            ResultSet rs2 = ps2.executeQuery();

            List<Ingredient> ingredients = new ArrayList<>();
            while (rs2.next()) {
                Ingredient ing = new Ingredient();
                ing.setId(rs2.getInt("id"));
                ing.setName(rs2.getString("name"));
                ing.setPrice(rs2.getDouble("price"));
                ing.setCategory(CategoryEnum.valueOf(rs2.getString("category")));
                ingredients.add(ing);
            }
            dish.setIngredients(ingredients);
            return dish;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Ingredient> findIngredients(int page, int size) {
        try (Connection conn = db.getConnection()) {
            int offset = (page - 1) * size;
            String sql = "SELECT * FROM \"Ingredient\" ORDER BY id LIMIT ? OFFSET ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, size);
            ps.setInt(2, offset);
            ResultSet rs = ps.executeQuery();

            List<Ingredient> ingredients = new ArrayList<>();
            while (rs.next()) {
                Ingredient ing = new Ingredient();
                ing.setId(rs.getInt("id"));
                ing.setName(rs.getString("name"));
                ing.setPrice(rs.getDouble("price"));
                ing.setCategory(CategoryEnum.valueOf(rs.getString("category")));
                ingredients.add(ing);
            }
            return ingredients;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
