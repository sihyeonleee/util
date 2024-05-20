package main.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraySort {
	public static void main(String[] args){
		
		test[] t = new test[5];
		
		t[0] = new test("test5", 1);
		t[1] = new test("test3", 3);
		t[2] = new test("test1", 5);
		t[3] = new test("test2", 4);
		t[4] = new test("test4", 2);
		
		// Arrays.sort(t, Comparator.comparing(test::getName).reversed());
		
		Arrays.sort(t, new Comparator<test>() {
			@Override
			public int compare(test o1, test o2) {
				return o1.getAge() < o2.getAge() ? -1 : o1.getAge() == o2.getAge() ? 0 : 1;
			}
		});
		
		List<test> l = new ArrayList<test>(Arrays.asList(t));
		
		System.out.println(l.toString());
		
	}
	
}

class test{
	
	public String name;
	public int age;
	
	public test(String name, int age){
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return getAge() + "";
	}
	
}
