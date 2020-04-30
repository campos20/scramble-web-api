package com.alexandrecampos.scramblewebapi.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.alexandrecampos.scramblewebapi.enums.PuzzleEnum;
import com.alexandrecampos.scramblewebapi.exception.InvalidParamException;
import com.alexandrecampos.scramblewebapi.vo.PuzzleDescriptionVo;
import com.alexandrecampos.scramblewebapi.vo.ScrambleVo;

public class ScrambleServiceImplTest {

	@InjectMocks
	private ScrambleServiceImpl service;

	private int minScrambles = 1;
	private int maxScrambles = 100;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);

		ReflectionTestUtils.setField(service, "minScrambles", minScrambles);
		ReflectionTestUtils.setField(service, "maxScrambles", maxScrambles);
	}

	@Test
	public void getScrambles() throws InvalidParamException {
		int numberOfScrambles = 3;
		ScrambleVo scrambles = service.getScrambles("333fm", numberOfScrambles);

		for (String scramble : scrambles.getScrambles()) {
			assertTrue(scramble.startsWith("R' U' F "));
		}
	}

	@Test
	public void getScramblesUnknowPuzzle() throws InvalidParamException {
		// We are not failing unknown puzzle at the moment
		int numberOfScrambles = 1;
		ScrambleVo scrambles = service.getScrambles("FOO BAR", numberOfScrambles);

		assertEquals("333", scrambles.getScrambler());
	}

	@Test(expected = InvalidParamException.class)
	public void getScramblesMinNumber() throws InvalidParamException {
		// Throw exception for small numbers
		int numberOfScrambles = minScrambles - 1;
		service.getScrambles("FOO BAR", numberOfScrambles);
	}

	@Test(expected = InvalidParamException.class)
	public void getScramblesMaxNumber() throws InvalidParamException {
		// Throw exception for large numbers
		int numberOfScrambles = maxScrambles + 1;
		service.getScrambles("FOO BAR", numberOfScrambles);
	}

	@Test
	public void getPuzzleDescriptionList() {
		// Each item on the enum must return a description
		List<PuzzleDescriptionVo> result = service.getPuzzleDescriptionList();
		assertEquals(PuzzleEnum.values().length, result.size());
	}

}
