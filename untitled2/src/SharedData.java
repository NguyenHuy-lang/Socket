class SharedData {
    int data;
    public  void produce(int value) {
        data = value; //
        System.out.println("produce: " + value);
    }
    public  void consume() {
        data += 0;
        System.out.println("consume: " + data);
    }
}