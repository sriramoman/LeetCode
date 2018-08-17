package Session1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeightDriver {
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
                    }
                });
        List<int[]> result = new LinkedList<int[]>();
        for (int[] p : people)
            result.add(p[1], p);
        return result.toArray(people);
    }

    public static void main(String[] args) {
        //code
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] recon = reconstructQueue(people);
        Arrays.stream(recon).forEach(p -> System.out.print("(" + p[0] + "," + p[1] + "), "));
    }
}
