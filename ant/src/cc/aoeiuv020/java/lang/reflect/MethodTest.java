/* ***************************************************
	^> File Name: MethodTest.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/05/30 - 01:21:07
*************************************************** */
package cc.aoeiuv020.java.lang.reflect;
import java.lang.reflect.*;
import java.io.*;
public class MethodTest
{
	public static void main(String[] args)throws NoSuchMethodException
	{
		PrintStream out=System.out;
		Class cla=A.class;
		System.out.println(""+(cla.getMethod("wait")==A.class.getMethod("wait")));
		System.out.println(""+(cla.getMethod("wait")==Object.class.getMethod("wait")));
		System.out.println(""+(cla.getMethod("wait").equals(Object.class.getMethod("wait"))));
		System.out.println(""+(cla.getMethod("wait").getDeclaringClass().equals(Object.class.getMethod("wait").getDeclaringClass())));
		System.out.println(""+(cla.getMethod("wait").getReturnType().equals(Void.class.getMethod("wait").getReturnType())));
		Method[] methods=cla.getMethods();
		for(Method method:methods)
		{
			String mName=method.getName();
			Class[] pClas=method.getParameterTypes();
			StringBuffer parm=new StringBuffer();
			for(Class pCla:pClas)
			{
				parm.append(pCla.getName());
				parm.append(",");
			}
			Class dCla=method.getDeclaringClass();
			Class rCla=method.getReturnType();
			out.println(""+dCla.getName()+"."+mName+"("+parm+")"+rCla.getName()+";");
		}
	}
}
class A
{
	public void foo(int a,String b)
	{
	}
	public void foo()
	{
	}
	public void bar()
	{
	}
}
