import java.util.Random;
public class WriteThread extends Thread {

    private final Int object;
    private final Random rand = new Random();


    public WriteThread(Int _obj) {
        if (_obj != null) {
            object = _obj;
        }
        else throw new IllegalArgumentException();
    }

    @Override
    public void run() {
        for (int i = 0; i < object.getLen(); i++) {
            int l = rand.nextInt(100);
            object.setElement(i, l);
            System.out.printf("Write: " + l + " to position " + i + "\n");
        }
    }

    @Override
    public void start() {
        System.out.println(getClass().getName() + " started");
        super.start();
    }

    // TODO: 29.02.2024 11:33 написал классы для первого задания
    //  нет в мейне использования, плюс ругаются методы, потому что я удалил array из main


}
