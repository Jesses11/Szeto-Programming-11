public class Main {
    //Code your solution to problem number one here
    static int problemOne(String s){
        //this is the variable for the answer.
        int answer = 0;
        //this goes through the string at every index and adds 1 to answer variable everytime it finds a vowel.
       for (int i = 0; i<s.length(); i++){
           char vowel = s.charAt(i);
           //this tells to only add for the valid vowels, a, e, i, o, or u.
           if (vowel == 'a' || vowel == 'e'|| vowel == 'i' || vowel == 'o' || vowel == 'u'){
               answer ++;
           }
       }
       //this prints out "the number of Vowels are:" and the answer variable after the it has searched through
        //the string.
        System.out.println("The number of Vowels are: "+ answer);
        return answer;
    }
    //Code you problem number two here
    static int problemTwo(String s) {
        //this is the variable for the answer for number 2.
        int answer = 0;
        //this goes through the string when the string is still 3 less than the length of the string.
        for (int i = 0; i < s.length() - 2; i++) {
            // this looks through the next three letters, and if it sees a 'bob' then it will add one to the
            // answer variable.
            if (s.substring(i, i + 3).equals("bob")) {
                answer++;
            }
        }
        //this prints out "the number of bobs are:" and the answer variable after it has searched through the string.
        System.out.println("The number of bobs are: "+ answer);
        return answer;
    }
    //Code your solution to problem number 3 here
    static String problemThree(String s){

        //THis variable is the position where the largest substring starts at.
        int LargestStart = 0;

        //This variable will tell you the size of the largest substring so far.
        int LargestSize = 0;

        //This is start of the substring that is being combed through.
        int searchStart = 0;

        //This is the stopping point of the search through a substring.
        int searchStop = 0;

        for(int i = 0; i < s.length(); i++){

            /* This checks whether the substring will continue by
             looking at the character at position 'i.' If it is greater or equal to the character at searchStop,
              searchStop will be set to 'i'.
            */
            if(s.charAt(i) >= s.charAt(searchStop)){
                searchStop = i;

            } else {
                //This will start a new search through the next set of substrings.
                //This will show what the length of the current largest substring.
                int searchLength = (searchStop - searchStart + 1);

                /* This next part check whether the largestSize is still the largest. If it is not, the largest variable
                 will then be assigned the values of the searching variables.
                */
                if(searchLength > LargestSize){
                    LargestStart = searchStart;
                    LargestSize = searchLength;
                }

                // these two variables will need to be assigned 'i' because they need to search a new substring and
                // needs to be reset.
                searchStart= i;
                searchStop = i;
            }
        }

        //This last bit will make sure the longest one that they found, is for sure the longest one.
        int probeLength = (searchStop - searchStart + 1);
        if(probeLength > LargestSize){
            LargestStart = searchStart;
            LargestSize = probeLength;
        }
        // this prints the "Longest substring in alphabetical order is:" and the substring found in each set of
        // letters given
        s = s.substring(LargestStart, LargestStart + LargestSize);
        System.out.println("Longest substring in alphabetical order is: " + s);
        return s;
    }
    public static void main(String[] args) {
        /*
        Set s to a string and run your method using s as the parameter
        Run your method in a println statement to determine what the output was
        Once you think you have it working try running the tests.
        The tests will put your method through several different Strings to test
        all possible cases.  If you have 100% success then there is no bugs in your methods.
         */
        String s;
    }
}
