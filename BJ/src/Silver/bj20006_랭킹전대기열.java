package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj20006_랭킹전대기열 {

	static class Player implements Comparable<Player>{
		int l;
		String n;
		public Player(int level, String nickname) {
			this.l = level;
			this.n = nickname;
		}
		
		@Override
		public int compareTo(Player o) {
			return this.n.compareTo(o.n);
		}

		@Override
		public String toString() {
			return "Player [l=" + l + ", n=" + n + "]";
		}
	}
	static class Room{
		String status = "Waiting!";
		List<Player> list;
		int l;
		public Room (int l) {
			list = new ArrayList<>();
			this.l = l;
		}
		@Override
		public String toString() {
			return "Room [status=" + status + ", list=" + list + ", l=" + l + "]";
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Player plist[] = new Player[p];
		List<Room> rlist = new ArrayList<>();
		for (int i = 0; i < plist.length; i++) {
			st = new StringTokenizer(in.readLine());
			int l = Integer.parseInt(st.nextToken());
			String n = st.nextToken();
			plist[i] = new Player(l, n);
		}
		
		for(int i = 0; i < plist.length; i++) {
			Player player = plist[i];
			boolean flag = false;
			for(int j = 0; j < rlist.size(); j++) {
				Room room = rlist.get(j);
				if(room.status.equals("Started!"))
					continue;
				int l = room.l;
				if((l-10) <= player.l && player.l <= (l+10)) {
					flag = true;
					room.list.add(player);
					if(m == room.list.size())
						room.status = "Started!";
					rlist.set(j, room);
					break;
				}
			}
			if(!flag) {
				Room room = new Room(plist[i].l);
				room.list.add(plist[i]);
				rlist.add(room);
				if(m == room.list.size())
					room.status = "Started!";
			}

		}
		for(int i = 0; i < rlist.size(); i++) {
			Room r = rlist.get(i);
			System.out.println(r.status);
			Collections.sort(r.list);
			for(Player pl : r.list)
				System.out.println(pl.l + " " + pl.n);
		}
	}
}
