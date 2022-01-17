import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Read_Que_and_Do_the_Quiz {
    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("There will randomly generate 5 questions");
        System.out.println("Each question has 4 options (a, b, c, or d)");
        System.out.println("Please input only the option of the correct answer");
        System.out.println("For example: type a and press Enter if the correct ans is (a)");
        System.out.println("------------------------- Quiz Start --------------------------");
        Scanner input = new Scanner(System.in);
        int c = 1;
        int count = 0;
        while(c<=5){
            //System.out.print("Question number - ");
            int total_questions = NumberOfQuestions();
            int n = RandomNumber(total_questions);
            String answer = ReadJSON(n);
            System.out.print("Ans: ");
            String ans = input.nextLine();
            if(answer.equals(ans)){
                count++;
            }
            c++;
        }
        System.out.println("Quiz ended.");
        System.out.println("Marks obtained - "+count+" out of 5");

    }
    static int RandomNumber(int total_que){
        int min = 1;
        int max = total_que;

        Scanner input = new Scanner(System.in);
        double rand_num = Math.random() * (max - min) + min;
        int num = (int) rand_num;    // typecast
        //System.out.println(num);
        return num;
    }
    static String ReadJSON(int pos) throws IOException, ParseException {
        String fileName="./src/main/resources/Questions.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        //System.out.println(jsonArray);
        JSONObject json = (JSONObject) jsonArray.get(pos);
        Scanner str = new Scanner(System.in);

        String que = (String) json.get("q");
        String op1 = (String) json.get("1");
        String op2 = (String) json.get("2");
        String op3 = (String) json.get("3");
        String op4 = (String) json.get("4");
        String correct_ans = (String) json.get("ans");
        System.out.println(que);
        System.out.println(op1);
        System.out.println(op2);
        System.out.println(op3);
        System.out.println(op4);

        return correct_ans;
    }
    static int NumberOfQuestions() throws IOException, ParseException {
        String fileName="./src/main/resources/Questions.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;

        int n = jsonArray.size();
        return n;
    }
}