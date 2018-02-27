package lab7_test;

import static org.junit.Assert.*;
import lab7.Playlist;
import lab7.Song;
import lab7.lab7;

import org.junit.*;

public class test_search {

	@Test
	public void testSearch()
	{
		lab7.pl = new Playlist();
		Song s = new Song("yellow", "coldplay", 400);
		lab7.pl.songs.add(s);
		Song st = new Song("yellow", "coldplay", 400);
		assertEquals(st,s);
		
		
	}
	
	private void assertEquals(Song st, Song s)
	{
		
	}
}
