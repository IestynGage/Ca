package com.iestyn.carjam.puzzlesolver;

import com.iestyn.carjam.puzzle.PuzzleInterface;
import java.util.LinkedList;
import java.util.Queue;


/**
 * BreathFirstSearch solver for {@link PuzzleInterface}.
 */
public class BreathFirstSearch {

  Queue<PuzzleInterface> puzzleQueue = new LinkedList<>();

  public BreathFirstSearch(PuzzleInterface firstQueue) {
    puzzleQueue.add(firstQueue);
  }

  /**
   * Solves the puzzle.

   * @return null or "No Solution"
   */

  public String getSolution() {
    while (!puzzleQueue.isEmpty()) {
      PuzzleInterface puzzle = puzzleQueue.remove();

      if (puzzle.isPuzzleComplete()) {
        System.out.println("Solution found");
        return puzzle.getMoveHistory();
      }

      puzzleQueue.addAll(puzzle.getAllMovesForAllVehicles());
    }
    System.out.println("Solution Not found");
    return "No Solution";
  }
}