
package main.test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.filechooser.FileSystemView;

import org.apache.ibatis.session.SqlSession;

import comm.fileio.ExcelFileWriter;
import comm.remote.DBConnection;

public class AVGService {

	Integer startMonth = 2;
	Integer startDay = 3;
	Integer ystrDay = -1;

	String deskTopPath = FileSystemView.getFileSystemView().getHomeDirectory().getPath();

	SimpleDateFormat s_fmt = new SimpleDateFormat("yyyyMMdd0000");
	SimpleDateFormat e_fmt = new SimpleDateFormat("yyyyMMdd0000");
	SimpleDateFormat fmt2 = new SimpleDateFormat("MMdd");

	Map<String, DBConnection> mainDb = new HashMap<>();

	DBConnection esof = new DBConnection("esof", "jdbc:mysql://ebsesofprodmysql.mysql.database.azure.com/ebsesof",
			DBConnection.MYSQL, "esofedu@ebsesofprodmysql", "eduesof");

	DBConnection POC = new DBConnection("POC / 메인", "jdbc:mysql://ebsocprodmysql.mysql.database.azure.com/ebsesof",
			DBConnection.MYSQL, "esofedu@ebsocprodmysql", "esofedu");
	DBConnection HOC = new DBConnection("HOC / 메인", "jdbc:mysql://ebshocprodmysql.mysql.database.azure.com/ebsesof",
			DBConnection.MYSQL, "esofedu@ebshocprodmysql", "esofedu");

	// 초등학교
	DBConnection P_317 = new DBConnection("oc1 / 초", "jdbc:mysql://ebsoc1prodmysql.mysql.database.azure.com/ebsesof",
			DBConnection.MYSQL, "esofedu@ebsoc1prodmysql", "esofedu");
	DBConnection[] P_322 = {
			new DBConnection("oc1 / 초", "jdbc:mysql://ebsoc1prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc1prodmysql", "esofedu"),
			new DBConnection("oc1_10 / 초", "jdbc:mysql://ebsoc10prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc10prodmysql", "esofedu"),
			new DBConnection("oc1_11 / 초", "jdbc:mysql://ebsoc11prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc11prodmysql", "esofedu"),
			new DBConnection("oc1_12 / 초", "jdbc:mysql://ebsoc12prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc12prodmysql", "esofedu") };
	DBConnection[] P_405 = {
			new DBConnection("oc1 / 초", "jdbc:mysql://ebsoc1prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc1prodmysql", "esofedu"),
			new DBConnection("oc1_10 / 초", "jdbc:mysql://ebsoc10prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc10prodmysql", "esofedu"),
			new DBConnection("oc1_11 / 초", "jdbc:mysql://ebsoc11prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc11prodmysql", "esofedu"),
			new DBConnection("oc1_12 / 초", "jdbc:mysql://ebsoc12prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc12prodmysql", "esofedu"),
			new DBConnection("oc1_13 / 초", "jdbc:mysql://ebsoc13prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc13prodmysql", "esofedu"),
			new DBConnection("oc1_14 / 초", "jdbc:mysql://ebsoc14prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc14prodmysql", "esofedu") };
	DBConnection[] P_417 = {
			new DBConnection("oc1 / 초", "jdbc:mysql://ebsoc1prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc1prodmysql", "esofedu"),
			new DBConnection("oc1_10 / 초", "jdbc:mysql://ebsoc10prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc10prodmysql", "esofedu"),
			new DBConnection("oc1_11 / 초", "jdbc:mysql://ebsoc11prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc11prodmysql", "esofedu"),
			new DBConnection("oc1_12 / 초", "jdbc:mysql://ebsoc12prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc12prodmysql", "esofedu"),
			new DBConnection("oc1_13 / 초", "jdbc:mysql://ebsoc13prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc13prodmysql", "esofedu"),
			new DBConnection("oc1_14 / 초", "jdbc:mysql://ebsoc14prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc14prodmysql", "esofedu"),
			new DBConnection("oc1_50 / 초", "jdbc:mysql://ebsoc50prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc50prodmysql", "esofedu") };

	// 중학교
	DBConnection M_317 = new DBConnection("oc2 / 중", "jdbc:mysql://ebsoc2prodmysql.mysql.database.azure.com/ebsesof",
			DBConnection.MYSQL, "esofedu@ebsoc2prodmysql", "esofedu");
	DBConnection[] M_322 = {
			new DBConnection("oc2 / 중", "jdbc:mysql://ebsoc2prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc2prodmysql", "esofedu"),
			new DBConnection("oc2_15 / 중", "jdbc:mysql://ebsoc15prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc15prodmysql", "esofedu"),
			new DBConnection("oc2_16 / 중", "jdbc:mysql://ebsoc16prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc16prodmysql", "esofedu"),
			new DBConnection("oc2_17 / 중", "jdbc:mysql://ebsoc17prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc17prodmysql", "esofedu"),
			new DBConnection("oc2_18 / 중", "jdbc:mysql://ebsoc18prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc18prodmysql", "esofedu"),
			new DBConnection("oc2_19 / 중", "jdbc:mysql://ebsoc19prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc19prodmysql", "esofedu"),
			new DBConnection("oc2_20 / 중", "jdbc:mysql://ebsoc20prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc20prodmysql", "esofedu"),
			new DBConnection("oc2_21 / 중", "jdbc:mysql://ebsoc21prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc21prodmysql", "esofedu"),
			new DBConnection("oc2_22 / 중", "jdbc:mysql://ebsoc22prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc22prodmysql", "esofedu"),
			new DBConnection("oc2_27 / 중", "jdbc:mysql://ebsoc27prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc27prodmysql", "esofedu") };
	DBConnection[] M_405 = {
			new DBConnection("oc2 / 중", "jdbc:mysql://ebsoc2prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc2prodmysql", "esofedu"),
			new DBConnection("oc3 / 중", "jdbc:mysql://ebsoc3prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc3prodmysql", "esofedu"),
			new DBConnection("oc4 / 중", "jdbc:mysql://ebsoc4prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc4prodmysql", "esofedu"),
			new DBConnection("oc5 / 중", "jdbc:mysql://ebsoc5prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc5prodmysql", "esofedu"),
			new DBConnection("oc6 / 중", "jdbc:mysql://ebsoc6prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc6prodmysql", "esofedu"),
			new DBConnection("oc7 / 중", "jdbc:mysql://ebsoc7prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc7prodmysql", "esofedu"),
			new DBConnection("oc8 / 중", "jdbc:mysql://ebsoc8prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc8prodmysql", "esofedu"),
			new DBConnection("oc9 / 중", "jdbc:mysql://ebsoc9prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc9prodmysql", "esofedu"),
			new DBConnection("oc15 / 중", "jdbc:mysql://ebsoc15prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc15prodmysql", "esofedu"),
			new DBConnection("oc16 / 중", "jdbc:mysql://ebsoc16prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc16prodmysql", "esofedu"),
			new DBConnection("oc17 / 중", "jdbc:mysql://ebsoc17prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc17prodmysql", "esofedu"),
			new DBConnection("oc18 / 중", "jdbc:mysql://ebsoc18prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc18prodmysql", "esofedu"),
			new DBConnection("oc19 / 중", "jdbc:mysql://ebsoc19prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc19prodmysql", "esofedu"),
			new DBConnection("oc20 / 중", "jdbc:mysql://ebsoc20prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc20prodmysql", "esofedu"),
			new DBConnection("oc21 / 중", "jdbc:mysql://ebsoc21prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc21prodmysql", "esofedu"),
			new DBConnection("oc22 / 중", "jdbc:mysql://ebsoc22prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc22prodmysql", "esofedu"),
			new DBConnection("oc23 / 중", "jdbc:mysql://ebsoc23prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc23prodmysql", "esofedu"),
			new DBConnection("oc24 / 중", "jdbc:mysql://ebsoc24prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc24prodmysql", "esofedu"),
			new DBConnection("oc25 / 중", "jdbc:mysql://ebsoc25prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc25prodmysql", "esofedu"),
			new DBConnection("oc26 / 중", "jdbc:mysql://ebsoc26prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc26prodmysql", "esofedu"),
			new DBConnection("oc27 / 중", "jdbc:mysql://ebsoc27prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc27prodmysql", "esofedu"),
			new DBConnection("oc28 / 중", "jdbc:mysql://ebsoc28prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc28prodmysql", "esofedu"),
			new DBConnection("oc29 / 중", "jdbc:mysql://ebsoc29prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc29prodmysql", "esofedu"),
			new DBConnection("oc30 / 중", "jdbc:mysql://ebsoc30prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc30prodmysql", "esofedu"),
			new DBConnection("oc31 / 중", "jdbc:mysql://ebsoc31prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc31prodmysql", "esofedu"),
			new DBConnection("oc32 / 중", "jdbc:mysql://ebsoc32prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc32prodmysql", "esofedu"),
			new DBConnection("oc33 / 중", "jdbc:mysql://ebsoc33prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc33prodmysql", "esofedu"),
			new DBConnection("oc34 / 중", "jdbc:mysql://ebsoc34prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc34prodmysql", "esofedu"),
			new DBConnection("oc35 / 중", "jdbc:mysql://ebsoc35prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc35prodmysql", "esofedu"),
			new DBConnection("oc36 / 중", "jdbc:mysql://ebsoc36prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc36prodmysql", "esofedu"),
			new DBConnection("oc37 / 중", "jdbc:mysql://ebsoc37prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc37prodmysql", "esofedu"),
			new DBConnection("oc38 / 중", "jdbc:mysql://ebsoc38prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc38prodmysql", "esofedu"),
			new DBConnection("oc39 / 중", "jdbc:mysql://ebsoc39prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc39prodmysql", "esofedu"),
			new DBConnection("oc40 / 중", "jdbc:mysql://ebsoc40prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc40prodmysql", "esofedu"),
			new DBConnection("oc41 / 중", "jdbc:mysql://ebsoc41prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc41prodmysql", "esofedu"),
			new DBConnection("oc42 / 중", "jdbc:mysql://ebsoc42prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc42prodmysql", "esofedu"),
			new DBConnection("oc43 / 중", "jdbc:mysql://ebsoc43prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc43prodmysql", "esofedu"),
			new DBConnection("oc44 / 중", "jdbc:mysql://ebsoc44prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc44prodmysql", "esofedu"),
			new DBConnection("oc45 / 중", "jdbc:mysql://ebsoc45prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc45prodmysql", "esofedu"),
			new DBConnection("oc46 / 중", "jdbc:mysql://ebsoc46prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc46prodmysql", "esofedu"),
			new DBConnection("oc47 / 중", "jdbc:mysql://ebsoc47prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc47prodmysql", "esofedu"),
			new DBConnection("oc48 / 중", "jdbc:mysql://ebsoc48prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc48prodmysql", "esofedu"),
			new DBConnection("oc49 / 중", "jdbc:mysql://ebsoc49prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsoc49prodmysql", "esofedu") };
	DBConnection[] M_417 = M_405;

	// 고등학교
	DBConnection[] H_317 = {
			new DBConnection("hoc1 / 고 co3", "jdbc:mysql://ebshoc1prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc1prodmysql", "esofedu"),
			new DBConnection("hoc4 / 고 oc4", "jdbc:mysql://ebshoc4prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc4prodmysql", "esofedu"),
			new DBConnection("hoc45 / 고 dg1", "jdbc:mysql://ebshoc45prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc45prodmysql", "esofedu"),
			new DBConnection("hoc46 / 고 dg2", "jdbc:mysql://ebshoc46prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc46prodmysql", "esofedu"),
			new DBConnection("hoc47 / 고 dg3", "jdbc:mysql://ebshoc47prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc47prodmysql", "esofedu"),
			new DBConnection("hoc48 / 고 dg4", "jdbc:mysql://ebshoc48prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc48prodmysql", "esofedu"),
			new DBConnection("hoc49 / 고 dg5", "jdbc:mysql://ebshoc49prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc49prodmysql", "esofedu") };
	DBConnection[] H_322 = {
			new DBConnection("hoc1 / 고 oc3", "jdbc:mysql://ebshoc1prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc1prodmysql", "esofedu"),
			new DBConnection("hoc4 / 고 oc3", "jdbc:mysql://ebshoc4prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc4prodmysql", "esofedu"),
			new DBConnection("hoc45 / 고 dg1", "jdbc:mysql://ebshoc45prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc45prodmysql", "esofedu"),
			new DBConnection("hoc46 / 고 dg2", "jdbc:mysql://ebshoc46prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc46prodmysql", "esofedu"),
			new DBConnection("hoc47 / 고 dg3", "jdbc:mysql://ebshoc47prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc47prodmysql", "esofedu"),
			new DBConnection("hoc48 / 고 dg4", "jdbc:mysql://ebshoc48prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc48prodmysql", "esofedu"),
			new DBConnection("hoc49 / 고 dg5", "jdbc:mysql://ebshoc49prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc49prodmysql", "esofedu"),
			new DBConnection("hoc7 / 고 oc3_35", "jdbc:mysql://ebshoc7prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc7prodmysql", "esofedu"),
			new DBConnection("hoc10 / 고 oc3_36", "jdbc:mysql://ebshoc10prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc10prodmysql", "esofedu"),
			new DBConnection("hoc13 / 고 oc3_37", "jdbc:mysql://ebshoc13prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc13prodmysql", "esofedu"),
			new DBConnection("hoc16 / 고 oc3_38", "jdbc:mysql://ebshoc16prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc16prodmysql", "esofedu"),
			new DBConnection("hoc28 / 고 oc3_42", "jdbc:mysql://ebshoc28prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc28prodmysql", "esofedu"),
			new DBConnection("hoc31 / 고 oc3_43", "jdbc:mysql://ebshoc31prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc31prodmysql", "esofedu"),
			new DBConnection("hoc33 / 고 oc3_44", "jdbc:mysql://ebshoc33prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc33prodmysql", "esofedu"),
			new DBConnection("hoc35 / 고 oc3_45", "jdbc:mysql://ebshoc35prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc35prodmysql", "esofedu") };
	DBConnection[] H_405 = {
			new DBConnection("hoc1", "jdbc:mysql://ebshoc1prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc1prodmysql", "esofedu"),
			new DBConnection("hoc2", "jdbc:mysql://ebshoc2prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc2prodmysql", "esofedu"),
			new DBConnection("hoc3", "jdbc:mysql://ebshoc3prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc3prodmysql", "esofedu"),
			new DBConnection("hoc4", "jdbc:mysql://ebshoc4prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc4prodmysql", "esofedu"),
			new DBConnection("hoc5", "jdbc:mysql://ebshoc5prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc5prodmysql", "esofedu"),
			new DBConnection("hoc6", "jdbc:mysql://ebshoc6prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc6prodmysql", "esofedu"),
			new DBConnection("hoc7", "jdbc:mysql://ebshoc7prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc7prodmysql", "esofedu"),
			new DBConnection("hoc8", "jdbc:mysql://ebshoc8prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc8prodmysql", "esofedu"),
			new DBConnection("hoc9", "jdbc:mysql://ebshoc9prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc9prodmysql", "esofedu"),
			new DBConnection("hoc10", "jdbc:mysql://ebshoc10prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc10prodmysql", "esofedu"),
			new DBConnection("hoc11", "jdbc:mysql://ebshoc11prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc11prodmysql", "esofedu"),
			new DBConnection("hoc12", "jdbc:mysql://ebshoc12prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc12prodmysql", "esofedu"),
			new DBConnection("hoc13", "jdbc:mysql://ebshoc13prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc13prodmysql", "esofedu"),
			new DBConnection("hoc14", "jdbc:mysql://ebshoc14prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc14prodmysql", "esofedu"),
			new DBConnection("hoc15", "jdbc:mysql://ebshoc15prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc15prodmysql", "esofedu"),
			new DBConnection("hoc16", "jdbc:mysql://ebshoc16prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc16prodmysql", "esofedu"),
			new DBConnection("hoc17", "jdbc:mysql://ebshoc17prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc17prodmysql", "esofedu"),
			new DBConnection("hoc18", "jdbc:mysql://ebshoc18prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc18prodmysql", "esofedu"),
			new DBConnection("hoc19", "jdbc:mysql://ebshoc19prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc19prodmysql", "esofedu"),
			new DBConnection("hoc20", "jdbc:mysql://ebshoc20prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc20prodmysql", "esofedu"),
			new DBConnection("hoc21", "jdbc:mysql://ebshoc21prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc21prodmysql", "esofedu"),
			new DBConnection("hoc22", "jdbc:mysql://ebshoc22prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc22prodmysql", "esofedu"),
			new DBConnection("hoc23", "jdbc:mysql://ebshoc23prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc23prodmysql", "esofedu"),
			new DBConnection("hoc24", "jdbc:mysql://ebshoc24prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc24prodmysql", "esofedu"),
			new DBConnection("hoc25", "jdbc:mysql://ebshoc25prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc25prodmysql", "esofedu"),
			new DBConnection("hoc26", "jdbc:mysql://ebshoc26prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc26prodmysql", "esofedu"),
			new DBConnection("hoc27", "jdbc:mysql://ebshoc27prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc27prodmysql", "esofedu"),
			new DBConnection("hoc28", "jdbc:mysql://ebshoc28prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc28prodmysql", "esofedu"),
			new DBConnection("hoc29", "jdbc:mysql://ebshoc29prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc29prodmysql", "esofedu"),
			new DBConnection("hoc30", "jdbc:mysql://ebshoc30prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc30prodmysql", "esofedu"),
			new DBConnection("hoc31", "jdbc:mysql://ebshoc31prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc31prodmysql", "esofedu"),
			new DBConnection("hoc32", "jdbc:mysql://ebshoc32prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc32prodmysql", "esofedu"),
			new DBConnection("hoc33", "jdbc:mysql://ebshoc33prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc33prodmysql", "esofedu"),
			new DBConnection("hoc34", "jdbc:mysql://ebshoc34prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc34prodmysql", "esofedu"),
			new DBConnection("hoc35", "jdbc:mysql://ebshoc35prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc35prodmysql", "esofedu"),
			new DBConnection("hoc36", "jdbc:mysql://ebshoc36prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc36prodmysql", "esofedu"),
			new DBConnection("hoc37", "jdbc:mysql://ebshoc37prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc37prodmysql", "esofedu"),
			new DBConnection("hoc38", "jdbc:mysql://ebshoc38prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc38prodmysql", "esofedu"),
			new DBConnection("hoc39", "jdbc:mysql://ebshoc39prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc39prodmysql", "esofedu"),
			new DBConnection("hoc40", "jdbc:mysql://ebshoc40prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc40prodmysql", "esofedu"),
			new DBConnection("hoc41", "jdbc:mysql://ebshoc41prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc41prodmysql", "esofedu"),
			new DBConnection("hoc42", "jdbc:mysql://ebshoc42prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc42prodmysql", "esofedu"),
			new DBConnection("hoc43", "jdbc:mysql://ebshoc43prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc43prodmysql", "esofedu"),
			new DBConnection("hoc44", "jdbc:mysql://ebshoc44prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc44prodmysql", "esofedu"),
			new DBConnection("hoc45", "jdbc:mysql://ebshoc45prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc45prodmysql", "esofedu"),
			new DBConnection("hoc46", "jdbc:mysql://ebshoc46prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc46prodmysql", "esofedu"),
			new DBConnection("hoc47", "jdbc:mysql://ebshoc47prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc47prodmysql", "esofedu"),
			new DBConnection("hoc48", "jdbc:mysql://ebshoc48prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc48prodmysql", "esofedu"),
			new DBConnection("hoc49", "jdbc:mysql://ebshoc49prodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshoc49prodmysql", "esofedu") };

	DBConnection[] H_417 = H_405;

	Map<String, DBConnection> allDb = new HashMap<>();

	List<DBConnection> allDbs = new ArrayList<>();

