package service.tmp; 

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.apache.ibatis.session.SqlSession;

import comm.CustomThread;
import comm.Path;
import comm.fileio.ExcelFileWriter;
import comm.remote.DBConnection;
import gui.obj.CompObj;
import gui.obj.FrameObj;
import main.Main;
import service.Service;  

public class CmplnService extends Service{ 
	
	Map<String, DBConnection> db = new HashMap<>();
	
	DBConnection esof = new DBConnection("esof", "jdbc:mysql://ebsesofprodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsesofprodmysql", "eduesof");
	DBConnection oc = new DBConnection("oc", "jdbc:mysql://ebsocprodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsocprodmysql", "esofedu");
	DBConnection hoc = new DBConnection("hoc", "jdbc:mysql://ebshocprodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshocprodmysql", "esofedu");
	DBConnection oc1 = new DBConnection("oc1", "P", "jdbc:mysql://ebsoc1prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc1prodmysql", "esofedu");
	DBConnection oc2 = new DBConnection("oc2", "M", "jdbc:mysql://ebsoc2prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc2prodmysql", "esofedu");
	DBConnection oc3 = new DBConnection("oc3", "M", "jdbc:mysql://ebsoc3prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc3prodmysql", "esofedu");
	DBConnection oc4 = new DBConnection("oc4", "M", "jdbc:mysql://ebsoc4prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc4prodmysql", "esofedu");
	DBConnection oc5 = new DBConnection("oc5", "M", "jdbc:mysql://ebsoc5prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc5prodmysql", "esofedu");
	DBConnection oc6 = new DBConnection("oc6", "M", "jdbc:mysql://ebsoc6prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc6prodmysql", "esofedu");
	DBConnection oc7 = new DBConnection("oc7", "M", "jdbc:mysql://ebsoc7prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc7prodmysql", "esofedu");
	DBConnection oc8 = new DBConnection("oc8", "M", "jdbc:mysql://ebsoc8prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc8prodmysql", "esofedu");
	DBConnection oc9 = new DBConnection("oc9", "M", "jdbc:mysql://ebsoc9prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc9prodmysql", "esofedu");
	DBConnection oc10 = new DBConnection("oc10", "P", "jdbc:mysql://ebsoc10prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc10prodmysql", "esofedu");
	DBConnection oc11 = new DBConnection("oc11", "P", "jdbc:mysql://ebsoc11prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc11prodmysql", "esofedu");
	DBConnection oc12 = new DBConnection("oc12", "P", "jdbc:mysql://ebsoc12prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc12prodmysql", "esofedu");
	DBConnection oc13 = new DBConnection("oc13", "P", "jdbc:mysql://ebsoc13prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc13prodmysql", "esofedu");
	DBConnection oc14 = new DBConnection("oc14", "P", "jdbc:mysql://ebsoc14prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc14prodmysql", "esofedu");
	DBConnection oc15 = new DBConnection("oc15", "M", "jdbc:mysql://ebsoc15prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc15prodmysql", "esofedu");
	DBConnection oc16 = new DBConnection("oc16", "M", "jdbc:mysql://ebsoc16prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc16prodmysql", "esofedu");
	DBConnection oc17 = new DBConnection("oc17", "M", "jdbc:mysql://ebsoc17prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc17prodmysql", "esofedu");
	DBConnection oc18 = new DBConnection("oc18", "M", "jdbc:mysql://ebsoc18prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc18prodmysql", "esofedu");
	DBConnection oc19 = new DBConnection("oc19", "M", "jdbc:mysql://ebsoc19prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc19prodmysql", "esofedu");
	DBConnection oc20 = new DBConnection("oc20", "M", "jdbc:mysql://ebsoc20prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc20prodmysql", "esofedu");
	DBConnection oc21 = new DBConnection("oc21", "M", "jdbc:mysql://ebsoc21prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc21prodmysql", "esofedu");
	DBConnection oc22 = new DBConnection("oc22", "M", "jdbc:mysql://ebsoc22prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc22prodmysql", "esofedu");
	DBConnection oc23 = new DBConnection("oc23", "M", "jdbc:mysql://ebsoc23prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc23prodmysql", "esofedu");
	DBConnection oc24 = new DBConnection("oc24", "M", "jdbc:mysql://ebsoc24prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc24prodmysql", "esofedu");
	DBConnection oc25 = new DBConnection("oc25", "M", "jdbc:mysql://ebsoc25prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc25prodmysql", "esofedu");
	DBConnection oc26 = new DBConnection("oc26", "M", "jdbc:mysql://ebsoc26prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc26prodmysql", "esofedu");
	DBConnection oc27 = new DBConnection("oc27", "M", "jdbc:mysql://ebsoc27prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc27prodmysql", "esofedu");
	DBConnection oc28 = new DBConnection("oc28", "M", "jdbc:mysql://ebsoc28prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc28prodmysql", "esofedu");
	DBConnection oc29 = new DBConnection("oc29", "M", "jdbc:mysql://ebsoc29prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc29prodmysql", "esofedu");
	DBConnection oc30 = new DBConnection("oc30", "M", "jdbc:mysql://ebsoc30prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc30prodmysql", "esofedu");
	DBConnection oc31 = new DBConnection("oc31", "M", "jdbc:mysql://ebsoc31prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc31prodmysql", "esofedu");
	DBConnection oc32 = new DBConnection("oc32", "M", "jdbc:mysql://ebsoc32prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc32prodmysql", "esofedu");
	DBConnection oc33 = new DBConnection("oc33", "M", "jdbc:mysql://ebsoc33prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc33prodmysql", "esofedu");
	DBConnection oc34 = new DBConnection("oc34", "M", "jdbc:mysql://ebsoc34prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc34prodmysql", "esofedu");
	DBConnection oc35 = new DBConnection("oc35", "M", "jdbc:mysql://ebsoc35prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc35prodmysql", "esofedu");
	DBConnection oc36 = new DBConnection("oc36", "M", "jdbc:mysql://ebsoc36prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc36prodmysql", "esofedu");
	DBConnection oc37 = new DBConnection("oc37", "M", "jdbc:mysql://ebsoc37prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc37prodmysql", "esofedu");
	DBConnection oc38 = new DBConnection("oc38", "M", "jdbc:mysql://ebsoc38prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc38prodmysql", "esofedu");
	DBConnection oc39 = new DBConnection("oc39", "M", "jdbc:mysql://ebsoc39prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc39prodmysql", "esofedu");
	DBConnection oc40 = new DBConnection("oc40", "M", "jdbc:mysql://ebsoc40prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc40prodmysql", "esofedu");
	DBConnection oc41 = new DBConnection("oc41", "M", "jdbc:mysql://ebsoc41prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc41prodmysql", "esofedu");
	DBConnection oc42 = new DBConnection("oc42", "M", "jdbc:mysql://ebsoc42prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc42prodmysql", "esofedu");
	DBConnection oc43 = new DBConnection("oc43", "M", "jdbc:mysql://ebsoc43prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc43prodmysql", "esofedu");
	DBConnection oc44 = new DBConnection("oc44", "M", "jdbc:mysql://ebsoc44prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc44prodmysql", "esofedu");
	DBConnection oc45 = new DBConnection("oc45", "M", "jdbc:mysql://ebsoc45prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc45prodmysql", "esofedu");
	DBConnection oc46 = new DBConnection("oc46", "M", "jdbc:mysql://ebsoc46prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc46prodmysql", "esofedu");
	DBConnection oc47 = new DBConnection("oc47", "M", "jdbc:mysql://ebsoc47prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc47prodmysql", "esofedu");
	DBConnection oc48 = new DBConnection("oc48", "M", "jdbc:mysql://ebsoc48prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc48prodmysql", "esofedu");
	DBConnection oc49 = new DBConnection("oc49", "M", "jdbc:mysql://ebsoc49prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc49prodmysql", "esofedu");
	DBConnection oc50 = new DBConnection("oc50", "P", "jdbc:mysql://ebsoc50prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc50prodmysql", "esofedu");
	DBConnection hoc1 = new DBConnection("hoc1", "H", "jdbc:mysql://ebshoc1prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc1prodmysql", "esofedu");
	DBConnection hoc2 = new DBConnection("hoc2", "H", "jdbc:mysql://ebshoc2prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc2prodmysql", "esofedu");
	DBConnection hoc3 = new DBConnection("hoc3", "H", "jdbc:mysql://ebshoc3prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc3prodmysql", "esofedu");
	DBConnection hoc4 = new DBConnection("hoc4", "H", "jdbc:mysql://ebshoc4prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc4prodmysql", "esofedu");
	DBConnection hoc5 = new DBConnection("hoc5", "H", "jdbc:mysql://ebshoc5prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc5prodmysql", "esofedu");
	DBConnection hoc6 = new DBConnection("hoc6", "H", "jdbc:mysql://ebshoc6prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc6prodmysql", "esofedu");
	DBConnection hoc7 = new DBConnection("hoc7", "H", "jdbc:mysql://ebshoc7prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc7prodmysql", "esofedu");
	DBConnection hoc8 = new DBConnection("hoc8", "H", "jdbc:mysql://ebshoc8prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc8prodmysql", "esofedu");
	DBConnection hoc9 = new DBConnection("hoc9", "H", "jdbc:mysql://ebshoc9prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc9prodmysql", "esofedu");
	DBConnection hoc10 = new DBConnection("hoc10", "H", "jdbc:mysql://ebshoc10prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc10prodmysql", "esofedu");
	DBConnection hoc11 = new DBConnection("hoc11", "H", "jdbc:mysql://ebshoc11prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc11prodmysql", "esofedu");
	DBConnection hoc12 = new DBConnection("hoc12", "H", "jdbc:mysql://ebshoc12prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc12prodmysql", "esofedu");
	DBConnection hoc13 = new DBConnection("hoc13", "H", "jdbc:mysql://ebshoc13prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc13prodmysql", "esofedu");
	DBConnection hoc14 = new DBConnection("hoc14", "H", "jdbc:mysql://ebshoc14prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc14prodmysql", "esofedu");
	DBConnection hoc15 = new DBConnection("hoc15", "H", "jdbc:mysql://ebshoc15prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc15prodmysql", "esofedu");
	DBConnection hoc16 = new DBConnection("hoc16", "H", "jdbc:mysql://ebshoc16prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc16prodmysql", "esofedu");
	DBConnection hoc17 = new DBConnection("hoc17", "H", "jdbc:mysql://ebshoc17prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc17prodmysql", "esofedu");
	DBConnection hoc18 = new DBConnection("hoc18", "H", "jdbc:mysql://ebshoc18prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc18prodmysql", "esofedu");
	DBConnection hoc19 = new DBConnection("hoc19", "H", "jdbc:mysql://ebshoc19prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc19prodmysql", "esofedu");
	DBConnection hoc20 = new DBConnection("hoc20", "H", "jdbc:mysql://ebshoc20prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc20prodmysql", "esofedu");
	DBConnection hoc21 = new DBConnection("hoc21", "H", "jdbc:mysql://ebshoc21prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc21prodmysql", "esofedu");
	DBConnection hoc22 = new DBConnection("hoc22", "H", "jdbc:mysql://ebshoc22prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc22prodmysql", "esofedu");
	DBConnection hoc23 = new DBConnection("hoc23", "H", "jdbc:mysql://ebshoc23prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc23prodmysql", "esofedu");
	DBConnection hoc24 = new DBConnection("hoc24", "H", "jdbc:mysql://ebshoc24prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc24prodmysql", "esofedu");
	DBConnection hoc25 = new DBConnection("hoc25", "H", "jdbc:mysql://ebshoc25prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc25prodmysql", "esofedu");
	DBConnection hoc26 = new DBConnection("hoc26", "H", "jdbc:mysql://ebshoc26prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc26prodmysql", "esofedu");
	DBConnection hoc27 = new DBConnection("hoc27", "H", "jdbc:mysql://ebshoc27prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc27prodmysql", "esofedu");
	DBConnection hoc28 = new DBConnection("hoc28", "H", "jdbc:mysql://ebshoc28prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc28prodmysql", "esofedu");
	DBConnection hoc29 = new DBConnection("hoc29", "H", "jdbc:mysql://ebshoc29prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc29prodmysql", "esofedu");
	DBConnection hoc30 = new DBConnection("hoc30", "H", "jdbc:mysql://ebshoc30prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc30prodmysql", "esofedu");
	DBConnection hoc31 = new DBConnection("hoc31", "H", "jdbc:mysql://ebshoc31prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc31prodmysql", "esofedu");
	DBConnection hoc32 = new DBConnection("hoc32", "H", "jdbc:mysql://ebshoc32prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc32prodmysql", "esofedu");
	DBConnection hoc33 = new DBConnection("hoc33", "H", "jdbc:mysql://ebshoc33prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc33prodmysql", "esofedu");
	DBConnection hoc34 = new DBConnection("hoc34", "H", "jdbc:mysql://ebshoc34prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc34prodmysql", "esofedu");
	DBConnection hoc35 = new DBConnection("hoc35", "H", "jdbc:mysql://ebshoc35prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc35prodmysql", "esofedu");
	DBConnection hoc36 = new DBConnection("hoc36", "H", "jdbc:mysql://ebshoc36prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc36prodmysql", "esofedu");
	DBConnection hoc37 = new DBConnection("hoc37", "H", "jdbc:mysql://ebshoc37prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc37prodmysql", "esofedu");
	DBConnection hoc38 = new DBConnection("hoc38", "H", "jdbc:mysql://ebshoc38prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc38prodmysql", "esofedu");
	DBConnection hoc39 = new DBConnection("hoc39", "H", "jdbc:mysql://ebshoc39prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc39prodmysql", "esofedu");
	DBConnection hoc40 = new DBConnection("hoc40", "H", "jdbc:mysql://ebshoc40prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc40prodmysql", "esofedu");
	DBConnection hoc41 = new DBConnection("hoc41", "H", "jdbc:mysql://ebshoc41prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc41prodmysql", "esofedu");
	DBConnection hoc42 = new DBConnection("hoc42", "H", "jdbc:mysql://ebshoc42prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc42prodmysql", "esofedu");
	DBConnection hoc43 = new DBConnection("hoc43", "H", "jdbc:mysql://ebshoc43prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc43prodmysql", "esofedu");
	DBConnection hoc44 = new DBConnection("hoc44", "H", "jdbc:mysql://ebshoc44prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc44prodmysql", "esofedu");
	DBConnection hoc45 = new DBConnection("hoc45", "H", "jdbc:mysql://ebshoc45prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc45prodmysql", "esofedu");
	DBConnection hoc46 = new DBConnection("hoc46", "H", "jdbc:mysql://ebshoc46prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc46prodmysql", "esofedu");
	DBConnection hoc47 = new DBConnection("hoc47", "H", "jdbc:mysql://ebshoc47prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc47prodmysql", "esofedu");
	DBConnection hoc48 = new DBConnection("hoc48", "H", "jdbc:mysql://ebshoc48prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc48prodmysql", "esofedu");
	DBConnection hoc49 = new DBConnection("hoc49", "H", "jdbc:mysql://ebshoc49prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebshoc49prodmysql", "esofedu");
	
