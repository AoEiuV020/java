/* ***************************************************
	^> File Name: CertificateContent.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/07/03 - 02:21:30
*************************************************** */
package cc.aoeiuv020.ssl;
import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.security.cert.*;
public class CertificateContent
{
	public static X509Certificate[] getCertificates()
	{
		return new X509Certificate[]{get12306()};
	}
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
