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
        
        //posso iterare attraverso un enum. Season.values è un metodo che mi restitutisce l'array degli enum creati
        for (Season season: Season.values()) {
        	System.out.println(season.name() + " " + season.ordinal());
        }
        
        //il caso più utlizzato con gli enum è lo switch. Occhi che enum non è un int non posso mai fare Season.SUMMER == 2 !! non compilerebbe
        Season s = Season.SUMMER;
        switch (s) {
        case WINTER: System.out.println("inverno"); break;
        case SUMMER: System.out.println("estate"); break;
        default: System.out.println("what else?");
        }
    }
}