	private String cityDflt = "도시";
	private String areaDflt = "지역";
	private String levelDflt = "초중고";
	private String schulDflt = "학교";
	
	private String[] cityCombo = { cityDflt };
	private String[] areaCombo = { areaDflt };
	private String[] levelCombo = { levelDflt };
	private String[] schulCombo = { schulDflt };
	
	private Map<String, Object> searchMap;
	
	public CmplnService(){ 
	      
		width = 800;
		height = 800;
		layout = FrameObj.LAYOUT_GRIDBAG;
		
		// 컴포넌트 설정
		CompObj city = new CompObj();
		city.setName("시");
		city.setEvtName("city");
		city.setSelectItems(cityCombo);
		city.setType(CompObj.TYPE_COMBOBOX);
		city.setEventType(CompObj.EVENT_ACTION);
		city.setGridPosition(0, 0);
		city.setGridWeight(1, 1);
		city.setArrangeType(GridBagConstraints.BOTH);
		componentObjs.add(city);
		
		CompObj area = new CompObj();
		area.setName("도");
		area.setEvtName("area");
		area.setSelectItems(areaCombo);
		area.setType(CompObj.TYPE_COMBOBOX);
		area.setEventType(CompObj.EVENT_ACTION);
		area.setGridPosition(1, 0);
		area.setGridWeight(1, 1);
		area.setArrangeType(GridBagConstraints.BOTH);
		componentObjs.add(area);
		
		CompObj level = new CompObj();
		level.setName("초중고");
		level.setEvtName("level");
		level.setSelectItems(levelCombo);
		level.setType(CompObj.TYPE_COMBOBOX);
		level.setEventType(CompObj.EVENT_ACTION);
		level.setGridPosition(2, 0);
		level.setGridWeight(1, 1);
		level.setArrangeType(GridBagConstraints.BOTH);
		componentObjs.add(level);
		
		CompObj schul = new CompObj();
		schul.setName("학교");
		schul.setEvtName("schul");
		schul.setSelectItems(schulCombo);
		schul.setType(CompObj.TYPE_COMBOBOX);
		schul.setEventType(CompObj.EVENT_ACTION);
		schul.setGridPosition(3, 0);
		schul.setGridWeight(1, 1);
		schul.setArrangeType(GridBagConstraints.BOTH);
		componentObjs.add(schul);
		
		CompObj area1 = new CompObj();
		area1.setEnabled(false);
		area1.setType(CompObj.TYPE_PANEL);
		area1.setLayout(CompObj.LAYOUT_GRID, 0, 1, 2, 2);
		area1.setScrollAt(true);
		area1.setGridSize(4, 1);
		area1.setGridWeight(30, 30);
		area1.setGridPosition(0, 1);
		area1.setArrangeType(GridBagConstraints.BOTH);
		componentObjs.add(area1);
		
	}
	
