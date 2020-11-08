/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poo2;

import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
        
/**
 *
 * @author 
 */
public class checking2 {
    private double balance;
    private int pin;
    private boolean status;
    private int number;
    static Scanner SC = new Scanner(System.in);

    /**
     *
     * @param balance
     * @param pin
     * @param status
     */
    public checking2() {
        this.balance = 0;
        this.pin = 0;
        this.status = false;
        Random rand = new Random();
        number=(int)(Math.random() * (99999 - 10000 + 1) + 10000);
    }
    
  
    
    
    
    public void menuServ(int ssn,HashMap map){
        String choose;
        do{
            System.out.println("[O]pen C[L]ose [I]nq [D]ep [W]ithdraw [R]eturn");
            choose=SC.nextLine();
            switch (choose){
                case "O":
                    open(ssn);
                    break;
                case "L":
                    close();
                     break;
                case "I":
                    inquire();
                     break;
                case "D":
                    System.out.println("Deposit:");
                    deposit(SC.nextDouble());
                     break;
                case "W":
                    System.out.println("Introduce the amount of cash you want: ");
                    withdraw(SC.nextDouble());
                    break;
                case "R":
                    break;
            }
        }while(!"R".equals(choose));
    }
     public void close(){
         System.out.println("The account has been closed witch cass: "+String.valueOf(balance)+" €");
         status=false;
         balance=0.0;
         number= 0;
    }
    public double getBalance(){
    return balance;
    }
    public int getNumber(){
    return number;
    }
    public boolean getStatus(){
        return status;
    }
        
    public void open(int ssn){ 
        if (!status){
            System.out.println("Initial Deposit:");
            balance=SC.nextDouble();
            System.out.println("The checking account had been opened");
            status=true;
        }
        else{
            System.out.println("An account is already opened");
        }   
    }
       
    public void inquire(){
        System.out.println("-------------------");
        System.out.println("Checking Account Number: "+String.valueOf(number));
        System.out.println("Current Balance: "+String.valueOf(balance));
        System.out.println("-------------------");
    }
    public void withdraw(double cash){
            if (cash<balance){
                balance=balance-cash;
            }
            else{
                System.out.println("The cash exceeds the balance");
            }
    }
    public void deposit(double cash){
        balance=balance+cash;
        System.out.println("Balance: "+String.valueOf(balance));
    }
    
}
