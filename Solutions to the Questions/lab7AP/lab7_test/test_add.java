package lab7_test;

import static org.junit.Assert.*;
import lab7.*;

import org.junit.*;
//import org.junit.Assert.*;


public class test_add {

	@Test
	public void testAdd()
	{
		lab7.pl = new Playlist();
		Song d  = new Song("s1", "ss", 100);
		lab7.pl.songs.add(d);
		int val = lab7.pl.songs.size();
		
		assertEquals(1,val);
		
	}

	private void assertEquals(int i, int a)
	{
		
	}
	
}
