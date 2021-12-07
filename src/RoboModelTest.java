import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoboModelTest {

	@Test
	void testGraphLength() {
		RoboModel model = new RoboModel(4);
		if (model.graphLength() != 4) {
			fail("Length should equal 4 got " + model.graphLength());
		}
		//We aren't changing the length ever. and nothing is happening to it.
		//It just returns the nodelength in the constructor. This unit test was great.
	}

	@Test
	void testSetConnections() {
		RoboModel model = new RoboModel(4);
		model.setConnections(1, 2);
		//There is literally no getter needed for this so this seems impossible to unit
		//test. I am loving these unit tests right now.
	}

	@Test
	void testIsSolvable() {
		RoboModel model = new RoboModel(3);
		model.setConnections(0, 1);
		model.setConnections(1, 2);
		model.setConnections(2, 0);
		//Sets valid values
		model.setConnections(3, 0);
		model.setConnections(1, 3);
		model.setConnections(-1, 0);
		model.setConnections(0, -1);
		//Tests setting invalid values if errors are gotten then it is a fail
		if (model.isSolvable(0) != null) {
		fail("Should be able to get from 0 to every node got " + model.isSolvable(0));
		}
		if(model.isSolvable(1) != null) {
			fail("Should be able to get from 1 to every node got " + model.isSolvable(1));
		}
		if(model.isSolvable(2) != null) {
			fail("Should be able to get from 2 to every node got " + model.isSolvable(2));
		}
		//Cannot change connections once set
		RoboModel model2 = new RoboModel(2);
		if(model2.isSolvable(0) != false) {
			fail("Shouldn't be able to get to every node got " + model2.isSolvable(0));
		}
		if(model2.isSolvable(1) != false) {
			fail("Shouldn't be able to get to every node got " + model2.isSolvable(1));
		}
	}

}
