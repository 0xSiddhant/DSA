
public class Runner {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.addWord("arts");
		trie.addWord("art");
		trie.addWord("boy");
		trie.addWord("bug");
		trie.addWord("seen");
		trie.addWord("sea");
		trie.addWord("see");
		trie.display();
		
		
		
		System.out.println(trie.search("seen"));
		System.out.println(trie.search("no"));
		
		
		trie.remove("arts");
		trie.display();
		System.out.println(trie.numwords());
	}

}
