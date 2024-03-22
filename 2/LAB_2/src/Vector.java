
public class Vector {

    private final double[] vector;

    public Vector(int n) {     // конструктор, что задает длину массива

        vector = new double[n];
    }

    public double getCord(int n) {      // получение элемента массива
        if (n < 0 || n >= vector.length) {
            throw new IndexOutOfBoundsException("Ошибка! Такой координаты у вектора нет!"); // TODO: 15.02.2024 что-то с этим сделать
        } else {
            return vector[n];
        }
    }

    public void setCord(int n, double i) { // задание элемента массива
        if (n < 0 || n > vector.length) {
            System.out.println("Ошибка! Такой координаты у вектора нет!");
        } else {
            vector[n] = i;
        }
    }

    public int getLen() {    // длина массива
        return vector.length;
    }

    public double maxCord() { // максимальное число в массиве
        double maxCord = vector[0];
        for (int i = 0; i < vector.length; i++)
            if (vector[i] > maxCord) {
                maxCord = vector[i];
            }
        return maxCord;
    }

    public double minCord() { // минимальное число в массиве
        double minCord = vector[0];
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] < minCord) {
                minCord = vector[i];
            }
        }
        return minCord;
    }

    public void sortVector() {



        for (int i = 0; i < vector.length; i++) {
            for (int j = i; j < vector.length; j++) {
                if (vector[i] > vector[j]) {
                    double temp = vector[j];
                    vector[j] = vector[i];
                    vector[i] = temp;
                }
            }
        }
    }

    public double evklid(Vector vec2) {

        if (vector.length != vec2.getLen()) { // проверка, чтобы размерности совпадали
            System.out.println("Ошибка! Размерности векторов не совпадают!");
            return 0;
        } else {
            double res = 0;
            for (int i = 0; i < vector.length; i++) {
                res += Math.pow(vector[i]-vec2.getCord(i), 2);
            }
            res = Math.sqrt(res);
            return res;
        }
    }

    public Vector mulNumber(double num) {  // умножение на число
        Vector res = new Vector(vector.length);
        for (int i = 0; i < vector.length; i++) {
            res.setCord(i, vector[i] * num);
        }
        return res;
    }

    public static Vector sumVector(Vector vec1, Vector vec2) { // сумма векторов
        if (vec1.getLen() != vec2.getLen()) { // проверка, чтобы размерности совпадали
            System.out.println("Ошибка! Размерности векторов не совпадают!");
            return null;
        } else {
            Vector res = new Vector(vec1.getLen());
            for (int i = 0; i < vec1.getLen(); i++) {
                res.setCord(i, vec1.getCord(i) + vec2.getCord(i));
            }
            return res;
        }
    }
    

    public static double scalar(Vector vec1, Vector vec2) // скалярное произведение
    {
        if (vec1.getLen() != vec2.getLen()) { // проверка, чтобы размерности совпадали
            System.out.println("Ошибка! Размерности векторов не совпадают!");
            return 0;
        } else {
            double res = 0;
            for (int i = 0; i < vec1.getLen(); i++) {
                res += vec1.getCord(i) * vec2.getCord(i);
            }
            return res;
        }
    }



    public void printVector() {
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();
    }

}
