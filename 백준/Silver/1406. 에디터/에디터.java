import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        // 스택 2개를 이용한 구현
        // 스택은 모든 연산이 O(1)의 시간 복잡도를 가지기 때문에 시간 초과 걸리지 않음
        // 모르겠어서 블로그 그림만 보고 코드 짬

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String origin[] = br.readLine().split("");

        Stack<String> leftSt = new Stack<String>();
        Stack<String > rightSt = new Stack<String>();

        for(int i=0;i<origin.length;i++) {
            leftSt.push(origin[i]);
        }

        int N = Integer.parseInt(br.readLine());

        while(N-- >0) {
            String command[] = br.readLine().split(" ");

            if(command[0].equals("P")) {
                leftSt.push(command[1]);
            }else if(command[0].equals("L")) {
                if(leftSt.size()>0) {
                    rightSt.push(leftSt.pop());
                }
            }
            else if(command[0].equals("D")) {
                if(rightSt.size()>0) {
                    leftSt.push(rightSt.pop());
                }
            }
            else if(command[0].equals("B")) {
                if(leftSt.size()>0) {
                    leftSt.pop();
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(!leftSt.isEmpty()) {
            rightSt.push(leftSt.pop());
        }
        while(!rightSt.isEmpty()) {
            bw.write(rightSt.pop());
        }
        bw.flush();
        bw.close();
    }
}
