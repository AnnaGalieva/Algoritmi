package Lesson2;
import java.util.Arrays;
import java.util.Random;


public class Sample01 {

    public static void main(String[] args) {

        int[] arr = ArrayUtils.prepareArray();
        ArrayUtils.printArray(arr);
        SortUtils.directSort(arr);
        ArrayUtils.printArray(arr);


        arr = ArrayUtils.prepareArray();
        ArrayUtils.printArray(arr);
        SortUtils.quickSort(arr);
        ArrayUtils.printArray(arr);


        int[] testArray = ArrayUtils.prepareArray(100000);

        long startTime = System.currentTimeMillis();
        //SortUtils.directSort(testArray.clone());
        long endTime = System.currentTimeMillis();
        long processingTime = endTime - startTime;
        System.out.printf("Время работы сортировки выбором: %d мс.\n", processingTime);

        // ---
        startTime = System.currentTimeMillis();
        //SortUtils.quickSort(testArray.clone());
        endTime = System.currentTimeMillis();
        processingTime = endTime - startTime;
        System.out.printf("Время работы быстрой сортировки: %d мс.\n", processingTime);


        int[] testArray2 = new int[] {-22, 11, -30, 0, 9, 1, 30, 99};
        SortUtils.quickSort(testArray2);
        ArrayUtils.printArray(testArray2);

        int res = SearchUtils.binarySearch(testArray2, 11);
        System.out.printf("Элемент %d %s\n", 11,
                res >= 0 ? String.format("найден в массиве по индексу %d", res) : "не найден в массиве");


        int res2 = Arrays.binarySearch(testArray2, 11);
        System.out.printf("Элемент %d %s\n", 11,
                res2 >= 0 ? String.format("найден в массиве по индексу %d", res2) : "не найден в массиве");

        /*int a = 1;
        int b = 3;
        int c;

        // if - then - else
        if (a >= b){
            c = a;
        }
        else {
            c = b;
        }

        c = a >= b ? a : b; */





    }

    static class SearchUtils{

        static  int binarySearch(int[] array,  int value){
            return  binarySearch(array, value, 0, array.length - 1);
        }

        static int binarySearch(int[] array,  int value, int min, int max){
            int middle; // Индекс середины массива
            if (max < min)
            {
                return -1;
            }
            else {
                middle = (max - min) / 2 + min;
            }

            if (array[middle] < value){
                return binarySearch(array, value, middle + 1, max);
            }
            else {
                if (array[middle] > value){
                    return binarySearch(array, value, min, middle - 1);
                }
                else {
                    return middle;
                }

            }

        }

    }

    static class  SortUtils{

        /**
         * O(n^2)
         * @param array
         */
        static void directSort(int[] array){
            for (int i = 0; i < array.length; i++){
                int min = i;
                for(int j = i + 1; j < array.length; j++){
                    if (array[j] < array[min]){
                        min = j;
                    }
                }
                if (min != i){
                    //int buf = array[i];
                    //array[i] = array[min];
                    //array[min] = buf;

                    array[i] = array[i] + array[min];
                    array[min] = array[i] - array[min];
                    array[i] = array[i] - array[min];

                }


            }
        }


        static  void quickSort(int[] array){
            quickSort(array, 0, array.length - 1);
        }

        static void quickSort(int[] array, int startPosition, int endPosition){
            int leftPosition = startPosition;
            int rightPosition = endPosition;
            int pivot = array[(startPosition + endPosition) / 2];

            do {
                while (array[leftPosition] < pivot)
                    leftPosition++;
                while (array[rightPosition] > pivot)
                    rightPosition--;
                if (leftPosition <= rightPosition){
                    if (leftPosition < rightPosition){
                        int buf = array[leftPosition];
                        array[leftPosition] = array[rightPosition];
                        array[rightPosition] = buf;
                    }
                    leftPosition++;
                    rightPosition--;
                }
            }while (leftPosition <= rightPosition);

            if(leftPosition < endPosition){
                quickSort(array, leftPosition, endPosition);
            }
            if(startPosition < rightPosition){
                quickSort(array, startPosition, rightPosition);
            }

        }


    }

    static class ArrayUtils{

        private static final Random random = new Random();

        static int[] prepareArray(){
            int[]  arr = new int[random.nextInt(16) + 5];
            for (int i = 0; i < arr.length; i++){
                arr[i] = random.nextInt(100);
            }
            return arr;
        }

        static int[] prepareArray(int length){
            int[]  arr = new int[length];
            for (int i = 0; i < arr.length; i++){
                arr[i] = random.nextInt(100);
            }
            return arr;
        }

        static void printArray(int[] arr){
            for (int element: arr) {
                System.out.printf("%d\t", element);
            }
            System.out.println();
        }

    }


}

