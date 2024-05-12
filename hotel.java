import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainProjGUI extends JFrame {

    private JButton ownerButton;
    private JButton customerButton;

    public MainProjGUI() {
        setTitle("Restaurant Management System");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        JPanel panel = new JPanel();
        ownerButton = new JButton("Owner");
        customerButton = new JButton("Customer");

        ownerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openOwnerMenu();
            }
        });

        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCustomerMenu();
            }
        });

        panel.add(ownerButton);
        panel.add(customerButton);

        getContentPane().add(panel);
    }

    private void openOwnerMenu() {
        // Your owner menu logic here
        JOptionPane.showMessageDialog(this, "Owner Menu will be implemented soon!");
    }

    private void openCustomerMenu() {
        // Your customer menu logic here
        JOptionPane.showMessageDialog(this, "Customer Menu will be implemented soon!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainProjGUI mainProjGUI = new MainProjGUI();
                mainProjGUI.setVisible(true);
            }
        });
    }
}


class Staff {
    private String name;
    private int age;
    private String designation;
    private String phoneNumber;
    private double salary;

    public Staff(String name, int age, String designation, String phoneNumber, double salary) {
        this.name = name;
        this.age = age;
        this.designation = designation;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Designation: " + designation);
        System.out.println("Phone number: " + phoneNumber);
        System.out.println("Salary: $" + salary);
    }
}

class Chef extends Staff {
    private String speciality;

    public Chef(String name, int age, String speciality) {
        super(name, age, "Chef", "N/A", 0); // Default values for phoneNumber and salary
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); // Call the superclass method
        System.out.println("Speciality: " + speciality);
    }
}

class Customer {
    private String name;
    private String phoneNumber;
    private int age;
    private boolean isMember;
    private List<Order> orders;

    public Customer(String name, String phoneNumber, int age, boolean isMember) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.isMember = isMember;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public double getTotalSpent() {
        double totalSpent = 0;
        for (Order order : orders) {
            totalSpent += order.getTotalPrice();
        }
        return totalSpent;
    }

    // Getters and setters for other fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean member) {
        isMember = member;
    }

    @Override
    public String toString() {
        return "Customer: {" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                ", isMember=" + isMember +
                '}';
    }
}

class MenuItem {
    private String name;
    private double price;
    private String cuisine;
    private Chef chef; // Association with Chef

    public MenuItem(String name, double price, String cuisine, Chef chef) {
        this.name = name;
        this.price = price;
        this.chef = chef;
        this.cuisine = cuisine;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }
}

class Order {
    private List<MenuItem> items;
    private Customer customer; // Reference to the Customer who placed the order

