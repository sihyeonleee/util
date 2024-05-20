package service.tmp; 

import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;

import comm.CustomThread;
import comm.remote.FTP;
import comm.remote.SSH;
import gui.obj.CompObj;
import gui.obj.FrameObj;
import service.Service;  

public class EBSService extends Service{
	
	String user = "ebsesof";
	String pwd = "Ebsesof!@#$!@#$";
	
	String[] prjNm = {"온클", "이솦"};
	String[] deployPosition = {"운영", "테스트"};
	String[] oncleHostNms = {
			  "oc1" , "oc2" , "oc3" , "oc4" , "oc5" , "oc6" , "oc7" , "oc8" , "oc9" , "oc10"
			, "oc11" , "oc12" , "oc13" , "oc14" , "oc15" , "oc16" , "oc17" , "oc18" , "oc19" , "oc20"
			, "oc21" , "oc22" , "oc23" , "oc24" , "oc25" , "oc26" , "oc27" , "oc28" , "oc29" , "oc30"
			, "oc31" , "oc32" , "oc33" , "oc34" , "oc35" , "oc36" , "oc37" , "oc38" , "oc39" , "oc40"
			, "oc41" , "oc42" , "oc43" , "oc44" , "oc45" , "oc46" , "oc47" , "oc48" , "oc49" , "oc50"
			, "hoc1" , "hoc2" , "hoc3" , "hoc4" , "hoc5" , "hoc6" , "hoc7" , "hoc8" , "hoc9" , "hoc10"
			, "hoc11" , "hoc12" , "hoc13" , "hoc14" , "hoc15" , "hoc16" , "hoc17" , "hoc18" , "hoc19" , "hoc20"
			, "hoc21" , "hoc22" , "hoc23" , "hoc24" , "hoc25" , "hoc26" , "hoc27" , "hoc28" , "hoc29" , "hoc30"
			, "hoc31" , "hoc32" , "hoc33" , "hoc34" , "hoc35" , "hoc36" , "hoc37" , "hoc38" , "hoc39" , "hoc40"
			, "hoc41" , "hoc42" , "hoc43" , "hoc44" , "hoc45" , "hoc46" , "hoc47" , "hoc48" , "hoc49"};
	
	public EBSService(){ 

		// 프레임 설정
		width = 300;
		height = 400;
		divisionX = 100;
		divisionY = 107;
		layout = FrameObj.LAYOUT_GRIDBAG;
		isAlwasOnTop = true;
		
		
		// 컴포넌트 설정
		CompObj btn1 = new CompObj();
		btn1.setName("was1");
		btn1.setEvtName("was1");
		btn1.setType(CompObj.TYPE_BUTTON);
		btn1.setEventType(CompObj.EVENT_ACTION);
		btn1.setGridPosition(0, 0);
		btn1.setGridWeight(1, 1);
		btn1.setArrangeType(GridBagConstraints.BOTH);
		componentObjs.add(btn1);

		CompObj btn2 = new CompObj();
		btn2.setName("was2");
		btn2.setEvtName("was2");
		btn2.setType(CompObj.TYPE_BUTTON);
		btn2.setEventType(CompObj.EVENT_ACTION);
		btn2.setGridPosition(1, 0);
		btn2.setGridWeight(1, 1);
		btn2.setArrangeType(GridBagConstraints.BOTH);
		componentObjs.add(btn2);
		
		CompObj btn3 = new CompObj();
		btn3.setName("was3");
		btn3.setEvtName("was3");
		btn3.setType(CompObj.TYPE_BUTTON);
		btn3.setEventType(CompObj.EVENT_ACTION);
		btn3.setGridPosition(2, 0);
		btn3.setGridWeight(1, 1);
		btn3.setArrangeType(GridBagConstraints.BOTH);
		componentObjs.add(btn3);
		
		CompObj btn4 = new CompObj();
		btn4.setName("deploy");
		btn4.setEvtName("deploy");
		btn4.setType(CompObj.TYPE_BUTTON);
		btn4.setEventType(CompObj.EVENT_ACTION);
		btn4.setGridSize(3, 1);
		btn4.setGridPosition(0, 1);
		btn4.setGridWeight(1, 1);
		btn4.setArrangeType(GridBagConstraints.BOTH);
		componentObjs.add(btn4);
		
		CompObj area1 = new CompObj();
		area1.setEnabled(true);
		area1.setScrollAt(true);
		area1.setType(CompObj.TYPE_PANEL);
		area1.setEventType(CompObj.EVENT_DRAGDROP, CompObj.EVENT_KEYTYPE);
		area1.setLayout(CompObj.LAYOUT_BOX, BoxLayout.Y_AXIS);
		area1.setEvtName("area");
		area1.setGridSize(3, 2);
		area1.setGridWeight(30, 30);
		area1.setGridPosition(0, 2);
		area1.setArrangeType(GridBagConstraints.BOTH);
		componentObjs.add(area1);

	}

