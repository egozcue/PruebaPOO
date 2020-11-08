/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo2;

import java.util.HashMap;
import java.util.Scanner;
/**import static poo2.checking2.menuServ;
import static poo2.client2.comprobarSsn;
import static poo2.client2.map;
import static poo2.client2.delete;
import static poo2.client2.display;
import static poo2.client2.getName;
*/
/**
 *
 * @author 
 */
public class program2 {
    static HashMap <String, client2> map = new HashMap <String, client2> ();
    
    public static void menu(){
        System.out.println("[C]reate Customer [D]elete Customer Dis[P]lay [S]ervices [Q]uit");
    }
    
    public static void election(){
        String choose;
        String nameC;
        do{
        menu();
        Scanner sc=new Scanner(System.in);
        System.out.println("Choose an option: ");
        choose=sc.nextLine();
        switch(choose){
            case "C":
                    System.out.println("Social security number: ");
                    int ssn = sc.nextInt();
                    while (!(comprobarSsn(ssn))){
                        System.out.println("Sorry, this ssn is already in our data base");
                        System.out.println("Use another ssn: ");
                        ssn = sc.nextInt();
                    }
                    
                    System.out.println("Name: ");
                    nameC = sc.next();
                    System.out.println("Phone: ");
                    int phone=sc.nextInt();
                    System.out.println("Adress: ");
                    String address= sc.next();
                    client2 client=new client2(nameC,address,ssn,phone,false);
                    
                    System.out.println("The customer " + nameC+" had been created");
                    map.put(String.valueOf(ssn),client);
                 
                    break;       
            case "D":
                
                System.out.println("Your ssn: ");
                ssn=sc.nextInt();
               
                if (!(comprobarSsn(ssn))){
                    delete(ssn); 
                    System.out.println("The client with ssn "+ssn+ " had been deleted");
                    
                }
                else{
                    System.out.println("There´s no client with that ssn in our database");
                }
                break;
            case "P":
                display();
                break;
            case "S":
                System.out.println("Your ssn: ");
                ssn=sc.nextInt();
                if (!comprobarSsn(ssn)){
                    client2 cliente = map.get(String.valueOf(ssn));
                    cliente.menuClient();
                    
                }
                else{
                    System.out.println("There´s no client with that ssn in our database");
                }
               
                break;  
            case "Q":
                break;
        }
        }
    
        while (!("Q".equals(choose)));
    }

    public static void bye(){
        System.out.println("Thanks for using our banking system!");
    }
    
    public static void main(String[] args) {
        election();
        bye();
    }
    public static boolean comprobarSsn(int ssn){
        return !map.containsKey(String.valueOf(ssn)); //The issn is in the hashmap
        //The ssn is not in the hashmap
    }
    public static void delete(int ssn){
        map.remove(String.valueOf(ssn));
    }
    public static void display(){
      map.forEach((k,v) -> System.
              out.println(  "Name: "+ (((client2)v).getName())+ ". Ssn: " + k +". Adress: "+(((client2)v).getAddress())+ ". Phone: " +(((client2)v).getPhone())));
    }
}
