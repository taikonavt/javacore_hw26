package main;

public class Main {

    public static int[] updateArray(int[] array) throws RuntimeException{
        int i = array.length;
        int indexOfFour;

        do {
            indexOfFour = --i;
            if (i == -1)
                throw new RuntimeException();
        } while (array[i] != 4);

        int[] result = new int[array.length - (indexOfFour + 1)];
        for (int j = 0; j < result.length; j++){
            result[j] = array[indexOfFour + 1 + j];
        }
        return result;
    }

    public static boolean onlyOneAndFour(int[] array){
        if (array.length == 0)
            return false;
        for (int i : array) {
            if (i != 1 && i != 4)
                return false;
        }
        return true;
    }
}
