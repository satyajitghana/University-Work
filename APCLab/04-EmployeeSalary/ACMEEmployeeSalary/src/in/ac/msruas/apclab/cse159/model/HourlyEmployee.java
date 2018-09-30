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
public class HourlyEmployee extends Employee {

    Float manHours;
    Float wagePerHour;

    public HourlyEmployee() {
    }

    public HourlyEmployee(Float manHours, Float wagePerHour, String firstName, String lastName, String aadharNumber) {
        super(firstName, lastName, aadharNumber);
        this.manHours = manHours;
        this.wagePerHour = wagePerHour;
    }
    
    @Override
    public Float getSalary() {
        if (manHours >= 40)
            return wagePerHour * (40 + (manHours - 40)*1.5f);
        return manHours * wagePerHour;
    }
    
    @Override
    public void getInput() {
        super.getInput();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Man Hours : ");
        manHours = input.nextFloat();
        System.out.print("Enter Wage Per Hour : ");
        wagePerHour = input.nextFloat();
    }
    
}