	public void initData(){
		db.put("esof", esof ); db.put("oc", oc ); db.put("hoc", hoc );
		db.put("oc1", oc1 ); db.put("oc2", oc2 ); db.put("oc3", oc3 ); db.put("oc4", oc4 ); db.put("oc5", oc5 );
		db.put("oc6", oc6 ); db.put("oc7", oc7 ); db.put("oc8", oc8 ); db.put("oc9", oc9 ); db.put("oc10", oc10 );
		db.put("oc11", oc11 ); db.put("oc12", oc12 ); db.put("oc13", oc13 ); db.put("oc14", oc14 ); db.put("oc15", oc15 );
		db.put("oc16", oc16 ); db.put("oc17", oc17 ); db.put("oc18", oc18 ); db.put("oc19", oc19 ); db.put("oc20", oc20 );
		db.put("oc21", oc21 ); db.put("oc22", oc22 ); db.put("oc23", oc23 ); db.put("oc24", oc24 ); db.put("oc25", oc25 );
		db.put("oc26", oc26 ); db.put("oc27", oc27 ); db.put("oc28", oc28 ); db.put("oc29", oc29 ); db.put("oc30", oc30 );
		db.put("oc31", oc31 ); db.put("oc32", oc32 ); db.put("oc33", oc33 ); db.put("oc34", oc34 ); db.put("oc35", oc35 );
		db.put("oc36", oc36 ); db.put("oc37", oc37 ); db.put("oc38", oc38 ); db.put("oc39", oc39 ); db.put("oc40", oc40 );
		db.put("oc41", oc41 ); db.put("oc42", oc42 ); db.put("oc43", oc43 ); db.put("oc44", oc44 ); db.put("oc45", oc45 );
		db.put("oc46", oc46 ); db.put("oc47", oc47 ); db.put("oc48", oc48 ); db.put("oc49", oc49 ); db.put("oc50", oc50 );
		db.put("hoc1", hoc1 ); db.put("hoc2", hoc2 ); db.put("hoc3", hoc3 ); db.put("hoc4", hoc4 ); db.put("hoc5", hoc5 );
		db.put("hoc6", hoc6 ); db.put("hoc7", hoc7 ); db.put("hoc8", hoc8 ); db.put("hoc9", hoc9 ); db.put("hoc10", hoc10);
		db.put("hoc11", hoc11); db.put("hoc12", hoc12); db.put("hoc13", hoc13); db.put("hoc14", hoc14); db.put("hoc15", hoc15);
		db.put("hoc16", hoc16); db.put("hoc17", hoc17); db.put("hoc18", hoc18); db.put("hoc19", hoc19); db.put("hoc20", hoc20);
		db.put("hoc21", hoc21); db.put("hoc22", hoc22); db.put("hoc23", hoc23); db.put("hoc24", hoc24); db.put("hoc25", hoc25);
		db.put("hoc26", hoc26); db.put("hoc27", hoc27); db.put("hoc28", hoc28); db.put("hoc29", hoc29); db.put("hoc30", hoc30);
		db.put("hoc31", hoc31); db.put("hoc32", hoc32); db.put("hoc33", hoc33); db.put("hoc34", hoc34); db.put("hoc35", hoc35);
		db.put("hoc36", hoc36); db.put("hoc37", hoc37); db.put("hoc38", hoc38); db.put("hoc39", hoc39); db.put("hoc40", hoc40);
		db.put("hoc41", hoc41); db.put("hoc42", hoc42); db.put("hoc43", hoc43); db.put("hoc44", hoc44); db.put("hoc45", hoc45);
		db.put("hoc46", hoc46); db.put("hoc47", hoc47); db.put("hoc48", hoc48); db.put("hoc49", hoc49);
		
		setCityList();
		
	}
	
	@Override
	public void doShow(String name) {
		
		if(db.size() < 1) initData();
		super.doShow(name);
		
	}
	
