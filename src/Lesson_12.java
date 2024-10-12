public class Lesson_12 {
    public static void main(String[] args) {
        String[][] arr = new String[][]{{"1", "2", "3", "5"}, {"2", "4", "2", "3"}, {"1", "6", "2", "2"},
                {"2", "2", "2u", "2"}};
        try {
            try {
                int result = method(arr);
                System.out.println(result);
            } catch (MyArraySizeException m) {
                System.out.println("Размер массива превышен!");
            }
        }
        catch (MyArrayDataException m) {
            System.out.println("Неправильное значение массива!");
            System.out.println("Ошибка в ячейке: " + m.str + "x" + m.col);
        }

    }


    public static int method(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int str = 0; str < arr.length; str++) {
            for (int col = 0; col < arr[str].length; col++) {
                try {
                    count = count + Integer.parseInt(arr[str][col]);
                }
                catch (NumberFormatException n) {
                    throw new MyArrayDataException(str, col);
                }
            }

        }
        return count;
    }
}
