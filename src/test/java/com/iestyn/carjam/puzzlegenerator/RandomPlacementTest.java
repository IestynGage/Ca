package com.iestyn.carjam.puzzlegenerator;

import com.iestyn.carjam.puzzle.PuzzleInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

class RandomPlacementTest {

  @RepeatedTest(1_000)
  public void generatePuzzleTest() {
    PuzzleInterface puzzle = RandomPlacement.generatePuzzle();

    Assertions.assertTrue(PuzzleInterface.validPuzzle(puzzle));
    // check array no repeated vehicle
    //check can solve
  }
}