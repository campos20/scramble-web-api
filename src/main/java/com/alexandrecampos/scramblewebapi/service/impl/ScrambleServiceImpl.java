package com.alexandrecampos.scramblewebapi.service.impl;

import org.springframework.stereotype.Service;

import com.alexandrecampos.scramblewebapi.service.ScrambleService;
import com.alexandrecampos.scramblewebapi.vo.ScrambleVo;

@Service
public class ScrambleServiceImpl implements ScrambleService {

	@Override
	public ScrambleVo getScramble(String puzzle) {
		ScrambleVo scramble = new ScrambleVo();
		scramble.setPuzzle("333");
		scramble.setScramble("R' U' F U2 R2 R' U' F");

		return scramble;
	}

}
