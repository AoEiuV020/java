/* ***************************************************
	^> File Name: HttpsTest.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/07/02 - 04:34:46
*************************************************** */
package cc.aoeiuv020;
import cc.aoeiuv020.ssl.*;
import okhttp3.*;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
public class HttpsTest
{
	private static final String BAIDU="https://sp0.baidu.com/5a1Fazu8AA54nxGko9WTAnF6hhy/su?wd=&json=1&p=3&sid=1461_17710_20515_18288_20536_20538_20467_19860_15636_12105&req=2&csor=0&cb=jQuery1102043230433850776584_1467403462404&_=1467403462405";
	private static final String TIELU="https://www.12306.cn/mormhweb/images/date.js";
	public static void main(String[] args)throws Exception
	{
		//f0();
		//f1(new OkHttpClient.Builder().build());
		//f2();
		//f3();
		//f4();
		f5();
	}
	//添加受信任的证书，
	public static void f5()
	{
		OkHttpClient.Builder builder=new OkHttpClient.Builder();
		OkHttpSSLManager.setInclude(builder,CertificateConstant.CER_ALL);
		f1(builder.build());
	}
	//设置成只信任12306,默认信任的百度不被信任，
	public static void f4()
	{
		OkHttpClient.Builder builder=new OkHttpClient.Builder();
		OkHttpSSLManager.setOnly(builder,CertificateConstant.CER_ALL);
		f1(builder.build());
	}
	//对Builder设置信任所有证书，
	public static void f3()
	{
		OkHttpClient.Builder builder=new OkHttpClient.Builder();
		OkHttpSSLManager.setAllowAll(builder);
		f1(builder.build());
	}
	//全局信任全证书，
	public static void f2()
	{
		SSLManager.setDefaultAllowAll();
		f0();
		//对okhttp无效，说明okhttp默认就不是用的默认的SSLContext之类的，
		f1(new OkHttpClient.Builder().build());
	}
	//直接请求https,
	public static void f1(OkHttpClient client)
	{
		output(HttpTest.getNoException(client,BAIDU));
		output(HttpTest.getNoException(client,TIELU));
	}
	//直接用原生URL请求https,
	public static void f0()
	{
		output(URLTest.getNoException(BAIDU));
		output(URLTest.getNoException(TIELU));
	}
	public static void output(String s)
	{
		System.out.println(s);
	}
}
