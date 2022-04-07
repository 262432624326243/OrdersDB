package Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "goods")
public class Goods {
    private int ID;
    private String type;
    private String brand;
    private String model;
    private double price;

    public Goods(String type, String brand, String model, double price) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public Goods() {
    }

    @Id
    @GeneratedValue
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "ID=" + ID +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
