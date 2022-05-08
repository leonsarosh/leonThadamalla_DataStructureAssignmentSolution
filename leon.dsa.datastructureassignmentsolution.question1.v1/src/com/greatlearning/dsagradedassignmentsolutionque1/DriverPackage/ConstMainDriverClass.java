package com.greatlearning.dsagradedassignmentsolutionque1.DriverPackage;

import com.greatlearning.dsagradedassignmentsolutionque1.ConstructionServicesPackage.ConstUtilitiesClass;
import com.greatlearning.dsagradedassignmentsolutionque1.ConstructionServicesPackage.ConstLinkedListClass;

public class ConstMainDriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConstUtilitiesClass const1= new ConstUtilitiesClass();
		
		System.out.println("Enter the total number of floors in the building:");
		int size=const1.checkInt();
		
		// using Linked Lists (custom implementation) for storing Input,Sorted Input and Buffer for floors not constructed
		ConstLinkedListClass floorsInputList=new ConstLinkedListClass();
		ConstLinkedListClass floorBuffer=new ConstLinkedListClass();
		ConstLinkedListClass floorsInputListSortedList=new ConstLinkedListClass();
		
		for(int i=0; i<size; i++) {
			System.out.println("Enter the floor size given on day "+(i+1)+" :");
			int floorSize=const1.checkInt();
			floorsInputList.addToList(floorSize); //adding element to Floors input Linked List
		}
		
		floorBuffer.head=floorsInputList.cloneList(); // copying input to retain the order in which the floors are received
		floorsInputListSortedList.head=floorBuffer.mergeSort(floorBuffer.head); // Sorting the Input and storing in a Linked List
		floorBuffer.head=null; //resetting buffer
		
		System.out.println("The order of construction is as follows");
		
		for(int i=0; i<size; i++) {
			System.out.println("Day: "+(i+1));
			floorsInputList.addFloor(floorsInputListSortedList,floorsInputList,floorBuffer);
		}

	}

}
