package qianyan.mofi.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class PageUtil {
	//参数过滤
	public static final String PREFIX = "filter_";
	public static final String SEPARATOR = "_";
	
	//条件类型
	public static final String AND = "AND";
//	public static String OR = "OR";
	public static final String LIKE = "LIKE";
//	public static final String IN = "IN";
//	public static final String MEMBER = "MEMBER";
	
	//运算符
	public static final String EQ = "EQ";
	public static final String GE = "GE";
	public static final String LE = "LE";
	
	//数据类型
	public static final String L = "L";
	public static final String S = "S";
	public static final String I = "I";
	public static final String D = "D";
	public static final String F = "F";
	
	/**
	 * @param request 
	 * */
	public static String parseToWhereCondition(HttpServletRequest request){
		String result = "";
		Map<String, String[]> params = request.getParameterMap();
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			if(name.startsWith(PREFIX)){
				String[] all = name.split("_");
				String paramName = all[2];
				String symbolStr = null==all[1].substring(0, all[1].length()-1)?"":all[1].substring(0, all[1].length()-1);
				String value = null == params.get(name)[0]?"":params.get(name)[0];
				if(paramName.length()<=0||symbolStr.length()<=0||value.length()<=0){
					continue;
				}
				if(name.startsWith(PREFIX)){
					result += condition(paramName, symbolStr, value);
				}else{
					continue;
				}
			}else{
				continue;
			}
		}
		
		return result;
	}

	private static String condition(String name, String symbolStr, String value){
		Map<String, String> map = new HashMap<String, String>();
		map.put(EQ, "=");
		map.put(GE, ">=");
		map.put(LE, "<=");
		map.put(LIKE, " LIKE ");
		String symbol = map.get(symbolStr);
		if(LIKE.equals(symbol.trim())){
			return " "+AND+" "+name+symbol+"'%"+value+"%'";
		}else{
			return " "+AND+" "+name+symbol+"'"+value+"'";
		}
	}
	
}
