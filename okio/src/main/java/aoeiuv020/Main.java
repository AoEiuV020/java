package aoeiuv020;
import okio.*;
/**
 * @author AoEiuV020
 * @version 1.0, 2016/07/21
 */
public class Main{
	public static void main(String[] args){
		Buffer buffer=new Buffer();
		buffer.writeLong(System.currentTimeMillis());
		output(buffer);
		buffer.writeLong(Double.doubleToLongBits(Math.random()));
		output(buffer);
		String base64=buffer.readByteString().base64();
		output(base64);
		ByteString bs=ByteString.decodeBase64(base64);
		output(bs.toString());
		buffer=new Buffer().write(bs);
		long timeMillis=buffer.readLong();
		double random=Double.longBitsToDouble(buffer.readLong());
		System.out.printf("%d,%x,%f;\n",timeMillis,timeMillis,random);
	}
	public static void output(String str){
		System.out.println(""+str.length());
		System.out.println(str);
	}
	public static void output(Buffer buffer){
		buffer=buffer.clone();
		System.out.println(""+buffer);
	}
}

