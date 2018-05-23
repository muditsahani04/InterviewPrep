
public class TrieImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie tree = new Trie();
		/*tree.insert("struct");
		tree.insert("word");
		tree.insert("test");
		tree.insert("random");
		tree.insert("leetcode");
		tree.insert("google");*/
		tree.insert("ab");
		tree.insert("abc");
		System.out.println(tree.search("ab"));
		System.out.println(tree.startsWith("abcd"));
	}

}
