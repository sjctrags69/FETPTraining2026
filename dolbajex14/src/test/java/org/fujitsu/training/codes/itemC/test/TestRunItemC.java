package org.fujitsu.training.codes.itemC.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ TestItemC.class })
public class TestRunItemC {

	private static final Logger LOGGER = LogManager.getLogger(TestRunItemC.class);

	static {
		LOGGER.info("Running TestRunItemC suite");
	}
}
