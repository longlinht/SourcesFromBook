/**
 * 
 */
package org.crazyit.desktop;


import android.app.Activity;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;

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
public class ShowWordActivity extends Activity
{
	EditText etWord , etDescription;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show);
		// ��ȡ�������
		etWord = (EditText) findViewById(R.id.word);
		etDescription = (EditText) findViewById(R.id.description);
		Uri uri = getIntent().getData();
		// ��ȡ����ID
		long id = ContentUris.parseId(uri);
		// ��ContentProvider��ѯָ������
		Cursor cursor = getContentResolver().query(
			Uri.parse("content://org.crazyit.providers.dictprovider/words")
			, null , "_id=?" , new String[]{id + ""} , null );
		if(cursor.moveToNext())
		{
			// ʹ�ý��������ʾ��ѯ�õ��Ľ��
			etWord.setText(cursor.getString(1));
			etDescription.setText(cursor.getString(2));
		}
	}
}
