import java.io.*;
import java.util.Scanner;

public class Main {

    private static final Scanner scan = new Scanner(System.in);

    public static Int[] array;
    public static void main(String[] s) {
        System.out.println("====ЛАБОРАТОРНАЯ РАБОТА №4====");
        while (array == null) {
            try {
                System.out.println("====СОЗДАНИЕ МАССИВА====");
                System.out.print("Введите размерность массива: ");
                int count = Integer.parseInt(scan.nextLine());
                array = new Int[count];
            } catch (NumberFormatException e) {
                System.out.println("====ОШИБКА====");
                System.out.println("Неверный формат ввода!\n");
            } catch (NegativeArraySizeException e) {
                System.out.println("====ОШИБКА====");
                System.out.println("Размерность не может быть отрицательной\n");
            }
        }
        for (int i = 0; i < array.length;) {
            System.out.println("1. Серия сочинений");
            System.out.println("2. Серия статей");
            System.out.printf("Выберите тип %d-го элемента: ", i);
            String name  = scan.nextLine();
            System.out.println();
            switch (name) {
                case "1":
                    try {
                    System.out.print("Введите название серии: ");
                    name = scan.nextLine();
                    System.out.print("Введите количество сочинений в серии: ");
                    int count = Integer.parseInt(scan.nextLine());
                    System.out.print("Введите, сколько вступительных страниц в серии: ");
                    int introduce = Integer.parseInt(scan.nextLine());

                        array[i] = new Essays(count, name, introduce);
                        i++;
                        System.out.println("====УСПЕШНО====\n");
                    }  catch (NumberFormatException e) {
                        System.out.println("====ОШИБКА====");
                        System.out.println("Неверный формат ввода!\n");
                    }  catch (RuntimeException e) {
                        System.out.println("====ОШИБКА====");
                        System.out.println(e.getMessage() + "\n");
                    }
                    break;
                case "2":
                    try {
                    System.out.print("Введите название серии: ");
                    name = scan.nextLine();
                    System.out.print("Введите количество сочинений в серии: ");
                    int count = Integer.parseInt(scan.nextLine());
                    System.out.print("Введите, сколько вступительных страниц в серии: ");
                    int introduce = Integer.parseInt(scan.nextLine());

                        array[i] = new Articles(count, name, introduce);
                        i++;
                        System.out.println("====УСПЕШНО====\n");
                    } catch (NumberFormatException e) {
                        System.out.println("====ОШИБКА====");
                        System.out.println("Неверный формат ввода!\n");
                    } catch (RuntimeException  e) {
                        System.out.println("====ОШИБКА====");
                        System.out.println(e.getMessage() + "\n");
                    }
                    break;
                default:
                    System.out.println("====ОШИБКА====");
                    System.out.println("Введено не правильное значение!\n");
                    break;
            }
        }
        boolean end = false;
        while (!end) {
            System.out.println("=========================МЕНЮ=========================");
            System.out.println("1. Работа с байтовым потоком");
            System.out.println("2. Работа с текстовым потоком");
            System.out.println("3. Сериализация");
            System.out.println("4. Форматный ввод/вывод");
            System.out.println("5. Вывод массива в консоль");
            System.out.println("0. Выход из программы");
            System.out.print("Выберите пункт меню: ");
            switch (scan.nextLine()) {
                case "1":
                    System.out.println("\n====БАЙТОВЫЙ ПОТОК====");
                    System.out.println("1. Записать массив в байтовый поток");
                    System.out.println("2. Считать массив из байтового потока");
                    System.out.println("0. Назад в меню");
                    System.out.print("Выберите пункт меню: ");
                    String menu = scan.nextLine();
                    if (menu.equals("1")) {
                        try {
                            binaryOutput();
                            System.out.println("====УСПЕШНО====");
                        } catch (IOException e) {
                            System.out.println("====ОШИБКА====");
                            System.out.println("Возникла ошибка.\n" + e.getLocalizedMessage());
                        }
                    } else if (menu.equals("2")) {
                        try {
                            array = binaryInput();
                            System.out.println("====УСПЕШНО====");
                        } catch (IOException e) {
                            System.out.println("====ОШИБКА====");
                            System.out.println("Возникла ошибка.\n" + e.getLocalizedMessage());
                        }
                    } else {
                        System.out.println("====ОШИБКА====");
                        System.out.println("Введено не правильное значение!\n");
                    }
                    break;
                case "2":
                    System.out.println("\n====ТЕКСТОВЫЙ ПОТОК====");
                    System.out.println("1. Записать массив в текстовый поток");
                    System.out.println("2. Считать массив из текстового потока");
                    System.out.println("0. Назад в меню");
                    System.out.print("Выберите пункт меню: ");
                    switch (scan.nextLine()) {
                        case "1":
                            try {
                                textOutput();
                                System.out.println("====УСПЕШНО====");
                            } catch (IOException e) {
                                System.out.println("====ОШИБКА====");
                                System.out.println("Возникла ошибка.\n" + e.getLocalizedMessage());
                            }
                            break;
                        case "2":
                            try {
                                array = textInput();
                                System.out.println("====УСПЕШНО====");
                            } catch (IOException e) {
                                System.out.println("====ОШИБКА====");
                                System.out.println("Возникла ошибка.\n" + e.getLocalizedMessage());
                            }
                            break;
                    }
                    break;
                case "3":
                    System.out.println("\n====СЕРИАЛИЗАЦИЯ====");
                    System.out.println("1. Сериализовать массив");
                    System.out.println("2. Десериализовать массив");
                    System.out.println("0. Назад в меню");
                    System.out.print("Выберите пункт меню: ");
                    switch (scan.nextLine()) {
                        case "1":
                            try {
                                serialize();
                                System.out.println("====УСПЕШНО====");
                            } catch (IOException e) {
                                System.out.println("====ОШИБКА====");
                                System.out.println("Возникла ошибка.\n" + e.getLocalizedMessage());
                            }
                            break;
                        case "2":
                            try {
                                array = deserialize();
                                System.out.println("====УСПЕШНО====");
                            } catch (IOException | ClassNotFoundException e) {
                                System.out.println("====ОШИБКА====");
                                System.out.println("Возникла ошибка.\n" + e.getLocalizedMessage());
                            }
                            break;
                    }
                    break;
                case "4":
                    System.out.println("\n====ФОРМАТНЫЙ ВВОД/ВЫВОД====");
                    System.out.println("1. Форматный вывод в файл");
                    System.out.println("2. Форматный ввод из файла");
                    System.out.println("0. Назад в меню");
                    System.out.print("Выберите пункт меню: ");
                    switch (scan.nextLine()) {
                        case "1":
                            try {
                                writeFormat();
                                System.out.println("====УСПЕШНО====");
                            } catch (Exception e) {
                                System.out.println("====ОШИБКА====");
                                System.out.println("Возникла ошибка.\n" + e.getLocalizedMessage());
                            }
                            break;
                        case "2":
                            try {
                                array = readFormat();
                                System.out.println("====УСПЕШНО====");
                            } catch (Exception e) {
                                System.out.println("====ОШИБКА====");
                                System.out.println("Возникла ошибка.\n" + e.getLocalizedMessage());
                            }
                            break;
                    }
                    break;
                case "5":
                    PrintOutArray(array);
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
    private static Int[] readFormat() throws IOException {

        System.out.println("\n====ФОРМАТНЫЙ ВВОД====");
        File file = CreateNewFile("r", ".txt");
        if (file.exists() && file.canRead()) {
            Scanner in = new Scanner(file);
            Int[] res;
            int arrayLength;
            if (in.hasNextInt()) {
                arrayLength = Integer.parseInt(in.nextLine());
                res = new Int[arrayLength];
                for (int i = 0; i < arrayLength; i++) {
                    res[i] = IOMethods.readFormatInt(in);
                }
                return res;
            }
            in.close();
        }
        throw new IOException();
    }
    private static void writeFormat() throws IOException {
        System.out.println("\n====ФОРМАТНЫЙ ВЫВОД====");
        File file = CreateNewFile("w", ".txt");
        while (!(file.exists() && file.canWrite())) {
            if (file.delete()) {
                if (!file.createNewFile()) {
                    throw new IOException("Ошибка создания файла");
                }
            }
        }
        Writer out = new FileWriter(file);
        out.write(array.length + "\n");
        for (Int el: array) {
            IOMethods.writeFormatInt(el, out);
        }
        try {
            out.close();
        } catch (IOException e) {e.getLocalizedMessage();}
}
    private static Int[] deserialize() throws IOException, ClassNotFoundException {
        System.out.println("\n====ДЕСЕРИАЛИЗАЦИЯ====");
        File file = CreateNewFile("r", ".bin");
        if (file.exists() && file.canRead()) {
            InputStream in = new FileInputStream(file);
            int arrayLength = in.read();
            Int[] res = new Int[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                res[i] = IOMethods.deserializeInt(in);
            }
            try {
                in.close();
            } catch (IOException ignored) {}
            return res;
        }
        else { throw new IOException(); }
    }
    private static void serialize() throws IOException {
        System.out.println("\n====СЕРИАЛИЗАЦИЯ====");
        File file = CreateNewFile("w", ".bin");
        OutputStream out = new FileOutputStream(file);
        out.write(array.length);
        for (Int el: array) {
            IOMethods.serializeInt(el, out);
        }
        try {
            out.close();
        } catch (IOException ignored) {}
    }
    private static void binaryOutput() throws IOException {
        System.out.println("\n====БИНАРНЫЙ ВЫВОД====");
        File file = CreateNewFile("w", ".bin");
        OutputStream out = new FileOutputStream(file);
        out.write(array.length);
        for (Int el: array) {
            IOMethods.outputInt(el, out);
        }
        try {
            out.close();
        } catch (IOException ignored) {}


    }
    private static File CreateNewFile(String way, String type) throws IOException {
        System.out.print("Введите название файла: ");
        String fileName = scan.nextLine();
        File file = new File("./data/" + fileName + type);
        if (way.equals("w")) {
            file.createNewFile();
            while (!(file.exists() && file.canWrite())) {
                if (file.delete()) {
                    if (!file.createNewFile()) {
                        throw new IOException("Ошибка создания файла");
                    }
                }
            }
        }
        else {
            if (file.exists()) {
                while(!file.canRead()) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ignored) {}
                }
            }
            else {
                throw new IOException("Ошибка открытия файла");
            }
        }
        return file;
    }
    private static Int[] binaryInput() throws IOException {
        System.out.println("\n====БИНАРНЫЙ ВВОД====");
        File file = CreateNewFile("r", ".bin");
        if (file.exists() && file.canRead()) {
            InputStream in = new FileInputStream(file);
            int arrayLength = in.read();
            Int[] res = new Int[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                res[i] = IOMethods.inputInt(in);
            }

            try {
                in.close();
            } catch (IOException ignored) {}
            return res;
        }
        else { throw new IOException(); }


    }
    private static Int[] textInput() throws IOException {
        System.out.println("\n====ТЕКСТОВЫЙ ВВОД====");
        File file = CreateNewFile("r", ".txt");
        if (file.exists() && file.canRead()) {
            Reader in = new FileReader(file);
            StreamTokenizer stream = new StreamTokenizer(in);
            stream.nextToken();
            Int[] res;
            int arrayLength;
            if (stream.ttype == StreamTokenizer.TT_NUMBER) {
                arrayLength = (int)stream.nval;
                    res = new Int[arrayLength];
                    for (int i = 0; i < arrayLength; i++) {
                        res[i] = IOMethods.readInt(in);
                        }
                    return res;
            }
            try {
                in.close();
            } catch (IOException e ) {e.getLocalizedMessage();}
        }
        throw new IOException();
    }
    private static void textOutput() throws IOException {
        System.out.println("\n====ТЕКСТОВЫЙ ВЫВОД====");
        File file = CreateNewFile("w", ".txt");
        Writer out = new FileWriter(file);
        out.write(array.length + "\n");
        for (Int el: array) {
            IOMethods.writeInt(el, out);
            out.write("\n");
        }
        try {
            out.close();
        } catch (IOException e) {e.getLocalizedMessage();}
    }
    private static void PrintOutArray(Int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("====ЭЛЕМЕНТ #" + (i + 1) + "====");
            System.out.println(array[i].toString());
        }
    }
}
