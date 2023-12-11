public class SetOperations<T> {

	/*
	 * private Object[] A; private Object[] B; private Object[] C; private Object[]
	 * setList;
	 * 
	 * private int A_Size; private int B_Size; private int C_Size; private int
	 * setListSize;
	 * 
	 * // constructor public SetOperations() { // default size and length of A & B
	 * set int defaultSize = 5;
	 * 
	 * A_Size = 0; B_Size = 0; C_Size = 0; setListSize = 0;
	 * 
	 * A = new Object[defaultSize]; B = new Object[defaultSize]; C = new
	 * Object[defaultSize]; setList = new Object[defaultSize]; }// end constructor
	 * 
	 * // getter for Set public Object[] getA() { return this.A; }// end method
	 * 
	 * public Object[] getB() { return this.B; }// end method
	 * 
	 * public Object[] getC() { return this.C; }// end method
	 * 
	 * // getter setter for size of set public int getA_Size() { return A_Size; }//
	 * end method
	 * 
	 * public void setA_Size(int sizeOfSet) { this.A_Size = sizeOfSet; }// end
	 * method
	 * 
	 * public int getB_Size() { return B_Size; }// end method
	 * 
	 * public void setB_Size(int sizeOfSet) { this.B_Size = sizeOfSet; }// end
	 * method
	 * 
	 * public int getC_Size() { return C_Size; }// end method
	 * 
	 * public void setC_Size(int sizeOfSet) { this.C_Size = sizeOfSet; }// end
	 * method
	 * 
	 * // Set methods // add method public void Add(T key, Object[] set, int
	 * sizeOfSet, boolean isSetA, boolean isSetB, boolean isSetC) { if
	 * (Contains(key, set, sizeOfSet)) {
	 * System.out.print("Element is already in the set"); return; } // end if
	 * CheckArrayCapacity(set, sizeOfSet);
	 * 
	 * if (isSetA) {// determine which set to add the element A[A_Size++] = key;
	 * return;
	 * 
	 * } else if (isSetB) { B[B_Size++] = key; System.out.println("added to B");
	 * return; } else if (isSetC) { C[C_Size++] = key;
	 * System.out.println("added to B"); return; } // end if else
	 * 
	 * System.out.println("Added to non"); }// end method
	 * 
	 * // remove method public void Remove(T key, Object[] set, int sizeOfSet,
	 * boolean isSetA, boolean isSetB, boolean isSetC) {
	 * 
	 * boolean elementFound = false; for (int index = 0; index < sizeOfSet; index++)
	 * { if (isSetA) {// for set A delete if (key == A[index]) {
	 * DeleteElement(index, sizeOfSet, isSetA, isSetB, isSetC); elementFound = true;
	 * break; } // end if } else if (isSetB) {// for set B delete if (key ==
	 * B[index]) { DeleteElement(index, sizeOfSet, isSetA, isSetB, isSetC);
	 * elementFound = true; break; } // end if } else if (isSetC) {// for set C
	 * delete if (key == C[index]) { DeleteElement(index, sizeOfSet, isSetA, isSetB,
	 * isSetC); elementFound = true; break; } // end if } // end if else } // end
	 * for
	 * 
	 * if (!elementFound) { System.out.println("Element not found"); } // end if }//
	 * end method
	 * 
	 * // clear method public void Clear(Object[] set, int sizeOfSet, boolean
	 * isSetA, boolean isSetB, boolean isSetC) { if (set == null) {
	 * System.out.println("Set is already empty"); return; } // end if
	 * 
	 * Object[] tempObjArray = new Object[set.length];
	 * 
	 * if (isSetA) { A = tempObjArray; A_Size = 0; } else if (isSetB) { B =
	 * tempObjArray; B_Size = 0; } else if (isSetC) { C = tempObjArray; C_Size = 0;
	 * } // end if else
	 * 
	 * }// end method
	 * 
	 * // size method public void Size(int sizeOfSet) {
	 * System.out.println("Set size: " + sizeOfSet); }// end method
	 * 
	 * // contains method public boolean Contains(T key, Object[] set, int
	 * sizeOfSet) { for (int index = 0; index < sizeOfSet; index++) { if (key ==
	 * set[index]) { return true; } // end if } // end for return false; }// end
	 * method
	 * 
	 * // // overload contains // public boolean Contains(T AKey, T BKey, int
	 * sizeOfSet) { // for (int index = 0; index < sizeOfSet; index++) { // if
	 * (setA[index] == setB[index]) { // return true; // } // end if // } // end for
	 * // return false; // }// end method
	 * 
	 * // union method public void Union(Object[] setA, Object[] setB) {//
	 * everything from A and B merge = C but no dups Object[] temp; int biggestSize
	 * = 0; int smallestSize = 0;
	 * 
	 * if (setA.length >= setB.length) { temp = new Object[setA.length]; biggestSize
	 * = A_Size; smallestSize = B_Size; } else { temp = new Object[setB.length];
	 * biggestSize = B_Size; smallestSize = A_Size; } // end if else
	 * 
	 * for (int index = 0; index < A_Size; index++) { T AKey = (T) A[index];
	 * 
	 * if (!Contains(AKey, setB, biggestSize)) { temp[index] = (Contains(AKey, setB,
	 * index));
	 * 
	 * } // end if } // end formatter
	 * 
	 * for (int indexA = 0; indexA < smallestSize; indexA++) { T AKey = (T)
	 * A[indexA];
	 * 
	 * for (int indexB = 0; indexB < biggestSize; indexB++) { T BKey = (T)
	 * B[indexB];
	 * 
	 * if (AKey != BKey) { } // end if } // end for } // end for
	 * 
	 * }// end method
	 * 
	 * // intersection method public void Intersection() {
	 * 
	 * }// end method
	 * 
	 * // difference method public void Difference() {
	 * 
	 * }// end method
	 * 
	 * // subset method public void Subset() {
	 * 
	 * }// end method
	 * 
	 * // equality method public void Equality() {
	 * 
	 * }// end method
	 * 
	 * // custom methods public void Display() { // prints set A
	 * System.out.print("Set A: "); for (int index = 0; index < A_Size; index++) {
	 * System.out.print("[" + A[index] + "]" + " -> "); } // end for
	 * System.out.print("[" + A_Size + "/" + A.length + "]\n");
	 * 
	 * // print set B System.out.print("Set B: "); for (int index = 0; index <
	 * B_Size; index++) { System.out.print("[" + B[index] + "]" + " -> "); } // end
	 * for System.out.print("[" + B_Size + "/" + B.length + "]\n");
	 * 
	 * // print set C System.out.print("Set C: "); for (int index = 0; index <
	 * C_Size; index++) { System.out.print("[" + C[index] + "]" + " -> "); } // end
	 * for System.out.print("[" + C_Size + "/" + C.length + "]\n"); }// end method
	 * 
	 * public void CheckArrayCapacity(Object[] set, int sizeOfSet, boolean isSetA,
	 * boolean isSetB) { if (set.length == sizeOfSet) { Object[] tempArray = new
	 * Object[sizeOfSet * 2];
	 * 
	 * for (int index = 0; index < sizeOfSet; index++) { tempArray[index] =
	 * set[index]; } // end for
	 * 
	 * if (isSetA) { A = tempArray; }else if (isSetB) { B = tempArray; }//end if
	 * else } // end if }// end method
	 * 
	 * public void DeleteElement(int indexOutSide, int sizeOfSet, boolean isSetA,
	 * boolean isSetB, boolean isSetC) { for (int index = indexOutSide; index <
	 * sizeOfSet; index++) { if (isSetA) { A[index] = A[index + 1]; } else if
	 * (isSetB) { B[index] = B[index + 1]; } else if (isSetC) { C[index] = C[index +
	 * 1]; } // end if else } // end if
	 * 
	 * if (isSetA) { A_Size--; } else if (isSetB) { B_Size--; } else if (isSetC) {
	 * C_Size--; } // end if else }// end method
	 */
}// end class

