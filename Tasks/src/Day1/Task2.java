package Day1;

import java.util.*;

// #Task 2 : Write a program to print all the unique characters in a String. For instance, if the input string is “abcb”
// , the output will be the characters ‘a’ and ‘c’ as they are unique. The character ‘b’ repeats twice and so it will not be printe

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Set<Character> set = uniqChar(str);
        for(char ch : set){
            System.out.print(ch);
        }
    }

    private static Set<Character> uniqChar(String str) {
        Set<Character> set = new HashSet<>();
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : str.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                set.add(entry.getKey());
            }
        }
        return set;
    }
}
