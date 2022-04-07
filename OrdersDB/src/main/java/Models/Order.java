package Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    private int ID;
    private int goodsID;
    private int userID;
    private String orderName;
    private boolean isValid = true;

    public Order(int goodsID, int userID, String orderName) {
        this.goodsID = goodsID;
        this.userID = userID;
        this.orderName = orderName;
    }

    public Order() {
    }

    @Id
    @GeneratedValue
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(int goodID) {
        this.goodsID = goodID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ID=" + ID +
                ", goodID=" + goodsID +
                ", userID=" + userID +
                ", orderName='" + orderName + '\'' +
                ", isValid=" + isValid +
                '}';
    }
}
