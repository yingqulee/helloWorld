package A_DataStructures.HashMap;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int choice, key;

		//HashMap
		HashMap h = new HashMap(7);

		//LinkedList
		LinkedList linked = new LinkedList();

		while (true) {
			System.out.println("Enter your Choice :");
			System.out.println("1. Add Key");
			System.out.println("2. Delete Key");
			System.out.println("3. Print Table");
			System.out.println("4. Exit");

			Scanner In = new Scanner(System.in);

			choice = In.nextInt();

			switch (choice) {
				case 1: {
					System.out.print("Enter the Key: ");

					key = In.nextInt();
					//HashMap
//					h.insertHash(key);

					//LinkedList
					linked.insert(key);
					break;
				}
				case 2: {
					System.out.print("Enter the Key delete:  ");
					key = In.nextInt();
					//HashMap
//					h.deleteHash(key);

					//LinkedList
					linked.delete(key);
					break;
				}
				case 3: {
					System.out.print("Print table: ");
					//HashMap
//					h.displayHashtable();

					//LinkedList
					linked.display();
					break;
				}
				case 4: {
					return;
				}	
			}
		}
	}
}