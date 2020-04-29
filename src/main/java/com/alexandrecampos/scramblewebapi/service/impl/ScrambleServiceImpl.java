package com.alexandrecampos.scramblewebapi.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.worldcubeassociation.tnoodle.scrambles.Puzzle;
import org.worldcubeassociation.tnoodle.scrambles.PuzzleRegistry;

import com.alexandrecampos.scramblewebapi.enums.PuzzleEnum;
import com.alexandrecampos.scramblewebapi.service.ScrambleService;
import com.alexandrecampos.scramblewebapi.vo.PuzzleDescriptionVo;
import com.alexandrecampos.scramblewebapi.vo.ScrambleVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ScrambleServiceImpl implements ScrambleService {

	private static final Random r = Puzzle.getSecureRandom();

	@Override
	public ScrambleVo getScramble(String puzzle) {
		log.info("Get scramble for {}", puzzle);

		PuzzleRegistry lazyScrambler = PuzzleEnum.getRegistryByName(puzzle);
		final Puzzle scrambler = lazyScrambler.getScrambler();
		String scramble = scrambler.generateWcaScramble(r);

		ScrambleVo result = new ScrambleVo();
		result.setPuzzle(puzzle);
		result.setScramble(scramble);
		result.setScrambler(scrambler.getShortName());

		return result;
	}

	@Override
	public List<PuzzleDescriptionVo> getPuzzleDescriptionList() {
		log.info("Get available puzzle list");
		return Arrays.stream(PuzzleEnum.values()).map(puzzleEnum -> {
			PuzzleDescriptionVo description = new PuzzleDescriptionVo();
			description.setPuzzle(puzzleEnum.getName());
			description.setDescription(puzzleEnum.getDescription());
			return description;
		}).collect(Collectors.toList());
	}
}
