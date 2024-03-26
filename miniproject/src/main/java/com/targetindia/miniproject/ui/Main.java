package com.targetindia.miniproject.ui;

import com.targetindia.miniproject.dao.DaoException;
import com.targetindia.miniproject.model.Customer;
import com.targetindia.miniproject.service.CustomerManager;
import com.targetindia.miniproject.service.ServiceException;
import com.targetindia.miniproject.utils.KeyBoardUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.InputMismatchException;

@Slf4j
public class Main {

    // this has a dependency on the CustomerManager
    CustomerManager cm;

    public Main()  {
        try {
            cm = new CustomerManager();
        } catch (ServiceException e) {
            log.warn("error while creating CustomerManager", e);
            System.out.println("Sorry. There wan an error. Please check logs.");
            System.exit(1);
        }
    }


    int menu(){
        System.out.println("==== Main Menu ====");
        System.out.println("0. Exit");
        System.out.println("1. List all customers");
        System.out.println("2. Add a new customer");
        System.out.println("3. Search customer by id");
        System.out.println("4. Search customer by email");
        System.out.println("5. Search customer by phone");
        System.out.println("6. Search customers by city");
        try {
            return KeyBoardUtil.getInt("Enter your choice: ");
        }
        catch(InputMismatchException e){
            log.warn("There wan error while accepting the menu choice", e);
            return -1;
        }
    }

    void start(){
        int choice;

        while((choice=menu())!=0){
            log.trace("user made a choice {}", choice);

            switch (choice){
                case 1:
                    displayCustomerList();
                    break;
                case 2:
                    addNewCustomerData();
                    break;
                case 3:
                    searchByCustomerId();
                    break;
                case 4:
                    searchByCustomerEmail();
                    break;
                case 5:
                    searchByCustomerPhone();
                    break;
                case 6:
                    searchByCustomerCity();
                    break;
                default:
                    System.out.println("Invalid choice. Please retry.");
            }
        }
    }
    void searchByCustomerCity() {
        var ci = KeyBoardUtil.getString("Enter the city of the customer : ");
        try{
            var customers = cm.getAll();
            for( var cus : customers){
                if(cus.getCity().equalsIgnoreCase(ci)){
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.printf("%4s|%-20s|%-15s|%-25s|%-15s\n", "ID", "Name", "City", "Email", "Phone");
                    System.out.println("----|--------------------|---------------|-------------------------|--------------");
                    System.out.printf("%4d|%-20s|%-15s|%-25s|%-15s\n",
                            cus.getId(),
                            cus.getName(),
                            cus.getCity(),
                            cus.getEmail(),
                            cus.getPhone());
                    System.out.println("-----------------------------------------------------------------------------------");
                    return;
                }
            }
            System.out.println("Invalid City! Please re-enter it");

        }catch (Exception e){

        }
    }
    void searchByCustomerPhone() {
        var ph = KeyBoardUtil.getString("Enter the phone number of the customer : ");
        try{
            var customers = cm.getAll();
            for( var cus : customers){
                if(cus.getPhone().equalsIgnoreCase(ph)){
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.printf("%4s|%-20s|%-15s|%-25s|%-15s\n", "ID", "Name", "City", "Email", "Phone");
                    System.out.println("----|--------------------|---------------|-------------------------|--------------");
                    System.out.printf("%4d|%-20s|%-15s|%-25s|%-15s\n",
                            cus.getId(),
                            cus.getName(),
                            cus.getCity(),
                            cus.getEmail(),
                            cus.getPhone());
                    System.out.println("-----------------------------------------------------------------------------------");
                    return;
                }
            }
            System.out.println("Invalid Phone number");
        }catch (Exception e){
            System.out.println("Error in the opening the file");
            System.out.println(e);
        }
    }
    void searchByCustomerEmail() {
        var em = KeyBoardUtil.getString("Enter the email of the customer : ");
        try{
            var customers = cm.getAll();
            for( var cus : customers){
                if(cus.getEmail().equalsIgnoreCase(em)){
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.printf("%4s|%-20s|%-15s|%-25s|%-15s\n", "ID", "Name", "City", "Email", "Phone");
                    System.out.println("----|--------------------|---------------|-------------------------|--------------");
                    System.out.printf("%4d|%-20s|%-15s|%-25s|%-15s\n",
                            cus.getId(),
                            cus.getName(),
                            cus.getCity(),
                            cus.getEmail(),
                            cus.getPhone());
                    System.out.println("-----------------------------------------------------------------------------------");
                    return;
                }

            }
            System.out.println("Invalid email adress");
        }catch (Exception e){
            System.out.println("Error in the opening the file");
            System.out.println(e);
        }
    }

    void searchByCustomerId() {
        var c = KeyBoardUtil.getInt("Enter the id: ");

        try {
            var customers = cm.getAll();
            for( var cus : customers){
                if(cus.getId() == c){
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.printf("%4s|%-20s|%-15s|%-25s|%-15s\n", "ID", "Name", "City", "Email", "Phone");
                    System.out.println("----|--------------------|---------------|-------------------------|--------------");
                    System.out.printf("%4d|%-20s|%-15s|%-25s|%-15s\n",
                            cus.getId(),
                            cus.getName(),
                            cus.getCity(),
                            cus.getEmail(),
                            cus.getPhone());
                    System.out.println("-----------------------------------------------------------------------------------");
                    return;
                }
            }
            System.out.println("Invalid ID");
        }catch (Exception e){
            System.out.println("Error in the opening the file");
            System.out.println(e);
        }
    }

    void searchAndDisplayCustomer() {
        System.out.println("searching for customer..");
    }

    void addNewCustomerData() {
        try{
            System.out.println("Enter new customer details: ");
            // accept data from the user: name, city, email, phone
            String name = KeyBoardUtil.getString("Name  : ");
            String city = KeyBoardUtil.getString("City  : ");
            String email = KeyBoardUtil.getString("Email : ");
            String phone = KeyBoardUtil.getString("Phone : ");

            // create customer object
            Customer customer = new Customer(0, name, city, email, phone);

            // call the service method to add new customer
            customer = cm.addNewCustomer(customer);
            System.out.println("New customer added successfully with id: " + customer.getId());
        }
        catch(ServiceException e){
            // show errors to user in a user-friendly manner
            log.warn("error while adding new user in the UI", e);
            System.out.println("Something went wrong. Please check logs.");
        }
    }

    void displayCustomerList() {
        try {
            var customers = cm.getAll();
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.printf("%4s|%-20s|%-15s|%-25s|%-15s\n", "ID", "Name", "City", "Email", "Phone");
            System.out.println("----|--------------------|---------------|-------------------------|--------------");
            for(var c: customers){
                System.out.printf("%4d|%-20s|%-15s|%-25s|%-15s\n",
                        c.getId(),
                        c.getName(),
                        c.getCity(),
                        c.getEmail(),
                        c.getPhone());
            }
            System.out.println("-----------------------------------------------------------------------------------");


        } catch (ServiceException e) {
            System.out.println("Something went wrong. Check the logs or contact tech support");
            log.warn("there was an error while calling cm.getAll()", e);
        }
    }

    public static void main(String[] args) {
        log.trace("starting the app...");
        new Main().start();
        log.trace("ending the app.");
    }

}