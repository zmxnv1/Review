public class Floyd{
	public void Floyd(int[][] map){
		int length = map.length;
		for(int k = 0; k < length; k++) {
			for(int i = 0; i < length; i++) {
				for(int j = 0; j < length; j++) {
					if(map[i][k] == 0x7fffffff || map[k][j] == 0x7fffffff) continue;
					if(map[i][j] > map[i][k] + map[k][j]){
						map[i][j] = map[i][k] + map[k][j];
					}	
				}
			}
		}
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println("\r");
		}


	}
	public static void main(String[] args){
		int[][] map = new int[4][4];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(i == j) map[i][j] = 0;
				else map[i][j] = 0x7fffffff;
			}
		}
		for(int i = 0; i < args.length; i++) {
			int x = Integer.valueOf(args[i++]);
			int y = Integer.valueOf(args[i++]);
			int z = Integer.valueOf(args[i]);
			map[x][y] = z;
		}
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println("\r");
		}

		Floyd floyd = new Floyd();
		floyd.Floyd(map);
	}

}