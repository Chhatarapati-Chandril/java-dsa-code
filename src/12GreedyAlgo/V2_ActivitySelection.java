// You are given n activities with their start and end times. 
// Select the maximum number of activities that can be performed by a single person, 
// assuming that a person can only work on a single activity at a time. 
// The activities are sorted according to end time.

import java.util.*;
// O(n)
public class V2_ActivitySelection {
    public static void main(String[] args) {
        // end time array is sorted
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        // sorting
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // lamda function: shortform
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        int maxActivities;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st activity
        maxActivities = 1;
        ans.add(activities[0][0]);
        int lastEnd = end[0];

        for (int i = 0; i < end.length; i++) {
            if (activities[i][1] >= lastEnd) {
                // select that activity
                ++maxActivities;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        System.out.println("Maximum Activities: " + maxActivities);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
    }
}