/*
	public static void SetPicker() {
		//@formatter:off
		System.out.print("\n" + 
						"━━━━━━━━━━━━━━━━━━━━━━━━━\n"+ 
						"┃ 【 1 】 Set A		┃\n" +
						"┃ 【 2 】 Set B 		┃\n" + 
						"┃ 【 3 】 Set C 		┃\n" + 
						"┃ 【 4 】 Exit 		┃\n" + 
						"━━━━━━━━━━━━━━━━━━━━━━━━━\n" + 
						"》 ");
		//@formatter:on
		switch (CheckUserInput()) {
		case 1:
			MenuChoices(setOps.getA(), setOps.getA_Size(), true, false, false);
			break;
		case 2:
			MenuChoices(setOps.getB(), setOps.getB_Size(), false, true, false);
			break;
		case 3:
			MenuChoices(setOps.getC(), setOps.getC_Size(), false, false, true);
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

	public static void MenuChoices(Object[] set, int sizeOfSet, boolean isSetA, boolean isSetB, boolean isSetC) {

		PrintMenuChoices();

		switch (CheckUserInput()) {
		case 1:// add
			System.out.print("Enter key to add: ");

			setOps.Add(CheckUserInput(), set, sizeOfSet, isSetA, isSetB, isSetC);
			setOps.Display();
			break;
		case 2:// remove
			System.out.println("size of set: " + sizeOfSet);
			if (sizeOfSet <= 0) {
				System.out.println("No element available in set to delete");
				break;
			} // end if

			System.out.print("Enter key to remove: ");

			setOps.Remove(CheckUserInput(), set, sizeOfSet, isSetA, isSetB, isSetC);
			setOps.Display();
			break;
		case 3:// contain
			if (sizeOfSet <= 0) {
				System.out.println("No element available in set to find");
				break;
			} // end if

			System.out.print("Enter key to find: ");
			setOps.Contains(CheckUserInput(), set, sizeOfSet);
			break;
		case 4:// size
			setOps.Size(sizeOfSet);
			break;
		case 5:// clear
			if (sizeOfSet <= 0) {
				System.out.println("Set is already empty.");
				break;
			} // end if

			System.out.println("Clearing set");
			setOps.Clear(set, sizeOfSet, isSetA, isSetB, isSetC);
			break;
		case 6:// set operations
			SetOperation();
			break;
		case 7:// display
			setOps.Display();
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
			MenuChoices(setOps.getA(), setOps.getA_Size(), isSetA, isSetB, isSetC);
		} else if (isSetB) {
			MenuChoices(setOps.getB(), setOps.getB_Size(), isSetA, isSetB, isSetC);
		} // end if else
	}// end method

	public static int CheckUserInput() {
		sc = new Scanner(System.in);

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
			set.Union();
			break;
		case 2:// intersection
			set.Intersection();
			break;
		case 3:// difference
			set.Difference();
			break;
		case 4:// subset check
			set.Subset();
			break;
		case 5:// equality check
			set.Equality();
			break;
		case 6:// <- back
			return;
		default:
			System.out.println("invalid input");
			break;
		}// switch

		SetOperation();
	}// end method
*/