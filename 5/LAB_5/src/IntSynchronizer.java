import java.util.Random;

public class IntSynchronizer {
    private final Int object;
    private final Random rand = new Random();

    public IntSynchronizer(Int _obj) {
        object = _obj;
    }

    public void Write(int i) throws InterruptedException {
        synchronized (object) {
            object.wait();
            int l = rand.nextInt(100);
            object.setElement(i, l);
            System.out.printf("Write: " + l + " to position " + i + "\n");
            object.notify();
        }
    }

    public int getLen() {
        return object.getLen();
    }

    public void Read(int i) throws InterruptedException {
        synchronized (object) {
            object.wait();
            System.out.printf("Read: " + object.getElement(i) + " from position " + i + "\n");
            object.notify();
        }
    }
}
