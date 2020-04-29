package com.alexandrecampos.scramblewebapi.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.alexandrecampos.scramblewebapi.vo.ScrambleVo;

public class ScrambleServiceImplTest {

	@InjectMocks
	private ScrambleServiceImpl service;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void getScrambles() {
		ScrambleVo scramble = service.getScramble("333fm");
		String scrambleString = scramble.getScramble();
		assertTrue(scrambleString.startsWith("R' U' F "));
	}
	
	@Test
	public void getScramblesUnknowPuzzle() {
		// We are not failing unknown puzzle at the moment
		ScrambleVo scramble = service.getScramble("FOO BAR");
		assertNotNull(scramble.getScramble());
	}

}
