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
public class BasePlusCommissionEmployee extends CommissionEmployee {
    
    private Float basicSalary;

    public BasePlusCommissionEmployee() {
        
    }
    
    public BasePlusCommissionEmployee(Float basicSalary, Float commissionRate, Float sales, String firstName, String lastName, String aadharNumber) {
        super(commissionRate, sales, firstName, lastName, aadharNumber);
        this.basicSalary = basicSalary;
    }
    
    @Override
    public void getInput() {
        Scanner input = new Scanner(System.in);
        super.getInput();
        System.out.print("Enter basic Salary : ");
        basicSalary = input.nextFloat();
    }
    
    @Override
    public Float getSalary() {
        return super.getSalary() + basicSalary;
    }
    
}
