package edu;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int arrNum = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        String temp;
        for (int i = 0; i < arrNum; i++) {
            temp = st2.nextToken();
            if (num > Integer.parseInt(temp)) {
                sb.append(temp + " ");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
