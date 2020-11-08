/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo3;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author egozc
 */
//LA SUPPERCLASE ACCOUNT
public abstract class account {
    static Scanner SC = new Scanner(System.in);
    //Variables que comparten las subclases
    protected double balance;
    protected boolean status;
    protected int number;
    //CONSTRUCTOR
    public account(){
        this.balance=0.0;
        this.status=false;
        this.number=0;
    }
    //METODOS ABSTRACTOS QUE SON COMUNES EN LAS DOS SUBCLASES PERO DISTINTO COMPORTAMIENTO
    abstract void open();
    abstract void show();
    abstract void close();
    double getBalance(){return balance;}
    int getNumber(){return number;}
    boolean getStatus(){return status;}
    public void deposit(double a){balance+=a;}
    public double withdraw(double a){
        if (a>balance){
            System.out.println("The amount exceeds the balance");
            return 0.0;
        }
        else{
            balance-=a;
            return a;
        }
    }
}
//Subclase checking, cuenta corriente
class checking extends account{
    private int nbrChecks;
    //mandamos al constructor de la superclase con super()
    public checking(){
        super();
        nbrChecks=5;
    }
    
    @Override
    public void open(){
        if (!this.status){
            Random rand = new Random();
            this.number=(int)(Math.random() * (49999 - 10000 + 1) + 10000);
            status=true;
            System.out.println("Initial Deposit:");
            balance=+SC.nextDouble();
        }
        else{
            System.out.println("The checking account is already opened");
        }
    }
    @Override
    public void show(){
        System.out.println("Checking Account Number: "+String.valueOf(this.number));
        System.out.println("Current Balance: "+String.valueOf(this.balance));
        System.out.println("Number of checks: "+String.valueOf(nbrChecks));
    }
    @Override
    public void close(){
        status=false;
        System.out.println("The checking account has been closed with balance: "+String.valueOf(balance)+" €");
        balance=0.0;
    }
    //metodos de los cheques
    public void writeChk(){
        if (nbrChecks>0){
            System.out.println("Write Check:");
            withdraw(SC.nextDouble());
            this.nbrChecks-=1;
            System.out.println("Number of checks:"+String.valueOf(nbrChecks));
        }else{
            System.out.println("No checks left please order new checks");
        }
    }
    public void orderChecks(){
        if (nbrChecks==5){
            System.out.println("You already have the max number of checks");
        }else{
            nbrChecks=5;
            System.out.println("You have now 5 checks");
            
        }
    }
}
//subclase saving
class savings extends account{
    public static double interestRate;
    private double matureBalance;
    public savings(){
        super();
    }
    @Override
    public void open(){
        if (!this.status){
            Random rand = new Random();
            this.number=(int)(Math.random() * (99999 - 50000 + 1) + 50000);
            status=true;
            System.out.println("Initial Deposit:");
            this.balance=+SC.nextDouble();
            this.matureBalance=balance*(1+interestRate);
        }
        else{
            System.out.println("The savings account is already opened");
        }
    }
    @Override
    public void show(){
        System.out.println("Saving Account Number"+ String.valueOf(number));
        System.out.println("Balance: "+String.valueOf(this.balance));
        System.out.println("Mature Balance: "+String.valueOf(this.matureBalance));
        System.out.println("Current Interest: "+String.valueOf(interestRate));
    }
    @Override
    public void close(){
        System.out.println("The savings account has been closed with balance: "+String.valueOf(balance)+" €");
        balance=0.0;
        status=false;
    }
    //ESTABLECER EL INTERES DE LA CUENTA DE AHORRO
    public static void setRate(double i){
        savings.interestRate=i;
    }
}
