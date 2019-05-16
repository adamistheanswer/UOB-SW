import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author David Mcdonald and Alexandros Evangelidis
 */

public class Ws3PublicTestsEx1 {
	
    //public test
    @Test 
    public void test1() {
		
        int[] a = {5, 2, 7, 6, 8, 1, 5};
		
		
        int[] expected = {1, 2, 5, 5, 6, 7, 8};
        int[] actual = SelectionSort.selectionSort(a);
		
        assertArrayEquals(expected, actual);
    }

    //public test
    @Test 
    public void test2() {
		
        int[] a = {8, 5, 7, 6, 2, 7, 6, 1, 2, 5, 4, 9};
		
		
        int[] expected = {1, 2, 2, 4, 5, 5, 6, 6, 7, 7, 8, 9};
        int[] actual = SelectionSort.selectionSort(a);
		
        assertArrayEquals(expected, actual);
    }
	
    //public test
    @Test 
    public void test3() {
		
        int[] a = {5, 4, 2, 7, 5, 4, 8, 1, 7, 3, 9, 0, 1, 6, 7};
		
		
        int[] expected = {0, 1, 1, 2, 3, 4, 4, 5, 5, 6, 7, 7, 7, 8, 9};
        int[] actual = SelectionSort.selectionSort(a);
		
        assertArrayEquals(expected, actual);
    }
	
    //public test
    @Test 
    public void test4() {
		
        int[] a = {5, 2, 4, 0, 8, 7, 6, 3, 0, 7, 8, 5, 4, 6, 3, 0, 8, 2, 7, 6, 3, 9, 0};
		
		
        int[] expected = {0, 0, 0, 0, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9};
        int[] actual = SelectionSort.selectionSort(a);
		
        assertArrayEquals(expected, actual);
    }
	
    //public test
    @Test 
    public void test5() {
		
        int[] a = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0};
		
		
        int[] expected = {0,1,1,1,1,1,1,1,1,1,1};
        int[] actual = SelectionSort.selectionSort(a);
		
        assertArrayEquals(expected, actual);
    }
	
    //public test
    @Test 
    public void test6() {
		
        int[] a = {Integer.MAX_VALUE, -1, -1, -1, 1, 2, -1};
		

        int[] expected = {-1, -1, -1, -1, 1, 2, Integer.MAX_VALUE};
        int[] actual = SelectionSort.selectionSort(a);
		
        assertArrayEquals(expected, actual);
    }

    //public test
    @Test 
    public void test7() {
		
        int[] a = {4};
		

        int[] expected = {4};
        int[] actual = SelectionSort.selectionSort(a);
		
        assertArrayEquals(expected, actual);
    }

    //public test
    @Test 
    public void test8() {
		
        int[] a = {};
		

        int[] expected = {};
        int[] actual = SelectionSort.selectionSort(a);
		
        assertArrayEquals(expected, actual);
    }
}
