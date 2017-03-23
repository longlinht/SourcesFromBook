package org.crazyit.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Description:
 * <br/>site: <a href="http://www.crazyit.org">crazyit.org</a> 
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class HttpClientTest extends Activity
{
	Button get;
	Button login;
	EditText response;
	HttpClient httpClient;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// ����DefaultHttpClient����
		httpClient = new DefaultHttpClient();
		get = (Button) findViewById(R.id.get);
		login = (Button) findViewById(R.id.login);
		response = (EditText) findViewById(R.id.response);
		get.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// ����һ��HttpGet����
				HttpGet get = new HttpGet(
					"http://192.168.2.20:8080/foo/secret.jsp");
				try
				{
					// ����GET����
					HttpResponse httpResponse = httpClient.execute(get);
					HttpEntity entity = httpResponse.getEntity();
					if (entity != null)
					{
						// ��ȡ��������Ӧ
						BufferedReader br = new BufferedReader(
							new InputStreamReader(entity.getContent()));
						String line = null;
						response.setText("");
						while ((line = br.readLine()) != null)
						{
							// ʹ��response�ı�����ʾ��������Ӧ
							response.append(line + "\n");
						}
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		login.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				final View loginDialog = getLayoutInflater().inflate(
					R.layout.login, null);
				new AlertDialog.Builder(HttpClientTest.this)
					.setTitle("��¼ϵͳ")
					.setView(loginDialog)
					.setPositiveButton("��¼",
						new DialogInterface.OnClickListener()
						{
							@Override
							public void onClick(DialogInterface dialog,
								int which)
							{
								String name = ((EditText) loginDialog
									.findViewById(R.id.name)).getText()
									.toString();
								String pass = ((EditText) loginDialog
									.findViewById(R.id.pass)).getText()
									.toString();
								HttpPost post = new HttpPost(
									"http://192.168.2.20:8080/foo/login.jsp");
								// ������ݲ��������Ƚ϶�Ļ����ԶԴ��ݵĲ������з�װ
								List<NameValuePair> params = new ArrayList<NameValuePair>();
								params
									.add(new BasicNameValuePair("name", name));
								params
									.add(new BasicNameValuePair("pass", pass));
								try
								{
									// �����������
									post.setEntity(new UrlEncodedFormEntity(
										params, HTTP.UTF_8));
									// ����POST����
									HttpResponse response = httpClient
										.execute(post);
									// ����������ɹ��ط�����Ӧ
									if (response.getStatusLine()
										.getStatusCode() == 200)
									{
										String msg = EntityUtils
											.toString(response.getEntity());
										// ��ʾ��¼�ɹ�
										Toast.makeText(HttpClientTest.this,
											msg, 5000).show();
									}
								}
								catch (Exception e)
								{
									e.printStackTrace();
								}
							}
						}).setNegativeButton("ȡ��", null).show();
			}
		});
	}
}