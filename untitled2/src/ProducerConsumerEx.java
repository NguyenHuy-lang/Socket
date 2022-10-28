public class ProducerConsumerEx { 
    public static void main(String[] args) {
        SharedData s = new SharedData();
        new Producer(s);
        new Consumer(s);
    }
}
