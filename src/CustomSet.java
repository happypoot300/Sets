public class CustomSet<Type> {
	// class fields
	private Object[] elements;
	private int size;

	// getter setter

	public Object[] getElements() {
		return this.elements;
	}// end method

	public int getSize() {
		return this.size;
	}// end method

	public int setSize() {
		return this.size;
	}// end method

	// constructor
	public CustomSet() {
		int defaultSize = 5;
		size = 0;
		elements = new Object[defaultSize];
	}// end constructor

	// set choices
	// add method
	public <T> void Add(T key, String prompt) {
		if (Contains(key)) {
			System.out.print(prompt);
			return;
		} // end if

		CheckArrayCapacity();
		elements[size++] = key;
	}// end method

	// overload for intersection method
	public <T> void Add(String prompt, T key, CustomSet<Integer> setTemp) {
		if (Contains(key, setTemp.getElements(), setTemp.getSize())) {
			CheckArrayCapacity();
			elements[size++] = key;
			return;
		} // end if
		System.out.print(prompt);
	}// end method

	// overload for difference, subset and equality methods
	public <T> int Add(String prompt, CustomSet<Integer> setTemp, T key) {
		if (Contains(key, setTemp.getElements(), setTemp.getSize())) {
			System.out.print(prompt);
			return 1;
		} // end if

		CheckArrayCapacity();
		elements[size++] = key;
		return 0;
	}// end method

	// remove method
	public void Remove(Type key) {

		boolean elementFound = false;
		for (int index = 0; index < size; index++) {
			if (key == elements[index]) {
				DeleteElement(index);
				elementFound = true;
				break;
			} // end if
		} // end for

		if (!elementFound) {
			System.out.println("Element not found");
		} // end if
	}// end method

	// clear method
	public void Clear() {
		if (elements == null) {
			System.out.println("Set is already empty");
			return;
		} // end if

		Object[] tempObjArray = new Object[elements.length];

		elements = tempObjArray;
		size = 0;
	}// end method

	// size method
	public void Size() {
		System.out.println("Set size: " + size);
	}// end method

	// contains method
	public <T> boolean Contains(T key) {
		for (int index = 0; index < size; index++) {
			if (key == elements[index]) {
				return true;
			} // end if
		} // end for
		return false;
	}// end method

	// overload contains for intersection, difference, subset and equality
	public <T> boolean Contains(T key, T[] set, int sizeOfSet) {
		for (int index = 0; index < sizeOfSet; index++) {
			if (key == set[index]) {
				return true;
			} // end if
		} // end for
		return false;
	}// end method

	// union method
	public <T> void Union(T[] A, T[] B, int sizeOfA, int sizeOfB) {// everything from A and B merge = C but no dups
		CustomSet<Integer> setC = new CustomSet<>();

		for (int indexA = 0; indexA < sizeOfA; indexA++) {
			setC.Add(A[indexA], "");
		} // end for

		for (int indexB = 0; indexB < sizeOfB; indexB++) {
			setC.Add(B[indexB], "");
		} // end for

		System.out.print("Set C: ");
		setC.Display();
	}// end method

	// intersection method
	public <T> void Intersection(T[] A, T[] B, int sizeOfA, int sizeOfB) {
		CustomSet<Integer> tempSet = new CustomSet<>();
		CustomSet<Integer> setC = new CustomSet<>();

		for (int indexA = 0; indexA < sizeOfA; indexA++) {
			tempSet.Add(A[indexA], "");
		} // end for

		for (int indexB = 0; indexB < sizeOfB; indexB++) {
			setC.Add("", B[indexB], tempSet);
		} // end for

		System.out.print("Set C: ");
		setC.Display();
	}// end method

	// difference method
	public <T> void Difference(T[] A, T[] B, int sizeOfA, int sizeOfB) {

		CustomSet<Integer> tempSet = new CustomSet<>();
		CustomSet<Integer> setC = new CustomSet<>();

		for (int indexA = 0; indexA < sizeOfA; indexA++) {
			tempSet.Add(A[indexA], "");
		} // end for

		for (int indexB = 0; indexB < sizeOfB; indexB++) {
			setC.Add("", tempSet, B[indexB]);
		} // end for

		System.out.print("Set C: ");
		setC.Display();
	}// end method

	// subset method
	public <T> void Subset(T[] A, T[] B, int sizeOfA, int sizeOfB) {
		CustomSet<Integer> tempSet = new CustomSet<>();
		CustomSet<Integer> setC = new CustomSet<>();
		int pairOfElementsCounter = 0;

		for (int indexA = 0; indexA < sizeOfA; indexA++) {
			tempSet.Add(A[indexA], "");
		} // end for

		for (int indexB = 0; indexB < sizeOfB; indexB++) {
			pairOfElementsCounter += setC.Add("", tempSet, B[indexB]);
		} // end for

		System.out.println("Pair counter: " + pairOfElementsCounter);

		if (pairOfElementsCounter == sizeOfB) {
			System.out.println("B is Subset of A");
		} // end if
		System.out.print("Set C: ");
		setC.Display();

	}// end method

	// equality method
	public <T> void Equality(T[] A, T[] B, int sizeOfA, int sizeOfB) {

		CustomSet<Integer> tempSet = new CustomSet<>();
		CustomSet<Integer> setC = new CustomSet<>();
		int pairOfElementsCounter = 0;

		for (int indexA = 0; indexA < sizeOfA; indexA++) {
			tempSet.Add(A[indexA], "");
		} // end for

		for (int indexB = 0; indexB < sizeOfB; indexB++) {
			pairOfElementsCounter += setC.Add("", tempSet, B[indexB]);
		} // end for

		System.out.println("Pair counter: " + pairOfElementsCounter);

		if (pairOfElementsCounter == sizeOfB && sizeOfA == sizeOfB) {
			System.out.println("B is equal to A");
		} // end if

		System.out.print("Set C: ");
		setC.Display();
	}// end method

	// custom methods
	public void Display() {
		for (int index = 0; index < size; index++) {
			System.out.print("[" + elements[index] + "]" + " -> ");
		} // end for
		System.out.print("[" + size + "/" + elements.length + "]\n");
	}// end method

	public void CheckArrayCapacity() {
		if (elements.length == size) {
			Object[] tempArray = new Object[size * 2];

			for (int index = 0; index < size; index++) {
				tempArray[index] = elements[index];
			} // end for
			elements = tempArray;
		} // end if
	}// end method

	public void DeleteElement(int indexOutSide) {
		for (int index = indexOutSide; index < size; index++) {
			elements[index] = elements[index + 1];// mali pato

		} // end if
		size--;
	}// end method

	public void CreateSetNode() {
		System.out.print("E");
	}// end method

}// end class
