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
            switch (scan.nextLine()) {
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
                        scan.nextLine();
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
                    // TODO: ДОДЕЛАТЬ 3-Й НОМЕР
                    System.out.println();
                    break;
                case "0":
                    System.out.println("====ЗАВЕРШЕНИЕ РАБОТЫ====");
                    end = true;
                    break;
                default:
                    System.out.println("====ОШИБКА====");
                    System.out.println("Введено не правильное значение!\n");
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
