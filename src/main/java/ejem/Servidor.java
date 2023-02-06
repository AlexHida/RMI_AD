/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejem;

import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class Servidor {
    public static void main(String[] args){
        try {
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1098);
            r.rebind("CalEjem", new RMI());
            JOptionPane.showMessageDialog(null, "Conectado al servidor");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se Conecto al servidor");
        }
    }
}
