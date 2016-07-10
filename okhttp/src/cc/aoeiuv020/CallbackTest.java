/* ***************************************************
	^> File Name: CallbackTest.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/07/02 - 00:29:07
*************************************************** */
package cc.aoeiuv020;
import okhttp3.*;
import java.io.*;
import java.util.*;
public class CallbackTest
{
	public static void main(String[] args)throws IOException,InterruptedException
	{
		OkHttpClient client=new OkHttpClient.Builder().build();
		String url="http://aoeiuv020.cc/ip.php?a=s&d=f";
		System.out.println(get(client,url));
		Callback callback=new Callback(){
			@Override
			public void onFailure(Call call,IOException e)
			{
				throw new RuntimeException(e);
			}
			@Override
			public void onResponse(Call call,Response response)throws IOException
			{
				output(Thread.currentThread());
				output(response);
				System.out.println(response.body().string());
			}
		};
		get(client,url,callback);
		get(client,url,callback,2);
		Thread.sleep(3000);
	}
	public static String get(OkHttpClient client,String url)throws IOException
	{
		final Thread currentThread=Thread.currentThread();
		output(currentThread);
		final StringBuilder sBuf=new StringBuilder();
		Callback callback=new Callback(){
			@Override
			public void onFailure(Call call,IOException e)
			{
				throw new RuntimeException(e);
			}
			@Override
			public void onResponse(Call call,Response response)throws IOException
			{
				//不是主线程，
				output(Thread.currentThread());
				sBuf.append(response.body().string());
				currentThread.interrupt();
			}
		};
		try
		{
			synchronized(currentThread)
			{
				get(client,url,callback);
				currentThread.wait();
			}
		}
		catch(InterruptedException e)
		{
		}
		return sBuf.toString();
	}
	public static void get(OkHttpClient client,String url,Callback callback)throws IOException
	{
		get(client,url,callback,1);
	}
	public static void get(OkHttpClient client,String url,Callback callback,int times)throws IOException
	{
		Request request=new Request.Builder()
			.url(url)
			.build();
		//每次enqueue都发起一次请求，得到不同的response，做不到一次response多个callback，
		for(int i=0;i<times;++i)
			client.newCall(request).enqueue(callback);
	}
	public static void output(Thread thread)
	{
		System.err.println(""+thread.getName()+":"+thread.getId());
	}
	public static void output(Response response)
	{
		System.err.println(""+response.hashCode()+";"+response.toString());
	}
}
