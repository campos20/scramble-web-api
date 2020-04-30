package com.alexandrecampos.scramblewebapi.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.worldcubeassociation.tnoodle.scrambles.Puzzle;
import org.worldcubeassociation.tnoodle.scrambles.PuzzleRegistry;

import com.alexandrecampos.scramblewebapi.enums.PuzzleEnum;
import com.alexandrecampos.scramblewebapi.exception.InvalidParamException;
import com.alexandrecampos.scramblewebapi.service.ScrambleService;
import com.alexandrecampos.scramblewebapi.vo.PuzzleDescriptionVo;
import com.alexandrecampos.scramblewebapi.vo.ScrambleVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ScrambleServiceImpl implements ScrambleService {

	private static final Random r = Puzzle.getSecureRandom();

	@Value("${service.scramble.min.scrambles}")
	private int minScrambles;

	@Value("${service.scramble.max.scrambles}")
	private int maxScrambles;

	@Override
	public ScrambleVo getScrambles(String puzzle, Integer n) throws InvalidParamException {
		// TODO cache scrambles using threads (or coroutines)

		int numberOfScrambles = Optional.ofNullable(n).orElse(minScrambles);
		log.info("Generate {} scrambles for {}", numberOfScrambles, puzzle);

		validateNumberOfRequestedScrambles(numberOfScrambles);

		PuzzleRegistry lazyScrambler = PuzzleEnum.getRegistryByName(puzzle);
		final Puzzle scrambler = lazyScrambler.getScrambler();
		ScrambleVo result = new ScrambleVo();
		result.setPuzzle(puzzle);
		result.setScrambler(scrambler.getShortName());

		List<String> scrambles = new ArrayList<>();
		for (int i = 0; i < numberOfScrambles; i++) {
			String scramble = scrambler.generateWcaScramble(r);
			scrambles.add(scramble);
		}
		result.setScrambles(scrambles);
		log.info("Scrambles generated");

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

	private void validateNumberOfRequestedScrambles(int numberOfScrambles) throws InvalidParamException {
		if (numberOfScrambles < minScrambles) {
			String msg = String.format("The minimum number of scrambles is %s and you provided %s", minScrambles,
					numberOfScrambles);
			log.error(msg);
			throw new InvalidParamException(msg);
		}

		if (numberOfScrambles > maxScrambles) {
			String msg = String.format("The maximum number of scrambles is %s and you provided %s", maxScrambles,
					numberOfScrambles);
			log.error(msg);
			throw new InvalidParamException(msg);
		}
	}
}
