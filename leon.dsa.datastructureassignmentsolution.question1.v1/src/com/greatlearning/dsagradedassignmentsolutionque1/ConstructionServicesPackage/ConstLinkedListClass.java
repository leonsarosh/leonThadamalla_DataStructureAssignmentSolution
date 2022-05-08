package com.greatlearning.dsagradedassignmentsolutionque1.ConstructionServicesPackage;

// Custom Linked List implementation

class Node {
	int data;
	Node nextNode;
	Node(int floorSize){
		this.data=floorSize;
		nextNode=null;
	}
}

public class ConstLinkedListClass {
	
	public Node head;
	
	void insertAtFirst(int floorSize) {
		Node newNode=new Node(floorSize);
		newNode.nextNode=head;
		head=newNode;
	}
	
	void insertAtLast(int floorSize) {
		Node currentNode=head;
		while(currentNode.nextNode!=null) {
			currentNode=currentNode.nextNode;
		}
		
		Node newNode=new Node(floorSize); 
		currentNode.nextNode=newNode;
	}
	
	int removeFromFront() {
		Node temp=head;
		head=head.nextNode;
		return temp.data;
	}
	
	public void addToList(int floorSize) {
		Node currentNode=head;
		if(currentNode==null) {
			insertAtFirst(floorSize);
		} else {
			insertAtLast(floorSize);
		}
	}
	
	public int removeFromList() {
		Node currentNode=head;
		if(currentNode==null) {
			System.out.println("List is empty");
			return currentNode.data;
		} else {
			return removeFromFront();
		}	 
	}
	
	public void printList() {
		Node currentNode=head;
		while(currentNode!=null) {
			System.out.print(currentNode.data+" ");
			currentNode=currentNode.nextNode;
		}
		System.out.println();
	}
	
	// Method for finding middle node of Linked List by tortoise and hare approach
	public Node findMidNode(Node head) {
		
		if(head==null) {
			return head;
		}
		Node slow_ptr=head;
		Node fast_ptr=head.nextNode;
		
		while(fast_ptr!=null && fast_ptr.nextNode!=null) {
			slow_ptr=slow_ptr.nextNode;
			fast_ptr=fast_ptr.nextNode.nextNode;
		}
		return slow_ptr;
	}
	
	// MergeSort for Linked List (Descending)
	public Node mergeSort(Node head) {
		
		if(head==null||head.nextNode==null) {
			return head;
		}
		
		Node midNode=findMidNode(head);
		Node nextOfMidNode=midNode.nextNode;
		
		midNode.nextNode=null;
		
		Node leftListHeadNode=mergeSort(head);
		Node rightListHeadNode=mergeSort(nextOfMidNode);
		
		Node sortedListNode=merge(leftListHeadNode,rightListHeadNode);
		
		return sortedListNode;
	}
	
	public Node merge(Node leftListHeadNode, Node rightListHeadNode) {
		
		Node mergedListHeadNode=new Node(-1);
		Node temp=mergedListHeadNode;
		
		while (leftListHeadNode!=null && rightListHeadNode!=null) {
			if(leftListHeadNode.data>rightListHeadNode.data) {
				temp.nextNode=leftListHeadNode;
				leftListHeadNode=leftListHeadNode.nextNode;
			} else {
				temp.nextNode=rightListHeadNode;
				rightListHeadNode=rightListHeadNode.nextNode;
			}
			temp=temp.nextNode;
		}
		
		while(leftListHeadNode!=null) {
			temp.nextNode=leftListHeadNode;
			leftListHeadNode=leftListHeadNode.nextNode;
			temp=temp.nextNode;
		}
		
		while(rightListHeadNode!=null) {
			temp.nextNode=rightListHeadNode;
			rightListHeadNode=rightListHeadNode.nextNode;
			temp=temp.nextNode;
		}
		
		return mergedListHeadNode.nextNode;
	}
	
	public Node cloneList() {
		Node currentNode=head;
		ConstLinkedListClass tempList=new ConstLinkedListClass();
		while(currentNode!=null) {
			tempList.addToList(currentNode.data);
			currentNode=currentNode.nextNode;
		}
		return tempList.head;
	}
	
	// Method for adding floors. If Floors that are in order will be constructed else Floors that are not in order will be sent to buffer and the buffer will be sorted before the floors are constructed.
	public void addFloor(ConstLinkedListClass floorsInputListSortedList ,ConstLinkedListClass floorsInputList ,ConstLinkedListClass floorBuffer) {
		
		if(floorsInputList.head.data==floorsInputListSortedList.head.data) {
			System.out.print(floorsInputList.removeFromList()+" ");
			floorsInputListSortedList.removeFromList();
			
			ConstLinkedListClass tempList2=new ConstLinkedListClass();
			tempList2.head=floorBuffer.cloneList();
			floorBuffer.head=null;
			floorBuffer.head=tempList2.mergeSort(tempList2.head);
			
			while(floorBuffer.head!=null && floorBuffer.head.data==floorsInputListSortedList.head.data) {
				System.out.print(floorBuffer.removeFromList()+" ");
				floorsInputListSortedList.removeFromList();
			}	
			System.out.println();
		} else {
			System.out.println();
			floorBuffer.addToList(floorsInputList.removeFromList());
		}
	}
}
