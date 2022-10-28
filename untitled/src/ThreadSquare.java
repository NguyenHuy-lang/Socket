import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadSquare extends Thread{
    SharedData sharedData;

    public ThreadSquare(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
//            System.out.println("T2 >> " + i);
            synchronized(sharedData) {
                try {
                    sharedData.notifyAll();
                    sharedData.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadSquare.class.getName()).log(Level.SEVERE, null, ex);
                }
                int rad = sharedData.getRad();
                rad *= rad;
                System.out.println("PT: " + rad);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadRandom.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        System.out.println("T2 Stop");
        //stop
        synchronized(sharedData) {
            sharedData.notifyAll();
        }
    }


}
