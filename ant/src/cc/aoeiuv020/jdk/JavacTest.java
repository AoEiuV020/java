/* ***************************************************
	^> File Name: JavacTest.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/06/08 - 16:03:48
*************************************************** */
package cc.aoeiuv020.jdk;
/**
 * 只是试试优化，
 * 比如编译期把final变量写进class这个让我很不爽，以前c/c++的const只读变量是不写进二进制文件的，
 */
public class JavacTest
{
	public static void main(String[] args)
	{
		stringTest();
	}
	public static void stringTest()
	{
		String s="1234567890";
		String str="";
		for(int i=0;i<s.length();i+=2)
		{
			str+=s.charAt(i);
		}
		System.out.println(""+str);
	}
}
