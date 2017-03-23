package org.crazyit.seekbar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

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
public class SeekBarTest extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final ImageView image = (ImageView)findViewById(R.id.image);
		SeekBar seekBar = (SeekBar)findViewById(R.id.seekbar);
		
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener()
		{
			//���϶����Ļ���λ�÷����ı�ʱ�����÷���
			@Override
			public void onProgressChanged(SeekBar arg0
				, int progress, boolean fromUser)
			{
				//��̬�ı�ͼƬ��͸����
				image.setAlpha(progress);
				
			}
			@Override
			public void onStartTrackingTouch(SeekBar bar){}
			@Override
			public void onStopTrackingTouch(SeekBar bar){}
		});
	}
}