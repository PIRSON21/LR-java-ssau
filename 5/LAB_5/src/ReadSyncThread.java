public class ReadSyncThread implements Runnable {

    private volatile IntSynchronizer obj;

    public ReadSyncThread(IntSynchronizer p) {
        obj = p;
    }

    @Override
    public void run() {
        try {
            obj.Read();
        } catch (InterruptedException ignored) {
            System.out.println("Ошибка ReadSyncThread");
        }
    }


}
