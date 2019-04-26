/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hellormi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Ghadeer
 */
public class HelloServer extends UnicastRemoteObject implements IHello{

    
    public HelloServer() throws RemoteException{
        super();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Registry reg = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            
            HelloServer obj = new HelloServer();
            reg.rebind("rmi://localhost/service", obj);
            
            System.out.println("Hello Server bound in registry");
        }catch(RemoteException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        return "Hello" + name;
    }
    
}
