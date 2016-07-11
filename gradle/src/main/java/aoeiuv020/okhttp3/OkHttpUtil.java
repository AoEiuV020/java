package aoeiuv020.okhttp3;
import okhttp3.*;
import java.io.IOException;
/**
 * 
 * @author AoEiuV020
 * @version 1.0, 2016/07/12
 */
public class OkHttpUtil{
	private static final OkHttpClient client = new OkHttpClient();
	public static String get(String url)throws IOException{
		Request request = new Request.Builder()
			.url(url)
			.build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}
}

