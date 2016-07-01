/* ***************************************************
	^> File Name: HttpTest.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/07/01 - 21:34:29
*************************************************** */
package cc.aoeiuv020;
import okhttp3.*;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
public class HttpTest
{
	public static OkHttpClient client=new OkHttpClient.Builder().build();
	public static void main(String[] args)throws IOException
	{
		Map<String,String> data=new HashMap<>();
		data.put("q","w");
		data.put("e","r");
		System.out.println(get(client,"http://aoeiuv020.cc/ip.php?a=s&d=f"));
		System.out.println(post(client,"http://aoeiuv020.cc/ip.php",data));
		System.out.println(get(client,"http://aoeiuv020.cc/ip.php?a=s&d=f"));
		System.out.println(post(client,"http://aoeiuv020.cc/ip.php",data));
	}
	public static String get(OkHttpClient client,String url) throws IOException
	{
		Request request=new Request.Builder()
			.url(url)
			.build();
		Response response=client.newCall(request).execute();
		output(request.headers());
		output(response.headers());
		return response.body().string();
	}
	public static String post(OkHttpClient client,String url,Map<String,String> data) throws IOException
	{
		FormBody.Builder builder=new FormBody.Builder();
		for(Map.Entry<String,String> entry:data.entrySet())
		{
			builder.add(entry.getKey(),entry.getValue());
		}
		Request request=new Request.Builder()
			.url(url)
			.post(builder.build())
			.build();
		Response response=client.newCall(request).execute();
		output(request.headers());
		output(response.headers());
		return response.body().string();
	}
	public static void output(Headers headers)
	{
		Map<String,List<String>> map=headers.toMultimap();
		for(Map.Entry<String,List<String>> entry:map.entrySet())
		{
			String key=entry.getKey();
			System.err.print(" * "+key);
			List<String> value=entry.getValue();
			for(String s:value)
			{
				System.err.println(" \t\t "+s);
			}
		}
	}
}
