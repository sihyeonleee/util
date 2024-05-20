package main.test;

import java.util.HashMap;
import java.util.Map;

public class MultiKeyMap {
	public static void main(String args[]){
		
		Map<String, String> keySet = new HashMap<>();
		
		keySet.put("q1", "qq");
		keySet.put("q2", "qq");
		keySet.put("q3", "qq");
		keySet.put("w1", "ww");
		keySet.put("e2", "ee");
		keySet.put("e3", "ee");
		
		
		Map<String, String> data = new HashMap<>();
		
		data.put("qq", "1");
		data.put("ww", "2");
		data.put("ee", "3");
		data.put("rr", "4");
		data.put("tt", "5");
		data.put("yy", "6");
		
		System.out.println(data.get(keySet.get("e2")));
		
	}
}
