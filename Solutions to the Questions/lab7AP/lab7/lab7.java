package lab7;

import java.io.*;
import lab7.Playlist.*;
import lab7.Song.*;
import java.util.*;

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






public class lab7 
{
	public static Playlist pl;
	
	public Playlist getPlaylist()
	{
		Playlist p = new Playlist();
		return p;
	}
	
	public Song getSong()
	{
		Song s = new Song();
		return s;
	}
	
	
	public static void serialize(String name) throws IOException
	{
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/home/riya/eclipse-workspace/AP/"+ name +".txt"));;
		
		{
			//out = new ObjectOutputStream(new FileOutputStream("/home/riya/eclipse-workspace/AP/"+"play.txt"));
			for(int h=0;h<pl.songs.size();h++)
			{
				Song s = pl.songs.get(h);
				out.writeObject(s);
			}
			
		}
		out.close();
		/*
		Song s1 = new Song("yellow","coldplay",400);
		Song s2 = new Song("photograph","sheeran",410);
		out.writeObject(s1);
		out.writeObject(s2);
		out.close();*/
	}
	
	public static Playlist deserialize(String name) throws IOException, ClassNotFoundException
	{
		ObjectInputStream in = null;
		int x=0;
		try{
			in = new ObjectInputStream(new FileInputStream("/home/riya/eclipse-workspace/AP/" + name+".txt"));
			while(x==0)
			{
				Song s = (Song) in.readObject();
				pl.songs.add(s);
			}
		}
		catch(EOFException e)
		{
			
		}
		finally
		{
			in.close();
		}
		return pl;
	}
//	
//	public static void hardcode() throws IOException
//	{
//		
//		Song s1 = new Song("yellow","coldplay",400);
//		Song s2 = new Song("photograph","sheeran",410);
//		Song s3 = new Song("words","christina",280);
//		Song s4 = new Song("roses","chainsmokers",360);
//		Song s5 = new Song("town","niall",380);
//		
//		/*pl.add(s1);
//		pl.add(s2);
//		pl.add(s3);
//		pl.add(s4);
//		pl.add(s5);
//		*/
//		//serialize(s1);
//		//serialize(s2);
//		
//	}
	
	public static void main(String[] args)throws IOException, ClassNotFoundException
	{
		Reader.init(System.in);
		
		
		// System.out.println("playlist read and 03 of songs displayed");
		System.out.println("enter the name of the playlist:");
		String name = Reader.next();
		
		pl = new Playlist();
		pl=deserialize(name);
		//hardcode();
		serialize(name);
		System.out.println("Songs in the playlist:"+pl.songs.size());
		System.out.println("Menu:\n a.Add \n b.Delete \n c.Search \n d.Show e.Back to Menu \n f.Exit" );
		
		String opt = Reader.next();
		
		boolean flag = true;
		//boolean flag1 = true;
		count = pl.songs.size();
		
		while(flag == true)
		{
			//deserialize(name);
			if(opt.equalsIgnoreCase("a"))
			{
				// add new song in the play list
				Song new_song = new Song();
				String sn = Reader.next();
				String ss = Reader.next();
				int sd = Reader.nextInt();
				new_song.name = sn;
				new_song.singer = ss;
				new_song.duration = sd;
				
				pl.add(new_song);
				count++;
				
			}
			
			else if (opt.equalsIgnoreCase("b"))
			{
				String n = Reader.next();
				pl.delete(n);
				count--;
			}
			
			else if(opt.equalsIgnoreCase("d"))
			{
				pl.show();
			}
			
			else if(opt.equalsIgnoreCase("c"))
			{
				String s = Reader.next();
				pl.search(s);
				
				
			}
			
			else if(opt.equalsIgnoreCase("f"))
			{
				System.out.println("exited app");
				flag = false;
				//serialize(name, pl.songs);
				break;
			}
			else if(opt.equalsIgnoreCase("e"))
			{
				//serialize(name, pl.songs);
				String[] paths = (new File("/home/riya/eclipse-workspace/AP").list());
				
				for(String path:paths)
				{
					if(path.substring((path.length()-3),path.length()).equalsIgnoreCase("txt"))
					{
						System.out.println(path);
					}
				}
				name = Reader.next();
				pl.name = name;
			}
			
			System.out.println("Menu:\n a.Add \n b.Delete \n c.Search \n d.Show \n e.Back to Menu \n f.Exit" );
			opt = Reader.next();
		}
	}

	public static int count;
	public static int index;
}
