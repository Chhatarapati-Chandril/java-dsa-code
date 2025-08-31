// Given an array of jobs where every job has a deadline and profit if the job is finished before the deadline. 
// It is also given that every job takes a single unit of time, 
// so the minimum possible deadline for any job is 1.
//  Maximize the total profit if only one job can be scheduled at a time.

import java.util.*;

public class V10_JobSequence {

    public static class Job{
        int id;
        int deadline;
        int profit;
        public Job(int i, int d, int p){
            id = i;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String[] args) {
        int jobsInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        // sort by deadline ASC, then profit DESC
        Collections.sort(jobs, (a, b) -> {
            if (a.deadline == b.deadline)   return b.profit - a.profit; // profit descending
            else                            return a.deadline - b.deadline; // deadline ascending
        });


        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                seq.add(curr.id);
                ++time;
            }
        }
        System.out.println("Max number of jobs: " + seq.size());
        System.out.println(seq);
    }
}