package chapter_Six_Brute_Force_Search;

import java.util.*;

public class BannedUser {

	public static void main(String[] args) {
		
	}
}


class BannedUserSolution {

	public BannedUserSolution() {
		super();
	}

	static Set<Set<String>> result = new HashSet<>();

	public static int bannedUserSolution(String[] userId, String[] bannId) {

		List<List<String>> list2 = new ArrayList<>();

		for(String b_ID  : bannId) {
			List<String> list = new ArrayList<>();
			for(String u_ID : userId) {
				if(match(u_ID,b_ID)) { 
					list.add(u_ID);
				}
			}
			list2.add(list);
		}
		dfs(list2,0,new HashSet<>());
		return result.size();
	}

	public static void dfs(List<List<String>> list2, int index, Set<String>current ) {
		/*
		dfs(list2, index + 1, current)가 호출될 때, 그 순간의 current.size()는 index + 1과 항상 같게 유지됩니다.
		if(index == current.size()) (X) index와 current.size()가 dfs를 재귀할때마다 같아지므로 나머지 banID를 처리할 수 없음
		그러므로 모든 밴 아이디를 처리하기 위해서 list2.size로 정해야지만 모든 밴 아이디를 처리할 수 있음
		*/
		if(index == list2.size()) {
			result.add(new HashSet<>(current));
			return;
		}
		for(String userID : list2.get(index)) {
			if(!current.contains(userID)) {
				current.add(userID);
				dfs(list2,index+1,current);
				current.remove(userID);
			}
		}
	}

	public static boolean match(String userID, String bannID) {
		if(userID.length() != bannID.length()) {
			return false;
		}
		for(int i=0; i<userID.length(); i++) {
			if(bannID.charAt(i) == '*') {
				continue;
			}
			if(userID.charAt(i) != bannID.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}