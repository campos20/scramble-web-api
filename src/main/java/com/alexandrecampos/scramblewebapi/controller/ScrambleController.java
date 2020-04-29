package com.alexandrecampos.scramblewebapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexandrecampos.scramblewebapi.service.impl.ScrambleServiceImpl;
import com.alexandrecampos.scramblewebapi.vo.ScrambleVo;

@RestController
@RequestMapping(path = "scramble")
public class ScrambleController {

	@Autowired
	private ScrambleServiceImpl scrambleService;

	@GetMapping(path = "{puzzle}")
	public ResponseEntity<ScrambleVo> getScramble(@PathVariable String puzzle) {
		return ResponseEntity.ok(scrambleService.getScramble(puzzle));

	}

}
