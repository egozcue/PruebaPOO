/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo2;

import java.util.List;
import java.util.Scanner;

import static javax.swing.text.html.HTML.Tag.S;
/**
 *
 * @author egozc
 */
public class program2 {
    private static List<client2>clients;
    private static int index;
    
    public static void menu(){
        System.out.println("[C]reate Customer [D]elete Customer Dis[p]lay [S]ervices [Q]uit");
    }
    
    public static void election(){
        String choose;
        do{
        menu();
        Scanner sc=new Scanner(System.in);
        System.out.println("Choose an option: ");
        choose=sc.nextLine();
        switch(choose){
            case "C":
                do{
                    int ssn = sc.nextInt();
                    confirmSsn(clients,ssn);
                }
                while(confirmSsn(clients,ssn)<)

                new client2(ssn);
                
                break;
            case "D":
                delete();
                break;
            case "p":
                display();
                break;
            case "s":
                services();
                index=confirmarSsn(clients,ssn);
                }while (index>0);
                break;
            case "q":
                break;
        }
        }
    
        while (!("q".equals(choose)));
                    
        
                
                
        }
    public static int confirmSsn(List<client2> lista,int ssn){
        int x=-1;
        for (int i=0; i<lista.size(); i++){
            if(lista.get(i).getssn()==ssn){
                x=i;
            }
        }
        return x;
    }
        
    
    public static void main(String[] args) {
        election();
    }
   
}
