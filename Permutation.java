

public class Permutation {

	static void swap(char[] a, int index1, int index2) {
		char temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}

	static void permute(char[] a, int startIndex, int endIndex) {
		if (startIndex == endIndex) {
			System.out.println(a);
		} else {
			for (int i = startIndex; i <= endIndex; i++) {
				swap(a,i, startIndex);
				permute(a, startIndex + 1, endIndex);
			swap(a,i, startIndex);
			}
		}
	}

	public static void main(String args[]) {
		char[] a = { 'a', 'b', 'c','d' };
		permute(a, 0, a.length - 1);

	}

}
