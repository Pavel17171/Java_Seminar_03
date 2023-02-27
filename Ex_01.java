// Ex_01 +Реализовать алгоритм сортировки слиянием

public class Ex_01 {
    public static void main(String[] args) {

        int[] array = { 1, 0, 5, -5, 2, 3, 7, 1, 2, 5, 9, 10, 15, 2, 4, 6, 8 };

        System.out.print("Исходный массив:       ");
        print(array);

        mergeSort(array);

        System.out.print("Отсортированный массив:");
        print(array);
    }

    // Метод разделения массива на 2-е части
    public static void mergeSort(int[] arrayA) {
        int len = arrayA.length;
        int midLen = len / 2;
        if (len < 2) {
            return;
        }
        int[] arrayB = new int[midLen];
        int[] arrayC = new int[len - midLen];

        for (int i = 0; i < midLen; i++) {
            arrayB[i] = arrayA[i];
        }

        for (int j = midLen; j < len; j++) {
            arrayC[j - midLen] = arrayA[j];
        }

        // Рекурсия дробления массива
        mergeSort(arrayB);
        mergeSort(arrayC);

        // Объединение массивов
        merge(arrayA, arrayB, arrayC, midLen, len - midLen);

    }

    // Метод слияния отсортированным меньших массивов в один отсортированный больший массив
    public static void merge(int[] arrayA, int[] arrayB, int[] arrayC, int lenB, int lenC) {
        int i = 0, j = 0, k = 0;

        // Пока не закончится один из подмассивов, в массиве заменяем 
        // элементы на элемены из его подмассивов по возразтанию
        while (j < lenB && k < lenC) {
            if (arrayB[j] <= arrayC[k]) {
                arrayA[i++] = arrayB[j++];
            } else {
                arrayA[i++] = arrayC[k++];
            }
        }

        // Если в подмассиве arrayB остались элементы, 
        // заменяем ими оставшиеся элементы массива
        while (j < lenB) {
            arrayA[i++] = arrayB[j++];
        }

        // Если в подмассиве arrayC остались элементы, 
        // заменяем ими оставшиеся элементы массива        
        while (k < lenC) {
            arrayA[i++] = arrayC[k++];
        }
    }

    // Метод вывода массива в терминал
    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
    }

}
