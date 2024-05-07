import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] s) {
        System.out.println("====ЛАБОРАТОРНАЯ РАБОТА №5====");
        boolean end = false;
        while (!end) {
            System.out.println("=========================МЕНЮ=========================");
            System.out.println("1. Параллельные запись/чтение массива (Задание 1)");
            System.out.println("2. Последовательные запись/чтение массива (Задание 2)");
            System.out.println("3. Последовательные запись/чтение массива (Задание 3)");
            System.out.println("0. Выход из программы");
            System.out.print("Выберете пункт меню: ");
            Int obj;
            // Из-за пользования одним и тем же потоком ввода (System.in), остаётся что-то
            // на что реагирует .nextLine(). Этот код помогает избежать проблемы
            try {
                while (!scan.hasNext()) {
                    Thread.sleep(200);
                }
            } catch (InterruptedException ignored) { }
            String choice = scan.nextLine();
            switch (choice) {
                case "1":
                    obj = CreateEssays();
                    System.out.println("====УСПЕШНО====\n");
                    Thread readThread = new ReadThread(obj);
                    Thread writeThread = new WriteThread(obj);
                    writeThread.start();
                    readThread.start();
                    try {
                        readThread.join();
                    } catch (InterruptedException ignored) {
                    }
                    try {
                        writeThread.join();
                    } catch (InterruptedException ignored) {
                    }
                    break;
                case "2":
                    obj = CreateEssays();
                    System.out.println("====УСПЕШНО====\n");
                    IntSynchronizer intSynchronizer = new IntSynchronizer(obj);
                    Thread read = new Thread(new ReadSyncThread(intSynchronizer));
                    Thread write = new Thread(new WriteSyncThread(intSynchronizer));
                    read.start();
                    write.start();
                    try {
                        read.join();
                    } catch (InterruptedException ignored) {}
                    try {
                        write.join();
                    } catch (InterruptedException ignored) {}
                    break;
                case "3":
                    obj = CreateEssays();
                    System.out.println("====УСПЕШНО====\n");
                    SynchronizedInt synchronizedInt = IOMethods.synchronizedInt(obj);
                    Thread thread1 = new ReadThread(synchronizedInt);
                    thread1.setName("ReadThread");
                    Thread thread2 = new WriteThread(synchronizedInt);
                    thread2.setName("WriteThread");

                    Thread checkThread1 = new CheckThread(thread1);
                    Thread checkThread2 = new CheckThread(thread2);

                    thread1.start();
                    thread2.start();

                    checkThread1.start();
                    checkThread2.start();

                    try {
                        thread2.join();
                    } catch (InterruptedException ignored) {}
                    try {
                        thread1.join();
                    } catch (InterruptedException ignored) {}
                    try {
                        checkThread1.join();
                    } catch (InterruptedException ignored) {}
                    try {
                        checkThread2.join();
                    } catch (InterruptedException ignored) {}
                    break;
                case "0":
                    System.out.println("\n====ЗАВЕРШЕНИЕ РАБОТЫ====");
                    end = true;
                    break;
                default:
                    System.out.println("\n====ОШИБКА====");
                    System.out.println("Введено неправильное значение!\n");
                    System.out.println(choice);
                    break;
            }

        }
    }

    private static void PrintOutArray(Int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("====ЭЛЕМЕНТ #" + (i + 1) + "====");
            System.out.println(array[i].toString());
        }
    }


    private static Int CreateEssays() {
        System.out.println("\n====СОЗДАНИЕ ОБЪЕКТА====");
        System.out.print("Введите длину массива: ");
        int length = scan.nextInt();
        return new Essays(length);
    }


}
