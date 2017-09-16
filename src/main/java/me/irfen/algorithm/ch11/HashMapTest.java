package me.irfen.algorithm.ch11;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>(2);
		map.put("a", "A");
		map.put("b", "B");
		map.put("c", "C");
		map.put("d", "D");
		map.put("e", "E");
		map.put("f", "F");
		map.put("g", "G");
		
		System.out.println(map.get("a"));
		System.out.println(map.get("b"));
		System.out.println(map.get("c"));
		System.out.println(map.get("d"));
		System.out.println(map.get("e"));
		System.out.println(map.get("f"));
		System.out.println(map.get("g"));
	}
}
