public class ReadSyncThread implements Runnable {

    private volatile IntSynchronizer obj;

    public ReadSyncThread(IntSynchronizer p) {
        obj = p;
        obj.notify();
    }

    @Override
    public void run() {
        System.out.println("Read method started");
        for (int i = 0; i < obj.getLen(); i++) {
            try {
                obj.Read(i);
            } catch (InterruptedException ignored) {
                System.out.println("Ошибка ReadSyncThread");
            }
        }
    }


}
