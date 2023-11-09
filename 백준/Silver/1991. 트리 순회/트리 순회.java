import java.io.*;
import java.util.*;

// 전위 순회 : 루트 왼쪽자식 오른쪽자식
// 중위 순회 : 왼쪽자식 루트 오른쪽자식
// 후위 순회 : 왼쪽자식 오른쪽자식 루트

class Node {
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    static Node[] tree;

    // 전위 순회 : 루트 왼쪽자식 오른쪽자식
    public static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 순회 : 왼쪽자식 루트 오른쪽자식
    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    // 후위 순회 : 왼쪽자식 오른쪽자식 루트
    public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new Node[N + 1];   // 노드 배열 생성

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());  // 띄어쓰기 기준으로 문자열 분리
            // nextToken() 메서드로 토큰을 하나씩 꺼내오면 StringTokenizer객체에는 해당 토큰이 사라짐
            char parentValue = st.nextToken().charAt(0);
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            // 부모 노드가 아직 생성되지 않은 경우
            if (tree[parentValue - 'A'] == null) {
                tree[parentValue - 'A'] = new Node(parentValue);
            }

            // 왼쪽 자식이 존재할 경우
            if (leftValue != '.') {
                tree[leftValue - 'A'] = new Node(leftValue);  // 왼쪽 자식 노드 생성
                tree[parentValue - 'A'].left = tree[leftValue - 'A'];  // 부모 노드와 연결
            }

            // 오른쪽 자식이 존재할 경우
            if (rightValue != '.') {
                tree[rightValue - 'A'] = new Node(rightValue); // 오른쪽 자식 노드 생성
                tree[parentValue - 'A'].right = tree[rightValue - 'A']; // 부모 노드와 연결
            }
        }

        // 전위 순회
        preorder(tree[0]);
        System.out.println();

        // 중위 순회
        inorder(tree[0]);
        System.out.println();

        // 후위 순회
        postorder(tree[0]);
        System.out.println();
    }
}
