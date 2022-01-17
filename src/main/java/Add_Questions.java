import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Scanner;

public class Add_Questions {
    public static void main(String[] args) throws IOException, ParseException {
        char ch='y';
        String fileName="./src/main/resources/Questions.json";
        do {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(fileName));
            JSONObject quizObj = new JSONObject();

            Scanner input = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Add new question: ");
            quizObj.put("q", reader.readLine());
            System.out.println("Option 1: ");
            quizObj.put("1", reader.readLine());
            System.out.println("Option 2: ");
            quizObj.put("2", reader.readLine());
            System.out.println("Option 3: ");
            quizObj.put("3", reader.readLine());
            System.out.println("Option 4: ");
            quizObj.put("4", reader.readLine());
            System.out.println("Correct Answer: ");
            quizObj.put("ans", reader.readLine());

            JSONArray jsonArray = (JSONArray) obj;
            jsonArray.add(quizObj);
            //System.out.print(jsonArray);
            FileWriter file = new FileWriter(fileName);
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();
            System.out.println("Saved!");
            //System.out.print(jsonArray);
            System.out.println("\nDo you want to add more?[y/n]");
            ch=input.next().charAt(0);

        }
        while(ch!='n');

    }

}
