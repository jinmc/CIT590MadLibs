/**
 * Jinmo Chong's Code
 */

package madLib;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MadLibTest {
	MadLib ml;
	@Before
	public void setUp() {
		 ml = new MadLib();
	}

	@Test
	public void testCheck() {
		ml.word = "place";
		assertFalse(ml.check());
		ml.word = "adjective";
		assertTrue(ml.check());

	}

}
