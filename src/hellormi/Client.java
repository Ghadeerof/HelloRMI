/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hellormi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author Ghadeer
 */
public class Client {
    
    public static void main(String[] args){
        try{
            Registry reg = LocateRegistry.getRegistry("localhost",1099);
            
            IHello server = (IHello) reg.lookup("rmi://localhost/service");
            
            System.out.println("Bound to : " + server);
            
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your name");
            
            String name = scan.nextLine();
            String response = server.sayHello(name);
            System.out.println(response);
        }catch(RemoteException  | NotBoundException  e){
            System.out.println(e.getMessage());
        }
    }
}
