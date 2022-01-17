import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Delete_Questions {
    public static void main(String[] args) throws IOException, ParseException {
        String fileName="./src/main/resources/Questions.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the JSON array position to remove the question: ");
        int n = input.nextInt();
        jsonArray.remove(n);
        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
        System.out.println("Deleted!");
        //System.out.print(jsonArray);
    }
}
