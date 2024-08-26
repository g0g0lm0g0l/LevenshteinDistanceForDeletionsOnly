package org.algorithm;

/*
    Levenshtein distance with the deletion operation is only needed
 */
public class LevenshteinDistance {

    public static int computeLevenshteinDistanceDeletionsOnly(String seqOne, String seqTwo) {
        if (seqTwo.isEmpty())
            return (seqOne.length());

        if (seqOne.isEmpty())
            return (0);

        int lengthOne = seqOne.length();
        int lengthTwo = seqTwo.length();

        int[][] distanceMatrix = new int[lengthOne + 1][lengthTwo + 1];

        for (int i = 0; i <= lengthOne; ++i)    //  Deletions only
            distanceMatrix[i][0] = i;

        for (int i = 1; i <= lengthOne; ++i) {
            for (int j = 1; j <= lengthTwo; ++j) {
                if (seqOne.charAt(i - 1) == seqTwo.charAt(j - 1)) {
                    distanceMatrix[i][j] = distanceMatrix[i - 1][j - 1];
                } else {
                    distanceMatrix[i][j] = distanceMatrix[i - 1][j] + 1;
                }
            }
        }

        int deletions = distanceMatrix[lengthOne][lengthTwo];

        int i = 0, j = 0;
        while (i < lengthOne && j < lengthTwo) {
            if (seqOne.charAt(i) == seqTwo.charAt(j)) {
                j++;
            }
            i++;
        }

        return (j == lengthTwo) ? deletions : 0;
    }

}
