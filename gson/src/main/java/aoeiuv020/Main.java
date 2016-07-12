package aoeiuv020;
import com.google.gson.*;
/**
 * @author AoEiuV020
 * @version 1.0, 2016/07/13
 */
public class Main{
	public static void main(String[] args){
		Gson gson=new Gson();
		F f=new F();
		String json="";
		json=gson.toJson(f);
		System.out.println(json);
		f=gson.fromJson(json,F.class);
		System.out.println(""+f);
	}
}
class F{
	public String token;
	public long timestamp;
	public F(){
		token=""+(int)(Math.random()*10000);
		timestamp=System.currentTimeMillis();
	}
	public String toString(){
		return ""+token+timestamp;
	}
}

