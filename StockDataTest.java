import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StockDataTest {

	public static void main(String[] args) {
	  int[] stock = new int[] {5,6,8,4,9,10,8,3,6,4};
	  
	  List<Integer> stockdata = new ArrayList();	
	 stockdata.add(5);
	 stockdata.add(6);
	 stockdata.add(8);
	 stockdata.add(4);
	 stockdata.add(9);
	 stockdata.add(10);
	 stockdata.add(8);
	 stockdata.add(3);
	 stockdata.add(6);
	 stockdata.add(4);
	  int[] days = new int[] {3,1,8};
	  List<Integer> queries = new ArrayList();
	  queries.add(3);
	  queries.add(1);
	  queries.add(8);
	  //for (int ele : queries)
		//  System.out.println(ele);
	 List<Integer> result = StockDataTest.predictAnswerTwoPointerApr(stockdata, queries);
	 for (int num: result)
		 System.out.println(num);
	}
	
	private static List<Integer> predictAnswer(List<Integer> stockData, List<Integer> queries){
		 List<Integer> daysList = new ArrayList<>();
		
		    for (int i=0; i<queries.size(); i++){
		    	int day = queries.get(i);
		        //get the price on that day
		        int price = stockData.get(day-1);

		        //go through the stock data to get the days which has a smaller 
		        //price
		       // List<Integer> temp = new ArrayList<>();
		        //5,6,8,4,9,10,8,3,6,4
		        int count = 1, dist = 0, tempday = 0; 
		        List<Integer> dayNum = new ArrayList<>();
		        for (int data : stockData){
		            if (data >= price){
		                count++;
		                continue;
		            }
		            else{
		                int distance = Math.abs(day - count);
		                if (distance == 0)
		                   continue;
		                else if (dist == 0 && distance != 0)
		                {
		                   dist = distance;
		                   tempday = count;
		                }
		                   
		                else if (dist > distance){
		                    dist = distance;
		                    tempday = count;
		                }
		                
		                else if (dist < distance){
		                    count++;
		                    continue;
		                }
		                
		                else if (dist == distance)
		                  {
		                      if (tempday >count)
		                       tempday = count;

		                       else
		                          continue;
		                  }

		            }

		            if (tempday != 0)
		              daysList.add(tempday);
		            else
		              daysList.add(-1);
		        }
		         
		    }
		    return daysList;
	}
	
	private static List<Integer> predictAnswerTwoPointer (List<Integer> stockData, List<Integer> queries){
		//5,6,8,4,9,10,8,3,6,4}
		//3,1,8
		int ltIdx = -1, rtIdx = -1;
		int ltptr =-1, rtptr = -1;
		List<Integer> resultList = new ArrayList();
		
	    for (int day: queries) {
	    	int price = stockData.get(day-1);
	    	ltptr = day-2;
	    	rtptr = day;
	    	//edge cases 
	    	//if day is the first day
	    	if (day == 1) {
	    		while (rtptr < stockData.size()) {
	    			if (stockData.get(rtptr) < price)
	    			{
	    				rtIdx = rtptr + 1;
	    				break;
	    			}
	    			else
	    				rtptr++;
	    		}
	    	}
	    	
	    	else if (day == stockData.size()+1) {
	    		while (ltptr >=0) {
	    			if (stockData.get(ltptr) < price) {
	    				ltIdx = ltptr+1;
	    				break;
	    			}
	    			else
	    				ltptr--;
	    		}
	    	}
	    	else {
	    		while (ltptr >=0 || rtptr <stockData.size()) {
		    		if (stockData.get(ltptr) > price && stockData.get(rtptr) > price)
		    		{
		    			ltptr--;
		    			rtptr++;
		    			
		    		}
		    		else {
		    			if (stockData.get(ltptr) < price) {
			    			if (ltIdx == -1)
			    			   ltIdx = ltptr+1;
			    			ltptr--;
			    		}
		    			else {
		    				ltptr --;
		    			}
		    			
		    			if (stockData.get(rtptr) < price) {
		    				if (rtIdx == -1)
			    			   rtIdx = rtptr + 1;
		    				rtptr++;
			    		}
		    			
		    			else
		    				rtptr++;
		    		}
		       }
	    	}
	    	
	    	
	    	if (ltIdx != -1 && rtIdx != -1) {
	    		int ltdis = day - ltIdx;
	    		int rtdis = rtIdx - day;
	    		
	    		if (ltdis < rtdis)
	    			resultList.add(ltIdx);
	    		else if (ltdis > rtdis)
	    			resultList.add(rtIdx);
	    		else if (ltdis == rtdis)
	    			resultList.add(ltIdx);
	    	}
	    	else if (ltIdx == -1 && rtIdx != -1)
	    		resultList.add(rtIdx);
	    	else if (ltIdx != -1 && rtIdx == -1)
                resultList.add(ltIdx);
	    	else if (ltIdx == -1 && rtIdx == -1)
	    		resultList.add(-1);
	    	
	    	ltIdx = -1;
	    	rtIdx = -1;
	    	
	   }
		return resultList;
	}
	
	
	private static List<Integer> predictAnswerTwoPointerApr (List<Integer> stockData, List<Integer> queries){
		int ltIdx = -1, rtIdx = -1;
		int ltptr =-1, rtptr = -1;
		List<Integer> resultList = new ArrayList();
		
		 for (int day: queries) {
		    	int price = stockData.get(day-1);
		    	ltptr = day-2;
		    	rtptr = day;
		    	//edge cases 
		    	//if day is the first day
		    	if (day == 1) {
		    		while (rtptr < stockData.size()) {
		    			if (stockData.get(rtptr) < price)
		    			{
		    				rtIdx = rtptr + 1;
		    				break;
		    			}
		    			else
		    				rtptr++;
		    		}
		    	}
		    	
		    	else if (day == stockData.size()+1) {
		    		while (ltptr >=0) {
		    			if (stockData.get(ltptr) < price) {
		    				ltIdx = ltptr+1;
		    				break;
		    			}
		    			else
		    				ltptr--;
		    		}
		    	}
		    	else {
		    		 while (ltptr >=0) {
		    			 if (stockData.get(ltptr) >= price)
		    				 ltptr --;
		    			 else {
		    				 ltIdx = ltptr+1;
		    				 break;
		    			 }
		    		 }
		    		 
		    		 while (rtptr < stockData.size()) {
		    			 if (stockData.get(rtptr) >= price)
		    				 rtptr ++;
		    			 else {
		    				 rtIdx = rtptr+1;
		    				 break;
		    			 }
		    		 }
		    	}
		    	
		    	
		    	if (ltIdx != -1 && rtIdx != -1) {
		    		int ltdis = day - ltIdx;
		    		int rtdis = rtIdx - day;
		    		
		    		if (ltdis < rtdis)
		    			resultList.add(ltIdx);
		    		else if (ltdis > rtdis)
		    			resultList.add(rtIdx);
		    		else if (ltdis == rtdis)
		    			resultList.add(ltIdx);
		    	}
		    	else if (ltIdx == -1 && rtIdx != -1)
		    		resultList.add(rtIdx);
		    	else if (ltIdx != -1 && rtIdx == -1)
	                resultList.add(ltIdx);
		    	else if (ltIdx == -1 && rtIdx == -1)
		    		resultList.add(-1);
		    	
		    	ltIdx = -1;
		    	rtIdx = -1;
		    	
		   }
		
		return resultList;
	}
	
	private static List<Integer> prediction (List<Integer> stockData, List<Integer> queries){
		int ltIdx = -1, rtIdx = -1;
		int ltptr =-1, rtptr = -1;
		List<Integer> resultList = new ArrayList();
		
		 for (int day: queries) {
		    	int price = stockData.get(day-1);
		    	ltptr = day-2;
		    	rtptr = day;
		    	//edge cases 
		    	//if day is the first day
		    	if (day == 1) {
		    		while (rtptr < stockData.size()) {
		    			if (stockData.get(rtptr) < price)
		    			{
		    				rtIdx = rtptr + 1;
		    				break;
		    			}
		    			else
		    				rtptr++;
		    		}
		    	}
		    	
		    	else if (day == stockData.size()+1) {
		    		while (ltptr >=0) {
		    			if (stockData.get(ltptr) < price) {
		    				ltIdx = ltptr+1;
		    				break;
		    			}
		    			else
		    				ltptr--;
		    		}
		    	}
		    	else {
		    		while (ltptr >=0 && rtptr <stockData.size()) {
		    			if (stockData.get(ltptr) >= price && stockData.get(rtptr) >= price)
		    			{
		    				ltptr--; rtptr++;
		    			}
		    			
		    			else if (stockData.get(ltptr) < price && stockData.get(rtptr) < price) {
		    				ltIdx = ltptr+1;
		    				rtIdx = rtptr+1;
		    				break;
		    			}
		    			
		    			else if (stockData.get(ltptr) < price && stockData.get(rtptr) >= price) {
		    				if (ltIdx == -1) {
		    					ltIdx = ltptr+1;
		    					rtptr++;
		    					break;
		    				}
		    					
		    		    }
		    			
		    			else if (stockData.get(rtptr) < price && stockData.get(ltptr) >=price) {
		    				if (rtIdx == -1) {
		    					rtIdx = rtptr+1;
		    					ltptr--;
		    					break;
		    				}
		    				
		    			}
		    		}
		    		
		    		if (ltIdx == -1 && ltptr >= 0) {
		    			while (ltptr >=0) {
		    				if (stockData.get(ltptr) < price) {
		    					ltIdx = ltptr+1;
		    					 break;
		    				}
		    				else
		    					ltptr--;
		    			}
		    		}
		    		
		    		if (rtIdx == -1 && rtptr <stockData.size()) {
		    			while (rtptr <stockData.size()) {
		    				if (stockData.get(rtptr) < price) {
		    					rtIdx = rtptr+1;
		    					 break;
		    				}
		    				else
		    					rtptr++;
		    			}
		    			
		    		}
		    	}
		    	
		    	
		    	if (ltIdx != -1 && rtIdx != -1) {
		    		int ltdis = day - ltIdx;
		    		int rtdis = rtIdx - day;
		    		
		    		if (ltdis < rtdis)
		    			resultList.add(ltIdx);
		    		else if (ltdis > rtdis)
		    			resultList.add(rtIdx);
		    		else if (ltdis == rtdis)
		    			resultList.add(ltIdx);
		    	}
		    	else if (ltIdx == -1 && rtIdx != -1)
		    		resultList.add(rtIdx);
		    	else if (ltIdx != -1 && rtIdx == -1)
	                resultList.add(ltIdx);
		    	else if (ltIdx == -1 && rtIdx == -1)
		    		resultList.add(-1);
		    	
		    	ltIdx = -1;
		    	rtIdx = -1;
		    	
		   }
		
		return resultList;
	}
}
