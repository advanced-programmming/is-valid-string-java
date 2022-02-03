package com.co.pa;

public class TestMain {


    public static void main(String[] args) {
        withOnlyOneCharacterOk();
        withOnlyOneCharacterBlankSpaceOk();
        withOnlyOneCharacterCounterOk();
        withOnlyOneCharacterBlankSpaceCounterOk();
        sameCounter2SizeOK();
        sameCounterNSizeOK();
        differentCounterNSizeOK();
        differentCounterNSizeNonOK();
        differentCounterNSizeFirstNonOK();
        sameCountersThreeCharOK();
        sameCountersThreeCharFirstOK();
        sameCountersThreeCharSecondOK();
        sameCountersThreeCharThirdOK();
        differentCountersThreeCharNonOK();
        differentCountersThreeCharRandomNonOK();
        sameCountersFourCharOK();
        sameCountersFourCharFirstOK();
        sameCountersFourCharFirstNonOK();
        sameCountersFourCharFirstAndThreeOK();
        sameCountersFourCharFirstAndThreeNonOK();
        differentCountersFourCharNonOK();
    }

    public static void withOnlyOneCharacterOk(){
        String input = "a";
        boolean expect = true;
        boolean result = Main.isValid(input);
        System.out.println("[withOnlyOneCharacterOk]: " + (expect == result));
    }

    public static void withOnlyOneCharacterCounterOk(){
        String input = "aaaa";
        boolean expect = true;
        boolean result = Main.isValid(input);
        System.out.println("[withOnlyOneCharacterCounterOk]: " + (expect == result));
    }

    public static void withOnlyOneCharacterBlankSpaceOk(){
        String input = " ";
        boolean expect = true;
        boolean result = Main.isValid(input);
        System.out.println("[withOnlyOneCharacterBlankSpaceOk]: " + (expect == result));
    }

    public static void withOnlyOneCharacterBlankSpaceCounterOk(){
        String input = "              ";
        boolean expect = true;
        boolean result = Main.isValid(input);
        System.out.println("[withOnlyOneCharacterBlankSpaceCounterOk]: " + (expect == result));
    }

    public static void sameCounter2SizeOK(){
        String input = "aabb";
        boolean expect = true;
        boolean result = Main.isValid(input);
        System.out.println("[sameCounter2SizeOK]: " + (expect == result));
    }

    public static void sameCounterNSizeOK(){
        String input = "aaaaaaaabbbbbbbb";
        boolean expect = true;
        boolean result = Main.isValid(input);
        System.out.println("[sameCounterNSizeOK]: " + (expect == result));
    }

    public static void differentCounterNSizeOK(){
        String input = "aabbb";
        boolean expect = true;
        boolean result = Main.isValid(input);
        System.out.println("[differentCounterNSizeOK]: " + (expect == result));
    }

    public static void differentCounterNSizeNonOK(){
        String input = "aabbbb";
        boolean expect = false;
        boolean result = Main.isValid(input);
        boolean print = expect && result;
        System.out.println("[differentCounterNSizeNonOK]: " + (expect == result));
    }

    public static void differentCounterNSizeFirstNonOK(){
        String input = "aaaaaabbbb";
        boolean expect = false;
        boolean result = Main.isValid(input);
        System.out.println("[differentCounterNSizeFirstNonOK]: " + (expect == result));
    }

    public static void sameCountersThreeCharOK(){
        String input = "abc";
        boolean expect = true;
        boolean result = Main.isValid(input);
        System.out.println("[sameCountersThreeCharOK]: " + (expect == result));
    }

    public static void sameCountersThreeCharFirstOK(){
        String input = "aabc";
        boolean expect = true;
        boolean result = Main.isValid(input);
        System.out.println("[sameCountersThreeCharFirstOK]: " + (expect == result));
    }

    public static void sameCountersThreeCharSecondOK(){
        String input = "abbc";
        boolean expect = true;
        boolean result = Main.isValid(input);
        System.out.println("[sameCountersThreeCharSecondOK]: " + (expect == result));
    }

    public static void sameCountersThreeCharThirdOK(){
        String input = "abcc";
        boolean expect = true;
        boolean result = Main.isValid(input);
        System.out.println("[sameCountersThreeCharThirdOK]: " + (expect == result));
    }

    /**
     * Stranger case:
     * a -> 1
     * b -> 2
     * c -> 3
     *
     * if I reduce b, it's equal to a, afterwards, if reduce c, it's equals to a and.
     * but if compares a with c, without reduces, the result it's false, (3 - 1) == 1 -> false (I use this case)
     * */
    public static void differentCountersThreeCharNonOK(){
        String input = "abbccc";
        boolean expect = false;
        boolean result = Main.isValid(input);
        System.out.println("[differentCountersThreeCharNonOK]: " + (expect == result));
    }

    public static void differentCountersThreeCharRandomNonOK(){
        String input = "aaaaaabbbbbbbbbccc";
        boolean expect = false;
        boolean result = Main.isValid(input);
        System.out.println("[differentCountersThreeCharRandomNonOK]: " + (expect == result));
    }

    public static void sameCountersFourCharOK(){
        String input = "aaaabbbbccccdddd";
        boolean expect = true;
        boolean result = Main.isValid(input);
        System.out.println("[sameCountersFourCharOK]: " + (expect == result));
    }

    public static void sameCountersFourCharFirstOK(){
        String input = "aabcd";
        boolean expect = true;
        boolean result = Main.isValid(input);
        System.out.println("[sameCountersFourCharFirstOK]: " + (expect == result));
    }

    public static void sameCountersFourCharFirstNonOK(){
        String input = "aaabcd";
        boolean expect = false;
        boolean result = Main.isValid(input);
        System.out.println("[sameCountersFourCharFirstNonOK]: " + (expect == result));
    }

    /**
     * Stranger case:
     * a -> 2
     * b -> 1
     * c -> 2
     * d -> 1
     *
     * if reduce a, and compare with b, AFTERWARDS reduce c, and compare with d = true <- I use this case, is more logical for me.
     * if ONLY reduce a, and compare with b, a -> 1, b -> 1, c -> 2, d -> 1, = false
     * if ONLY reduce c, and compare with b, a -> 2, b -> 1, c -> 1, d -> 1, = false
     * */
    public static void sameCountersFourCharFirstAndThreeOK(){
        String input = "aabccd";
        boolean expect = true;
        boolean result = Main.isValid(input);
        System.out.println("[sameCountersFourCharFirstAndThreeOK]: " + (expect == result));
    }

    public static void sameCountersFourCharFirstAndThreeNonOK(){
        String input = "aabcccd";
        boolean expect = false;
        boolean result = Main.isValid(input);
        System.out.println("[sameCountersFourCharFirstAndThreeNonOK]: " + (expect == result));
    }

    public static void differentCountersFourCharNonOK(){
        String input = "aaabddddddddddddcccdbb";
        boolean expect = false;
        boolean result = Main.isValid(input);
        System.out.println("[differentCountersFourCharNonOK]: " + (expect == result));
    }

}
