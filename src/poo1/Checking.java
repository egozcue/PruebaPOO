/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo1;

/**
 *
 * @author egozc
 */
public class Checking {

    private final String nombre;
    private double dinero;
    private int PIN;

    public Checking(String nuevoNombre) 
    {
        nombre = nuevoNombre;
    }

    public int getPIN() 
    {
        return PIN;
    }

    /**
     *
     * @param nuevoPIN
     */
    public void setPIN(int nuevoPIN) 
    {
        PIN = nuevoPIN;
    }
    public String getNombre() 
    {
        return nombre;
    }

    public void setDinero(double nuevoDinero) 
    {
        dinero = nuevoDinero;
    }
    public double getDinero() 
    {
        return dinero;
    }
    public double retirarDinero(double sacar)
    {
            dinero = dinero - sacar;
            return dinero;
    }
    public void meterDinero(double meter){
        dinero = dinero + meter;
    }
    
}
