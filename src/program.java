/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author egozc
 */
public class program {
    static Scanner SC = new Scanner(System.in);
    private static List<customer> clients=new ArrayList<>();;
    private static int index = -1;
    private static String resp;
    
    public static void main(String[] args) {
        do{
            System.out.println("[C]reate Customer   [D]elete Customer  Dis[p]lay  [S]ervices  [Q]uit:");
            resp=SC.nextLine();
            switch(resp){
                case "C":
                    customer c=new customer();
                    clients.add(c);
                    System.out.println("The record has been created for "+c.getName());
                    break;
                case "D":
                    System.out.println("Please enter the Social Security Number: ");
                    index=confirmarSsn(SC.nextInt(),clients);
                    if (index<0){
                        System.out.println("Incorrect Social Security Number:");
                    }else{
                        clients.get(index).closeAll();
                        System.out.println("The record for "+clients.get(index).getName()+ "has been deleted");
                        clients.remove(index);
                    }
                    break;
                case "P":
                    for (int i = 0; i < clients.size(); i++) {
                        clients.get(i).display();
                    }
                    break;
                case "S":
                    System.out.println("Please enter the Social Security Number: ");
                    int ssn=SC.nextInt();
                    index=confirmarSsn(ssn,clients);
                    if (index<0){
                        System.out.println("Incorrect Social Security Number:");
                    }else{
                        customerMenu(ssn,clients.get(index));
                    }
            }
            
        }while(!"Q".equals(resp));
    }
    public static void transferMenu(int pin,customer client){
        if ((client.getPin()==pin) & client.hasChkAcc() & client.hasSvAcc()){
            String r;
            do{
                System.out.println("[C]hecking to Saving [S]aving to Checking [R]eturn");
                r=SC.nextLine();
                switch(r){
                    case "C":
                        client.ChToSv();
                        break;
                    case "S":
                        client.SvToCh();
                        break;               
                }        
            }while(!"R".equals(r));   
        }
    }
    
    
    
    public static void checkingMenu(int pin,customer client){
        if (client.getPin()==pin){
            checking cuenta;
            String r;
            do{
                System.out.println("[0]pen C[L]ose [I]nq [D]ep [W]ithdraw OrderC[H]k [R]eturn");
                r=SC.nextLine();
                cuenta=client.getChAcc();
                switch(r){
                    case "O":
                        cuenta.open();
                        break;
                    case "L":
                        cuenta.close();
                        break;
                    case "I":
                        cuenta.show();
                        break;
                    case "D":
                        System.out.println("Introduce the amount of cash:");
                        cuenta.deposit(SC.nextDouble());
                        System.out.println("Account now with balance: "+String.valueOf(cuenta.getBalance()));
                        break;
                    case "W":
                        cuenta.withdraw(SC.nextDouble());
                        break;
                    case "H":
                        break;
                        
                }
            }while(!"R".equals(r));
        }else{
            System.out.println("Incorrect PIN");
        }
        
    }
    public static void savingMenu(int pin,customer client){
        if (client.getPin()==pin){
            savings cuenta;
            String r;
            do{
                System.out.println("[0]pen C[L]ose [I]nq [R]eturn");
                r=SC.nextLine();
                cuenta=client.getSvAcc();
                switch(r){
                    case "O":
                        cuenta.open();
                        break;
                    case "L":
                        cuenta.close();
                        break;
                    case "I":
                        cuenta.show();
                        break;
                }         
            }while(!"R".equals(r));              
        }else{
            System.out.println("Incorrect PIN");
        }        
    }
    public static void customerMenu(int ssn,customer client){
        if (client.getSsn()==ssn){
            String r;
            do{
                System.out.println("[C]hecking [S]aving S[E]t PIN S[H]ow Accounts [T]ransfer [R]eturn");
                r=SC.nextLine();
                switch(r){
                    case "C":
                        System.out.println("Enter PIN:");
                        checkingMenu(SC.nextInt(),client);
                        break;
                    case "S":
                        System.out.println("Enter PIN:");
                        savingMenu(SC.nextInt(),client);
                        break;
                    case "E":
                        System.out.println("Enter PIN:");
                        client.setPin();
                        break;
                    case "H":
                        client.show();
                    case "T":
                        System.out.println("Enter PIN:");
                        transferMenu(SC.nextInt(),client);
                }
            }while(!"R".equals(r));
        }else{
            System.out.println("Incorrect Social Security Number");
        }      
    }
    public static int confirmarSsn(int ssn, List<customer> lista){
        int x = -1;
        for (int i = 0; i < lista.size(); i++) {
            if (ssn == lista.get(i).getSsn()) {
                x = i;
            }
        }
        return x;
    }
    public static void setInterest(){
        System.out.println("Introduce the interest rate:");
        savings.setRate(SC.nextDouble());
    }
}