    public Order(Customer customer) {
        this.customer = customer;
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

class Billing {
    private List<Order> orders;

    public Billing() {
        orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public double calculateTotalRevenue() {
        double total = 0;
        for (Order order : orders) {
            total += order.getTotalPrice();
        }
        return total;
    }

    public double calculateTotalRevenueWithGSTAndDiscount() {
        double totalRevenue = calculateTotalRevenue();
        double gst = totalRevenue * 0.18; // 18% GST
        double discountedTotal = totalRevenue;
        if (totalRevenue > 500) {
            discountedTotal *= 0.9; // Apply 10% discount if total exceeds $500
        }
        return discountedTotal + gst;
    }

}

public mainProj{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();
        Billing billing = new Billing();
        List<Staff> stafflist = new ArrayList<>();

        Staff staff1 = new Staff("Alice", 25, "Waiter", "12347890", 18000);
        Staff staff2 = new Staff("Bob", 30, "Waiter", "98765210", 18000);
        Staff staff3 = new Staff("surya", 27, "Dish washer", "12367890", 18000);
        Staff staff4 = new Staff("arya", 32, "Accountant", "98765210", 30000);
        Staff staff5 = new Staff("simbu", 22, "Sanitation", "12367890", 1800);
        Staff staff6 = new Staff("gopika", 30, "Waiter", "98763210", 2100);
        Staff staff7 = new Staff("maria", 32, "Decoration", "123567890", 22000);
        Staff staff8 = new Staff("Revathy", 28, "waiter", "987654310", 18000);
        Staff staff9 = new Staff("Ajith", 25, "dish washer", "123457890", 18000);
        Staff staff10 = new Staff("Shalini", 30, "Waiter", "987654320", 1800);

        // Creating some chefs
        Chef chef1 = new Chef("John", 35, "Italian Cuisine");
        Chef chef2 = new Chef("Emily", 30, "French Cuisine");
        Chef chef3 = new Chef("Aswin", 28, "Indian Cuisine");
        Chef chef4 = new Chef("Rachel", 30, "Spanish Cuisine");
        Chef chef5 = new Chef("michael", 31, "Japanese Cuisine");
        Chef chef6 = new Chef("Afreen", 31, "Arabic Cuisine");

        // Creating some menu items
        MenuItem item1 = new MenuItem("Spaghetti Carbonara", 320, "Italian", chef1);
        MenuItem item2 = new MenuItem("pepper Steak", 400, "French", chef2);
        MenuItem item3 = new MenuItem("Margherita Pizza", 290, "Italian", chef1);
        MenuItem item4 = new MenuItem("French fries", 120, "French", chef2);
        MenuItem item5 = new MenuItem("Butter chicken", 320, "indian", chef3);
        MenuItem item6 = new MenuItem("Tortila Espanola", 400, "Spanish", chef4);
        MenuItem item7 = new MenuItem("Cochinillo asado", 310, "Spanish", chef4);
        MenuItem item8 = new MenuItem("pollo al ajillo", 190, "Spanish", chef4);
        MenuItem item9 = new MenuItem("Kerala Sadhya", 200, "Indian", chef3);
        MenuItem item10 = new MenuItem("Hyderabadi biriyani", 180, "indian", chef3);
        MenuItem item11 = new MenuItem("Al faham", 260, "Arab", chef6);
        MenuItem item12 = new MenuItem("Sushi platter", 310, "Japanese", chef5);
        MenuItem item13 = new MenuItem("udon", 200, "Japanese", chef5);

        // Adding some menu items to a list
        List<MenuItem> itemsList = new ArrayList<>();
        itemsList.add(item1);
        itemsList.add(item2);
        itemsList.add(item3);
        itemsList.add(item4);
        itemsList.add(item5);
        itemsList.add(item6);
        itemsList.add(item7);
        itemsList.add(item8);
        itemsList.add(item9);
        itemsList.add(item10);
        itemsList.add(item11);
        itemsList.add(item12);
        itemsList.add(item13);

        Customer cust1 = new Customer("Aleena", "456525426", 20, true);
        Customer cust2 = new Customer("aparna", "4565744652", 28, true);
        Customer cust3 = new Customer("abhishek", "4456222265", 30, true);
        Customer cust4 = new Customer("amisha", "4568888886", 40, true);
        Customer cust5 = new Customer("devika", "456525426", 20, true);
        Customer cust6 = new Customer("anlia", "4565744652", 28, true);
        Customer cust7 = new Customer("vaishak", "4456222265", 30, true);
        Customer cust8 = new Customer("Dev", "985468886", 28, true);
        Customer cust9 = new Customer("John", "1234567890", 35, true);
        Customer cust10 = new Customer("Emily", "0987654321", 25, true);
        Customer cust11 = new Customer("Michael", "9876543210", 45, true);
        Customer cust12 = new Customer("Sophia", "0123456789", 30, true);
        Customer cust13 = new Customer("William", "1112223333", 40, true);
        Customer cust14 = new Customer("Olivia", "3332221111", 22, true);
        Customer cust15 = new Customer("James", "9998887777", 28, true);
        Customer cust16 = new Customer("Emma", "7778889999", 32, true);

        customers.add(cust1);
        customers.add(cust2);
        customers.add(cust3);
        customers.add(cust4);
        customers.add(cust5);
        customers.add(cust6);
        customers.add(cust7);
        customers.add(cust8);
        customers.add(cust9);
        customers.add(cust10);
        customers.add(cust11);
        customers.add(cust12);
        customers.add(cust13);
        customers.add(cust14);
        customers.add(cust15);
        customers.add(cust16);

        System.out.print("HI MAY I KNOW WHO YOU ARE:(customer/owner) ");
        String who = scanner.next();
        if (who.equals("owner")) {
            System.out.print("Enter your password: ");
            String password = scanner.next();

            if (password.equals("owner123")) {

                int choice;
                do {
                    System.out.println("\nOwner Menu:");
                    System.out.println("1. Add Customer");
                    System.out.println("2. Add Staff");
                    System.out.println("3.Add menuitem");
                    System.out.println("4. Display Total Revenue");
                    System.out.println("5. Exit");

                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (choice) {
                        case 1:
                            System.out.println("Enter customer details:");
                            System.out.print("Name: ");
                            String customerName = scanner.nextLine();
                            System.out.print("Phone Number: ");
                            String phoneNumber = scanner.nextLine();
                            System.out.print("Age: ");
                            int age = scanner.nextInt();
                            System.out.print("Is member (true/false): ");
                            boolean isMember = scanner.nextBoolean();
                            Customer customer = new Customer(customerName, phoneNumber, age, isMember);
                            customers.add(customer);
                            System.out.println("Customer added successfully!");
                            break;
                        case 2:
                            System.out.print("Enter staff name: ");
                            String staffName = scanner.next();
                            System.out.print("Enter staff age: ");
                            int staffAge = scanner.nextInt();
                            System.out.print("Enter staff designation: ");
                            scanner.nextLine(); // Consume newline character
                            String staffDesignation = scanner.nextLine();
                            System.out.print("Enter staff phone number: ");
                            String staffPhoneNumber = scanner.nextLine();
                            System.out.print("Enter staff salary: ");
                            double staffSalary = scanner.nextDouble();

                            // Create a new Staff object with the provided details
                            Staff newStaff = new Staff(staffName, staffAge, staffDesignation, staffPhoneNumber,
                                    staffSalary);

                            // Add the new staff to the staff list
                            stafflist.add(newStaff);

                            // Confirmation message
                            System.out.println("Staff added successfully!");
                            break;
                        case 3:
                            // Owner chooses to add a menu item
                            System.out.println("Enter menu item details:");
                            System.out.print("Name: ");
                            String itemName = scanner.nextLine();
                            System.out.print("Price: ");
                            double itemPrice = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline character
                            System.out.print("Cuisine: ");
                            String itemCuisine = scanner.nextLine();
                            System.out.println("Select Chef:");
                            for (int i = 0; i < stafflist.size(); i++) {
                                if (stafflist.get(i) instanceof Chef) {
                                    System.out.println((i + 1) + ". " + stafflist.get(i).getName());
                                }
                            }
                            System.out.print("Enter chef number: ");
                            int chefNumber = scanner.nextInt();
                            Chef chef = (Chef) stafflist.get(chefNumber - 1);
                            MenuItem newItem = new MenuItem(itemName, itemPrice, itemCuisine, chef);
                            itemsList.add(newItem);
                            System.out.println("Menu item added successfully!");
                            break;

                        case 4:
                            // Display total revenue
                            System.out.printf("Total revenue: $%.2f%n", billing.calculateTotalRevenue());
                            break;
                        case 5:
                            // Exiting the program
                            System.out.println("Exiting the program...");
                            break;
                    }
                } while (choice != 5);

            }
        } else {
            int choice;

            do {
                System.out.println("\nMenu:");
                System.out.println("1. Add Customer");
                System.out.println("2. Place Order");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.println("Enter customer details:");
                        System.out.print("Name: ");
                        String customerName = scanner.nextLine();
                        System.out.print("Phone Number: ");
                        String phoneNumber = scanner.nextLine();
                        System.out.print("Age: ");
                        int age = scanner.nextInt();
                        System.out.print("Is member (true/false): ");
                        boolean isMember = scanner.nextBoolean();
                        Customer customer = new Customer(customerName, phoneNumber, age, isMember);
                        customers.add(customer);
                        System.out.println("Customer added successfully!");
                        break;
                    case 2:
                        if (customers.isEmpty()) {
                            System.out.println("No customers available. Please add a customer first.");
                            break;
                        }
                        System.out.println("Select Customer:");
                        for (int i = 0; i < customers.size(); i++) {
                            System.out.println((i + 1) + ". " + customers.get(i).toString());
                        }
                        System.out.print("Enter customer number: ");
                        int customerNumber = scanner.nextInt();
                        Customer selectedCustomer = customers.get(customerNumber - 1);

                        System.out.println("Enter total number of items to order: ");
                        int totalItems = scanner.nextInt();
                        Order order = new Order(selectedCustomer);

                        System.out.println("Available Menu Items:");
                        for (int i = 0; i < itemsList.size(); i++) {
                            System.out.println(
                                    (i + 1) + ". " + itemsList.get(i).getName() + " - $" + itemsList.get(i).getPrice());
                        }

                        System.out.println("Add items to the order:");
                        for (int i = 0; i < totalItems; i++) {
                            System.out.print("Enter item number: ");
                            int itemNumber = scanner.nextInt();
                            order.addItem(itemsList.get(itemNumber - 1));
                        }

                        // Add the order to the billing system
                        billing.addOrder(order);
                        System.out.println("Order added successfully!");

                        // Display billing information for the specific order
                        double totalRevenue = billing.calculateTotalRevenue();
                        double totalRevenueWithGSTAndDiscount = billing.calculateTotalRevenueWithGSTAndDiscount();
                        System.out.printf(
                                "Billing information for the current order:\n price: $%.2f\nTotal price with GST and Discount: $%.2f\n",
                                totalRevenue, totalRevenueWithGSTAndDiscount);
                        break;

                    case 3:
                        // Exiting the program
                        System.out.println("Exiting the program...");
                        break;
                }
            } while (choice != 3);

        }
    }
}