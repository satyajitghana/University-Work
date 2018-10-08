/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ac.msruas.apclab.cse159.model;

import java.util.Scanner;

/**
 *
 * @author shadowleaf
 */
public class SalariedEmployee extends Employee{

    Float salary;

    public SalariedEmployee() {
    }

    public SalariedEmployee(Float salary, String firstName, String lastName, String aadharNumber) {
        super(firstName, lastName, aadharNumber);
        this.salary = salary;
    }

    @Override
    public Float getSalary() {
        return salary;
    }
    
    @Override
    public void getInput() {
        super.getInput();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Salary : ");
        salary = input.nextFloat();
    }
    
}
