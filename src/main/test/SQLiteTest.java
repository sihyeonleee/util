package main.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import comm.remote.DBConnection;

public class SQLiteTest {
	
	public static void main(String[] args){
		
		String fileName = "D:/lee/t.db";
		
		DBConnection db = new DBConnection("test", "jdbc:sqlite://" + fileName, DBConnection.SQLITE, "", "");
		try{
			
			SqlSession s = db.getSqlSession(false);
			List<Map<String, Object>> list = s.selectList("common.selectTables");
			
			if(list.size() > 0){
				for(Map<String, Object> map : list){
					String test = (String) map.get("name");
					
					if(test == null){
						s.insert("common.createTables");
						s.commit();
						List<Map<String, Object>> list2 = s.selectList("common.selectTables");
						System.out.println(list2);
					}else if(test.equals("test")){
						System.out.println("테이블 목록");
						System.out.println(list);
					}
				}
			}else {
				s.insert("common.createTables");
				s.commit();
				List<Map<String, Object>> list2 = s.selectList("common.selectTables");
				System.out.println(list2);
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
