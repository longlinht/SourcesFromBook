/**
 * 
 */
package org.crazyit.map;

import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a> 
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class ConvertUtil
{
	// ���ݵ�ַ��ȡ��Ӧ�ľ�γ��
	public static double[] getLocationInfo(String address)
	{
		// ����һ��HttpClient��������ָ����ַ��������
		HttpClient client = new DefaultHttpClient();
		// ��ָ����ַ����GET����
		HttpGet httpGet = new HttpGet("http://maps.google."
			+ "com/maps/api/geocode/json?address=" + address
			+ "ka&sensor=false");
		StringBuilder sb = new StringBuilder();
		try
		{
			// ��ȡ����������Ӧ
			HttpResponse response = client.execute(httpGet);
			HttpEntity entity = response.getEntity();
			// ��ȡ��������Ӧ��������
			InputStream stream = entity.getContent();
			int b;
			// ѭ����ȡ��������Ӧ
			while ((b = stream.read()) != -1)
			{
				sb.append((char) b);
			}
			// �����������ص��ַ���ת��ΪJSONObject����
			JSONObject jsonObject = new JSONObject(sb.toString());
			// ��JSONObject������ȡ������λ�õ�location����
			JSONObject location = jsonObject.getJSONArray("results")
				.getJSONObject(0)   
				.getJSONObject("geometry").getJSONObject("location");
			// ��ȡ������Ϣ
			double longitude = location.getDouble("lng");
			// ��ȡγ����Ϣ
			double latitude = location.getDouble("lat");
			// �����ȡ�γ����Ϣ���double[]����
			return new double[]{longitude , latitude};			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	} 
	// ���ݾ�γ�Ȼ�ȡ��Ӧ�ĵ�ַ
	public static String getAddress(double longitude
		, double latitude)
	{
		// ����һ��HttpClient��������ָ����ַ��������
		HttpClient client = new DefaultHttpClient();
		// ��ָ����ַ����GET����
		HttpGet httpGet = new HttpGet("http://maps.google.com/maps/api/"
			+ "geocode/json?latlng="
			+ latitude + "," + longitude 
			+ "&sensor=false&region=cn");
		StringBuilder sb = new StringBuilder();
		try
		{
			// ִ������
			HttpResponse response = client.execute(httpGet);
			HttpEntity entity = response.getEntity();
			// ��ȡ��������Ӧ���ַ���
			InputStream stream = entity.getContent();
			int b;
			while ((b = stream.read()) != -1)
			{
				sb.append((char) b);
			}
			// �ѷ�������Ӧ���ַ���ת��ΪJSONObject
			JSONObject jsonObj = new JSONObject(sb.toString());
			// ��������Ӧ����еĵ�ַ����
			return jsonObj.getJSONArray("results").getJSONObject(0)
				.getString("formatted_address");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}  	
}
