package array;

public class BubbleSort {
    //
    // [6,7,4,2]
    // [6,7,4,2]
    // [3,2,4,6]
    public int[] sort(int[] numbers) {

        int auxNumber = 0;
        for (int arrayIdx = 0; arrayIdx < numbers.length; arrayIdx++) {
            for (int numIdx = 0; numIdx < (numbers.length - 1) - arrayIdx; numIdx++) {
                if(numbers[numIdx+1] < numbers[numIdx]) {
                    auxNumber = numbers[numIdx];
                    numbers[numIdx] = numbers[numIdx+1] ;
                    numbers[numIdx+1] = auxNumber;
                }
            }
        }

        return numbers;
    }
}
