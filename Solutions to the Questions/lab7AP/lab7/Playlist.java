package lab7;

import java.io.Serializable;
import java.util.ArrayList;

public class Playlist implements Serializable{
	public String name;
	public ArrayList<Song> songs;
	
	public Playlist()
	{
		name = null;
		songs = new ArrayList<Song>();
	}
	
	public Playlist(String n, ArrayList<Song> s)
	{
		name = n;
		songs = s;
	}
	
	void add (Song s)
	{
		songs.add(s);
		System.out.println(songs.size());
	}
	
	void delete(String s)
	{
		for(int i = 0; i<songs.size();i++)
		{
			if(songs.get(i).name.equalsIgnoreCase(s))
			{
				songs.remove(i);
				System.out.println(songs.size());
				return;
			}
		}
		System.out.print("songs not there in the playlist");	
	}
	
	void search(String s)
	{
		for(int i = 0; i<songs.size();i++)
		{
			if(songs.get(i).name.equalsIgnoreCase(s))
			{
				System.out.println(songs.get(i));
				return;
			}
		}
		System.out.print("songs not there in the playlist");
		
	}
	
	void show()
	{
		if(songs.size()>0)
		{
			for(int i=0; i<songs.size();i++)
			{
				System.out.println(songs.get(i));
			}
		}
	}
}
