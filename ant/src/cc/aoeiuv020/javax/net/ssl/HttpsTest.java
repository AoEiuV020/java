/* ***************************************************
	^> File Name: HttpsTest.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/07/02 - 03:55:41
*************************************************** */
package cc.aoeiuv020.javax.net.ssl;
import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.security.SecureRandom;
import java.security.cert.*;
public class HttpsTest
{
	public static void main(String[] args)throws Exception
	{
		output(get("https://sp0.baidu.com/5a1Fazu8AA54nxGko9WTAnF6hhy/su?wd=&json=1&p=3&sid=1461_17710_20515_18288_20536_20538_20467_19860_15636_12105&req=2&csor=0&cb=jQuery1102043230433850776584_1467403462404&_=1467403462405"));
		output(getNoException("https://www.12306.cn/mormhweb/images/date.js"));
		setAcceptAll();
		output(getNoException("https://www.12306.cn/mormhweb/images/date.js"));
		output(getNoException("https://sp0.baidu.com/5a1Fazu8AA54nxGko9WTAnF6hhy/su?wd=&json=1&p=3&sid=1461_17710_20515_18288_20536_20538_20467_19860_15636_12105&req=2&csor=0&cb=jQuery1102043230433850776584_1467403462404&_=1467403462405"));
		output(getNoException("https://www.12306.cn/mormhweb/images/date.js"));
	}
	public static void output(String s)
	{
		System.out.println(s);
	}
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
	public static void setAcceptAll()
	{
		try
		{
			HttpsURLConnection.setDefaultHostnameVerifier(
					new HostnameVerifier(){

						public boolean verify(String hostname, SSLSession sslSession) {
							System.err.println("** Hostname "+hostname+" Accepted");
							System.err.println("SSLSession "+sslSession);
							return true;
						}
					});
			//SSLContext context=SSLContext.getDefault();
			//SSLContext context=SSLContext.getInstance("Default");//getDefault();
			//SSLContext context=SSLContext.getInstance("SSL", "SunJSSE");
			SSLContext context=SSLContext.getInstance("SSL");
			context.init(null,AcceptAllTrustManager.get(),new SecureRandom());
			SSLContext.setDefault(context);
			HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
		}
		catch(Exception e)
		{
			throw new RuntimeException("设置TrustManager失败，",e);
		}
	}
	public static class AcceptAllTrustManager implements X509TrustManager
	{
		private final Set<X509Certificate> accepted=new HashSet<>();
		private static X509Certificate c12306=Cert.get12306();
		public AcceptAllTrustManager()
		{
			accepted.add(c12306);
		}
		public void checkClientTrusted(X509Certificate[] chain, String authType)
		{
			//没用，
			System.err.println("---checkClientTrusted "+authType+" ---");
		}
		public void checkServerTrusted(X509Certificate[] chain, String authType)throws CertificateException
		{
			System.err.println("---checkServerTrusted "+authType+" ---");
			output(chain);
			accepted.addAll(Arrays.asList(chain));
		}
		public X509Certificate[] getAcceptedIssuers()
		{
			System.err.println("---getAcceptedIssuers "+accepted.size()+" ---");
			return (X509Certificate[])accepted.toArray(new X509Certificate[0]);
		}
		private static void output(X509Certificate[] chain)
		{
			for(X509Certificate cer:chain)
			{
				System.err.println(" * "+cer.hashCode()+" * ");
				//System.err.println(""+cer.toString());
				System.err.println(""+cer.equals(c12306));
			}
		}
		public static AcceptAllTrustManager[] get()
		{
			return new AcceptAllTrustManager[]{new AcceptAllTrustManager()};
		}
	}
	public static class Cert
	{
		public static X509Certificate get12306()
		{
			try
			{
				CertificateFactory cFactory=CertificateFactory.getInstance("X.509");
				X509Certificate certificate=(X509Certificate)cFactory.generateCertificate(new ByteArrayInputStream(srca_cer.getBytes()));
				return certificate;
			}
			catch(Exception e)
			{
				throw new RuntimeException("证书处理失败",e);
			}
		}
		public static String srca_cer=
			"-----BEGIN CERTIFICATE-----\n"+
			"MIICmjCCAgOgAwIBAgIIbyZr5/jKH6QwDQYJKoZIhvcNAQEFBQAwRzELMAkGA1UEBhMCQ04xKTAn\n"+
			"BgNVBAoTIFNpbm9yYWlsIENlcnRpZmljYXRpb24gQXV0aG9yaXR5MQ0wCwYDVQQDEwRTUkNBMB4X\n"+
			"DTA5MDUyNTA2NTYwMFoXDTI5MDUyMDA2NTYwMFowRzELMAkGA1UEBhMCQ04xKTAnBgNVBAoTIFNp\n"+
			"bm9yYWlsIENlcnRpZmljYXRpb24gQXV0aG9yaXR5MQ0wCwYDVQQDEwRTUkNBMIGfMA0GCSqGSIb3\n"+
			"DQEBAQUAA4GNADCBiQKBgQDMpbNeb34p0GvLkZ6t72/OOba4mX2K/eZRWFfnuk8e5jKDH+9BgCb2\n"+
			"9bSotqPqTbxXWPxIOz8EjyUO3bfR5pQ8ovNTOlks2rS5BdMhoi4sUjCKi5ELiqtyww/XgY5iFqv6\n"+
			"D4Pw9QvOUcdRVSbPWo1DwMmH75It6pk/rARIFHEjWwIDAQABo4GOMIGLMB8GA1UdIwQYMBaAFHle\n"+
			"tne34lKDQ+3HUYhMY4UsAENYMAwGA1UdEwQFMAMBAf8wLgYDVR0fBCcwJTAjoCGgH4YdaHR0cDov\n"+
			"LzE5Mi4xNjguOS4xNDkvY3JsMS5jcmwwCwYDVR0PBAQDAgH+MB0GA1UdDgQWBBR5XrZ3t+JSg0Pt\n"+
			"x1GITGOFLABDWDANBgkqhkiG9w0BAQUFAAOBgQDGrAm2U/of1LbOnG2bnnQtgcVaBXiVJF8LKPaV\n"+
			"23XQ96HU8xfgSZMJS6U00WHAI7zp0q208RSUft9wDq9ee///VOhzR6Tebg9QfyPSohkBrhXQenvQ\n"+
			"og555S+C3eJAAVeNCTeMS3N/M5hzBRJAoffn3qoYdAO1Q8bTguOi+2849A==\n"+
			"-----END CERTIFICATE-----";
	}
}
