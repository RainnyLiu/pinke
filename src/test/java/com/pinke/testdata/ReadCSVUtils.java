package com.pinke.testdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVUtils {
	public static void main(String[] args) {
		Object[][] o = getPlainCSVData("calcTestData.csv");
		for(int i = 0; i < o.length; i++) {
			for(int j=0; j < o[i].length; j++) {
				System.out.println(o[i][j]+"\t");
			}
			System.out.println();
		}
		
	}
	public static Object[][] getPlainCSVData(String filename){
		Object[][] objs = null;
		InputStream is = ReadCSVUtils.class.getClassLoader().getResourceAsStream(filename); // is是字节流
		BufferedReader br = new BufferedReader(new InputStreamReader(is)); 
		// BufferedReader参数里放的是字符流，先把字节流转换成字符流INputStreamReader，然后再转换成带有缓存的字符流，然后就可以readline了，即下面的br.readline。
		String line = null;
		try {
			line = br.readLine(); //先读掉第一行，是标题, readline读出来一行值，（CSV中间不能有空行，否则是非法的）
			List<Object[]> list = new ArrayList<Object[]>(); //用list容器放读出来的数组，因为数组不知道有多少行
			while((line = br.readLine()) != null) {//只要不为空，就往下读一次
				list.add(parseData(line.split(",")));	// 用逗号，分割出来之后就是数组，然后放进list	
				//split的结果是一个string类型的数组，而实际csv里是数字，所以后面计算会有问题， 读csv就有这个问题，读出来的全部是字符串
				//所以单独封装了一个parseData方法，将string转成int/double/bollean
			}
			int size = list.size();
			objs = new Object[size][];
			for(int i=0; i<size; i++) {
				objs[i] = list.get(i); // list数组转换成Object
			}
									
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return objs;
	}
	
	private static Object[] parseData(String[] strData) {
		Object[] objs = new Object[strData.length];
		for(int i=0;i<objs.length;i++) {
			try {
				double tmp = Double.parseDouble(strData[i]);
				objs[i] = DataParse.double2int(tmp);
			}catch(NumberFormatException e) {
				if(strData[i].equalsIgnoreCase("true") || strData[i].equalsIgnoreCase("false")){			
					objs[i] = Boolean.parseBoolean(strData[i]);
				}else {
					objs[i] = strData[i];
				}
				
			}
		}
		return objs;
	}
}
