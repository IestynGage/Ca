package com.iestyn.carjam.api;

import com.iestyn.carjam.puzzle.ListPuzzle;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * API to create a puzzle.
 */
@RestController
public class PuzzleApi {

  @PostMapping("/puzzle/")
  ListPuzzle generatePuzzle(@RequestParam(required = false) final Integer solutionLength) {
    return null;
  }
}
