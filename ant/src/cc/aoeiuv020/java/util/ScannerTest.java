/* ***************************************************
	^> File Name: ScannerTest.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/06/09 - 23:49:57
*************************************************** */
package cc.aoeiuv020.java.util;
import java.util.*;
import java.io.*;
public class ScannerTest
{
	public static void main(String[] args)
	{
		try
		{
			Scanner scan=new Scanner("5555");
			int port=scan.nextInt();
			System.out.println(""+port);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
}
