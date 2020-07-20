package com.igeekspace;

import java.io.*;

public class Main {
    static StreamTokenizer in;
    static PrintWriter out;

    private static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    private static void solve() throws IOException {
        int a = nextInt();
        int b = nextInt();

        out.println(a + b);
    }

    public static void main(String[] args) {
        try {
            in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
            out = new PrintWriter(new OutputStreamWriter(System.out));
            solve();
            out.flush();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}