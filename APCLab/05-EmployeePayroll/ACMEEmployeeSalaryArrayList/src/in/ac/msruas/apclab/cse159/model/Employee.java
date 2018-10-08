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
public abstract class Employee implements Comparable<Employee> {

    private String firstName;
    private String lastName;
    private String aadharNumber;

    public Employee() {
    }
    
    public Employee(String firstName, String lastName, String aadharNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.aadharNumber = aadharNumber;
    }

    @Override
    public int compareTo(Employee o) {
        return (int) (this.getSalary() - o.getSalary());
    }
    
    public abstract Float getSalary();

    public void getInput() {
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\n");
        System.out.print("Enter First Name : ");
        this.firstName = input.nextLine();
        System.out.print("Enter Last Name : ");
        this.lastName = input.nextLine();
        System.out.print("Enter Aadhar Number : ");
        this.aadharNumber = input.nextLine();
    }

    @Override
    public String toString() {
        return "\nEmployee :: " + "First Name : " + firstName + ", Last Name : " + lastName + ", Aadhar Number : " + aadharNumber + ", Salary : " + getSalary();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

}
