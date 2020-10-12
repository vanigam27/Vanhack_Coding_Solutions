import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusBorading {
	
	public static void main(String[] args) {
		int k = 2;
		List<Integer> p = new ArrayList();
		p.add(1);
		p.add(4);
		p.add(4);
		p.add(3);
		p.add(1);
		p.add(2);
		p.add(6);
		
		List<Integer> q = new ArrayList();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.add(6);
		q.add(7);
		
		
		List<Integer> result = BusBorading.getTheKthPerson(k, p, q);
		for (int ele : result)
			System.out.println(ele);
		
		
	}

	/*private static List<Integer> kthPerson(int k, List<Integer> p, List<Integer> q){
		List<Integer> peopleBoarded = new ArrayList(k);
		//[2,5,3] , [1,5] k = 3  //o(n2)---> o(n)/O(logn)
		//edge case
		int first = 0, int last = k-1;
		for (int wTime : q) {
			int countPpl = 0;
			/*for (int i=0 ; i<p.size(); i++) {
				if (p.get(i) < wTime)
					continue;
				else
				{
					if (countPpl < k) {
						countPpl++;
						if (countPpl == k) {
							peopleBoarded.add(i+1);
							break;
						}
					}
						
				}
			}*/
			
			/*while (countPpl != k || first != last) {
				if (p.get(first)<wTime  && first < last)
					first++;
				else if (p.get(first) >= wTime )
			}
			
			if (countPpl <k)
				peopleBoarded.add(0);
		}
		return peopleBoarded;
	}*/
	
	private static  List<Integer> getTheKthPerson(int k, List<Integer> p, List<Integer> q){ 
		List<Integer> result = new ArrayList();
		
		int first = 0, last = 1;
		for (int time: q) {
			int count = 0;
			first = 0;
			last = 1;
			while (first <p.size()) {
				if (p.get(first) < time) {
					first = last+1;
				}
				
				else 
				{
					if (p.get(first) >= time) {
						count++;
						if (count == k)
						{
							result.add(first+1);
							break;
						}
						
						else
							first = last+1;
					}
					
				}
				
				if (last <= p.size()-1 && p.get(last) < time) {
					last = first+1;
				}
				
				else {
					
					if (last <= p.size()-1 && p.get(last) >= time) {
						count++;
						if (count == k)
						{
							result.add(last+1);
							break;
						}
						
						else
							last = first+1;
					}
				}
			}
			
			if (count < k)
				result.add(0);
			
			
		}
		
		return result;
	}
	
	private static List<Integer> kthPerson(int k, List<Integer> p, List<Integer> q){
		List<Integer> peopleBoarded = new ArrayList();
	//	Map<Integer, Integer> checkMap= new HashMap();
	    int checkNum = 0;
		//Collections.sort(duplicate);
	  
	        for (int wTime : q) {
	            int countPpl = 0;
	           /* if (checkMap.containsKey(wTime)) {
	            	peopleBoarded.add(checkMap.get(wTime));
	            	continue;
	            }*/
	            
	            //count the number
	            if (checkNum != 0 && wTime >= checkNum) {
	            	peopleBoarded.add(0);
	            continue;
	        }
	            for (int i=0 ; i<p.size(); i++) {
	                if (p.get(i) < wTime)
	                    continue;
	                else
	                {
	                    if (countPpl < k) {
	                        countPpl++;
	                        if (countPpl == k) {
	                            peopleBoarded.add(i+1);
	                           // checkMap.put(wTime, i+1);
	                            break;
	                        }
	                    }
	                        
	                }
	            }
	            
	            if (countPpl <k) {
	            	  peopleBoarded.add(0);
	            	  if (checkNum == 0)
	            		  checkNum = wTime;
	            	 // checkMap.put(wTime, 0);
	            }
	              
	        }
	       
	        return peopleBoarded;
}
}
