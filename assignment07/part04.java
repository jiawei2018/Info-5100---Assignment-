package assignment07;

import java.util.*;

public class part04 {

/*	Given a set of time intervals in any order, merge all overlapping
	intervals into one and output the result which should have only mutually
	exclusive intervals. Let the intervals be represented as pairs of integers
	for simplicity.
	For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }.
	The intervals {1,3} and {2,4} overlap with each other, so they should be
	merged and become {1, 4}. Similarly {5, 7} and {6, 8} should be merged
	and become {5, 8}
	Write a function which produces the set of merged intervals for the given
	set of intervals.(score 2)*/
	
	
	public static void main(String args[]) {
		
/*		List<Interval>  t1 = new ArrayList<Interval>();
		Interval a1 = new Interval(1,3);
		Interval a2 = new Interval(2,4);
		Interval a3 = new Interval(5,7);
		Interval a4 = new Interval(6,8);
		
		
		t1.add(a1);
		t1.add(a2);
		t1.add(a3);
		t1.add(a4);
		
		part04 tt= new part04();
		tt.merge(t1);
		System.out.println("============================");
		part04.show(t1);
		System.out.println("============================");*/
		
	}
	
/*	public static  void show(List<Interval> intervals) {
		for(Interval i:intervals) {
			System.out.println(i.start+","+i.end);
		}
	}*/
	
	public List<Interval> merge(List<Interval> intervals) {
		boolean q = true;
		int i=0;
		while( q) {
			if(intervals.get(i).end >intervals.get(i+1).start ) {
				Interval tmp = new Interval();  
				tmp.start = intervals.get(i).start;
				tmp.end = intervals.get(i+1).end;
				intervals.add(i,tmp);
				intervals.remove(i+1); //remove the former "i"
				intervals.remove(i+1);//remove the  former "i+1"
			}
			if(i+1 >= intervals.size()-1) break;
			i++;
		}//while
		return intervals;
	}
}

  class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }