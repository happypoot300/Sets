import java.util.Scanner;

public class Main {

	private static CustomSet<Integer> setA = new CustomSet<>();
	private static CustomSet<Integer> setB = new CustomSet<>();
	private static CustomSet<CustomSet<Integer>> setOps = new CustomSet<>();

	public static void main(String[] args) {
		SetPicker();
	}// end main

	public static void SetPicker() {
		//@formatter:off
		System.out.print("\n" + 
						"━━━━━━━━━━━━━━━━━━━━━━━━━\n"+ 
						"┃ 【 1 】 Set A		┃\n" +
						"┃ 【 2 】 Set B 		┃\n" + 
						"┃ 【 3 】 Set C// 		┃\n" + 
						"┃ 【 4 】 Exit 		┃\n" + 
						"━━━━━━━━━━━━━━━━━━━━━━━━━\n" + 
						"》 ");
		//@formatter:on
		switch (CheckUserInput()) {
		case 1:
			MenuChoices(setA, true, false);
			break;
		case 2:
			MenuChoices(setB, false, true);
			break;
		case 3:
			SetOperation();
			break;
		case 4:// exit
			System.out.println("「Exiting now...」");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid input");
			break;
		}// end switch
		SetPicker();
	}// end method

	public static void MenuChoices(CustomSet<Integer> set, boolean isSetA, boolean isSetB) {

		PrintMenuChoices();

		switch (CheckUserInput()) {
		case 1:// add
			System.out.print("Enter key to add: ");

			set.Add(CheckUserInput(), "Element is already in the set");
			set.Display();
			break;
		case 2:// remove
			System.out.println("size of set: " + set.getSize());
			if (set.getSize() <= 0) {
				System.out.println("No element available in set to delete");
				break;
			} // end if

			System.out.print("Enter key to remove: ");
			set.Remove(CheckUserInput());
			set.Display();
			break;
		case 3:// contain
			if (set.getSize() <= 0) {
				System.out.println("No element available in set to find");
				break;
			} // end if

			System.out.print("Enter key to find: ");
			set.Contains(CheckUserInput());
			break;
		case 4:// size
			set.Size();
			break;
		case 5:// clear
			if (set.getSize() <= 0) {
				System.out.println("Set is already empty.");
				break;
			} // end if

			System.out.println("Clearing set");
			set.Clear();
			break;
		case 6:// set operations
//			SetOperation();
			break;
		case 7:// display
			set.Display();
			break;
		case 8:// back
			return;
		case 9:// exit
			System.out.println("「Exiting now...」");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid input");
			break;
		}// end switch

		if (isSetA) {
			MenuChoices(setA, isSetA, isSetB);
		} else {
			MenuChoices(setB, isSetA, isSetB);
		} // end if else
	}// end method

	public static int CheckUserInput() {
		Scanner sc = new Scanner(System.in);

		if (sc.hasNextInt()) {
			int key = sc.nextInt();
			return key;
		} // end if
		System.out.println("Invalid input\n" + "》 ");
		return CheckUserInput();
	}// end if

	public static void PrintMenuChoices() {
		//@formatter:off
		System.out.print("\n" + 
						"━━━━━━━━━━━━━━━━━━━━━━━━━\n"+ 
						"┃ 【 1 】 Add		┃\n" +
						"┃ 【 2 】 Remove 		┃\n" + 
						"┃ 【 3 】 Contain 		┃\n" +
						"┃ 【 4 】 Size 		┃\n" +
						"┃ 【 5 】 clear 		┃\n" +
						"┃ 【 6 】 Set Operations 	┃\n" +
						"┃ 【 7 】 Display 		┃\n" + 
						"┃ 【 8 】 <- Back 		┃\n" + 
						"┃ 【 9 】 Exit 		┃\n" + 
						"━━━━━━━━━━━━━━━━━━━━━━━━━\n" + 
						"》 ");
		//@formatter:on
	}// end method

	public static void PrintSetOperations() {
		//@formatter:off
		System.out.print("\n" + 
						"━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n"+ 
						"┃ 【 1 】 Union (A ∪ B)          ┃\n" +
						"┃ 【 2 】 Intersection (A ∩ B)   ┃\n" + 
						"┃ 【 3 】 Difference (A − B)     ┃\n" +
						"┃ 【 4 】 Subset Check (A ⊂ B)   ┃\n" +
						"┃ 【 5 】 Equality Check (A ⊆ B) ┃\n" +
						"┃ 【 6 】 <-Back                 ┃\n" + 
						"━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" + 
						"》 ");
		//@formatter:on
	}// end method

	public static void SetOperation() {

		PrintSetOperations();

		switch (CheckUserInput()) {
		case 1:// union
			setOps.Union(setA.getElements(), setB.getElements(), setA.getSize(), setB.getSize());
			System.out.print("Set A: ");
			setA.Display();
			System.out.print("Set B: ");
			setB.Display();
			break;
		case 2:// intersection
			setOps.Intersection(setA.getElements(), setB.getElements(), setA.getSize(), setB.getSize());
			System.out.print("Set A: ");
			setA.Display();
			System.out.print("Set B: ");
			setB.Display();
			break;
		case 3:// difference
			setOps.Difference(setA.getElements(), setB.getElements(), setA.getSize(), setB.getSize());
			System.out.print("Set A: ");
			setA.Display();
			System.out.print("Set B: ");
			setB.Display();
			break;
		case 4:// subset check
			setOps.Subset(setA.getElements(), setB.getElements(), setA.getSize(), setB.getSize());
			System.out.print("Set A: ");
			setA.Display();
			System.out.print("Set B: ");
			setB.Display();
			break;
		case 5:// equality check
			setOps.Equality(setA.getElements(), setB.getElements(), setA.getSize(), setB.getSize());
			System.out.print("Set A: ");
			setA.Display();
			System.out.print("Set B: ");
			setB.Display();
			break;
		case 6:// <- back
			return;
		default:
			System.out.println("invalid input");
			break;
		}// switch

		SetOperation();
	}// end method

}// end class