	@Override
	public void onEvent(String type, CompObj obj, Object...objects) throws Exception {
		
		String threadName = "CmplnService";
		runThread(threadName, false);
		
		if(type.equals("change") && "city".equals(obj.getEvtName()) ){
			setAreaList();
		}else if(type.equals("change") && "area".equals(obj.getEvtName()) ){
			setLevelList();
		}else if(type.equals("change") && "level".equals(obj.getEvtName()) ){
			setSchulList();
		}else if(type.equals("change") && "schul".equals(obj.getEvtName()) ){
			setClassList();
		}
		
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setCityList(){
		SqlSession session = db.get("oc").getSqlSession(true);
		List<Map<String, Object>> resultMap = session.selectList("cmplnservice.selectCityList");
		List<String> citys = new ArrayList<>(); citys.add(cityDflt);
		for(Map<String, Object> map : resultMap) citys.add( (String) map.get("cityNm") );
		String[] models = citys.toArray(new String[citys.size()]);
		comboBoxes.get(0).setModel(new DefaultComboBoxModel(models));
		comboBoxes.get(1).setSelectedIndex(0);
		comboBoxes.get(2).setSelectedIndex(0);
		comboBoxes.get(3).setSelectedIndex(0);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setAreaList(){
		String cityNm = (String) comboBoxes.get(0).getSelectedItem();
		Map<String, Object> param = new HashMap<>(); param.put("cityNm", cityNm);
		SqlSession session = db.get("oc").getSqlSession(true);
		List<Map<String, Object>> resultMap = session.selectList("cmplnservice.selectAreaList", param);
		List<String> areas = new ArrayList<>(); areas.add(areaDflt);
		for(Map<String, Object> map : resultMap) areas.add( (String) map.get("areaNm") );
		String[] models = areas.toArray(new String[areas.size()]);
		comboBoxes.get(1).setModel(new DefaultComboBoxModel(models));
		comboBoxes.get(2).setSelectedIndex(0);
		comboBoxes.get(3).setSelectedIndex(0);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setLevelList(){
		String cityNm = (String) comboBoxes.get(0).getSelectedItem();
		String areaNm = (String) comboBoxes.get(1).getSelectedItem();
		Map<String, Object> param = new HashMap<>(); param.put("cityNm", cityNm); param.put("areaNm", areaNm);
		SqlSession session = db.get("oc").getSqlSession(true);
		List<Map<String, Object>> resultMap = session.selectList("cmplnservice.selectSchulLevelList", param);
		List<String> levels = new ArrayList<>(); levels.add(levelDflt);
		for(Map<String, Object> map : resultMap) levels.add( (String) map.get("schulLevelCode") );
		String[] models = levels.toArray(new String[levels.size()]);
		comboBoxes.get(2).setModel(new DefaultComboBoxModel(models));
		comboBoxes.get(3).setSelectedIndex(0);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setSchulList(){
		String cityNm = (String) comboBoxes.get(0).getSelectedItem();
		String areaNm = (String) comboBoxes.get(1).getSelectedItem();
		String schulLevelCode = (String) comboBoxes.get(2).getSelectedItem();
		Map<String, Object> param = new HashMap<>(); 
		param.put("cityNm", cityNm); param.put("areaNm", areaNm); param.put("schulLevelCode", schulLevelCode);
		SqlSession session = db.get("oc").getSqlSession(true);
		List<Map<String, Object>> resultMap = session.selectList("cmplnservice.selectSchulList", param);
		List<String> schuls = new ArrayList<>(); schuls.add(schulDflt);
		for(Map<String, Object> map : resultMap) schuls.add( (String) map.get("schulNm") );
		String[] models = schuls.toArray(new String[schuls.size()]);
		comboBoxes.get(3).setModel(new DefaultComboBoxModel(models));
	}
	
	public void setClassList(){
		panels.get(0).removeAll();
		panels.get(0).repaint();
		panels.get(0).revalidate();
		
		String cityNm = (String) comboBoxes.get(0).getSelectedItem();
		String areaNm = (String) comboBoxes.get(1).getSelectedItem();
		String schulLevelCode = (String) comboBoxes.get(2).getSelectedItem();
		String schulNm = (String) comboBoxes.get(3).getSelectedItem();
		
		Map<String, Object> param = new HashMap<>(); 
		param.put("cityNm", cityNm); param.put("areaNm", areaNm); 
		param.put("schulLevelCode", schulLevelCode); param.put("schulNm", schulNm);
		
		// Search
		SqlSession session = db.get("oc").getSqlSession(true);
		searchMap = session.selectOne("cmplnservice.selectHostInfo", param);
		
		
		if(searchMap != null && searchMap.size() > 0) {
			// Class List
			SqlSession hostSession = db.get(searchMap.get("host")).getSqlSession(true);
			List<Map<String, Object>> resultListMap = hostSession.selectList("cmplnservice.selectClassList", searchMap);
			for(Map<String, Object> map : resultListMap){
				OncleObj obj = new OncleObj(map);
				
				panels.get(0).add(obj);
				panels.get(0).repaint();
				panels.get(0).revalidate();
				
			}
		}
		
	}
	
	@Override
	public CustomThread createThread(){
		return new CustomThread(){
			@Override
			public void run() {
				
			}
		};
	}
	
	
	
	
	public class OncleObj extends JPanel{
		
		private SqlSession hostSession;
		private SqlSession mainSession;
		
		private Color highColor = new Color(0,0,0,0);
		private Color shadColor = Color.GRAY;
		private int borderWidth = 2;
		
		private LineBorder defaultBorder = new LineBorder(highColor, borderWidth);
		private Font font = new Font("바탕", Font.PLAIN, 11);
		private JPopupMenu popupMenu;
		
		private String menuMeberList = "멤버목록";
		private String menuAlctcrList = "강좌목록";
		private String menuEsterChange = "개설자변경";
		private String menuClose = "폐쇄하기";
		private String menuClosReco = "폐쇄복구";
		private String menuLctreList = "강의목록";
		private String menuAtnlcList = "수강생목록";
		private String menuLrnHistList = "학습이력"; 
		private String menuLrnCmplList = "학습상세";
		private String menuLrnHistCmplList = "이력&상세";
		private String menuAlctcrClose = "강좌폐쇄";
		private String menuAlctcrCloseReco = "강좌폐쇄복구";
		private String menuLctreUrlCopy = "영상확인";
		
		private String[] operOptions = { menuMeberList, menuAlctcrList, menuEsterChange, menuClose };
		private String[] closOptions = { menuClosReco };
		
		// hmpgOperSn, hmpgNm, hmpgUrl, hmpgReqstSn, operAt
		// userSn, userNm, userId, grade, schulClass
		Map<String, Object> map;
		
		public OncleObj(Map<String, Object> map){
			this.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.fill=GridBagConstraints.BOTH;
			
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.weightx = 40;
			
			JLabel label = new JLabel("<html>" + (String) map.get("hmpgNm") + "</html>");
			label.setFont(font);
			this.add(label, gbc);
			
			gbc.gridx = 1;
			gbc.gridy = 0;
			gbc.weightx = 1;
			JLabel ester = new JLabel("<html>[<span style='color:ORANGE'>" + (Integer) map.get("grade") + "-" + (String) map.get("schulClass") + "</span>] " 
					+ (String) map.get("userNm") + "(" + (String) map.get("userId") + ")</html>");
			ester.setAlignmentX(JLabel.RIGHT);
			ester.setHorizontalAlignment(JLabel.RIGHT);
			this.add(ester, gbc);

			gbc.gridx = 2;
			gbc.gridy = 0;
			gbc.weightx = 3;
			
			JLabel status = null;
			if((Integer) map.get("operAt") == 1){
				status = new JLabel("<html>" + "<p style='color:green'>운영중</p>");
			}else {
				status = new JLabel("<html>" + "<p style='color:gray'>폐쇄상태</p></html>");
			}
			status.setFont(font);
			status.setAlignmentX(JLabel.RIGHT);
			status.setHorizontalAlignment(JLabel.RIGHT);
			this.add(status, gbc);
			
			hostSession = db.get(searchMap.get("host")).getSqlSession(true);
			mainSession = db.get(searchMap.get("main")).getSqlSession(true);
			
			this.map = map;
			
			this.setToolTipText(
					  "<html>"
					+ "<p>호스트 : " + map.get("host") + "</p>"
					+ "<p>홈페이지번호 : " + map.get("hmpgOperSn") + "</p>"
					+ "<p>URL : " + map.get("hmpgUrl")+"</p>"
					+ "</html>"
			);
			this.setBorder(new EmptyBorder(2,2,2,2));
			ActionListener listener = new ActionListener(){
				@SuppressWarnings("unchecked")
				@Override
				public void actionPerformed(ActionEvent e) {
					String item = e.getActionCommand();

					if( item.equals(menuMeberList)){
						selectMberList(map);
					}else if( item.equals(menuAlctcrList)){
						selectAlctcrList(map);
					}else if( item.equals(menuEsterChange) && Main.confirmPop( "\"" + map.get("hmpgNm") + "\" 개설자를 변경 하시겠습니까?") == 1 ){ 
						changeEsterUser("inputType", map);
					}else if( item.equals(menuClose) && Main.confirmPop( "\"" + map.get("hmpgNm") + "\" 클래스를 폐쇄 하시겠습니까?") == 1 ){
						oncleHmpgClose();
					}else if( item.equals(menuClosReco) && Main.confirmPop( "\"" + map.get("hmpgNm") + "\" 클래스를 복구 하시겠습니까?") == 1 ){
						oncleHmpgCloseReco();
					}
				}
			};
			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount() == 2) duoClick((JComponent) e.getComponent());
					else popupMenu.show(e.getComponent(), e.getX(), e.getY());
				}
				@Override
				public void mouseEntered(MouseEvent e) { focus((JComponent) e.getComponent()); }
				@Override
				public void mouseExited(MouseEvent e) { unFocus((JComponent) e.getComponent()); }
			});
			
			this.popupMenu = popupMenu(this, (String) map.get("hmpgNm"), (Integer) map.get("operAt") == 1 ? operOptions : closOptions, listener);
		}

		
		
		/*
		 * 홈페이지 폐쇄
		 * */
		public void oncleHmpgClose(){
			try {
				Integer result = hostSession.update("cmplnservice.closeHmpg", this.map);
				result *= hostSession.update("cmplnservice.closeHmpgReqst", this.map);
				result *= mainSession.update("cmplnservice.closeHmpg", this.map);
				result *= mainSession.update("cmplnservice.closeHmpgReqst", this.map);
				if(result > 0){
					Main.alertPop("클래스 폐쇄성공");
					hostSession.commit();
					setClassList();
				}else {
					Main.alertPop("클래스 폐쇄실패 다시시도해주세요.");
					hostSession.rollback();
				}
			}catch(Exception err){
				Main.alertPop("클래스 폐쇄실패 다시시도해주세요.");
				hostSession.rollback();
				mainSession.rollback();
			}
		}
		
		/*
		 * 홈페이지 복구
		 * */
		public void oncleHmpgCloseReco(){
			try{
				Integer result = hostSession.update("cmplnservice.closeRecoverHmpg", this.map);
				result *= hostSession.update("cmplnservice.closeRecoverHmpgReqst", this.map);
				result *= mainSession.update("cmplnservice.closeRecoverHmpg", this.map);
				result *= mainSession.update("cmplnservice.closeRecoverHmpgReqst", this.map);
				if(result > 0){
					Main.alertPop("클래스 복구성공");
					hostSession.commit();
					setClassList();
				}else {
					Main.alertPop("클래스 복구실패 다시시도해주세요.");
					hostSession.rollback();
				}
			}catch(Exception err){
				Main.alertPop("클래스 폐쇄실패 다시시도해주세요.");
				hostSession.rollback();
				mainSession.rollback();
			}
		}
		
		/*
		 * 개설자 변경
		 * */
		public void changeEsterUser(String type, @SuppressWarnings("unchecked") Map<String, Object>...params){
			try {
				
				Map<String, Object> map = params[0];
				
				if(type.equals("changeType")){
					
				}else if(type.equals("inputType")){
					String id = Main.inputPop( "개설자 \"" + map.get("userNm") + "(" + map.get("userId") + ")\" 에서 변경될 사용자 아이디를 입력 해주세요.");
					if(id == null || id.equals("")){
						return;
					}
					Map<String, Object> param = new HashMap<>();
					param.put("userId", id);
					map = hostSession.selectOne("cmplnservice.selectChangeEsterUser", param);
				}
					
					
					if(map != null && map.size() > 0){
						if(Main.confirmPop("사용자\"" + map.get("userNm") + "(" + map.get("userId") + ")\" 님으로 변경 하시겠습니까?") == 1){
							map.put("hmpgOperSn", this.map.get("hmpgOperSn"));
							int result = hostSession.update("cmplnservice.updateChangeHmpgOperUser", map);
							
							Map<String, Object> resultMap = hostSession.selectOne("cmplnservice.selectChangeEsterMber", map);
							
							if(resultMap != null && resultMap.size() > 0){
								result *= hostSession.update("cmplnservice.updateHmpgOperMberUser", map);
							}else {
								result *= hostSession.insert("cmplnservice.insertHmpgOperMberUser", map);
							}
							
							if(result > 0){
								Main.alertPop("개설자 변경 성공.");
								hostSession.commit();
								setClassList();
							}else {
								Main.alertPop("개설자 변경 실패 다시시도해주세요.");
								hostSession.rollback();
							}
						}
					}else {
						Main.alertPop("사용자 정보가 없습니다.");
					}
				
			}catch(Exception err){
				err.printStackTrace();
				Main.alertPop("개설자 변경 실패 다시시도해주세요.");
				hostSession.rollback();
			}
		}
		
		
		
		/*
		 * 강좌 리스트
		 * */
		public void selectAlctcrList(Map<String, Object> param){
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(0, 1));
			List<Map<String, Object>> resultListMap = hostSession.selectList("cmplnservice.selectALctcrManageList", param);
			for(Map<String, Object> map : resultListMap){
				String alctcrNm = (String) map.get("alctcrNm");
				JLabel label = new JLabel(alctcrNm);
				label.setBorder(new EmptyBorder(2,2,2,2));
				label.setToolTipText("강좌번호 : "+(Long)map.get("alctcrSn"));
				String options[] = null;
				if(map.containsKey("clsSttusCode") && ((String) map.get("clsSttusCode")).equals("005")){
					options = new String[]{menuLctreList, menuAtnlcList, menuAlctcrCloseReco};
					label.setText("<html>" + label.getText() + "	<span style='color:gray'>(폐쇄)</span></html>");
				}else {
					options = new String[]{menuLctreList, menuAtnlcList, menuAlctcrClose};
					label.setText("<html>" + label.getText() + "	<span style='color:green'>(운영중)</span></html>");
				}
				
				ActionListener listener = new ActionListener(){
					@SuppressWarnings("unchecked")
					@Override
					public void actionPerformed(ActionEvent e) {
						String item = e.getActionCommand();

						if( item.equals(menuAtnlcList) ){
							selectMberList(map);
						}else if( item.equals(menuLctreList) ){
							selectLctreList(map);
						}else if( item.equals(menuAlctcrCloseReco) && Main.confirmPop( "\"" + alctcrNm + "\" 강좌를 복구 하시겠습니까?") == 1 ){ 
							try{
								int result = hostSession.update("cmplnservice.closeAlctcrManageReco", map);
								if(result > 0){
									Main.alertPop("강좌 복구 성공");
									hostSession.commit();
									JOptionPane.getRootFrame().dispose();
									selectAlctcrList(param);
								}else {
									Main.alertPop("강좌 복구 실패 다시시도해주세요.");
									hostSession.rollback();
								}
							}catch(Exception err){
								err.printStackTrace();
								Main.alertPop("강좌 복구 실패 다시시도해주세요.");
								hostSession.rollback();
							}
						}else if( item.equals(menuAlctcrClose) && Main.confirmPop( "\"" + alctcrNm + "\" 강좌를 폐쇄 하시겠습니까?") == 1 ){
							try{
								int result = hostSession.update("cmplnservice.closeAlctcrManage", map);
								if(result > 0){
									Main.alertPop("강좌 폐쇄 성공");
									hostSession.commit();
									JOptionPane.getRootFrame().dispose();
									selectAlctcrList(param);
								}else {
									Main.alertPop("강좌 폐쇄 실패 다시시도해주세요.");
									hostSession.rollback();
								}
							}catch(Exception err){
								err.printStackTrace();
								Main.alertPop("강좌 폐쇄 실패 다시시도해주세요.");
								hostSession.rollback();
							}
						}
					}
				};
				JPopupMenu menu = popupMenu(label, alctcrNm, options, listener);
				label.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(e.getClickCount() == 2) duoClick((JComponent) e.getComponent());
						else menu.show(e.getComponent(), e.getX(), e.getY());
					}
					@Override
					public void mouseEntered(MouseEvent e) { focus((JComponent) e.getComponent()); }
					@Override
					public void mouseExited(MouseEvent e) { unFocus((JComponent) e.getComponent()); }
				});
				panel.add(label);
			}
			JScrollPane container = new JScrollPane(panel);
			container.getVerticalScrollBar().setUnitIncrement(16);
			Main.alertPop("강좌목록 : " + (String) map.get("hmpgNm"), container);
		}
		
		/*
		 * 멤버 리스트
		 * */
		public void selectMberList(Map<String, Object> param){
			
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(0, 1));
			
			String tit = "";
			
			if(param.containsKey("alctcrSn")){
				tit = "강좌 : " + param.get("alctcrNm");
			}else {
				tit = "온클 : " + (String)map.get("hmpgNm");
			}
			
			List<Map<String, Object>> resultListMap = hostSession.selectList("cmplnservice.selectHmpgMberList", param);
			for(Map<String, Object> map : resultListMap){
				
				Integer grade = (Integer) map.get("grade");
				String mberClass = (String) map.get("mberClass");
				Integer mberClassNo = (Integer) map.get("mberClassNo");
				String userNm = (String) map.get("userNm");
				String job = (String) map.get("job");
				String mberSttusStr = (String) map.get("mberSttusStr");
				String atnlcSttusStr = (String) map.get("atnlcSttusStr");
				
				JLabel label = new JLabel("<html>" + grade + "학년 " + mberClass + "반 " + mberClassNo + "번 " + userNm +"(" + (String) map.get("userId") + ") " + job + 
						(param.containsKey("alctcrSn") ? " :: " + atnlcSttusStr : "( " + mberSttusStr + " )") + "</html>");
				label.setToolTipText( "<html><p>사용자번호 : " + (Long) map.get("userSn") + "</p><p>사용자아이디 : " + (String) map.get("userId") + "</html>");
				label.setBorder(new EmptyBorder(2,2,2,2));
				ActionListener listener = new ActionListener(){
					@SuppressWarnings("unchecked")
					@Override
					public void actionPerformed(ActionEvent e) {
						String item = e.getActionCommand();

						if( item.equals(menuLrnHistList) ){
							if(param.containsKey("alctcrSn")){
								// 강좌목록 > 수강생목록 > 수강생 > 학습이력
								Map<String, Object> p = new HashMap<>();
								p.put("hmpgOperSn", param.get("hmpgOperSn"));
								p.put("alctcrSn", param.get("alctcrSn"));
								p.put("userSn", map.get("userSn"));
								p.put("userNm", userNm);
								selectLctreLrnHist(p);
							}else {
								// 맴버목록 > 학습이력
								Map<String, Object> p = new HashMap<>();
								p.put("hmpgOperSn", param.get("hmpgOperSn"));
								p.put("userSn", map.get("userSn"));
								p.put("userNm", userNm);
								selectLctreLrnHist(p);
							}
						}else if( item.equals(menuLrnCmplList) ){
							if(param.containsKey("alctcrSn")){
								// 강좌목록 > 수강생목록 > 학습상세
								Map<String, Object> p = new HashMap<>();
								p.put("hmpgOperSn", param.get("hmpgOperSn"));
								p.put("alctcrSn", param.get("alctcrSn"));
								p.put("userSn", map.get("userSn"));
								p.put("userNm", userNm);
								selectLctreLrnDetail(p);
							}else {
								// 맴버목록 > 학습이력
								Map<String, Object> p = new HashMap<>();
								p.put("hmpgOperSn", param.get("hmpgOperSn"));
								p.put("userSn", map.get("userSn"));
								p.put("userNm", userNm);
								selectLctreLrnDetail(p);
							}
						}else if( item.equals(menuLctreList) ){
							map.put("userNm", userNm);
							selectLctreList(map);
						}else if( item.equals(menuEsterChange) ){
							changeEsterUser("changeType", map);
							JOptionPane.getRootFrame().dispose();
							selectMberList(param);
						}
					}
				};
				
				String[] options = null; 
				
				if(param.containsKey("alctcrSn")){
					options = new String[]{menuLrnHistList, menuLrnCmplList, menuLctreList};
				}else {
					options = new String[]{menuLrnHistList, menuLrnCmplList, menuLctreList, menuEsterChange};
				}
				
				JPopupMenu menu = popupMenu(label, userNm, options, listener);
				label.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(e.getClickCount() == 2) duoClick((JComponent) e.getComponent());
						else menu.show(e.getComponent(), e.getX(), e.getY());
					}
					@Override
					public void mouseEntered(MouseEvent e) { focus((JComponent) e.getComponent()); }
					@Override
					public void mouseExited(MouseEvent e) { unFocus((JComponent) e.getComponent()); }
				});
				panel.add(label);
			}
			JScrollPane container = new JScrollPane(panel);
			container.getVerticalScrollBar().setUnitIncrement(16);
			Main.alertPop(tit , container);
		}
		
		/*
		 * 강의 리스트
		 * */
		public void selectLctreList(Map<String, Object> param){
			
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(0, 1));
			
			List<Map<String, Object>> resultListMap = hostSession.selectList("cmplnservice.selectLctreList", param);
			
			String tit = "";
			if(param.containsKey("userSn")){
				tit += "유저 : " + (String) param.get("userNm");
			}else {
				tit = "강좌 : " + (String) param.get("alctcrNm");
			}
			
			for(Map<String, Object> map : resultListMap){
				
				String labelStr = "";
				String lctreNm = (String) map.get("lctreNm");
				
				// 멤버목록 > 강의목록 > 학습이력 || 강좌목록 > 수강생목록 > 강의목록 > 학습이력
				if(param.containsKey("userSn")){
					labelStr = "<html>" + map.get("alctcrNm") + " : " + lctreNm + "(<span style='color:BLUE'>" + map.get("codeNm") + "</span>) >> " + 
							(map.containsKey("lrnAt") && (Boolean) map.get("lrnAt") ? "학습완료" : "학습중") + "</html>";
				// 강좌목록 > 강의목록 > 학습이력
				}else {
					labelStr = "<html>" + lctreNm + "(<span style='color:BLUE'>" + map.get("codeNm") + "</span>)</html>";
				}
				
				JLabel label = new JLabel(labelStr );
				label.setBorder(new EmptyBorder(2,2,2,2));
				ActionListener listener = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						String item = e.getActionCommand();

						if( item.equals(menuLrnHistList) ){
							Map<String, Object> p = new HashMap<>();
							p.put("hmpgOperSn", param.get("hmpgOperSn"));
							p.put("lctreNm", map.get("lctreNm"));
							if(param.containsKey("userSn")) p.put("userSn", param.get("userSn"));
							if(param.containsKey("alctcrSn")) p.put("alctcrSn", param.get("alctcrSn"));
							if(param.containsKey("userNm")) p.put("userNm", param.get("userNm"));
							if(map.containsKey("lctreSn")) p.put("lctreSn", map.get("lctreSn"));
							selectLctreLrnHist(p);
						}else if( item.equals(menuLrnCmplList) ){
							Map<String, Object> p = new HashMap<>();
							p.put("hmpgOperSn", param.get("hmpgOperSn"));
							p.put("lctreNm", map.get("lctreNm"));
							if(param.containsKey("userSn")) p.put("userSn", param.get("userSn"));
							if(param.containsKey("alctcrSn")) p.put("alctcrSn", param.get("alctcrSn"));
							if(param.containsKey("userNm")) p.put("userNm", param.get("userNm"));
							if(map.containsKey("lctreSn")) p.put("lctreSn", map.get("lctreSn"));
							selectLctreLrnDetail(p);
						}else if( item.equals(menuLrnHistCmplList) ){
							Map<String, Object> p = new HashMap<>();
							p.put("hmpgOperSn", param.get("hmpgOperSn"));
							p.put("lctreNm", map.get("lctreNm"));
							if(param.containsKey("userSn")) p.put("userSn", param.get("userSn"));
							if(param.containsKey("alctcrSn")) p.put("alctcrSn", param.get("alctcrSn"));
							if(param.containsKey("userNm")) p.put("userNm", param.get("userNm"));
							if(map.containsKey("lctreSn")) p.put("lctreSn", map.get("lctreSn"));
							selectLctreLrnDetailAndHist(p);
						}else if( item.equals(menuLctreUrlCopy) ){
//							Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//							StringSelection contents = new StringSelection((String) map.get("mvpFileUrl"));
//							clipboard.setContents(contents, null);
//							TrayIconHandler.displayMessage("복사완료", (String) map.get("mvpFileUrl"), MessageType.NONE);
							
							try {
								Desktop.getDesktop().browse(new URI((String) map.get("mvpFileUrl")));
							} catch (IOException e1) {
								e1.printStackTrace();
							} catch (URISyntaxException e1) {
								e1.printStackTrace();
							}
						}
					}
				};
				
				String options[] = null;
				
				if(((String) map.get("cntntsTyCode")).equals("001") || ((String) map.get("cntntsTyCode")).equals("002") 
						|| ((String) map.get("cntntsTyCode")).equals("014") || ((String) map.get("cntntsTyCode")).equals("015")){
					if(param.containsKey("userSn")){
						options = new String[]{menuLrnHistList, menuLrnCmplList, menuLrnHistCmplList, menuLctreUrlCopy, "강의시간:" + (Integer) map.get("revivTime")+"초"};
					}else {
						options = new String[]{menuLrnHistList, menuLrnCmplList, menuLctreUrlCopy, "강의시간:" + (Integer) map.get("revivTime")+"초"};
					}
				}else {
					if(param.containsKey("userSn")){
						options = new String[]{menuLrnHistList, menuLrnCmplList, menuLrnHistCmplList};
					}else {
						options = new String[]{menuLrnHistList, menuLrnCmplList};
					}
				}
				
				JPopupMenu menu = popupMenu(label, lctreNm, options, listener);
				label.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(e.getClickCount() == 2) duoClick((JComponent) e.getComponent());
						else menu.show(e.getComponent(), e.getX(), e.getY());
					}
					@Override
					public void mouseEntered(MouseEvent e) { focus((JComponent) e.getComponent()); }
					@Override
					public void mouseExited(MouseEvent e) { unFocus((JComponent) e.getComponent()); }
				});
				panel.add(label);
			}
			
			JScrollPane container = new JScrollPane(panel);
			Main.alertPop(tit, container);
		}
		
		
		
		
		
		
		
		
		/*
		 * 1 멤버의 전체 강의 학습이력
		 * 		1.1 멤버의 해당 강의에 대한 학습이력
		 * 
		 * 2 해당 강의에 대한 전체 사용자 학습이력
		 * 		2.1 해당 강좌를 수강중인 사용자의 전체(강의) 학습이력
		 * 			2.1.1 강좌를 수강중인 사용자가 수강중인 해당 강의에 대한 학습이력
		 * */
		
		/*
		 * 학습이력
		 * */
		public void selectLctreLrnHist(Map<String, Object> param){
			
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(0, 1));
			List<Map<String, Object>> resultListMap = hostSession.selectList("cmplnservice.selectLctreLrnHist", param);
			
			String schulNm = (String) this.map.get("schulNm");
			Integer grade = (Integer) this.map.get("grade");
			String schulClass = (String) this.map.get("schulClass");
			String userNm = "";
			String lctreNm = "";
			if(param.containsKey("userNm")) userNm = (String) param.get("userNm")+"_";
			if(param.containsKey("lctreNm")) lctreNm = (String) param.get("lctreNm")+"_";
			
