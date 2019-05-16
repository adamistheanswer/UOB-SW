/**
 * @author Alex Evangelidis and Manfred Kerber modified by Adam Robinson
 * @version 2017-11-10
 *
 * The class contains implementations of two sorting algorithms, bubbleSort and quickSort.
 * Furthermore we have a method to check whether a given array of type double[] is sorted.
 */
public class Sorting {


  /**
   * @param a The array to be sorted.
   * @return The start and end points of the array.
   */

  public static Sortable[] quickSort(Sortable[] a) {
    if (a.length == 0) {
      return a;
    }
    return quickSort(a, 0, a.length - 1);
  }


  /**
   * @param a The array to be sorted in a range.
   * @param start The smallest index in the range of the array to be sorted.
   * @param end The largest index in the range of the array to be sorted.
   * @return The value of the pivot.
   */
  public static Sortable determinePivot(Sortable[] a, int start, int end) {
    // first get the pivot index (middle index of the array)
    int pivot_index = start + (end - start) / 2;

    // Use pivot to store the middle element of the array
    return a[pivot_index];
  }


  /**
   * Performs in-place quicksort over the provided array,
   *
   * @param a The array to be sorted in a range.
   * @param start The smallest index in the range of the array to be sorted.
   * @param end The largest index in the range of the array to be sorted.
   * @return The array in which the specified range is sorted.
   */
  public static Sortable[] quickSort(Sortable[] a, int start, int end) {

    Sortable temp;
    int i = start;
    int j = end;

    Sortable pivot = determinePivot(a, start, end);

    // As long as i and j do not cross
    while (i <= j) {

      // Scan the array from left to right as long as the
      // value is less than the pivot
      while (a[i].compareValue() < pivot.compareValue()) {
        i++;
      }

      // Scan the array from right to left as long as
      // the value is greater than the pivot
      while (a[j].compareValue() > pivot.compareValue()) {
        j--;
      }

      // In the case where the ith element
      // is greater than the pivot
      // or in the case where the jth element
      // is less than the pivot
      // Swap i with j and increment and decrement
      // i and j, respectively.

      if (i <= j) {
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        i++;
        j--;
      }
    }

    // At this point the partitioning phase
    // has been completed because i and j cross
    // Now call the same method recursively
    // for the two sub arrays("left" and "right")
    if (start < j) {
      quickSort(a, start, j);
    }
    if (i < end) {
      quickSort(a, i, end);
    }
    return a;
  }
}