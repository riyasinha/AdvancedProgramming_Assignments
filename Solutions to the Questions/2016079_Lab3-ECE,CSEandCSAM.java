package lab3;

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

class creature{
	protected String name;
	protected int power;
	protected int health;
	protected int cost;
	protected int asset;
	
	public creature(int c, int a, int p, int h){
		//name = n;
                cost = c;
		asset = a;
		power = p;
		health = h;
	}

    public  creature() {
            power = 0;
            cost = 0;
            health = 0;
            asset = 0;
        }
	public void setName(String n){
		this.name = n;
	}
	public String getName(){
		return name;
	}
	public void damage(creature rival){
		rival.health = rival.health - (int)(Math.random()*power+1);
	}
	
}

class human extends creature{
	public human(int p, int h, int c, int a) {
		super(p, h, c, a);
		// TODO Auto-generated constructor stub
	}
}

class dragons extends creature{
	public dragons(int p, int h, int c, int a) {
		super(p, h, c, a);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void damage(creature rival){
                rival.health = rival.health - (int)(Math.random()*power+1);
		int n = (int)(Math.random()*101);
		if(n<16){
			rival.health = rival.health /*- (int)(Math.random()*power+1)*/ - 25;
		}
	}
}

class fire_dragons extends dragons{
	public fire_dragons(int p, int h, int c, int a) {
		super(p, h, c, a);
		// TODO Auto-generated constructor stub
	}
        
        @Override
	public void damage(creature rival){
                rival.health = rival.health - (int)(Math.random()*power+1);
		int n = (int)(Math.random()*101);
		if(n<6){
                        rival.health = rival.health - (int)(Math.random()*power+1);
		}
	}
	
}

class ice_dragons extends dragons{

	public ice_dragons(int p, int h, int c, int a) {
		super(p, h, c, a);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void damage(creature rival){
                rival.health = rival.health - (int)(Math.random()*power+1);
		//super.damage(rival);
		int n = (int)(Math.random()*101);
		if(n<6){
                    rival.health = rival.health - (int)(Math.random()*power+1);
		}
	}
}
class daemons extends creature{

	public daemons(int p, int h, int c, int a) {
		super(p, h, c, a);
		// TODO Auto-generated constructor stub
	}
        @Override
        public void damage(creature rival){
            rival.health = rival.health - (int)(Math.random()*power+1);
            int n = (int)(Math.random()*101);
            if(n<51){
                rival.health = rival.health - (int)(Math.random()*power+1);
            }
        }
	
}

class wolves extends creature{

