import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Codec {
Map<String,String> map = new HashMap<String,String>();
Random rand = new Random();

private String getKey()
{
 String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

 StringBuilder sb = new StringBuilder();
 for(int i=0;i<6; i++)
 {
	 sb.append(chars.charAt(rand.nextInt(62)));
 }
 return sb.toString();
}

public String encode(String url)
{
	String key = getKey();
	while(map.containsKey(key))
	{
		key = getKey();
	}
	map.put(key, url);
	return "http://tinyurl.com/" + key;
}

public String decode(String shortUrl)
{
	return map.get(shortUrl.replace("http://tinyurl.com/",""));
}
}
