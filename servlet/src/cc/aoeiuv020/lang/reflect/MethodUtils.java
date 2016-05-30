/* ***************************************************
	^> File Name: MethodUtils.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/05/30 - 20:19:24
*************************************************** */
package cc.aoeiuv020.lang.reflect;
import org.apache.commons.lang3.StringUtils;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
public class MethodUtils
{
	public static void output(PrintStream out,Object obj)
	{
		output(new PrintWriter(out),obj);
	}
	/**
	 * 输出所有getXXX()和isXXX()方法的返回值
	 */
	public static void output(PrintWriter out,Object obj)
	{
		if(obj==null)return;
		Class cla=obj.getClass();
		Method[] methods=cla.getMethods();
		for(Method method:methods)
		{
			String mName=method.getName();
			Class[] pClas=method.getParameterTypes();
			if(pClas.length==0&&(StringUtils.left(mName,3).equals("get")||StringUtils.left(mName,2).equals("is")))
			{
				Class rCla=method.getReturnType();
				Class dCla=method.getDeclaringClass();
				Object rObj=null;
				try
				{
					rObj=method.invoke(obj);
				}
				catch(Exception e)
				{
				}
				out.println(""+dCla.getName()+"."+mName+"("+pClas.length+")"+rCla.getName()+";"+rObj);
			}
		}
		out.flush();
	}
}
