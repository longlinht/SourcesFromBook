package org.crazyit.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

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
public class Lifecycle extends Activity
{
	final String TAG = "--CrazyIt--";
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//�����־
		Log.d(TAG , "-------onCreate------");		
		Button bn = (Button)findViewById(R.id.bn);
		//Ϊbn��ť���¼�������
		bn.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				//������Activity
				Lifecycle.this.finish();
			}			
		});
	}
	@Override
	public void onStart() 
	{
		super.onStart();
		//�����־
		Log.d(TAG , "-------onStart------");
	}
	@Override
	public void onRestart() 
	{
		super.onRestart();
		//�����־
		Log.d(TAG , "-------onRestart------");		
	}
	@Override
	public void onResume() 
	{
		super.onResume();
		//�����־
		Log.d(TAG , "-------onResume------");		
	}
	@Override
	public void onPause() 
	{
		super.onPause();
		//�����־
		Log.d(TAG , "-------onPause------");		
	}
	@Override
	public void onStop() 
	{
		super.onStop();
		//�����־
		Log.d(TAG , "-------onStop------");		
	}
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		//�����־
		Log.d(TAG , "-------onDestroy------");		
	}
}