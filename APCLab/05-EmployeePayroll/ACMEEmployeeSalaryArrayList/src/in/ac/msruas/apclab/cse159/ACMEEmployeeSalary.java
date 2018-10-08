/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ac.msruas.apclab.cse159;

import in.ac.msruas.apclab.cse159.model.BasePlusCommissionEmployee;
import in.ac.msruas.apclab.cse159.model.CommissionEmployee;
import in.ac.msruas.apclab.cse159.model.Employee;
import in.ac.msruas.apclab.cse159.model.HourlyEmployee;
import in.ac.msruas.apclab.cse159.model.PieceWorkEmployee;
import in.ac.msruas.apclab.cse159.model.SalariedEmployee;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author shadowleaf
 */
public class ACMEEmployeeSalary {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Employee> employees = new ArrayList<>();
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Integer choice;
        String mainMenu
                = "------------------------- ACME Employee --------------------------------\n"
                + "1.\tAdd Employee to the List\n"
                + "2.\tCalculate Salary for Employees\n"
                + "3.\tExit"
                + "\n\nYour Choice : ";
        String menu
                = "Select the type of employee : \n"
                + "1.\tCommission Employee\n"
                + "2.\tBase Plus Employee\n"
                + "3.\tSalaried Employee\n"
                + "4.\tHourly Employee\n"
                + "5.\tPiece Work Emlpoyee\n"
                + "6.\tExit"
                + "\n\tYour Choice : ";
        System.out.print(mainMenu);
        choice = input.nextInt();
        switch (choice) {
            case 1: {
                System.out.print(menu);
                choice = input.nextInt();
                Employee employee = null;
                switch (choice) {
                    case 1:
                        employee = new CommissionEmployee();
                        break;
                    case 2:
                        employee = new BasePlusCommissionEmployee();
                        break;
                    case 3:
                        employee = new SalariedEmployee();
                        break;
                    case 4:
                        employee = new HourlyEmployee();
                        break;
                    case 5:
                        employee = new PieceWorkEmployee();
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("Wrong Choice !");
                        break;
                }
                if (employee != null) {
                    employee.getInput();
                    employees.add(employee);
                    System.out.println(employee.toString());
                    System.out.println("Employee Added to the list");
                }
            }
            break;
            case 2: {
                Collections.sort(employees);
                System.out.println(employees);
                System.out.println();
            } break;
            case 3: {
                System.exit(0);
            }
            default:
                System.out.println("Wrong Choice !");
                break;
        }
        /* Infinite Recursion */
        main(args);
    }

}
