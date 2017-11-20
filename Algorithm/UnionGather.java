public class UnionGather{
	private int[] father;
	private int count;
	private int[] size;
	public UnionGather(int numElements){
		father = new int[numElements];
		size = new int[numElements];
		for(int i = 0; i < numElements; i++) {
			father[i] = i;
		}

	}
	public void union(int p, int q){
		int pid = find(p);
		int qid = find(q);
		if(pid == qid) return;
		if(size[pid] > size[qid]) {
			father[qid] = pid;
			size[pid] += size[qid];
		}
		else{
			father[pid] = qid;
			size[qid] += size[pid];
		}
		count--;

	}
	public boolean judgeConnection(int p, int q){
		return find(p) == find(q);
	}
	public int find(int x){
		if(father[x] == x) return x;
		father[x] = find(father[x]);
		return father[x];

	}
}