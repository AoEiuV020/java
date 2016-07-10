/* ***************************************************
	^> File Name: ArrayTest.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/06/10 - 00:46:49
*************************************************** */
package cc.aoeiuv020.jdk;
import java.util.*;
import java.lang.reflect.*;
public class ArrayTest
{
	public static void main(String[] args)throws Exception
	{
		f1();
		f2();
	}
	static void f2()
	{
		//数组的成员，
		String[] arr=new String[3];
		System.out.println(""+arr.length);
	}
	static void f1()throws NoSuchFieldException,IllegalAccessException
	{
		//reflect反射测试数组，
		String[] arr=new String[3];
		Class clazz=arr.getClass();
		for(Member m:clazz.getDeclaredConstructors())
			output(m);
		for(Member m:clazz.getDeclaredFields())
			output(m);
		for(Member m:clazz.getDeclaredMethods())
			output(m);
		try
		{
			Field length=clazz.getField("length");
			System.out.println(""+length.get(arr));
		}
		catch(Exception e)
		{
			System.out.println(""+e);
		}
	}
	static void output(Member mem)
	{
		System.out.println(String.format("%s %s.%s",Modifier.toString(mem.getModifiers()),mem.getDeclaringClass().getName(),mem.getName()));
	}
}
