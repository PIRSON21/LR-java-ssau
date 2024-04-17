public class ReadSyncThread implements Runnable {

    private volatile IntSynchronizer obj;
    private Thread cur;

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
