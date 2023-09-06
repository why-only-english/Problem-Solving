import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static int[] stack;
    public static int size = 0;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        stack = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {

                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    sb.append(pop()).append('\n');
                    break;

                case "size":
                    sb.append(size()).append('\n');
                    break;

                case "empty":
                    sb.append(empty()).append('\n');
                    break;

                case "top":
                    sb.append(top()).append('\n');
                    break;
                }
            }
            System.out.println(sb);
        }

        public static void push(int item){
            stack[size] = item;  // size칸에 item을 넣고 size를 1씩 증가
            size++;
        }

        public static int pop() {
            // 스택에 들어있는 정수가 없는 경우
            if (size == 0) {
                return -1;
            }
            // 인덱스는 0부터 시작하므로 최상단 요소는 size-1
            else {
                int res = stack[size - 1];
                stack[size - 1] = 0;
                size--;
                return res;
            }
        }

        public static int size() {
            return size;
        }

        public static int empty() {
            // 스택이 비어있으면 1
            if (size == 0) {
                return 1;
            }
            // 아니면 0
            else {
                return 0;
            }
        }

        public static int top() {
            // 스택에 들어있는 정수가 없을 경우 -1
            if (size == 0) {
                return -1;
            }
            // 최상단 요소 size-1
            else {
                return stack[size - 1];
            }
        }
}