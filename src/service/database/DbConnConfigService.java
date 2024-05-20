package service.database;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.util.Map;

import comm.fileio.FileService;
import comm.fileio.TextFileReader;
import comm.fileio.TextFileWriter;
import comm.remote.DBConnection;
import gui.obj.CompObj;
import gui.obj.FrameObj;
import main.Main;
import service.Service;

public class DbConnConfigService extends Service{
	
	TextFileReader reader;
	
	DBConnection db = null;
	
	public DbConnConfigService(){
		// 프레임 설정
		width = 800;
		height = 800;
		layout = FrameObj.LAYOUT_GRIDBAG;
		
		// 컴포넌트설정
		CompObj output1 = new CompObj();
		output1.setMsg( "현재 연결 DB 정보 : " + "" );
		output1.setType(CompObj.TYPE_OUTPUT);
		output1.setGridPosition(0, 0);
		output1.setGridWeight(1, 1);
		output1.setArrangeType(GridBagConstraints.BOTH);
		componentObjs.add(output1);
		
		CompObj btn1 = new CompObj();
		btn1.setName("새 DB 연결");
		btn1.setEvtName("add");
		btn1.setType(CompObj.TYPE_BUTTON);
		btn1.setEventType(CompObj.EVENT_ACTION);
		btn1.setGridPosition(0, 1);
		btn1.setGridWeight(1, 1);
		btn1.setArrangeType(GridBagConstraints.BOTH);
		componentObjs.add(btn1);
		
		CompObj btn2 = new CompObj();
		btn2.setName("DB 연결 변경");
		btn2.setEvtName("modify");
		btn2.setType(CompObj.TYPE_BUTTON);
		btn2.setEventType(CompObj.EVENT_ACTION);
		btn2.setGridPosition(1, 1);
		btn2.setGridWeight(1, 1);
		btn2.setArrangeType(GridBagConstraints.BOTH);
		componentObjs.add(btn2);
		
		CompObj area1 = new CompObj();
		area1.setEnabled(false);
		area1.setType(CompObj.TYPE_TEXTAREA);
		area1.setScrollAt(true);
		area1.setCharY(30);
		area1.setCharX(50);
		area1.setGridSize(2, 1);
		area1.setGridWeight(30, 30);
		area1.setGridPosition(0, 2);
		area1.setArrangeType(GridBagConstraints.BOTH);
		componentObjs.add(area1);
	}
	
	@Override
	public void doShow(String name) {
		
		outputs.get(0).setFont(new Font("", Font.BOLD, 15));
		
		reader = new TextFileReader(comm.Path.ROOTPATH + FileService.PATH_DIRECTORY_PROP, FileService.PATH_FILE_DATABASE, FileService.EXEC_FILE_LSH);
		setMessage("textArea", 0, reader.reade());
		
		super.doShow(name);
	}
	
	@Override
	public void onEvent(String type, CompObj obj, Object...objects) throws Exception {
		if(type.equals("click") && "modify".equals(obj.getEvtName())){
			
			@SuppressWarnings("static-access")
			Map<String, Map<String, String>> result = reader.getKeyValueTypeDataToMap(reader.getText(), "\\[DB_INFO\\]", null);
			
			String[] selections = new String[result.size()];
			
			for(int i=0; i<result.size(); i++){
				Map<String, String> m = result.get(i+"");
				selections[i] = m.get("name");
			}
			
			String selectInfo = (String) Main.selectPop("DB연결 정보", db.getName(), selections);
			
			for(int i=0; i<selections.length; i++) {
				String selection = selections[i];
				if(selection.equals(selectInfo)) {
//					createDbObject(i);
					db.connection();
					if(db.isConnection()) {
						Main.alertPop("데이터베이스 변경", "DB변경 성공 : " + db.getName());
						setMessage( "output", 0, "현재 연결 DB 정보 : " + db.getName() );
					}else {
						Main.alertPop("데이터베이스 변경 실패", "DB변경 실패 : " + db.getName());
					}
					db.disConnection();
				}
			}
			
		}else if(type.equals("click") && "add".equals(obj.getEvtName())) {
			
			String[] inputStr = {
					  "name"
					, "url"
					, "driver"
					, "user"
					, "password"
			};
			
			Map<String, String> result = Main.confirmPop("새연결 DB", inputStr);
			
			if(result.get("result").equals("confirm")) {
				
				if(result.size()-1 == inputStr.length){
					String dbInfo = "\n\n[DB_INFO]";
					
					for(String str : inputStr){
						dbInfo += "\n" + str + "=" + result.get(str);
					}
					
					TextFileWriter writer = new TextFileWriter(comm.Path.ROOTPATH + FileService.PATH_DIRECTORY_PROP, FileService.PATH_FILE_DATABASE, FileService.EXEC_FILE_LSH, dbInfo);
					
					writer.write(true);
					
					reader = new TextFileReader(comm.Path.ROOTPATH + FileService.PATH_DIRECTORY_PROP, FileService.PATH_FILE_DATABASE, FileService.EXEC_FILE_LSH);
					setMessage("textArea", 0, reader.reade());
				}else {
					Main.alertPop("입력값을 확인해주세요.");
				}
			}
			
		}
	}
}
