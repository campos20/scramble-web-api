package com.alexandrecampos.scramblewebapi.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;
import org.worldcubeassociation.tnoodle.scrambles.Puzzle;
import org.worldcubeassociation.tnoodle.scrambles.PuzzleRegistry;

import com.alexandrecampos.scramblewebapi.service.ScrambleService;
import com.alexandrecampos.scramblewebapi.vo.ScrambleVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ScrambleServiceImpl implements ScrambleService {

	private static final Random r = Puzzle.getSecureRandom();

	@Override
	public ScrambleVo getScramble(String puzzle) {
		log.info("Get scramble for {}", puzzle);

		PuzzleRegistry lazyScrambler = getLazyScrambler(puzzle);
		final Puzzle scrambler = lazyScrambler.getScrambler();
		String scramble = scrambler.generateWcaScramble(r);

		ScrambleVo result = new ScrambleVo();
		result.setPuzzle(puzzle);
		result.setScramble(scramble);

		return result;
	}

	private PuzzleRegistry getLazyScrambler(String puzzle) {
		switch (puzzle) {
		case ("333"):
			return PuzzleRegistry.THREE;
		case ("222"):
			return PuzzleRegistry.TWO;
		case ("444"):
			return PuzzleRegistry.FOUR;
		case ("555"):
			return PuzzleRegistry.FIVE;
		case ("666"):
			return PuzzleRegistry.SIX;
		case ("777"):
			return PuzzleRegistry.SEVEN;
		case ("333ni"):
			return PuzzleRegistry.THREE_NI;
		case ("444ni"):
			return PuzzleRegistry.FOUR_NI;
		case ("555ni"):
			return PuzzleRegistry.FIVE_NI;
		case ("333fm"):
			return PuzzleRegistry.THREE_FM;
		case ("pyra"):
			return PuzzleRegistry.PYRA;
		case ("sq1"):
			return PuzzleRegistry.SQ1;
		case ("minx"):
			return PuzzleRegistry.MEGA;
		case ("clock"):
			return PuzzleRegistry.CLOCK;
		case ("skewb"):
			return PuzzleRegistry.SKEWB;
		case ("333oh"):
			return PuzzleRegistry.THREE;
		case ("444fast"):
			return PuzzleRegistry.FOUR_FAST;
		default:
			return PuzzleRegistry.THREE;
		}

	}

}
