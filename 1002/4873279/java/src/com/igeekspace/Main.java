package com.igeekspace;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class MapKeyComparator implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {

        return str1.compareTo(str2);
    }
}

public class Main {
    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    //字母到数字的映射关系
    static HashMap<Character, String> letterNumberMap;

    /**
     * 获取某个电话号码的标准格式
     *
     * @param phoneNumber
     * @return
     */
    private static String getStandPhoneNumber(String phoneNumber) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < phoneNumber.length(); i++) {
            char currentChar = phoneNumber.charAt(i);
            if (Character.isLetter(currentChar)) {
                stringBuilder.append(letterNumberMap.get(currentChar));
            } else if (Character.isDigit(currentChar)) {
                stringBuilder.append(currentChar);
            }
        }

        stringBuilder.insert(3, '-');
        return stringBuilder.toString();
    }

    /**
     * 建立字母到数字的映射关系
     */
    private static void init() {
        letterNumberMap = new HashMap<Character, String>();

        int count = 0;
        int number = 2;
        for (char i = 'A'; i < 'Z'; i++) {
            if (i == 'Q') {
                continue;
            }

            letterNumberMap.put(i, Integer.toString(number));

            count++;

            if (count % 3 == 0) {
                number++;
            }
        }
    }

    private static void solve() throws IOException {
        int numberCount = Integer.parseInt(bufferedReader.readLine());

        TreeMap<String, Integer> phoneNumbers = new TreeMap<String, Integer>(new MapKeyComparator());

        while (numberCount-- > 0) {
            String phoneNumber = bufferedReader.readLine();
            String standPhoneNumber = getStandPhoneNumber(phoneNumber);

            if (phoneNumbers.containsKey(standPhoneNumber)) {
                phoneNumbers.put(standPhoneNumber, phoneNumbers.get(standPhoneNumber) + 1);
            } else {
                phoneNumbers.put(standPhoneNumber, 1);
            }
        }

        boolean isDuplicates = false;
        for (Map.Entry<String, Integer> phoneNumber : phoneNumbers.entrySet()) {
            if (phoneNumber.getValue() > 1) {
                isDuplicates = true;

                printWriter.println(phoneNumber.getKey() + " " + phoneNumber.getValue());
            }
        }

        if (!isDuplicates) {
            printWriter.println("No duplicates.");
        }
    }

    public static void main(String[] args) throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        printWriter = new PrintWriter(new OutputStreamWriter(System.out));
        init();
        solve();
        printWriter.flush();
    }
}