package com.iestyn.CarJam.PuzzleSolver;

import com.iestyn.CarJam.Puzzle.PuzzleInterface;

import java.util.LinkedList;
import java.util.Queue;

public class BreathFirstSearch {

    Queue<PuzzleInterface> puzzleQueue = new LinkedList<>();

    public BreathFirstSearch(PuzzleInterface firstQueue) {
        puzzleQueue.add(firstQueue);
    }

    public String getSolution(){
        while(!puzzleQueue.isEmpty()){
            PuzzleInterface puzzle = puzzleQueue.remove();

            if(puzzle.isPuzzleComplete()) {
                System.out.println("Solution found");
                return puzzle.getMoveHistory();
            }
            for (PuzzleInterface puzzleToAdd:puzzle.getAllMovesForAllVehicles()) {
                puzzleQueue.add(puzzleToAdd);
            }
        }
        System.out.println("Solution Not found");
        return "No Solution";
    }

}