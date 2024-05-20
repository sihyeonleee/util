package comm;

import java.util.ArrayList;
import java.util.List;

public class RunnableConfig {
	
	// Runnable Argument SET : -DServer.mode=DEV
	// Command Line Run : java -DServer.mode=DEV -jar .\\utillService_1_1_0.jar
	
	/*
	 * 개발 서비스
	 * */ 
	@SuppressWarnings("rawtypes")
	public static List<ArrayList<String>> getDevServiceList(){
		List<ArrayList<String>> list = new ArrayList<>();
		
		ArrayList<String> names = new ArrayList<>();
		ArrayList<String> events = new ArrayList<>();
		
		names.add("File Manager"		  ); events.add("manager.FileManager"	 );
		names.add("Task Manager"		  ); events.add("manager.TaskManager"	 );
//		names.add("Learning Manager"	  ); events.add("manager.LearningManager");
//		names.add("TEXT Manager"		  ); events.add("manager.TextManager"	 );
		
		names.add("File Path Copy"        ); events.add("write.FilePathCopy"     );
//		names.add("Text File Convert"     ); events.add("write.TextFileConvert"  );
//		names.add("Text To Excel" /*#*/   ); events.add("write.TextToExcel"      );
//		names.add("Xcel Files Merge" /*#*/); events.add("write.XcelFilesMerge"   );
		
		names.add("Table Col To Src"      ); events.add("database.ColToVariable" );
//		names.add("Prpr Type Query"       ); events.add("database.PrprQueryExc"  );
		
//		names.add("Macro"                 ); events.add("manager.SystemMacro"    );
//		names.add("FFFF"                  ); events.add("ffff.FFFF"              );
		names.add("---------------------" ); events.add("---------------------"  );
//		names.add("ebs"                   ); events.add("tmp.EBS"                );
		names.add("통계"                   ); events.add("tmp.AVG"                );
//		names.add("민원"                   ); events.add("tmp.Cmpln"              );
		names.add("계산"                   ); events.add("tmp.CALC"               );
		names.add("---------------------" ); events.add("---------------------"  );
		names.add("Log"                   ); events.add("config.Logger"          );
		names.add("Workspace"             ); events.add("config.Path"            );
		names.add("종료"                   ); events.add("config.Exit"            );
		
		list.add(names);
		list.add(events);
		
		return list;
	}
	
	/*
	 * 운영 서비스
	 * */ 
	@SuppressWarnings("rawtypes")
	public static List<ArrayList<String>> getOprServiceList(){
		List<ArrayList<String>> list = new ArrayList<>();
		
		ArrayList<String> names = new ArrayList<>();
		ArrayList<String> events = new ArrayList<>();
		
		names.add("파일관리"				 ); events.add("manager.FileManager"  );
		names.add("파일복사"				 ); events.add("write.FilePathCopy"   );
//		names.add("온클민원"				 ); events.add("tmp.Cmpln"            );
		names.add("---------------------"); events.add("---------------------");
//		names.add("통계"					 ); events.add("tmp.AVG"              );
		names.add("계산"					 ); events.add("tmp.CALC"             );
		names.add("Log"					 ); events.add("config.Logger"        );
		names.add("Workspace"			 ); events.add("config.Path"          );
		names.add("종료"					 ); events.add("config.Exit"          );
		
		list.add(names);
		list.add(events);
		
		return list;
	}
	
	
}
