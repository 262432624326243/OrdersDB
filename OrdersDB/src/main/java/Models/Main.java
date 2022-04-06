package Models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Scanner;

public class Main {
    static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            emf = Persistence.createEntityManagerFactory("OrderDB");

            while (true) {
                System.out.println("1: add user");
                System.out.println("2: add goods");
                System.out.println("3: create order");
                System.out.println("4: view users");
                System.out.println("5: view goods");
                System.out.println("6: view orders");
                System.out.print("-> ");

                String s = sc.nextLine();
                switch (s) {
                    case "1":
                        addUser(sc);
                        break;
                    case "2":
                        addGoods(sc);
                        break;
                    case "3":
                        createOrder(sc);
                        break;
                    case "4":
                        viewUsers();
                        break;
                    case "5":
                        viewGoods();
                        break;
                    case "6":
                        viewOrders();
                        break;
                    default:
                        return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }

    private static void addUser(Scanner sc) {
        System.out.println("Enter information about user:");
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter age: ");
        String strAge = sc.nextLine();
        int age = Integer.parseInt(strAge);
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter phone: ");
        String phone = sc.nextLine();

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            User user = new User(name, lastName, age, email, phone);
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    private static void addGoods(Scanner sc) {
        System.out.println("Enter information about product:");
        System.out.print("Enter type: ");
        String type = sc.nextLine();
        System.out.print("Enter brand: ");
        String brand = sc.nextLine();
        System.out.print("Enter model: ");
        String model = sc.nextLine();
        System.out.print("Enter price: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Enter description: ");
        String desc = sc.nextLine();

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Good good = new Good(type, brand, model, price, desc);
            em.persist(good);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    private static void createOrder(Scanner sc) {
        System.out.println("Enter information about order:");
        System.out.print("Enter goods id: ");
        int goodID = Integer.parseInt(sc.nextLine());
        System.out.print("Enter user id: ");
        int userID = Integer.parseInt(sc.nextLine());
        System.out.print("Enter order name: ");
        String orderName = sc.nextLine();

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Order order = new Order(goodID, userID, orderName);
            em.persist(order);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    private static void viewUsers() {
        try {
            em = emf.createEntityManager();
            Query query = em.createQuery("SELECT u FROM User u", User.class);
            List<User> list = (List<User>) query.getResultList();

            for (User u : list)
                System.out.println(u);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    private static void viewGoods() {
        try {
            em = emf.createEntityManager();
            Query query = em.createQuery("SELECT g FROM Good g", Good.class);
            List<Good> list = (List<Good>) query.getResultList();

            for (Good g : list)
                System.out.println(g);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    private static void viewOrders() {
        try {
            em = emf.createEntityManager();
            Query query = em.createQuery("SELECT o FROM Order o", Order.class);
            List<Order> list = (List<Order>) query.getResultList();

            for (Order o : list)
                System.out.println(o);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
