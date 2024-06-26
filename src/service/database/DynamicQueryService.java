package service.database;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;

import comm.CustomThread;
import comm.remote.DBConnection;
import gui.obj.CompObj;
import gui.obj.FrameObj;
import service.Service;

public class DynamicQueryService extends Service{
	
	DBConnection db = null;
	
	public DynamicQueryService() {
		
		// 프레임 설정
		width = 800;
		height = 800;
		layout = FrameObj.LAYOUT_GRIDBAG;
		
		// 컴포넌트설정
		CompObj input1 = new CompObj();
		input1.setHint("쿼리 입력");
		input1.setEvtName("query");
		input1.setType(CompObj.TYPE_INPUT);
		input1.setEventType(CompObj.EVENT_ACTION);
		input1.setGridPosition(0, 0);
		input1.setGridWeight(1, 1);
		input1.setArrangeType(GridBagConstraints.BOTH);
		componentObjs.add(input1);
		
		CompObj btn1 = new CompObj();
		btn1.setEvtName("run");
		btn1.setType(CompObj.TYPE_BUTTON);
		btn1.setEventType(CompObj.EVENT_ACTION);
		btn1.setGridPosition(1, 0);
		btn1.setGridWeight(1, 1);
		btn1.setArrangeType(GridBagConstraints.BOTH);
		componentObjs.add(btn1);
		
		CompObj area1 = new CompObj();
		area1.setType(CompObj.TYPE_TEXTAREA);
		area1.setScrollAt(true);
		area1.setCharY(30);
		area1.setCharX(50);
		area1.setGridSize(2, 1);
		area1.setGridWeight(30, 30);
		area1.setGridPosition(0, 1);
		area1.setArrangeType(GridBagConstraints.BOTH);
		componentObjs.add(area1);

//		createDbObject(0);
	}
	
	@Override
	public void doShow(String name) {
		
		JTextField input = inputs.get(0);
		
		input.setToolTipText("테이블 명 입력");
		
		input.setFont(new Font("", Font.BOLD, 20));
		
		super.doShow(name);
	}
	
	@Override
	public void onEvent(String type, CompObj obj, Object...objects) {
		
		// SHOW COLUMNS FROM TB_SUM_USER_INFO
		// SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'ebsesof2'
		// SELECT USER_ID FROM TB_SUM_USER_INFO WHERE USER_SN = 2
		runThread("DynamicQuery", false);
	}
	
	@Override
	public CustomThread createThread() {
		return new CustomThread(){
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				String query = inputs.get(0).getText();
				
				Map<String, Object> result = db.execute(DBConnection.EXECUTE_QUERY, query);
				
				List<Map<String, Object>> data = (List<Map<String, Object>>) result.get("data");
				
				this.setTotalProc(data.size());
				
				for(int i=0; i<data.size(); i++) {
					
					Map<String, Object> obj = data.get(i);
					
					for(Map.Entry<String, Object> elem : obj.entrySet()) {
						appendMessage( "textArea", 0, (String) elem.getKey() + " : " + elem.getValue() + "\n" );
					}
					
					appendMessage( "textArea", 0, "\n\n");
					
					this.setNowProc(i);
					
				}
			}
		};
	}
}
