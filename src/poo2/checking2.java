/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo2;
//holaalalala
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
        
/**
 *
 * @author egozc
 */
public class checking2 {
    private double balance;
    private final int number;
    private boolean status;
    Scanner SC = new Scanner(System.in);
    
    public checking2(){
        Random rand = new Random();
        number=(int)(Math.random() * (99999 - 10000 + 1) + 10000);
    }

    /**
     *
     * @param resp
     */
    public void menu(String resp){
        do{
            System.out.println("[O]pen C[L]ose [I]nq [D]ep [W]ithdraw [R]eturn");
            switch (resp){
                case "O":
                    open();
                case "L":
                    close();
                case "I":
                    inquire();
                case "D":
                    System.out.println("Deposit:");
                    deposit(SC.nextDouble());
                case "W":
                    System.out.println("Introduce the amount of cash you want: ");
                    withdraw(SC.nextDouble());
            }
        }while("R".equals(resp));
    }
    public void open(){
        if (!status){
            status=true;
            System.out.println("Initial Deposit:");
            balance=SC.nextDouble();
            System.out.println("The checking account has been opened for Jane Doe");
        }
        else{
            System.out.println("The account is already opened");
        }   
    }
    public void close(){
        status=false;
        System.out.println("The account has been closed");
    }
    public void inquire(){
        System.out.println("-------------------");
        System.out.println("Checkimg Account Number: "+String.valueOf(number));
        System.out.println("Current Balance: "+String.valueOf(balance)+" €");
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
        balance=balance+cash
        System.out.println("Balance: "+String.valueOf(balance)+" €");
    }
        
    
}
