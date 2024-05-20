package main.test;

import org.apache.ibatis.session.SqlSession;

import comm.remote.DBConnection;

public class mybatis {
	
	public static void main(String[] args){
		DBConnection POC = new DBConnection("POC / 메인", "jdbc:mysql://ebsocprodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsocprodmysql", "esofedu");
		SqlSession s = POC.getSqlSession(false);
		s.insert("testSqlmap.selectTables");
	}
	
}
