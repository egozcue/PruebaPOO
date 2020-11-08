package poo2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class client2 {

    private String name;
    private String address;
    private int pin;
    private final int ssn;
    private boolean status;
    private int phone;
    Scanner SC = new Scanner(System.in);
    static HashMap <String, checking2> mapPin = new HashMap <String, checking2> ();
    
    //Constructor
    public client2(String name, String address, int ssn, int phone,boolean status) {
        this.name = name;
        this.address = address;
        this.ssn = ssn;
        this.phone = phone;
        this.status=status;
    }
    public void menuClient(){
        String choose;
        do{
            System.out.println("[C]hecking S[E]t PIN S[H]ow Accounts [R]eturn:");
            choose=SC.nextLine();
            switch(choose){
                case "C":
                    System.out.println("Enter pin:");
                    int pin=SC.nextInt();
                    if(!comprobarPin(pin)){
                        mapPin.get(String.valueOf(pin)).menuServ(ssn, mapPin);
                    }else{
                        System.out.println("The PIN doesn´t exist");
                    }
                    break;
                case "E":
                    System.out.println("Enter pin:");
                    pin=SC.nextInt();
                    if(comprobarPin(pin)){
                        mapPin.put(String.valueOf(pin), new checking2());
                    }
                    break;
                case "H":
                    mapPin.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v.getBalance()+ ": Number: "+v.getNumber()));     
                    break;
            }
            
        }while(!"R".equals(choose));
    
    }
    

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }
     public int getPhone(){
        return phone;
     }
    
    public void show(int ssn) {
        System.out.println("Account of" +getName());
        System.out.println("---------------");
        System.out.println("Current balance: ");
    }
    public int getssn(){
        return ssn;
    }
    public static boolean comprobarPin(int pin){
        return !mapPin.containsKey(String.valueOf(pin)); 
    }
}
