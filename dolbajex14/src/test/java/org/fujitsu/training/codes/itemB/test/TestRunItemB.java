package org.fujitsu.training.codes.itemB.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ TestItemB.class })
public class TestRunItemB {

	private static final Logger LOGGER = LogManager.getLogger(TestRunItemB.class);

	static {
		LOGGER.info("Running TestRunItemB suite for marshall and unmarshall tests");
	}
}
