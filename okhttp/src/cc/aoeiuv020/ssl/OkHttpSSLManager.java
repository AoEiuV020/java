/* ***************************************************
	^> File Name: OkHttpSSLManager.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/07/03 - 02:36:04
*************************************************** */
package cc.aoeiuv020.ssl;
import okhttp3.*;
import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.security.cert.*;
public class OkHttpSSLManager
{
	public static void setOnly(OkHttpClient.Builder builder,Certificate... cers)
	{
		X509TrustManager[] trust=MultiModalTrustManager.getOnly(cers);
		set(builder,trust);
	}
	public static void setAllowAll(OkHttpClient.Builder builder)
	{
		X509TrustManager[] trust=MultiModalTrustManager.getAllowAll();
		set(builder,trust);
	}
	public static void set(OkHttpClient.Builder builder,X509TrustManager[] arg)
	{
		builder.hostnameVerifier(SSLManager.getAllowAllHostnameVerify());
		builder.sslSocketFactory(SSLManager.getSocketFactory(arg),arg[0]);
	}
}
