/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo3;

import java.util.Scanner;

/**
 *
 * @author egozc
 */
public class customer {
    static Scanner SC = new Scanner(System.in);
    private final String address;
    private final int ssn;
    private checking chAcc;
    private savings svAcc;
    private String name;
    private final int tel;
    private int pin;
    
    /**
     *CONSTRUCTOR
     */
    public customer(){
        chAcc = new checking();
        svAcc = new savings();
        System.out.println("Social Security Number: ");
        ssn= SC.nextInt();
        System.out.println("Name: ");
        name=SC.next();
        System.out.println("Adress: ");
        address=SC.next();
        System.out.println("Telephone: ");
        tel=SC.nextInt();
        pin=0;
    }
    
    /**
     *Diferentes metodos para obtener y modificar inf de customer
     */
    public String getName(){return name;}
    public int getSsn(){return ssn;}
    public int getPin(){return pin;}
    public void setPin(){System.out.println("Introduc 4-digit Pin");pin=SC.nextInt();}
    public boolean hasChkAcc(){return chAcc.getStatus();}
    public boolean hasSvAcc(){return svAcc.getStatus();}
    public checking getChAcc(){return chAcc;}
    public savings getSvAcc(){return svAcc;}
    public void closeAll(){
        chAcc.close();
        svAcc.close();
    }
   //OUTPUT DEL CLIENTE Y SUS CUENTAS
    public void display(){
        System.out.println("--------Customer Information--------");
        System.out.println("Social Security Number: "+String.valueOf(ssn));
        System.out.println("Name: "+name);
        System.out.println("Address: "+address);
        System.out.println("Telephone: "+String.valueOf(tel));
        System.out.println("PIN:"+String.valueOf(pin));
    }
    public void show(){
        System.out.println("Accunts for "+name+":");
        System.out.println("-------------------------------");
        chAcc.show();
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        svAcc.show();
        System.out.println("-------------------------------");
    }
    //Transferencias
    public void SvToCh(){
        System.out.println("Saving Balance: "+String.valueOf(svAcc.getBalance())+" € ------> Checking Balance: "+String.valueOf(chAcc.getBalance())+" €");
        System.out.println("Transfer:");
        chAcc.deposit(svAcc.withdraw(SC.nextDouble()));  
        System.out.println("Saving Balance: "+String.valueOf(svAcc.getBalance())+" € ------> Checking Balance: "+String.valueOf(chAcc.getBalance())+" €");
    }
    public void ChToSv(){
        System.out.println("Checking Balance: "+String.valueOf(chAcc.getBalance())+" €------> Saving Balance: "+String.valueOf(svAcc.getBalance())+" €");
        System.out.println("Transfer:");
        svAcc.deposit(chAcc.withdraw(SC.nextDouble()));  
        System.out.println("Checking Balance: "+String.valueOf(chAcc.getBalance())+" €------> Saving Balance: "+String.valueOf(svAcc.getBalance())+" €");
    }
}
