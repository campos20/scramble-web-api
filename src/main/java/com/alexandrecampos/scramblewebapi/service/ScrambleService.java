package com.alexandrecampos.scramblewebapi.service;

import com.alexandrecampos.scramblewebapi.vo.ScrambleVo;

@FunctionalInterface
public interface ScrambleService {

	/**
	 * Given the name of a puzzle, returns a scramble for it.
	 * 
	 * @param puzzle
	 * @return
	 */
	public ScrambleVo getScramble(String puzzle);

}
