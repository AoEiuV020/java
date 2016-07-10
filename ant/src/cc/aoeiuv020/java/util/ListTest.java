/* ***************************************************
	^> File Name: ListTest.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/06/10 - 00:28:16
*************************************************** */
package cc.aoeiuv020.java.util;
import java.util.*;
public class ListTest
{
	public static void main(String[] args)
	{
		f2();
	}
	static void f2()
	{
		List<String> list=new LinkedList<String>();
		for(int i=0;i<10;++i)
		{
			list.add("i="+i);
		}
		Iterator<String> it=list.iterator();
		if(it.hasNext())
		{
			System.out.println(""+it.next());
		}
	}
	static void f1()
	{
		//contains测试，
		List<String> list=new LinkedList<String>();
		String a="str";
		String b=new String(a);
		System.out.println(String.format("%s:%s",a.hashCode(),b.hashCode()));
		list.add(a);
		System.out.println(""+list.contains(a));
		System.out.println(""+list.contains(b));
	}
}
