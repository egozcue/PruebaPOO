package poo2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author egozc
 */
public class client2 {

    private final String address;
    private static HashMap<String, checking2> chAcc;
    private final String name;
    private int pin;
    private final int ssn;
    private boolean status;
    private final int phone;
    Scanner SC = new Scanner(System.in);
    public client2(int ssn) {
        this.ssn=ssn;
        System.out.println("Address:");
        this.address = SC.nextLine();
        System.out.println("Name:");
        this.name =SC.nextLine();
        this.status = true;
        System.out.println("Telephone:");
        this.phone = SC.nextInt();
    }

    public String getName(){
        return name;
    }
    public i
    public void delete(int ssn) {

    }

    public void hasCheckAcc(int pin) {
        
        
    }

    public void show(int ssn) {
        System.out.println("Account of" +getName());
        System.out.println("---------------");
        System.out.println("Checking account number"+);
    }
    public int getssn(){
        
    }
}
