import org.algorithm.LevenshteinDistance;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LevenshteinDistanceTest {

    @Test
    void testCarrefour() {
        assertEquals(4, LevenshteinDistance.computeLevenshteinDistanceDeletionsOnly("Carrrrefffour", "Carrefour"));
    }

    @Test
    void testIdenticalStrings() {
        assertEquals(0, LevenshteinDistance.computeLevenshteinDistanceDeletionsOnly("abc", "abc"));
    }

    @Test
    void testEmptySecondString() {
        assertEquals(3, LevenshteinDistance.computeLevenshteinDistanceDeletionsOnly("abc", ""));
    }

    @Test
    void testEmptyFirstString() {
        assertEquals(0, LevenshteinDistance.computeLevenshteinDistanceDeletionsOnly("", "abc"));
    }

    @Test
    void testSecondStringLongerThanFirstString() {
        assertEquals(0, LevenshteinDistance.computeLevenshteinDistanceDeletionsOnly("abc", "abcdef"));
    }

    @Test
    void testLargeStrings() {
        String seqOne = "abcdefghij".repeat(100);
        String seqTwo = "abcde".repeat(100);
        assertEquals(500, LevenshteinDistance.computeLevenshteinDistanceDeletionsOnly(seqOne, seqTwo));
    }

    @Test
    void testSingleCharacterStrings() {
        assertEquals(1, LevenshteinDistance.computeLevenshteinDistanceDeletionsOnly("a", ""));
    }

    @Test
    void testStringsWithSpaces() {
        assertEquals(2, LevenshteinDistance.computeLevenshteinDistanceDeletionsOnly("a b c", "abc"));
    }
}
