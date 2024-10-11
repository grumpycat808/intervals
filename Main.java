package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] testData = {{1,3},   {4, 6},{4, 5}, {5, 5}, {0, 2},  };
//		int[][] testData = {{0,3}, {4, 6}, {5, 5}};
		sortMultiArray(testData);
		for (int i = 0; i < testData.length; i++) {
			System.out.println(Arrays.toString(testData[i]));
		}
		System.out.println("Merging");
		int[][] mergedIntervals = merge(testData);
		
		for (int i = 0; i < mergedIntervals.length; i++) {
			System.out.println(Arrays.toString(mergedIntervals[i]));
		}
	}
	
	public static int[][] merge(int[][] intervals) {
		sortMultiArray(intervals);
		List<int[]> returnList = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; i++) {
        	int ceiling = intervals[i][1];
        	int counter = 0;
			while(counter+i +1 < intervals.length && ceiling >= intervals[i+counter +1][0]) {
				ceiling = intervals[i][1] >= intervals[i+counter +1][1] ? intervals[i][1] : intervals[i+counter +1][1];
				counter++;
				
			}
			int[] newInterval = new int[2];
			newInterval[0] = intervals[i][0];
			newInterval[1] = intervals[i + counter][1] >= intervals[i][1] ? intervals[i + counter][1] :intervals[i][1] ;
			returnList.add(newInterval);
			i = i + counter;
		}
        
        
        int[][] returnArray = new int[returnList.size()][2];
        
        for (int i = 0; i < returnArray.length; i++) {
			returnArray[i] = returnList.get(i);
		}
		return returnArray;
    }
	public static void sortMultiArray(int[][] inputArray) {
		Arrays.sort(inputArray, new Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		    	if(a[0] - b[0] == 0) {
		    		return a[1] - b[1];
		    	} else {
		    		return a[0] - b[0];
		    	}
		    }
		});
	}

}
