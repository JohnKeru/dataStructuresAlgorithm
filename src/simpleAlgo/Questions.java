package simpleAlgo;

import java.util.HashMap;

public class Questions {

	private int rStart;
	private int rLength;

	public static int[] getTwoSum(int[] nums, int target) {
		// O(n) -> linear
		var map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int delta = target - nums[i];
			if (map.containsKey(delta))
				return new int[] { map.get(delta), i };
			map.put(nums[i], i);
		}
		return new int[] { -1, -1 };
	}

	public static int[] testing(int[] nums, int target) {
		// O(n2) -> worst time complexity or quadratic
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (nums[j] + nums[i] == target && nums[j] != nums[i])
					return new int[] { i, j };
			}
		}
		return new int[] { nums[-1], -1 };
	}

	public void myReverse(String input) {
		for (int i = input.length() - 1; i >= 0; i--) {
			char rev = input.charAt(i);
			System.out.print(rev);
		}
	}

	public static String reverse(String input) {
		StringBuilder indexHolder = new StringBuilder();
		for (int i = input.length() - 1; i >= 0; i--)
			indexHolder.append(input.charAt(i));

		return indexHolder.toString();
	}

	public int reverseInteger(int input) {
		int rev = 0; // 1 2 3 4 5
		while (input > 0) {
			int lastValue = input % 10; // 5 4 3 2 1
			input /= 10; // 5 -> 0
			rev = (rev * 10) + lastValue; // 5 54 543 5432 54321
		}
		return rev;
	}

	public String reverseAll(String words) {
		String[] separate = words.split(" ");
		String reverser = "";
		for (int i = separate.length - 1; i >= 0; i--) {
			if (i != 0)
				reverser += reverser(separate[i]) + " ";
			else
				reverser += reverser(separate[i]);
		}
		return reverser;
	}

	public String reverseWords(String words) {
		String[] separate = words.split(" ");
		String reverser = "";
		for (int i = separate.length - 1; i >= 0; i--) 
			reverser += separate[i] + " ";
		return reverser;
	}

	public String reverser(String input) {
		String reverse = "";
		for (int i = input.length() - 1; i >= 0; i--)
			reverse  += input.charAt(i);
		return reverse;
	}

	public void crossDesign(int size, String pattern, String cross) {
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if ((i == size / 2) || (j == size / 2))
					System.out.print(cross);
				else
					System.out.print(pattern);
			}
			System.out.println();
		}
	}

	public String intToRoman(int input) {
		String[] thousands = { "", "M", "MM", "MMM", "MV", "V", "VM", "VMM", "VMMM" };
		String[] hundreds = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String[] tens = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String[] units = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

		return thousands[input / 1000] + // 2
				hundreds[(input % 1000) / 100] + // 1
				tens[(input % 100) / 10] + // 2
				units[input % 10]; // 0
	}

	public int romanToInt(String input) {
		String roman = input.toUpperCase();
		int result = 0;

		var map = new HashMap<Character, Integer>(); // IV = 4, VII = 7
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		for (int i = 0; i < roman.length(); i++) {
			if (i > 0 && map.get(roman.charAt(i)) > map.get(roman.charAt(i - 1)))
				result += map.get(roman.charAt(i)) - (2 * map.get(roman.charAt(i - 1)));
			else
				result += map.get(roman.charAt(i));
		}
		return result;
	}

	public String evenOrOdd(int input) {
		if (input % 2 == 0)
			return "Even";
		return "Odd";
	}

	public String longestPalindrome(String i) {
		int l = i.length();
		if (l < 2)
			return i;
		for (int start = 0; start < l - 1; start++) {
			expandRange(i, start, start);
			expandRange(i, start, start + 1);
		}
		return i.substring(rStart, rStart + rLength);
	}

	private void expandRange(String i, int start, int end) {
		while ((start >= 0) && (end < i.length()) && (i.charAt(start) == i.charAt(end))) {
			start--;
			end++;
		}
		if (rLength < end - start - 1) {
			rStart = start + 1;
			rLength = end - 1;
		}
	}

	public boolean detectCapitalUse(String input) {

		if (input.length() == 0)
			return false;

		String fLetter = input.substring(0, 1);
		String nextLetters = input.substring(1, input.length());

		if (fLetter.equals(fLetter.toUpperCase()) && nextLetters.equals(nextLetters.toLowerCase()))
			return true;
		else if (input.equals(input.toUpperCase()) || input.equals(input.toLowerCase()))
			return true;

		return false;
	}

	public boolean powerOfFour(int input) {
		return Math.log(input) / Math.log(4) % 1 == 0;
	}

}
