package com.avios.cp.base;

import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@AutoConfigureTestDatabase
public abstract class BaseTC {

	@Before
	public void initMock() {
		MockitoAnnotations.initMocks(this);
	}
}
