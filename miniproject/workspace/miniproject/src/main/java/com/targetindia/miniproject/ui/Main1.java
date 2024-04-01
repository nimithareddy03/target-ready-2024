package com.targetindia.miniproject.ui;

import com.targetindia.miniproject.dao.CsvFileCustomerDao;
import com.targetindia.miniproject.dao.DaoException;
import com.targetindia.miniproject.model.Customer;
import com.targetindia.miniproject.service.CustomerManager;
import com.targetindia.miniproject.service.ServiceException;
import com.targetindia.miniproject.utils.KeyBoardUtil;

import lombok.extern.slf4j.Slf4j;
import java.util.InputMismatchException;
import java.util.List;

@Slf4j

public class Main1 {
    Customer cm;
    CsvFileCustomerDao cfd;

    public Main1()  {
        try {
            cfd = new CsvFileCustomerDao();
        } catch (Exception e) {
            log.warn("error while opening the CSV file", e);
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
        System.out.println("6. Search customers by city\n7. Delete customer by id");
        System.out.println("8. Update customer details by id");
        try {
            return KeyBoardUtil.getInt("Enter your choice: ");
        }
        catch(InputMismatchException e){
            log.warn("There wan error while accepting the menu choice", e);
            return -1;
        }
    }
    Customer getDetails() {
        Customer customer = null;
        try {
            System.out.println("Enter new customer details: ");
            // accept data from the user: name, city, email, phone
            String name = KeyBoardUtil.getString("Name  : ");
            String city = KeyBoardUtil.getString("City  : ");
            String email = KeyBoardUtil.getString("Email : ");
            String phone = KeyBoardUtil.getString("Phone : ");

            // create customer object
            customer = new Customer(0, name, city, email, phone);
            return customer;
        }catch (Exception e){
            // show errors to user in a user-friendly manner
            log.warn("Please enter the valid information", e);
            System.out.println("Something went wrong. Please check logs.");
        }
        return customer;
    }
    void print(List<Customer> lt){
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%4s|%-20s|%-15s|%-25s|%-15s\n", "ID", "Name", "City", "Email", "Phone");
        System.out.println("----|--------------------|---------------|-------------------------|--------------");
        for(var c: lt){
            System.out.printf("%4d|%-20s|%-15s|%-25s|%-15s\n",
                    c.getId(),
                    c.getName(),
                    c.getCity(),
                    c.getEmail(),
                    c.getPhone());
        }
        System.out.println("-----------------------------------------------------------------------------------");

    }
    void start(){
        int choice = menu();

        while(choice!=0){
            log.trace("user made a choice {}", choice);
            switch (choice){
                case 1:
                    try {
                       cfd.getAll();
                        //System.out.println(lt);
                        break;
                    } catch (DaoException e) {
                        throw new RuntimeException(e);
                    }
                    //break;
                case 2:
                    try {
                        cm = getDetails();
                        cfd.save(cm);
                        break;
                    } catch (DaoException e) {
                        throw new RuntimeException(e);
                    }
                case 3:
                    try {
                        int id = KeyBoardUtil.getInt("Enter the id of the customer:");
                        cfd.getById(id);
                        break;
                    } catch (DaoException e) {
                        throw new RuntimeException(e);
                    }

                case 4:
                    String em = KeyBoardUtil.getString("Enter the email id of the customer:");
                    try {
                        cfd.getByEmail(em);
                        break;
                    } catch (DaoException e) {
                        throw new RuntimeException(e);
                    }

                case 5:
                    String ph = KeyBoardUtil.getString("Enter the phone number of the customer:");
                    try {
                        cfd.getByPhone(ph);
                        break;
                    } catch (DaoException e) {
                        throw new RuntimeException(e);
                    }
                case 6:
                    String ct = KeyBoardUtil.getString("Enter the city id of the customer:");
                    try {
                        cfd.getByCity(ct);
                        break;
                    } catch (DaoException e) {
                        throw new RuntimeException(e);
                    }
                case 7:
                    int id1 = KeyBoardUtil.getInt("Enter the id of the customer:");
                    try {
                        cfd.deleteById(id1);
                        break;
                    } catch (DaoException e) {
                        throw new RuntimeException(e);
                    }
                case 8:
                    cm = getDetails();
                    try {
                        cfd.update(cm);
                        break;
                    } catch (DaoException e) {
                        throw new RuntimeException(e);
                    }
                default:
                    System.out.println("Invalid choice. Please retry.");
            }
        }
    }
    public static void main(String[] args){
        log.trace("starting the app...");
        new Main1().start();
        log.trace("ending the app.");
    }
}
