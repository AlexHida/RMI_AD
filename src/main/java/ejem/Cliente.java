/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejem;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class Cliente {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        try {
            Registry miRegistro = LocateRegistry.getRegistry("localhost", 1098);
            CalEjem c = (CalEjem)Naming.lookup("//localhost/CalEjem");
            
            while (true){
                String menu = JOptionPane.showInputDialog("CALCULADORA RMI \n Seleccione la opción\n 1 a 4 \n"
                + "Ingrese (1)..SUMAR\n"
                + "Ingrese (2)..RESTAR\n"
                + "Ingrese (3)..MULTIPLICAR\n"
                + "Ingrese (4)..DIVIDIR\n"
                + "Clic Boton Cancelar para salir");
                switch(menu){
                    case "1":{
                        int x=Integer.parseInt(JOptionPane.showInputDialog("Sumar ingrese el primer numero para sumar"));
                            int y=Integer.parseInt(JOptionPane.showInputDialog("Sumar ingrese el segundo numero para sumar"));
                        
                        JOptionPane.showInputDialog(null, "La suma es: "+ c.add(x,y));
                        break;
                    }
                    case "2":{
                        int x=Integer.parseInt(JOptionPane.showInputDialog("Restar ingrese el primer numero para restar"));
                        int y=Integer.parseInt(JOptionPane.showInputDialog("Restar ingrese el segundo numero para restar"));
                        
                        JOptionPane.showInputDialog(null, "La resta es:"+ c.sub(x,y));
                        break;
                    }
                    case "3":{
                        int x=Integer.parseInt(JOptionPane.showInputDialog("Multiplicar ingrese el primer numero para multiplicar"));
                        int y=Integer.parseInt(JOptionPane.showInputDialog("Multiplicar ingrese el segundo numero para multiplicar"));
                        
                        JOptionPane.showInputDialog(null, "La multiplicacion es:"+ c.mul(x,y));
                        break;
                    }
                    case "4":{
                        int x=Integer.parseInt(JOptionPane.showInputDialog("Dividir ingrese el primer numero para dividir"));
                        int y=Integer.parseInt(JOptionPane.showInputDialog("Dividir ingrese el segundo numero para dividir"));
                        
                        JOptionPane.showInputDialog(null, "La division es:"+ c.div(x,y));
                        break;
                    }
                }
            }
            
        } catch (Exception e) {
            System.out.println("Servidor no conectado" + e);
        }
    }
}
