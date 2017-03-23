package org.crazyit.sensor;

import org.openintents.sensorsimulator.hardware.SensorManagerSimulator;
import org.openintents.sensorsimulator.hardware.Sensor;
import org.openintents.sensorsimulator.hardware.SensorEvent;
import org.openintents.sensorsimulator.hardware.SensorEventListener;

import android.app.Activity;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;

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
public class AccelSimulatorTest extends Activity
	implements SensorEventListener
{
	// ����ģ������Sensor������
	private SensorManagerSimulator mSensorManager;
	// ��������ϵ��ı������
	EditText etTxt1;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// ��ȡ���������ı������
		etTxt1 = (EditText) findViewById(R.id.txt1);
		// ��ȡ������ģ�����Ĵ������������
		mSensorManager = SensorManagerSimulator.getSystemService(
			this, SENSOR_SERVICE);
		// ���Ӵ�����ģ����
		mSensorManager.connectSimulator();
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		// Ϊϵͳ�ļ��ٶȴ�����ע�������
		mSensorManager.registerListener(this,
			mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
			SensorManager.SENSOR_DELAY_GAME);
	}

	@Override
	protected void onStop()
	{
		// ȡ��ע��
		mSensorManager.unregisterListener(this);
		super.onStop();
	}

	// ������ʵ��SensorEventListener�ӿڱ���ʵ�ֵķ���
	// ����������ֵ�����ı�ʱ�ص��÷���
	@Override
	public void onSensorChanged(SensorEvent event)
	{
		float[] values = event.values;
		StringBuilder sb = new StringBuilder();
		sb.append("X�����ϵļ��ٶȣ�");
		sb.append(values[0]);
		sb.append("\nY�����ϵļ��ٶȣ�");
		sb.append(values[1]);
		sb.append("\nZ�����ϵļ��ٶȣ�");
		sb.append(values[2]);
		etTxt1.setText(sb.toString());
	}

	@Override
	// �����������ȸı�ʱ�ص��÷�����
	public void onAccuracyChanged(Sensor sensor, int accuracy)
	{
	}
}