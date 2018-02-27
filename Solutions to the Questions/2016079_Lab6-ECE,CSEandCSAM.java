package lab06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

//import lab6.element;
class Reader 
{
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) 
    {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException 
    {
        while ( ! tokenizer.hasMoreTokens() ) 
        {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException 
    {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException 
    {
        return Double.parseDouble( next() );
    }
    
    static String nextLine() throws IOException 
    {
    	return reader.readLine();
    }
}

class NonCoordinateException extends Exception{
	public NonCoordinateException(String message){
		super(message);
	}
}

class OverlapException extends Exception{
	public OverlapException(String message){
		super(message);
	}
}

class StackEmptyException extends Exception{
	public StackEmptyException(String message){
		super(message);
	}
}

class QueenFoundException extends Exception{
	public QueenFoundException(String message){
		super(message);
	}
}

class element{
	String name;
	double x;
	double y;
	String value;
	
	public element(String n){
		name = n;
	}
	
}

class knight implements Comparable<knight>{
	String name;
	double x;
	double y;
	Stack<element> magbox;
	boolean state = true;
	
	public knight(){
		magbox = new Stack<element>();
	}

	public int compareTo(knight arg0) {
		// TODO Auto-generated method stub
		//return 0;
		if(this.name.compareTo(arg0.name)<0){
			return -1;
		}
		else{
			return 1;
		}
			
	}
	
	
	
}

public class lab06{
	
	static void emptyStack(ArrayList<knight> arr,int i) throws StackEmptyException{
		if(arr.get(i).magbox.isEmpty()){
			throw new StackEmptyException("StackEmptyException:​ ​Stack​ ​Empty​ ​exception​");
		}
	}
	
	static void foundQueen(double qx, double qy, double ex, double ey) throws QueenFoundException
	{
		if(qx==ex && qy==ey)
		{
			
			throw new QueenFoundException("QueenFoundException:​ ​Queen​ ​has​ ​been​ ​Found.​ ​Abort!​");
		}
	}
	
	static void NotCoordianate(element e) throws NonCoordinateException
	{
		if(!e.name.equals("Coordinate")){
			throw new NonCoordinateException("​NonCoordinateException: ​Not a coordinate Exception​"+" "+e.value);
		}
	}
	
	static void Overlapping(ArrayList<knight> k,knight x1, knight y1, int j) throws OverlapException
	{
		if(x1.x ==y1.x && x1.y == y1.y){
			k.get(j).state = false;
			k.remove(j);
			throw new OverlapException("OverlapException:​ ​Knights​ ​Overlap​ ​Exception​"+" "+x1.name);
		}
	}
	public static void main(String[] args) throws IOException, NonCoordinateException, StackEmptyException, QueenFoundException, OverlapException{
		Reader.init(System.in);
		
		int k_no = Reader.nextInt();
		int iter = Reader.nextInt();
		double qx= Reader.nextDouble();
		double qy = Reader.nextDouble();
		
		ArrayList<knight> arr = new ArrayList<knight>();
		
		PrintWriter pr = new PrintWriter("./src/" + "answer" + ".txt");
		for(int i = 1;i<=k_no;i++){
			//System.out.println("input loop");
			File file  = new File("./input/" + i+".txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			knight k = new knight();
			String nm = br.readLine();
			k.name = nm;
			
			String[] coord = br.readLine().split(" ");
			double x_k = Double.parseDouble(coord[0]);
			double y_k = Double.parseDouble(coord[1]);
			k.x = x_k;
			k.y = y_k;
			String m  = br.readLine();
			int mb = Integer.parseInt(m);
			
			for(int j =0;j<mb;j++){
				String[] ele = br.readLine().split(" ");
				String type = ele[0];
				if(type.equalsIgnoreCase("String")){
					element el1 = new element(ele[0]);
					el1.value = ele[1];
					k.magbox.push(el1);
				}
				if(type.equalsIgnoreCase( "Coordinate")){
					double co_x = Double.parseDouble(ele[1]);
					double co_y = Double.parseDouble(ele[2]);
					element el1 = new element(ele[0]);
					el1.x = co_x;
					el1.y = co_y;
					k.magbox.push(el1);
						
				}
				if(type.equalsIgnoreCase("Integer")){
					element el1 = new element(ele[0]);
					el1.value = ele[1];
					k.magbox.push(el1);
				}
				if(type.equalsIgnoreCase("Float")){
					element el1 = new element(ele[0]);
					el1.value = ele[1];
					k.magbox.push(el1);
				}
				
			}
			arr.add(k);
		}
		
		Collections.sort(arr);
		int flag =0;
		for(int t = 1;t<=iter;t++)
		{
			for(int i =0;i<arr.size();i++){
				try{
					pr.println(t+" "+ arr.get(i).name + " " + arr.get(i).x + " " + arr.get(i).y);
					emptyStack(arr,i);
					element e = arr.get(i).magbox.pop();
					NotCoordianate(e);
					
					foundQueen(qx,qy,e.x,e.y);
					
					arr.get(i).x=e.x;
					arr.get(i).y=e.y;
					for(int j = 0;j<arr.size();j++){
						if(j!=i){
							Overlapping(arr,arr.get(j),arr.get(i),j);
						}
					}
					pr.println("No​ ​exception"+" "+e.x+" "+e.y);
					arr.get(i).x=e.x;
					arr.get(i).y=e.y;
					
					
				}
				catch(NonCoordinateException e){
					pr.println(e.getMessage());
					//System.out.println(e.getMessage());
				}
				catch(StackEmptyException e){
					pr.println(e.getMessage());
					//System.out.println(e.getMessage());
				}
				catch(OverlapException e){
					pr.println(e.getMessage());
					//System.out.println(e.getMessage());
				}
				catch(QueenFoundException e){
					flag=1;
					pr.println(e.getMessage());
					//System.out.println(e.getMessage());
					break;
				}
			}
			if(flag == 1)
				break;
		}
		pr.close();
	}

}
