// Link: https://www.geeksforgeeks.org/problems/maximum-meetings-in-one-room/1
// Time Complexity: O(NlogN)
// Space Complexity: O(N)

import java.util.*;

class Solution {
    static class Meeting {
        int start, end, index;

        Meeting(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    static class MeetingComparator implements Comparator<Meeting> {
        @Override
        public int compare(Meeting a, Meeting b) {
            if (a.end == b.end)
                return Integer.compare(a.start, b.start);
            return Integer.compare(a.end, b.end);
        }
    }

    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        ArrayList<Integer> out = new ArrayList<>();
        Meeting[] meetings = new Meeting[N];

        for (int i = 0; i < N; ++i)
            meetings[i] = new Meeting(S[i], F[i], i + 1);

        Arrays.sort(meetings, new MeetingComparator());

        int last = 0;
        for (Meeting meeting : meetings) {
            if (last < meeting.start) {
                last = meeting.end;
                out.add(meeting.index);
            }
        }
        
        Collections.sort(out);

        return out;
    }
}
 