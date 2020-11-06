/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author egozc
 */
public class client2 {
    private final String address;
    private static Map<Integer, checking2> chAcc;
    private final String name;
    private final int pin;
    private final int ssn;
    private boolean status;
    private final int phone;


    public client2(String address, String name, int pin, int ssn, boolean status, int phone) {
        this.address = address;
        this.chAcc=chAcc;
        this.name = name;
        this.pin = pin;
        this.ssn = ssn;
        this.status = status;
        this.phone = phone;
    }



    public void create(String address, String name, int pin, int ssn, boolean status, int phone){
        
}

public void delete(int ssn){
    
}   

public void hasCheckAcc(int pin){
    
}
public void show(int ssn){
    
}
}
