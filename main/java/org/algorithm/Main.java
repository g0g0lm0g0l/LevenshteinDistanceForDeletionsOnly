package org.algorithm;

public class Main {
    public static void main(String[] args) {
        String origin = "test";
        String insertedByUser = "teeestttt";
        int result = LevenshteinDistance.computeLevenshteinDistanceDeletionsOnly(insertedByUser, origin);

        if (result > 0) {
            System.out.println(origin + " ???");
        } else {
            System.out.println("no possible solution");
        }
    }
}