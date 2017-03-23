package org.crazyit.net;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

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
public class URLTest extends Activity
{
	ImageView show;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		show = (ImageView) findViewById(R.id.show);
		// ����һ��URL����
		try
		{
			URL url = new URL("http://www.crazyit.org/attachments/"
				+ "month_1008/20100812_7763e970f822325bfb019ELQVym8tW3A.png");
			// �򿪸�URL��Ӧ����Դ��������
			InputStream is = url.openStream();
			// ��InputStream�н�����ͼƬ
			Bitmap bitmap = BitmapFactory.decodeStream(is);
			// ʹ��ImageView��ʾ��ͼƬ
			show.setImageBitmap(bitmap);
			is.close();
			// �ٴδ�URL��Ӧ����Դ��������
			is = url.openStream();
			// ���ֻ��ļ���Ӧ�������
			OutputStream os = openFileOutput("crazyit.png"
				, MODE_WORLD_READABLE);
			byte[] buff = new byte[1024];
			int hasRead = 0;
			// ��URL��Ӧ����Դ���ص�����
			while((hasRead = is.read(buff)) > 0)
			{
				os.write(buff, 0 , hasRead);
			}
			is.close();
			os.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}