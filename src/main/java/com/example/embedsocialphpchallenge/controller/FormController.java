package com.example.embedsocialphpchallenge.controller;

import com.example.embedsocialphpchallenge.service.ReviewService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
public class FormController {

    @GetMapping({"/"})
    public String showList(Model model) {
        return "form.html";
    }
    @PostMapping("/processForm")
    public void processForm(@RequestParam("rating") String rating,
                                        @RequestParam("minrating") Integer minrating,
                                        @RequestParam("date") String date,
                                        @RequestParam("text") String text
                              ) throws JSONException, IOException {

       ReviewService.sortingReviews(rating,minrating,date,text);
    }
}
