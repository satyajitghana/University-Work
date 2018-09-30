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
import java.util.Scanner;

/**
 *
 * @author shadowleaf
 */

public class ACMEEmployeeSalary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        String menu =
                "Select the type of employee : \n"+
                "1.\tCommission Employee\n"+
                "2.\tBase Plus Employee\n"+
                "3.\tSalaried Employee\n"+
                "4.\tHourly Employee\n"+
                "5.\tPiece Work Emlpoyee\n"+
                "6.\tExit"+
                "\n\tYour Choice : ";
        System.out.print(menu);
        Integer choice = input.nextInt();
        Employee employee = null;
        switch(choice) {
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
            System.out.println("Your Salary : " + employee.getSalary()+"\n");
        }
        /* Infinite Recursion */
        main(args);
    }
    
}
