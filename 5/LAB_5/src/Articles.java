import java.util.Scanner;

public class Articles implements Int {


    private final int[] pages;
    private final String name;
    private final int introduce;
    private int check;

    public Articles() {
        this(0, "NULL", 0);
    }

    public Articles(int _count) {
        this (_count, "NULL", 0);
    }

    public Articles(int _count, String _name, int _introduce) {
        if (_count >= 0) {
            pages = new int[_count];
            int check;
            Scanner scan = new Scanner(System.in);
            for (int i = 0; i < pages.length;) {
                System.out.printf("Введите страницы %d-ой книги: ", i);
                check = Integer.parseInt(scan.nextLine());
                if (check < 0) { throw new RuntimeException("Страниц не может быть меньше нуля!"); }
                else {
                    pages[i] = check;
                    i++;                }
            }
        }
        else { throw new RuntimeException("Размер массива не может быть отрицательным!"); }

        if (!_name.isEmpty()) { this.name = _name; }
        else { throw new RuntimeException("Имя не может быть пустым!"); }

        if (_introduce >= 0) { this.introduce = _introduce; }
        else { throw new RuntimeException("Страницы вступления не могут быть отрицательны!"); }
    }

    @Override
    public int getElement(int n) {
        if ( (n >= 0) && (n < pages.length) ) { return pages[n]; }
        else { throw new IndexOutOfBoundsException(); }
    }

    @Override
    public void setElement(int n, int k) {
        if ( (n >= 0) && (n < pages.length) ) { pages[n] = k; }
        else { throw new IndexOutOfBoundsException(); }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getIntroduce() {
        return introduce;
    }

    @Override
    public int calcPages() throws PagesLessZeroException {
        int res = 0;
        int midTerm = 0;
        for (int page: pages) {
            midTerm = page - introduce;
            if (midTerm > -1) { res += midTerm; }
            else { throw new PagesLessZeroException("Кол-во страниц без вступления меньше нуля!"); }
        }
        return res;
    }


    @Override
    public String toString() {
        String res = "Название серии: " + name + "\n";
        res += "Тип серии: Серия статей\n";
        res += "Кол-во статей: " + pages.length + "\n";
        res += "Кол-во страниц в статьях:\n";
        for (int page : pages) res += page + " ";
        res += "\nКол-во вводных страниц: " + introduce + "\n";
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this.getClass() == o.getClass()) {
            Articles cmp = (Articles)o;
            if (name.equals(cmp.name)) {
                if (introduce == cmp.getIntroduce()) {
                    if (pages.length == cmp.getLen()) {
                        for (int i = 0; i < pages.length; ) {
                            try {
                                if (pages[i] == cmp.getElement(i)) { i++; }
                                else { return false; }
                            }
                            catch (Exception e) { return false; }
                        } return true;
                    } else { return false; }
                } else { return false; }
            } else { return false; }
        } else { return false; }
    }

    @Override
    public int getLen() {
        return pages.length;
    }

    @Override
    public int hashCode() {
        return introduce + name.hashCode() + pages.length * 1000;
    }

}
