package lab8;
import java.util.HashMap;
import java.util.concurrent.*;

import com.sun.javafx.collections.MappingChange.Map;

public class lab08 extends RecursiveAction{

	int n;
	int k;
	int result;
	
	public lab08(int _n,int _k) 
	{
		n = _n;
		k = _k;
		
		
	}
	public void compute() {
		
		
		if(n==0 || k==0 || n==k)
		{
			this.result=1 ;
			return;
		}
		
		lab08 left = new lab08(n-1 ,k-1);
		lab08 right = new lab08(n-1,k);
		left.fork();
		right.compute();
		left.join();
		result = left.result + right.result;
	}
	
	public static void main(String[] args) {
//		ForkJoinPool pool = new ForkJoinPool(2);
//		lab08 task = new lab08(5,2);
//		
//		
//		
//		pool.invoke(task);
//		
//		int result = task.result;
//		System.out.println("Q1 result = "+result);

		
		
		long t1 = System.currentTimeMillis();
		ForkJoinPool pool2 = new ForkJoinPool(2);
		FlyWeight task2 = new FlyWeight(120,50);
		pool2.invoke(task2);
		long t2 = System.currentTimeMillis()-t1;
		System.out.println("time for pool size 2 = " +t2);
		long result2 =task2.result;
		
		System.out.println("pool 2 result =" + result2);
		
		long t1_1 = System.currentTimeMillis();
		ForkJoinPool pool1 = new ForkJoinPool(1);
		//FlyWeight task2 = new FlyWeight(5,2);
		pool2.invoke(task2);
		long t2_1 = System.currentTimeMillis()-t1_1;
		System.out.println("time for pool size 1 = " +t2_1);
		long result1 =task2.result;
		
		System.out.println("pool 1 result =" + result1);
		
		
		long t1_3 = System.currentTimeMillis();
		ForkJoinPool pool3 = new ForkJoinPool(3);
		//FlyWeight task2 = new FlyWeight(5,2);
		pool2.invoke(task2);
		long t2_3 = System.currentTimeMillis()-t1;
		System.out.println("time for pool size 3 = " +t2_3);
		long result3 =task2.result;
		
		System.out.println("Q2 result =" + result3);
		
	}
	
	
}


class FlyWeight extends RecursiveAction{
	 static volatile HashMap<String, FlyWeight> instances = new HashMap<String, FlyWeight>();
	
	public static FlyWeight getInstance(int n, int k)
	{
		String key = n+ " , "+k;
		if(!instances.containsKey(key)) {
			instances.put(key, new FlyWeight(n,k));
			
		}
		return instances.get(key);
		
		
	}
	
	private int n, k;
	long result;
	
	FlyWeight(int n, int k) {
		this.n = n;
		this.k = k;
	}
public synchronized void compute() {
		
		
		if(n==0 || k==0 || n==k)
		{
			this.result=1 ;
			return;
		}
		
		FlyWeight left = getInstance(n-1 ,k-1);
		FlyWeight right = getInstance(n-1,k);
		left.fork();
		right.compute();
		left.join();
		result = left.result + right.result;
	}
	
	
	
}

