package main.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativePath {
	public void test(){
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		System.out.println("Current relative path is: " + s);
	}
}
