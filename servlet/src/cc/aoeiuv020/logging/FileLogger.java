/* ***************************************************
	^> File Name: FileLogger.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/05/30 - 23:44:47
*************************************************** */
package cc.aoeiuv020.logging;
import java.io.*;
public class FileLogger extends StreamLogger
{
	private String mFileName=null;
	private PrintWriter mOut=null;
	public FileLogger()
	{
		this("/tmp/FileLogger.log");
	}
	public FileLogger(String fileName)
	{
		mFileName=fileName;
		try
		{
			setWriter(new FileOutputStream(mFileName,true));
		}
		catch(FileNotFoundException e)
		{
			throw new RuntimeException("文件路径不正确",e);
		}
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
