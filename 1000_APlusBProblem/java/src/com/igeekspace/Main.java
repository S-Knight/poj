package com.igeekspace;

import java.io.*;

public class Main {
    static BufferedReader bufferedReader;
    static PrintWriter printWriter;

    private static void solve() throws IOException {
        while (true) {
            String input = bufferedReader.readLine();

            if (input == null) {
                break;
            }
            String[] nums = input.split(" ");

            if(nums.length != 2){
                break;
            }
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);

            printWriter.println(a + b);
        }
    }

    public static void main(String[] args) {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        printWriter = new PrintWriter(new OutputStreamWriter(System.out));

        try {
            solve();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        printWriter.flush();
    }
}