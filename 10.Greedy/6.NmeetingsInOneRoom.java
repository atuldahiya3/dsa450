import java.util.Arrays;

class Solution666 {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    static class Meeting {
        int start, end;
        Meeting(int s, int e) {
            start = s;
            end = e;
        }
    }
    public int maxMeetings(int start[], int end[]) {
       Meeting[] meetings= new Meeting[start.length];
       for(int i=0;i<start.length;i++){
           meetings[i] = new Meeting(start[i], end[i]);
       }
       
       Arrays.sort(meetings, (a,b)->a.end-b.end);
       int count=1;
       int i=1;
       int prevEnd=meetings[0].end;
       while(i<start.length){
           if(meetings[i].start>prevEnd){
               prevEnd=meetings[i].end;
               count++;
           }
           i++;
       }
       return count;
    }
}
