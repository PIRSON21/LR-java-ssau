public class WriteSyncThread implements Runnable {

    private volatile IntSynchronizer obj;

    public WriteSyncThread(IntSynchronizer p) {
        obj = p;
        obj.notify();
    }

    @Override
    public void run() {
        System.out.println("Write method started");
        for (int i = 0; i < obj.getLen(); i++) {
            try {
                obj.Write(i);
            } catch (InterruptedException ignored) {
                System.out.println("Ошибка WriteSyncThread");
            }
        }

    }


}
