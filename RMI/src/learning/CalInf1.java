package learning;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalInf1 extends Remote
{
    public int add(int a,int b) throws RemoteException;
}
