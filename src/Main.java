import java.util.*;

import DataStructures.Array;
import DataStructures.HashTable;
import DataStructures.LinkedList;
import DataStructures.Queue;
import DataStructures.Stack;
import DataStructures.Sort.BubbleSort;
import DataStructures.Sort.InsertionSort;
import DataStructures.Sort.MergeSort;
import DataStructures.Sort.MyQuickSort;
import DataStructures.Sort.RadixSort;
import simpleAlgo.Questions;

public class Main {

	public static void main(String[] args) {
		int n = 5;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j || i + j == n + 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println((int)Math.pow(10, 7));
	}
}

// 5.4 = 20
// 20.3 = 60
// 60.2 = 120
// 120.1 = 120