package YeppoonCabinsMenu;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 12206477
 */
public class Booking {
    private String name;
    private int nights;

    public Booking(String name, int nights) {
        this.name = name;
        this.nights = nights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }
    public double calculateCharge() 
    {
        final double nightCharge = 89.95;
        final double cleaningCharge = 20.00;
        double charge ;
        
         if (nights > 7 & nights <= 14) {
            charge = (((nights*nightCharge)*0.90)+cleaningCharge);
        }
        else if (nights > 14){
                charge = (((nights*nightCharge)*0.85)+cleaningCharge);
                    }
        else
            charge = (nights*nightCharge)+cleaningCharge; 
        
    return charge;
    }
    @Override
    public String toString(){
    return String.format("%-30s%-11d$%5.2f", name, nights, calculateCharge());
    }
}
