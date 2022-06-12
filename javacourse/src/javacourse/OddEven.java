package javacourse;
class OddEven {
	public static void main(String[] args)
	{
		
		int nums[] = new int[25];
		int odd = 0, even = 0;
		int r;
		
		//create array of 25 random numbers
		for (int i = 0; i < 25; i++)
		{
			r = 1 + (int)(Math.random() * 100);
			nums[i] = r;
			if (r % 2 == 0) ++even;
			else ++odd;
		}
		
		//create odd and even arrays to exact lengths
		int e[] = new int[even];
		int o[] = new int[odd];
		int x = 0, y = 0;
		
		for (int n : nums ) {
			if (n % 2 == 0) {	// evens
				e[x] = n;
				x++;
			}
			else {				// odds
				o[y] = n;
				y++;
			}
		}
		
		// display odd and even arrays
		System.out.print("Even numbers are: ");
		for (int i : e)
			System.out.print(i + " ");
		System.out.println();
		System.out.print("Odd numbers are: ");
		for (int i : o)
			System.out.print(i + " ");
		System.out.println();
	}
}