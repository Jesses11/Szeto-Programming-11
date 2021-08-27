import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
        public static void lookForWord(ArrayList<String> list, String word) {
            for (int i = 0; i < list.size(); i++) {
                String eachLine = list.get(i);
                eachLine = eachLine.replaceAll(",", "");
                eachLine = eachLine.replaceAll("\\.", "");
                //System.out.println(eachLine);
                String[] wordsOnLine = eachLine.split(" ");
                for (int j = 0; j < wordsOnLine.length; j++) {
                    if (wordsOnLine[j].equals((word))) {
                        System.out.println("\nThe line number of the word \""+ word +  "\" is: " + (i + 1) + "\nThe index of the word \"" + word +  "\" in the array is: " + j);
                    }
                }
            }
        }


        public static void main(String[] args) {
            ArrayList<String> list = new ArrayList<>();
            try {
                File fileToRead = new File("Reading Text Assignment.txt");
                Scanner myReader = new Scanner(fileToRead);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                    list.add(data);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            System.out.println("\nEnter word to search:");
            Scanner scanner = new Scanner(System.in);
            String word = scanner.nextLine();
            lookForWord(list, word);
        }
    }



