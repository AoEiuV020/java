/* ***************************************************
	^> File Name: Main.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/05/22 - 22:02:18
*************************************************** */
package cc.aoeiuv020;
import java.lang.reflect.*;
public class Main
{
	static String[] mArgs;
	public static void main(String[] args)throws Exception
	{
		mArgs=args;
		//cc.aoeiuv020.javax.net.ssl.HttpsTest.main(args);
		//run("cc.aoeiuv020.java.util.PropertiesTest");
		run("cc.aoeiuv020.javax.net.ssl.HttpsTest");
		//run("cc.aoeiuv020.javax.net.ssl.SSLSocketFactoryTest");
	}
	public static void run(String className)throws Exception
	{
		Class clazz=Class.forName(className);
		Method main=clazz.getMethod("main",String[].class);
		main.invoke(null,new Object[]{mArgs});
	}
}
