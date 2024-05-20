package main.test;

import java.util.HashMap;
import java.util.Map;

import comm.fileio.FileService;
import comm.fileio.TextFileReader;

public class PropReader {
	public static void main(String[] args){
		
		TextFileReader reader = new TextFileReader(FileService.PATH_DIRECTORY_PROP, FileService.PATH_FILE_DATABASE, FileService.EXEC_FILE_LSH);
		String dbFile = reader.reade();
		
		String[] dbInfos = dbFile.split("DB_INFO");
		String[] dbInfo = dbInfos[ 1 ].split("\n");
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		for(String info : dbInfo){
			String[] value = info.split("=");
			
			if(value.length > 1){
				map.put(value[0], value[1].trim());
			}else {
				
			}
			
		}
		
		System.out.println(map.get("name"));
		System.out.println(map.get("driver"));
		System.out.println(map.get("url"));
		System.out.println(map.get("user"));
		System.out.println(map.get("password"));
		
	}
}
