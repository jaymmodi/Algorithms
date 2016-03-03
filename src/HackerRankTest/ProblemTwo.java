package HackerRankTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ProblemTwo {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        List<String> comments = new ArrayList<>();

        try {
            while ((line = br.readLine()) != null) {
                if(line.length() ==0 && (line = br.readLine()).length()==0){
                    break;
                }

                if (line.contains("//")) {
                    int index = line.indexOf("//");
                    String comment = line.substring(index).trim();
                    comments.add(comment);
                } else if (line.contains("/*")) {
                    int firstIndex = line.indexOf("/*");
                    int lastIndex = line.indexOf("*/");
                    String comment;
                    if (lastIndex == -1) {
                        comment = line.substring(firstIndex).trim();
                        comments.add(comment);
                        line = br.readLine();
                        while (!line.contains("*/")) {
                            comments.add(line.trim());
                            line = br.readLine();
                        }
                        lastIndex = line.indexOf("*/");
                        comment = line.substring(0, lastIndex+2);

                    } else {
                        comment = line.substring(firstIndex, lastIndex+2);
                    }
                    comments.add(comment.trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        comments.forEach(System.out::println);
    }

}
