import java.util.Random;

public class ReadThread extends Thread {

    private final Int object;


    public ReadThread(Int _obj) {
        if (_obj != null) {
            object = _obj;
        }
        else throw new IllegalArgumentException();
    }
    @Override
    public void run() {
        for (int i = 0; i < object.getLen(); i++) {
            Random rand = new Random();
            System.out.printf("Read: " + object.getElement(i) + " from position " + i + "\n");
        }
    }
    @Override
    public void start() {
        System.out.println(getClass().getName() + " started");
        super.start();
    }


}
