package DataStructures;

public class HashSet {

	private boolean[] arr = new boolean[1001];
	
	public void add(int key) {
		arr[key] = true;
	}

	public void delete(int key) {
		arr[key] = false;
	}

	public boolean contains(int key) {
		return arr[key];
	}
}