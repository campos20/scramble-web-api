package com.alexandrecampos.scramblewebapi.vo;

import java.util.List;

import lombok.Data;

@Data
public class ScrambleVo {
	private String puzzle;
	private List<String> scrambles;
	private String scrambler;
}
