import java.net.*;
import java.io.*;
import java.util.*;

/**
 * @author  yeeku.H.lee kongyeeku@163.com
 * @version  1.0
 * <br>Copyright (C), 2005-2008, yeeku.H.Lee
 * <br>This program is protected by copyright laws.
 * <br>Program Name:
 * <br>Date: 
 */
public class MyServer
{
	//���屣������Socket��ArrayList
	public static ArrayList<Socket> socketList 
		= new ArrayList<Socket>();
    public static void main(String[] args) 
		throws IOException
    {
        ServerSocket ss = new ServerSocket(30000);
		while(true)
		{
			//���д������������һֱ�ȴ����˵�����
			Socket s = ss.accept();
			socketList.add(s);
			//ÿ���ͻ������Ӻ�����һ��ServerThread�߳�Ϊ�ÿͻ��˷���
			new Thread(new ServerThread(s)).start();
		}
    }
}