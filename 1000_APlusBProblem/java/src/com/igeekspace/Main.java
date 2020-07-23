package com.igeekspace;

import java.io.*;

public class Main {
    static StreamTokenizer in;
    static PrintWriter out;

    private static double nextNumber() throws IOException {
        if (in.nextToken() == StreamTokenizer.TT_EOF) {
            throw new IOException("EOF");
        }
        return in.nval;
    }

    private static void solve() {
        while (true) {
            try {
                int a = (int) nextNumber();
                int b = (int) nextNumber();

                out.println(a + b);
            } catch (IOException ioException) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        solve();
        out.flush();
    }
}