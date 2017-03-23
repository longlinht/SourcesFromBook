package org.crazyit.sound;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Bundle;
import android.os.Environment;
import android.view.Display;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
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
public class CaptureImage extends Activity
{
	SurfaceView sView;
	SurfaceHolder surfaceHolder;
	int screenWidth, screenHeight;
	// ����ϵͳ���õ������
	Camera camera;
	//�Ƿ��������
	boolean isPreview = false;
    @Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		// ����ȫ��
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
			WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.main);
		WindowManager wm = (WindowManager) getSystemService(
			Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		// ��ȡ��Ļ�Ŀ�͸�
		screenWidth = display.getWidth();
		screenHeight = display.getHeight();
		// ��ȡ������SurfaceView���
		sView = (SurfaceView) findViewById(R.id.sView);
		// ���SurfaceView��SurfaceHolder
		surfaceHolder = sView.getHolder();
		// ΪsurfaceHolder���һ���ص�������
		surfaceHolder.addCallback(new Callback()
		{
			@Override
			public void surfaceChanged(SurfaceHolder holder, int format, int width,
				int height)
			{
			}
			@Override
			public void surfaceCreated(SurfaceHolder holder)
			{
				// ������ͷ
				initCamera();
			}
			@Override
			public void surfaceDestroyed(SurfaceHolder holder)
			{
				// ���camera��Ϊnull ,�ͷ�����ͷ
				if (camera != null)
				{
					if (isPreview)
						camera.stopPreview();
					camera.release();
					camera = null;
				}
			}		
		});
		// ���ø�SurfaceView�Լ���ά������    
		surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}

	private void initCamera()
	{
		if (!isPreview)
		{
			camera = Camera.open();
		}
		if (camera != null && !isPreview)
		{
			try
			{
				Camera.Parameters parameters = camera.getParameters();
				// ����Ԥ����Ƭ�Ĵ�С
				parameters.setPreviewSize(screenWidth, screenHeight);
				// ÿ����ʾ4֡
				parameters.setPreviewFrameRate(4);
				// ����ͼƬ��ʽ
				parameters.setPictureFormat(PixelFormat.JPEG);
				// ����JPG��Ƭ������
				parameters.set("jpeg-quality", 85);
				//������Ƭ�Ĵ�С
				parameters.setPictureSize(screenWidth, screenHeight);
				camera.setParameters(parameters);
				//ͨ��SurfaceView��ʾȡ������
				camera.setPreviewDisplay(surfaceHolder);
				// ��ʼԤ��
				camera.startPreview();
				// �Զ��Խ�
				camera.autoFocus(null);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			isPreview = true;
		}
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		switch (keyCode)
		{
			// ���û�����������������ʱִ������
			case KeyEvent.KEYCODE_DPAD_CENTER:
			case KeyEvent.KEYCODE_CAMERA:
				if (camera != null && event.getRepeatCount() == 0)
				{
					// ����
					camera.takePicture(null, null , myjpegCallback);
					return true;
				}
				break;
		}		
		return super.onKeyDown(keyCode, event);
	}
	
	PictureCallback myjpegCallback = new PictureCallback()
	{
		@Override
		public void onPictureTaken(byte[] data, Camera camera)
		{
			// �����������õ����ݴ���λͼ
			final Bitmap bm = BitmapFactory.decodeByteArray(data
				, 0, data.length);
			// ����/layout/save.xml�ļ���Ӧ�Ĳ�����Դ
			View saveDialog = getLayoutInflater().inflate(
				R.layout.save, null);
			final EditText photoName = (EditText) saveDialog
				.findViewById(R.id.phone_name);
			// ��ȡsaveDialog�Ի����ϵ�ImageView���
			ImageView show = (ImageView) saveDialog.findViewById(R.id.show);
			// ��ʾ�ո��ĵõ���Ƭ
			show.setImageBitmap(bm);
			//ʹ�öԻ�����ʾsaveDialog���
			new AlertDialog.Builder(CaptureImage.this)
				.setView(saveDialog)
				.setPositiveButton("����", new OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog,
						int which)
					{
						// ����һ��λ��SD���ϵ��ļ�
						File file = new File(Environment.getExternalStorageDirectory()
							,  photoName.getText().toString() + ".jpg");
						FileOutputStream outStream = null;
						try
						{
							// ��ָ���ļ���Ӧ�������
							outStream = new FileOutputStream(file);
							// ��λͼ�����ָ���ļ���
							bm.compress(CompressFormat.JPEG, 100, outStream);
							outStream.close();
						}
						catch (IOException e)
						{
							e.printStackTrace();
						}
					}
				})
				.setNegativeButton("ȡ��", null)
				.show();
			//�������
			camera.stopPreview();
			camera.startPreview();
			isPreview = true;
		}
	};
}

