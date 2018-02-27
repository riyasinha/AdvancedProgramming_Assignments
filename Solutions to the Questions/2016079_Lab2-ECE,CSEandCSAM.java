package lab2;

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
    
    static String nextLine() throws IOException {
    	return reader.readLine();
    }
}
   
class mess{
	double food_avail;
	double food_nut_val;
	double hygeine;
	double food_deli_del;
	
	public mess(double fa, double fnv, double h, double fdd){
		food_avail = fa;
		food_nut_val = fnv;
		hygeine = h;
		food_deli_del = fdd;
	}
	
	public mess better_mess(mess m1, mess m2){
		if(m1.food_avail>m2.food_avail){
			return m1;
		}
		
		else if(m1.food_avail==m2.food_avail){
			if(m1.food_nut_val>m2.food_nut_val){
				return m1;
			}
			if(m2.food_nut_val>m1.food_nut_val){
				return m2;
			}
			if(m2.food_nut_val==m1.food_nut_val){
				if(m1.food_deli_del>m2.food_deli_del){
					return m2;
				}
				else{
					return m1;
				}
			}
		}
		return m2;

	}
	
	
}

class hostel{
	double room_cond;
	double stud_fac;
	double cleanliness;
	double rec_fac;
	
	public hostel(double rc, double sf, double c, double rf){
		room_cond = rc;
		stud_fac = sf;
		cleanliness = c;
		rec_fac = rf;
	}
	
	
}

class library{
	double books_avail;
	double dig_fac;
	double sys_eff;
	
	public library(double ba, double df, double se){
		books_avail= ba;
		dig_fac= df;
		sys_eff = se;
	}
	
	
	/*public library better_lib(library ac1, library ac2){
		double avg1 = ac1.lib_avg();
		double avg2 = ac2.lib_avg();
		if(avg1>avg2){
			return ac1;
		}
		else{
			return ac2;
		}
	}*/
	
	
	
}

class academics{
	double know_imp;
	double dom_cov;
	double course_eff;
	
	public academics(double ki, double dc, double cf){
		know_imp = ki;
		dom_cov = dc;
		course_eff = cf;
	}
	
	public double avg_acad(){
		double avg = (know_imp+dom_cov)+ (course_eff*2);
		return avg;
	}
	
	public academics better_acad(academics ac1, academics ac2){
		double avg1 = ac1.avg_acad();
		double avg2 = ac2.avg_acad();
		if(avg1>avg2){
			return ac1;
		}
		else{
			return ac2;
		}
	}
	
}

class college{
	String name;
	mess mess;
	hostel hos;
	library lib;
	academics acad;
	int fees;
	String grade;;
	int rank;
	int input_rank;
	double weighted_rank;
	
	public college(String n, mess m, hostel h, library l, academics a, int f,String g, int r,int ir, double wr){
		name = n;
		mess = m;
		hos = h;
		lib = l;
		acad = a;
		fees = f;
		grade = g;
		rank = r;
		input_rank =ir;
		weighted_rank = wr;
	}
	
	
	
}




public class lab2 {
	
	public static mess better_mess(mess m1, mess m2){
		if(m1.food_avail>m2.food_avail){
			return m1;
		}
		
		else if(m1.food_avail==m2.food_avail){
			if(m1.food_nut_val>m2.food_nut_val){
				return m1;
			}
			if(m2.food_nut_val>m1.food_nut_val){
				return m2;
			}
			if(m2.food_nut_val==m1.food_nut_val){
				if(m1.food_deli_del>m2.food_deli_del){
					return m2;
				}
				else{
					return m1;
				}
			}
		}
		return m2;

	}
	
	public static hostel better_hostel(hostel h1, hostel h2){
		if(h1.room_cond>h2.room_cond){
			return h1;
		}
		else if(h1.room_cond==h2.room_cond){
			if(h1.stud_fac>h2.stud_fac){
				return h1;
			}
			else if(h1.stud_fac==h2.stud_fac){
				if(h1.cleanliness>h2.cleanliness){
					return h1;
				}
				else if(h1.cleanliness==h2.cleanliness){
					if(h1.rec_fac>h2.rec_fac){
						return h1;
					}
					else{
						return h2;
					}
				}
				else{
					return h2;
				}
			}
			
		}
		return h2;
		
	}
	
	public static double lib_avg(library l1){
		double avg = (l1.books_avail + l1.dig_fac + l1.sys_eff)/3;
		return avg;
	}
	
