package org.crazyit.gallery;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Gallery.LayoutParams;
import android.widget.ViewSwitcher.ViewFactory;

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
public class GallaryTest extends Activity
{
	int[] imageIds = new int[]
	{
		R.drawable.shuangzi, R.drawable.shuangyu,
		R.drawable.chunv, R.drawable.tiancheng, R.drawable.tianxie,
		R.drawable.sheshou, R.drawable.juxie, R.drawable.shuiping,
		R.drawable.shizi, R.drawable.baiyang, R.drawable.jinniu,
		R.drawable.mojie };

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final Gallery gallery = (Gallery) findViewById(R.id.gallery);
		// ��ȡ��ʾͼƬ��ImageSwitcher����
		final ImageSwitcher switcher = (ImageSwitcher) 
			findViewById(R.id.switcher);
		// ΪImageSwitcher��������ViewFactory����
		switcher.setFactory(new ViewFactory()
		{
			@Override
			public View makeView()
			{
				ImageView imageView = new ImageView(GallaryTest.this);
				imageView.setBackgroundColor(0xff0000);
				imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
				imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
				return imageView;
			}
		});
		// ����ͼƬ�����Ķ���Ч��
		switcher.setInAnimation(AnimationUtils.loadAnimation(this,
			android.R.anim.fade_in));
		switcher.setOutAnimation(AnimationUtils.loadAnimation(this,
			android.R.anim.fade_out));
		// ����һ��BaseAdapter���󣬸ö������ṩGallery����ʾ��ͼƬ
		BaseAdapter adapter = new BaseAdapter()
		{
			@Override
			public int getCount()
			{
				return imageIds.length;
			}
			@Override
			public Object getItem(int position)
			{
				return position;
			}
			@Override
			public long getItemId(int position)
			{
				return position;
			}

			// �÷����ķ��ص�View���Ǵ�����ÿ���б���
			@Override
			public View getView(int position, View convertView, ViewGroup parent)
			{
				// ����һ��ImageView
				ImageView imageView = new ImageView(GallaryTest.this);
				imageView
					.setImageResource(imageIds[position % imageIds.length]);
				// ����ImageView����������
				imageView.setScaleType(ImageView.ScaleType.FIT_XY);
				imageView.setLayoutParams(new Gallery.LayoutParams(75, 100));
				TypedArray typedArray = obtainStyledAttributes(
					R.styleable.Gallery);
				imageView.setBackgroundResource(typedArray.getResourceId(
					R.styleable.Gallery_android_galleryItemBackground, 0));
				return imageView;
			}
		};
		gallery.setAdapter(adapter);
		gallery.setOnItemSelectedListener(new OnItemSelectedListener()
		{
			// ��Galleryѡ������ı�ʱ�����÷���
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id)
			{
				switcher.setImageResource(imageIds[position % imageIds.length]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent)
			{
			}
		});
	}
}