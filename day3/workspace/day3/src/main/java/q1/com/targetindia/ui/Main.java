package q1.com.targetindia.ui;

import q1.com.targetindia.exception.*;
import q1.com.targetindia.exception.InputFormatException;
import q1.com.targetindia.models.Operations;
import q1.com.targetindia.utils.KeyboardUtil;
import q1.com.targetindia.exception.InvalidCityException;
import q1.com.targetindia.exception.InvalidIdException;
import q1.com.targetindia.exception.InvalidNumberException;

import java.io.IOException;

//@Slf4j
public class Main {
   public static void main(String[] args) {

        System.out.println("MENU \n1. Add new Customer\n2. View all customers \n3. Search customers by city\n4.Delete a customer details by ID \n5. Search customers by ID and edit/update details\n" +
                "6. Exit");

        int input = KeyboardUtil.getInt("Enter your choice: ");

        while(input != 6) {

            try {
                switch(input) {

                    case 1:
                        Operations.processAddData();
                        break;

                    case 2:
                        Operations.printData();
                        break;

                    case 3:
                        Operations.processSearchData();
                        break;

                    case 4:
                        Operations.processDeleteData();
                        break;

                    case 5:
                        Operations.processUpdateData();
                        break;

                    default:
                        System.out.println("Please enter a valid input or enter \"exit\" to terminate the program.\n");
                        break;
                }
            } catch (InputFormatException |
                     InvalidIdException |
                     InvalidNumberException |
                     InvalidCityException | IOException e) {
                System.out.println("\n" + e.getMessage());
            }
            System.out.println("MENU \n1. Add new Customer\n2. View all customers\n3. Search customers by city\n4. Delete a customer (by ID)\n5. Search customers by ID and edit/update details\n" +
                    "6. Exit");
            input = KeyboardUtil.getInt("Enter your choice: ");
        }
    }
}