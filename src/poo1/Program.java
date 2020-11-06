/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static javafx.scene.input.KeyCode.S;

/**
 *
 * @author egozc
 */
public class Program {
    private static String opcionMenu;
    private static List<Checking> clientes;
    private static int index = -1;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);
        clientes = new ArrayList<>();
        /**
         * creamos una lista de listas para almacenar los datos de los clientes
         */
        
        do {
            System.out.println("[O]pen Account c[L]ose Account s[H]ow Customers [S]ervices [Q]uit");
            opcionMenu = SC.nextLine();
            switch (opcionMenu) {
                case "O":
                    System.out.println("Introduce name");
                    Checking client = new Checking(SC.nextLine());
                    openAccount(clientes, client);
                    clientes.add(client);
                    break;
                case "L":
                    do {
                        System.out.println("Please enter THE 4-digit PIN");
                        index = confirmarPin(clientes, SC.nextInt());
                    } while (index < 0);
                    System.out.println("The Account has been closed for " + clientes.get(index).getNombre() + " with cash " + String.valueOf(clientes.get(index).getDinero()));
                    break;
                case "H":
                    showCostumer(clientes);
                    break;
                case "S":
                    if (clientes.size() > 0) {
                        int pin;
                        do {
                            System.out.println("4-digit PIN: ");
                            pin = SC.nextInt();
                            index = confirmarPin(clientes, pin);
                        } while (index < 0);
                        servicios(clientes, index);
                    } else {
                        System.out.println("There are no clients");
                    }

                    break;
            }
        } while (!"Q".equals(opcionMenu));
        System.out.println("Thanks for using our bank system");
    }

    /**
     * creamos una función que nos pregunte los datos y los almacene en una
     * lista tipo string que sera lo que nos da el @return
     *
     * @param lista con elementos de tipo checking
     * @param cliente tipo checking para introducir los datos
     * @return
     */
    public static Checking openAccount(List<Checking> lista, Checking cliente) {
        Scanner SC = new Scanner(System.in);
        System.out.println("4-digit PIN");
        cliente.setPIN(SC.nextInt());
        while ((confirmarPin(lista, cliente.getPIN())) > 0) and (S.length(String.valueOf(cliente.getPIN()))==4{
            System.out.println("repeat your 4-digit PIN please:");
            cliente.setPIN(SC.nextInt());
        }
        System.out.println("Initial Deposit:");
        cliente.setDinero(SC.nextDouble());

        return cliente;
    }

    /**
     *
     * @param lista
     * @param pin
     * @return -1 si es incorrecto el pin y el index si esta el pin
     */
    public static int confirmarPin(List<Checking> lista, int pin) {
        int x = -1;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getPIN() == pin) {
                x = i;
            }
        }
        return x;
    }

    /**
     * Intruducimos la lista clientes y nos lee cada cliente
     *
     * @param lista
     */
    public static void showCostumer(List<Checking> lista) {
        if (lista.size() > 0) {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println("Name: " + lista.get(i).getNombre() + "\nPIN: " + String.valueOf(lista.get(i).getPIN()) + "\nBalance: " + String.valueOf(lista.get(i).getDinero()) + " $");
                System.out.println("---------------------------");
            }
        } else {
            System.out.println("There are no clients, as a banker, u suck");
        }
    }

    /**
     * REALIZA LOS SERIVICIOS DE INFORMACIÓN, DEPOSITO Y RETIRAR DINERO
     *
     * @param lista de clientes
     * @param index la localización del cliente en la lista
     */
    public static void servicios(List<Checking> lista, int index) {
        Scanner SC = new Scanner(System.in);
        String respuesta;
        do {
            System.out.println("[I]nquire  [D]eposit  [W]ithdraw  [R]eturn");
            respuesta = SC.nextLine();
            switch (respuesta) {
                case "I":
                    System.out.println(lista.get(index).getNombre() + " balance in your accoun" + String.valueOf(lista.get(index).getDinero()) + " $");
                    break;
                case "D":
                    System.out.println("Deposit:");
                    lista.get(index).meterDinero(SC.nextDouble());
                    break;
                case "W":
                    System.out.println("Withdraw:");
                    double aretirar = SC.nextDouble();
                    while (lista.get(index).retirarDinero(aretirar) < 0) {
                        lista.get(index).meterDinero(aretirar);
                        System.out.println("ERROR:" + String.valueOf(aretirar) + " $ exceeds balance: " + String.valueOf(lista.get(index).getDinero()) + " $");
                        System.out.println("Withdraw:");
                        aretirar = SC.nextDouble();
                    }
                    break;
                default:
                    System.out.println("Introduce only the capital letters");
            }
        } while (!"R".equals(respuesta));

    }

}