	public static double avg_acad(academics a1){
		double avg = a1.know_imp+a1.dom_cov+ (a1.course_eff*2);
		return avg;
	}
//	public static void arr_sort(college[] a1, college[] a2){
//		for(int i = 0;i<a1.length;i++){
//			String x  = a1[i].name;
//			
//		}
//	}
	
	public static void main (String[] args)throws IOException{
		Reader.init(System.in);
		int N = Reader.nextInt();
		
		college[] arr = new college[N];
		college[] mess_rank=new college[N] ;
		college[] hostel_rank = new college[N];
		college[] lib_rank = new college[N];
		college[] acad_rank = new college[N];
		
		int ir = 1;
		
		for(int i = 0; i<N; i++){
			
			String name = Reader.next();
			
			String n_mess = Reader.next();
			double m_fa = Reader.nextDouble();
			double m_fnv = Reader.nextDouble();
			double m_hm = Reader.nextDouble();
			double m_fdd = Reader.nextDouble();
			mess Mess = new mess(m_fa,m_fnv,m_hm,m_fdd);
			
			String n_hostel = Reader.next();
			double h_rc = Reader.nextDouble();
			double h_sf = Reader.nextDouble();
			double h_c = Reader.nextDouble();
			double h_rf = Reader.nextDouble();
			hostel Hostel = new hostel(h_rc,h_sf,h_c,h_rf);
			
			String n_lib = Reader.next();
			double l_ba = Reader.nextDouble();
			double l_df = Reader.nextDouble();
			double l_se = Reader.nextDouble();
			library Lib = new library(l_ba,l_df,l_se);
			
			String n_acad = Reader.next();
			double a_ki = Reader.nextDouble();
			double a_dc = Reader.nextDouble();
			double a_cse = Reader.nextDouble();
			academics Acad = new academics(a_ki,a_dc,a_cse);
			
			String n_fees = Reader.next();
			int Fees = Reader.nextInt();
			
			String n_grade = Reader.nextLine();
			//String Grade = Reader.next();
			
			college Coll = new college(name,Mess,Hostel,Lib,Acad,Fees,n_grade,0, ir,0);
			college Coll1=new college(name,Mess,Hostel,Lib,Acad,Fees,n_grade,0, ir,0);
			college Coll2=new college(name,Mess,Hostel,Lib,Acad,Fees,n_grade,0, ir,0);
			college Coll3=new college(name,Mess,Hostel,Lib,Acad,Fees,n_grade,0, ir,0);
			college Coll4=new college(name,Mess,Hostel,Lib,Acad,Fees,n_grade,0, ir,0);
			arr[i] = Coll;	
			mess_rank[i] = Coll1;
			hostel_rank[i] = Coll2;
			lib_rank[i] = Coll3;
			acad_rank[i] = Coll4;
			
			ir++;
		}
		for(int i = 0; i<N;i++){
			for(int j =1;j<N-i;j++){
				if(better_mess(mess_rank[j-1].mess,mess_rank[j].mess) == mess_rank[j-1].mess){
					college temp = mess_rank[j-1];
					mess_rank[j-1] = mess_rank[j];
					mess_rank[j] = temp;
				}
			}
		}
		
		int mr = N;
		for(int i= 0;i<N;i++){
			mess_rank[i].rank = mr;
			mr--;
		}
		
		for(int i = 0; i<N;i++){
			for(int j =1;j<N-i;j++){
				if(mess_rank[j-1].input_rank>mess_rank[j].input_rank){
					college temp = mess_rank[j-1];
					mess_rank[j-1] = mess_rank[j];
					mess_rank[j] = temp;
				}
			}
		}
		
//		System.out.println("mess");
//		for(int i =0;i<N;i++){
//			System.out.println(mess_rank[i].name+ " " + mess_rank[i].rank);
//		}
		for(int i =0;i<N;i++){
			for(int j =1;j<N-i;j++){
				if(better_hostel(hostel_rank[j-1].hos,hostel_rank[j].hos)==hostel_rank[j-1].hos){
					college temp = hostel_rank[j-1];
					hostel_rank[j-1] = hostel_rank[j];
					hostel_rank[j] = temp;
				}
			}
		}
		
		int hr = N;
		for(int i =0;i<N;i++){
			hostel_rank[i].rank = hr;
			hr--;
		}
		for(int i =0;i<N;i++){
			for(int j =1;j<N-i;j++){
				if(hostel_rank[j-1].input_rank>hostel_rank[j].input_rank){
					college temp = hostel_rank[j-1];
					hostel_rank[j-1] = hostel_rank[j];
					hostel_rank[j] = temp;
				}
			}
		}
//		System.out.println("hostel");
//		
//		for(int i = 0; i<N;i++){
//			System.out.println(hostel_rank[i].name+ " "+hostel_rank[i].rank +" " );
//		}
		for(int i=0;i<N;i++){
			for(int j =1;j<N-i;j++){
				if(lib_avg(lib_rank[j-1].lib)<lib_avg(lib_rank[j].lib)){
					college temp = lib_rank[j-1];
					lib_rank[j-1] = lib_rank[j];
					lib_rank[j] = temp;
				}
			}
		}
		
		
		int lr = 1;
		for(int i =0; i<N;i++){
			lib_rank[i].rank = lr;
			lr++;
		}
		
		for(int i=0;i<N;i++){
			for(int j =1;j<N-i;j++){
				if(lib_rank[j-1].input_rank>lib_rank[j].input_rank){
					college temp = lib_rank[j-1];
					lib_rank[j-1] = lib_rank[j];
					lib_rank[j] = temp;
				}
			}
		}
		
//		System.out.println("lib");
//		
//		for(int i = 0; i<N;i++){
//			System.out.println(lib_rank[i].name+ " "+lib_rank[i].rank +" " + lib_avg(lib_rank[i].lib));
//		}
		
		for(int i=0;i<N;i++){
			for(int j=1;j<N-i;j++){
				if(avg_acad(acad_rank[j-1].acad)<avg_acad(acad_rank[j].acad)){
					college temp = acad_rank[j-1];
					acad_rank[j-1] = acad_rank[j];
					acad_rank[j] = temp;
				}
			}
		}
		int ar = 1;
		for(int i = 0; i<N;i++){
			acad_rank[i].rank = ar;
			ar++;
		}
		for(int i=0;i<N;i++){
			for(int j=1;j<N-i;j++){
				if(acad_rank[j-1].input_rank>acad_rank[j].input_rank){
					college temp = acad_rank[j-1];
					acad_rank[j-1] = acad_rank[j];
					acad_rank[j] = temp;
				}
			}
		}
		
//		System.out.println("acad");
//		for(int i = 0; i<N;i++){
//			System.out.println(acad_rank[i].name+ " "+acad_rank[i].rank +" " );
//		}
		
		 //weighted_arr[] w = new weighted_arr[N];
		
		//int wr = 1;
		for(int i =0; i<N;i++){
			//w[i].name = arr[i].name;
			//w[i].input_rank = arr[i].input_rank;
			//System.out.println("mess"+mess_rank[i].rank +" college"+mess_rank[i].name);
			arr[i].weighted_rank = mess_rank[i].rank*0.25 + hostel_rank[i].rank*0.20 + lib_rank[i].rank*0.25 +acad_rank[i].rank*0.30;
		}
		
		
//		for(int i = 0; i<N;i++){
//			System.out.println(arr[i].name + " Mess rank:" + mess_rank[i].rank + " hostel rank:" + hostel_rank[i].rank + " lib rank:" + lib_rank[i].rank + " academic rank:" + acad_rank[i].rank + " weighted value:" + arr[i].weighted_rank);
//		}
		
//		System.out.println("weighted rank");
//		
//		
//		for(int i = 0; i<N;i++){
//			System.out.println(arr[i].name+ " "+arr[i].weighted_rank +" " );
//		}
		
		
		for(int i = 0; i<N;i++){
			for(int j =1; j<N-i;j++){
				if(arr[j-1].weighted_rank>arr[j].weighted_rank){
					college temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] =temp;
				}
			}
		}
		
//		System.out.println("weighted rank");
//		
//		
//		for(int i = 0; i<N;i++){
//			System.out.println(arr[i].name+ " "+arr[i].weighted_rank +" " );
//		}
		
		
		for(int i = 0; i<N-1;i++){
		if(arr[i].weighted_rank==arr[i+1].weighted_rank){
			if(arr[i].fees>arr[i+1].fees){
				college temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
			if(arr[i].fees==arr[i+1].fees){
				int l = arr[i].grade.compareTo(arr[i+1].grade);
				if(l>0){
					college temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					
				}
			}
		}
	}

		//System.out.println("final");
		for(int i =0;i<N;i++){
			System.out.println(arr[i].name);
		}
		
		
		
		
	}
}

