package Session1;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0 || numCourses < 1)
            return true;
        boolean[][] adjMatrix = new boolean[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++)
            adjMatrix[prerequisites[i][1]][prerequisites[i][0]] = true;
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++)
            if (!visited[i] && dfsCheckGraphCycle(i, numCourses, adjMatrix, visited, new boolean[numCourses]))
                return false;
        return true;
    }

    public static boolean dfsCheckGraphCycle(int i, int numCourses, boolean[][] adjMatrix, boolean[] visited, boolean[] traversed) {
        if (traversed[i]) return true;
        if (visited[i]) return false;
        visited[i] = traversed[i] = true;
        for (int j = 0; j < adjMatrix[i].length; j++)
            if (adjMatrix[i][j] && dfsCheckGraphCycle(j, numCourses, adjMatrix, visited, traversed))
                return true;
        traversed[i] = false;
        return false;
    }

    public static void main(String[] args) {
        //code
    }
}
