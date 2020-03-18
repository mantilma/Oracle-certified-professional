package ocp.chapter1.enums;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Season.values()));
        Season.SUMMER.getState();
        Season.SUMMER.printHours();
        Season.WINTER.printHours();
        Season.SUMMER.printItalianSeason();
        Season.WINTER.printItalianSeason();
    }
}
