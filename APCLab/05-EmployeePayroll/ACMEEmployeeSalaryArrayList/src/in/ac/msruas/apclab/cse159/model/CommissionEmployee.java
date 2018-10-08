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
public class CommissionEmployee extends Employee {
    
    private Float commissionRate;
    private Float sales;

    public CommissionEmployee() {
    }
    
    public CommissionEmployee(Float commissionRate, Float sales, String firstName, String lastName, String aadharNumber) {
        super(firstName, lastName, aadharNumber);
        this.commissionRate = commissionRate;
        this.sales = sales;
    }

    public void getInput() {
        super.getInput();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Commission Rate : ");
        this.commissionRate = input.nextFloat();
        System.out.print("Enter Sales : ");
        this.sales = input.nextFloat();
    }

    @Override
    public Float getSalary() {
        return commissionRate/100f * sales;
    }
    
    
    public Float getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Float commissionRate) {
        this.commissionRate = commissionRate;
    }

    public Float getSales() {
        return sales;
    }

    public void setSales(Float sales) {
        this.sales = sales;
    }
    
}
