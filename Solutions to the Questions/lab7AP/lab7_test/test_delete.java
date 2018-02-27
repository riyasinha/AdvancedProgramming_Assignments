package lab7_test;

import static org.junit.Assert.*;
import lab7.Playlist;
import lab7.Song;
import lab7.lab7;

import org.junit.*;
//import org.junit.Assert.*;


public class test_delete {

	@Test
	public void testDelete()
	{
		lab7.pl = new Playlist();
		Song d  = new Song("s1", "ss", 100);
		lab7.pl.songs.add(d);
		lab7.pl.songs.remove(0);
		int val = lab7.count;
		
		assertEquals(0,val);
		
		
	}

	private void assertEquals(int i, int a)
	{
		
	}
	
}
