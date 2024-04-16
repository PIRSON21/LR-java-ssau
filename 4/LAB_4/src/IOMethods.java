import java.io.*;
import java.util.Scanner;

public class IOMethods {

    public static void outputInt(Int o, OutputStream out) throws IOException {
            if (o.getClass().equals(Essays.class)) { out.write(1);}
            else { out.write(2);}
            out.write(o.getName().length());
            out.write(o.getName().getBytes());
            out.write(o.getIntroduce());
            out.write(o.getLen());
            for (int i = 0; i < o.getLen(); i++) { out.write(o.getElement(i)); }
    }
    public static Int inputInt(InputStream in) throws IOException {
            int type = in.read();
            int nameLength = in.read();
            byte[] nameByte = new byte[nameLength];

            if (nameLength == in.read(nameByte)) {
                String name = new String(nameByte);
                int introduce = in.read();
                int arrayLength = in.read();
                int[] array = new int[arrayLength];
                for (int i = 0; i < arrayLength; i++) array[i] = in.read();

                if (type == 1) return new Essays(arrayLength, name, introduce, array);
                else if (type == 2) return new Articles(arrayLength, name, introduce, array);
                else throw new IOException();
            } else throw new IOException();
    }
    public static void writeInt(Int o, Writer out) throws IOException {
            if (o.getClass().equals(Essays.class)) { out.write(1 + " ");}
            else { out.write(2 + " ");}
            out.write(o.getName() + " ");
            out.write(o.getIntroduce() + " ");
            out.write(o.getLen() + " ");
            for (int i = 0; i < o.getLen(); i++) { out.write(o.getElement(i) + " "); }
    }
    public static Int readInt(Reader in) throws IOException {
            if (in.ready()) {
                StreamTokenizer stream = new StreamTokenizer(in);
                stream.nextToken();
                if (stream.ttype == StreamTokenizer.TT_NUMBER) {
                    int type = (int) stream.nval;
                    stream.nextToken();
                    if (stream.ttype == StreamTokenizer.TT_WORD || stream.ttype == StreamTokenizer.TT_NUMBER) {
                        String name = "";
                        if (stream.sval == null) {
                            name = String.valueOf(stream.nval);
                        }
                        else {
                            name = stream.sval;
                        }
                        stream.nextToken();
                        if (stream.ttype == StreamTokenizer.TT_NUMBER) {
                            int introduce = (int)stream.nval;
                            stream.nextToken();
                            if (stream.ttype == StreamTokenizer.TT_NUMBER) {
                                int length = (int)stream.nval;
                                int[] array = new int[length];
                                for (int i = 0; i < array.length; i++) {
                                    stream.nextToken();
                                    if (stream.ttype == StreamTokenizer.TT_NUMBER) {
                                        array[i] = (int)stream.nval;
                                    }
                                }
                                if (type == 1) return new Essays(length, name, introduce, array);
                                else if (type == 2) return new Articles(length, name, introduce, array);
                                else throw new IOException();
                            }
                        }
                    }
                }
            }
            else throw new IOException("Поток не задан!");
            throw new IOException("Ошибка чтения!");
    }
    public static void serializeInt(Int o, OutputStream out) throws IOException {
        ObjectOutputStream objOut = new ObjectOutputStream(out);
        objOut.writeObject(o);
    }
    public static Int deserializeInt(InputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream objIn = new ObjectInputStream(in);
        return (Int)objIn.readObject();
    }
    public static void writeFormatInt(Int o, Writer out) throws IOException {
        out.write("Название серии: '" + o.getName() + "'\n");
        out.write( "Тип серии: 'Серия статей'\n");
        out.write( "Кол-во статей: '" + o.getLen() + "'\n");
        out.write( "Кол-во страниц в статьях:\n");
        for (int i = 0; i < o.getLen(); i++) {
            out.write( o.getElement(i) + " ");
        }
        out.write("\n");
        out.write( "Кол-во вводных страниц: '" + o.getIntroduce() + "'\n");
    }
    public static Int readFormatInt(Scanner in) {
        String name = "";
        int len = 0;
        int[] elements;
        int introduce = 0;
        String nextLine;

        if (in.hasNextLine()) {
            nextLine = in.nextLine();
            name = nextLine.substring("Название серии: '".length(), nextLine.length() - 1);
        }

        in.nextLine();

        if (in.hasNextLine()) {
            nextLine = in.nextLine();
            len = Integer.parseInt(nextLine.substring("Кол-во статей: '".length(), nextLine.length() - 1));
        }

        in.nextLine();

        elements = new int[len];
        if (in.hasNextLine()) {
            String[] pages = in.nextLine().split(" ");
            for (int i = 0; i < len; i++) {
                elements[i] = Integer.parseInt(pages[i]);
            }
        }

        if (in.hasNextLine()) {
            nextLine = in.nextLine();
            introduce = Integer.parseInt(nextLine.substring("Кол-во вводных страниц: '".length(), nextLine.length() - 1));
        }
        return new Articles(elements.length, name, introduce, elements);
    }
}
