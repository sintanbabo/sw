package pro.datastruct;

import java.util.PriorityQueue;

class Prisoner implements Comparable<Prisoner>{
	String name;
	int weight;
	
	Prisoner(String name, int weight)
	{
		this.name = name;
		this.weight = weight;
	}
	
	public int compareTo(Prisoner target) {
		if (this.weight > target.weight) return 1;
		else if (this.weight < target.weight) return -1;
		else return 0;
	}
}

public class PriorityQueueTest {
	public static void main(String[] args) {
		Prisoner prisoner1 = new Prisoner("james",5);
		Prisoner prisoner2 = new Prisoner("schofield",99);
		Prisoner prisoner3 = new Prisoner("alex",14);
		Prisoner prisoner4 = new Prisoner("silvia",10);
		Prisoner prisoner5 = new Prisoner("thomson",1);
		Prisoner prisoner6 = new Prisoner("sintanbab",1);
		
		PriorityQueue<Prisoner> priorityQueue = new PriorityQueue<Prisoner>();
		
		priorityQueue.offer(prisoner1);
		priorityQueue.offer(prisoner2);
		priorityQueue.offer(prisoner3);
		priorityQueue.offer(prisoner4);
		priorityQueue.offer(prisoner5);
		priorityQueue.offer(prisoner6);
		
		while(!priorityQueue.isEmpty())
		{
			Prisoner a = priorityQueue.poll();
			System.out.println(a.name);
		}
		
	}
	
}
