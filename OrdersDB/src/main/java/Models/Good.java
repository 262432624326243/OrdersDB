package Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "goods")
public class Good {
    private int ID;
    private String type;
    private String brand;
    private String model;
    private double price;
    private String desc;

    public Good(String type, String brand, String model, double price, String desc) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.desc = desc;
    }

    public Good() {
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Good ID: " + ID + System.lineSeparator()
                + "Type: " + type + " " + brand + " " + model + System.lineSeparator()
                + "Price: " + price + System.lineSeparator()
                + "Description: " + desc;
    }
}
