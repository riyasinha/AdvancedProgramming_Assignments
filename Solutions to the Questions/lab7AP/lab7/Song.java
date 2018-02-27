package lab7;

import java.io.Serializable;


public class Song implements Serializable
{
	String name;
	String singer;
	int duration;
	
	public Song()
	{
		name=null;
		singer = null;
		duration = 0;
	}
	
	public Song(String n, String s, int d)
	{
		name = n;
		singer = s;
		duration = d;
	}
	
	public String toString()
	{
		//System.out.println("name:" + this.name+" singer:" + this.singer + " duration:" + this.duration);
		return "name:" + this.name+" singer:" + this.singer + " duration:" + this.duration;
	}
}
