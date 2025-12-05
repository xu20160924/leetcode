package com.interview;

public class Test {
    public String calculate(String a, String b) {
        StringBuffer sb = new StringBuffer();

        int aPeriod = a.length() - a.indexOf('.');
        int bPeriod = b.length() - b.indexOf('.');
        if (aPeriod != bPeriod) {
            int maxLength = Math.max(aPeriod, bPeriod);
            while (aPeriod++ < maxLength) {
                a += '0';
            }
            while (bPeriod++ < maxLength) {
                b += '0';
            }
        }
        int carry = 0;
        int remaind = 0;
        int maxLength = Math.max(a.length(), b.length());
        int i = a.length() - 1, j = b.length() - 1;

        while (i >= 0 || j >= 0) {
            if (i > 0 && a.charAt(i) == '.' || j > 0 && b.charAt(j) == '.') {
                sb.append('.');
                i--;
                j--;
                continue;
            }


            int aNum = i < 0 ? 0 : a.charAt(i) - '0';
            int bNum = j < 0 ? 0 : b.charAt(j) - '0';
            remaind = (aNum + bNum + carry) % 10;
            carry = (aNum + bNum) / 10;
            sb.append(remaind);
            i--;
            j--;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
//        double a = 223333.23 ;
//        double b = 223333.22 ;
//        String a = "223333.23";
//        String b = "223333.22";
        String a = "456789.99";
        String b = "123456123.784";
        Test test = new Test();
        System.out.println(test.calculate(a, b));
    }
}


