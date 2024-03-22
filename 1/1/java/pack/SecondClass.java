package pack;

public class SecondClass {

    private int i;
    private int j;

    public SecondClass() {
        i = 0;
        j = 0;
    }


    public int getI()
    {
        return i;
    }

    public int getJ()
    {
        return j;
    }

    public void setI(int _i) {
        i = _i;
    }

    public void setJ(int _j) {
        j = _j;
    }
    
    public int sum(int i, int  j) {
        return i + j;
    }

}