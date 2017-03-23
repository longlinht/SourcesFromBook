package org.crazyit.desktop;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.view.MotionEvent;
import android.view.SurfaceHolder;


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
public class LiveWallpaper extends WallpaperService
{
	// ʵ��WallpaperService����ʵ�ֵĳ��󷽷�
	@Override
	public Engine onCreateEngine()
	{
		// �����Զ����Engine
		return new MyEngine();
	}

	class MyEngine extends Engine
	{
		// ��¼��������Ƿ�ɼ�
		private boolean mVisible;
		// ��¼��ǰ��ǰ�û������¼��ķ���λ��
		private float mTouchX = -1;
		private float mTouchY = -1;
		// ��¼��ǰԲȦ�Ļ���λ��
		private float cx = 15;
		private float cy = 20;
		// ���廭��
		private Paint mPaint = new Paint();
		// ����һ��Handler
		Handler mHandler = new Handler();
		// ����һ��������ִ�е�����
		private final Runnable drawTarget = new Runnable()
		{
			public void run()
			{
				drawFrame();
			}
		};

		@Override
		public void onCreate(SurfaceHolder surfaceHolder)
		{
			super.onCreate(surfaceHolder);
			// ��ʼ������
			mPaint.setColor(0xffffffff);
			mPaint.setAntiAlias(true);
			mPaint.setStrokeWidth(2);
			mPaint.setStrokeCap(Paint.Cap.ROUND);
			mPaint.setStyle(Paint.Style.STROKE);
			// ���ô������¼�
			setTouchEventsEnabled(true);
		}

		@Override
		public void onDestroy()
		{
			super.onDestroy();
			// ɾ���ص�
			mHandler.removeCallbacks(drawTarget);
		}

		@Override
		public void onVisibilityChanged(boolean visible)
		{
			mVisible = visible;
			// ������ɼ�ʱ��ִ��drawFrame()������
			if (visible)
			{
				// ��̬�ػ���ͼ��
				drawFrame();
			}
			else
			{
				// ������治�ɼ���ɾ���ص�
				mHandler.removeCallbacks(drawTarget);
			}
		}

		@Override
		public void onOffsetsChanged(float xOffset, float yOffset, float xStep,
			float yStep, int xPixels, int yPixels)
		{
			drawFrame();
		}

		// // ����Ļ��С�ı�ʱ����ø÷���
		// @Override
		// public void onSurfaceChanged(SurfaceHolder holder, int format,
		// int width, int height)
		// {
		// super.onSurfaceChanged(holder, format, width, height);
		// drawFrame();
		// }
		//
		// @Override
		// public void onSurfaceCreated(SurfaceHolder holder)
		// {
		// super.onSurfaceCreated(holder);
		// }
		//
		// @Override
		// public void onSurfaceDestroyed(SurfaceHolder holder)
		// {
		// super.onSurfaceDestroyed(holder);
		// mVisible = false;
		// mHandler.removeCallbacks(drawTarget);
		// }

		@Override
		public void onTouchEvent(MotionEvent event)
		{
			// �����⵽��������
			if (event.getAction() == MotionEvent.ACTION_MOVE)
			{
				mTouchX = event.getX();
				mTouchY = event.getY();
			}
			else
			{
				mTouchX = -1;
				mTouchY = -1;
			}
			super.onTouchEvent(event);
		}

		// �������ͼ�εĹ��߷���
		private void drawFrame()
		{
			// ��ȡ�ñ�ֽ��SurfaceHolder
			final SurfaceHolder holder = getSurfaceHolder();
			Canvas c = null;
			try
			{
				// �Ի�������
				c = holder.lockCanvas();
				if (c != null)
				{
					c.save();
					// ���Ʊ���ɫ
					c.drawColor(0xff000000);
					// �ڴ��������ԲȦ
					drawTouchPoint(c);
					// ����ԲȦ
					c.drawCircle(cx, cy, 80, mPaint);
					c.restore();
				}
			}
			finally
			{
				if (c != null)
					holder.unlockCanvasAndPost(c);
			}
			mHandler.removeCallbacks(drawTarget);
			// ������һ���ػ�
			if (mVisible)
			{
				cx += 15;
				cy += 20;
				// ���cx��cy�Ƴ���Ļ������Ͻ����¿�ʼ
				if (cx > 320)
					cx = 15;
				if (cy > 400)
					cy = 20;
				// ָ��0.1�������ִ��mDrawCubeһ��
				mHandler.postDelayed(drawTarget, 100);
			}
		}

		// ����Ļ���������ԲȦ
		private void drawTouchPoint(Canvas c)
		{
			if (mTouchX >= 0 && mTouchY >= 0)
			{
				c.drawCircle(mTouchX, mTouchY, 40, mPaint);
			}
		}
	}
}