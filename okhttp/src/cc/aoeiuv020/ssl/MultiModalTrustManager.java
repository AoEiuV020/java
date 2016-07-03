/* ***************************************************
	^> File Name: MultiModalTrustManager.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/07/03 - 02:13:57
*************************************************** */
package cc.aoeiuv020.ssl;
import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.security.cert.*;
import java.security.KeyStore;
/**
  * 总之就是通过几个方法得到信任管理器，
  */
public class MultiModalTrustManager
{
	private static final boolean DEBUG=true;
	public static X509TrustManager[] getInclude(Certificate... cers)
	{
		return new X509TrustManager[]{new Include(cers)};
	}
	public static X509TrustManager[] getOnly(Certificate... cers)
	{
		return new X509TrustManager[]{new Only(cers)};
	}
	public static X509TrustManager[] getDenyAll()
	{
		return new X509TrustManager[]{new DenyAll()};
	}
	public static X509TrustManager[] getAllowAll()
	{
		return new X509TrustManager[]{new AllowAll()};
	}
	private static class AllowAll implements X509TrustManager
	{
		private final X509Certificate[] EMPTY_CERTIFICATE=new X509Certificate[0];
		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType)
		{
		}
		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType)
		{
		}
		@Override
		public X509Certificate[] getAcceptedIssuers()
		{
			return EMPTY_CERTIFICATE;
		}
	}
	private static class DenyAll implements X509TrustManager
	{
		private final X509Certificate[] EMPTY_CERTIFICATE=new X509Certificate[0];
		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType)
		{
		}
		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType)throws CertificateException
		{
			throw new CertificateException("不被信任的证书");
		}
		@Override
		public X509Certificate[] getAcceptedIssuers()
		{
			return EMPTY_CERTIFICATE;
		}
	}
	private static class Only implements X509TrustManager
	{
		private final Set<X509Certificate> accepted=new HashSet<>();
		public Only(Certificate... cers)
		{
			addAllCertificate(cers);
		}
		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType)
		{
		}
		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType)throws CertificateException
		{
			for(X509Certificate cer:chain)
			{
				if(accepted.contains(cer))
				{
					accepted.addAll(Arrays.asList(chain));
					return;
				}
			}
			throw new CertificateException("不被信任的证书");
		}
		@Override
		public X509Certificate[] getAcceptedIssuers()
		{
			return (X509Certificate[])accepted.toArray(new X509Certificate[0]);
		}
		public void addCertificate(Certificate certificate)
		{
			if(certificate instanceof X509Certificate)
			{
				accepted.add((X509Certificate)certificate);
			}
		}
		public void addAllCertificate(Certificate... cers)
		{
			for(Certificate cer:cers)
			{
				addCertificate(cer);
			}
		}
	}
	private static class Include extends Only
	{
		private static X509TrustManager defaultTrustManager;
		static
		{
			try
			{
				TrustManagerFactory tmf=TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
				tmf.init((KeyStore)null);
				TrustManager[] tms=tmf.getTrustManagers();
				for(TrustManager tm:tms)
				{
					if(tm instanceof X509TrustManager)
					{
						defaultTrustManager=(X509TrustManager)tm;
						break;
					}
				}
			}
			catch(Exception e)
			{
				//不可到达，
				throw new RuntimeException("初始化默认信任管理器失败",e);
			}
			assert(defaultTrustManager!=null);
		}
		public Include(Certificate... cers)
		{
			super(cers);
		}
		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType)throws CertificateException
		{
			try
			{
				defaultTrustManager.checkServerTrusted(chain,authType);
				addAllCertificate(chain);
			}
			catch(CertificateException e)
			{
				super.checkServerTrusted(chain,authType);
			}
		}
	}
}
