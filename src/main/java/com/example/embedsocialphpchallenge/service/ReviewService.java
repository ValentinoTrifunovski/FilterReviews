package com.example.embedsocialphpchallenge.service;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {

    public static List<JSONObject> parseJsonFile(String filePath) throws IOException, JSONException {
            String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray jsonArray = new JSONArray(fileContent);
            List<JSONObject> jsonObjectList = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                jsonObjectList.add(jsonObject);

            }
            return jsonObjectList;
        }

}



