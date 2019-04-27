import java.util.Scanner;

public class ArrayRecursion {

    public static void main(String[] args) {

        System.out.println(lastIndex(new int[] { 3, 8, 1, 8, 8, 7 }, 0, 8));
        printArray(new int[] { 12, 3, 4, 23, 5, 6, 7 });
    }

    public static int lastIndex(int[] arr, int si, int data) {
        if (si == arr.length) {
            return -1;
        }
        int index = lastIndex(arr, si + 1, data);
        if (index == -1) {
            if (arr[si] == data)
                index = si;
            else
                index = -1;
        }
        return index;
    }

    private static void printArray(int[] is) {
        printArray(is, is.length - 1);
    }

    private static void printArray(int[] is, int length) {
        if (length < 0)
            return;
        printArray(is, length - 1);
        System.out.print(is[length] + " ");
    }
}
