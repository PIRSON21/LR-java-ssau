import java.io.OutputStream;
import java.io.Writer;

public class SynchronizedInt implements Int {
    private final Int packaged;

    public SynchronizedInt(Int _package) {
        this.packaged = _package;
    }

    @Override
    public synchronized int getElement(int n) {
        return packaged.getElement(n);
    }

    @Override
    public synchronized void setElement(int n, int k) {
        packaged.setElement(n, k);
    }

    @Override
    public synchronized String getName() {
        return packaged.getName();
    }

    @Override
    public synchronized int getIntroduce() {
        return packaged.getIntroduce();
    }

    @Override
    public synchronized int calcPages() throws PagesLessZeroException {
        return packaged.calcPages();
    }

    @Override
    public synchronized String toString() {
        return packaged.toString();
    }

    @Override
    public synchronized boolean equals(Object o) {
        return packaged.equals(o);
    }

    @Override
    public synchronized int getLen() {
        return packaged.getLen();
    }


    @Override
    public synchronized void output(OutputStream out) {
        packaged.output(out);
    }

    @Override
    public synchronized void write(Writer out) {
        packaged.write(out);
    }

    @Override
    public synchronized int hashCode() {
        return packaged.hashCode();
    }
}