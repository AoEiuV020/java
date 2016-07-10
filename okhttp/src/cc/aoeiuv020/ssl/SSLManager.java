/* ***************************************************
	^> File Name: SSLManager.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/07/03 - 01:49:28
*************************************************** */
package cc.aoeiuv020.ssl;
import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.security.NoSuchAlgorithmException;
import java.security.cert.*;
/**
  * 直接调用一个方法全局信任所有证书，
  * public static void setDefaultAllowAll()
  */
public class SSLManager
{
	private static final HostnameVerifier AllowAllHostname=new HostnameVerifier(){
		public boolean verify(String hostname, SSLSession sslSession) {
			//允许任何域名，
			return true;
		}
	};
	public static SSLSocketFactory getSocketFactory(X509TrustManager[] arg)
	{
		return getContext(arg).getSocketFactory();
	}
	public static SSLContext getContext(X509TrustManager[] arg)
	{
		try
		{
			SSLContext context=newSSLContext();
			context.init(null,arg,null);
			return context;
		}
		catch(Exception e)
		{
			throw new RuntimeException("创建SSLContext失败",e);
		}
	}
	public static void setDefault(X509TrustManager[] arg)
	{
		try
		{
			SSLContext context=getContext(arg);
			SSLContext.setDefault(context);
			HttpsURLConnection.setDefaultHostnameVerifier(getAllowAllHostnameVerify());
			HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
		}
		catch(Exception e)
		{
			throw new RuntimeException("设置TrustManager失败",e);
		}
	}
	public static HostnameVerifier getAllowAllHostnameVerify()
	{
		return AllowAllHostname;
	}
	public static SSLContext newSSLContext()
	{
		//协议，SSL/TLS,
		String protocol="TLS";
		try
		{
			return SSLContext.getInstance(protocol);
		}
		catch(NoSuchAlgorithmException e)
		{
			//不可到达
			throw new RuntimeException(""+protocol+" 协议不支持");
		}
	}
	public static void setDefaultInclude(Certificate... cers)
	{
		setDefault(MultiModalTrustManager.getInclude(cers));
	}
	public static void setDefaultOnly(Certificate... cers)
	{
		setDefault(MultiModalTrustManager.getOnly(cers));
	}
	public static void setDefaultAllowAll()
	{
		setDefault(MultiModalTrustManager.getAllowAll());
	}
}
