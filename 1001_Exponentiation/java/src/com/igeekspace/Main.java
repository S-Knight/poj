package com.igeekspace;

import java.io.*;
import java.math.BigDecimal;

public class Main {
    private static final boolean debug = false;

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
                double r = nextNumber();
                int n = (int) nextNumber();

                BigDecimal bigDecimal = new BigDecimal(Double.toString(r));

                if (debug) {
                    out.println("r is " + r + "; n is " + n);
                    out.println("answer is :" + bigDecimal.pow(n));
                }

                String answer = bigDecimal.pow(n).stripTrailingZeros().toPlainString();
                out.println(answer.startsWith("0") ? answer.substring(1) : answer);
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