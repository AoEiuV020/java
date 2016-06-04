/* ***************************************************
	^> File Name: Logger.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/05/30 - 23:34:18
*************************************************** */
package cc.aoeiuv020.logging;
import java.io.*;
public abstract class Logger
{
	protected String TAG;
	private static Logger mSysoutLogger=Logger.getLogger("AoEiuV020 System.out",System.out);
	private final static boolean DEBUG=true;
	protected Logger()
	{
	}
	protected boolean isDebug()
	{
		return DEBUG;
	}
	private void setTag(String tag)
	{
		TAG=tag;
	}
	public static Logger getLogger(String tag,PrintStream out)
	{
		Logger logger=new StreamLogger(out);
		logger.setTag(tag);
		return logger;
	}
	public static Logger getLogger(String tag,PrintWriter out)
	{
		Logger logger=new StreamLogger(out);
		logger.setTag(tag);
		return logger;
	}
	public static Logger getLogger(String tag)
	{
		Logger logger=new FileLogger();
		logger.setTag(tag);
		return logger;
	}
	public abstract void i(String msg);
	public abstract void i(String msg,Throwable t);
	public static void s(String msg)
	{
		mSysoutLogger.i(msg);
	}
	public static void s(String msg,Throwable t)
	{
		mSysoutLogger.i(msg,t);
	}
}
