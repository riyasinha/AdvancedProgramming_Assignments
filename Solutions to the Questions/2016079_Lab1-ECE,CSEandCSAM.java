package lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;


/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

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
}

class studentDetails{
	String name;
	String rollnumber;
	String program;
	int distance;
	int orderno;
	
	public studentDetails(String n, String rn, String pr, int d,int no){
		name = n;
		rollnumber = rn;
		program = pr;
		distance = d;
		orderno = no;
	}
	
	
	
}



public class lab1 {
	public static void main(String[] args)throws IOException{
		Reader.init(System.in);
		int n = Reader.nextInt();
		int m = Reader.nextInt();
		
		studentDetails[] arr = new studentDetails[n];
		
		int no = 1;
		
		for(int i = 0;i<n;i++){
			studentDetails student = new studentDetails(Reader.next(),Reader.next(),Reader.next(),Reader.nextInt(),no);
			
			arr[i]=student;
			no++;
		}
			
		studentDetails[] phd = new studentDetails[n];
		studentDetails[] pg = new studentDetails[n];
		studentDetails[] ug = new studentDetails[n];
		
		int phdcount = 0;
		int pgcount = 0;
		int ugcount = 0;
		
		for (int i = 0; i<n;i++){
			if(arr[i].program.equalsIgnoreCase("phd")){
				//System.out.println("fgag");
				phd[phdcount] = arr[i];
				phdcount++;
			}
			else if(arr[i].program.equalsIgnoreCase("pg")){
				pg[pgcount] = arr[i];
				pgcount++;
			}
			else if(arr[i].program.equalsIgnoreCase("ug")){
				ug[ugcount] = arr[i];
				ugcount++;
			}
		}
		//System.out.println(phdcount);
		
		//for(int i =0; i<phdcount;i++){
			//System.out.println(phd[0].name+" "+phd[0].rollnumber+" "+phd[0].program+" "+phd[0].distance);
		//}
		
		 for(int i=0; i < phdcount; i++){
             for(int j=1; j < phdcount-i; j++){  
            	// System.out.println("chn");
                      if(phd[j-1].distance < phd[j].distance){  
                    	  //System.out.println("gd");
                             //swap elements  
                             studentDetails temp = phd[j-1];  
                             phd[j-1]= phd[j];  
                             
                             phd[j] = temp;  
                     }  
                      
             }  
		 } 
		 
//		 for(int i =0; i<phdcount;i++){
//				System.out.println(phd[i].name+" "+phd[i].rollnumber+" "+phd[i].program+" "+phd[i].distance);
//			}
		for(int i=0; i < pgcount; i++){  
		             for(int j=1; j < pgcount-i; j++){  
		                      if(pg[j-1].distance < pg[j].distance){  
		                             //swap elements  
		                             studentDetails temp = pg[j-1];  
		                             pg[j-1]= pg[j];  
		                             pg[j] = temp;  
		                     }  
		                      
		             }  
		     } 
//		for(int i =0; i<pgcount;i++){
//			System.out.println(pg[i].name+" "+pg[i].rollnumber+" "+pg[i].program+" "+pg[i].distance);
//		}
		for(int i=0; i < ugcount; i++){
		    for(int j=1; j < ugcount-i; j++){  
		             if(ug[j-1].distance < ug[j].distance){  
		                    //swap elements  
		                    studentDetails temp = ug[j-1];  
		                    ug[j-1]= ug[j];  
		                    ug[j] = temp;  
		            }  
		             
		    }  
		}
//		for(int i =0; i<ugcount;i++){
//			System.out.println(ug[i].name+" "+ug[i].rollnumber+" "+ug[i].program+" "+ug[i].distance);
//		}

	studentDetails[] hostel = new studentDetails[m];
	int l = 0;
	if(phdcount>(m-(m/2))){
		for(int i=0;i<(m-(m/2));i++){
			hostel[i]=phd[l];
			l++;
		}
	}
	else{
		for(int i= 0;i<phdcount;i++){
			hostel[i]=phd[l];
			l++;
		}
	}
	
	int k = 0;
	if(pgcount>m/2){
		for(int i=l;i<m/2+l;i++){
			hostel[i]=pg[k];
			k++;
		}
	}
	else if (pgcount<=m/2){
		for(int i=l;i<phdcount+l;i++){
			hostel[i]=pg[k];
			k++;
		}
	}
	int z =0;
	if(l+k<m){
		for(int i =l+k;i<m;i++){
			hostel[i]= ug[z];
			z++;
		}
	}
	
	
	for(int i=0; i < m; i++){
	    for(int j=1; j < m-i; j++){  
	             if(hostel[j-1].orderno > hostel[j].orderno){  
	                    //swap elements  
	                    studentDetails temp = hostel[j-1];  
	                    hostel[j-1]= hostel[j];  
	                    hostel[j] = temp;  
	            }  
	             
	    }  
	}
	for(int i =0; i<m;i++){
		System.out.println(hostel[i].name+" "+hostel[i].rollnumber+" "+hostel[i].program+" "+hostel[i].distance);
	}
}}
