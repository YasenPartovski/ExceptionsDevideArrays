package task1;

import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		// Case 1:
		int[] a1={8, 3, 10, 24, 0, 4, 7, 14};
		int[] a2={4, 0, 5, 3, 9, 4};
		System.out.println("Result 1: "+Arrays.toString(devideArrays(a1, a2))); // Printing the new array's values
		// Case 2:
		int[] a3={8, 3, 0, -4, 0, 4, 8 , 88, 888};
		int[] a4={4, 0, 0, 3, 9, 4, 7, 14, 4543, 43, 4353};
		System.out.println("Result 2: "+Arrays.toString(devideArrays(a3, a4)));
		// Case 3:
		int[] a5={84, 3, 7, 14, 4743, 88, 4, 0, 878};
		int[] a6=null;
		System.out.println("Result 3: "+Arrays.toString(devideArrays(a5, a6)));
		// Case 4:
		int[] a7={84, 3, 7, 14, 4743, 88, 4, 0, 878};
		int[] a8={};
		System.out.println("Result 4: "+Arrays.toString(devideArrays(a7, a8)));
		// Case 5:
		int[] a9=null;
		int[] a10={};
		System.out.println("Result 5: "+Arrays.toString(devideArrays(a9, a10)));
	}

	public static int[] devideArrays(int[] a1, int[] a2) {
		int[] a3; // Declaring the output array
		try {
			a3=new int[a1.length]; // Risky: a1 may be NULL
			for (int i = 0; i < a3.length; i++) {
				try {
					a3[i]=a1[i]/a2[i]; // Risky operation because a2[i] can be 0, and the program will generate ArithmeticException
				}
				catch (ArithmeticException e1) {
					a3[i]=0; // Fixing it with automatically making the element 0
				}
				catch (ArrayIndexOutOfBoundsException e2) { // If the length of the 1-st array is greater than the one of the second (a1.length>a2.length)
					int[] a4=new int[a2.length]; // Creating a new int[] with length equal to the shortest array (i.e. a2)
					for (int j = 0; j < a4.length; j++) { // Copying all the values of a3 to a4 (until a4 is full)
						a4[j]=a3[j];
					}
					a3=a4; a4=null; // a3 takes a4's address in the Heap; and than a4 is make null 
					return a3; // returning the new a3 (i.e. with the same value of the elements but with shorter length)
				}
			}
		}
		catch (NullPointerException e3) { // If one of both arrays are NULL
			System.out.println("One or both of the input arrays are NULL. Please try again with valid array inputs!");
			return a3=new int[0]; // "Returns" an empty array with 0 length
		}
		return a3; // If everything goes well the result should be int[] a3
	}
}