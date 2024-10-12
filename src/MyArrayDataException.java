public class MyArrayDataException extends Exception {
    public int col;
    public int str;

    MyArrayDataException(int str, int col) {
        this.str = str;
        this.col = col;
    }
}
