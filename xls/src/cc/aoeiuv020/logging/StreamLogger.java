/* ***************************************************
	^> File Name: StreamLogger.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/05/31 - 00:16:52
*************************************************** */
package cc.aoeiuv020.logging;
import java.io.*;
public class StreamLogger extends Logger
{
	private String mFileName=null;
	private PrintWriter mOut=null;
	public StreamLogger()
	{
	}
	public StreamLogger(OutputStream out)
	{
		setWriter(out);
	}
	public StreamLogger(Writer out)
	{
		setWriter(out);
	}
	protected void setWriter(OutputStream out)
	{
		try
		{
			mOut=new PrintWriter(new OutputStreamWriter(out,"UTF-8"),true);
		}
		catch(UnsupportedEncodingException e)
		{
			//不可到达，
			throw new RuntimeException("代码错误",e);
		}
	}
	protected void setWriter(PrintWriter out)
	{
		mOut=out;
	}
	protected void setWriter(Writer out)
	{
		mOut=new PrintWriter(out,true);
	}
	protected boolean isDebug()
	{
		return super.isDebug()&&mOut!=null;
	}
	@Override
	public void i(String msg)
	{
		i(msg,null);
	}
	@Override
	public void i(String msg,Throwable throwable)
	{
		if(!isDebug())return;
		mOut.println("****"+TAG+"****");
		mOut.println(msg);
		if(throwable!=null)
		{
			throwable.printStackTrace(mOut);
		}
	}
}