//			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
//			String toDayStr = fmt.format(new Date());
			
			String fileName = schulNm + "_" + userNm + "학습이력";
			
			ExcelFileWriter w = new ExcelFileWriter(Path.DESKTOPPATH, fileName, "xlsx");
			
//			w.addData(0, 0, 0, "학년");
//			w.addData(0, 0, 1, "반");
//			w.addData(0, 0, 2, "번호");
//			w.addData(0, 0, 3, "이름");
//			w.addData(0, 0, 4, "아이디");
//			w.addData(0, 0, 5, "강좌명");
//			w.addData(0, 0, 6, "강의명");
//			w.addData(0, 0, 7, "강의유형");
//			w.addData(0, 0, 8, "LRN_TIME");
//			w.addData(0, 0, 9, "SERVER_LRN_TIME");
//			w.addData(0, 0, 10, "학습일시");
//			w.addData(0, 0, 11, "총학습시간");
//			w.addData(0, 0, 12, "목표학습시간");
//			w.addData(0, 0, 13, "학습여부");
			
			w.addData(0, 0, 0, "ALCTCR_NM");
			w.addData(0, 0, 1, "LCTRE_NM");
			w.addData(0, 0, 2, "USER_NM");
			w.addData(0, 0, 3, "LRN_TIME");
			w.addData(0, 0, 4, "SERVER_LRN_TIME");
			w.addData(0, 0, 5, "FRST_REGIST_PNTTM");
			w.addData(0, 0, 6, "REVIV_TIME");
			
			int row = 1;
			for(Map<String, Object> map : resultListMap){
				System.out.println(map.toString());
				
//				w.addData(0, row, 0, map.get("학년"));
//				w.addData(0, row, 1, map.get("반"));
//				w.addData(0, row, 2, map.get("번호"));
//				w.addData(0, row, 3, map.get("이름"));
//				w.addData(0, row, 4, map.get("아이디"));
//				w.addData(0, row, 5, map.get("강좌명"));
//				w.addData(0, row, 6, map.get("강의명"));
//				w.addData(0, row, 7, map.get("강의유형"));
//				w.addData(0, row, 8, map.get("LRN_TIME"));
//				w.addData(0, row, 9, map.get("SERVER_LRN_TIME"));
//				w.addData(0, row, 10, map.get("학습일시") + "");
//				w.addData(0, row, 11, map.get("총학습시간"));
//				w.addData(0, row, 12, map.get("목표학습시간"));
//				w.addData(0, row, 13, map.get("학습여부"));
				
				w.addData(0, row, 0, map.get("ALCTCR_NM"));
				w.addData(0, row, 1, map.get("LCTRE_NM"));
				w.addData(0, row, 2, map.get("USER_NM"));
				w.addData(0, row, 3, map.get("LRN_TIME"));
				w.addData(0, row, 4, map.get("SERVER_LRN_TIME"));
				w.addData(0, row, 5, map.get("FRST_REGIST_PNTTM")+"");
				w.addData(0, row, 6, map.get("REVIV_TIME"));
				row++;
			}
			w.write();
			Main.alertPop(fileName + " 바탕화면 저장완료");
		}
		
		/*
		 * 학습상세
		 * */
		public void selectLctreLrnDetail(Map<String, Object> param){
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(0, 1));
			List<Map<String, Object>> resultListMap = hostSession.selectList("cmplnservice.selectLctreLrnDetail", param);
			
			String schulNm = (String) this.map.get("schulNm");
			Integer grade = (Integer) this.map.get("grade");
			String schulClass = (String) this.map.get("schulClass");
			String userNm = "";
			String lctreNm = "";
			if(param.containsKey("userNm")) userNm = (String) param.get("userNm")+"_";
			if(param.containsKey("lctreNm")) lctreNm = (String) param.get("lctreNm")+"_";
			
