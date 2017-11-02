class Node{
	public char c;
	public Node[] nodes = new Node[26];
	public boolean flag = false;

	public Node(){

	}
	public Node(char c){
		this.c = c;

	}
}
public class trie{
	Node root;

	public trie(){
		root = new Node();
	}

	public void insert(char[] word){
		Node p = root;
		int index = 0;
		while(index < word.length){
			if(p.nodes[word[index] - 'a'] == null) {
				p.nodes[word[index] - 'a'] = new Node(word[index]);
				if(index == word.length - 1) p.nodes[word[index] - 'a'].flag = true;
			}
			p = p.nodes[word[index] - 'a'];
			index++;
		}	
	}

	public boolean search(char[] word){
		if(word.length == 0) return true;
		int index = 0;
		Node p = root;
		while(index < word.length && p != null) {
			if(p.nodes[word[index] - 'a'] == null) return false;
			p = p.nodes[word[index] - 'a'];
			if(index == word.length - 1 && p.flag) return true;
			index++;
		}
		return false;
	}

	public static void main(String[] args){
		trie t = new trie();
		char[] word1 = {'h', 'e', 'l', 'l', 'o'};
		char[] word2 = {'w', 'o', 'r', 'l', 'd'};;
		t.insert(word1);
		t.insert(word2);
		System.out.println(t.search(word1));		
	}

}