import static org.junit.Assert.*;

import org.junit.Test;

public class LCA_Test {

	@Test
	public void testIsEmpty() {
		LCA test = new LCA();
		boolean isEmpty = test.isEmpty();
		assertEquals(isEmpty, true);
		test.put(1, 100);
		test.put(2, 110);
		test.put(3, 120);
		test.put(4, 130);
		isEmpty = test.isEmpty();
		assertEquals(isEmpty, false);
	}

}
