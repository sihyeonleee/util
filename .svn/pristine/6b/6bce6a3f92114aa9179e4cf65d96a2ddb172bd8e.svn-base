package main.test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HookTest {
	
	static {
		
		String folderName = ".dll";
		
		Path currentRelativePath = Paths.get("");
		String path = currentRelativePath.toAbsolutePath().toString() + File.separator + folderName + File.separator + "test.dll";
        System.load(path);
        
    }
    
    private native int getNumber();
    private native void printHelloWorld();
    
    public static void main(String[] args){
    	HookTest jni = new HookTest();
    
        jni.printHelloWorld();
        
        System.out.println(jni.getNumber());
    }

}
