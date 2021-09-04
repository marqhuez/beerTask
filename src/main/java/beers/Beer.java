package beers;

import java.util.List;

public class Beer {
    private String type;
    private String name;
    private String id;
    private String brand;
    private Integer price;
    private List<Ingredient> ingredients;
    private Boolean isCan;

    public Beer(String type, String name, String id, String brand, Integer price, List<Ingredient> ingredients, Boolean isCan) {
        this.type = type;
        this.name = name;
        this.id = id;
        this.brand = brand;
        this.price = price;
        this.ingredients = ingredients;
        this.isCan = isCan;
    }

    public Beer() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isCan() {
        return isCan;
    }

    public void setCan(boolean can) {
        isCan = can;
    }
}
