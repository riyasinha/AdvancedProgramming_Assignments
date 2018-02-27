
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
import java.util.Random;

/** Class for buffered reading double and double values */
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

    static double nextInt() throws IOException 
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

abstract class Animal implements Comparable<Animal>
{
	double _x;
	double _y;
	double time_stamp;
	double health;
        String name;
        double count=0;
        
	public Animal(double x, double y, double ts, double h)
        {
		_x= x;
		_y=-y;
		time_stamp = ts;
		health = h;
	}
        
        public int compareTo(Animal a1)
        {
            int answer =0;
            if(this.time_stamp>a1.time_stamp)
            {
                answer=1;
            }
            else if(time_stamp==a1.time_stamp)
            {
                if(this.health> a1.health)
                {
                    answer=1;                    
                }
                else if(this.health==a1.health)
                {
                    if(this.getClass().getSimpleName().equals("Herbivore"))
                    {
                        answer=1;
                    }
                    else if(this.getClass().getSimpleName().equals("Herbivore")==a1.getClass().getSimpleName().equals("Herbivore"))
                    {
                        if(Math.sqrt((Math.pow( this._x,2)+Math.pow(this._y,2)))>Math.sqrt((Math.pow(a1._x,2)+Math.pow(a1._y,2))))
                        {
                            answer=1;
                        }
                        else 
                        {
                        answer=-1;
                        }
                    }
                    else
                    {
                        answer=-1;
                    }                    
                }
                else
                {
                    answer= -1;
                }                
            }
            else
            {
                answer=-1;
            }
            return answer;
        }
        
      public abstract void takeTurn(Grassland g1, Grassland g2, boolean flag);
      
      public abstract void Turns_number();

//    void takeTurn(Grassland g1,Grassland g2, boolean flag) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
        
}


class Herbivore extends Animal
{
	double grass_capacity;
        Carnivore nearest;
	public Herbivore(double x, double y, double ts, double h, double gc) 
        {
		super(x, y, ts, h);
		//double grass_capacity = gc;
		// TODO Auto-generated constructor stub
	}	

   @Override
    public void takeTurn(Grassland g1, Grassland g2, boolean flag) 
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //super.takeTurn(g1, g2, flag);
        
