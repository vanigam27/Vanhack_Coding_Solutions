import java.util.List;
import java.util.Map;

import java.util.Iterator;

import java.util.ArrayList;
import java.util.HashMap;

//program to calculate the max# of meetings..
public class MaxMeeting {

	public static void main(String[] args) {
		MaxMeeting obj = new MaxMeeting();
		List<Integer> first = new ArrayList();
		first.add(1);
		first.add(1);
		first.add(2);
		//first.add(5);
		
		List<Integer> last = new ArrayList();
		last.add(1);
		last.add(2);
		last.add(2);
		//last.add(5);
		
		int meets = obj.numOfMeets(first, last);
		
	    System.out.println(meets);
		
	}
	
	private int numOfMeets (List<Integer> firstDay, List<Integer> lastDay) {
		 int totalMeetings = 0;
		 boolean[] invstMet = new boolean[firstDay.size()];
		
		 //get the min of the firstArray
		 int min = firstDay.get(0);
	      for (int ele : firstDay){
	          if (min <= ele)
	             continue;
	           else
	              min = ele;
	      }
	      
	    //  System.out.println(min);
	      
	      //get the max of the lastDays
	      int max = lastDay.get(0);
	      for (int ele : lastDay){
	          if (max >= ele)
	             continue;
	           else
	              max = ele;
	      }
	   
	      while (min <= max) {
	    	  int count = 0;
	    	  int temp = -1;
	    	  while (count <= firstDay.size()-1) { //min =3-----> 1,1,3,5 & 4,1,4,5
	    		  if (firstDay.get(count) == min && lastDay.get(count) == min) {
		    		  temp = count;
		    		  break;
		    	  }
	    		  
	    		  else if (firstDay.get(count) == min && lastDay.get(count) >min)
	    		  {
	    			  if (temp == -1)
	    				  temp = count;
	    		  }
	    		  
	    		  else if (firstDay.get(count) > min) {
	    			  count++;
	    			  continue;
	    		  }
	    		  
	    		  else if (firstDay.get(count) < min && lastDay.get(count) >=min) {
	    			  
	    			  if (invstMet[count] == true)
	    			  {
	    				  count++;
	    				  continue;
	    			  }
	    				  
	    			  
	    			  if (temp == -1)
	    				  temp = count;
	    			  
	    		  }
	    		  
	    		  else if (firstDay.get(count) < min && lastDay.get(count) < min) {
	    			  count++;
	    			  continue;
	    		  }
	    			  
	    		  
	    		  count++;
	    	}
	    	  min++;
	    	  if (temp != -1) {
	    		  invstMet[temp] = true;
	    		  totalMeetings++;
	    	  }
	    	   
	    	 
	    	  
	    	  
	      }

		 return totalMeetings;
	}
}
