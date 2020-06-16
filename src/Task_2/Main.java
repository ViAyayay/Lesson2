package Task_2;

/**
 * Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
 При подаче массива другого размера необходимо бросить исключение MyArraySizeException.

 * Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
 Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
 должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.

 * В методе main() вызвать полученный метод,
 обработать возможные исключения MySizeArrayException и MyArrayDataException и вывести результат расчета.

 */

public class Main {

    public static void main(String[] args) {
        String[][] array = new String[4][4];
        try{
        array = getArray();
        checkIt(array);
        } catch(MySizeArrayException e){
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e){
            System.out.println(e.getMessage());
        }

    }

    private static void checkIt(String[][] array) throws MyArrayDataException, MySizeArrayException{

        int sum =0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    try {
                        sum += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e){
                        throw new MyArrayDataException("Value: \"" + array[i][j] + "\" at " + i+"x"+j+" incorrectly");
                    }
                }
            }
        System.out.println(sum);
    }

    private static String[][] getArray() {
        String[][] arr =  new String[][]{
                {"1", "3", "15", "2"},

                {"2", "3", "1"},

                {"4", "3", "1a", "3"},

                {"3", "9", "22", "2"},
        };
        for (int i = 0; i < arr.length; i++) {
            if(arr.length!=4 || arr[i].length != 4){
                throw new MySizeArrayException("The array has a size different from 4x4");
            }
        }
        return arr;
    }
}