        //carnivore is not present
        if(flag==false)
        {
            double n = Math.random()*100+1;
            //in a grassland
            if(n<=50)
            {
               if(g1.isInside(this)) 
               {
                   this.count =0;
                   double xx = Math.pow(this._x-g2._x,2);
                   double yy = Math.pow(this._y-g2._y,2);
                   double distance = Math.sqrt(xx+yy);
                  
                   double x = (g2._x*5+(distance-5)*_x)/distance;
                   x = Math.round(x);
                   double y = (g2._y*5+(distance-5)*_y)/distance;
                   y = Math.round(y);
                   
                   this._x = x;
                   this._y = y;
                   
                   //this.Turns_number();
               }
               else if(g2.isInside(this))
               {
                   this.count =0;
                   double xx = Math.pow(this._x-g1._x,2);
                   double yy = Math.pow(this._y-g1._y,2);
                   double distance = Math.sqrt(xx+yy);
                  
                   double x = (g1._x*5+(distance-5)*_x)/distance;
                   x = Math.round(x);
                   double y = (g1._y*5+(distance-5)*_y)/distance;
                   y = Math.round(y);
                   
                   this._x = x;
                   this._y = y;
                   
                   //this.Turns_number();
               }
            }
            //not in grassland
            else
            {
                double xx1 = Math.pow(this._x-g1._x,2);
                double yy1 = Math.pow(this._y-g1._y,2);
                double distance1 = Math.sqrt(xx1+yy1);
                  
                double xx2 = Math.pow(this._x-g2._x,2);
                double yy2 = Math.pow(this._y-g2._y,2);
                double distance2 = Math.sqrt(xx2+yy2);
                                           
                if(distance1<distance2)
                {
                    double x1 = (g1._x*5+(distance1-5)*_x)/distance1;
                    x1 = Math.round(x1);
                    double y1 = (g1._y*5+(distance1-5)*_y)/distance1;
                    y1 = Math.round(y1);
                          
                    _x = x1;
                    _y = y1;
                }
                else
                {
                    double x2 = (g2._x*5+(distance2-5)*_x)/distance2;
                    x2 = Math.round(x2);
                    double y2 = (g2._y*5+(distance2-5)*_y)/distance2;
                    y2 = Math.round(y2);
                            
                    _x = x2;
                    _y = y2;
                }
                    
                    xx1 = Math.pow(this._x-g1._x,2);
                    yy1 = Math.pow(this._y-g1._y,2);
                    distance1 = Math.sqrt(xx1+yy1);
                    
                    xx2 = Math.pow(this._x-g2._x,2);
                    yy2 = Math.pow(this._y-g2._y,2);
                    distance2 = Math.sqrt(xx2+yy2);
                    
                    if(distance1<g1.radius || distance2<g2.radius)
                    {
                        count=0;
                        this.Turns_number();
                    }
                    else
                    {
                        //this.health = this.health-25;
                        this.count++;
                        this.Turns_number();                        
                    }                                       
                
            }
        } 
        //carnivore is present
        else
        {
            if(!g1.isInside(this) && !g2.isInside(this))
            {
                
                double chance = Math.random()*100+1;
                // doesn't stay at same place
                if(chance<=95)
                {
                    double chance2 = Math.random()*101;
                    //goes 5 units in direction of nearest grassland
                    if(chance2<=65)
                    {
                        double xx1 = Math.pow(this._x-g1._x,2);
                        double yy1 = Math.pow(this._y-g1._y,2);
                        double distance1 = Math.sqrt(xx1+yy1);

                        double xx2 = Math.pow(this._x-g2._x,2);
                        double yy2 = Math.pow(this._y-g2._y,2);
                        double distance2 = Math.sqrt(xx2+yy2);

                        if(distance1<distance2)
                        {
                            double x1 = (g1._x*5+(distance1-5)*_x)/distance1;
                            x1 = Math.round(x1);
                            double y1 = (g1._y*5+(distance1-5)*_y)/distance1;
                            y1 = Math.round(y1);

                            _x = x1;
                            _y = y1;
                        }
                        else
                        {
                            double x2 = (g2._x*5+(distance2-5)*_x)/distance2;
                            x2 = Math.round(x2);
                            double y2 = (g2._y*5+(distance2-5)*_y)/distance2;
                            y2 = Math.round(y2);

                            _x = x2;
                            _y = y2;
                        }
                        
                        if(g1.isInside(this)||g2.isInside(this))
                        {
                            this.count=0;
                            
                        }
                        else
                        {
                            this.count++;
                            this.Turns_number();
                        }
                    }
                    // 4 units away from the nearest carnivore
                    else
                    {
                        double distance = Math.sqrt(Math.pow(nearest._x-_x,2)+Math.pow(nearest._y-_y,2));
                        double x = (4*_x-(distance+4)*nearest._x)/distance;
                        double y = (4*_y-(distance+4)*nearest._y)/distance;

                        _x = x;
                        _y = y;
                        
                        if(g1.isInside(this)||g2.isInside(this))
                        {
                            this.count=0;
                            
                        }
                        else
                        {
                            this.count++;
                            this.Turns_number();
                        }
                        
                        //this.count++;
                        //this.Turns_number();

                    }
                }
            }
            
            // is inside a grassland
            else
            {
                //inside g1
                if(g1.isInside(this))
                {
                    //grass capacity of grassland ismore than grass capacity of herbi
                    if(g1.grass_capacity>=this.grass_capacity)
                    {
                        double chance = Math.random()*101;
                        
                        // eats all grass and stays
                        if(chance<=90)
                        {
                            g1.grass_capacity= g1.grass_capacity-this.grass_capacity;
                            
                            this.health = this.health + this.health/2;
                            if(g1.isInside(this)||g2.isInside(this))
                            {
                            this.count=0;
                            
                            }
                            else
                            {
                                this.count++;
                                this.Turns_number();
                            }
                        }
                        //does not stay
                        else
                        {                            
                            double rand = Math.random()*101;
                            //moves 2 units away from nearest carni
                            if(rand<=50)
                            {
                                double distance = Math.sqrt(Math.pow(nearest._x-_x,2)+Math.pow(nearest._y-_y,2));
                                double x = (2*_x-(distance+2)*nearest._x)/distance;

                                double y = (2*_y-(distance+2)*nearest._y)/distance;

                                _x = x;
                                _y = y;
                                
                                
                                if(g1.isInside(this)||g2.isInside(this))
                                {
                                this.count=0;

                                }
                                else
                                {
                                    this.count++;
                                    this.Turns_number();
                                }
                            }
                            //moves 3 units towards the next nearest grassland
                            else
                            {
                                double distance = Math.sqrt(Math.pow(g2._x-_x,2)+Math.pow(g2._y-_y,2));
                                double x = (3*_x+(distance-3)*g2._x)/distance;

                                double y = (3*_y+(distance-3)*g2._y)/distance;

                                _x = x;
                                _y = y;
                            }
                        }
                    }
                    
                    // grass capacity of grassland is less than max capacity of herbi
                    else
                    {
                        double rnd = Math.random()*101;
                        // stays and eats all the grass and finishes it
                        if(rnd<=20)
                        {
                            //stays
                            g1.grass_capacity=0;
                            this.health = this.health+this.health/5;
                            
                            if(g1.isInside(this)||g2.isInside(this))
                            {
                            this.count=0;
                            
                            }
                            else
                            {
                                this.count++;
                                this.Turns_number();
                            }
                        }
                        //choses not to stay
                        else
                        {
                            double rand = Math.random()*101;
                            if(rand<=70)
                            {
                                double distance = Math.sqrt(Math.pow(nearest._x-_x,2)+Math.pow(nearest._y-_y,2));
                                double x= (_x*(distance+4)-nearest._x*4)/distance;
                                double y= (_y*(distance+4)-nearest._y*4)/distance;
                                
                                _x = x;
                                _y = y;     
                                
                                if(g1.isInside(this)||g2.isInside(this))
                                {
                                this.count=0;

                                }
                                else
                                {
                                    this.count++;
                                    this.Turns_number();
                                }
                            }
                            else
                            {
                                double xx2 = Math.pow(this._x-g2._x,2);
                                double yy2 = Math.pow(this._y-g2._y,2);
                                double distance2 = Math.sqrt(xx2+yy2);
                                double x2 = (g2._x*2+(distance2-2)*_x)/distance2;
                                x2 = Math.round(x2);
                                double y2 = (g2._y*2+(distance2-2)*_y)/distance2;
                                y2 = Math.round(y2);

                                _x = x2;
                                _y = y2;
                                
                                
                                if(g1.isInside(this)||g2.isInside(this))
                                {
                                this.count=0;

                                }
                                else
                                {
                                    this.count++;
                                    this.Turns_number();
                                }
                            }
                        }
                    }
                }
                if(g2.isInside(this))
                {
                    //grass capacity of grassland ismore than grass capacity of herbi
                    if(g2.grass_capacity>=this.grass_capacity)
                    {
                        double chance = Math.random()*101;
                        
                        // eats all grass and stays
                        if(chance<=90)
                        {
                            g2.grass_capacity= g2.grass_capacity-this.grass_capacity;
                            
                            
                            this.health = this.health+this.health/2;
                            
                            if(g2.isInside(this)||g1.isInside(this))
                            {
                            this.count=0;
                            
                            }
                            else
                            {
                                this.count++;
                                this.Turns_number();
                            }
                        }
                        //does not stay
                        else
                        {                            
                            double rand = Math.random()*101;
                            //moves 2 units away from nearest carni
                            if(rand<=50)
                            {
                                double distance = Math.sqrt(Math.pow(nearest._x-_x,2)+Math.pow(nearest._y-_y,2));
                                double x = (2*_x-(distance+2)*nearest._x)/distance;

                                double y = (2*_y-(distance+2)*nearest._y)/distance;

                                _x = x;
                                _y = y;
                                
                                
                                if(g1.isInside(this)||g2.isInside(this))
                                {
                                this.count=0;

                                }
                                else
                                {
                                    this.count++;
                                    this.Turns_number();
                                }
                            }
                            //moves 3 units towards the next nearest grassland
                            else
                            {
                                double distance = Math.sqrt(Math.pow(g1._x-_x,2)+Math.pow(g1._y-_y,2));
                                double x = (3*_x+(distance-3)*g1._x)/distance;

                                double y = (3*_y+(distance-3)*g1._y)/distance;

                                _x = x;
                                _y = y;
                            }
                        }
                    }
                    
                    // grass capacity of grassland is less than max capacity of herbi
                    else
                    {
                        double rnd = Math.random()*101;
                        // stays and eats all the grass and finishes it
                        if(rnd<=20)
                        {
                            //stays
                            g2.grass_capacity=0;
                            
                            this.health = this.health+this.health/5;
                            
                            if(g1.isInside(this)||g2.isInside(this))
                            {
                            this.count=0;
                            
                            }
                            else
                            {
                                this.count++;
                                this.Turns_number();
                            }
                        }
                        //choses not to stay
                        else
                        {
                            double rand = Math.random()*101;
                            if(rand<=70)
                            {
                                double distance = Math.sqrt(Math.pow(nearest._x-_x,2)+Math.pow(nearest._y-_y,2));
                                double x= (_x*(distance+4)-nearest._x*4)/distance;
                                double y= (_y*(distance+4)-nearest._y*4)/distance;
                                
                                _x = x;
                                _y = y;     
                                
                                if(g1.isInside(this)||g2.isInside(this))
                                {
                                this.count=0;

                                }
                                else
                                {
                                    this.count++;
                                    this.Turns_number();
                                }
                            }
                            else
                            {
                                double xx2 = Math.pow(this._x-g1._x,2);
                                double yy2 = Math.pow(this._y-g1._y,2);
                                double distance2 = Math.sqrt(xx2+yy2);
                                double x2 = (g1._x*2+(distance2-2)*_x)/distance2;
                                x2 = Math.round(x2);
                                double y2 = (g1._y*2+(distance2-2)*_y)/distance2;
                                y2 = Math.round(y2);

                                _x = x2;
                                _y = y2;
                                
                                
                                if(g1.isInside(this)||g2.isInside(this))
                                {
                                this.count=0;

                                }
                                else
                                {
                                    this.count++;
                                    this.Turns_number();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void Turns_number() 
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(this.count>7)
        {
            this.health = this.health-5;
        }
    
    }
}

class Carnivore extends Animal
{
    //String name;
    Herbivore nearest;
    public Carnivore(double x, double y, double ts, double h) 
    {
        super(x, y, ts, h);
    }

    @Override
    public void takeTurn(Grassland g1, Grassland g2, boolean flag) 
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //double n = Math.random()*100+1;
        
        //no herbi left
        if(flag==false)
        {
            if(g1.isInside(this)==false && g2.isInside(this)==false)
            {
                this.health = this.health-60;
                this.count++;
                this.Turns_number();
            }
            else
            {
                this.health = this.health - 30;
                this.count++;
                this.Turns_number();
            }
        }
        //at least one herbi is present
        else
        {
            double dist_nearest_herb = Math.sqrt(Math.pow(nearest._x-_x,2)+Math.pow(nearest._y-_y,2));
            // kills the herbivore
            if(dist_nearest_herb<=1)
            {
                count=0;
                this.health = this.health+ (2*nearest.health)/3;
                // the nearest herbivore dies
                nearest.health=0;
                count++;
                this.Turns_number();
            }
            else
            {
                //not inside a grassland
                if(!g1.isInside(this)&& !g2.isInside(this))
                {
                    double chancec = Math.random()*101;
                    if(chancec<=92)
                    {
                        double xx1 = Math.pow(this._x-nearest._x,2);
                        double yy1 = Math.pow(this._y-nearest._y,2);
                        double dist = Math.sqrt(xx1+yy1);

                        double x1 = (nearest._x*4+(dist-4)*_x)/dist;
                        x1 = Math.round(x1);
                        double y1 = (nearest._y*4+(dist-4)*_y)/dist;
                        y1 = Math.round(y1);

                        _x = x1;
                        _y = y1;
                        
                        //this.health = this.health -60;
                        this.count++;
                        this.Turns_number();
                    }
                    else
                    {
                        //stay in current position
                        this.health = this.health -60;
                        this.count++;
                        this.Turns_number();
                        
                    }
                }
                //if carnivore is inside a grassland
                else
                {
                    double chancec = Math.random()*101;
                    if(chancec<=25)
                    {
                        //stays inside the grssland
                        this.health = this.health -30;
                        this.count++;
                        this.Turns_number();
                    }
                    else
                    {
                        double xx1 = Math.pow(this._x-nearest._x,2);
                        double yy1 = Math.pow(this._y-nearest._y,2);
                        double dist = Math.sqrt(xx1+yy1);

                        double x1 = (nearest._x*2+(dist-2)*_x)/dist;
                        x1 = Math.round(x1);
                        double y1 = (nearest._y*2+(dist-2)*_y)/dist;
                        y1 = Math.round(y1);

                        _x = x1;
                        _y = y1;
                        //this.health = this.health -30;
                        this.count++;
                        this.Turns_number();
                    }
                }
            }
        }
    }

    @Override
    public void Turns_number() 
    {
        
        double dist = Math.sqrt(Math.pow(nearest._x-this._x,2)+Math.pow(nearest._y-this._y,2));
        if(dist<5)
        {
            count=0;
        }
        
        if(dist>=5 && this.count>7)
        {
            this.health = this.health-6;
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

class Grassland
{
	double _x;
	double _y;
	double radius;
	double grass_capacity;
        
	public Grassland(double x, double y, double r,double gc)
        {
		_x = x;
		_y = y;
		radius = r;
                grass_capacity = gc;
	}
        
        public boolean isInside(Animal a)
        {
            double xx = Math.pow(a._x - this._x,2);
            double yy = Math.pow(a._x - this._x,2);
            double dist = Math.sqrt(xx+yy);
            if(dist<this.radius)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
}

public class World
{
        static PriorityQueue<Animal> pqueue = new PriorityQueue<>();
                
	public static void main(String[] args)throws IOException
        {
		Reader.init(System.in);
		
		System.out.println("Enter Total Final Time for Simulation:");
		double tf_time = Reader.nextDouble();
		
		System.out.println("Enter x,y centre, radius, and Grass Available for First Grassland:");
		double x_g1 = Reader.nextDouble();
		double y_g1 = Reader.nextDouble();
		double rad_g1 = Reader.nextDouble();
		double grass_avail_g1 = Reader.nextDouble();
                
                Grassland g1 = new Grassland(x_g1,y_g1,rad_g1,grass_avail_g1);
                
		
		System.out.println("Enter x,y centre, radius, and Grass Available for Second Grassland:");
		double x_g2 = Reader.nextDouble();
		double y_g2 = Reader.nextDouble();
		double rad_g2 = Reader.nextDouble();
		double grass_avail_g2 = Reader.nextDouble();
                
                Grassland g2 = new Grassland(x_g2,y_g2,rad_g2,grass_avail_g2);
		
		System.out.println("Enter Health and Grass Capacity for Herbivores:");
		double health_herb = Reader.nextDouble();
		double grass_cap_herb = Reader.nextDouble();
		
		System.out.println("Enter x,y position and timestamp for First Herbivore:");
		double x_h1 = Reader.nextDouble();
		double y_h1 = Reader.nextDouble();
		double ts_h1 = Reader.nextDouble();
                
                Herbivore h1 = new Herbivore(x_h1,y_h1,ts_h1,ts_h1,grass_cap_herb);
                
                h1.name = "First Herbivore";
                
		System.out.println("Enter x,y position and timestamp for Second Herbivore:");
		double x_h2 = Reader.nextDouble();
		double y_h2 = Reader.nextDouble();
		double ts_h2 = Reader.nextDouble();
                
                Herbivore h2 = new Herbivore(x_h2,y_h2,ts_h2,ts_h2,grass_cap_herb);
                h2.name = "Second Herbivore";
		
		System.out.println("Enter health of Carnivores:");
		double health_carn = Reader.nextDouble();
		
		System.out.println("Enter x,y position and timestamp for First Carnivore:");
		double x_c1 = Reader.nextDouble();
		double y_c1 = Reader.nextDouble();
		double ts_c1 = Reader.nextDouble();
                
                Carnivore c1 = new Carnivore(x_c1, y_c1,ts_c1,health_carn);
                c1.name = "First Carnivore";
		
		System.out.println("Enter x,y position and timestamp for Second Carnivore:");
		double x_c2 = Reader.nextDouble();
		double y_c2 = Reader.nextDouble();
                double ts_c2 = Reader.nextDouble();
                
                Carnivore c2 = new Carnivore(x_c2,y_c2,ts_c2,health_carn);
                c2.name = "Second Carnivore";

		System.out.println("The Simulation Begins-");
		
		pqueue.add(h1);
                pqueue.add(h2);
                pqueue.add(c1);
                pqueue.add(c2);
                
                double t = tf_time;
                
                int count_C =2;
                int count_H = 2;
                
                boolean flag_C=false;
                boolean flag_H=false;
                
                double d1_c = Double.MAX_VALUE;
                double d2_c=Double.MAX_VALUE;
                
                double d1_h = Double.MAX_VALUE;
                double d2_h = Double.MAX_VALUE;
                
                while(t>0 && !pqueue.isEmpty())
                {
                    if(h1.health<=0)
                    {
                        pqueue.remove(h1);
                    }
                    
                    if(h2.health<=0)
                    {
                        pqueue.remove(h2);
                    }
                    
                    if(c1.health<=0)
                    {
                        pqueue.remove(c1);
                    }
                    
                    if(c2.health<=0)
                    {
                        pqueue.remove(c2);
                    }
                    
                    
                    Animal ani = pqueue.poll();
                    
                    System.out.println("It is "+ani.name);
                    
                    if(ani.getClass().getSimpleName().equals("Herbivore"))
                    {
                        if(count_C>0)
                        {
                            flag_H = true;
                            if(pqueue.contains(h1))
                            {
                                d1_h = Math.sqrt(Math.pow(c1._x-ani._x,2)+Math.pow(c1._y-ani._y,2));
                            }
                            if(pqueue.contains(h2))
                            {
                                d2_h = Math.sqrt(Math.pow(c2._x-ani._x,2)+Math.pow(c2._y-ani._y,2));
                            }
                        }
                        Herbivore obj = (Herbivore)ani;
                        if(d2_h>d1_h)
                        {
                            obj.nearest = c1;
                        }
                        else
                        {
                            obj.nearest = c2;
                        }
                        ani.takeTurn(g1, g2, flag_H);
                    }
                    else
                    {
                        if(count_H>0)
                        {
                            flag_C = true;
                            if(pqueue.contains(h1))
                            {
                                d1_c = Math.sqrt(Math.pow(h1._x-ani._x,2)+Math.pow(h1._y-ani._y,2));
                            }
                            if(pqueue.contains(h2))
                            {
                                d2_c = Math.sqrt(Math.pow(h2._x-ani._x,2)+Math.pow(h2._y-ani._y,2));
                            }
                        }
                        
                        Carnivore obj = (Carnivore)ani;
                        if(d2_c>d1_c)
                        {
                            obj.nearest = h1;
                        }
                        else
                        {
                            obj.nearest = h2;
                        }
                        
                        ani.takeTurn(g1, g2, flag_C);
                    }
                    
                    //System.out.println("It's health after taking the turn is "+ ani.health);
                    //Random rand = null;
                    double max_timestamp = Math.max(h1.time_stamp, Math.max(h2.time_stamp, Math.max(c1.time_stamp, c2.time_stamp)));
                    
                    ani.time_stamp = Math.random()*((max_timestamp-ani.time_stamp)-1)+ani.time_stamp;
                    
                    if(ani.health>0)
                    {
                        System.out.println("It's health after taking the turn is "+ ani.health);
                        pqueue.add(ani);
                    }
                    else
                    {
                        System.out.println("It is dead");
                        if(pqueue.contains(ani))
                        {
                        pqueue.remove(ani);
                        }
                    }
                    t--;
                }
                
                
	}

}
