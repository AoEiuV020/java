/* ***************************************************
	^> File Name: Main.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/06/18 - 02:16:11
*************************************************** */
package cc.aoeiuv020;
import net.sf.json.*;
import java.io.*;
import java.util.*;
public class Main
{
	private static final String inputFileName="res/response_json";
	private static final String outputFileName="res/response_json_json";
	public static void main(String[] args)throws Exception
	{
		InputStreamReader input=new FileReader(inputFileName);
		StringBuffer sBuf=new StringBuffer();
		char[] buf=new char[1024];
		int len;
		while((len=input.read(buf))>0){
			sBuf.append(buf,0,len);
		}
		input.close();
		JSONObject jIn=JSONObject.fromObject(sBuf.toString());
		JSONObject jOut=new JSONObject();
		Iterator<String> iterator=jIn.keys();
		while(iterator.hasNext()){
			String key=iterator.next();
			String value=jIn.getString(key);
			try{
				JSONObject jsonValue=JSONObject.fromObject(value);
				jOut.element(key,jsonValue);
			}
			catch(Exception e){
				jOut.element(key,value);
			}
		}
		OutputStreamWriter output=new FileWriter(outputFileName);
		output.write(jOut.toString(4));
		output.close();
	}
}
