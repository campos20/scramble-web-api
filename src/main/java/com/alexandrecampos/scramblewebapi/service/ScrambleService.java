package com.alexandrecampos.scramblewebapi.service;

import java.util.List;

import com.alexandrecampos.scramblewebapi.vo.PuzzleDescriptionVo;
import com.alexandrecampos.scramblewebapi.vo.ScrambleVo;

public interface ScrambleService {

	/**
	 * Given the name of a puzzle, returns a scramble for it.
	 * 
	 * @param puzzle
	 * @return
	 */
	public ScrambleVo getScramble(String puzzle);

	/**
	 * This is pretty much a helper method for displaying info on the API.
	 * 
	 * @return
	 */
	public List<PuzzleDescriptionVo> getPuzzleDescriptionList();

}
