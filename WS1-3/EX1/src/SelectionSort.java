public class SelectionSort {

  public static int[] selectionSort(int[] numbers) {

    int tmp;
    int i;
    int j;
    int minNumber;
    int sortedIndex;


    for (i = 0; i < numbers.length; i++) {
      minNumber = numbers[i];
      sortedIndex = i;

      for (j = i; j < numbers.length; j++) {
        if (numbers[j] < minNumber) {
              minNumber = numbers[j];
              sortedIndex = j;
        }
      }
      if (minNumber < numbers[i]){
          tmp = numbers[i];
          numbers[i] = numbers [sortedIndex];
          numbers[sortedIndex] = tmp;
      }
    }
    return numbers;
  }
}

