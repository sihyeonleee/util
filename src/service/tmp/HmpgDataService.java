package service.tmp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comm.remote.DBConnection;

public class HmpgDataService {

	public static List<Map<String,Object>> hmpgOperList = new ArrayList<Map<String,Object>>();
	public static int hmpgOperCnt = 0;
	
	public static void main(String[] args) {
		
		List<DBConnection> connectionList = getConnectionList();
		
		for( DBConnection dbCon : connectionList ){
			
			Thread t = new Thread(){
				@Override
				public void run() {
					insertHmpgOper( dbCon );
					
					hmpgOperCnt++;
					
					if(hmpgOperCnt >= connectionList.size()){
						System.out.println(hmpgOperList);
						
						if( hmpgOperList != null && hmpgOperList.size() > 0 ){
							for(Map<String,Object> hmpgOperMap : hmpgOperList){
								
								//해당 host에 insert 작업
								
								
							}
						}
						
						
					}
					
				}
			};
			t.start();
			
		}
		
	}
	
	
	public static List<DBConnection> getConnectionList(){
		
		List<DBConnection> allDbs = new ArrayList<DBConnection>();
		
		allDbs.add(new DBConnection("oc1", "P", "jdbc:mysql://ebsoc1prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc1prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc2", "M", "jdbc:mysql://ebsoc2prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc2prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc3", "M", "jdbc:mysql://ebsoc3prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc3prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc4", "M", "jdbc:mysql://ebsoc4prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc4prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc5", "M", "jdbc:mysql://ebsoc5prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc5prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc6", "M", "jdbc:mysql://ebsoc6prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc6prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc7", "M", "jdbc:mysql://ebsoc7prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc7prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc8", "M", "jdbc:mysql://ebsoc8prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc8prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc9", "M", "jdbc:mysql://ebsoc9prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc9prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc10", "P", "jdbc:mysql://ebsoc10prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc10prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc11", "P", "jdbc:mysql://ebsoc11prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc11prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc12", "P", "jdbc:mysql://ebsoc12prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc12prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc13", "P", "jdbc:mysql://ebsoc13prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc13prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc14", "P", "jdbc:mysql://ebsoc14prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc14prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc15", "M", "jdbc:mysql://ebsoc15prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc15prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc16", "M", "jdbc:mysql://ebsoc16prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc16prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc17", "M", "jdbc:mysql://ebsoc17prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc17prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc18", "M", "jdbc:mysql://ebsoc18prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc18prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc19", "M", "jdbc:mysql://ebsoc19prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc19prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc20", "M", "jdbc:mysql://ebsoc20prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc20prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc21", "M", "jdbc:mysql://ebsoc21prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc21prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc22", "M", "jdbc:mysql://ebsoc22prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc22prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc23", "M", "jdbc:mysql://ebsoc23prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc23prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc24", "M", "jdbc:mysql://ebsoc24prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc24prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc25", "M", "jdbc:mysql://ebsoc25prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc25prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc26", "M", "jdbc:mysql://ebsoc26prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc26prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc27", "M", "jdbc:mysql://ebsoc27prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc27prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc28", "M", "jdbc:mysql://ebsoc28prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc28prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc29", "M", "jdbc:mysql://ebsoc29prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc29prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc30", "M", "jdbc:mysql://ebsoc30prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc30prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc31", "M", "jdbc:mysql://ebsoc31prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc31prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc32", "M", "jdbc:mysql://ebsoc32prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc32prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc33", "M", "jdbc:mysql://ebsoc33prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc33prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc34", "M", "jdbc:mysql://ebsoc34prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc34prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc35", "M", "jdbc:mysql://ebsoc35prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc35prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc36", "M", "jdbc:mysql://ebsoc36prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc36prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc37", "M", "jdbc:mysql://ebsoc37prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc37prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc38", "M", "jdbc:mysql://ebsoc38prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc38prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc39", "M", "jdbc:mysql://ebsoc39prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc39prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc40", "M", "jdbc:mysql://ebsoc40prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc40prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc41", "M", "jdbc:mysql://ebsoc41prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc41prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc42", "M", "jdbc:mysql://ebsoc42prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc42prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc43", "M", "jdbc:mysql://ebsoc43prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc43prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc44", "M", "jdbc:mysql://ebsoc44prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc44prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc45", "M", "jdbc:mysql://ebsoc45prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc45prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc46", "M", "jdbc:mysql://ebsoc46prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc46prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc47", "M", "jdbc:mysql://ebsoc47prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc47prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc48", "M", "jdbc:mysql://ebsoc48prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc48prodmysql", "esofedu"));
		allDbs.add(new DBConnection("oc49", "M", "jdbc:mysql://ebsoc49prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc49prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc1", "H", "jdbc:mysql://ebshoc1prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc1prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc2", "H", "jdbc:mysql://ebshoc2prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc2prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc3", "H", "jdbc:mysql://ebshoc3prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc3prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc4", "H", "jdbc:mysql://ebshoc4prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc4prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc5", "H", "jdbc:mysql://ebshoc5prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc5prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc6", "H", "jdbc:mysql://ebshoc6prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc6prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc7", "H", "jdbc:mysql://ebshoc7prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc7prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc8", "H", "jdbc:mysql://ebshoc8prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc8prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc9", "H", "jdbc:mysql://ebshoc9prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc9prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc10", "H", "jdbc:mysql://ebshoc10prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc10prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc11", "H", "jdbc:mysql://ebshoc11prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc11prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc12", "H", "jdbc:mysql://ebshoc12prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc12prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc13", "H", "jdbc:mysql://ebshoc13prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc13prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc14", "H", "jdbc:mysql://ebshoc14prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc14prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc15", "H", "jdbc:mysql://ebshoc15prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc15prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc16", "H", "jdbc:mysql://ebshoc16prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc16prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc17", "H", "jdbc:mysql://ebshoc17prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc17prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc18", "H", "jdbc:mysql://ebshoc18prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc18prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc19", "H", "jdbc:mysql://ebshoc19prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc19prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc20", "H", "jdbc:mysql://ebshoc20prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc20prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc21", "H", "jdbc:mysql://ebshoc21prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc21prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc22", "H", "jdbc:mysql://ebshoc22prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc22prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc23", "H", "jdbc:mysql://ebshoc23prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc23prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc24", "H", "jdbc:mysql://ebshoc24prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc24prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc25", "H", "jdbc:mysql://ebshoc25prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc25prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc26", "H", "jdbc:mysql://ebshoc26prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc26prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc27", "H", "jdbc:mysql://ebshoc27prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc27prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc28", "H", "jdbc:mysql://ebshoc28prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc28prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc29", "H", "jdbc:mysql://ebshoc29prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc29prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc30", "H", "jdbc:mysql://ebshoc30prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc30prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc31", "H", "jdbc:mysql://ebshoc31prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc31prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc32", "H", "jdbc:mysql://ebshoc32prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc32prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc33", "H", "jdbc:mysql://ebshoc33prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc33prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc34", "H", "jdbc:mysql://ebshoc34prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc34prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc35", "H", "jdbc:mysql://ebshoc35prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc35prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc36", "H", "jdbc:mysql://ebshoc36prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc36prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc37", "H", "jdbc:mysql://ebshoc37prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc37prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc38", "H", "jdbc:mysql://ebshoc38prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc38prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc39", "H", "jdbc:mysql://ebshoc39prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc39prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc40", "H", "jdbc:mysql://ebshoc40prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc40prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc41", "H", "jdbc:mysql://ebshoc41prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc41prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc42", "H", "jdbc:mysql://ebshoc42prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc42prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc43", "H", "jdbc:mysql://ebshoc43prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc43prodmysql", "esofedu"));
		allDbs.add(new DBConnection("hoc44", "H", "jdbc:mysql://ebshoc44prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc44prodmysql", "esofedu"));
		allDbs.add(new DBConnection("dg1", "H", "jdbc:mysql://ebshoc45prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc45prodmysql", "esofedu"));
		allDbs.add(new DBConnection("dg2", "H", "jdbc:mysql://ebshoc46prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc46prodmysql", "esofedu"));
		allDbs.add(new DBConnection("dg3", "H", "jdbc:mysql://ebshoc47prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc47prodmysql", "esofedu"));
		allDbs.add(new DBConnection("dg4", "H", "jdbc:mysql://ebshoc48prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc48prodmysql", "esofedu"));
		allDbs.add(new DBConnection("dg5", "H", "jdbc:mysql://ebshoc49prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc49prodmysql", "esofedu"));
		
		return allDbs;
		
	}
	
	
	public static void insertHmpgOper( DBConnection dbCon ){
		
		
		StringBuffer querySb = new StringBuffer();
		
		/**
		 * 온라인클래스 개설
		 */
		querySb.append(" SELECT b.*, c.*");
		querySb.append(" FROM tb_lem_hmpg_oper b");
		querySb.append(" INNER JOIN tb_scm_schul c");
		querySb.append(" ON b.SCHUL_CODE = c.SCHUL_CODE");
		querySb.append(" WHERE c.HOST != ?");
		querySb.append(" AND b.FRST_REGIST_PNTTM >= '2020-04-10'");
		querySb.append(" ;");
		
		
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> resultList = (List<Map<String, Object>>) dbCon.execute(1, querySb.toString(), dbCon.getName()).get("data");
		
		if( resultList != null ){
			for( Map<String, Object> resultMap : resultList ){
//				System.out.println(dbCon.getName() + " HMPG_OPER_SN ::: " + resultMap.get("HMPG_OPER_SN"));
				resultMap.put("dbCon.getName()", dbCon.getName());
				hmpgOperList.add(resultMap);
			}
		}
		
		
		
	}
	
	

}
