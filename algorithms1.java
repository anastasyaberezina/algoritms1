public class Sort {
    public static void main(String[] args){
        int[] array = new int[]{1,5,7,9,4,14,18,0};
        PyramidSorting(array);
    }


    private static void PyramidSorting(int[] array, arraySize, int initialIndex){

        int maxNumber = initialIndex;
        int leftNumber = 2*initialIndex+1;
        int rightNumber = 2*initialIndex+2;

        if (leftNumber < arraySize && array[leftNumber] > array[maxNumber]){
            maxNumber = leftNumber;
        }
        if (rightNumber < arraySize && array[rightNumber] > array[maxNumber]){
            maxNumber = rightNumber;
        }
        if (maxNumber != initialIndex){
            int count = array[initialIndex];
            array[initialIndex] = array[maxNumber];
            array[maxNumber] = count;

            PyramidSorting(array, arraySize, maxNumber);
        }
    }
}