	@Override
	public void doShow(String name) {
		// Component Object Settings 
		super.doShow(name);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initData(){
		
		/*List<Map<String, Object>> maps = new ArrayList<>();
		
		Map<String, Object> map = new HashMap<>();
		map.put("lPort", 222);
		map.put("rPort", 22);
		map.put("rHost", "172.17.22.26");
		maps.add(map);
		
		Map<String, Object> map2 = new HashMap<>();
		map2.put("lPort", 6258);
		map2.put("rPort", 22);
		map2.put("rHost", "172.17.22.26");
		maps.add(map2);
		
		try {
			ssh.setTunnels(maps);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		Map<String, Map<String, Map<String, Object>>> metaInfo = new HashMap<>();
		
		metaInfo.put("테스트", new HashMap<>());
		metaInfo.get("테스트").put("이솦", new HashMap<>());
		metaInfo.get("테스트").get("이솦").put("cmd", new String[]{"/app/jboss/servers/esof2_node11/"});
		metaInfo.get("테스트").get("이솦").put("was", "/data/ESOF/deploy/esofWeb2/ebs-software-portal-front.war/WEB-INF/");
		metaInfo.get("테스트").get("이솦").put("web", "/data/ESOF/www/esofWeb2/");
		
		metaInfo.put("운영", new HashMap<>());
		metaInfo.get("운영").put("이솦", new HashMap<>());
		metaInfo.get("운영").get("이솦").put("tunIp", "52.231.202.221");
		metaInfo.get("운영").get("이솦").put("cmd", new String[]{"/app/was/domains/ebssw11/", "/app/was/domains/ebssw12/", "/app/was/domains/ebssw13/"});
		metaInfo.get("운영").get("이솦").put("was", "/data/ESOF/deploy/esofWeb/ebs-software-portal-front.war/WEB-INF/");
		metaInfo.get("운영").get("이솦").put("web", "/data/ESOF/www/esofWeb/");

		metaInfo.put("테스트", new HashMap<>());
		metaInfo.get("테스트").put("온클", new HashMap<>());
		metaInfo.get("테스트").get("온클").put("cmd", new String[]{"/app/jboss/servers/oc_node11/", "/app/jboss/servers/oc_node12/"});
		metaInfo.get("테스트").get("온클").put("was", "/data/ESOF/deploy/onlineClass/ebs-software-portal-front.war/WEB-INF/");
		metaInfo.get("테스트").get("온클").put("web", "/data/ESOF/www/onlineClass/");
		
		metaInfo.put("운영", new HashMap<>());
		metaInfo.get("운영").put("온클", new HashMap<>());
		metaInfo.get("운영").get("온클").put("tunIp", "52.231.202.221");
		metaInfo.get("운영").get("온클").put("cmd", new String[]{"/app/was/domains/ebssw11/", "/app/was/domains/ebssw12/", "/app/was/domains/ebssw13/"});
		metaInfo.get("운영").get("온클").put("was", "/app/ESOF/deploy/esofWeb/ebs-software-portal-front.war/WEB-INF/");
		metaInfo.get("운영").get("온클").put("web", "/app/ESOF/www/esofWeb/");
		
		
		
		Map<String, Map<String, Object>> hostInfo = new HashMap<>();
		
		hostInfo.put("테스트", new HashMap<>());
		hostInfo.get("테스트").put("이솦", new Obj(new String[]{"52.231.184.207"}, new int[]{22}));
		
		hostInfo.put("테스트", new HashMap<>());
		hostInfo.get("테스트").put("온클", new Obj(new String[]{"52.231.184.207"}, new int[]{22}));
		
		hostInfo.put("운영", new HashMap<>());
		hostInfo.get("운영").put("이솦", new HashMap<>());
		hostInfo.get("운영").put("이솦", new Obj(new String[]{"172.17.20.9", "172.17.20.11"}, new int[]{25001, 25002}));
		
		hostInfo.put("운영", new HashMap<>());
		hostInfo.get("운영").put("온클", new HashMap<>());
		((Map) hostInfo.get("운영").get("온클")).put("oc1",   new Obj(new String[]{}, new int[]{1011, 1012, 1013}, new String[]{}, new int[]{2011, 2012, 2013}));
		((Map) hostInfo.get("운영").get("온클")).put("oc2",   new Obj(new String[]{}, new int[]{1021, 1022, 1023}, new String[]{}, new int[]{2021, 2022, 2023}));
		((Map) hostInfo.get("운영").get("온클")).put("oc3",   new Obj(new String[]{}, new int[]{1031, 1032, 1033}, new String[]{}, new int[]{2031, 2032, 2033}));
		((Map) hostInfo.get("운영").get("온클")).put("oc4",   new Obj(new String[]{}, new int[]{1041, 1042, 1043}, new String[]{}, new int[]{2041, 2042, 2043}));
		((Map) hostInfo.get("운영").get("온클")).put("oc5",   new Obj(new String[]{}, new int[]{1051, 1052, 1053}, new String[]{}, new int[]{2051, 2052, 2053}));
		((Map) hostInfo.get("운영").get("온클")).put("oc6",   new Obj(new String[]{}, new int[]{1061, 1062, 1063}, new String[]{}, new int[]{2061, 2062, 2063}));
		((Map) hostInfo.get("운영").get("온클")).put("oc7",   new Obj(new String[]{}, new int[]{1071, 1072, 1073}, new String[]{}, new int[]{2071, 2072, 2073}));
		((Map) hostInfo.get("운영").get("온클")).put("oc8",   new Obj(new String[]{}, new int[]{1081, 1082, 1083}, new String[]{}, new int[]{2081, 2082, 2083}));
		((Map) hostInfo.get("운영").get("온클")).put("oc9",   new Obj(new String[]{}, new int[]{1091, 1092, 1093}, new String[]{}, new int[]{2091, 2092, 2093}));
		((Map) hostInfo.get("운영").get("온클")).put("oc10",  new Obj(new String[]{}, new int[]{1101, 1102, 1103}, new String[]{}, new int[]{2101, 2102, 2103}));
		((Map) hostInfo.get("운영").get("온클")).put("oc11",  new Obj(new String[]{}, new int[]{1111, 1112, 1113}, new String[]{}, new int[]{2111, 2112, 2113}));
		((Map) hostInfo.get("운영").get("온클")).put("oc12",  new Obj(new String[]{}, new int[]{1121, 1122, 1123}, new String[]{}, new int[]{2121, 2122, 2123}));
		((Map) hostInfo.get("운영").get("온클")).put("oc13",  new Obj(new String[]{}, new int[]{1131, 1132, 1133}, new String[]{}, new int[]{2131, 2132, 2133}));
		((Map) hostInfo.get("운영").get("온클")).put("oc14",  new Obj(new String[]{}, new int[]{1141, 1142, 1143}, new String[]{}, new int[]{2141, 2142, 2143}));
		((Map) hostInfo.get("운영").get("온클")).put("oc15",  new Obj(new String[]{}, new int[]{1151, 1152, 1153}, new String[]{}, new int[]{2151, 2152, 2153}));
		((Map) hostInfo.get("운영").get("온클")).put("oc16",  new Obj(new String[]{}, new int[]{1161, 1162, 1163}, new String[]{}, new int[]{2161, 2162, 2163}));
		((Map) hostInfo.get("운영").get("온클")).put("oc17",  new Obj(new String[]{}, new int[]{1171, 1172, 1173}, new String[]{}, new int[]{2171, 2172, 2173}));
		((Map) hostInfo.get("운영").get("온클")).put("oc18",  new Obj(new String[]{}, new int[]{1181, 1182, 1183}, new String[]{}, new int[]{2181, 2182, 2183}));
		((Map) hostInfo.get("운영").get("온클")).put("oc19",  new Obj(new String[]{}, new int[]{1191, 1192, 1193}, new String[]{}, new int[]{2191, 2192, 2193}));
		((Map) hostInfo.get("운영").get("온클")).put("oc20",  new Obj(new String[]{}, new int[]{1201, 1202, 1203}, new String[]{}, new int[]{2201, 2202, 2203}));
		((Map) hostInfo.get("운영").get("온클")).put("oc21",  new Obj(new String[]{}, new int[]{1211, 1212, 1213}, new String[]{}, new int[]{2211, 2212, 2213}));
		((Map) hostInfo.get("운영").get("온클")).put("oc22",  new Obj(new String[]{}, new int[]{1221, 1222, 1223}, new String[]{}, new int[]{2221, 2222, 2223}));
		((Map) hostInfo.get("운영").get("온클")).put("oc23",  new Obj(new String[]{}, new int[]{1231, 1232, 1233}, new String[]{}, new int[]{2231, 2232, 2233}));
		((Map) hostInfo.get("운영").get("온클")).put("oc24",  new Obj(new String[]{}, new int[]{1241, 1242, 1243}, new String[]{}, new int[]{2241, 2242, 2243}));
		((Map) hostInfo.get("운영").get("온클")).put("oc25",  new Obj(new String[]{}, new int[]{1251, 1252, 1253}, new String[]{}, new int[]{2251, 2252, 2253}));
		((Map) hostInfo.get("운영").get("온클")).put("oc26",  new Obj(new String[]{}, new int[]{1261, 1262, 1263}, new String[]{}, new int[]{2261, 2262, 2263}));
		((Map) hostInfo.get("운영").get("온클")).put("oc27",  new Obj(new String[]{}, new int[]{1271, 1272, 1273}, new String[]{}, new int[]{2271, 2272, 2273}));
		((Map) hostInfo.get("운영").get("온클")).put("oc28",  new Obj(new String[]{}, new int[]{1281, 1282, 1283}, new String[]{}, new int[]{2281, 2282, 2283}));
		((Map) hostInfo.get("운영").get("온클")).put("oc29",  new Obj(new String[]{}, new int[]{1291, 1292, 1293}, new String[]{}, new int[]{2291, 2292, 2293}));
		((Map) hostInfo.get("운영").get("온클")).put("oc30",  new Obj(new String[]{}, new int[]{1301, 1302, 1303}, new String[]{}, new int[]{2301, 2302, 2303}));
		((Map) hostInfo.get("운영").get("온클")).put("oc31",  new Obj(new String[]{}, new int[]{1311, 1312, 1313}, new String[]{}, new int[]{2311, 2312, 2313}));
		((Map) hostInfo.get("운영").get("온클")).put("oc32",  new Obj(new String[]{}, new int[]{1321, 1322, 1323}, new String[]{}, new int[]{2321, 2322, 2323}));
		((Map) hostInfo.get("운영").get("온클")).put("oc33",  new Obj(new String[]{}, new int[]{1331, 1332, 1333}, new String[]{}, new int[]{2331, 2332, 2333}));
		((Map) hostInfo.get("운영").get("온클")).put("oc34",  new Obj(new String[]{}, new int[]{1341, 1342, 1343}, new String[]{}, new int[]{2341, 2342, 2343}));
		((Map) hostInfo.get("운영").get("온클")).put("oc35",  new Obj(new String[]{}, new int[]{1351, 1352, 1353}, new String[]{}, new int[]{2351, 2352, 2353}));
		((Map) hostInfo.get("운영").get("온클")).put("oc36",  new Obj(new String[]{}, new int[]{1361, 1362, 1363}, new String[]{}, new int[]{2361, 2362, 2363}));
		((Map) hostInfo.get("운영").get("온클")).put("oc37",  new Obj(new String[]{}, new int[]{1371, 1372, 1373}, new String[]{}, new int[]{2371, 2372, 2373}));
		((Map) hostInfo.get("운영").get("온클")).put("oc38",  new Obj(new String[]{}, new int[]{1381, 1382, 1383}, new String[]{}, new int[]{2381, 2382, 2383}));
		((Map) hostInfo.get("운영").get("온클")).put("oc39",  new Obj(new String[]{}, new int[]{1391, 1392, 1393}, new String[]{}, new int[]{2391, 2392, 2393}));
		((Map) hostInfo.get("운영").get("온클")).put("oc40",  new Obj(new String[]{}, new int[]{1401, 1402, 1403}, new String[]{}, new int[]{2401, 2402, 2403}));
		((Map) hostInfo.get("운영").get("온클")).put("oc41",  new Obj(new String[]{}, new int[]{1411, 1412, 1413}, new String[]{}, new int[]{2411, 2412, 2413}));
		((Map) hostInfo.get("운영").get("온클")).put("oc42",  new Obj(new String[]{}, new int[]{1421, 1422, 1423}, new String[]{}, new int[]{2421, 2422, 2423}));
		((Map) hostInfo.get("운영").get("온클")).put("oc43",  new Obj(new String[]{}, new int[]{1431, 1432, 1433}, new String[]{}, new int[]{2431, 2432, 2433}));
		((Map) hostInfo.get("운영").get("온클")).put("oc44",  new Obj(new String[]{}, new int[]{1441, 1442, 1443}, new String[]{}, new int[]{2441, 2442, 2443}));
		((Map) hostInfo.get("운영").get("온클")).put("oc45",  new Obj(new String[]{}, new int[]{1451, 1452, 1453}, new String[]{}, new int[]{2451, 2452, 2453}));
		((Map) hostInfo.get("운영").get("온클")).put("oc46",  new Obj(new String[]{}, new int[]{1461, 1462, 1463}, new String[]{}, new int[]{2461, 2462, 2463}));
		((Map) hostInfo.get("운영").get("온클")).put("oc47",  new Obj(new String[]{}, new int[]{1471, 1472, 1473}, new String[]{}, new int[]{2471, 2472, 2473}));
		((Map) hostInfo.get("운영").get("온클")).put("oc48",  new Obj(new String[]{}, new int[]{1481, 1482, 1483}, new String[]{}, new int[]{2481, 2482, 2483}));
		((Map) hostInfo.get("운영").get("온클")).put("oc49",  new Obj(new String[]{}, new int[]{1491, 1492, 1493}, new String[]{}, new int[]{2491, 2492, 2493}));
		((Map) hostInfo.get("운영").get("온클")).put("oc50",  new Obj(new String[]{}, new int[]{1501, 1502, 1503}, new String[]{}, new int[]{2501, 2502, 2503}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc1",  new Obj(new String[]{}, new int[]{3011, 3012, 3013}, new String[]{}, new int[]{4011, 4012, 4013}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc2",  new Obj(new String[]{}, new int[]{3021, 3022, 3023}, new String[]{}, new int[]{4021, 4022, 4023}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc3",  new Obj(new String[]{}, new int[]{3031, 3032, 3033}, new String[]{}, new int[]{4031, 4032, 4033}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc4",  new Obj(new String[]{}, new int[]{3041, 3042, 3043}, new String[]{}, new int[]{4041, 4042, 4043}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc5",  new Obj(new String[]{}, new int[]{3051, 3052, 3053}, new String[]{}, new int[]{4051, 4052, 4053}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc6",  new Obj(new String[]{}, new int[]{3061, 3062, 3063}, new String[]{}, new int[]{4061, 4062, 4063}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc7",  new Obj(new String[]{}, new int[]{3071, 3072, 3073}, new String[]{}, new int[]{4071, 4072, 4073}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc8",  new Obj(new String[]{}, new int[]{3081, 3082, 3083}, new String[]{}, new int[]{4081, 4082, 4083}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc9",  new Obj(new String[]{}, new int[]{3091, 3092, 3093}, new String[]{}, new int[]{4091, 4092, 4093}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc10", new Obj(new String[]{}, new int[]{3101, 3102, 3103}, new String[]{}, new int[]{4101, 4102, 4103}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc11", new Obj(new String[]{}, new int[]{3111, 3112, 3113}, new String[]{}, new int[]{4111, 4112, 4113}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc12", new Obj(new String[]{}, new int[]{3121, 3122, 3123}, new String[]{}, new int[]{4121, 4122, 4123}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc13", new Obj(new String[]{}, new int[]{3131, 3132, 3133}, new String[]{}, new int[]{4131, 4132, 4133}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc14", new Obj(new String[]{}, new int[]{3141, 3142, 3143}, new String[]{}, new int[]{4141, 4142, 4143}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc15", new Obj(new String[]{}, new int[]{3151, 3152, 3153}, new String[]{}, new int[]{4151, 4152, 4153}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc16", new Obj(new String[]{}, new int[]{3161, 3162, 3163}, new String[]{}, new int[]{4161, 4162, 4163}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc17", new Obj(new String[]{}, new int[]{3171, 3172, 3173}, new String[]{}, new int[]{4171, 4172, 4173}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc18", new Obj(new String[]{}, new int[]{3181, 3182, 3183}, new String[]{}, new int[]{4181, 4182, 4183}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc19", new Obj(new String[]{}, new int[]{3191, 3192, 3193}, new String[]{}, new int[]{4191, 4192, 4193}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc20", new Obj(new String[]{}, new int[]{3201, 3202, 3203}, new String[]{}, new int[]{4201, 4202, 4203}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc21", new Obj(new String[]{}, new int[]{3211, 3212, 3213}, new String[]{}, new int[]{4211, 4212, 4213}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc22", new Obj(new String[]{}, new int[]{3221, 3222, 3223}, new String[]{}, new int[]{4221, 4222, 4223}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc23", new Obj(new String[]{}, new int[]{3231, 3232, 3233}, new String[]{}, new int[]{4231, 4232, 4233}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc24", new Obj(new String[]{}, new int[]{3241, 3242, 3243}, new String[]{}, new int[]{4241, 4242, 4243}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc25", new Obj(new String[]{}, new int[]{3251, 3252, 3253}, new String[]{}, new int[]{4251, 4252, 4253}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc26", new Obj(new String[]{}, new int[]{3261, 3262, 3263}, new String[]{}, new int[]{4261, 4262, 4263}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc27", new Obj(new String[]{}, new int[]{3271, 3272, 3273}, new String[]{}, new int[]{4271, 4272, 4273}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc28", new Obj(new String[]{}, new int[]{3281, 3282, 3283}, new String[]{}, new int[]{4281, 4282, 4283}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc29", new Obj(new String[]{}, new int[]{3291, 3292, 3293}, new String[]{}, new int[]{4291, 4292, 4293}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc30", new Obj(new String[]{}, new int[]{3301, 3302, 3303}, new String[]{}, new int[]{4301, 4302, 4303}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc31", new Obj(new String[]{}, new int[]{3311, 3312, 3313}, new String[]{}, new int[]{4311, 4312, 4313}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc32", new Obj(new String[]{}, new int[]{3321, 3322, 3323}, new String[]{}, new int[]{4321, 4322, 4323}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc33", new Obj(new String[]{}, new int[]{3331, 3332, 3333}, new String[]{}, new int[]{4331, 4332, 4333}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc34", new Obj(new String[]{}, new int[]{3341, 3342, 3343}, new String[]{}, new int[]{4341, 4342, 4343}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc35", new Obj(new String[]{}, new int[]{3351, 3352, 3353}, new String[]{}, new int[]{4351, 4352, 4353}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc36", new Obj(new String[]{}, new int[]{3361, 3362, 3363}, new String[]{}, new int[]{4361, 4362, 4363}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc37", new Obj(new String[]{}, new int[]{3371, 3372, 3373}, new String[]{}, new int[]{4371, 4372, 4373}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc38", new Obj(new String[]{}, new int[]{3381, 3382, 3383}, new String[]{}, new int[]{4381, 4382, 4383}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc39", new Obj(new String[]{}, new int[]{3391, 3392, 3393}, new String[]{}, new int[]{4391, 4392, 4393}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc40", new Obj(new String[]{}, new int[]{3401, 3402, 3403}, new String[]{}, new int[]{4401, 4402, 4403}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc41", new Obj(new String[]{}, new int[]{3411, 3412, 3413}, new String[]{}, new int[]{4411, 4412, 4413}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc42", new Obj(new String[]{}, new int[]{3421, 3422, 3423}, new String[]{}, new int[]{4421, 4422, 4423}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc43", new Obj(new String[]{}, new int[]{3431, 3432, 3433}, new String[]{}, new int[]{4431, 4432, 4433}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc44", new Obj(new String[]{}, new int[]{3441, 3442, 3443}, new String[]{}, new int[]{4441, 4442, 4443}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc45", new Obj(new String[]{}, new int[]{3451, 3452, 3453}, new String[]{}, new int[]{4451, 4452, 4453}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc46", new Obj(new String[]{}, new int[]{3461, 3462, 3463}, new String[]{}, new int[]{4461, 4462, 4463}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc47", new Obj(new String[]{}, new int[]{3471, 3472, 3473}, new String[]{}, new int[]{4471, 4472, 4473}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc48", new Obj(new String[]{}, new int[]{3481, 3482, 3483}, new String[]{}, new int[]{4481, 4482, 4483}));
		((Map) hostInfo.get("운영").get("온클")).put("hoc49", new Obj(new String[]{}, new int[]{3491, 3492, 3493}, new String[]{}, new int[]{4491, 4492, 4493}));
		
	}
	
	@Override
	public void onEvent(String type, CompObj obj, Object...objects) throws Exception {

		String threadName = "EBSService";
		runThread(threadName, false);
		
		SSH ssh = new SSH("localhost", "ebsesof", "Ebsesof!@#$!@#$", 222);
		FTP ftp = new FTP("localhost", "ebsesof", "Ebsesof!@#$!@#$", 6258);
		
		if(type.equals("change") && "area".equals(obj.getEvtName())){
			
		}else if(type.equals("click") && "was1".equals(obj.getEvtName())){
			String result = ssh.execContinue("whoami");
		}else if(type.equals("click") && "was2".equals(obj.getEvtName())){
			String result = ssh.execContinue("who am i");
		}else if(type.equals("click") && "was3".equals(obj.getEvtName())){
			String result = ftp.execContinue("who am i");
		}

	}
	
	public void showParkingPop(){
		
	}

	@Override
	public CustomThread createThread(){
		return new CustomThread(){
			@Override
			public void run() {

			}
		};
	}
	
	public class Obj{
		private String ipa[];
		private int porta[];
		
		private String ipe[];
		private int porte[];

		public Obj(String[] ipa, int[] porta){
			this.ipa = ipa;
			this.porta = porta;
		}
		
		public Obj(String[] ipa, int[] porta, String[] ipe, int[] porte){
			this.ipa = ipa;
			this.porta = porta;
			this.ipe = ipe;
			this.porte = porte;
		}
		
		public String getIPa(int index){
			return ipa[index];
		}
		
		public int getPorta(int index){
			return porta[index];
		}

		public String[] getIpa() {
			return ipa;
		}

		public int[] getPorta() {
			return porta;
		}
		
		public String getIPe(int index){
			return ipe[index];
		}
		
		public int getPorte(int index){
			return porte[index];
		}
		
		public String[] getIpe() {
			return ipe;
		}
		
		public int[] getPorte() {
			return porte;
		}
		
	}
}
