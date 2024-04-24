public class ReadSyncThread implements Runnable {

    private final IntSynchronizer obj;
    private final Thread cur;

    public ReadSyncThread(IntSynchronizer p) {
        obj = p;
        cur = Thread.currentThread();
    }

    @Override
    public void run() {
        while (obj.canRead()) {
            try {
                obj.read();
            } catch (InterruptedException ignored) { }
        }
        cur.interrupt();
    }


}
