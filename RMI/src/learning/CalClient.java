package learning;

import java.rmi.*;
public class CalClient {
    public static void main(String[] args) throws Exception {
        try{
//            System.out.println("Finding Objec");
// tim doi tuong tu xa theo ten dang ky
            CalInf1 cal= (CalInf1) Naming.lookup ("rmi://localhost/cal11");
// trieu goi phuong thuc tu xa
            System.out.println(cal.add(10,20));
        } catch(Exception e) { System.out.println(e); }
    }
}
