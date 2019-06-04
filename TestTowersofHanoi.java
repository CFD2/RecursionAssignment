/**
 * Created by CFD2 on 10/7/17.
 */
public class TestTowersofHanoi {
    public int instructionNumber = 0;
    public static void main(String[] args) {
        TestTowersofHanoi towers = new TestTowersofHanoi();
        towers.solveTowers(3, 'L', 'R', 'M', towers.instructionNumber);
    }

    /**
     *
     * @param n a disk that we are currently operating with. (But it doesn't print properly)
     * @param source is a starting peg of the puzzle (usually the leftmost peg)
     * @param destination is the destination peg (usually the rightmost peg)
     * @param spare is the peg which is neither the starting peg nor the destination but is used for intermediate permutations
     * @param instructionNumber is a parameter to keep track of the step number while solving the puzlle
     * @return step number or it will be hard to keep track of properly
     */
    public static int solveTowers(int n, char source, char destination, char spare, int instructionNumber) {
        if (n == 1) {   //Base case. when the whole problem is isolated to having only one disc on the source peg
            instructionNumber++;
            System.out.println(instructionNumber + ". Disk " + n + " from " + source + " to " + destination);
            return instructionNumber;
        }

        instructionNumber = solveTowers(n - 1, source, spare, destination, instructionNumber);
        instructionNumber = solveTowers(1, source, destination, spare, instructionNumber);
        instructionNumber = solveTowers(n - 1, spare, destination, source, instructionNumber);

        return instructionNumber;
    }
}
