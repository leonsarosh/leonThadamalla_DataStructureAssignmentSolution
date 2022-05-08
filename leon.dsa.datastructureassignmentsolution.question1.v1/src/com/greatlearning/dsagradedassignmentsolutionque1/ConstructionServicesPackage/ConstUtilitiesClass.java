package com.greatlearning.dsagradedassignmentsolutionque1.ConstructionServicesPackage;

import java.util.Scanner;


//Using this class for support functions
public class ConstUtilitiesClass {
	
	// This method is used to make sure only positive integers are entered 
	public int checkInt() {
		Scanner sc2=new Scanner(System.in);
		
		while (!sc2.hasNextInt()) {
			System.out.println("Please enter a positive integer value only. Try again.");
			return checkInt();
		}
		
		int input1=sc2.nextInt();
		
		while (input1<0) {
			System.out.println("Please enter a positive integer value only. Try again.");
			return checkInt();
		}
		
		return input1;
	}
}