//			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
//			String toDayStr = fmt.format(new Date());
			
			String fileName = schulNm + "_" + userNm + "학습상세";
			
			ExcelFileWriter w = new ExcelFileWriter(Path.DESKTOPPATH, fileName, "xlsx");
			
//			w.addData(0, 0, 0, "학년");
//			w.addData(0, 0, 1, "반");
//			w.addData(0, 0, 2, "번호");
//			w.addData(0, 0, 3, "이름");
//			w.addData(0, 0, 4, "아이디");
//			w.addData(0, 0, 5, "강좌명");
//			w.addData(0, 0, 6, "강의명");
//			w.addData(0, 0, 7, "강의유형");
//			w.addData(0, 0, 8, "학습시작일시");
//			w.addData(0, 0, 9, "학습완료일시");
//			w.addData(0, 0, 10, "학습시간/목표시간");
//			w.addData(0, 0, 11, "학습여부");
			
			w.addData(0, 0, 0, "클래스명");
			w.addData(0, 0, 1, "학년");
			w.addData(0, 0, 2, "반");
			w.addData(0, 0, 3, "번호");
			w.addData(0, 0, 4, "이름(아이디)");
			w.addData(0, 0, 5, "강의유형");
			w.addData(0, 0, 6, "강좌명");
			w.addData(0, 0, 7, "강의명");
			w.addData(0, 0, 8, "학습시간");
			w.addData(0, 0, 9, "목표 학습시간");
			w.addData(0, 0, 10, "학습시작시간");
			w.addData(0, 0, 11, "학습완료시간");
			w.addData(0, 0, 12, "학습여부");
			
			int row = 1;
			for(Map<String, Object> map : resultListMap){
				System.out.println(map.toString());
//				w.addData(0, row, 0, map.get("학년"));
//				w.addData(0, row, 1, map.get("반"));
//				w.addData(0, row, 2, map.get("번호"));
//				w.addData(0, row, 3, map.get("이름"));
//				w.addData(0, row, 4, map.get("아이디"));
//				w.addData(0, row, 5, map.get("강좌명"));
//				w.addData(0, row, 6, map.get("강의명"));
//				w.addData(0, row, 7, map.get("강의유형"));
//				w.addData(0, row, 8, map.get("학습시작일시") + "");
//				w.addData(0, row, 9, map.get("학습완료일시") + "");
//				w.addData(0, row, 10, map.get("학습시간/목표시간"));
//				w.addData(0, row, 11, map.get("학습여부"));
				
				w.addData(0, row, 0, map.get("클래스명"));
				w.addData(0, row, 1, map.get("학년"));
				w.addData(0, row, 2, map.get("반"));
				w.addData(0, row, 3, map.get("번호"));
				w.addData(0, row, 4, map.get("이름(아이디)"));
				w.addData(0, row, 5, map.get("강의유형"));
				w.addData(0, row, 6, map.get("강좌명"));
				w.addData(0, row, 7, map.get("강의명"));
				w.addData(0, row, 8, map.get("학습시간"));
				w.addData(0, row, 9, map.get("목표 학습시간"));
				w.addData(0, row, 10, map.get("학습시작시간")+"");
				w.addData(0, row, 11, map.get("학습완료시간")+"");
				w.addData(0, row, 12, map.get("학습여부"));
				row++;
			}
			w.write();
			Main.alertPop(fileName + " 바탕화면 저장완료");
		}
		
		
		public void selectLctreLrnDetailAndHist(Map<String, Object> param){
			
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(0, 1));
			List<Map<String, Object>> resultDetailListMap = hostSession.selectList("cmplnservice.selectLctreLrnDetail", param);
			List<Map<String, Object>> resultHistListMap = hostSession.selectList("cmplnservice.selectLctreLrnHist", param);
			
			String schulNm = (String) this.map.get("schulNm");
			Integer grade = (Integer) this.map.get("grade");
			String schulClass = (String) this.map.get("schulClass");
			String userNm = "";
			String lctreNm = "";
			if(param.containsKey("userNm")) userNm = (String) param.get("userNm")+"_";
			if(param.containsKey("lctreNm")) lctreNm = (String) param.get("lctreNm")+"_";
			
