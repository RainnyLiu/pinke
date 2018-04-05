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
		InputStream is = ReadCSVUtils.class.getClassLoader().getResourceAsStream(filename); // is���ֽ���
		BufferedReader br = new BufferedReader(new InputStreamReader(is)); 
		// BufferedReader������ŵ����ַ������Ȱ��ֽ���ת�����ַ���INputStreamReader��Ȼ����ת���ɴ��л�����ַ�����Ȼ��Ϳ���readline�ˣ��������br.readline��
		String line = null;
		try {
			line = br.readLine(); //�ȶ�����һ�У��Ǳ���, readline������һ��ֵ����CSV�м䲻���п��У������ǷǷ��ģ�
			List<Object[]> list = new ArrayList<Object[]>(); //��list�����Ŷ����������飬��Ϊ���鲻֪���ж�����
			while((line = br.readLine()) != null) {//ֻҪ��Ϊ�գ������¶�һ��
				list.add(parseData(line.split(",")));	// �ö��ţ��ָ����֮��������飬Ȼ��Ž�list	
				//split�Ľ����һ��string���͵����飬��ʵ��csv�������֣����Ժ������������⣬ ��csv����������⣬��������ȫ�����ַ���
				//���Ե�����װ��һ��parseData��������stringת��int/double/bollean
			}
			int size = list.size();
			objs = new Object[size][];
			for(int i=0; i<size; i++) {
				objs[i] = list.get(i); // list����ת����Object
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
