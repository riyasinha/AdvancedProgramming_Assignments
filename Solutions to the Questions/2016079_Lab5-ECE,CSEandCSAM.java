package lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
import java.io.*;

/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    //static String next;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
    
    static String nextLine() throws IOException {
    	return reader.readLine();
    }
}

// Node class
class Node<T>
{
	T data;
	Node link;
	Node left;
	Node right;
	
	public Node()
	{
		data = null;
		link = null;
		left = null;
		right = null;
		
	}
	
	public Node(T dt)
	{
		data = dt;
	}
	
	public Node(T d, Node lk, Node l, Node r)
	{
		data = d;
		link = lk;
		left = l;
		right = r;
	}
	
	public T getData()
	{
		return data;
	}
	
	public void setData(T d)
	{
		this.data = d;
	}
	
	public Node getLink()
	{
		return link;
	}
	
	public void setLink(Node lk)
	{
		this.link = lk;
	}
	
	public Node getLeft()
	{
		return left;
	}
	
	public void setLeft(Node lk)
	{
		this.left = lk;
	}
	
	public Node getRight()
	{
		return right;
	}
	
	public void setRight(Node lk)
	{
		this.right = lk;
	}
	
	public int CompareTo(T obj)
	{
		int result =0;
		if(this.CompareTo(obj)>0)
		{
			result  = 1;
		}
		else if (this.CompareTo(obj)==0)
		{
			result =0;
		}
		else
		{
			result =-1;
		}
		
		return result;
		
	}
}

class BST <T extends Comparable<T>>
{
	Node<T> root;
	ArrayList<T> inorder;
	
	public BST()
	{
		root = null;
		inorder = new ArrayList<T>();
		
	}
	
	public void InOrder()
	{
		InOrder(root);
	}
	
	private void InOrder(Node<T> r)
	{
		if(r!=null)
		{
			InOrder(r.getLeft());
			inorder.add(r.getData());
			InOrder(r.getRight());
		}
		
	}
	
	public void insert(T data)
	   {
	      root = insert(root, data);
	   }
	
	private Node<T> insert(Node<T> p, T dt)
	{
		if (p == null)
			return new Node<T>(dt);

	    if (dt.compareTo(p.getData())== 0)
	      	return p;

	    if (dt.compareTo(p.getData()) < 0)
	         p.left = insert(p.left, dt);
	    else
	         p.right = insert(p.right, dt);

	    return p;
	   }
	
}

public class lab5 {
	
	//method to create the BST trees
	public static void createBSTFiles(int numStudents, int numTrees) 
	{
		Random rand = new Random();
		for (int i = 1; i <= numTrees; i++) 
		{
		    try 
		    {
				PrintWriter w = new PrintWriter("./src/" + i + ".txt", "UTF-8");
				int type = rand.nextInt(3) + 1;
				if(type == 1) 
				{
					w.println("Integer");
					w.println(numStudents);
					for (int j = 1; j <= numStudents; j++) 
					{
						w.print(rand.nextInt(1000));
						w.print(" ");
					}
				}
				else if(type == 2) 
				{
					w.println("Float");
					w.println(numStudents);
					for (int j = 1; j <= numStudents; j++) 
					{
						w.print(rand.nextFloat()*1000);
						w.print(" ");
					}
				}
				else 
				{
					w.println("String");
					w.println(numStudents);
					String alphabet = "abcdefghijklmnopqrstuvwxyz";
					for (int j = 1; j <= numStudents; j++) 
					{
						int len = rand.nextInt(10)+1;
						for (int k = 0; k < len; k++)
							w.print(alphabet.charAt(rand.nextInt(alphabet.length())));
						w.print(" ");
					}
				}
				w.close();
			} 
		    catch (Exception e) 
		    {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args)throws IOException
	{
		Reader.init(System.in);
		// x is the number of trees
		int x = Reader.nextInt();
		// n is the number of students
		int n = Reader.nextInt();
		
		createBSTFiles(n,x);
		
		ArrayList<BST<?>> tree = new ArrayList<BST<?>>();
		
		for(int i =0; i<x;i++)
		{
			String test_file_name = Integer.toString(i).concat(".txt");
			File f = new File("input\\" + test_file_name);
			BufferedReader  br  = new BufferedReader(new FileReader("file.txt"));
			String datatype = br.readLine();
			
			if(datatype.equals("String"))
			{
				BST<String> string_bst = new BST<String>();
				String str = br.readLine();
				int str2 = Integer.parseInt(str);
				
				if(str2!=n)
				{
					break;
				}
				String[] bst_val = br.readLine().split(" ");
				
				for(int j = 0;j<bst_val.length;j++){
					string_bst.insert(bst_val[j]);
				}
				tree.add(string_bst);								
			}
			else if(datatype.equals("Integer"))
			{
				BST<Integer> int_bst = new BST<Integer>();
				String str = br.readLine();
				int str2 = Integer.parseInt(str);
				
				if(str2!=n)
				{
					break;
				}
				String[] bst_val = br.readLine().split(" ");
				
				for(int j = 0;j<bst_val.length;j++){
					int integer = Integer.parseInt(bst_val[j]);
					int_bst.insert(integer);
				}
				tree.add(int_bst);
			}
			
			else if(datatype.equals("Float"))
			{
				BST<Float> float_bst = new BST<Float>();
				String str = br.readLine();
				int str2 = Integer.parseInt(str);
				
				if(str2!=n)
				{
					break;
				}
				String[] bst_val = br.readLine().split(" ");
				
				for(int j = 0;j<bst_val.length;j++){
					float integer = Float.parseFloat(bst_val[j]);
					float_bst.insert(integer);
				}
				tree.add(float_bst);
			}
		}
		
		
		
		//BufferedReader  br  = new BufferedReader(new FileReader("file.txt"));
	
		
		
		
	}
}
