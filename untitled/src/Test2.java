
public class Test2 {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        ThreadRandom threadRandom = new ThreadRandom(sharedData);
        ThreadSquare threadSquare = new ThreadSquare(sharedData);

        threadSquare.start();
        threadRandom.start();
    }
}
