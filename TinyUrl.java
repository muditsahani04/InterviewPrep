
public class TinyUrl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String longUrl = "https://leetcode.com/problems/design-tinyurl";
		Codec codec = new Codec();
		
		System.out.println(codec.encode(longUrl));
		System.out.println(codec.decode(codec.encode(longUrl)));
	}

}
