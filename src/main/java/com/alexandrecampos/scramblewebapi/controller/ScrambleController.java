package com.alexandrecampos.scramblewebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alexandrecampos.scramblewebapi.exception.InvalidParamException;
import com.alexandrecampos.scramblewebapi.service.impl.ScrambleServiceImpl;
import com.alexandrecampos.scramblewebapi.vo.PuzzleDescriptionVo;
import com.alexandrecampos.scramblewebapi.vo.ScrambleVo;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "scramble")
public class ScrambleController {

	@Autowired
	private ScrambleServiceImpl scrambleService;

	@GetMapping(path = "available-puzzles")
	public ResponseEntity<List<PuzzleDescriptionVo>> getPuzzleDescriptionList() {
		return ResponseEntity.ok(scrambleService.getPuzzleDescriptionList());
	}

	@ApiOperation("Generate scrambles for a given puzzle. "
			+ "You may use available-puzzles to find which puzzles you can use. "
			+ "If you use an invalid option, you'll get a 3x3x3 scramble.")
	@GetMapping(path = "{puzzle}")
	public ResponseEntity<ScrambleVo> getScrambles(@PathVariable String puzzle,

			@RequestParam(defaultValue = "1") Integer numberOfScrambles) throws InvalidParamException {
		return ResponseEntity.ok(scrambleService.getScrambles(puzzle, numberOfScrambles));
	}

}
