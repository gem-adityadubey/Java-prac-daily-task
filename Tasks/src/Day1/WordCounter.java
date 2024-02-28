package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class WordCounter {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the text file:");
        String fileName = sc.nextLine();
        File file = new File("C:\\Java Tasks\\Day1\\Tasks\\src\\"+fileName+".txt");
        String fileContent = readFile(fileName,  file);
        if(fileContent != null) {
            Map<String, Integer> wordCount = countWord(fileContent);
            displayResult(wordCount);
        }else{
            System.out.println("FileNotFoundException");
        }
    }

    private static void displayResult(Map<String, Integer> wordCount) {
        for(Map.Entry<String,Integer> entry : wordCount.entrySet()){
            System.out.println("Key : " + entry.getKey()+" Value: "+entry.getValue());
        }
    }

    private static String readFile(String fileName, File file){
        StringBuilder content = new StringBuilder();
        try(Scanner scanner = new Scanner(file)){
            while (scanner.hasNextLine()){
                content.append(scanner.nextLine()).append("\n");
            }
            return content.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static Map<String, Integer> countWord(String fileContent) {
        Map<String , Integer> map = new HashMap<>();
        String[] words = fileContent.toLowerCase().split("\\s+");
        for(String word : words){
          word = word.replaceAll("[^a-zA-Z]","");
          if(!word.isEmpty()){
              map.put(word,map.getOrDefault(word,0)+1);
          }
        }
        return map;
    }
}
