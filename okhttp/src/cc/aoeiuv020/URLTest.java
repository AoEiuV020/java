/* ***************************************************
	^> File Name: URLTest.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/07/03 - 03:03:30
*************************************************** */
package cc.aoeiuv020;
import java.io.*;
import java.util.*;
import java.net.*;
public class URLTest
{
	public static String getNoException(String sUrl)
	{
		String result=null;
		try
		{
			result=get(sUrl);
		}
		catch(IOException e)
		{
			result=e.getMessage();
		}
		return result;
	}
	public static String get(String sUrl)throws IOException
	{
		URL url=new URL(sUrl);
		InputStreamReader input=new InputStreamReader(url.openStream());
		char[] buf=new char[1024];
		int len;
		StringBuilder sBuf=new StringBuilder();
		while((len=input.read(buf))>0)
		{
			sBuf.append(buf,0,len);
		}
		return sBuf.toString();
	}
}
