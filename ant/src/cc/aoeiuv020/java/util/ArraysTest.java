/* ***************************************************
	^> File Name: ArraysTest.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/06/10 - 00:34:47
*************************************************** */
package cc.aoeiuv020.java.util;
import java.util.*;
public class ArraysTest
{
	public static void main(String[] args)
	{
		String[] arr=new String[3];
		List<String> list=new ArrayList<String>();
		if(list instanceof Collection)
			System.out.println(""+"true");
		else
			System.out.println(""+"false");
		System.out.println(arr.getClass());
		System.out.println(list.getClass());
	}
}
