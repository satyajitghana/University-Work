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
public class PieceWorkEmployee extends Employee {

    Integer piecesProduced;
    Float pricePerPiece;

    public PieceWorkEmployee() {
    }

    public PieceWorkEmployee(Integer piecesProduced, Float pricePerPiece, String firstName, String lastName, String aadharNumber) {
        super(firstName, lastName, aadharNumber);
        this.piecesProduced = piecesProduced;
        this.pricePerPiece = pricePerPiece;
    }

    @Override
    public Float getSalary() {
        return piecesProduced * pricePerPiece;
    }
    
    @Override
    public void getInput() {
        super.getInput();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Pieces Produced : ");
        piecesProduced = input.nextInt();
        System.out.print("Enter Price Per Piece : ");
        pricePerPiece = input.nextFloat();
    }
    
}
