public class PagesLessZeroException extends Exception {
    public PagesLessZeroException(int i) {
        super(Integer.toString(i));
    }

    public PagesLessZeroException(String message) {
        super(message);
    }
}
