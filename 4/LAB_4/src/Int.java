import java.io.OutputStream;
import java.io.Writer;

interface Int {
    int getElement(int n);
    void setElement(int n, int k);
    String getName();
    int getIntroduce();
    int calcPages() throws PagesLessZeroException;
    boolean equals(Object o);
    int getLen();
    void output(OutputStream out);
    void write(Writer out);
}