	public wolves(int p, int h, int c, int a) {
		super(p, h, c, a);
		// TODO Auto-generated constructor stub
	}
	
}
public class lab3 {
	public static void main(String[] args)throws IOException{
		Reader.init(System.in);
                System.out.println("Enter Team Good's total money");
                int tg_money = Reader.nextInt();
                System.out.println("Enter Team Bad's total money");
                int tb_money = Reader.nextInt();
                System.out.println("Enter cost, asset, power and health for Human(space-seperated");
                int human_c = Reader.nextInt();
                int human_a = Reader.nextInt();
                int human_p = Reader.nextInt();
                int human_h = Reader.nextInt();
                
                human hum = new human(human_c, human_a, human_p, human_h);
                
                System.out.println("Enter cost, asset, power and health for Fire Dragon(space-seperated");
                int fdragon_c = Reader.nextInt();
                int fdragon_a = Reader.nextInt();
                int fdragon_p = Reader.nextInt();
                int fdragon_h = Reader.nextInt();
                
                fire_dragons fd = new fire_dragons(fdragon_c, fdragon_a, fdragon_p, fdragon_h);
                
                System.out.println("Enter cost, asset, power and health for Ice Dragon(space-seperated");
                int idragon_c = Reader.nextInt();
                int idragon_a = Reader.nextInt();
                int idragon_p = Reader.nextInt();
                int idragon_h = Reader.nextInt();
                
                ice_dragons id = new ice_dragons(idragon_c, idragon_a, idragon_p, idragon_h);
                
                System.out.println("Enter cost, asset, power and health for Daemon(space-seperated");
                int daemon_c = Reader.nextInt();
                int daemon_a = Reader.nextInt();
                int daemon_p = Reader.nextInt();
                int daemon_h = Reader.nextInt();
                
                daemons dae = new daemons(daemon_c, daemon_a, daemon_p,daemon_h);
                System.out.println("Enter cost asset, power and health for Wolf(space-seperated");
                int wolf_c = Reader.nextInt();
                int wolf_a = Reader.nextInt();
                int wolf_p = Reader.nextInt();
                int wolf_h = Reader.nextInt();
                
                wolves wol = new wolves(wolf_c, wolf_a, wolf_p, wolf_h);
                
                ArrayList<creature> gt = new ArrayList<creature>();                
                int cnt_bt = 0;
                int cnt_gt = 0;
                
                System.out.println("Select Creatures for Team Good: \n 1.Human \n 2.Fire Dragon \n 3.Wolf \n 4.Exit Selection" );
                
                int tg_nos = Reader.nextInt(); 
                while(tg_nos!=4){
                   if(tg_nos == 1){
                       System.out.println("Enter name of Human:");
                       hum.setName(Reader.next());
                       gt.add(hum);
                       tg_money = tg_money-hum.cost; 
                       cnt_gt++;
                   }
                   else if(tg_nos == 2){
                       System.out.println("Enter name of Fire Dragon:");
                       fd.setName(Reader.next());
                       gt.add(fd);
                       tg_money = tg_money-fd.cost;
                       cnt_gt++;
                   }
                   else if(tg_nos == 3){
                       System.out.println("Enter name of Wolf:");
                       wol.setName(Reader.next());
                       gt.add(wol);
                       tg_money = tg_money-wol.cost;
                       cnt_gt++;
                   }
                   if( Math.min(Math.min(human_c, fdragon_c),wolf_c)<tg_money){
                        System.out.println("Select Creatures for Team Good: \n 1.Human \n 2.Fire Dragon \n 3.Wolf \n 4.Exit Selection");
                        tg_nos = Reader.nextInt();
                   }
                   else{
                       break;
                   }
                  
                }
                
                ArrayList<creature> bt = new ArrayList<creature>();
                System.out.println("Select Creatures for Team Bad: \n 1.Daemon \n 2.Ice Dragon \n 3.Exit Selection" );
                int tb_nos = Reader.nextInt();
                while(tb_nos!=3){
                    if(tb_nos == 1){
                        System.out.println("Enter name of Daemon:");
                        dae.setName(Reader.next());
                        bt.add(dae);
                        tb_money = tb_money - daemon_c;
                        cnt_bt++;
                    }
                    else if(tb_nos == 2){
                        System.out.println("Enter name of Ice Dragon");
                        id.setName(Reader.next());
                        bt.add(id);
                        tb_money = tb_money-idragon_c;
                        cnt_bt++;
                    }
                    if(Math.min(daemon_c, idragon_c)<tb_money){
                        System.out.println("Select Creatures for Team Bad: \n 1.Daemon \n 2.Ice Dragon \n 3.Exit Selection" );
                        tb_nos = Reader.nextInt();
                    }
                    else{
                        break;
                    }
                    
                }
                System.out.println("The War Begins:");
                creature c1_gt = new creature();
                creature c1_bt = new creature();
                
                
                for(int z =1;;z++){
                    if(c1_gt.health>0 && c1_bt.health>0){
                        System.out.println("Round-"+z+":");
               //         System.out.println(c1_gt.health);
                    c1_bt.damage(c1_gt);
 //                   System.out.println(c1_gt.health);
   //                 System.out.println(c1_bt.health);;
                    c1_gt.damage(c1_bt);
     //               System.out.println(c1_bt.health);
                    
                    if(c1_bt.health>0 && c1_gt.health>0){
                        continue;
                    }
                    
                    if(cnt_gt>0 && cnt_bt>0){
                    if(c1_gt.health>0 && c1_bt.health<=0 ){
                        tg_money = tg_money+c1_bt.asset;
                        System.out.println(c1_bt.name+" Loses in Round-"+z);
                        System.out.println("Money of Good's Team is " + tg_money);
                        System.out.println("Money of Bad's Team is " + tb_money);
                        bt.remove(c1_bt);
                        cnt_bt--;
                    }
                    else if (c1_bt.health>0 && c1_gt.health<=0){
                        tb_money = tb_money+c1_gt.asset;
                        System.out.println(c1_gt.name+" Loses in Round-"+z);
                        System.out.println("Money of Bad's Team is " + tb_money);
                        System.out.println("Money of Good's Team is " + tg_money);
                        gt.remove(c1_gt);
                        cnt_gt--;
                    }
                    else if(c1_bt.health<=0 && c1_bt.health<=0){
                        
                        System.out.println("Both lose");
                        bt.remove(c1_bt);
                        cnt_bt--;
                        gt.remove(c1_gt);
                        cnt_gt--;
                    }
                    }
                    if(cnt_gt==0 && cnt_bt==0){
                        if(tg_money>tg_money){
                            System.out.println("Team Good Wins the War");
                        }
                        else{
                            System.out.println("Team Bad wins the War");
                        
                        }
                        break;
                    }

                    else if(cnt_gt==0 && Math.min(Math.min(human_c, fdragon_c),wolf_c)>tg_money ){
                        System.out.println("Team Bad wins the War. The money the team has is" + tb_money);
                        break;
                    }
                    else if(cnt_bt<=0 && Math.min(daemon_c, idragon_c)>tb_money){
                        System.out.println("Team Good wins the War. The money the team has is" + tg_money);
                        break;
                    } 
                    }
                    else if(c1_gt.health>0 && c1_bt.health<0){
                        System.out.println("Round-"+z+":");
                        System.out.println("Enter Creature from Bad's Team to fight in the war:");
                        String cre1_bt = Reader.next();
                        
                        for(int i = 0; i<bt.size();i++){
                        if(bt.get(i).getName().equals(cre1_bt)){
                            c1_bt = bt.get(i);
                            break;
                        }
                        }
                        
                      //  System.out.println(c1_gt.health);
                    c1_bt.damage(c1_gt);
                    //System.out.println(c1_gt.health);
                    //System.out.println(c1_bt.health);;
                    c1_gt.damage(c1_bt);
                    //System.out.println(c1_bt.health);
                    
                    if(c1_bt.health>0 && c1_gt.health>0){
                        continue;
                    }
                    
                    if(cnt_gt>0 && cnt_bt>0){
                    if(c1_gt.health>0 && c1_bt.health<=0 ){
                        tg_money = tg_money+c1_bt.asset;
                        System.out.println(c1_bt.name+" Loses in Round-"+z);
                        System.out.println("Money of Good's Team is " + tg_money);
                        System.out.println("Money of Bad's Team is " + tb_money);
                        bt.remove(c1_bt);
                        cnt_bt--;
                    }
                    else if (c1_bt.health>0 && c1_gt.health<=0){
                        tb_money = tb_money+c1_gt.asset;
                        System.out.println(c1_gt.name+" Loses in Round"+z);
                        System.out.println("Money of Bad's Team is " + tb_money);
                        System.out.println("Money of Good's Team is " + tg_money);
                        gt.remove(c1_gt);
                        cnt_gt--;
                    }
                    else if(c1_bt.health<=0 && c1_bt.health<=0){
                        
                        System.out.println("Both lose");
                        bt.remove(c1_bt);
                        cnt_bt--;
                        gt.remove(c1_gt);
                        cnt_gt--;
                    }
                    }
                    
                    if(cnt_gt==0 && cnt_bt==0){
                        if(tg_money>tg_money){
                            System.out.println("Team Good Wins the War");
                        }
                        else{
                            System.out.println("Team Bad wins the War");
                        
                        }
                        break;
                    }

                    else if(cnt_gt==0 && Math.min(Math.min(human_c, fdragon_c),wolf_c)>tg_money ){
                        System.out.println("Team Bad wins the War. The money the team has is" + tb_money);
                        break;
                    }
                    else if(cnt_bt<=0 && Math.min(daemon_c, idragon_c)>tb_money){
                        System.out.println("Team Good wins the War. The money the team has is" + tg_money);
                        break;
                    } 
                    while(tg_nos != 4 && Math.min(Math.min(human_c, fdragon_c),wolf_c)<=tg_money){
                        if(Math.min(Math.min(human_c, fdragon_c),wolf_c)<=tg_money){
                            System.out.println("Select Creatures for Team Good: \n 1.Human \n 2.Fire Dragon \n 3.Wolf \n 4.Exit Selection");
                            tg_nos = Reader.nextInt();
                       }
                       else{
                    	   break;
                       } 
                       if(tg_nos == 1){
                           
                           System.out.println("Enter name of Human:");
                           //String n_hum = Reader.next
                           hum.setName(Reader.next());
                           gt.add(hum);
                           tg_money = tg_money-hum.cost; 
                       }
                       else if(tg_nos == 2){
                           System.out.println("Enter name of Fire Dragon:");
                           fd.setName(Reader.next());
                           gt.add(fd);
                           tg_money = tg_money-fd.cost;
                       }
                       else if(tg_nos == 3){
                           System.out.println("Enter name of Wolf:");
                           wol.setName(Reader.next());
                           gt.add(wol);
                           tg_money = tg_money-wol.cost;
                       }
                    }
                    while(Math.min(daemon_c, idragon_c)<tb_money && tb_nos!=3 ){
                        if(Math.min(daemon_c, idragon_c)<tb_money){
                            System.out.println("Select Creatures for Team Bad:\n 1.Daemon \n 2.Ice Dragon \n 3.Exit Selection" );
                            tb_nos = Reader.nextInt();
                        }
                        else{
                            break;
                        }
                        if(tb_nos == 1){
                            System.out.println("Enter name of Daemon:");
                            dae.setName(Reader.next());
                            bt.add(dae);
                            tb_money = tb_money - daemon_c;
                        }
                        else if(tb_nos == 2){
                            System.out.println("Enter name of Ice Dragon");
                            id.setName(Reader.next());
                            bt.add(id);
                            tb_money = tb_money-daemon_c;
                        }
                    }
                    }
                    
                    else if(c1_bt.health>0 && c1_gt.health<0){
                        System.out.println("Round-"+z+":");
                        System.out.println("Enter Creature from Good's Team to fight in the war:");
                        String cre1_gt = Reader.next();
                        
                        for(int i = 0; i<gt.size();i++){
                        if(gt.get(i).getName().equals(cre1_gt)){
                           c1_gt = gt.get(i); 
                           break;
                        }
                        }
                        
             //            System.out.println(c1_gt.health);
                    c1_bt.damage(c1_gt);
       //             System.out.println(c1_gt.health);
         //           System.out.println(c1_bt.health);;
                    c1_gt.damage(c1_bt);
           //         System.out.println(c1_bt.health);
                    
                    if(c1_bt.health>0 && c1_gt.health>0){
                        continue;
                    }
                    
                    if(cnt_gt>0 && cnt_bt>0){
                    if(c1_gt.health>0 && c1_bt.health<=0 ){
                        tg_money = tg_money+c1_bt.asset;
                        System.out.println(c1_bt.name+" Loses in Round-"+z);
                        System.out.println("Money of Good's Team is " + tg_money);
                        System.out.println("Money of Bad's Team is " + tb_money);
                        bt.remove(c1_bt);
                        cnt_bt--;
                    }
                    else if (c1_bt.health>0 && c1_gt.health<=0){
                        tb_money = tb_money+c1_gt.asset;
                        System.out.println(c1_gt.name+" Loses in Round"+z);
                        System.out.println("Money of Bad's Team is " + tb_money);
                        System.out.println("Money of Good's Team is " + tg_money);
                        gt.remove(c1_gt);
                        cnt_gt--;
                    }
                    else if(c1_bt.health<=0 && c1_bt.health<=0){
                        
                        System.out.println("Both lose");
                        bt.remove(c1_bt);
                        cnt_bt--;
                        gt.remove(c1_gt);
                        cnt_gt--;
                    }
                    }
                    
                    if(cnt_gt==0 && cnt_bt==0){
                        if(tg_money>tg_money){
                            System.out.println("Team Good Wins the War");
                        }
                        else{
                            System.out.println("Team Bad wins the War");
                        
                        }
                        break;
                    }

                    else if(cnt_gt==0 && Math.min(Math.min(human_c, fdragon_c),wolf_c)>tg_money ){
                        System.out.println("Team Bad wins the War. The money the team has is" + tb_money);
                        break;
                    }
                    else if(cnt_bt<=0 && Math.min(daemon_c, idragon_c)>tb_money){
                        System.out.println("Team Good wins the War. The money the team has is" + tg_money);
                        break;
                    } 
                    
                    while(tg_nos != 4 && Math.min(Math.min(human_c, fdragon_c),wolf_c)<=tg_money){
                        if(Math.min(Math.min(human_c, fdragon_c),wolf_c)<=tg_money){
                            System.out.println("Select Creatures for Team Good: \n 1.Human \n 2.Fire Dragon \n 3.Wolf \n 4.Exit Selection");
                            tg_nos = Reader.nextInt();
                       }
                       else{
                    	   break;
                       } 
                       if(tg_nos == 1){
                           
                           System.out.println("Enter name of Human:");
                           //String n_hum = Reader.next
                           hum.setName(Reader.next());
                           gt.add(hum);
                           tg_money = tg_money-hum.cost; 
                       }
                       else if(tg_nos == 2){
                           System.out.println("Enter name of Fire Dragon:");
                           fd.setName(Reader.next());
                           gt.add(fd);
                           tg_money = tg_money-fd.cost;
                       }
                       else if(tg_nos == 3){
                           System.out.println("Enter name of Wolf:");
                           wol.setName(Reader.next());
                           gt.add(wol);
                           tg_money = tg_money-wol.cost;
                       }
                    }
                    
                    while(Math.min(daemon_c, idragon_c)<tb_money && tb_nos!=3 ){
                        if(Math.min(daemon_c, idragon_c)<tb_money){
                            System.out.println("Select Creatures for Team Bad:\n 1.Daemon \n 2.Ice Dragon \n 3.Exit Selection" );
                            tb_nos = Reader.nextInt();
                        }
                        else{
                            break;
                        }
                        if(tb_nos == 1){
                            System.out.println("Enter name of Daemon:");
                            dae.setName(Reader.next());
                            bt.add(dae);
                            tb_money = tb_money - daemon_c;
                        }
                        else if(tb_nos == 2){
                            System.out.println("Enter name of Ice Dragon");
                            id.setName(Reader.next());
                            bt.add(id);
                            tb_money = tb_money-daemon_c;
                        }
                    }
                
                    }
                    else{
                    System.out.println("Round-"+z+":");
                    System.out.println("Enter Creature from Good's Team to fight in the war:");
                    String cre1_gt = Reader.next();
                    System.out.println("Enter Creature from Bad's Team to fight in the war:");
                    String cre1_bt = Reader.next();
                    for(int i = 0; i<gt.size();i++){
                        if(gt.get(i).getName().equals(cre1_gt)){
                           c1_gt = gt.get(i); 
                           break;
                        }
                    }
                    
                    for(int i = 0; i<bt.size();i++){
                        if(bt.get(i).getName().equals(cre1_bt)){
                            c1_bt = bt.get(i);
                            break;
                        }
                    }
                    
                    
                 //   System.out.println(c1_gt.health);
                    c1_bt.damage(c1_gt);
                   // System.out.println(c1_gt.health);
                    //System.out.println(c1_bt.health);;
                    c1_gt.damage(c1_bt);
                    //System.out.println(c1_bt.health);
                    
                    if(c1_bt.health>0 && c1_gt.health>0){
                        continue;
                    }
                    
                    if(cnt_gt>0 && cnt_bt>0){
                    if(c1_gt.health>0 && c1_bt.health<=0 ){
                        tg_money = tg_money+c1_bt.asset;
                        System.out.println(c1_bt.name+" Loses in Round-"+z);
                        System.out.println("Money of Good's Team is " + tg_money);
                        System.out.println("Money of Bad's Team is " + tb_money);
                        bt.remove(c1_bt);
                        cnt_bt--;

                    }
                    else if (c1_bt.health>0 && c1_gt.health<=0){
                        tb_money = tb_money+c1_gt.asset;
                        System.out.println(c1_gt.name+" Loses in Round"+z);
                        System.out.println("Money of Bad's Team is " + tb_money);
                        System.out.println("Money of Good's Team is " + tg_money);
                        gt.remove(c1_gt);
                        cnt_gt--;
                    }
                    else if(c1_bt.health<=0 && c1_bt.health<=0){
                        
                        System.out.println("Both lose");
                        bt.remove(c1_bt);
                        cnt_bt--;
                        gt.remove(c1_gt);
                        cnt_gt--;
                    }
                    }
                    
                    if(cnt_gt==0 && cnt_bt==0){
                        if(tg_money>tg_money){
                            System.out.println("Team Good Wins the War");
                        }
                        else{
                            System.out.println("Team Bad wins the War");
                        
                        }
                        break;
                    }

                    else if(cnt_gt==0 && Math.min(Math.min(human_c, fdragon_c),wolf_c)>tg_money ){
                        System.out.println("Team Bad wins the War. The money the team has is" + tb_money);
                        break;
                    }
                    else if(cnt_bt<=0 && Math.min(daemon_c, idragon_c)>tb_money){
                        System.out.println("Team Good wins the War. The money the team has is" + tg_money);
                        break;
                    } 
                    
                    while(tg_nos != 4 && Math.min(Math.min(human_c, fdragon_c),wolf_c)<=tg_money){
                        if(Math.min(Math.min(human_c, fdragon_c),wolf_c)<=tg_money){
                            System.out.println("Select Creatures for Team Good: \n 1.Human \n 2.Fire Dragon \n 3.Wolf \n 4.Exit Selection");
                            tg_nos = Reader.nextInt();
                       }
                       else{
                    	   break;
                       } 
                       if(tg_nos == 1){
                           
                           System.out.println("Enter name of Human:");
                           hum.setName(Reader.next());
                           gt.add(hum);
                           tg_money = tg_money-hum.cost; 
                       }
                       else if(tg_nos == 2){
                           System.out.println("Enter name of Fire Dragon:");
                           fd.setName(Reader.next());
                           gt.add(fd);
                           tg_money = tg_money-fd.cost;
                       }
                       else if(tg_nos == 3){
                           System.out.println("Enter name of Wolf:");
                           wol.setName(Reader.next());
                           gt.add(wol);
                           tg_money = tg_money-wol.cost;
                       }
                       
                    while(Math.min(daemon_c, idragon_c)<tb_money && tb_nos!=3 ){
                        if(Math.min(daemon_c, idragon_c)<tb_money){
                            System.out.println("Select Creatures for Team Bad:\n 1.Daemon \n 2.Ice Dragon \n 3.Exit Selection" );
                            tb_nos = Reader.nextInt();
                        }
                        else{
                            break;
                        }
                        if(tb_nos == 1){
                            System.out.println("Enter name of Daemon:");
                            dae.setName(Reader.next());
                            bt.add(dae);
                            tb_money = tb_money - daemon_c;
                        }
                        else if(tb_nos == 2){
                            System.out.println("Enter name of Ice Dragon");
                            id.setName(Reader.next());
                            bt.add(id);
                            tb_money = tb_money-daemon_c;
                        }
                    }
                }
                }
        }
}
}
