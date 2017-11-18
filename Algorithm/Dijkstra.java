public class Dijkstra{
	public void Dijkstra(int[][] map, int start){
		int length = map.length;
		int flag = 1, x = 0;
		int[] s = new int[length];
		int[] vis = new int[length];

		for(int i = 0; i < length; i++) {
			s[i] = map[i][start];
			vis[i] = 0;
		}
		vis[start] = 1;

		for(int i = start; flag < length; ) {
			int min = 0x7fffffff;
			for(int j = 0; j < length; j++) {
				if(vis[j] == 1 || i == j || map[i][j] == 0x7fffffff) continue;

				if(map[i][j] + s[i] < s[j]) {
					s[j] = map[i][j] + s[i];
				}
				if(s[j] < min) {
					min = s[j];
					x = j;
				}
			}
			i = x;
			vis[i] = 1;
			flag++;
		}	



		for(int i = 0; i < length; i++) {
			System.out.println(s[i]);
		}

	}
	public static void main(String[] args){
		int[][] map = new int[6][6];
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 6; j++) {
				if(i == j) map[i][j] = 0;
				else map[i][j] = 0x7fffffff;
			}
		}
		for(int i = 0; i < args.length; i++) {
			int x = Integer.valueOf(args[i++]);
			int y = Integer.valueOf(args[i++]);
			int z = Integer.valueOf(args[i]);
			map[x][y] = z;
			map[y][x] = z;
		}
		
		Dijkstra a = new Dijkstra();
		a.Dijkstra(map, 0);
	}

}