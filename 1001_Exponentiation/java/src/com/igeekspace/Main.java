package com.igeekspace;

import java.io.*;
import java.math.BigDecimal;

public class Main {
    private static final boolean debug = false;

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;

    private static void solve() throws IOException {
        while (true) {
            String input = bufferedReader.readLine();

            if (input == null) {
                break;
            }
            double r = Double.parseDouble(input.substring(0, 6).trim());
            int n = Integer.parseInt(input.substring(7).trim());

            BigDecimal bigDecimal = new BigDecimal(Double.toString(r));

            if (debug) {
                printWriter.println("r is " + r + "; n is " + n);
                printWriter.println("answer is :" + bigDecimal.pow(n));
            }

            String answer = bigDecimal.pow(n).stripTrailingZeros().toPlainString();
            printWriter.println(answer.startsWith("0") ? answer.substring(1) : answer);
        }
    }

    public static void main(String[] args) throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        printWriter = new PrintWriter(new OutputStreamWriter(System.out));
        solve();
        printWriter.flush();
    }
}