package com.company;

import java.util.*;

public class HardChallengeN {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Graph<Integer> graph = new Graph1L<>();

        String[] nextLine;
        Integer[] castedStrings;
        do {
            int counter = 0;
            nextLine = input.nextLine().split(" ");

            castedStrings = new Integer[nextLine.length];
            for(String eachStrIndx : nextLine) {
                castedStrings[counter] = Integer.parseInt(eachStrIndx);
                counter++;
                if(castedStrings.length < 1) {
                  graph.add(castedStrings[0].);
                } else {
                  
                }
            }
        } while(castedStrings[0] != -1);
    }
}
