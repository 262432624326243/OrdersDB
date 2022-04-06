package Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    private int ID;
    private String name;
    private String lastName;
    private int age;
    private String mail;
    private String phone;

    public User(String name, String lastName, int age, String mail, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.mail = mail;
        this.phone = phone;
    }

    public User() {
    }

    @Id
    @GeneratedValue
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Users [ ID: " + ID + System.lineSeparator()
                + "Name: " + name + " " + lastName + ", age: " + age + System.lineSeparator()
                + "email: " + mail + System.lineSeparator()
                + "phone: " + phone+"]";
    }
}
