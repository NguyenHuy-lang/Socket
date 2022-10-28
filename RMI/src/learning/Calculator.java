package learning;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class Calculator extends UnicastRemoteObject {
    Calculator()throws RemoteException{
        super();
    }
    public int add(int a, int b) throws RemoteException {
        System.out.println("Client request to calculate");
        return (a+b);
    }
}