import java.util.Random;

public class IntSynchronizer {
    private final Int object;
    private final Random rand = new Random();

    public IntSynchronizer(Int _obj) {
        object = _obj;
    }

    public void Write() throws InterruptedException {
        System.out.println("Write method started");
        for (int i = 0; i < object.getLen(); i++) {

            synchronized (object) {
                object.wait();
                int l = rand.nextInt(100);
                object.setElement(i, l);
                System.out.printf("Write: " + l + " to position " + i + "\n");
                object.notify();
            }

        }
    }

    public void Read() throws InterruptedException {
        System.out.println("Read method started");
        for (int i = 0; i < object.getLen(); i++) {
            synchronized (object) {
                object.wait();
                System.out.printf("Read: " + object.getElement(i) + " from position " + i + "\n");
                object.notify();
            }

        }
    }
}
