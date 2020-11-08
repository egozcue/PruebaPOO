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

    
    static HashMap <String, Object> map = new HashMap <String, Object> ();
    private static String name;
    private static String address;
    private int pin;
    private final int ssn;
    private static boolean status;
    private static int phone;
    Scanner SC = new Scanner(System.in);
    
    //Constructor
    public client2(String name, String address, int ssn, int phone,boolean status) {
        client2.name = name;
        this.address = address;
        this.ssn = ssn;
        this.phone = phone;
        this.status=status;
    }
    
  
    public static boolean comprobarSsn(int ssn){
        if (map.containsKey(String.valueOf(ssn))){
            return false; //The issn is in the hashmap
        }
        else{
            return true; //The ssn is not in the hashmap
        }
    }
    public static void delete(int ssn){
        map.remove(String.valueOf(ssn));
    }

    public static String getName(){
        return name;
    }
     public static boolean getStatus(){
        return status;
    }
    public static String getAddress(){
        return address;
    }
     public static int getPhone(){
        return phone;
     }
     
    public static void display(){
      map.forEach((k,v) -> System.out.println(  "Name: "+ (((client2)v).getName())+ ". Ssn: " + k +". Adress: "+(((client2)v).getAddress())+ ". Phone: " +(((client2)v).getPhone())));
      map.forEach((k,v)->System.out.println("key"+ k + "Value"+ v));
    }
    
    public void show(int ssn) {
        System.out.println("Account of" +getName());
        System.out.println("---------------");
        System.out.println("Current balance: ");
    }
    public int getssn(){
        return ssn;
    }
}
