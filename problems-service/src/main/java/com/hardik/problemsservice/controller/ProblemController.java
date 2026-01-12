package com.hardik.problemsservice.controller;

import com.hardik.problemsservice.model.Problem;
import com.hardik.problemsservice.service.ProblemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class ProblemController {

    private final ProblemService problemService;

    public ProblemController(ProblemService problemService) {
        this. problemService = problemService;
    }

    @GetMapping("/hello")
    String hello() {
        return "Leet";
    }

    @GetMapping("/me")
    String me(Principal principal) {
        return "Hola " + principal.getName();
    }

    @GetMapping("/all")
    List<Problem> findAll() {
        return problemService.findAll();
    }

    @GetMapping("/find/{id}")
    Problem findById(@PathVariable int id) {
        return problemService.findProblem(id);
    }
}