package com.alexandrecampos.scramblewebapi.enums;

import org.worldcubeassociation.tnoodle.scrambles.PuzzleRegistry;

public enum PuzzleEnum {
	THREE("333", PuzzleRegistry.THREE),
	TWO("222", PuzzleRegistry.TWO),
	FOUR("444", PuzzleRegistry.FOUR),
	FIVE("555", PuzzleRegistry.FIVE),
	SIX("666", PuzzleRegistry.SIX),
	SEVEN("777", PuzzleRegistry.SEVEN),
	THREE_BLD("333bld", PuzzleRegistry.THREE_NI),
	FOUR_BLD("444bld", PuzzleRegistry.FOUR_NI),
	FIVE_BLD("555bld", PuzzleRegistry.FIVE_NI),
	THREE_FM("333fm", PuzzleRegistry.THREE_FM),
	PYRA("pyra", PuzzleRegistry.PYRA),
	SQ1("sq1", PuzzleRegistry.SQ1),
	MEGA("minx", PuzzleRegistry.MEGA),
	CLOCK("clock", PuzzleRegistry.CLOCK),
	SKEWB("skewb", PuzzleRegistry.SKEWB),
	THREE_OH("333oh", PuzzleRegistry.THREE),
	FOUR_FAST("444fast", PuzzleRegistry.FOUR_FAST);

	private String name;
	private PuzzleRegistry puzzleRegistry;

	private PuzzleEnum(String name, PuzzleRegistry puzzleRegistry) {
		this.name = name;
		this.puzzleRegistry = puzzleRegistry;
	}

	public static PuzzleRegistry getRegistryByName(String name) {
		for (PuzzleEnum puzzle : PuzzleEnum.values()) {
			if (puzzle.name.equals(name)) {
				return puzzle.puzzleRegistry;
			}
		}
		return PuzzleRegistry.THREE;
	}

}
