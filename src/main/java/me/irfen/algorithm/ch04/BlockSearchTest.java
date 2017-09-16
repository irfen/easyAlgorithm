package me.irfen.algorithm.ch04;

public class BlockSearchTest {

	public static void main(String[] args) {
		int[] index = {10, 20, 30};
		BlockSearch blockSearch = new BlockSearch(index);
		
		blockSearch.insert(1);
		blockSearch.insert(12);
		blockSearch.insert(22);
		
		blockSearch.insert(9);
		blockSearch.insert(18);
		blockSearch.insert(23);
		
		blockSearch.insert(5);
		blockSearch.insert(15);
		blockSearch.insert(27);
		
		blockSearch.printAll();
		
		System.out.println(blockSearch.search(18));
		System.out.println(blockSearch.search(29));
	}
}
