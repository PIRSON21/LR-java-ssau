import java.util.Random;

public class WriteSyncThread implements Runnable {

    private volatile IntSynchronizer obj;
    private Thread cur;

    public WriteSyncThread(IntSynchronizer p) {
        obj = p;
        cur = Thread.currentThread();
    }

    @Override
    public void run() {
        Random rand = new Random();
        while (obj.canWrite()) try {
            obj.write(rand.nextInt(1, 10));
        } catch (InterruptedException ignored) { }
        cur.interrupt();
    }
}
