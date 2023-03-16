package com.example.embedsocialphpchallenge;
import com.example.embedsocialphpchallenge.service.ReviewService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



@SpringBootApplication
public class EmbedSocialPhpChallengeApplication {

    public static void main(String[] args) throws Exception {
        List<JSONObject> jsonObjects = ReviewService.parseJsonFile("reviews (2).json");

        SpringApplication.run(EmbedSocialPhpChallengeApplication.class, args);
    }

}
