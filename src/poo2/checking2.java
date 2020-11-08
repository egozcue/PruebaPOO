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
import static poo2.client2.comprobarSsn;
import static poo2.client2.map;
import static poo2.client2.getStatus;
        
/**
 *
 * @author 
 */
public class checking2 {
    private static double balance;
    private static int pin;
    private static boolean status;
    static Scanner SC = new Scanner(System.in);
    static HashMap <String, Double> mapPin = new HashMap <String, Double> ();

    /**
     *
     * @param balance
     * @param number
     * @param status
     */
    public checking2(double balance, int pin, boolean status) {
        checking2.balance = balance;
        checking2.pin = pin;
        checking2.status = status;
    }
    
  

    /**
     *Random rand = new Random();
        number=(int)(Math.random() * (99999 - 10000 + 1) + 10000);
    
     */
    
    
    public static void menuServ(){
        String choose;
        do{
            System.out.println("[O]pen C[L]ose [I]nq [D]ep [W]ithdraw [R]eturn");
            choose=SC.nextLine();
            int ssn;
            switch (choose){
                case "O":
                    System.out.println("Your ssn: ");
                    ssn=SC.nextInt();
                    if (comprobarSsn(ssn)){
                        open(ssn);
                    }
                    else{
                        System.out.println("The ssn "+ssn+ " is not in our database\n");
                        System.out.println("First create a customer with that ssn");
                    }
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
        }while("R".equals(choose));
    }

    public double getBalance(){
    return balance;
}
    public static void open(int ssn){
        client2 data=(client2) map.get(String.valueOf(ssn));
        status= data.getStatus();
        if (!status){
            System.out.println("Choose your pin: ");
            int pin=SC.nextInt();
            System.out.println("Initial Deposit:");
            balance=SC.nextDouble();
            System.out.println("The checking account had been opened");
            status=true;
            mapPin.put(String.valueOf(pin), balance);
        }
        else{
            System.out.println("An account is already opened");
        }   
    }
    public static void close(){
        System.out.println("Your pin: ");
        String pin=SC.nextLine();
        if (mapPin.containsKey(pin)){
            System.out.println("The account has been closed");
            mapPin.remove(pin);
        }
        else{
            System.out.println("There´s no account with that pin ih our database");
        }
        
    }
    public static void inquire(){
        System.out.println("-------------------");
        System.out.println("Checking Account Number: "+String.valueOf(number));
        System.out.println("Current Balance: "+String.valueOf(balance));
        System.out.println("-------------------");
    }
    public static void withdraw(double cash){
            if (cash<balance){
                balance=balance-cash;
            }
            else{
                System.out.println("The cash exceeds the balance");
            }
    }
    public static void deposit(double cash){
        balance=balance+cash;
        System.out.println("Balance: "+String.valueOf(balance));
    }

}
        
