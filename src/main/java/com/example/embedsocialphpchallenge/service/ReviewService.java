package com.example.embedsocialphpchallenge.service;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReviewService{

    public static List<JSONObject> parseJsonFile(String filePath) throws IOException, JSONException {
        String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONArray jsonArray = new JSONArray(fileContent);
        ArrayList<JSONObject> jsonObjectList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            jsonObjectList.add(jsonObject);

        }
        return jsonObjectList;
    }


    public static void sortingReviews(String byRating, int minRating, String byDate, String byText) throws JSONException, IOException {
        List<JSONObject> objects = parseJsonFile("reviews.json");
        objects = objects.stream()
                .filter(o -> {
                    try {
                        return Integer.parseInt(String.valueOf(o.get("rating"))) >= minRating;
                    } catch (JSONException e) {
                        return Boolean.parseBoolean(e.getMessage());
                    }
                })
                .collect(Collectors.toList());
        if(byText.equals("Yes") && byRating.equals("Highest First") && byDate.equals("Oldest First"))
        {
            objects.sort(new JSONComparator());
        }
        else if (!byText.equals("Yes") && !byRating.equals("Highest First") && !byDate.equals("Oldest First"))
            objects.sort(new JSONComparator().reversed());


        System.out.println(objects);
    }
static class JSONComparator implements Comparator<JSONObject>{


    @SneakyThrows
    @Override
    public int compare(JSONObject o1, JSONObject o2) {
        String t1 = (String) o1.get("reviewText");
        String t2 = (String) o2.get("reviewText");
        if(t1.equals(t2)) {
            String v1 = (String) o1.get("rating");
            String v2 = (String) o2.get("rating");
            if(v1.equals(v2))
            {
                Date d1 = (Date) o1.get("reviewCreatedOnDate");
                Date d2 = (Date) o2.get("reviewCreatedOnDate");
                return d1.compareTo(d2);
            }
            return v1.compareTo(v2);
        }
        else{
            return t1.compareTo(t2);
        }
    }
}
}



