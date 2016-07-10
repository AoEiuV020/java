/* ***************************************************
	^> File Name: SSLSocketFactoryTest.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/07/02 - 20:42:12
*************************************************** */
package cc.aoeiuv020.javax.net.ssl;
import javax.net.ssl.*;
import java.io.*;
import java.util.*;
public class SSLSocketFactoryTest
{
	public static void main(String[] args)
	{
		SSLSocketFactory sslsf=(SSLSocketFactory)SSLSocketFactory.getDefault();
		output(sslsf.getDefaultCipherSuites());
		output(sslsf.getSupportedCipherSuites());
	}
	public static void output(String[] arr)
	{
		System.out.println("--- "+arr+" ---");
		for(String s:arr)
		{
			System.out.println(s);
		}
	}
}
