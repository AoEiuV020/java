/* ***************************************************
	^> File Name: EnumTest.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/06/10 - 22:30:49
*************************************************** */
package cc.aoeiuv020.java.lang;
import java.lang.reflect.*;
public class EnumTest
{
	public static void main(String[] args)
	{
		Class clazz=E.class;
		Field[] fields=clazz.getDeclaredFields();
		for(Member mem:fields)
			output(mem);
		Method[] methods=clazz.getDeclaredMethods();
		for(Member mem:methods)
			output(mem);
		E[] arr=E.values();
		for(E e:arr)
			output(e);
	}
	static void output(E e)
	{
		System.out.println(""+e);
	}
	static void output(Member mem)
	{
		System.out.println(String.format("%s %s.%s",Modifier.toString(mem.getModifiers()),mem.getDeclaringClass().getName(),mem.getName()));
	}
	static enum E
	{
		A,B,C;
	}
}