//			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
//			String toDayStr = fmt.format(new Date());
			
			String fileName = schulNm + "_" + userNm + "학습데이터";
			
			ExcelFileWriter w = new ExcelFileWriter(Path.DESKTOPPATH, fileName, "xlsx");
			
			/*w.addData("DETAIL", 0, 0, "학년");
			w.addData("DETAIL", 0, 1, "반");
			w.addData("DETAIL", 0, 2, "번호");
			w.addData("DETAIL", 0, 3, "이름");
			w.addData("DETAIL", 0, 4, "아이디");
			w.addData("DETAIL", 0, 5, "강좌명");
			w.addData("DETAIL", 0, 6, "강의명");
			w.addData("DETAIL", 0, 7, "강의유형");
			w.addData("DETAIL", 0, 8, "학습시작일시");
			w.addData("DETAIL", 0, 9, "학습완료일시");
			w.addData("DETAIL", 0, 10, "학습시간/목표시간");
			w.addData("DETAIL", 0, 11, "학습여부");
			
			w.addData("HIST", 0, 0, "학년");
			w.addData("HIST", 0, 1, "반");
			w.addData("HIST", 0, 2, "번호");
			w.addData("HIST", 0, 3, "이름");
			w.addData("HIST", 0, 4, "아이디");
			w.addData("HIST", 0, 5, "강좌명");
			w.addData("HIST", 0, 6, "강의명");
			w.addData("HIST", 0, 7, "강의유형");
			w.addData("HIST", 0, 8, "LRN_TIME");
			w.addData("HIST", 0, 9, "SERVER_LRN_TIME");
			w.addData("HIST", 0, 10, "학습일시");
			w.addData("HIST", 0, 11, "총학습시간");
			w.addData("HIST", 0, 12, "목표학습시간");
			w.addData("HIST", 0, 13, "학습여부");
			
			int row = 1;
			for(Map<String, Object> map : resultDetailListMap){
				System.out.println(map.toString());
				w.addData("DETAIL", row, 0, map.get("학년"));
				w.addData("DETAIL", row, 1, map.get("반"));
				w.addData("DETAIL", row, 2, map.get("번호"));
				w.addData("DETAIL", row, 3, map.get("이름"));
				w.addData("DETAIL", row, 4, map.get("아이디"));
				w.addData("DETAIL", row, 5, map.get("강좌명"));
				w.addData("DETAIL", row, 6, map.get("강의명"));
				w.addData("DETAIL", row, 7, map.get("강의유형"));
				w.addData("DETAIL", row, 8, map.get("학습시작일시") + "");
				w.addData("DETAIL", row, 9, map.get("학습완료일시") + "");
				w.addData("DETAIL", row, 10, map.get("학습시간/목표시간"));
				w.addData("DETAIL", row, 11, map.get("학습여부"));
				row++;
			}
			
			row = 1;
			for(Map<String, Object> map : resultHistListMap){
				System.out.println(map.toString());
				w.addData("HIST", row, 0, map.get("학년"));
				w.addData("HIST", row, 1, map.get("반"));
				w.addData("HIST", row, 2, map.get("번호"));
				w.addData("HIST", row, 3, map.get("이름"));
				w.addData("HIST", row, 4, map.get("아이디"));
				w.addData("HIST", row, 5, map.get("강좌명"));
				w.addData("HIST", row, 6, map.get("강의명"));
				w.addData("HIST", row, 7, map.get("강의유형"));
				w.addData("HIST", row, 8, map.get("LRN_TIME"));
				w.addData("HIST", row, 9, map.get("SERVER_LRN_TIME"));
				w.addData("HIST", row, 10, map.get("학습일시") + "");
				w.addData("HIST", row, 11, map.get("총학습시간"));
				w.addData("HIST", row, 12, map.get("목표학습시간"));
				w.addData("HIST", row, 13, map.get("학습여부"));
				row++;
			}*/
			
			w.addData("DETAIL", 0, 0, "클래스명");     
			w.addData("DETAIL", 0, 1, "학년");       
			w.addData("DETAIL", 0, 2, "반");        
			w.addData("DETAIL", 0, 3, "번호");       
			w.addData("DETAIL", 0, 4, "이름(아이디)");  
			w.addData("DETAIL", 0, 5, "강의유형");     
			w.addData("DETAIL", 0, 6, "강좌명");      
			w.addData("DETAIL", 0, 7, "강의명");      
			w.addData("DETAIL", 0, 8, "학습시간");    
			w.addData("DETAIL", 0, 9, "목표 학습시간"); 
			w.addData("DETAIL", 0, 10, "학습시작시간");  
			w.addData("DETAIL", 0, 11, "학습완료시간");  
			w.addData("DETAIL", 0, 12, "학습여부");    
			
			w.addData("HIST", 0, 0, "ALCTCR_NM");        
			w.addData("HIST", 0, 1, "LCTRE_NM");         
			w.addData("HIST", 0, 2, "USER_NM");          
			w.addData("HIST", 0, 3, "LRN_TIME");         
			w.addData("HIST", 0, 4, "SERVER_LRN_TIME");  
			w.addData("HIST", 0, 5, "FRST_REGIST_PNTTM");
			w.addData("HIST", 0, 6, "REVIV_TIME");       
			
			int row = 1;
			for(Map<String, Object> map : resultDetailListMap){
				System.out.println(map.toString());
				w.addData("DETAIL", row, 0, map.get("클래스명"));       
				w.addData("DETAIL", row, 1, map.get("학년"));         
				w.addData("DETAIL", row, 2, map.get("반"));          
				w.addData("DETAIL", row, 3, map.get("번호"));         
				w.addData("DETAIL", row, 4, map.get("이름(아이디)"));    
				w.addData("DETAIL", row, 5, map.get("강의유형"));       
				w.addData("DETAIL", row, 6, map.get("강좌명"));        
				w.addData("DETAIL", row, 7, map.get("강의명"));        
				w.addData("DETAIL", row, 8, map.get("학습시간"));      
				w.addData("DETAIL", row, 9, map.get("목표 학습시간"));   
				w.addData("DETAIL", row, 10, map.get("학습시작시간")+""); 
				w.addData("DETAIL", row, 11, map.get("학습완료시간")+""); 
				w.addData("DETAIL", row, 12, map.get("학습여부"));      
				row++;
			}
			
			row = 1;
			for(Map<String, Object> map : resultHistListMap){
				System.out.println(map.toString());
				w.addData("HIST", row, 0, map.get("ALCTCR_NM"));           
				w.addData("HIST", row, 1, map.get("LCTRE_NM"));            
				w.addData("HIST", row, 2, map.get("USER_NM"));             
				w.addData("HIST", row, 3, map.get("LRN_TIME"));            
				w.addData("HIST", row, 4, map.get("SERVER_LRN_TIME"));     
				w.addData("HIST", row, 5, map.get("FRST_REGIST_PNTTM")+"");
				w.addData("HIST", row, 6, map.get("REVIV_TIME"));          
				row++;
			}
			
			w.write();
			
			Main.alertPop(fileName + " 바탕화면 저장완료");
			
		}
		
		
		
		
		
		
		
		
		/*
		 * 외부 클릭 메소드
		 * */
		public void duoClick(JComponent j){
			unSelect(j);
		}
		
		public void select(){
			this.setBorder(new BevelBorder(BevelBorder.LOWERED, highColor, shadColor));
			this.setBackground(Color.GRAY);
		}
		
		public void unSelect(JComponent j){
			j.setBorder(defaultBorder);
			j.setBackground(null);
		}
		
		public void focus(JComponent j){
			j.setBorder(new LineBorder(shadColor));
		}
		
		public void unFocus(JComponent j){
			j.setBorder(defaultBorder);
		}
		
		/*
		 * 우클릭 메뉴
		 * */
		public JPopupMenu popupMenu(JComponent jc, String title, String[] list, ActionListener listener){
			
			JPopupMenu popupMenu = new JPopupMenu();
			
			// 팝업에 파일 제목 셋팅
			JMenuItem name = new JMenuItem(title);
			name.setBackground(Color.gray);
			name.setForeground(Color.white);
			popupMenu.add(name);
			
			// 파일 기능 팝업 추가
			for(int j=0;j<list.length; j++) {
				String menu = list[j];
				final JMenuItem item = new JMenuItem(menu);
				item.setBackground(Color.WHITE);
				item.setForeground(Color.BLACK);
				item.addActionListener(listener);
				item.setFont(font);
				popupMenu.add(item);
			}
			
			jc.setComponentPopupMenu(popupMenu);
			return popupMenu;
			
		}
		
	}


}
