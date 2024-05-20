package main.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class FileWriter {
	public static void main(String[] args) {
		
		File folder = new File("text");
		
		if(!folder.exists()){
			if(folder.mkdir()){
				System.out.println("폴더 생성 성공");
			}else {
				System.out.println("폴더 생성 실패");
			}
		}
		
		File file = new File("text" + File.separator + "test.txt");
		System.out.println("text" + File.separator + "test.txt");
		try {
			if(!file.exists()){
				if(file.createNewFile()){
					System.out.println("파일 생성 성공");
				}else {
					System.out.println("파일 생성 실패");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		String text = "asdfasdf";
		
		byte[] buffer = null;
		
		try {
			
			buffer = text.getBytes("utf-8");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		OutputStream out = null;
		// 파일이 없으면 파일을 만들면서, 오픈시킴
		try {
			out = new FileOutputStream("text" + File.separator + "test.txt", true);
			out.write(buffer);
			System.out.println("[INFO] 파일 저장됨 >> " + "text" + File.separator + "test.txt");
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] 저장 경로를 찾을 수 없습니다.");
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] 저장에 실패했습니다.");
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러가 발생했습니다.");
			//e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					System.out.println("파일 닫기 실패");
					//e.printStackTrace();
				}	// 파일 스트림 닫기
			}
		}
		
	}
}
