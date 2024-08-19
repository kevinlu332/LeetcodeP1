package KaratWoErMa;

import java.util.Arrays;

public class Meeting {
    public static boolean canSchedule(int[][] meetings, int start, int end) {
        for(int[] meeting: meetings){
            int meetingStart = meeting[0];
            int meetingEnd = meeting[1];
            if((start >= meetingStart && start < meetingEnd) || (end > meetingStart && end <= meetingEnd)
                    || (start < meetingStart && end > meetingEnd)) return false;
        }
        return true;
    }
}
