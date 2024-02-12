package out.production;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _3015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long ans = 0; // 서로 볼 수 있는 숫자 쌍의 개수
        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int cnt = 1; // 현재 숫자의 반복 횟수
            while (!stack.isEmpty() && stack.peek().value <= arr[i]) {
                if (stack.peek().value == arr[i]) {
                    cnt += stack.peek().count; // 반복 횟수 증가
                    ans += stack.peek().count; // 반복 횟수만큼 쌍의 개수 증가
                    stack.pop();
                } else {
                    ans += stack.peek().count; // 다른 숫자일 경우 1회만 증가
                    stack.pop();
                }
            }
            
            if (!stack.isEmpty()) ans++; // 스택이 비어있지 않으면 현재 숫자와 볼 수 있는 숫자가 하나 더 있음
            stack.push(new Pair(arr[i], cnt));
        }
        
        System.out.println(ans);
    }

    static class Pair {
        int value;
        int count;

        public Pair(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}