	public static void main(String[]args){
		AVGService s = new AVGService();
		
		try {
			s.onEvent("egov");
		} catch (Exception e) {
			// TKTAG Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public AVGService() {
		init();
	}
	
	public void init() {

		mainDb.put("P", POC);
		mainDb.put("M", POC);
		mainDb.put("H", HOC);

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
		allDbs.add(new DBConnection("oc50", "P", "jdbc:mysql://ebsoc50prodmysql.mysql.database.azure.com/ebsesof", DBConnection.MYSQL, "esofedu@ebsoc50prodmysql", "esofedu"));
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

		for (DBConnection db : allDbs) {
			allDb.put(db.getName(), db);
		}

	}

	public void onEvent(String evtNm) throws Exception {

		if ("egov".equals(evtNm)) {
			Thread t = new Thread() {
				@Override
				public void run() {
					Calendar trgetDate = Calendar.getInstance();
					trgetDate.add(Calendar.DATE, 1);
					final Calendar date = trgetDate;
					egov(date);
				}
			};
			t.start();
		} else if ("schul".equals(evtNm)) {
			Thread t = new Thread() {
				@Override
				public void run() {
					Calendar trgetDate = Calendar.getInstance();
					// Calendar trgetDate = Calendar.getInstance();

					// if(trgetDate == null) trgetDate = Calendar.getInstance();
					// else trgetDate.add(Calendar.DATE, 1);

					if (trgetDate == null)
						return;
					trgetDate.add(Calendar.DATE, 1);
					final Calendar date = trgetDate;
					schul(date);
				}
			};
			t.start();
		} else if ("gradeJoin".equals(evtNm)) {
			Thread t = new Thread() {
				@Override
				public void run() {
					Calendar trgetDate = Calendar.getInstance();
					// Calendar trgetDate = Calendar.getInstance();

					// if(trgetDate == null) trgetDate = Calendar.getInstance();
					// else trgetDate.add(Calendar.DATE, 1);
					if (trgetDate == null)
						return;
					trgetDate.add(Calendar.DATE, 1);
					final Calendar date = trgetDate;
					gradeJoinCnt(date);
				}
			};
			t.start();
		} else if ("daeguCreateJoin".equals(evtNm)) {
			Thread t = new Thread() {
				@Override
				public void run() {
					Calendar trgetDate = Calendar.getInstance();
					// Calendar trgetDate = Calendar.getInstance();

					// if(trgetDate == null) trgetDate = Calendar.getInstance();
					// else trgetDate.add(Calendar.DATE, 1);
					if (trgetDate == null)
						return;
					final Calendar date = trgetDate;
					daeguCreateJoin(date);
				}
			};
			t.start();
		} 

	}

	// 교육부 통계
	/**
	 * @Date : 2020. 3. 22.
	 * @Role :
	 * @Dcpt :
	 */
	Integer egovComplCnt = 0;

	public void egov(Calendar trgetDate) {

		trgetDate.set(Calendar.HOUR_OF_DAY, 23);

		String[] schulCodes = { "P", "M", "H" };

		String m0317_2130 = "202003172130";
		String m0322_2130 = "202003222130";
		String m0405_0100 = "202004052130";
		String m0417_0000 = "202004170000";

		final Calendar date = trgetDate;

		for (String schulCode : schulCodes) {
			Thread t = new Thread() {
				@Override
				public void run() {

					Calendar dd = Calendar.getInstance();
					dd.setTime(trgetDate.getTime());
					dd.add(Calendar.DATE, -1);

					System.out.println(" ( " + fmt2.format(dd.getTime()) + " 기준 )");
					egov1(date, schulCode, m0317_2130, m0322_2130, m0405_0100, m0417_0000);
					egov2(date, schulCode, m0317_2130, m0322_2130, m0405_0100, m0417_0000);
					egov3(date, schulCode, m0317_2130, m0322_2130, m0405_0100, m0417_0000);
					egov4(date, schulCode, m0317_2130, m0322_2130, m0405_0100, m0417_0000);
					egovComplCnt++;

					if (egovComplCnt == 3) {
						System.out.println("교육부 통계 종료");
					}
				}
			};
			t.start();
		}
	}

	// 가입수, 개설수 -- 승인, 폐쇄 ( 불일정 )
	public void egov1(Calendar trgetDate, String schulCode, String m1_0317_2130, String m2_0322_2130, String m0405_0100,
			String m0417_0000) {

		/*
		 * 가입수, 개설수
		 */
		String egovQuery1_1 = "" + "SELECT COUNT(*) FROM ("
				+ "  SELECT TLHO.HMPG_OPER_SN, TLHOM.USER_SN, COUNT(*) AS cnt" + "  FROM TB_LEM_HMPG_OPER_MBER TLHOM"
				+ "	 INNER JOIN TB_LEM_HMPG_OPER TLHO ON TLHOM.HMPG_OPER_SN = TLHO.HMPG_OPER_SN"
				+ "	 INNER JOIN TB_SCM_SCHUL SCHUL ON TLHO.SCHUL_CODE = SCHUL.SCHUL_CODE"
				+ "  WHERE TLHO.HMPG_SE_CODE = '005'" + "  AND TLHOM.MBER_STTUS_CODE = '005'"
				+ "  AND SCHUL.SCHUL_LEVEL_CODE = ?" + "  AND DATE_FORMAT(TLHOM.FRST_REGIST_PNTTM,'%Y%m%d%H%i') <= ?"
				+ "  GROUP BY TLHOM.USER_SN, TLHO.HMPG_OPER_SN" + "  )a ";
		String egovQuery1_2 = "" + "SELECT COUNT(*) FROM ("
				+ "  SELECT TLHO.HMPG_OPER_SN, TLHOM.USER_SN, COUNT(*) AS cnt" + "  FROM TB_LEM_HMPG_OPER_MBER TLHOM"
				+ "	 INNER JOIN TB_LEM_HMPG_OPER TLHO ON TLHOM.HMPG_OPER_SN = TLHO.HMPG_OPER_SN"
				+ "	 INNER JOIN TB_SCM_SCHUL SCHUL ON TLHO.SCHUL_CODE = SCHUL.SCHUL_CODE"
				+ "  WHERE TLHO.HMPG_SE_CODE = '005'" + "  AND TLHOM.MBER_STTUS_CODE = '005'"
				+ "  AND SCHUL.SCHUL_LEVEL_CODE = ?" + "  AND (DATE_FORMAT(TLHOM.FRST_REGIST_PNTTM ,'%Y%m%d%H%i') > ?"
				+ "  and DATE_FORMAT(TLHOM.FRST_REGIST_PNTTM ,'%Y%m%d%H%i') <= ?)"
				+ "  GROUP BY TLHOM.USER_SN, TLHO.HMPG_OPER_SN" + "  )a ";

		String egovQuery2_1 = "" + "SELECT COUNT(1)" + "  FROM TB_LEM_HMPG_OPER HO"
				+ "  INNER JOIN TB_SUM_HMPG_REQST HR ON HO.HMPG_REQST_SN = HR.HMPG_REQST_SN "
				+ "  INNER JOIN TB_SCM_SCHUL SCHUL ON HO.SCHUL_CODE = SCHUL.SCHUL_CODE"
				+ "  WHERE HO.HMPG_SE_CODE = '005'" + "  AND HO.ESTBL_STTUS_CODE = '005'"
				+ "  AND (HR.CLS_STTUS_CODE IS NULL OR HR.CLS_STTUS_CODE <> '005')" + "  AND SCHUL.SCHUL_LEVEL_CODE = ?" // 초등
				+ "  AND DATE_FORMAT(HO.FRST_REGIST_PNTTM,'%Y%m%d%H%i') <= ?";
		String egovQuery2_2 = "" + "SELECT COUNT(1)" + "  FROM TB_LEM_HMPG_OPER HO"
				+ "  INNER JOIN TB_SUM_HMPG_REQST HR ON HO.HMPG_REQST_SN = HR.HMPG_REQST_SN "
				+ "  INNER JOIN TB_SCM_SCHUL SCHUL ON HO.SCHUL_CODE = SCHUL.SCHUL_CODE"
				+ "  WHERE HO.HMPG_SE_CODE = '005'" + "  AND HO.ESTBL_STTUS_CODE = '005'"
				+ "  AND (HR.CLS_STTUS_CODE IS NULL OR HR.CLS_STTUS_CODE <> '005')" + "  AND SCHUL.SCHUL_LEVEL_CODE = ?" // 초등
				+ "  AND (DATE_FORMAT(HO.FRST_REGIST_PNTTM ,'%Y%m%d%H%i') > ?"
				+ "  and DATE_FORMAT(HO.FRST_REGIST_PNTTM ,'%Y%m%d%H%i') <= ?)";

//		System.out.println("#### 가입수, 개설수 ####");

		Calendar sCal = Calendar.getInstance();
		Calendar eCal = Calendar.getInstance();

		// 어제 오전 12시 ~ 오늘 오전 12시
		eCal.setTime(trgetDate.getTime());
		sCal.setTime(eCal.getTime());

		while (true) {

			if (sCal.compareTo(eCal) > 0) break;

			Calendar yCal = Calendar.getInstance();
			yCal.setTime(sCal.getTime());
			yCal.add(Calendar.DATE, ystrDay);

			String sYDayStr = s_fmt.format(yCal.getTime()); // 어제
			String sDayStr = e_fmt.format(sCal.getTime()); // 오늘

//			System.out.print(fmt2.format(yCal.getTime()) + " " + schulCode + " )");

			DBConnection db = getMainDB(schulCode);

			Integer resultA = query(db, egovQuery1_1, schulCode, sDayStr);
			Integer resultB = query(db, egovQuery1_2, schulCode, sYDayStr, sDayStr);
			Integer resultC = query(db, egovQuery2_1, schulCode, sDayStr);
			Integer resultD = query(db, egovQuery2_2, schulCode, sYDayStr, sDayStr);

			System.out.println("\n" + getShculLevelNm(schulCode) + " 가입수 :" + resultB + " / " + resultA);
			System.out.println("\n" + getShculLevelNm(schulCode) + " 개설수 : " + resultD + " / " + resultC);

			sCal.add(Calendar.DATE, 1);
		}

	}

	// 강좌 개설수 -- 취소가능 ( 불일정 )
	public void egov2(Calendar trgetDate, String schulCode, String m1_0317_2130, String m2_0322_2130, String m0405_0100,
			String m0417_0000) {

		/*
		 * 강좌 개설수
		 */
		String egovQuery3_1 = "" + " SELECT COUNT(*)" + " FROM TB_LCM_ALCTCR_MANAGE AM"
				+ " INNER JOIN TB_LEM_HMPG_OPER HO ON AM.HMPG_OPER_SN = HO.HMPG_OPER_SN"
				+ " INNER JOIN TB_SCM_SCHUL SC ON HO.SCHUL_CODE = SC.SCHUL_CODE" + " WHERE 1=1"
				+ " AND AM.ALCTCR_TY = 1" + " AND AM.HMPG_SE_CODE = '005'" + " AND AM.ORGINL_ALCTCR_SN IS NOT NULL"
				+ " AND AM.STTUS_CODE = '005'" + " AND AM.CLS_AT <> 1" + " AND SC.SCHUL_LEVEL_CODE = ?"
				+ " AND DATE_FORMAT(AM.LAST_UPDT_PNTTM, '%Y%m%d%H%i') <= ?";

		String egovQuery3_2 = "" + " SELECT COUNT(*)" + " FROM TB_LCM_ALCTCR_MANAGE AM"
				+ " INNER JOIN TB_LEM_HMPG_OPER HO ON AM.HMPG_OPER_SN = HO.HMPG_OPER_SN"
				+ " INNER JOIN TB_SCM_SCHUL SC ON HO.SCHUL_CODE = SC.SCHUL_CODE" + " WHERE 1=1"
				+ " AND AM.ALCTCR_TY = 1" + " AND AM.HMPG_SE_CODE = '005'" + " AND AM.ORGINL_ALCTCR_SN IS NOT NULL"
				+ " AND AM.STTUS_CODE = '005'" + " AND AM.CLS_AT <> 1" + " AND SC.SCHUL_LEVEL_CODE = ?"
				+ " AND (DATE_FORMAT(AM.LAST_UPDT_PNTTM ,'%Y%m%d%H%i') > ?"
				+ " AND DATE_FORMAT(AM.LAST_UPDT_PNTTM ,'%Y%m%d%H%i') <= ?)";

//		System.out.println("#### 강좌개설수 ####");

		Calendar sCal = Calendar.getInstance();
		Calendar eCal = Calendar.getInstance();

		eCal.setTime(trgetDate.getTime());

		
		sCal.setTime(eCal.getTime());

		List<DBConnection> dbs_317 = new ArrayList<>();
		List<DBConnection> dbs_322 = new ArrayList<>();
		List<DBConnection> dbs_405 = new ArrayList<>();
		List<DBConnection> dbs_417 = new ArrayList<>();

		if ("P".equals(schulCode)) {
			dbs_317.addAll(Arrays.asList(P_317));
			dbs_322.addAll(Arrays.asList(P_322));
			dbs_405.addAll(Arrays.asList(P_405));
			dbs_417.addAll(Arrays.asList(P_417));
		} else if ("M".equals(schulCode)) {
			dbs_317.addAll(Arrays.asList(M_317));
			dbs_322.addAll(Arrays.asList(M_322));
			dbs_405.addAll(Arrays.asList(M_405));
			dbs_417.addAll(Arrays.asList(M_417));
		} else if ("H".equals(schulCode)) {
			dbs_317.addAll(Arrays.asList(H_317));
			dbs_322.addAll(Arrays.asList(H_322));
			dbs_405.addAll(Arrays.asList(H_405));
			dbs_417.addAll(Arrays.asList(H_417));
		}

		while (true) {

			if (sCal.compareTo(eCal) > 0)
				break;

			Calendar yCal = Calendar.getInstance();
			yCal.setTime(sCal.getTime());
			yCal.add(Calendar.DATE, ystrDay);

			String sYDayStr = s_fmt.format(yCal.getTime()); // 어제
			String sDayStr = e_fmt.format(sCal.getTime()); // 오늘

//			System.out.print(fmt2.format(yCal.getTime()) + " " + schulCode + " )");

			Integer resultA = 0;
			Integer resultB = 0;

			// 서버분할 17일
			if (sDayStr.compareTo(m1_0317_2130) < 1) {

				// 1차 분할전 누적, 신규
				resultA = query(mainDb.get(schulCode), egovQuery3_1, schulCode, sDayStr);
				resultB = query(mainDb.get(schulCode), egovQuery3_2, schulCode, sYDayStr, sDayStr);

				// 서버분할 22일
			} else if (sDayStr.compareTo(m2_0322_2130) < 1) {

				// 1차 분할전 누적
				resultA = query(mainDb.get(schulCode), egovQuery3_1, schulCode, m1_0317_2130);

				// 1차 분할 후 누적
				for (DBConnection db : dbs_317) {
					resultA += query(db, egovQuery3_2, schulCode, m1_0317_2130, sDayStr);
				}

				// 1차 분할 후 신규
				for (DBConnection db : dbs_317) {
					resultB += query(db, egovQuery3_2, schulCode, sYDayStr, sDayStr);
				}

				// 서버분할 4-5일
			} else if (sDayStr.compareTo(m0405_0100) < 1) {

				// 1차 분할전 누적
				resultA = query(mainDb.get(schulCode), egovQuery3_1, schulCode, m1_0317_2130);

				// 2차 분할 전 누적
				for (DBConnection db : dbs_317) {
					resultA += query(db, egovQuery3_2, schulCode, m1_0317_2130, m2_0322_2130);
				}

				// 2차 분할 후 누적
				for (DBConnection db : dbs_322) {
					resultA += query(db, egovQuery3_2, schulCode, m2_0322_2130, sDayStr);
				}

				// 2차 분할 후 신규
				for (DBConnection db : dbs_322) {
					resultB += query(db, egovQuery3_2, schulCode, sYDayStr, sDayStr);
				}

			} else if (sDayStr.compareTo(m0417_0000) < 1) {

				// 1차 분할전 누적
				resultA = query(mainDb.get(schulCode), egovQuery3_1, schulCode, m1_0317_2130);

				// 2차 분할 전 누적
				for (DBConnection db : dbs_317) {
					resultA += query(db, egovQuery3_2, schulCode, m1_0317_2130, m2_0322_2130);
				}

				// 3차 분할 전 누적
				for (DBConnection db : dbs_322) {
					resultA += query(db, egovQuery3_2, schulCode, m2_0322_2130, m0405_0100);
				}

				// 3차 분할 후 누적
				for (DBConnection db : dbs_405) {
					resultA += query(db, egovQuery3_2, schulCode, m0405_0100, sDayStr);
				}

				// 3차 분할 후 신규
				for (DBConnection db : dbs_405) {
					resultB += query(db, egovQuery3_2, schulCode, sYDayStr, sDayStr);
				}

			} else {
				// 1차 분할전 누적
				resultA = query(mainDb.get(schulCode), egovQuery3_1, schulCode, m1_0317_2130);

				// 2차 분할 전 누적
				for (DBConnection db : dbs_317) {
					resultA += query(db, egovQuery3_2, schulCode, m1_0317_2130, m2_0322_2130);
				}

				// 3차 분할 전 누적
				for (DBConnection db : dbs_322) {
					resultA += query(db, egovQuery3_2, schulCode, m2_0322_2130, m0405_0100);
				}

				// 4차 분할 전 누적
				for (DBConnection db : dbs_405) {
					resultA += query(db, egovQuery3_2, schulCode, m0405_0100, m0417_0000);
				}

				// 4차 분할 후 누적
				for (DBConnection db : dbs_417) {
					resultA += query(db, egovQuery3_2, schulCode, m0417_0000, sDayStr);
				}

				// 4차 분할 후 신규
				for (DBConnection db : dbs_417) {
					resultB += query(db, egovQuery3_2, schulCode, sYDayStr, sDayStr);
				}
			}

			System.out.println("강좌개설수 (" + getShculLevelNm(schulCode) + ") : " + resultB + " / " + resultA);

			sCal.add(Calendar.DATE, 1);
		}

	}

	// 수강 신청수 -- ( 일정 )
	public void egov3(Calendar trgetDate, String schulCode, String m1_0317_2130, String m2_0322_2130, String m0405_0100,
			String m0417_0000) {

		/*
		 * 강좌 신청수
		 */
		String egovQuery3_1 = "" + "SELECT count(AA.ATNLC_NO)" + "  FROM TB_LEM_ALCTCR_ATNLC AA"
				+ "  INNER JOIN TB_LCM_ALCTCR_MANAGE AM ON AA.ALCTCR_SN = AM.ALCTCR_SN"
				+ "  INNER JOIN TB_LEM_HMPG_OPER OP ON AM.HMPG_OPER_SN = OP.HMPG_OPER_SN"
				+ "  INNER JOIN TB_SCM_SCHUL SCHUL ON SCHUL.SCHUL_CODE = OP.SCHUL_CODE"
				+ "  WHERE AM.HMPG_SE_CODE = '005'" + "  AND SCHUL.SCHUL_LEVEL_CODE = ?"
				+ "  AND DATE_FORMAT(AA.ATNLC_REQST_DT,'%Y%m%d%H%i') <= ?";

		String egovQuery3_2 = "" + "SELECT count(AA.ATNLC_NO)" + "  FROM TB_LEM_ALCTCR_ATNLC AA"
				+ "  INNER JOIN TB_LCM_ALCTCR_MANAGE AM ON AA.ALCTCR_SN = AM.ALCTCR_SN"
				+ "  INNER JOIN TB_LEM_HMPG_OPER OP ON AM.HMPG_OPER_SN = OP.HMPG_OPER_SN"
				+ "  INNER JOIN TB_SCM_SCHUL SCHUL ON SCHUL.SCHUL_CODE = OP.SCHUL_CODE"
				+ "  WHERE AM.HMPG_SE_CODE = '005'" + "  AND SCHUL.SCHUL_LEVEL_CODE = ?"
				+ "  AND (DATE_FORMAT(AA.ATNLC_REQST_DT ,'%Y%m%d%H%i') > ? "
				+ "  AND DATE_FORMAT(AA.ATNLC_REQST_DT ,'%Y%m%d%H%i') <= ?)";

//		System.out.println("#### 수강신청수 ####");

		Calendar sCal = Calendar.getInstance();
		Calendar eCal = Calendar.getInstance();

		eCal.setTime(trgetDate.getTime());

		sCal.setTime(eCal.getTime());

		List<DBConnection> dbs_317 = new ArrayList<>();
		List<DBConnection> dbs_322 = new ArrayList<>();
		List<DBConnection> dbs_405 = new ArrayList<>();
		List<DBConnection> dbs_417 = new ArrayList<>();

		if ("P".equals(schulCode)) {
			dbs_317.addAll(Arrays.asList(P_317));
			dbs_322.addAll(Arrays.asList(P_322));
			dbs_405.addAll(Arrays.asList(P_405));
			dbs_417.addAll(Arrays.asList(P_417));
		} else if ("M".equals(schulCode)) {
			dbs_317.addAll(Arrays.asList(M_317));
			dbs_322.addAll(Arrays.asList(M_322));
			dbs_405.addAll(Arrays.asList(M_405));
			dbs_417.addAll(Arrays.asList(M_417));
		} else if ("H".equals(schulCode)) {
			dbs_317.addAll(Arrays.asList(H_317));
			dbs_322.addAll(Arrays.asList(H_322));
			dbs_405.addAll(Arrays.asList(H_405));
			dbs_417.addAll(Arrays.asList(H_417));
		}

		while (true) {

			if (sCal.compareTo(eCal) > 0)
				break;

			Calendar yCal = Calendar.getInstance();
			yCal.setTime(sCal.getTime());
			yCal.add(Calendar.DATE, ystrDay);

			String sYDayStr = s_fmt.format(yCal.getTime()); // 어제
			String sDayStr = e_fmt.format(sCal.getTime()); // 오늘

//			System.out.print(fmt2.format(yCal.getTime()) + " " + schulCode + " )");

			Integer resultA = 0;
			Integer resultB = 0;

			// 서버분할 17일
			if (sDayStr.compareTo(m1_0317_2130) < 1) {

				// 1차 분할전 누적, 신규
				resultA = query(mainDb.get(schulCode), egovQuery3_1, schulCode, sDayStr);
				resultB = query(mainDb.get(schulCode), egovQuery3_2, schulCode, sYDayStr, sDayStr);

				// 서버분할 22일
			} else if (sDayStr.compareTo(m2_0322_2130) < 1) {

				// 1차 분할전 누적
				resultA = query(mainDb.get(schulCode), egovQuery3_1, schulCode, m1_0317_2130);

				// 1차 분할 후 누적
				for (DBConnection db : dbs_317) {
					resultA += query(db, egovQuery3_2, schulCode, m1_0317_2130, sDayStr);
				}

				// 1차 분할 후 신규
				for (DBConnection db : dbs_317) {
					resultB += query(db, egovQuery3_2, schulCode, sYDayStr, sDayStr);
				}

				// 서버분할 4-5일
			} else if (sDayStr.compareTo(m0405_0100) < 1) {

				// 1차 분할전 누적
				resultA = query(mainDb.get(schulCode), egovQuery3_1, schulCode, m1_0317_2130);

				// 2차 분할 전 누적
				for (DBConnection db : dbs_317) {
					resultA += query(db, egovQuery3_2, schulCode, m1_0317_2130, m2_0322_2130);
				}

				// 2차 분할 후 누적
				for (DBConnection db : dbs_322) {
					resultA += query(db, egovQuery3_2, schulCode, m2_0322_2130, sDayStr);
				}

				// 2차 분할 후 신규
				for (DBConnection db : dbs_322) {
					resultB += query(db, egovQuery3_2, schulCode, sYDayStr, sDayStr);
				}

			} else if (sDayStr.compareTo(m0417_0000) < 1) {

				// 1차 분할전 누적
				resultA = query(mainDb.get(schulCode), egovQuery3_1, schulCode, m1_0317_2130);

				// 2차 분할 전 누적
				for (DBConnection db : dbs_317) {
					resultA += query(db, egovQuery3_2, schulCode, m1_0317_2130, m2_0322_2130);
				}

				// 3차 분할 전 누적
				for (DBConnection db : dbs_322) {
					resultA += query(db, egovQuery3_2, schulCode, m2_0322_2130, m0405_0100);
				}

				// 3차 분할 후 누적
				for (DBConnection db : dbs_405) {
					resultA += query(db, egovQuery3_2, schulCode, m0405_0100, sDayStr);
				}

				// 3차 분할 후 신규
				for (DBConnection db : dbs_405) {
					resultB += query(db, egovQuery3_2, schulCode, sYDayStr, sDayStr);
				}

			} else {
				// 1차 분할전 누적
				resultA = query(mainDb.get(schulCode), egovQuery3_1, schulCode, m1_0317_2130);

				// 2차 분할 전 누적
				for (DBConnection db : dbs_317) {
					resultA += query(db, egovQuery3_2, schulCode, m1_0317_2130, m2_0322_2130);
				}

				// 3차 분할 전 누적
				for (DBConnection db : dbs_322) {
					resultA += query(db, egovQuery3_2, schulCode, m2_0322_2130, m0405_0100);
				}

				// 4차 분할 전 누적
				for (DBConnection db : dbs_405) {
					resultA += query(db, egovQuery3_2, schulCode, m0405_0100, m0417_0000);
				}

				// 4차 분할 후 누적
				for (DBConnection db : dbs_417) {
					resultA += query(db, egovQuery3_2, schulCode, m0417_0000, sDayStr);
				}

				// 4차 분할 후 신규
				for (DBConnection db : dbs_417) {
					resultB += query(db, egovQuery3_2, schulCode, sYDayStr, sDayStr);
				}
			}

			System.out.println("수강 신청수 (" + getShculLevelNm(schulCode) + ") : " + resultB + " / " + resultA);

			sCal.add(Calendar.DATE, 1);
		}

	}

	// 이용자수, 이용건수 -- ( 일정 )
	public void egov4(Calendar trgetDate, String schulCode, String m1_0317_2130, String m2_0322_2130, String m0405_0100,
			String m0417_0000) {

		String egovQuery4 = "" + "SELECT count(*)" + "  FROM (" + "  SELECT REGIST_SN, COUNT(*) cnt"
				+ "	 FROM TB_LEM_CNTNTS_USE TLCU"
				+ "	 INNER JOIN TB_LCM_ALCTCR_MANAGE AM ON TLCU.ALCTCR_SN = AM.ALCTCR_SN"
				+ "  INNER JOIN TB_LEM_HMPG_OPER OP ON OP.HMPG_OPER_SN = AM.HMPG_OPER_SN"
				+ "  INNER JOIN TB_SCM_SCHUL SC ON SC.SCHUL_CODE = OP.SCHUL_CODE" + "	 WHERE 1=1"
				+ "	 AND TLCU.CNTNTS_USE_TY_CODE = '001'" + "	 AND AM.ALCTCR_TY = 1" // 가져오기,
																						// 만들기
																						// =
																						// 1
																						// //
																						// EBS
																						// 원본
																						// 강좌
																						// =
																						// 6
				+ "	 AND AM.HMPG_SE_CODE = '005'" + "	 AND AM.ORGINL_ALCTCR_SN IS NOT NULL "
				+ "	 AND (DATE_FORMAT(TLCU.REGIST_PNTTM ,'%Y%m%d%H%i') > ? "
				+ "	 AND DATE_FORMAT(TLCU.REGIST_PNTTM ,'%Y%m%d%H%i') <= ? )" + "  AND SC.SCHUL_LEVEL_CODE = ?"
				+ "	 GROUP BY REGIST_SN" + "  )a";

		String egovQuery5 = ""
				+ "  SELECT COUNT(*) FROM ("
					+ "	 SELECT LCTRE_SN, REGIST_SN"
					+ "	 FROM TB_LEM_CNTNTS_USE TLCU"
					+ "	 INNER JOIN TB_LCM_ALCTCR_MANAGE AM ON TLCU.ALCTCR_SN = AM.ALCTCR_SN"
					+ "  INNER JOIN TB_LEM_HMPG_OPER OP ON OP.HMPG_OPER_SN = AM.HMPG_OPER_SN"
					+ "  INNER JOIN TB_SCM_SCHUL SC ON SC.SCHUL_CODE = OP.SCHUL_CODE"
					+ "  WHERE 1=1"
					+ "	 AND TLCU.CNTNTS_USE_TY_CODE = '001'"
					+ "	 AND AM.ALCTCR_TY = 1" // 가져오기, 만들기=1// EBS원본강좌=6
					+ "	 AND AM.HMPG_SE_CODE = '005'"
					+ "	 AND AM.ORGINL_ALCTCR_SN IS NOT NULL "
					+ "	 AND (DATE_FORMAT(TLCU.REGIST_PNTTM ,'%Y%m%d%H%i') > ? "
					+ "	 AND DATE_FORMAT(TLCU.REGIST_PNTTM ,'%Y%m%d%H%i') <= ? )"
					+ "  AND SC.SCHUL_LEVEL_CODE = ?"
					+ "	 GROUP BY LCTRE_SN, REGIST_SN"
				+ "  )a";

//		System.out.println("#### 이용자수, 이용건수 ####");

		Calendar sCal = Calendar.getInstance();
		Calendar eCal = Calendar.getInstance();

		eCal.setTime(trgetDate.getTime());

		sCal.setTime(eCal.getTime());

		List<DBConnection> dbs_317 = new ArrayList<>();
		List<DBConnection> dbs_322 = new ArrayList<>();
		List<DBConnection> dbs_405 = new ArrayList<>();
		List<DBConnection> dbs_417 = new ArrayList<>();

		if ("P".equals(schulCode)) {
			dbs_317.addAll(Arrays.asList(P_317));
			dbs_322.addAll(Arrays.asList(P_322));
			dbs_405.addAll(Arrays.asList(P_405));
			dbs_417.addAll(Arrays.asList(P_417));
		} else if ("M".equals(schulCode)) {
			dbs_317.addAll(Arrays.asList(M_317));
			dbs_322.addAll(Arrays.asList(M_322));
			dbs_405.addAll(Arrays.asList(M_405));
			dbs_417.addAll(Arrays.asList(M_417));
		} else if ("H".equals(schulCode)) {
			dbs_317.addAll(Arrays.asList(H_317));
			dbs_322.addAll(Arrays.asList(H_322));
			dbs_405.addAll(Arrays.asList(H_405));
			dbs_417.addAll(Arrays.asList(H_417));
		}

		int totalA = 0;
		int totalB = 0;

		while (true) {

			if (sCal.compareTo(eCal) > 0) {
				break;
			}

			Calendar yCal = Calendar.getInstance();
			yCal.setTime(sCal.getTime());
			yCal.add(Calendar.DATE, ystrDay);

			String ystrDayStr = s_fmt.format(yCal.getTime()); // 어제
			String toDayStr = e_fmt.format(sCal.getTime()); // 오늘

			System.out.print(fmt2.format(yCal.getTime()) + " " + schulCode + " )");

			int resultA = 0;
			int resultB = 0;

			if (toDayStr.compareTo(m1_0317_2130) < 1) {

				resultA = query(mainDb.get(schulCode), egovQuery4, ystrDayStr, toDayStr, schulCode);
				resultB = query(mainDb.get(schulCode), egovQuery5, ystrDayStr, toDayStr, schulCode);

				// 서버분할 17일
			} else if (toDayStr.compareTo(m2_0322_2130) < 1) {

				if ("H".equals(schulCode)) {
					if ("202003181500".equals(toDayStr)) {
						resultA += query(mainDb.get(schulCode), egovQuery4, ystrDayStr, m1_0317_2130, schulCode);
						for (DBConnection db : dbs_317)
							resultA += query(db, egovQuery4, m1_0317_2130, toDayStr, schulCode);
						resultB += query(mainDb.get(schulCode), egovQuery5, ystrDayStr, m1_0317_2130, schulCode);
						for (DBConnection db : dbs_317)
							resultB += query(db, egovQuery5, m1_0317_2130, toDayStr, schulCode);
					} else {
						for (DBConnection db : dbs_317)
							resultA += query(db, egovQuery4, ystrDayStr, toDayStr, schulCode);
						for (DBConnection db : dbs_317)
							resultB += query(db, egovQuery5, ystrDayStr, toDayStr, schulCode);
					}
				} else {
					for (DBConnection db : dbs_317)
						resultA += query(db, egovQuery4, ystrDayStr, toDayStr, schulCode);
					for (DBConnection db : dbs_317)
						resultB += query(db, egovQuery5, ystrDayStr, toDayStr, schulCode);
				}

				// 서버 분할 22일
			} else if (toDayStr.compareTo(m0405_0100) < 1) {

				if ("202003231500".equals(toDayStr)) {
					for (DBConnection db : dbs_317)
						resultA += query(db, egovQuery4, ystrDayStr, m2_0322_2130, schulCode);
					for (DBConnection db : dbs_322)
						resultA += query(db, egovQuery4, m2_0322_2130, toDayStr, schulCode);
					for (DBConnection db : dbs_317)
						resultB += query(db, egovQuery5, ystrDayStr, m2_0322_2130, schulCode);
					for (DBConnection db : dbs_322)
						resultB += query(db, egovQuery5, m2_0322_2130, toDayStr, schulCode);
				} else {
					for (DBConnection db : dbs_322)
						resultA += query(db, egovQuery4, ystrDayStr, toDayStr, schulCode);
					for (DBConnection db : dbs_322)
						resultB += query(db, egovQuery5, ystrDayStr, toDayStr, schulCode);
				}

				// 서버분할 4-5일
			} else if (toDayStr.compareTo(m0417_0000) < 1) {

				if ("202004061500".equals(toDayStr)) {
					for (DBConnection db : dbs_322)
						resultA += query(db, egovQuery4, ystrDayStr, m0405_0100, schulCode);
					for (DBConnection db : dbs_405)
						resultA += query(db, egovQuery4, m0405_0100, toDayStr, schulCode);
					for (DBConnection db : dbs_322)
						resultB += query(db, egovQuery5, ystrDayStr, m0405_0100, schulCode);
					for (DBConnection db : dbs_405)
						resultB += query(db, egovQuery5, m0405_0100, toDayStr, schulCode);
				} else {
					for (DBConnection db : dbs_405)
						resultA += query(db, egovQuery4, ystrDayStr, toDayStr, schulCode);
					for (DBConnection db : dbs_405)
						resultB += query(db, egovQuery5, ystrDayStr, toDayStr, schulCode);
				}

			} else {
				for (DBConnection db : dbs_417)
					resultA += query(db, egovQuery4, ystrDayStr, toDayStr, schulCode);
				for (DBConnection db : dbs_417)
					resultB += query(db, egovQuery5, ystrDayStr, toDayStr, schulCode);
			}

//			System.out.println(getShculLevelNm(schulCode) + "자수 : " + resultA + "\t\t" + getShculLevelNm(schulCode)
//					+ "건수 : " + resultB);

			totalA = totalA + resultA;
			totalB = totalB + resultB;

			sCal.add(Calendar.DATE, 1);

		}

		System.out.println(getShculLevelNm(schulCode) + "이용자수 총합 : " + totalA + "\t\t" + "이용건수 총합 : " + totalB);

	}

	// 학급통계 : 학교별, 학급별 통계, 
	int realTimeThreadCnt = 0;
	public synchronized void  realTimeThreadCnt(){
		System.out.println(++realTimeThreadCnt);
	}
	@SuppressWarnings("unchecked")
	public void schul(Calendar trgetDate) {

		String dateString = s_fmt.format(trgetDate.getTime());

		trgetDate.add(Calendar.DATE, -1);

		String pickDate = fmt2.format(trgetDate.getTime());

		// 학교수 초중
		String schulQuery1_2 = "" + "select sub.CITY_NM As 시도" + "  , CASE WHEN sub.SCHUL_LEVEL_CODE = 'P' THEN '초등학교'"
				+ "    WHEN sub.SCHUL_LEVEL_CODE = 'M' THEN '중학교'" + "    WHEN sub.SCHUL_LEVEL_CODE = 'H' THEN '고등학교'"
				+ "    WHEN sub.SCHUL_LEVEL_CODE = 'A' THEN '대안학교'" + "    ELSE '기타학교'" + "  END AS 학제"
				+ "  , count(*) As 학교수" + " FROM (" + "  SELECT TSS.CITY_NM" + "    , TSS.SCHUL_LEVEL_CODE"
				+ "    , TSS.SCHUL_CODE" + "  FROM TB_LEM_HMPG_OPER TLHO"
				+ "    INNER JOIN TB_SUM_HMPG_REQST TSHR  ON TLHO.HMPG_REQST_SN = TSHR.HMPG_REQST_SN"
				+ "    INNER JOIN TB_SCM_SCHUL TSS ON TLHO.SCHUL_CODE = TSS.SCHUL_CODE"
				+ "  WHERE TLHO.HMPG_SE_CODE = '005'" + "  AND TLHO.ESTBL_STTUS_CODE = '005'"
				+ "  AND (TSHR.CLS_STTUS_CODE IS NULL OR TSHR.CLS_STTUS_CODE <> '005')"
				+ "  AND DATE_FORMAT(TLHO.FRST_REGIST_PNTTM ,'%Y%m%d%H%i') <= '" + dateString + "' "
				+ "  AND TSS.SCHUL_LEVEL_CODE = 'H'" + "  GROUP BY TSS.CITY_NM, TSS.SCHUL_LEVEL_CODE, TSS.SCHUL_CODE"
				+ " ) sub" + " GROUP BY sub.CITY_NM, sub.SCHUL_LEVEL_CODE";
		// 학교수 고등
		String schulQuery1_1 = "" + "select sub.CITY_NM As 시도" + "  , CASE WHEN sub.SCHUL_LEVEL_CODE = 'P' THEN '초등학교'"
				+ "    WHEN sub.SCHUL_LEVEL_CODE = 'M' THEN '중학교'" + "    WHEN sub.SCHUL_LEVEL_CODE = 'H' THEN '고등학교'"
				+ "    WHEN sub.SCHUL_LEVEL_CODE = 'A' THEN '대안학교'" + "    ELSE '기타학교'" + "  END AS 학제"
				+ "  , count(*) As 학교수" + " FROM (" + "  SELECT TSS.CITY_NM" + "    , TSS.SCHUL_LEVEL_CODE"
				+ "    , TSS.SCHUL_CODE" + "  FROM TB_LEM_HMPG_OPER TLHO"
				+ "    INNER JOIN TB_SUM_HMPG_REQST TSHR  ON TLHO.HMPG_REQST_SN = TSHR.HMPG_REQST_SN"
				+ "    INNER JOIN TB_SCM_SCHUL TSS ON TLHO.SCHUL_CODE = TSS.SCHUL_CODE"
				+ "  WHERE TLHO.HMPG_SE_CODE = '005'" + "  AND TLHO.ESTBL_STTUS_CODE = '005'"
				+ "  AND (TSHR.CLS_STTUS_CODE IS NULL OR TSHR.CLS_STTUS_CODE <> '005')"
				+ "  AND DATE_FORMAT(TLHO.FRST_REGIST_PNTTM ,'%Y%m%d%H%i') <= '" + dateString + "' "
				+ "  AND TSS.SCHUL_LEVEL_CODE <> 'H'" + "  GROUP BY TSS.CITY_NM, TSS.SCHUL_LEVEL_CODE, TSS.SCHUL_CODE"
				+ " ) sub" + " GROUP BY sub.CITY_NM, sub.SCHUL_LEVEL_CODE";
		// 학급수 초중
		String schulQuery2_2 = "" + " SELECT TSS.CITY_NM As 시도"
				+ "   , CASE WHEN TSS.SCHUL_LEVEL_CODE = 'P' THEN '초등학교'"
				+ "     WHEN TSS.SCHUL_LEVEL_CODE = 'M' THEN '중학교'" + "     WHEN TSS.SCHUL_LEVEL_CODE = 'H' THEN '고등학교'"
				+ "     WHEN TSS.SCHUL_LEVEL_CODE = 'A' THEN '대안학교'" + "     ELSE '기타학교'" + "   END AS 학제"
				+ "   , COUNT(*) as 학급수" + " FROM TB_LEM_HMPG_OPER TLHO"
				+ "   INNER JOIN TB_SUM_HMPG_REQST TSHR  ON TLHO.HMPG_REQST_SN = TSHR.HMPG_REQST_SN"
				+ "   INNER JOIN TB_SCM_SCHUL TSS ON TLHO.SCHUL_CODE = TSS.SCHUL_CODE"
				+ " WHERE TLHO.HMPG_SE_CODE = '005'" + " AND TLHO.ESTBL_STTUS_CODE = '005'"
				+ " AND (TSHR.CLS_STTUS_CODE IS NULL OR TSHR.CLS_STTUS_CODE <> '005')"
				+ " AND DATE_FORMAT(TLHO.FRST_REGIST_PNTTM ,'%Y%m%d%H%i') <= '" + dateString + "' "
				+ " AND TSS.SCHUL_LEVEL_CODE = 'H'" + " GROUP BY TSS.CITY_NM, TSS.SCHUL_LEVEL_CODE";
		// 학급수 고등
		String schulQuery2_1 = "" + " SELECT TSS.CITY_NM As 시도"
				+ "   , CASE WHEN TSS.SCHUL_LEVEL_CODE = 'P' THEN '초등학교'"
				+ "     WHEN TSS.SCHUL_LEVEL_CODE = 'M' THEN '중학교'" + "     WHEN TSS.SCHUL_LEVEL_CODE = 'H' THEN '고등학교'"
				+ "     WHEN TSS.SCHUL_LEVEL_CODE = 'A' THEN '대안학교'" + "     ELSE '기타학교'" + "   END AS 학제"
				+ "   , COUNT(*) as 학급수" + " FROM TB_LEM_HMPG_OPER TLHO"
				+ "   INNER JOIN TB_SUM_HMPG_REQST TSHR  ON TLHO.HMPG_REQST_SN = TSHR.HMPG_REQST_SN"
				+ "   INNER JOIN TB_SCM_SCHUL TSS ON TLHO.SCHUL_CODE = TSS.SCHUL_CODE"
				+ " WHERE TLHO.HMPG_SE_CODE = '005'" + " AND TLHO.ESTBL_STTUS_CODE = '005'"
				+ " AND (TSHR.CLS_STTUS_CODE IS NULL OR TSHR.CLS_STTUS_CODE <> '005')"
				+ " AND DATE_FORMAT(TLHO.FRST_REGIST_PNTTM ,'%Y%m%d%H%i') <= '" + dateString + "' "
				+ " AND TSS.SCHUL_LEVEL_CODE <> 'H'" + " GROUP BY TSS.CITY_NM, TSS.SCHUL_LEVEL_CODE";

		String[] cityNms = { "강원", "경기", "경남", "경북", "광주", "대구", "대전", "부산", "서울", "세종", "울산", "인천", "전남", "전북", "제주",
				"충남", "충북", "해외" };

		System.out.println("( " + pickDate + " 기준 )");

		System.out.println("\n #### 학교수 #### ");

		List<Map<String, Object>> data1_1 = (List<Map<String, Object>>) queryM(POC, schulQuery1_1).get("data");
		List<Map<String, Object>> data1_2 = (List<Map<String, Object>>) queryM(HOC, schulQuery1_2).get("data");

		Map<String, List<Map<String, Object>>> convt1_1 = new HashMap<>();
		Map<String, List<Map<String, Object>>> convt1_2 = new HashMap<>();

		for (Map<String, Object> d : data1_1) {
			if (convt1_1.get(d.get("CITY_NM")) == null)
				convt1_1.put((String) d.get("CITY_NM"), new ArrayList<>());
			convt1_1.get(d.get("CITY_NM")).add(d);
		}
		for (Map<String, Object> d : data1_2) {
			if (convt1_2.get(d.get("CITY_NM")) == null)
				convt1_2.put((String) d.get("CITY_NM"), new ArrayList<>());
			convt1_2.get(d.get("CITY_NM")).add(d);
		}

		for (String city : cityNms) {

			List<Map<String, Object>> cvts1 = convt1_1.get(city);
			List<Map<String, Object>> cvts2 = convt1_2.get(city);

			for (Map<String, Object> cvt : cvts1) {
				System.out.println("\n" + cvt.get("CITY_NM") + "\t" + cvt.get("학제") + "\t" + cvt.get("학교수"));
			}

			if (cvts2 == null)
				continue;

			for (Map<String, Object> cvt : cvts2) {
				System.out.println("\n" + cvt.get("CITY_NM") + "\t" + cvt.get("학제") + "\t" + cvt.get("학교수"));
			}
		}

		System.out.println("\n\n\n #### 학급수 #### ");
		List<Map<String, Object>> data2_1 = (List<Map<String, Object>>) queryM(POC, schulQuery2_1).get("data");
		List<Map<String, Object>> data2_2 = (List<Map<String, Object>>) queryM(HOC, schulQuery2_2).get("data");

		Map<String, List<Map<String, Object>>> convt2_1 = new HashMap<>();
		Map<String, List<Map<String, Object>>> convt2_2 = new HashMap<>();

		for (Map<String, Object> d : data2_1) {
			if (convt2_1.get(d.get("CITY_NM")) == null)
				convt2_1.put((String) d.get("CITY_NM"), new ArrayList<>());
			convt2_1.get(d.get("CITY_NM")).add(d);
		}
		for (Map<String, Object> d : data2_2) {
			if (convt2_2.get(d.get("CITY_NM")) == null)
				convt2_2.put((String) d.get("CITY_NM"), new ArrayList<>());
			convt2_2.get(d.get("CITY_NM")).add(d);
		}

		for (String city : cityNms) {

			List<Map<String, Object>> cvts1 = convt2_1.get(city);
			List<Map<String, Object>> cvts2 = convt2_2.get(city);

			for (Map<String, Object> cvt : cvts1) {
				System.out.println("\n" + cvt.get("CITY_NM") + "\t" + cvt.get("학제") + "\t" + cvt.get("학급수"));
			}

			if (cvts2 == null)
				continue;

			for (Map<String, Object> cvt : cvts2) {
				System.out.println("\n" + cvt.get("CITY_NM") + "\t" + cvt.get("학제") + "\t" + cvt.get("학급수"));
			}
		}
		
		
		// 화상강의
		System.out.println("\n\n\n #### 화상강의 #### ");
		Map<String, Map<String, Long>> alctcrCnt = new HashMap<>();
		Map<String, Map<String, Long>> lctreCnt = new HashMap<>();
		Map<String, Map<String, Long>> schulCnt = new HashMap<>();
		Map<String, Map<String, Long>> classCnt = new HashMap<>();
		
		realTimeThreadCnt = 0;
		
		for(DBConnection db : allDbs){
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					
					SqlSession sql = db.getSqlSession(true);
					
					// 화상강의 학교 수
					List<Map<String, Object>> schulResult = sql.selectList("avgservice.selectRealTimeSchoolCnt", new HashMap<>());
					
					for(int i=0;i<schulResult.size();i++){
						
						Map<String, Object> data = schulResult.get(i);
						
						String cityNm = (String) data.get("cityNm");
						String level = (String) data.get("schulLevelCode");
						Long cnt = (Long) data.get("cnt");
						
						if(!schulCnt.containsKey(cityNm)){
							schulCnt.put(cityNm, new HashMap<>());
						}
						
						if(!schulCnt.get(cityNm).containsKey(level)){
							schulCnt.get(cityNm).put(level, 0L);
						}
						
						schulCnt.get(cityNm).put(level, schulCnt.get(cityNm).get(level) + cnt);
						
					}
	
					// 화상강의 학급 수
					List<Map<String, Object>> classResult = sql.selectList("avgservice.selectRealTimeClassCnt", new HashMap<>());
					
					for(int i=0;i<classResult.size();i++){
						
						Map<String, Object> data = classResult.get(i);
						
						String cityNm = (String) data.get("cityNm");
						String level = (String) data.get("schulLevelCode");
						Long cnt = (Long) data.get("cnt");
						
						if(!classCnt.containsKey(cityNm)){
							classCnt.put(cityNm, new HashMap<>());
						}
						
						if(!classCnt.get(cityNm).containsKey(level)){
							classCnt.get(cityNm).put(level, 0L);
						}
						
						classCnt.get(cityNm).put(level, classCnt.get(cityNm).get(level) + cnt);
						
					}
					
					// 화상강의 강좌 수
					List<Map<String, Object>> alctcrResult = sql.selectList("avgservice.selectRealTimeGenAlctcrCnt", new HashMap<>());
					
					for(int i=0;i<alctcrResult.size();i++){
						
						Map<String, Object> data = alctcrResult.get(i);
						
						String cityNm = (String) data.get("cityNm");
						String level = (String) data.get("schulLevelCode");
						Long cnt = (Long) data.get("cnt");
						
						if(!alctcrCnt.containsKey(cityNm)){
							alctcrCnt.put(cityNm, new HashMap<>());
						}
						
						if(!alctcrCnt.get(cityNm).containsKey(level)){
							alctcrCnt.get(cityNm).put(level, 0L);
						}
						
						alctcrCnt.get(cityNm).put(level, alctcrCnt.get(cityNm).get(level) + cnt);
						
					}
					
					// 화상강의 강의 수
					List<Map<String, Object>> lctreResult = sql.selectList("avgservice.selectRealTimeGenLctreCnt", new HashMap<>());
					
					for(int i=0;i<lctreResult.size();i++){
						
						Map<String, Object> data = lctreResult.get(i);
						
						String cityNm = (String) data.get("cityNm");
						String level = (String) data.get("schulLevelCode");
						Long cnt = (Long) data.get("cnt");
						
						if(!lctreCnt.containsKey(cityNm)){
							lctreCnt.put(cityNm, new HashMap<>());
						}
						
						if(!lctreCnt.get(cityNm).containsKey(level)){
							lctreCnt.get(cityNm).put(level, 0L);
						}
						
						lctreCnt.get(cityNm).put(level, lctreCnt.get(cityNm).get(level) + cnt);
						
					}
					
					realTimeThreadCnt();
					
					if(realTimeThreadCnt >= allDbs.size()){
						
						// 화상강의 학교 수
						System.out.println("\n\n\n 화상강의 학교 수 ");
						for(String cityNm : cityNms){
							if(schulCnt.containsKey(cityNm)){
								if(schulCnt.get(cityNm).containsKey("A")){
									System.out.println("\n" + cityNm + "\t" + "대안학교" + "\t" + schulCnt.get(cityNm).get("A"));
								}
								if(schulCnt.get(cityNm).containsKey("E")){
									System.out.println("\n" + cityNm + "\t" + "기타학교" + "\t" + schulCnt.get(cityNm).get("E"));
								}
								if(schulCnt.get(cityNm).containsKey("M")){
									System.out.println("\n" + cityNm + "\t" + "중학교" + "\t" + schulCnt.get(cityNm).get("M"));
								}
								if(schulCnt.get(cityNm).containsKey("P")){
									System.out.println("\n" + cityNm + "\t" + "초등학교" + "\t" + schulCnt.get(cityNm).get("P"));
								}
								if(schulCnt.get(cityNm).containsKey("H")){
									System.out.println("\n" + cityNm + "\t" + "고등학교" + "\t" + schulCnt.get(cityNm).get("H"));
								}
							}
						}
						
						// 화상강의 학급 수
						System.out.println("\n\n\n 화상강의 학급 수 ");
						for(String cityNm : cityNms){
							if(classCnt.containsKey(cityNm)){
								if(classCnt.get(cityNm).containsKey("A")){
									System.out.println("\n" + cityNm + "\t" + "대안학교" + "\t" + classCnt.get(cityNm).get("A"));
								}
								if(classCnt.get(cityNm).containsKey("E")){
									System.out.println("\n" + cityNm + "\t" + "기타학교" + "\t" + classCnt.get(cityNm).get("E"));
								}
								if(classCnt.get(cityNm).containsKey("M")){
									System.out.println("\n" + cityNm + "\t" + "중학교" + "\t" + classCnt.get(cityNm).get("M"));
								}
								if(classCnt.get(cityNm).containsKey("P")){
									System.out.println("\n" + cityNm + "\t" + "초등학교" + "\t" + classCnt.get(cityNm).get("P"));
								}
								if(classCnt.get(cityNm).containsKey("H")){
									System.out.println("\n" + cityNm + "\t" + "고등학교" + "\t" + classCnt.get(cityNm).get("H"));
								}
							}
						}
						
						// 화상강의 조종례 수
						System.out.println("\n\n\n 화상 조종례 개설 수 (강의) ");
						for(String cityNm : cityNms){
							if(alctcrCnt.containsKey(cityNm)){
								if(alctcrCnt.get(cityNm).containsKey("A")){
									System.out.println("\n" + cityNm + "\t" + "대안학교" + "\t" + alctcrCnt.get(cityNm).get("A"));
								}
								if(alctcrCnt.get(cityNm).containsKey("E")){
									System.out.println("\n" + cityNm + "\t" + "기타학교" + "\t" + alctcrCnt.get(cityNm).get("E"));
								}
								if(alctcrCnt.get(cityNm).containsKey("M")){
									System.out.println("\n" + cityNm + "\t" + "중학교" + "\t" + alctcrCnt.get(cityNm).get("M"));
								}
								if(alctcrCnt.get(cityNm).containsKey("P")){
									System.out.println("\n" + cityNm + "\t" + "초등학교" + "\t" + alctcrCnt.get(cityNm).get("P"));
								}
								if(alctcrCnt.get(cityNm).containsKey("H")){
									System.out.println("\n" + cityNm + "\t" + "고등학교" + "\t" + alctcrCnt.get(cityNm).get("H"));
								}
							}
						}
						
						// 화상강의 강의 수 
						System.out.println("\n\n\n 화상 개설 수 (강의) ");
						for(String cityNm : cityNms){
							if(lctreCnt.containsKey(cityNm)){
								if(lctreCnt.get(cityNm).containsKey("A")){
									System.out.println("\n" + cityNm + "\t" + "대안학교" + "\t" + lctreCnt.get(cityNm).get("A"));
								}
								if(lctreCnt.get(cityNm).containsKey("E")){
									System.out.println("\n" + cityNm + "\t" + "기타학교" + "\t" + lctreCnt.get(cityNm).get("E"));
								}
								if(lctreCnt.get(cityNm).containsKey("M")){
									System.out.println("\n" + cityNm + "\t" + "중학교" + "\t" + lctreCnt.get(cityNm).get("M"));
								}
								if(lctreCnt.get(cityNm).containsKey("P")){
									System.out.println("\n" + cityNm + "\t" + "초등학교" + "\t" + lctreCnt.get(cityNm).get("P"));
								}
								if(lctreCnt.get(cityNm).containsKey("H")){
									System.out.println("\n" + cityNm + "\t" + "고등학교" + "\t" + lctreCnt.get(cityNm).get("H"));
								}
							}
						}
					}
					
				}
			});
			t.start();
		}

	}
		
		



	// 학년별 접속자 수 ( 중복 제거 )
	long gradeP1 = 0;
	long gradeP2 = 0;
	long gradeP3 = 0;
	long gradeP4 = 0;
	long gradeP5 = 0;
	long gradeP6 = 0;
	long gradeP9 = 0;
	long gradeM1 = 0;
	long gradeM2 = 0;
	long gradeM3 = 0;
	long gradeH1 = 0;
	long gradeH2 = 0;
	long gradeH3 = 0;
	long gradeM9 = 0;
	long gradeH9 = 0;
	long etc1 = 0;
	int gradeJoinThreadCnt = 0;

	public void gradeJoinCnt(Calendar trgetDate) {

		gradeP1 = 0;
		gradeP2 = 0;
		gradeP3 = 0;
		gradeP4 = 0;
		gradeP5 = 0;
		gradeP6 = 0;
		gradeP9 = 0;
		gradeM1 = 0;
		gradeM2 = 0;
		gradeM3 = 0;
		gradeH1 = 0;
		gradeH2 = 0;
		gradeH3 = 0;
		gradeM9 = 0;
		gradeH9 = 0;
		etc1 = 0;
		gradeJoinThreadCnt = 0;

		SimpleDateFormat fmt1 = new SimpleDateFormat("yyyyMMdd0000");
		SimpleDateFormat fmt2 = new SimpleDateFormat("yyyyMMdd0000");

		Calendar cal = Calendar.getInstance();
		cal.setTime(trgetDate.getTime());
		String toDayStr = fmt1.format(cal.getTime());

		cal.add(Calendar.DATE, -1);
		String ystDayStr = fmt2.format(cal.getTime());

		String currentDay = this.fmt2.format(cal.getTime());

		System.out.println("( " + currentDay + " 기준 )");

		System.out.println(ystDayStr);
		System.out.println(toDayStr);

		String q = "" + "	SELECT SCHUL_LEVEL_CODE AS code, GRADE AS grade, COUNT(*) AS cnt FROM ("
				+ "	  SELECT d.SCHUL_LEVEL_CODE, a.GRADE, COUNT(*) AS cnt, GROUP_CONCAT(a.HMPG_OPER_SN)"
				+ "	  FROM TB_LEM_HMPG_OPER a "
				+ "	  INNER JOIN TB_LCM_ALCTCR_MANAGE b ON a.HMPG_OPER_SN = b.HMPG_OPER_SN"
				+ "	  INNER JOIN TB_LEM_CNTNTS_USE c ON b.ALCTCR_SN = c.ALCTCR_SN"
				+ "	  INNER JOIN TB_SCM_SCHUL d ON a.SCHUL_CODE = d.SCHUL_CODE"
				// + " INNER JOIN TB_SUM_USER_INFO e ON c.REGIST_SN = e.USER_SN
				// AND e.TCHER_CRTFC_AT = 1" // 선생님 통계
				// + " INNER JOIN TB_SUM_USER_INFO e ON c.REGIST_SN = e.USER_SN
				// AND (e.TCHER_CRTFC_AT = 0 OR e.TCHER_CRTFC_AT IS NULL)" // 학생
				// 통계
				+ "	  WHERE DATE_FORMAT(c.REGIST_PNTTM, '%Y%m%d%H%i') > '" + ystDayStr + "'"
				+ "	  AND DATE_FORMAT(c.REGIST_PNTTM, '%Y%m%d%H%i') < '" + toDayStr + "'"
				+ "	  GROUP BY d.SCHUL_LEVEL_CODE, a.GRADE, c.REGIST_SN" + "	) a"
				+ "	GROUP BY a.SCHUL_LEVEL_CODE, a.GRADE";

		for (DBConnection db : allDbs) {
			Thread t = new Thread() {
				@SuppressWarnings("unchecked")
				@Override
				public void run() {

					Map<String, Object> result = queryM(db, q);
					List<Map<String, Object>> datas = (List<Map<String, Object>>) result.get("data");

					System.out.println(db.getName());

					for (Map<String, Object> d : datas) {
						if (d.get("SCHUL_LEVEL_CODE").equals("H")) {
							switch ((Integer) d.get("GRADE")) {
							case 1:
								System.out.println("고 3 : " + d.get("cnt"));
								gradeH1 += (Long) d.get("cnt");
								break;
							case 2:
								System.out.println("고 3 : " + d.get("cnt"));
								gradeH2 += (Long) d.get("cnt");
								break;
							case 3:
								System.out.println("고 3 : " + d.get("cnt"));
								gradeH3 += (Long) d.get("cnt");
								break;
							case 9:
								System.out.println("고 공통 : " + d.get("cnt"));
								gradeH9 += (Long) d.get("cnt");
								break;
							}
						} else if (d.get("SCHUL_LEVEL_CODE").equals("M")) {
							switch ((Integer) d.get("GRADE")) {
							case 1:
								System.out.println("중 1 : " + d.get("cnt"));
								gradeM1 += (Long) d.get("cnt");
								break;
							case 2:
								System.out.println("중 2 : " + d.get("cnt"));
								gradeM2 += (Long) d.get("cnt");
								break;
							case 3:
								System.out.println("중 3 : " + d.get("cnt"));
								gradeM3 += (Long) d.get("cnt");
								break;
							case 9:
								System.out.println("중 공통 : " + d.get("cnt"));
								gradeM9 += (Long) d.get("cnt");
								break;
							}
						} else if (d.get("SCHUL_LEVEL_CODE").equals("P")) {
							switch ((Integer) d.get("GRADE")) {
							case 1:
								System.out.println("초 1 : " + d.get("cnt"));
								gradeP1 += (Long) d.get("cnt");
								break;
							case 2:
								System.out.println("초 2 : " + d.get("cnt"));
								gradeP2 += (Long) d.get("cnt");
								break;
							case 3:
								System.out.println("초 3 : " + d.get("cnt"));
								gradeP3 += (Long) d.get("cnt");
								break;
							case 4:
								System.out.println("초 4 : " + d.get("cnt"));
								gradeP4 += (Long) d.get("cnt");
								break;
							case 5:
								System.out.println("초 5 : " + d.get("cnt"));
								gradeP5 += (Long) d.get("cnt");
								break;
							case 6:
								System.out.println("초 6 : " + d.get("cnt"));
								gradeP6 += (Long) d.get("cnt");
								break;
							case 9:
								System.out.println("초 공통 : " + d.get("cnt"));
								gradeP9 += (Long) d.get("cnt");
								break;
							}
						} else if (d.get("SCHUL_LEVEL_CODE").equals("E") || d.get("SCHUL_LEVEL_CODE").equals("A")) {
							etc1 += (Long) d.get("cnt");
						}
					}

					gradeJoinThreadCnt++;
					System.out.println("::: 카운트 : " + gradeJoinThreadCnt);

					if (gradeJoinThreadCnt >= allDbs.size()) {

						System.out.println("###########종료###########");
						System.out.println("초등학교 1학년 : " + gradeP1);
						System.out.println("초등학교 2학년 : " + gradeP2);
						System.out.println("초등학교 3학년 : " + gradeP3);
						System.out.println("초등학교 4학년 : " + gradeP4);
						System.out.println("초등학교 5학년 : " + gradeP5);
						System.out.println("초등학교 6학년 : " + gradeP6);
						System.out.println("초등학교 공통 : " + gradeP9);
						System.out.println("중학교 1학년 : " + gradeM1);
						System.out.println("중학교 2학년 : " + gradeM2);
						System.out.println("중학교 3학년 : " + gradeM3);
						System.out.println("중학교 공통 : " + gradeM9);
						System.out.println("고등학교 1학년 : " + gradeH1);
						System.out.println("고등학교 2학년 : " + gradeH2);
						System.out.println("고등학교 3학년 : " + gradeH3);
						System.out.println("고등학교 공통 : " + gradeH9);
						System.out.println("그 외 : " + etc1);
						System.out.println("###########종료###########");
					} else {
						
					}
				}
			};
			t.start();
		}
	}

	// 대구지역 통계
	@SuppressWarnings("unchecked")
	public void daeguCreateJoin(Calendar trgetDate) {

		String dateString = s_fmt.format(trgetDate.getTime());

		String q1 = "" + " SELECT c.SCHUL_NM, COUNT(*) AS cnt" + " FROM TB_LEM_HMPG_OPER a"
				+ " INNER JOIN TB_SUM_HMPG_REQST b ON a.HMPG_REQST_SN = b.HMPG_REQST_SN"
				+ " INNER JOIN TB_SCM_SCHUL c ON a.SCHUL_CODE = c.SCHUL_CODE"
				+ " WHERE (b.CLS_STTUS_CODE IS NULL OR b.CLS_STTUS_CODE <> '005')"
				+ " AND DATE_FORMAT(a.FRST_REGIST_PNTTM ,'%Y%m%d%H%i') <= " + dateString + " AND c.CITY_NM = '대구'"
				+ " AND c.SCHUL_LEVEL_CODE = 'H'" + " GROUP BY c.SCHUL_CODE";

		String q2 = "" + " SELECT c.SCHUL_NM, COUNT(*) AS cnt" + " FROM TB_LEM_HMPG_OPER a"
				+ " INNER JOIN TB_SUM_HMPG_REQST b ON a.HMPG_REQST_SN = b.HMPG_REQST_SN"
				+ " INNER JOIN TB_SCM_SCHUL c ON a.SCHUL_CODE = c.SCHUL_CODE"
				+ " INNER JOIN TB_LEM_HMPG_OPER_MBER d ON a.HMPG_OPER_SN = d.HMPG_OPER_SN"
				+ " WHERE (b.CLS_STTUS_CODE IS NULL OR b.CLS_STTUS_CODE <> '005')"
				+ " AND DATE_FORMAT(a.FRST_REGIST_PNTTM ,'%Y%m%d%H%i') <= " + dateString + " AND c.CITY_NM = '대구'"
				+ " AND c.SCHUL_LEVEL_CODE = 'H'" + " GROUP BY c.SCHUL_CODE;";

		String q3 = "" + " SELECT SCHUL_NM, COUNT(*) AS cnt FROM (" + " SELECT c.SCHUL_NM, COUNT(*) AS cnt"
				+ " FROM TB_LEM_HMPG_OPER a" + " INNER JOIN TB_SUM_HMPG_REQST b ON a.HMPG_REQST_SN = b.HMPG_REQST_SN"
				+ " INNER JOIN TB_SCM_SCHUL c ON a.SCHUL_CODE = c.SCHUL_CODE"
				+ " INNER JOIN TB_LEM_HMPG_OPER_MBER d ON a.HMPG_OPER_SN = d.HMPG_OPER_SN"
				+ " WHERE (b.CLS_STTUS_CODE IS NULL OR b.CLS_STTUS_CODE <> '005')"
				+ " AND DATE_FORMAT(a.FRST_REGIST_PNTTM ,'%Y%m%d%H%i') <= " + dateString + " AND c.CITY_NM = '대구'"
				+ " AND c.SCHUL_LEVEL_CODE = 'H'" + " GROUP BY c.SCHUL_CODE, d.USER_SN" + " ) a"
				+ " GROUP BY a.SCHUL_NM";

		List<Map<String, Object>> d1 = (List<Map<String, Object>>) queryM(HOC, q1).get("data");
		List<Map<String, Object>> d2 = (List<Map<String, Object>>) queryM(HOC, q2).get("data");
		List<Map<String, Object>> d3 = (List<Map<String, Object>>) queryM(HOC, q3).get("data");

		Map<String, Map<String, Long>> result = new HashMap<>();

		String key1 = "클래스 수";
		String key2 = "회원가입 수";
		String key3 = "회원가입 수 (중복제거)";

		for (Map<String, Object> data : d1) {
			String key = (String) data.get("SCHUL_NM");
			result.put(key, new HashMap<>());
			result.get(key).put(key1, (Long) data.get("cnt"));
		}

		for (Map<String, Object> data : d2) {
			String key = (String) data.get("SCHUL_NM");
			result.get(key).put(key2, (Long) data.get("cnt"));
		}

		for (Map<String, Object> data : d3) {
			String key = (String) data.get("SCHUL_NM");
			result.get(key).put(key3, (Long) data.get("cnt"));
		}

		ExcelFileWriter w = new ExcelFileWriter(deskTopPath, "대구지역 클래스 개설, 가입 수 " + fmt2.format(trgetDate.getTime()),
				"xlsx");

		w.addData("sheet", 0, 0, "학교 이름");
		w.addData("sheet", 0, 1, key1);
		w.addData("sheet", 0, 2, key2);
		w.addData("sheet", 0, 3, key3);

		int rowIndex = 1;

		for (Map.Entry<String, Map<String, Long>> r : result.entrySet()) {

			w.addData("sheet", rowIndex, 0, r.getKey());
			w.addData("sheet", rowIndex, 1,
					r.getValue().get(key1) != null && r.getValue().get(key1) > 0 ? r.getValue().get(key1) : 0);
			w.addData("sheet", rowIndex, 2,
					r.getValue().get(key2) != null && r.getValue().get(key2) > 0 ? r.getValue().get(key2) : 0);
			w.addData("sheet", rowIndex, 3,
					r.getValue().get(key3) != null && r.getValue().get(key3) > 0 ? r.getValue().get(key3) : 0);

			rowIndex++;
		}

		w.write();

	}

	// _DAY_teachJoin > _DAY_studentJoin > _DAY_lctreGetAndUp
	public void _DAY_AVG() throws InterruptedException {
		_DAY_studentJoin();
		_DAY_teachJoin();
		_DAY_lctreGetAndUp();
	}

	// 강의 업로드 수 ( 직접, 가져오기 구분 :: 강의 오픈에 따라 통계 불일치 )
	Map<String, Map<String, Long>> lctreGetAndUpMap;
	Integer lctreGetAndUpCnt;
	
	public synchronized void dyalctreGetAndUp(){
		lctreGetAndUpCnt++;
	}

	public void _DAY_lctreGetAndUp() {

		lctreGetAndUpCnt = 0;

		lctreGetAndUpMap = new HashMap<>();

		String q = "" + "    SELECT DATE_FORMAT(LM.FRST_REGIST_PNTTM , '%Y-%m-%d') As '날짜'"
				+ " , count(if(CNTNTS_TY_CODE = '015', LM.LCTRE_SN, null ) ) As '가져오기'"
				+ " , count(if(CNTNTS_TY_CODE <> '015', LCTRE_SN, null) ) As '만들기'" + " FROM TB_LCM_LCTRE_MANAGE LM"
				+ "   INNER JOIN TB_LCM_STEP_MANAGE SM ON LM.STEP_SN = SM.STEP_SN"
				+ "   INNER JOIN TB_LCM_ALCTCR_MANAGE AM ON SM.ALCTCR_SN = AM.ALCTCR_SN"
				+ "   INNER JOIN TB_LEM_HMPG_OPER HO ON AM.HMPG_OPER_SN = HO.HMPG_OPER_SN"
				+ "   INNER JOIN TB_SCM_SCHUL SC ON HO.SCHUL_CODE = SC.SCHUL_CODE" + " WHERE HO.HMPG_SE_CODE = '005'"
				+ " AND HO.OPER_AT = 1" + " AND (AM.CLS_AT <> 1 OR AM.CLS_AT IS NULL)"
				+ " AND LM.FRST_REGIST_PNTTM > '2020-03-01'" + " AND SC.HOST = ?"
				+ " GROUP BY DATE_FORMAT(LM.FRST_REGIST_PNTTM , '%Y-%m-%d')";

		/*
		 * allDbsToExcelQuery("선생님 강의 업로드 수 (직접, 가져오기)", q, 2, buttons.get(3));
		 */

		for (DBConnection db : allDbs) {
			Thread t = new Thread() {
				@SuppressWarnings({ "unchecked", "deprecation" })
				@Override
				public void run() {

					Thread tt = new Thread() {
						@Override
						public void run() {
							while(true){
								System.out.println(db.getName());
								try {
									sleep(1000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}
					};
					
					tt.start();
					
					List<Map<String, Object>> datas = (List<Map<String, Object>>) queryM(db, q, db.getName())
							.get("data");
					
					tt.stop();
					
					for (Map<String, Object> data : datas) {

						String day = (String) data.get("날짜");
						long get = (long) data.get("가져오기");
						long make = (long) data.get("만들기");

						if (lctreGetAndUpMap.containsKey(day)) {
							lctreGetAndUpMap.get(day).put("get", lctreGetAndUpMap.get(day).get("get") + get);
							try{
								lctreGetAndUpMap.get(day).put("make", lctreGetAndUpMap.get(day).get("make") + make);
							}catch(Exception err){
								err.printStackTrace();
							}
						} else {
							lctreGetAndUpMap.put(day, new HashMap<>());
							lctreGetAndUpMap.get(day).put("get", get);
							lctreGetAndUpMap.get(day).put("make", make);
						}

					}

					dyalctreGetAndUp();

					if (lctreGetAndUpCnt >= allDbs.size()) {

						Calendar eCal = Calendar.getInstance();
						Calendar sCal = Calendar.getInstance();
						sCal.set(Calendar.MONTH, 3);
						sCal.set(Calendar.DATE, 9);

						SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

						while (true) {

							if (sCal.compareTo(eCal) >= 0) {
								break;
							}

							String date = fmt.format(sCal.getTime());
							Map<String, Long> d = lctreGetAndUpMap.get(date);
							long getD = d.get("get");
							long makeD = d.get("make");

							System.out.println(date + " ::: 자체제작 " + makeD + " ::: 기본제공 :" + getD + "\n");

							sCal.add(Calendar.DATE, 1);
						}

						System.out.println("===========종료============" + "\n");

					} else {
						
					}

				}
			};
			t.start();
		}

	}

	// 학년별 선생님 접속수 ( 선생님 클래스 가입시 통계 불일치 )
	public void _DAY_teachJoin() {

		String q = "" + " SELECT  day" + "       ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 1, cnt, null)) As '초1' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 2, cnt, null)) As '초2' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 3, cnt, null)) As '초3' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 4, cnt, null)) As '초4' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 5, cnt, null)) As '초5' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 6, cnt, null)) As '초6' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 9, cnt, null)) As '초 공통' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'M' and a.GRADE = 1, cnt, null)) As '중1' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'M' and a.GRADE = 2, cnt, null)) As '중2' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'M' and a.GRADE = 3, cnt, null)) As '중3' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'M' and a.GRADE = 9, cnt, null)) As '중 공통' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'H' and a.GRADE = 1, cnt, null)) As '고1' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'H' and a.GRADE = 2, cnt, null)) As '고2' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'H' and a.GRADE = 3, cnt, null)) As '고3' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'H' and a.GRADE = 9, cnt, null)) As '고 공통' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'E' or SCHUL_LEVEL_CODE = 'A' , cnt, null)) As '기타' " + " FROM ("
				+ "   SELECT DATE_FORMAT(a.FRST_REGIST_PNTTM, '%Y-%m-%d') AS day, e.SCHUL_LEVEL_CODE, d.GRADE, COUNT(*) AS cnt"
				+ "   FROM  TB_STM_LOGIN_HIST a" + "   INNER JOIN TB_SUM_USER_INFO b ON a.FRST_REGISTER_ID = b.USER_SN"
				+ "   INNER JOIN TB_LEM_HMPG_OPER_MBER c ON c.USER_SN = b.USER_SN"
				+ "   INNER JOIN TB_LEM_HMPG_OPER d ON c.HMPG_OPER_SN = d.HMPG_OPER_SN"
				+ "   INNER JOIN TB_SCM_SCHUL e ON d.SCHUL_CODE = e.SCHUL_CODE" + "   WHERE "
				+ "	  b.TCHER_CRTFC_AT = 1" + "   AND HMPG_SE_CODE = '005'" + "   AND e.HOST = ?"
				+ "   AND a.FRST_REGIST_PNTTM >= '2020-10-01'"
				+ "   GROUP BY DATE_FORMAT(a.FRST_REGIST_PNTTM, '%Y%m%d'), e.SCHUL_LEVEL_CODE, d.GRADE, b.USER_SN"
				+ " ) a" + " GROUP BY day";

		allDbsToExcelQuery("선생님 접속수", q, 2);

	}

	// 학년별 학생 접속수 ( 학생 클래스 가입시 통계 불일치 )
	public void _DAY_studentJoin() {

		String q = "" + " SELECT  day" + "       ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 1, cnt, null)) As '초1' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 2, cnt, null)) As '초2' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 3, cnt, null)) As '초3' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 4, cnt, null)) As '초4' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 5, cnt, null)) As '초5' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 6, cnt, null)) As '초6' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 9, cnt, null)) As '초공통' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'M' and a.GRADE = 1, cnt, null)) As '중1' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'M' and a.GRADE = 2, cnt, null)) As '중2' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'M' and a.GRADE = 3, cnt, null)) As '중3' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'M' and a.GRADE = 9, cnt, null)) As '중공통' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'H' and a.GRADE = 1, cnt, null)) As '고1' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'H' and a.GRADE = 2, cnt, null)) As '고2' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'H' and a.GRADE = 3, cnt, null)) As '고3' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'H' and a.GRADE = 9, cnt, null)) As '고공통' "
				+ "       ,count(IF(SCHUL_LEVEL_CODE = 'E' or SCHUL_LEVEL_CODE = 'A' , cnt, null)) As '기타' " + " FROM ("
				+ "   SELECT DATE_FORMAT(a.FRST_REGIST_PNTTM, '%Y-%m-%d') AS day, e.SCHUL_LEVEL_CODE, d.GRADE, COUNT(*) AS cnt"
				+ "   FROM  TB_STM_LOGIN_HIST a" + "   INNER JOIN TB_SUM_USER_INFO b ON a.FRST_REGISTER_ID = b.USER_SN"
				+ "   INNER JOIN TB_LEM_HMPG_OPER_MBER c ON c.USER_SN = b.USER_SN"
				+ "   INNER JOIN TB_LEM_HMPG_OPER d ON c.HMPG_OPER_SN = d.HMPG_OPER_SN"
				+ "   INNER JOIN TB_SCM_SCHUL e ON d.SCHUL_CODE = e.SCHUL_CODE" + "   WHERE "
				+ "	  (b.TCHER_CRTFC_AT = 0 or b.TCHER_CRTFC_AT IS NULL)" + "   AND HMPG_SE_CODE = '005'"
				+ "   AND e.HOST = ?" + "   AND a.FRST_REGIST_PNTTM >= '2020-10-01'"
				+ "   GROUP BY DATE_FORMAT(a.FRST_REGIST_PNTTM, '%Y%m%d'), e.SCHUL_LEVEL_CODE, d.GRADE, b.USER_SN"
				+ " ) a" + " GROUP BY day";

		allDbsToExcelQuery("학생 접속수", q, 2);

	}

	// 시스템 현황
	int systmUsesStatusThreadCnt;
	Map<String, List<Map<String, Object>>> systmUsesStatusMap;
	Map<String, Map<String, Object>> systmUsesStatusAlctcrMap;

	@SuppressWarnings("unchecked")
	public void _systmUsesStatus() {

		systmUsesStatusThreadCnt = 0;
		systmUsesStatusMap = new HashMap<>();
		systmUsesStatusAlctcrMap = new HashMap<>();

		String cityKey = "CITY_NM";
		String[] grdKey = { "초1", "초2", "초3", "초4", "초5", "초6", "중1", "중2", "중3", "고1", "고2", "고3" };
		String[] cityKeys = { "서울", "부산", "대구", "인천", "광주", "대전", "울산", "세종", "경기", "강원", "충북", "충남", "전북", "전남", "경북",
				"경남", "제주", "해외" };

		for (String key : cityKeys) {
			systmUsesStatusAlctcrMap.put(key, new HashMap<>());
		}

		String schulCntQ = "" + "SELECT " + "	           CITY_NM As 지역"
				+ "	          ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 1, HMPG_OPER_SN, null)) As '" + grdKey[0]
				+ "'" + "	          ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 2, HMPG_OPER_SN, null)) As '"
				+ grdKey[1] + "'"
				+ "	          ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 3, HMPG_OPER_SN, null)) As '" + grdKey[2]
				+ "'" + "	          ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 4, HMPG_OPER_SN, null)) As '"
				+ grdKey[3] + "'"
				+ "	          ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 5, HMPG_OPER_SN, null)) As '" + grdKey[4]
				+ "'" + "	          ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 6, HMPG_OPER_SN, null)) As '"
				+ grdKey[5] + "'"
				+ "	          ,count(IF(SCHUL_LEVEL_CODE = 'M' and a.GRADE = 1, HMPG_OPER_SN, null)) As '" + grdKey[6]
				+ "'" + "	          ,count(IF(SCHUL_LEVEL_CODE = 'M' and a.GRADE = 2, HMPG_OPER_SN, null)) As '"
				+ grdKey[7] + "'"
				+ "	          ,count(IF(SCHUL_LEVEL_CODE = 'M' and a.GRADE = 3, HMPG_OPER_SN, null)) As '" + grdKey[8]
				+ "'" + "	          ,count(IF(SCHUL_LEVEL_CODE = 'H' and a.GRADE = 1, HMPG_OPER_SN, null)) As '"
				+ grdKey[9] + "'"
				+ "	          ,count(IF(SCHUL_LEVEL_CODE = 'H' and a.GRADE = 2, HMPG_OPER_SN, null)) As '" + grdKey[10]
				+ "'" + "	          ,count(IF(SCHUL_LEVEL_CODE = 'H' and a.GRADE = 3, HMPG_OPER_SN, null)) As '"
				+ grdKey[11] + "'" + "	FROM ("
				+ "	    SELECT b.SCHUL_NM, b.CITY_NM, b.SCHUL_LEVEL_CODE, a.GRADE, a.HMPG_OPER_SN, COUNT(*)"
				+ "	    FROM TB_LEM_HMPG_OPER a " + "	    INNER JOIN TB_SCM_SCHUL b ON a.SCHUL_CODE = b.SCHUL_CODE"
				+ "	    GROUP BY b.CITY_NM, b.SCHUL_LEVEL_CODE, b.SCHUL_CODE, a.GRADE" + "	) a"
				+ "	GROUP BY CITY_NM"
				+ "	order by FIELD(CITY_NM, '서울','부산','대구','인천','광주','대전','울산','세종','경기','강원','충북','충남','전북','전남','경북','경남','제주','해외')";
		String classCntQ = "" + "  SELECT" + "	           c.CITY_NM As 지역"
				+ "	          ,count(IF(c.SCHUL_LEVEL_CODE = 'P' and a.GRADE = 1, a.HMPG_OPER_SN, null)) As '"
				+ grdKey[0] + "'"
				+ "	          ,count(IF(c.SCHUL_LEVEL_CODE = 'P' and a.GRADE = 2, a.HMPG_OPER_SN, null)) As '"
				+ grdKey[1] + "'"
				+ "	          ,count(IF(c.SCHUL_LEVEL_CODE = 'P' and a.GRADE = 3, a.HMPG_OPER_SN, null)) As '"
				+ grdKey[2] + "'"
				+ "	          ,count(IF(c.SCHUL_LEVEL_CODE = 'P' and a.GRADE = 4, a.HMPG_OPER_SN, null)) As '"
				+ grdKey[3] + "'"
				+ "	          ,count(IF(c.SCHUL_LEVEL_CODE = 'P' and a.GRADE = 5, a.HMPG_OPER_SN, null)) As '"
				+ grdKey[4] + "'"
				+ "	          ,count(IF(c.SCHUL_LEVEL_CODE = 'P' and a.GRADE = 6, a.HMPG_OPER_SN, null)) As '"
				+ grdKey[5] + "'"
				+ "	          ,count(IF(c.SCHUL_LEVEL_CODE = 'M' and a.GRADE = 1, a.HMPG_OPER_SN, null)) As '"
				+ grdKey[6] + "'"
				+ "	          ,count(IF(c.SCHUL_LEVEL_CODE = 'M' and a.GRADE = 2, a.HMPG_OPER_SN, null)) As '"
				+ grdKey[7] + "'"
				+ "	          ,count(IF(c.SCHUL_LEVEL_CODE = 'M' and a.GRADE = 3, a.HMPG_OPER_SN, null)) As '"
				+ grdKey[8] + "'"
				+ "	          ,count(IF(c.SCHUL_LEVEL_CODE = 'H' and a.GRADE = 1, a.HMPG_OPER_SN, null)) As '"
				+ grdKey[9] + "'"
				+ "	          ,count(IF(c.SCHUL_LEVEL_CODE = 'H' and a.GRADE = 2, a.HMPG_OPER_SN, null)) As '"
				+ grdKey[10] + "'"
				+ "	          ,count(IF(c.SCHUL_LEVEL_CODE = 'H' and a.GRADE = 3, a.HMPG_OPER_SN, null)) As '"
				+ grdKey[11] + "'" + "	  FROM TB_LEM_HMPG_OPER a "
				+ "	  INNER JOIN TB_SUM_HMPG_REQST b ON a.HMPG_REQST_SN = b.HMPG_REQST_SN"
				+ "	  INNER JOIN TB_SCM_SCHUL c ON a.SCHUL_CODE = c.SCHUL_CODE"
				+ "	  WHERE ( b.CLS_STTUS_CODE IS NULL OR b.CLS_STTUS_CODE <> '005' )" + "	  GROUP BY c.CITY_NM"
				+ "	order by FIELD(CITY_NM, '서울','부산','대구','인천','광주','대전','울산','세종','경기','강원','충북','충남','전북','전남','경북','경남','제주','해외')";
		String teachCntQ = "" + "select  CITY_NM As 지역"
				+ "	      ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 1, a.HMPG_OPER_SN, null)) As '" + grdKey[0]
				+ "'" + "	      ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 2, a.HMPG_OPER_SN, null)) As '"
				+ grdKey[1] + "'"
				+ "	      ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 3, a.HMPG_OPER_SN, null)) As '" + grdKey[2]
				+ "'" + "	      ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 4, a.HMPG_OPER_SN, null)) As '"
				+ grdKey[3] + "'"
				+ "	      ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 5, a.HMPG_OPER_SN, null)) As '" + grdKey[4]
				+ "'" + "	      ,count(IF(SCHUL_LEVEL_CODE = 'P' and a.GRADE = 6, a.HMPG_OPER_SN, null)) As '"
				+ grdKey[5] + "'"
				+ "	      ,count(IF(SCHUL_LEVEL_CODE = 'M' and a.GRADE = 1, a.HMPG_OPER_SN, null)) As '" + grdKey[6]
				+ "'" + "	      ,count(IF(SCHUL_LEVEL_CODE = 'M' and a.GRADE = 2, a.HMPG_OPER_SN, null)) As '"
				+ grdKey[7] + "'"
				+ "	      ,count(IF(SCHUL_LEVEL_CODE = 'M' and a.GRADE = 3, a.HMPG_OPER_SN, null)) As '" + grdKey[8]
				+ "'" + "	      ,count(IF(SCHUL_LEVEL_CODE = 'H' and a.GRADE = 1, a.HMPG_OPER_SN, null)) As '"
				+ grdKey[9] + "'"
				+ "	      ,count(IF(SCHUL_LEVEL_CODE = 'H' and a.GRADE = 2, a.HMPG_OPER_SN, null)) As '" + grdKey[10]
				+ "'" + "	      ,count(IF(SCHUL_LEVEL_CODE = 'H' and a.GRADE = 3, a.HMPG_OPER_SN, null)) As '"
				+ grdKey[11] + "'" + "	from ("
				+ "	  SELECT USER_SN, CITY_NM, USER_ID, SCHUL_LEVEL_CODE, GRADE, HMPG_OPER_SN" + "	  FROM ("
				+ "	      SELECT  c.CITY_NM, a.HMPG_OPER_SN, b.USER_ID"
				+ "	            , c.SCHUL_LEVEL_CODE, a.GRADE, d.USER_SN" + "	      FROM TB_LEM_HMPG_OPER a"
				+ "	      INNER JOIN TB_LEM_HMPG_OPER_MBER b ON a.HMPG_OPER_SN = b.HMPG_OPER_SN"
				+ "	      INNER JOIN TB_SCM_SCHUL c ON a.SCHUL_CODE = c.SCHUL_CODE"
				+ "	      INNER JOIN TB_SUM_USER_INFO d ON b.USER_SN = d.USER_SN"
				+ "	      WHERE d.TCHER_CRTFC_AT = 1" + "	      AND d.USER_SE_CODE = 'A'"
				+ "	      GROUP BY b.USER_SN" + "	    UNION ALL"
				+ "	      SELECT c.CITY_NM , a.HMPG_OPER_SN, d.USER_ID"
				+ "	           , c.SCHUL_LEVEL_CODE, a.GRADE, d.USER_SN" + "	      FROM TB_LEM_HMPG_OPER a"
				+ "	      INNER JOIN TB_SCM_SCHUL c ON a.SCHUL_CODE = c.SCHUL_CODE"
				+ "	      INNER JOIN TB_SUM_USER_INFO d ON a.ESTER_SN = d.USER_SN"
				+ "	      WHERE d.TCHER_CRTFC_AT = 1" + "	      AND d.USER_SE_CODE = 'A'"
				+ "	      GROUP BY d.USER_SN" + "	  )aa" + "	  GROUP BY CITY_NM, USER_SN" + "	) a"
				+ "	GROUP BY CITY_NM"
				+ "	order by FIELD(CITY_NM, '서울','부산','대구','인천','광주','대전','울산','세종','경기','강원','충북','충남','전북','전남','경북','경남','제주','해외')";
		String userCntQ = "" + "SELECT   CITY_NM As 지역"
				+ "	      ,count(IF(SCHUL_LEVEL_CODE = 'P' and GRADE = 1, HMPG_OPER_SN, null)) As '" + grdKey[0] + "'"
				+ "	      ,count(IF(SCHUL_LEVEL_CODE = 'P' and GRADE = 2, HMPG_OPER_SN, null)) As '" + grdKey[1] + "'"
				+ "	      ,count(IF(SCHUL_LEVEL_CODE = 'P' and GRADE = 3, HMPG_OPER_SN, null)) As '" + grdKey[2] + "'"
				+ "	      ,count(IF(SCHUL_LEVEL_CODE = 'P' and GRADE = 4, HMPG_OPER_SN, null)) As '" + grdKey[3] + "'"
				+ "	      ,count(IF(SCHUL_LEVEL_CODE = 'P' and GRADE = 5, HMPG_OPER_SN, null)) As '" + grdKey[4] + "'"
				+ "	      ,count(IF(SCHUL_LEVEL_CODE = 'P' and GRADE = 6, HMPG_OPER_SN, null)) As '" + grdKey[5] + "'"
				+ "	      ,count(IF(SCHUL_LEVEL_CODE = 'M' and GRADE = 1, HMPG_OPER_SN, null)) As '" + grdKey[6] + "'"
				+ "	      ,count(IF(SCHUL_LEVEL_CODE = 'M' and GRADE = 2, HMPG_OPER_SN, null)) As '" + grdKey[7] + "'"
				+ "	      ,count(IF(SCHUL_LEVEL_CODE = 'M' and GRADE = 3, HMPG_OPER_SN, null)) As '" + grdKey[8] + "'"
				+ "	      ,count(IF(SCHUL_LEVEL_CODE = 'H' and GRADE = 1, HMPG_OPER_SN, null)) As '" + grdKey[9] + "'"
				+ "	      ,count(IF(SCHUL_LEVEL_CODE = 'H' and GRADE = 2, HMPG_OPER_SN, null)) As '" + grdKey[10] + "'"
				+ "	      ,count(IF(SCHUL_LEVEL_CODE = 'H' and GRADE = 3, HMPG_OPER_SN, null)) As '" + grdKey[11] + "'"
				+ "	      FROM" + "	("
				+ "	SELECT c.CITY_NM, c.SCHUL_LEVEL_CODE, a.GRADE, a.HMPG_OPER_SN, d.USER_SN, COUNT(*)"
				+ "	FROM TB_LEM_HMPG_OPER a"
				+ "	INNER JOIN TB_LEM_HMPG_OPER_MBER b ON a.HMPG_OPER_SN = b.HMPG_OPER_SN"
				+ "	INNER JOIN TB_SCM_SCHUL c ON a.SCHUL_CODE = c.SCHUL_CODE"
				+ "	INNER JOIN TB_SUM_USER_INFO d ON b.USER_SN = d.USER_SN" + "	WHERE d.TCHER_CRTFC_AT = 0"
				+ "	AND d.USER_SE_CODE = 'A'" + "	GROUP BY c.CITY_NM, c.SCHUL_LEVEL_CODE, a.GRADE, d.USER_SN" + "	) a"
				+ "	GROUP BY CITY_NM"
				+ "	order by FIELD(CITY_NM, '서울','부산','대구','인천','광주','대전','울산','세종','경기','강원','충북','충남','전북','전남','경북','경남','제주','해외')";
		String alctcrCntQ = "" + " SELECT" + "	  SC.CITY_NM As 지역"
				+ "	  ,count(IF(SC.SCHUL_LEVEL_CODE = 'P' and HO.GRADE = 1, AM.ALCTCR_SN, null)) As '" + grdKey[0] + "'"
				+ "	  ,count(IF(SC.SCHUL_LEVEL_CODE = 'P' and HO.GRADE = 2, AM.ALCTCR_SN, null)) As '" + grdKey[1] + "'"
				+ "	  ,count(IF(SC.SCHUL_LEVEL_CODE = 'P' and HO.GRADE = 3, AM.ALCTCR_SN, null)) As '" + grdKey[2] + "'"
				+ "	  ,count(IF(SC.SCHUL_LEVEL_CODE = 'P' and HO.GRADE = 4, AM.ALCTCR_SN, null)) As '" + grdKey[3] + "'"
				+ "	  ,count(IF(SC.SCHUL_LEVEL_CODE = 'P' and HO.GRADE = 5, AM.ALCTCR_SN, null)) As '" + grdKey[4] + "'"
				+ "	  ,count(IF(SC.SCHUL_LEVEL_CODE = 'P' and HO.GRADE = 6, AM.ALCTCR_SN, null)) As '" + grdKey[5] + "'"
				+ "	  ,count(IF(SC.SCHUL_LEVEL_CODE = 'M' and HO.GRADE = 1, AM.ALCTCR_SN, null)) As '" + grdKey[6] + "'"
				+ "	  ,count(IF(SC.SCHUL_LEVEL_CODE = 'M' and HO.GRADE = 2, AM.ALCTCR_SN, null)) As '" + grdKey[7] + "'"
				+ "	  ,count(IF(SC.SCHUL_LEVEL_CODE = 'M' and HO.GRADE = 3, AM.ALCTCR_SN, null)) As '" + grdKey[8] + "'"
				+ "	  ,count(IF(SC.SCHUL_LEVEL_CODE = 'H' and HO.GRADE = 1, AM.ALCTCR_SN, null)) As '" + grdKey[9] + "'"
				+ "	  ,count(IF(SC.SCHUL_LEVEL_CODE = 'H' and HO.GRADE = 2, AM.ALCTCR_SN, null)) As '" + grdKey[10]
				+ "'" + "	  ,count(IF(SC.SCHUL_LEVEL_CODE = 'H' and HO.GRADE = 3, AM.ALCTCR_SN, null)) As '"
				+ grdKey[11] + "'" + "	FROM TB_LCM_ALCTCR_MANAGE AM"
				+ "	  INNER JOIN TB_LEM_HMPG_OPER HO ON AM.HMPG_OPER_SN = HO.HMPG_OPER_SN"
				+ "	  INNER JOIN TB_SCM_SCHUL SC ON HO.SCHUL_CODE = SC.SCHUL_CODE" + "	WHERE AM.ALCTCR_TY = 1"
				+ "	AND AM.HMPG_SE_CODE = '005'" + "	AND AM.STTUS_CODE = '005'" + "	AND AM.CLS_AT <> 1"
				+ "	AND HO.OPER_AT = 1" + "	and SC.HOST = ?" + "	group by SC.CITY_NM"
				+ "	ORDER BY FIELD(SC.CITY_NM, '서울','부산','대구','인천','광주','대전','울산','세종','경기','강원','충북','충남','전북','전남','경북','경남','제주','해외')";

		Thread tt1 = new Thread() {
			@Override
			public void run() {
				systmUsesStatusMap.put("pSchulCntResult",
						(List<Map<String, Object>>) POC.execute(DBConnection.NONTIME_QUERY, schulCntQ).get("data"));
				System.out.println("학교수 POC");
				systmUsesStatusMap.put("pClassCntResult",
						(List<Map<String, Object>>) POC.execute(DBConnection.NONTIME_QUERY, classCntQ).get("data"));
				System.out.println("학급수 POC");
				systmUsesStatusMap.put("pTeachCntResult",
						(List<Map<String, Object>>) POC.execute(DBConnection.NONTIME_QUERY, teachCntQ).get("data"));
				System.out.println("교사수 POC");
				systmUsesStatusMap.put("pUserCntResult",
						(List<Map<String, Object>>) POC.execute(DBConnection.NONTIME_QUERY, userCntQ).get("data"));
				System.out.println("학생수 POC");
				systmUsesStatusThreadCnt++;
			}
		};
		tt1.start();

		Thread tt2 = new Thread() {
			@Override
			public void run() {
				systmUsesStatusMap.put("hSchulCntResult",
						(List<Map<String, Object>>) HOC.execute(DBConnection.NONTIME_QUERY, schulCntQ).get("data"));
				System.out.println("학교수 HOC");
				systmUsesStatusMap.put("hClassCntResult",
						(List<Map<String, Object>>) HOC.execute(DBConnection.NONTIME_QUERY, classCntQ).get("data"));
				System.out.println("학급수 HOC");
				systmUsesStatusMap.put("hTeachCntResult",
						(List<Map<String, Object>>) HOC.execute(DBConnection.NONTIME_QUERY, teachCntQ).get("data"));
				System.out.println("교사수 HOC");
				systmUsesStatusMap.put("hUserCntResult",
						(List<Map<String, Object>>) HOC.execute(DBConnection.NONTIME_QUERY, userCntQ).get("data"));
				System.out.println("학생수 HOC");
				systmUsesStatusThreadCnt++;
			}
		};
		tt2.start();

		for (DBConnection db : allDbs) {
			Thread t = new Thread() {
				@Override
				public void run() {

					List<Map<String, Object>> alctcrCntResult = (List<Map<String, Object>>) db
							.execute(DBConnection.NONTIME_QUERY, alctcrCntQ, db.getName()).get("data");

					for (Map<String, Object> data : alctcrCntResult) {
						String city = (String) data.get(cityKey);
						for (String key : grdKey) {

							long cnt = (long) data.get(key);

							if (systmUsesStatusAlctcrMap.get(city).get(key) != null) {
								long tot = cnt + (long) systmUsesStatusAlctcrMap.get(city).get(key);
								systmUsesStatusAlctcrMap.get(city).put(key, tot);
							} else {
								systmUsesStatusAlctcrMap.get(city).put(key, cnt);
							}
						}
					}

					systmUsesStatusThreadCnt++;
					if (systmUsesStatusThreadCnt >= allDbs.size()) {
						while (true) {
							Calendar c = Calendar.getInstance();
							String toDayStr = s_fmt.format(c.getTime());
							ExcelFileWriter w = new ExcelFileWriter(deskTopPath, "활용 현황_" + toDayStr, "xlsx");

							if (systmUsesStatusThreadCnt >= allDbs.size() + 2) {

								// 엑셀 만들기

								// ################ 강좌 개설 수 ###################
								int alctcrTitColCnt = 1;
								for (String key2 : grdKey) {
									w.addData("강좌개설수", 0, alctcrTitColCnt++, key2);
								}

								int row = 1;
								for (String key : cityKeys) {

									int col = 0;
									w.addData("강좌개설수", row, col++, key);

									for (String key2 : grdKey) {
										long value = (long) systmUsesStatusAlctcrMap.get(key).get(key2);
										w.addData("강좌개설수", row, col++, value);
									}

									row++;

								}
								w.write();
								break;
								// ###############################################

							} else {
								try {
									Thread.sleep(3000);
								} catch (InterruptedException e) {
									continue;
								}
								continue;
							}
						}
					}
				}
			};
			t.start();
		}

	}

	// 학년별 이용자 수 ( 중복 제거 X )
	long gradeUseP1 = 0;
	long gradeUseP2 = 0;
	long gradeUseP3 = 0;
	long gradeUseP4 = 0;
	long gradeUseP5 = 0;
	long gradeUseP6 = 0;
	long gradeUseM1 = 0;
	long gradeUseM2 = 0;
	long gradeUseM3 = 0;
	long gradeUseH1 = 0;
	long gradeUseH2 = 0;
	long gradeUseH3 = 0;
	int gradeUseThreadCnt = 0;

	public void _gradeUseCnt(Calendar trgetDate) {

		gradeUseP1 = 0;
		gradeUseP2 = 0;
		gradeUseP3 = 0;
		gradeUseP4 = 0;
		gradeUseP5 = 0;
		gradeUseP6 = 0;
		gradeUseM1 = 0;
		gradeUseM2 = 0;
		gradeUseM3 = 0;
		gradeUseH1 = 0;
		gradeUseH2 = 0;
		gradeUseH3 = 0;
		gradeUseThreadCnt = 0;

		SimpleDateFormat fmt1 = new SimpleDateFormat("yyyyMMdd0000");
		SimpleDateFormat fmt2 = new SimpleDateFormat("yyyyMMdd0000");

		Calendar cal = Calendar.getInstance();
		cal.setTime(trgetDate.getTime());
		String toDayStr = fmt1.format(cal.getTime());

		cal.add(Calendar.DATE, -1);
		String ystDayStr = fmt2.format(cal.getTime());

		System.out.println(ystDayStr);
		System.out.println(toDayStr);

		String q = "" + "	SELECT SCHUL_LEVEL_CODE AS code, GRADE AS grade, SUM(a.cnt) AS cnt FROM ("
				+ "	  SELECT d.SCHUL_LEVEL_CODE, a.GRADE, COUNT(*) AS cnt, GROUP_CONCAT(a.HMPG_OPER_SN)"
				+ "	  FROM TB_LEM_HMPG_OPER a "
				+ "	  INNER JOIN TB_LCM_ALCTCR_MANAGE b ON a.HMPG_OPER_SN = b.HMPG_OPER_SN"
				+ "	  INNER JOIN TB_LEM_CNTNTS_USE c ON b.ALCTCR_SN = c.ALCTCR_SN"
				+ "	  INNER JOIN TB_SCM_SCHUL d ON a.SCHUL_CODE = d.SCHUL_CODE"
				+ "	  WHERE DATE_FORMAT(c.REGIST_PNTTM, '%Y%m%d%H%i') > '" + ystDayStr + "'"
				+ "	  AND DATE_FORMAT(c.REGIST_PNTTM, '%Y%m%d%H%i') < '" + toDayStr + "'"
				+ "	  GROUP BY d.SCHUL_LEVEL_CODE, a.GRADE, c.REGIST_SN" + "	) a"
				+ "	GROUP BY a.SCHUL_LEVEL_CODE, a.GRADE";

		for (DBConnection db : allDbs) {
			Thread t = new Thread() {
				@SuppressWarnings("unchecked")
				@Override
				public void run() {

					Map<String, Object> result = queryM(db, q);
					List<Map<String, Object>> datas = (List<Map<String, Object>>) result.get("data");

					System.out.println(db.getName());

					for (Map<String, Object> d : datas) {
						if (d.get("SCHUL_LEVEL_CODE").equals("H")) {
							switch ((Integer) d.get("GRADE")) {
							case 1:
								System.out.println("고 3 : " + d.get("cnt"));
								BigDecimal tempValue1 = (BigDecimal) d.get("cnt");
								gradeUseH1 += Integer.valueOf(tempValue1.toString());
								break;
							case 2:
								System.out.println("고 3 : " + d.get("cnt"));
								BigDecimal tempValue2 = (BigDecimal) d.get("cnt");
								gradeUseH2 += Integer.valueOf(tempValue2.toString());
								break;
							case 3:
								System.out.println("고 3 : " + d.get("cnt"));
								BigDecimal tempValue3 = (BigDecimal) d.get("cnt");
								gradeUseH3 += Integer.valueOf(tempValue3.toString());
								break;
							}
						} else if (d.get("SCHUL_LEVEL_CODE").equals("M")) {
							switch ((Integer) d.get("GRADE")) {
							case 1:
								System.out.println("중 1 : " + d.get("cnt"));
								BigDecimal tempValue1 = (BigDecimal) d.get("cnt");
								gradeUseM1 += Integer.valueOf(tempValue1.toString());
								break;
							case 2:
								System.out.println("중 2 : " + d.get("cnt"));
								BigDecimal tempValue2 = (BigDecimal) d.get("cnt");
								gradeUseM2 += Integer.valueOf(tempValue2.toString());
								break;
							case 3:
								System.out.println("중 3 : " + d.get("cnt"));
								BigDecimal tempValue3 = (BigDecimal) d.get("cnt");
								gradeUseM3 += Integer.valueOf(tempValue3.toString());
								break;
							}
						} else if (d.get("SCHUL_LEVEL_CODE").equals("P")) {
							switch ((Integer) d.get("GRADE")) {
							case 1:
								System.out.println("초 1 : " + d.get("cnt"));
								BigDecimal tempValue1 = (BigDecimal) d.get("cnt");
								gradeUseP1 += Integer.valueOf(tempValue1.toString());
								break;
							case 2:
								System.out.println("초 2 : " + d.get("cnt"));
								BigDecimal tempValue2 = (BigDecimal) d.get("cnt");
								gradeUseP2 += Integer.valueOf(tempValue2.toString());
								break;
							case 3:
								System.out.println("초 3 : " + d.get("cnt"));
								BigDecimal tempValue3 = (BigDecimal) d.get("cnt");
								gradeUseP3 += Integer.valueOf(tempValue3.toString());
								break;
							case 4:
								System.out.println("초 4 : " + d.get("cnt"));
								BigDecimal tempValue4 = (BigDecimal) d.get("cnt");
								gradeUseP4 += Integer.valueOf(tempValue4.toString());
								break;
							case 5:
								System.out.println("초 5 : " + d.get("cnt"));
								BigDecimal tempValue5 = (BigDecimal) d.get("cnt");
								gradeUseP5 += Integer.valueOf(tempValue5.toString());
								break;
							case 6:
								System.out.println("초 6 : " + d.get("cnt"));
								BigDecimal tempValue6 = (BigDecimal) d.get("cnt");
								gradeUseP6 += Integer.valueOf(tempValue6.toString());
								break;
							}
						}
					}

					gradeUseThreadCnt++;
					System.out.println("::: 카운트 : " + gradeUseThreadCnt);

					if (gradeUseThreadCnt >= allDbs.size()) {

						System.out.println("###########종료###########");
						System.out.println("초등학교 1학년 : " + gradeUseP1);
						System.out.println("초등학교 2학년 : " + gradeUseP2);
						System.out.println("초등학교 3학년 : " + gradeUseP3);
						System.out.println("초등학교 4학년 : " + gradeUseP4);
						System.out.println("초등학교 5학년 : " + gradeUseP5);
						System.out.println("초등학교 6학년 : " + gradeUseP6);
						System.out.println("중학교 1학년 : " + gradeUseM1);
						System.out.println("중학교 2학년 : " + gradeUseM2);
						System.out.println("중학교 3학년 : " + gradeUseM3);
						System.out.println("고등학교 1학년 : " + gradeUseH1);
						System.out.println("고등학교 2학년 : " + gradeUseH2);
						System.out.println("고등학교 3학년 : " + gradeUseH3);
						System.out.println("###########종료###########");

					} else {
						
					}
				}
			};
			t.start();
		}
	}

	// 선생님 강의 업로드 수
	Integer teachLctreUploadHCnt;
	Integer teachLctreUploadHSum;
	Integer teachLctreUploadMSum;
	Integer teachLctreUploadPSum;

	public void _teachLctreUploadCnt() {

		teachLctreUploadHCnt = 0;
		teachLctreUploadHSum = 0;
		teachLctreUploadMSum = 0;
		teachLctreUploadPSum = 0;

		String q = "" + "SELECT count(*)" + "	FROM COMTNFILEDETAIL FD"
				+ "	  INNER JOIN TB_LCM_CNTNTS_MVP CM ON FD.ATCH_FILE_ID = CM.ATCH_FILE_ID"
				+ "	  INNER JOIN TB_LCM_CNTNTS_INFO CI ON CM.CNTNTS_SN = CI.CNTNTS_SN"
				+ "	  INNER JOIN TB_LCM_LCTRE_MANAGE LM ON CI.CNTNTS_SN = LM.CNTNTS_SN"
				+ "	  INNER JOIN TB_LCM_STEP_MANAGE SM ON LM.STEP_SN = SM.STEP_SN"
				+ "	  INNER JOIN TB_LCM_ALCTCR_MANAGE AM ON SM.ALCTCR_SN = AM.ALCTCR_SN"
				+ "	  INNER JOIN TB_LEM_HMPG_OPER HO ON AM.HMPG_OPER_SN = HO.HMPG_OPER_SN"
				+ "	  INNER JOIN TB_SCM_SCHUL SC ON HO.SCHUL_CODE = SC.SCHUL_CODE" + "	WHERE HO.HMPG_SE_CODE = '005'"
				+ "	AND HO.OPER_AT = 1" + "	AND AM.CLS_AT = 0" + "	AND LM.CNTNTS_TY_CODE = '001'"
				+ "	AND DATE_FORMAT(CM.FRST_REGIST_PNTTM, '%Y%m%d') >= '20200421'" + "	AND SC.HOST = ?";

		// 선생님 강의 업로드 이용건수
		/*
		 * String q = "" + "SELECT COUNT(*) FROM (" + "  SELECT count(*)" +
		 * "	FROM TB_LCM_CNTNTS_INFO CI " +
		 * "	  INNER JOIN TB_LCM_LCTRE_MANAGE LM ON CI.CNTNTS_SN = LM.CNTNTS_SN"
		 * + "	  INNER JOIN TB_LCM_STEP_MANAGE SM ON LM.STEP_SN = SM.STEP_SN" +
		 * "	  INNER JOIN TB_LCM_ALCTCR_MANAGE AM ON SM.ALCTCR_SN = AM.ALCTCR_SN"
		 * +
		 * "	  INNER JOIN TB_LEM_HMPG_OPER HO ON AM.HMPG_OPER_SN = HO.HMPG_OPER_SN"
		 * + "	  INNER JOIN TB_SCM_SCHUL SC ON HO.SCHUL_CODE = SC.SCHUL_CODE" +
		 * "    INNER JOIN TB_LEM_LCTRE_LRN_MANAGE LRM ON LRM.LCTRE_SN = LM.LCTRE_SN"
		 * + "	WHERE HO.HMPG_SE_CODE = '005'" + "	AND HO.OPER_AT = 1" +
		 * "	AND AM.CLS_AT = 0" + "	AND LM.CNTNTS_TY_CODE = '001'" +
		 * "	AND SC.HOST = ?" +
		 * " AND (DATE_FORMAT(LRM.LAST_UPDT_PNTTM, '%Y%m%d') >= '20200415' AND DATE_FORMAT(LRM.LAST_UPDT_PNTTM, '%Y%m%d') < '20200416')"
		 * + "  GROUP BY LRM.USER_ID" + "  ) a" + "  ;" ;
		 */

		for (DBConnection db : allDbs) {

			Thread t = new Thread() {

				@Override
				public void run() {

					int result = query(db, q, db.getName());

					if (db.getTag().equals("H")) {
						teachLctreUploadHSum += result;
					} else if (db.getTag().equals("M")) {
						teachLctreUploadMSum += result;
					} else if (db.getTag().equals("P")) {
						teachLctreUploadPSum += result;
					}

					teachLctreUploadHCnt++;

					if (teachLctreUploadHCnt >= allDbs.size()) {
						System.out.println(teachLctreUploadHSum);
						System.out.println(teachLctreUploadMSum);
						System.out.println(teachLctreUploadPSum);
					}

				}

			};

			t.start();

		}

	}

	// 컨텐츠별 강의 시간 통계
	int lctreTimeCnt;

	public void _lctreTimeCnt() {

		lctreTimeCnt = 0;

		String q = "" + "SELECT AM.ALCTCR_NM" // 강좌명
				+ "	  , LM.LCTRE_NM" // 강의명
				+ "	  , CM.REVIV_TIME" // 강의시간(초)
				+ "	  , TRUNCATE(CM.REVIV_TIME/60, 0) AS MIN" // 분
				+ "	  , MOD(CM.REVIV_TIME, 60) AS SEC" // 초
				+ "	  , CONCAT(TRUNCATE(CM.REVIV_TIME/60, 0), '분 ', MOD(CM.REVIV_TIME, 60), '초') AS LCTRE_TIME" // 강의시간
				+ "	FROM TB_LCM_CNTNTS_MVP CM" + "	  INNER JOIN TB_LCM_CNTNTS_INFO CI ON CM.CNTNTS_SN = CI.CNTNTS_SN"
				+ "	  INNER JOIN TB_LCM_LCTRE_MANAGE LM ON CI.CNTNTS_SN = LM.CNTNTS_SN"
				+ "	  INNER JOIN TB_LCM_STEP_MANAGE SM ON LM.STEP_SN = SM.STEP_SN"
				+ "	  INNER JOIN TB_LCM_ALCTCR_MANAGE AM ON SM.ALCTCR_SN = AM.ALCTCR_SN"
				+ "	  INNER JOIN TB_LEM_HMPG_OPER HO ON AM.HMPG_OPER_SN = HO.HMPG_OPER_SN"
				+ "	  INNER JOIN TB_SCM_SCHUL SC ON HO.SCHUL_CODE = SC.SCHUL_CODE" + "	WHERE HO.HMPG_SE_CODE = '005'"
				+ "	AND HO.OPER_AT = 1" + "	AND AM.CLS_AT = 0" + "	AND LM.CNTNTS_TY_CODE = '001'" + "	AND SC.HOST = ?"
				+ "	GROUP BY CI.CNTNTS_SN";

		Calendar c = Calendar.getInstance();
		String toDayStr = s_fmt.format(c.getTime());
		ExcelFileWriter w = new ExcelFileWriter(deskTopPath, "통계) 강의시간_" + toDayStr, "xlsx");

		for (DBConnection db : allDbs) {
			Thread t = new Thread() {
				@SuppressWarnings("unchecked")
				@Override
				public void run() {

					List<Map<String, Object>> datas = (List<Map<String, Object>>) queryM(db, q, db.getName())
							.get("data");

					w.addData(db.getName(), 0, 0, "강좌명");
					w.addData(db.getName(), 0, 1, "강의명");
					w.addData(db.getName(), 0, 2, "강의시간 (초)");
					w.addData(db.getName(), 0, 3, "분");
					w.addData(db.getName(), 0, 4, "초");
					w.addData(db.getName(), 0, 5, "강의시간");

					int rowIndex = 1;

					for (Map<String, Object> data : datas) {

						String alctcrNm = data.get("ALCTCR_NM") + "";
						String lctreNm = data.get("LCTRE_NM") + "";
						String revivTime = data.get("REVIV_TIME") + "";
						String min = data.get("MIN") + "";
						String sec = data.get("SEC") + "";
						String lctreTime = data.get("LCTRE_TIME") + "";

						w.addData(db.getName(), rowIndex, 0, alctcrNm);
						w.addData(db.getName(), rowIndex, 1, lctreNm);
						w.addData(db.getName(), rowIndex, 2, revivTime);
						w.addData(db.getName(), rowIndex, 3, min);
						w.addData(db.getName(), rowIndex, 4, sec);
						w.addData(db.getName(), rowIndex, 5, lctreTime);

						rowIndex++;

						System.out.println(db.getName() + " ::: " + rowIndex + " / " + datas.size());

					}

					lctreTimeCnt++;

					if (lctreTimeCnt >= allDbs.size()) {
						w.write();
					}

				}
			};

			t.start();

		}

	}

	// 일자별 동영상 강의 업로드 수
	Map<String, Long> dayOfMvpCntMap;
	int dayOfMvpCnt;

	public void _dayOfMvpCnt() {

		dayOfMvpCnt = 0;

		dayOfMvpCntMap = new HashMap<>();

		String q = "" + "SELECT DATE_FORMAT(CM.FRST_REGIST_PNTTM, '%Y%m%d') AS DAY, count(*) AS CNT"
				+ "	FROM COMTNFILEDETAIL FD"
				+ "	  INNER JOIN TB_LCM_CNTNTS_MVP CM ON FD.ATCH_FILE_ID = CM.ATCH_FILE_ID"
				+ "	  INNER JOIN TB_LCM_CNTNTS_INFO CI ON CM.CNTNTS_SN = CI.CNTNTS_SN"
				+ "	  INNER JOIN TB_LCM_LCTRE_MANAGE LM ON CI.CNTNTS_SN = LM.CNTNTS_SN"
				+ "	  INNER JOIN TB_LCM_STEP_MANAGE SM ON LM.STEP_SN = SM.STEP_SN"
				+ "	  INNER JOIN TB_LCM_ALCTCR_MANAGE AM ON SM.ALCTCR_SN = AM.ALCTCR_SN"
				+ "	  INNER JOIN TB_LEM_HMPG_OPER HO ON AM.HMPG_OPER_SN = HO.HMPG_OPER_SN"
				+ "	  INNER JOIN TB_SCM_SCHUL SC ON HO.SCHUL_CODE = SC.SCHUL_CODE" + "	WHERE HO.HMPG_SE_CODE = '005'"
				+ "	AND HO.OPER_AT = 1" + "	AND AM.CLS_AT = 0" + "	AND LM.CNTNTS_TY_CODE = '001'" + "	AND SC.HOST = ?"
				+ "	group by DATE_FORMAT(CM.FRST_REGIST_PNTTM, '%Y%m%d')";

		for (DBConnection db : allDbs) {
			Thread t = new Thread() {
				@SuppressWarnings("unchecked")
				@Override
				public void run() {

					List<Map<String, Object>> datas = (List<Map<String, Object>>) queryM(db, q, db.getName())
							.get("data");

					int index = 0;

					for (Map<String, Object> data : datas) {

						System.out.println(db.getName() + " ::: " + index + " / " + datas.size());

						String day = data.get("DAY") + "";
						long cnt = Long.parseLong(data.get("CNT") + "");

						if (dayOfMvpCntMap.containsKey(day)) {
							long strdCnt = dayOfMvpCntMap.get(day);
							strdCnt += cnt;
							dayOfMvpCntMap.put(day, strdCnt);
						} else {
							dayOfMvpCntMap.put(day, cnt);
						}

						index++;

					}

					dayOfMvpCnt++;

					if (dayOfMvpCnt >= allDbs.size()) {
						for (Map.Entry<String, Long> d : dayOfMvpCntMap.entrySet()) {
							System.out.println(d.getKey() + "	" + d.getValue());
						}
					} else {
						
					}

				}
			};
			t.start();
		}
	}

	// 온라인 클래스 일괄 생성
	int findHmpgEmptyDatasThreadCnt;

	public void _findHmpgEmptyDatas() {

		findHmpgEmptyDatasThreadCnt = 0;

		Calendar c = Calendar.getInstance();

		String toDayStr = s_fmt.format(c.getTime());

		String sd = "202004070000";
		String ed = "202004071400";
		String q = "" + " SELECT a.HMPG_URL, a.HMPG_NM, c.SCHUL_CODE, a.USER_ID" + "	FROM TB_LEM_HMPG_OPER a"
				+ "	INNER JOIN TB_SUM_HMPG_REQST b ON a.HMPG_REQST_SN = b.HMPG_REQST_SN"
				+ "	INNER JOIN TB_SCM_SCHUL c ON a.SCHUL_CODE = c.SCHUL_CODE"
				+ "	WHERE ( b.CLS_STTUS_CODE is null or b.CLS_STTUS_CODE <> '005' )" + "	AND c.HOST = ?" + "	AND ("
				+ "	  DATE_FORMAT(a.FRST_REGIST_PNTTM, '%Y%m%d%H%i') > '" + sd + "'"
				+ "	  AND DATE_FORMAT(a.FRST_REGIST_PNTTM, '%Y%m%d%H%i') < '" + ed + "'" + "	)";

		String operDel = "" + " UPDATE TB_LEM_HMPG_OPER SET" + "    OPER_AT = 2" + "  , LAST_UPDT_IP = '127.0.0.1'"
				+ "  , LAST_UPDT_PNTTM = SYSDATE()" + "  , LAST_UPDUSR_ID = 'SYSTEM'" + " WHERE HMPG_URL = ?";

		String reqstDel = "" + " UPDATE TB_SUM_HMPG_REQST SET" + "    CLS_STTUS_CODE = '005'"
				+ "  , CLS_STTUS_CN = '온라인클래스 사용자 폐쇄신청 (일괄)'" + "  , CLS_REQST_DE = CURDATE()"
				+ "  , CLS_APPLCNT_SN = 4699168" + "  , CLS_CONFM_DE = CURDATE()" + "  , CLS_CONFMER_SN = 4699168"
				+ "  , LAST_UPDT_IP = '127.0.0.1'" + "  , LAST_UPDT_PNTTM = SYSDATE()" + "  , LAST_UPDUSR_ID = 'SYSTEM'"
				+ " WHERE HMPG_URL = ?";

		ExcelFileWriter w = new ExcelFileWriter(deskTopPath, "클래스 일괄 폐쇄_" + toDayStr, "xlsx");

		for (DBConnection db : allDbs) {
			Thread t = new Thread() {
				@SuppressWarnings("unchecked")
				@Override
				public void run() {

					DBConnection mDb = mainDb.get(db.getTag());
					Map<String, Object> mainResult = mDb.execute(DBConnection.NONTIME_QUERY, q, db.getName());
					Map<String, Object> subResult = db.execute(DBConnection.NONTIME_QUERY, q, db.getName());

					List<Map<String, Object>> mDatas = (List<Map<String, Object>>) mainResult.get("data");
					List<Map<String, Object>> sDatas = (List<Map<String, Object>>) subResult.get("data");

					Map<String, Map<String, Object>> mMapDatas = new HashMap<>();

					// URL 값으로 키 등록
					for (Map<String, Object> map : mDatas) {
						mMapDatas.put((String) map.get("HMPG_URL"), map);
					}

					// 로컬 디비의 URL 키 값으로 메인 키 제거
					for (Map<String, Object> map : sDatas) {
						mMapDatas.remove(map.get("HMPG_URL"));
					}

					int row = 0;

					// 최종 데이터 출력 & 삭제
					for (Map.Entry<String, Map<String, Object>> map : mMapDatas.entrySet()) {

						String hmpgUrl = (String) map.getValue().get("HMPG_URL");
						String hmpgNm = (String) map.getValue().get("HMPG_URL");
						String schulCode = (String) map.getValue().get("HMPG_URL");
						String userId = (String) map.getValue().get("HMPG_URL");

						Integer operCnt = 0;
						Integer reqstCnt = 0;

						Map<String, Object> operResult = null;

						// 홈페이지 오퍼 업데이트
						try {
							operResult = mDb.execute(DBConnection.EXECUTE_UPDATE, operDel, hmpgUrl);
							operCnt = (Integer) operResult.get("data");
						} catch (Exception e) {
							operCnt = 0;
						}

						if (operCnt > 1) {
							System.out.println("다중 업데이트 오류 ::: OPER :: " + operResult.get("query"));
							mDb.rollback();
						} else if (operCnt == 1) {

							// 홈페이지 요처 업데이트
							try {
								Map<String, Object> reqstResult = mDb.execute(DBConnection.EXECUTE_UPDATE, reqstDel,
										hmpgUrl);
								reqstCnt = (Integer) reqstResult.get("data");
							} catch (Exception e) {
								reqstCnt = 0;
							}

							if (reqstCnt > 1) {
								System.out.println("다중 업데이트 오류 ::: REQST :: " + operResult.get("query"));
								mDb.rollback();
							}
						}

						w.addData(db.getName(), row, 0, hmpgUrl);
						w.addData(db.getName(), row, 1, hmpgNm);
						w.addData(db.getName(), row, 2, schulCode);
						w.addData(db.getName(), row, 3, userId);

						if (operCnt == 1 && reqstCnt == 1) {
							System.out.println(db.getName() + " ::: " + row + " / " + mMapDatas.size() + " ::: 삭제완료");
							w.addData(db.getName(), row, 5, "삭제완료");
						} else {
							System.out.println("삭제실패 ::: " + mDb.getName() + ") " + db.getName() + " >> hmpgUrl : "
									+ hmpgUrl + " / hmpgHm : " + hmpgNm + " / userId : " + userId);
							w.addData(db.getName(), row, 5, "삭제실패");
							w.addData(db.getName(), row, 6, "operCnt = " + operCnt);
							w.addData(db.getName(), row, 7, "reqstCnt = " + reqstCnt);
						}

						row++;
					}

					findHmpgEmptyDatasThreadCnt++;

					System.out.println();
					System.out.println();
					System.out.println("#################################");
					System.out.println("현재 남은 작업수 " + (allDbs.size() - findHmpgEmptyDatasThreadCnt));
					System.out.println("#################################");
					System.out.println();
					System.out.println();

					if (findHmpgEmptyDatasThreadCnt >= allDbs.size()) {
						System.out.println("#################################" + "\n");
						System.out.println("#################################" + "\n");
						System.out.println("#################################" + "\n");
						System.out.println("작업 결과 파일 생성중" + "\n");
						System.out.println("#################################" + "\n");
						System.out.println("#################################" + "\n");
						System.out.println("#################################" + "\n");
						w.write();

						System.out.println(" \n\n ");
						System.out.println(" ========== 작업 종료 ========== ");

					}
				}
			};
			t.start();
		}

	}

	// 클래스 게시판 일괄 생성
	int bbsEmptyMenuCnt;

	public void _bbsEmptyMenu() {

		bbsEmptyMenuCnt = 0;

		String selectQ = ""
				+ "   SELECT b.MENU_SN, b.BBS_ID, a.HMPG_OPER_SN, a.ESTER_SN, a.HMPG_URL, b.MENU_TMPLAT_CODE"
				+ "   FROM TB_LEM_HMPG_OPER a " + "   INNER JOIN TB_SMM_HMPG_MENU b ON a.HMPG_OPER_SN = b.HMPG_OPER_SN"
				+ "   INNER JOIN TB_SCM_SCHUL c ON a.SCHUL_CODE = c.SCHUL_CODE" + "   WHERE b.USE_AT = 1 "
				+ "   AND c.HOST = ?" /* 호스트 */
				+ "   AND b.BASS_MENU_AT = 1" + "   AND a.OPER_AT = 1"
				+ "   AND (b.MENU_TMPLAT_CODE = '001' OR b.MENU_TMPLAT_CODE = '006')"
				+ "   AND b.BBS_ID NOT IN (SELECT BBS_ID FROM tb_cbs_cmmn_bbs)"
				+ "   ORDER BY b.FRST_REGIST_PNTTM DESC";

		String insertQ = "" + " INSERT INTO TB_CBS_CMMN_BBS" + "			("
				+ "			BBS_ID, BBS_TY_CODE, BBS_NM, CTGRY_USE_AT, SJ_USE_AT"
				+ "			, PGE_LINK_USE_AT, CN_USE_AT, CN_EDITR_USE_AT, CN_INPUT_LMTT_CHRCTR_CO, TAG_USE_AT"
				+ "			, ATCHMNFL_USE_AT, ATCHMNFL_LMTT_CO, ATCHMNFL_EXTSN, ORIGIN_REGIST_AT, INDVDLINFO_COLCT_AT"
				+ "			, USE_AGRE_COLCT_PURPS, USE_AGRE_HOLD_PD, USE_AGRE_ETC_GUIDANCE, INDVDLINFO_CNSGN_ENTRPS, CNSGN_AGRE_COLCT_PURPS"
				+ "			, CNSGN_AGRE_HOLD_PD, CNSGN_AGRE_ETC_GUIDANCE, EVL_USE_AT, EVL_RECOMEND_USE_AT, EVL_RECOMEND_SJ"
				+ "			, EVL_NON_RECOMEND_USE_AT, EVL_NON_RECOMEND_SJ, EVL_PYEONG_POINT_USE_AT, ANSWER_USE_AT, ANSWER_SJ_USE_AT"
				+ "			, ANSWER_EDITR_USE_AT, ANSWER_TAG_USE_AT, ANSWER_ATCHMNFL_USE_AT, ANSWER_EVL_RECOMEND_USE_AT, ANSWER_EVL_RECOMEND_SJ"
				+ "			, ANSWER_EVL_NON_RECOMEND_USE_AT, ANSWER_EVL_NON_RECOMEND_SJ, ANSWER_EVL_SCORE_USE_AT, ANSWER_CMMNTS_USE_AT, ANSWER_CMMNTS_INPUT_LMTT_CHRCTR_CO"
				+ "			, CMMNTS_USE_AT, CMMNTS_INPUT_LMTT_CHRCTR_CO, SNS_CNRS_USE_AT, SNS_CNRS_FCBK_USE_AT, SNS_CNRS_TWTR_USE_AT"
				+ "			, SNS_CNRS_BAND_USE_AT, SNS_CNRS_KKSTRY_USE_AT, SNS_CNRS_ClSTNG_USE_AT, SNS_URL_USE_AT, BBSCTT_ESSNTL_USE_AT"
				+ "			, BBSCTT_ESSNTL_EXPSR_CO, BBSCTT_EXCLNC_USE_AT, BBSCTT_NEW_USE_AT, BBSCTT_NEW_EXPSR_CO, BBSCTT_THUMB_USE_AT"
				+ "			, BBSCTT_EXPSR_PRARNDE_USE_AT, BBSCTT_REDNG_AUTHOR_AT, BBSCTT_WRIT_AUTHOR_AT, ANSWER_REDNG_AUTHOR_AT, ANSWER_WRIT_AUTHOR_AT"
				+ "			, CMMNTS_REDNG_AUTHOR_AT, CMMNTS_WRIT_AUTHOR_AT, BBS_CLS_AT, ALCTCR_SN,CN_EDITR_CODE"
				+ "			,BBSCTT_EXCLNC_EXPSR_CO, HMPG_OPER_SN, FRST_REGIST_IP, FRST_REGIST_PNTTM, FRST_REGISTER_ID, LAST_UPDT_IP"
				+ "			, LAST_UPDT_PNTTM, LAST_UPDUSR_ID" + "     )" + " SELECT"
				+ "		?"/* 게시판 아이디 */
				+ ", BBS_TY_CODE, ?" /* 홈페이지 url + 공지게시형n */ + ", CTGRY_USE_AT, SJ_USE_AT"
				+ "		, PGE_LINK_USE_AT, CN_USE_AT, CN_EDITR_USE_AT, CN_INPUT_LMTT_CHRCTR_CO, TAG_USE_AT"
				+ "		, ATCHMNFL_USE_AT, ATCHMNFL_LMTT_CO, ATCHMNFL_EXTSN, ORIGIN_REGIST_AT, INDVDLINFO_COLCT_AT"
				+ "		, USE_AGRE_COLCT_PURPS, USE_AGRE_HOLD_PD, USE_AGRE_ETC_GUIDANCE, INDVDLINFO_CNSGN_ENTRPS, CNSGN_AGRE_COLCT_PURPS"
				+ "		, CNSGN_AGRE_HOLD_PD, CNSGN_AGRE_ETC_GUIDANCE, EVL_USE_AT, EVL_RECOMEND_USE_AT, EVL_RECOMEND_SJ"
				+ "		, EVL_NON_RECOMEND_USE_AT, EVL_NON_RECOMEND_SJ, EVL_PYEONG_POINT_USE_AT, ANSWER_USE_AT, ANSWER_SJ_USE_AT"
				+ "		, ANSWER_EDITR_USE_AT, ANSWER_TAG_USE_AT, ANSWER_ATCHMNFL_USE_AT, ANSWER_EVL_RECOMEND_USE_AT, ANSWER_EVL_RECOMEND_SJ"
				+ "		, ANSWER_EVL_NON_RECOMEND_USE_AT, ANSWER_EVL_NON_RECOMEND_SJ, ANSWER_EVL_SCORE_USE_AT, ANSWER_CMMNTS_USE_AT, ANSWER_CMMNTS_INPUT_LMTT_CHRCTR_CO"
				+ "		, CMMNTS_USE_AT, CMMNTS_INPUT_LMTT_CHRCTR_CO, SNS_CNRS_USE_AT, SNS_CNRS_FCBK_USE_AT, SNS_CNRS_TWTR_USE_AT"
				+ "		, SNS_CNRS_BAND_USE_AT, SNS_CNRS_KKSTRY_USE_AT, SNS_CNRS_ClSTNG_USE_AT, SNS_URL_USE_AT, BBSCTT_ESSNTL_USE_AT"
				+ "		, BBSCTT_ESSNTL_EXPSR_CO, BBSCTT_EXCLNC_USE_AT, BBSCTT_NEW_USE_AT, BBSCTT_NEW_EXPSR_CO, BBSCTT_THUMB_USE_AT"
				+ "		, BBSCTT_EXPSR_PRARNDE_USE_AT, BBSCTT_REDNG_AUTHOR_AT, BBSCTT_WRIT_AUTHOR_AT, ANSWER_REDNG_AUTHOR_AT, ANSWER_WRIT_AUTHOR_AT"
				+ "		, CMMNTS_REDNG_AUTHOR_AT, CMMNTS_WRIT_AUTHOR_AT, BBS_CLS_AT, ALCTCR_SN,CN_EDITR_CODE"
				+ "		,BBSCTT_EXCLNC_EXPSR_CO, ? " /* 홈페이지 번호 */
				+ ", FRST_REGIST_IP, FRST_REGIST_PNTTM, ?" /* 사용자 번호 */ + ", LAST_UPDT_IP"
				+ "		, LAST_UPDT_PNTTM, ?"/* 사용자 번호 */ + "" + "	FROM TB_CBS_CMMN_BBS"
				+ "	WHERE BBS_ID = ?" /* 템플 게시판 번호 */ + "";

		Map<String, String> tmplBbsId = new HashMap<>();
		tmplBbsId.put("001", "BBSID_000305066"); // 공지
		tmplBbsId.put("006", "BBSID_000305067"); // 일반

		Calendar car = Calendar.getInstance();

		String toDayStr = fmt2.format(car.getTime());

		ExcelFileWriter w = new ExcelFileWriter(deskTopPath, "게시판 일괄 생성_" + toDayStr, "xlsx");

		for (DBConnection db : allDbs) {
			Thread t = new Thread() {
				@SuppressWarnings("unchecked")
				@Override
				public void run() {

					System.out.println(db.getName() + " ::: 메뉴 빈 게시판 SELECT");
					List<Map<String, Object>> emptyData = (List<Map<String, Object>>) queryM(db, selectQ, db.getName()).get("data");
					System.out.println(db.getName() + " ::: 빈게시판 갯수 ::: " + emptyData.size());

					int sheetRowIndex = 0;

					for (Map<String, Object> data : emptyData) {

						String menuSn = data.get("MENU_SN") + "";
						String bbsId = data.get("BBS_ID") + "";
						String hmpgOperSn = data.get("HMPG_OPER_SN") + "";
						String esterSn = data.get("ESTER_SN") + "";
						String hmpgUrl = data.get("HMPG_URL") + "";
						String menuTmplatCode = data.get("MENU_TMPLAT_CODE") + "";

						Map<String, Object> reqstResult = db.execute(DBConnection.NONTIME_UPDATE, insertQ, bbsId,
								hmpgUrl, hmpgOperSn, esterSn, esterSn, tmplBbsId.get(menuTmplatCode));
						int insertCnt = (Integer) reqstResult.get("data");

						String insertResultStr = "";

						if (insertCnt == 1) {
							insertResultStr = "완료";
						} else {
							insertResultStr = "삭제실패";
						}

						w.addData(db.getName(), sheetRowIndex, 0, menuSn);
						w.addData(db.getName(), sheetRowIndex, 1, bbsId);
						w.addData(db.getName(), sheetRowIndex, 2, hmpgOperSn);
						w.addData(db.getName(), sheetRowIndex, 3, esterSn);
						w.addData(db.getName(), sheetRowIndex, 4, hmpgUrl);
						w.addData(db.getName(), sheetRowIndex, 5, menuTmplatCode);
						w.addData(db.getName(), sheetRowIndex, 6, insertResultStr);

						System.out.println(db.getName() + " :: " + sheetRowIndex + " / " + emptyData.size() + " ::: "
								+ insertResultStr);
						sheetRowIndex++;

					}

					bbsEmptyMenuCnt++;

					if (bbsEmptyMenuCnt >= allDbs.size()) {
						System.out.println(" ########### 작업 종료 ########### ");
						System.out.println(" ########## 파일 생성 중 ########## ");
						w.write();
						System.out.println(" ######### 파일 생성 완료 ######### ");
						System.out.println(" ######### " + w.getPath() + " ######### ");
					} else {
						System.out.println(" ======== 남은 DB수 :: " + (allDbs.size() - bbsEmptyMenuCnt) + " ======== ");
					}

				}
			};
			t.start();
		}

	}

	// 멤버 회원 일괄 가입 신청
	int operMberRgstCnt;
	Map<String, Integer> operMberRgstMap;

	public void _operMberRgst() {

		operMberRgstMap = new HashMap<>();
		operMberRgstCnt = 0;

		// 온라인 클래스 멤버 가입
		String q1 = "" + "SELECT " + "    c.HOST" + "  , b.HMPG_URL" + "  , d.RELATE_SN" + "  , d.AUTHOR_SN" + "  , a.*"
				+ " FROM tb_lem_hmpg_oper_mber a" + " INNER JOIN tb_lem_hmpg_oper b ON a.HMPG_OPER_SN = b.HMPG_OPER_SN"
				+ " INNER JOIN tb_scm_schul c ON b.SCHUL_CODE = c.SCHUL_CODE"
				+ " LEFT JOIN TB_SMM_HMPG_MBER_RELATE d ON a.OPER_MBER_SN = d.OPER_MBER_SN" + " WHERE c.HOST != ?"
				+ " AND a.FRST_REGIST_PNTTM >= '2020-04-10'" + " AND b.OPER_AT = 1";
		String q2 = "" + " SELECT *" + " FROM TB_SUM_USER_INFO " + " WHERE USER_ID = ?";
		String q3 = "" + " SELECT a.HMPG_OPER_SN, b.USER_ID, a.GRADE, a.CLASS" + " FROM TB_LEM_HMPG_OPER a "
				+ " LEFT JOIN (" + "   SELECT * FROM TB_LEM_HMPG_OPER_MBER WHERE USER_ID = ?" + " ) b"
				+ " ON a.HMPG_OPER_SN = b.HMPG_OPER_SN" + " WHERE a.HMPG_URL = ?";
		String q4 = "" + " INSERT INTO TB_LEM_HMPG_OPER_MBER " + "(" + " HMPG_OPER_SN" + ", USER_SN" + ", MBER_SRBDE"
				+ ", BKMK_AT" + ", MBER_STTUS_CODE"
				// + ", MBER_CONFM_DE"
				// + ", MBER_SECSN_DE"
				+ ", USER_ID" + ", USER_NM" + ", USER_SE_CODE" + ", GRADE" + ", CLASS" + ", CLASS_NO"
				+ ", FRST_REGIST_IP" + ", FRST_REGIST_PNTTM" + ", FRST_REGISTER_ID" + ", LAST_UPDT_IP"
				+ ", LAST_UPDT_PNTTM" + ", LAST_UPDUSR_ID" + ")" + " VALUES(" + "  ?" // HMPG_OPER_SN
				+ ", ?" // USER_SN
				+ ", ?" // MBER_SRBDE
				+ ", ?" // BKMK_AT
				+ ", ?" // MBER_STTUS_CODE
				// + ", ?" // MBER_CONFM_DE
				// + ", ?" // MBER_SECSN_DE
				+ ", ?" // USER_ID
				+ ", ?" // USER_NM
				+ ", ?" // USER_SE_CODE
				+ ", ?" // GRADE
				+ ", ?" // CLASS
				+ ", ?" // CLASS_NO
				+ ", ?" // FRST_REGIST_IP
				+ ", ?" // FRST_REGIST_PNTTM
				+ ", 'SYSTEM'" // FRST_REGISTER_ID
				+ ", ?" // LAST_UPDT_IP
				+ ", ?" // LAST_UPDT_PNTTM
				+ ", 'SYSTEM'" // LAST_UPDUSR_ID
				+ ")";

		ExcelFileWriter w = new ExcelFileWriter(deskTopPath, "USER_MBER_EMPTY", "xlsx");

		for (DBConnection db : allDbs) {
			Thread t = new Thread() {
				@SuppressWarnings("unchecked")
				@Override
				public void run() {

					// ################# 잘못 들어간 데이터 검색 ###################
					List<Map<String, Object>> q1Datas = (List<Map<String, Object>>) queryM(db, q1, db.getName())
							.get("data");

					w.addData(db.getName(), 0, 0, "BAD HOST");
					w.addData(db.getName(), 0, 1, "ORIGIN HOST");
					w.addData(db.getName(), 0, 2, "HMPG_URL");
					w.addData(db.getName(), 0, 3, "USER_ID");
					w.addData(db.getName(), 0, 4, "USER_NM");
					w.addData(db.getName(), 0, 5, "USER_SN");
					w.addData(db.getName(), 0, 6, "MBER_STTUS_CODE");
					w.addData(db.getName(), 0, 7, "RELATE_SN");
					w.addData(db.getName(), 0, 8, "AUTHOR_SN");
					w.addData(db.getName(), 0, 9, "FRST_REGIST_PNTTM");
					w.addData(db.getName(), 0, 10, "RESULT");

					int rowIndex = 1;

					// ################# 각데이터 조건한에 INSERT ###################
					for (Map<String, Object> data : q1Datas) {

						String host = data.get("HOST") + "";
						String hmpgUrl = data.get("HMPG_URL") + "";
						String userId = data.get("USER_ID") + "";
						String userNm = data.get("USER_NM") + "";
						String userSn = data.get("USER_SN") + "";
						String mberSttusCode = data.get("MBER_STTUS_CODE") + "";
						String relateSn = data.get("RELATE_SN") + "";
						String authorSn = data.get("AUTHOR_SN") + "";
						String frstRegistPnttm = data.get("FRST_REGIST_PNTTM") + "";
						String resultStr = "";

						// 회원가입처리가 완료 된 경우
						if (mberSttusCode.equals("005")) {
							resultStr = "이미가입된회원";
							// 회원가입처리가 안된 된 경우
						} else {

							DBConnection subDb = allDb.get(host);

							// ################### 사용자 정보가 있는지 확인
							// ###########################

							Map<String, Object> datas = queryM(subDb, q2, userId);
							List<Map<String, Object>> subDatas1 = null;
							if (datas != null && datas.containsKey("data")) {

								subDatas1 = (List<Map<String, Object>>) datas.get("data");

								// 사용자 정보가 있는 경우
								if (subDatas1 != null && subDatas1.size() > 0) {

									// ################### 원래 디비에 데이터가 있는지 확인
									// ###########################
									List<Map<String, Object>> subDatas2 = (List<Map<String, Object>>) queryM(subDb, q3,
											userId, hmpgUrl).get("data");

									String hmpgOperSn = subDatas2.get(0).get("HMPG_OPER_SN") + "";
									String subDbUserId = subDatas2.get(0).get("USER_ID") + "";

									// 데이터가 없는 경우 ( INSERT 수행 )
									if (subDbUserId == null || subDbUserId.equals("") || subDbUserId.equals("null")) {

										userSn = subDatas1.get(0).get("USER_SN") + "";
										String mberSrbde = data.get("MBER_SRBDE") + "";
										String bkmkAt = "0";
										/*
										 * String mberSttusCode =
										 * data.get("MBER_STTUS_CODE") + "";
										 */
										String mberConfmDe = "";
										String mberSecsnDe = "";
										/*
										 * String userId = data.get("USER_ID") +
										 * "";
										 */
										userNm = data.get("USER_NM") + "";
										String userSeCode = data.get("USER_SE_CODE") + "";
										String GRADE = data.get("GRADE") + "";
										String CLASS = data.get("CLASS") + "";
										String classNoStr = data.get("CLASS_NO") + "";
										String classNo = classNoStr.equals("null") ? 0 + ""
												: Integer.parseInt(classNoStr) + "";
										String frstRegistIp = data.get("FRST_REGIST_IP") + "";
										frstRegistPnttm = data.get("FRST_REGIST_PNTTM") + "";
										/*
										 * String frstRegistId =
										 * data.get("FRST_REGIST_ID") + "";
										 */
										String lastUpdtIp = data.get("LAST_UPDT_IP") + "";
										String lastUpdtPnttm = data.get("LAST_UPDT_PNTTM") + "";
										/*
										 * String lastUpdUsrId =
										 * data.get("LAST_UPDUSR_ID") + "";
										 */

										int result = insert(subDb, q4, hmpgOperSn, userSn, mberSrbde, bkmkAt,
												mberSttusCode/*
																 * , mberConfmDe
																 * , mberSecsnDe
																 */
										, userId, userNm, userSeCode, GRADE, CLASS, classNo, frstRegistIp,
												frstRegistPnttm, lastUpdtIp, lastUpdtPnttm);

										if (result > 0)
											resultStr = "회원저장성공";
										else
											resultStr = "회원저장실패";

										// 데이터가 이미 있는 경우 :: 사용자가 정상 디비에서 재가입
									} else {
										resultStr = "사용자재가입신청";
									}
								} else {
									// 사용자 정보가 없는경우
									resultStr = "사용자정보없음";
								}

							} else {
								resultStr = "DB 없음";
							}

						}

						w.addData(db.getName(), rowIndex, 0, db.getName());
						w.addData(db.getName(), rowIndex, 1, host);
						w.addData(db.getName(), rowIndex, 2, hmpgUrl);
						w.addData(db.getName(), rowIndex, 3, userId);
						w.addData(db.getName(), rowIndex, 4, userNm);
						w.addData(db.getName(), rowIndex, 5, userSn);
						w.addData(db.getName(), rowIndex, 6, mberSttusCode);
						w.addData(db.getName(), rowIndex, 7, relateSn);
						w.addData(db.getName(), rowIndex, 8, authorSn);
						w.addData(db.getName(), rowIndex, 9, frstRegistPnttm);
						w.addData(db.getName(), rowIndex, 10, resultStr);

						rowIndex++;

						System.out.println(db.getName() + " :: " + rowIndex + " / " + q1Datas.size() + "\n");

					}

					// ################### 종료 검사 ######################
					operMberRgstCnt++;
					if (operMberRgstCnt >= allDbs.size()) {
						w.write();
						System.out.println(" ############################### \n ");
						System.out.println(" #############종료############### \n ");
						System.out.println(" ############################### \n ");
					} else {
						System.out.println(" ########## 남은 DB수 : " + (allDbs.size() - operMberRgstCnt) + "개 ############# \n");
					}

				}
			};
			t.start();
		}

	}

	// 선생님 강좌 생성 목록
	int alctcrEmptyCnt = 0;
	Map<String, Integer> alctcrEmptyMap;

	public void _alctcrEmpty() {

		alctcrEmptyCnt = 0;

		alctcrEmptyMap = new HashMap<>();

		// 강좌 생성
		/*
		 * String q = "" + " SELECT ?, c.HOST, d.*" + "	FROM tb_lem_hmpg_oper b"
		 * + "	INNER JOIN tb_scm_schul c" + "	ON b.SCHUL_CODE = c.SCHUL_CODE"
		 * + "	INNER JOIN tb_lcm_alctcr_manage d" +
		 * "	ON b.HMPG_OPER_SN = d.HMPG_OPER_SN" + "	WHERE c.HOST != ?" +
		 * "	AND d.FRST_REGIST_PNTTM >= '2020-04-10'" ;
		 */
		// 수강
		/*
		 * String q = "" + " SELECT ?, c.HOST, f.*" + "	FROM tb_lem_hmpg_oper b"
		 * + "	INNER JOIN tb_scm_schul c" + "	ON b.SCHUL_CODE = c.SCHUL_CODE"
		 * + "	INNER JOIN tb_lcm_alctcr_manage e" +
		 * "	ON b.HMPG_OPER_SN = e.HMPG_OPER_SN" +
		 * "	INNER JOIN tb_lem_alctcr_atnlc f" +
		 * "	ON e.ALCTCR_SN = f.ALCTCR_SN" + "	WHERE c.HOST != ?" +
		 * "	AND f.FRST_REGIST_PNTTM >= '2020-04-10'" ;
		 */
		// 수강이력
		String q = "" + " SELECT ?, c.HOST, b.HMPG_URL, g.*" + "	FROM tb_lem_hmpg_oper b"
				+ "	INNER JOIN tb_scm_schul c" + "	ON b.SCHUL_CODE = c.SCHUL_CODE"
				+ "	INNER JOIN tb_lcm_alctcr_manage e" + "	ON b.HMPG_OPER_SN = e.HMPG_OPER_SN"
				+ "	INNER JOIN tb_lem_alctcr_atnlc f" + "	ON e.ALCTCR_SN = f.ALCTCR_SN"
				+ "	INNER JOIN tb_lem_lctre_lrn_manage g" + "	ON f.ATNLC_NO = g.ATNLC_NO" + "	WHERE c.HOST != ?"
				+ "	AND g.FRST_REGIST_PNTTM >= '2020-04-10'";

		/*
		 * ExcelFileWriter w = new ExcelFileWriter(deskTopPath, "선생님 강좌 생성 목록",
		 * "xlsx");
		 * 
		 * for(DBConnection db : allDbs){ Thread t = new Thread(){
		 * 
		 * @Override public void run() {
		 * 
		 * int result = query(db, q, db.getName());
		 * 
		 * if(alctcrEmptyMap.containsKey(db.getName())){ result +=
		 * alctcrEmptyMap.get(db.getName()); alctcrEmptyMap.put(db.getName(),
		 * result); }else { alctcrEmptyMap.put(db.getName(), result); }
		 * 
		 * // ################### 종료 검사 ###################### alctcrEmptyCnt++;
		 * if(alctcrEmptyCnt >= allDbs.size()){
		 * textAreas.get(4).append(" ############################### \n ");
		 * textAreas.get(4).append(" ############################### \n ");
		 * textAreas.get(4).append(" ############################### \n ");
		 * textAreas.get(4).append(" ############################### \n ");
		 * textAreas.get(4).setCaretPosition(textAreas.get(4).getDocument().
		 * getLength());
		 * 
		 * int sum = 0; for(DBConnection d : allDbs){
		 * 
		 * int data = alctcrEmptyMap.get(d.getName());
		 * 
		 * sum += data;
		 * 
		 * textAreas.get(4).append( d.getName() + " :: " + data + "\n" );
		 * textAreas.get(4).setCaretPosition(textAreas.get(4).getDocument().
		 * getLength()); }
		 * 
		 * textAreas.get(4).append( sum + "\n" ); // w.write();
		 * 
		 * textAreas.get(4).append(" ############################### \n ");
		 * textAreas.get(4).append(" #############종료############### \n ");
		 * textAreas.get(4).append(" ############################### \n ");
		 * textAreas.get(4).setCaretPosition(textAreas.get(4).getDocument().
		 * getLength()); }else { textAreas.get(4).append(" ########## 남은 DB수 : "
		 * + (allDbs.size() - alctcrEmptyCnt) + "개 ############# \n");
		 * textAreas.get(4).setCaretPosition(textAreas.get(4).getDocument().
		 * getLength()); } } };
		 * 
		 * t.start(); }
		 */

		allDbsToExcelQuery("수강 이력", q, 1);

	}

	// 홈페이지 방문수 ( 로그인 이력 )
	int loginHistCnt = 0;
	long tot = 0;

	public void _loginHist() {

		loginHistCnt = 0;

		String q = "" + " SELECT COUNT(*) AS cnt FROM (" + " SELECT COUNT(*) FROM tb_stm_login_hist"
				+ " WHERE (DATE_FORMAT(FRST_REGIST_PNTTM, '%Y%m%d%H%i') > '202004220000'"
				+ " AND DATE_FORMAT(FRST_REGIST_PNTTM, '%Y%m%d%H%i') < '202004230000')" + " GROUP BY FRST_REGISTER_ID"
				+ " )a";

		for (DBConnection db : allDbs) {
			Thread t = new Thread() {
				@Override
				public void run() {
					long cnt = query(db, q);

					tot += cnt;

					loginHistCnt++;

					if (loginHistCnt >= allDbs.size()) {
						System.out.println("##### " + tot);
					} else {
						System.out.println(db.getName() + " ::: " + cnt);
					}
				}
			};
			t.start();
		}

	}

	// 100 디비 데이터 To 엑셀 파일
	int allDbsToExcelQueryCnt = 0;
	Map<String, Integer> allDbsToExcelQueryMap;
	Map<Integer, Map<Integer, Object>> sumData = new HashMap<>();

	public void allDbsToExcelQuery(String fileName, String Query, int mode) {

		// mode : 0 카운트
		// mode : 1 APPEND
		// mode : 2 SUM
		
		allDbsToExcelQueryCnt = 0;

		allDbsToExcelQueryMap = new HashMap<>();

		sumData = new HashMap<>();

		Calendar cal = Calendar.getInstance();

		SimpleDateFormat fmt = new SimpleDateFormat("MMddHHmmss");

		ExcelFileWriter w = new ExcelFileWriter(deskTopPath, fileName + "_" + fmt.format(cal.getTime()), "xlsx");

		// 첫 시트 등록
		if (mode == 2) {
			w.addData("SUM", 0, 0, "");
		}

		for (DBConnection db : allDbs) {
			// 엑셀 형식일 경우 시트 우선 등록 ( 정렬을 위해 )
			if (mode == 1) {
				w.addData(db.getName(), 0, 0, "");
			} else if (mode == 2) {
				w.addData(db.getName(), 0, 0, "");
			}

			Thread t = new Thread() {
				@SuppressWarnings("unchecked")
				@Override
				public void run() {

					// 카운트
					if (mode == 0) {
						int result = query(db, Query, db.getName());
						if (allDbsToExcelQueryMap.containsKey(db.getName())) {
							result += allDbsToExcelQueryMap.get(db.getName());
							allDbsToExcelQueryMap.put(db.getName(), result);
						} else {
							allDbsToExcelQueryMap.put(db.getName(), result);
						}
						// 오브젝트
					} else if (mode == 1) {

						List<Map<String, Object>> resultList = (List<Map<String, Object>>) queryM(db, Query,
								db.getName()/* , db.getName() */).get("data");

						int rowIndex = 1;

						for (Map<String, Object> item : resultList) {

							TreeMap<String, Object> tMap = new TreeMap<String, Object>(item);

							int colIndex = 0;
							for (Map.Entry<String, Object> map : tMap.entrySet()) {
								// ColName Set
								if (rowIndex == 1)
									w.addData(db.getName(), 0, colIndex, map.getKey());

								// ColData Set
								w.addData(db.getName(), rowIndex, colIndex++, map.getValue());
							}
							rowIndex++;
						}

					} else if (mode == 2) {

						List<Map<String, Object>> resultList = (List<Map<String, Object>>) queryM(db, Query,
								db.getName()/* , db.getName() */).get("data");

						int rowIndex = 1;

						for (Map<String, Object> item : resultList) {

							TreeMap<String, Object> tMap = new TreeMap<String, Object>(item);

							int colIndex = 0;
							for (Map.Entry<String, Object> map : tMap.entrySet()) {
								// ColName Set
								if (rowIndex == 1) {
									w.addData(db.getName(), 0, colIndex, map.getKey());

									if (!sumData.containsKey(0))
										sumData.put(0, new HashMap<Integer, Object>());
									sumData.get(0).put(colIndex, map.getKey());
								}

								// ColData Set
								Long value = null;

								if (!sumData.containsKey(rowIndex)) {
									sumData.put(rowIndex, new HashMap<Integer, Object>());
								}

								try {
									// 연산이 가능한 데이터일경우
									value = Long.parseLong((map.getValue() + "").trim());

									if (value != null) {
										w.addData(db.getName(), rowIndex, colIndex, map.getValue());

										if (!sumData.get(rowIndex).containsKey(colIndex)) {
											sumData.get(rowIndex).put(colIndex, value);
										} else {
											sumData.get(rowIndex).put(colIndex,
													(Long) sumData.get(rowIndex).get(colIndex) + value);
										}
									}
								} catch (Exception e) {
									// 연산이 불가능한 데이터일경우
									w.addData(db.getName(), rowIndex, colIndex, map.getValue());
									sumData.get(rowIndex).put(colIndex, map.getValue());
								}

								colIndex++;
							}
							rowIndex++;

						}

					}

					// ################### 종료 검사 ######################
					allDbsToExcelQueryCnt++;
					if (allDbsToExcelQueryCnt >= allDbs.size()) {
						System.out.println(" ############################### \n ");
						System.out.println(" ############################### \n ");
						System.out.println(" ############################### \n ");
						System.out.println(" ############################### \n ");

						if (mode == 0) {
							int sum = 0;
							for (DBConnection d : allDbs) {

								int data = allDbsToExcelQueryMap.get(d.getName());

								sum += data;

								System.out.println(d.getName() + " :: " + data + "\n");
							}
							System.out.println(sum + "\n");
						} else if (mode == 1) {
							w.write();
						} else if (mode == 2) {
							for (Map.Entry<Integer, Map<Integer, Object>> rowDatas : sumData.entrySet())
								for (Map.Entry<Integer, Object> colDatas : sumData.get(rowDatas.getKey()).entrySet()) {
									w.addData("SUM", rowDatas.getKey(), colDatas.getKey(), colDatas.getValue());
								}

							w.write();
						}

						System.out.println(" ############################### \n ");
						System.out.println(" #############종료############### \n ");
						System.out.println(" ############################### \n ");

					} else {
						
					}

				}
			};
			t.start();
		}

	}

	public DBConnection getMainDB(String SchulCode) {

		switch (SchulCode) {
		case "H":
			return new DBConnection("HOC / 메인", "jdbc:mysql://ebshocprodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebshocprodmysql", "esofedu");
		case "M":
			return new DBConnection("POC / 메인", "jdbc:mysql://ebsocprodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsocprodmysql", "esofedu");
		case "P":
			return new DBConnection("POC / 메인", "jdbc:mysql://ebsocprodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsocprodmysql", "esofedu");
		default:
			return new DBConnection("POC / 메인", "jdbc:mysql://ebsocprodmysql.mysql.database.azure.com/ebsesof",
					DBConnection.MYSQL, "esofedu@ebsocprodmysql", "esofedu");
		}

	}

	@SuppressWarnings("unchecked")
	public Object dataSet(Map<String, Object> parseData) {
		List<Map<String, Object>> data = (List<Map<String, Object>>) parseData.get("data");
//		System.out.println(parseData.get("query"));
		for (Map<String, Object> list : data) {
			for (Map.Entry<String, Object> d : list.entrySet()) {
//				System.out.println(" ::: " + d.getValue());
				return d.getValue();
				// area.get(schulCode).append("\n" + str + " : " +
				// d.getValue());
				// System.out.print(d.getKey() + "\t");
				// System.out.println(d.getValue());
			}
		}
		return 0;
	}

	public Integer query(DBConnection db, String query, String... param) {
		ArrayList<String> params = new ArrayList<String>(Arrays.asList(param));
		try {

			Integer result = null;

			if (query.contains("?"))
				result = Integer.parseInt(dataSet(db.execute(DBConnection.NONTIME_QUERY, query, param)) + "");
			else
				result = Integer.parseInt(dataSet(db.execute(DBConnection.NONTIME_QUERY, query)) + "");

//			if (query.contains("?"))
//				System.out.println(" // " + db.getName() + " // PARAM ::: " + params.toString());
//			else
//				System.out.println(" // " + db.getName());

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(db.getName());
			return query(db, query, param);
		}
	}

	public Map<String, Object> queryM(DBConnection db, String query, String... param) {
		ArrayList<String> params = new ArrayList<String>(Arrays.asList(param));
		try {
			if (db != null) {

				Map<String, Object> map = null;

				if (query.contains("?"))
					map = db.execute(DBConnection.NONTIME_QUERY, query, param);
				else
					map = db.execute(DBConnection.NONTIME_QUERY, query);

				System.out.println(map.get("query"));

//				if (query.contains("?"))
//					System.out.println(" // " + db.getName() + " // PARAM ::: " + params.toString());
//				else
//					System.out.println(" // " + db.getName());

				return map;

			} else {
				System.out.println("DB가 없습니다.");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(db.getName());
			return queryM(db, query, param);
		}
	}

	public int insert(DBConnection db, String query, String... param) {

		ArrayList<String> params = new ArrayList<String>(Arrays.asList(param));
		Map<String, Object> map = db.execute(DBConnection.NONTIME_UPDATE, query, param);

//		System.out.println(map.get("query"));
//		System.out.println(" // " + db.getName() + " // PARAM ::: " + params.toString());

		return (int) map.get("data");

	}
	
	public String getShculLevelNm(String code) {
		switch (code) {
		case "P":
			return "초등학교";
		case "M":
			return "중학교";
		case "H":
			return "고등학교";
		default:
			return "";
		}
	}

}
