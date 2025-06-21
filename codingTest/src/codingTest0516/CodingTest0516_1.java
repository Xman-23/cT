package codingTest0516;

import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;
import java.time.*;
import java.time.format.*;


public class CodingTest0516_1 {
	//필렌드롬
    public static void main(String[] args) {
        String s = "abcbabcbabcba";
        int maxLen = 1;

        for (int i = 0; i < s.length(); i++) {
            // 홀수 길이 팰린드롬 체크
            int left = i, right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                maxLen = Math.max(maxLen, right - left + 1);
                left--;
                right++;
            }

            // 짝수 길이 팰린드롬 체크
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                maxLen = Math.max(maxLen, right - left + 1);
                left--;
                right++;
            }
        }

        System.out.println(maxLen);
    }

}

class WordCompress {
	
	WordCompress() {
		super();
	}
	//aaabbbcc
	public static int wordCompree(String string) {
		int returnCouner = 1;
		StringBuilder counterStringBuilder = new StringBuilder();

		for(int i=0; i<string.length()-1;i++) {
			//abb
			
			if(string.charAt(i) == string.charAt(i+1)) {
				returnCouner++;
			}else {
				counterStringBuilder.append(string.charAt(i)).append(returnCouner);
				returnCouner=1;
			}
		}

		System.out.println(counterStringBuilder);

		String toString = counterStringBuilder.append(string.charAt(string.length()-1)).append(returnCouner).toString();
		int reverseCounter = 0;
		for(int i=0; i<toString.length(); i++) {
			char ch = toString.charAt(i);
			if(ch>='2' && ch <= '9') {
				System.out.println("ch [" + i +"] =" +ch);
				reverseCounter =  reverseCounter + (ch-'0');
			}
		}
		System.out.println(reverseCounter);
		return reverseCounter;
	}
}

class SolutionTwo {
	//2ab3cc
    public int solution(String s) {
    	int returnInt = s.length();

    	for(int len = 1; len<=s.length()/2; len++) {
    		StringBuilder stringBuilder = new StringBuilder();
    		String prevString = s.substring(0,len);
    		int returnCouner = 1;

    		for(int i=len; i<s.length(); i = i+len) {
    			String currentString = (i+len <= s.length()) ? s.substring(i,i+len) : s.substring(i);

    			if(currentString.equals(prevString)) {
    				returnCouner++;
    			}else {
    				if(returnCouner > 1) {
    					stringBuilder.append(returnCouner);
    				}
    				stringBuilder.append(prevString);
    				prevString = currentString;
    				returnCouner = 1;
    			}
    		}
    		if(returnCouner > 1) {
    			stringBuilder.append(returnCouner);
    		}
    		stringBuilder.append(prevString);
    		returnInt = Math.min(returnInt, stringBuilder.length());
    	}
        return returnInt;
    }
    //트리
    public int solutionThree(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n + 1];
        boolean[] visited = new boolean[n + 1];
        int[] maxDepth = new int[1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(1, 1, graph, visited, maxDepth); // 루트 노드 1부터 시작, 깊이 1
        return maxDepth[0];
    }

    private void dfs(int node, int depth, List<Integer>[] graph, boolean[] visited, int[] maxDepth) {
        visited[node] = true;
        if (depth > maxDepth[0]) {
            maxDepth[0] = depth;
        }

        for (int i = 0; i < graph[node].size(); i++) {
            int next = graph[node].get(i);
            if (!visited[next]) {
                dfs(next, depth + 1, graph, visited, maxDepth);
            }
        }
    }
}
class sThree {

	sThree() {
		super();
	}
	//하노이 변수
	ArrayList<int[]> arrayList = new ArrayList<int[]>();
	//나무 짜르기
	public static int solution(int arr[], int h) {

		int start = 0;
		int end = 0;
		int result = 0;
		for(int i=0; i<arr.length;i++) {
			if(arr[i] > end) {
				end = arr[i];
			}
		}

		while(start <= end) {
			int mid = (start+end) / 2;
			long sum = 0;

			for(int i=0; i<arr.length;i++) {
				if(arr[i] > mid) {
					sum = sum +(arr[i]-mid);
				}else {
					sum = sum+0;
				}
			}
			if(sum >= h) {
				result = mid;
				start = mid+1;
			}else {
				end = mid-1;
			}
		}

		return result;
	}
	//하노이
	public void hanoi(int n, int f,int to,int via) {

		if(n == 1) {
			arrayList.add(new int[] {f,to});
			return;
		}
		hanoi (n-1,f,via,to);
		arrayList.add(new int[] {f,to});
		hanoi (n-1,via,to,f);
	}
	
	public int[][] solutionTwo(int n) {
		hanoi(n,1,3,2);

		int[][] returnint = new int[arrayList.size()][2];

		for(int i=0; i<arrayList.size(); i++) {
			returnint[i] = arrayList.get(i);
		}
		return returnint;
	}

	public int arrayMuiltiple(int[]	 number, int[] number2) {

		Arrays.sort(number);

		Integer[] integer = new Integer[number2.length];
		
		for(int i=0; i<integer.length; i++) {
			integer[i] = number2[i];
		}

		Arrays.sort(integer,Comparator.reverseOrder());
		int returnInt = 0;
		for(int i=0; i<number.length;i++) {
			returnInt = returnInt + number[i] * integer[i];
		}

		return returnInt;
	}
}