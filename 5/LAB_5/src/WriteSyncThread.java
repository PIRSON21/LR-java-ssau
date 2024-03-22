public class WriteSyncThread implements Runnable {

    private volatile IntSynchronizer obj;

    public WriteSyncThread(IntSynchronizer p) {
        obj = p;
    }

    @Override
    public void run() {
        try {
            obj.Write();
        } catch (InterruptedException ignored) {
            System.out.println("Ошибка WriteSyncThread");
        }
    }


}
