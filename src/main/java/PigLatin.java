public class PigLatin {
    boolean isQ = false;
    public void tester() {
        // String[] lines = loadStrings("words.txt");
        String[] lines = new String[8]; 
        try{
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
      System.out.println("there are " + lines.length + " lines");
      for (int i = 0 ; i < lines.length; i++) {
          System.out.println(pigLatin(lines[i]));
      }
    }
    public int findFirstVowel(String sWord) {
        //precondition: sWord is a valid String of length greater than 0.
        //postcondition: returns the position of the first vowel in sWord.  If there are no vowels, returns -1
      // your code goes here
  isQ=false;
    for(int i=0; i<sWord.length(); i++){
      if(sWord.substring(i,i+1).equals("a")||sWord.substring(i,i+1).equals("e")||sWord.substring(i,i+1).equals("i")||sWord.substring(i,i+1).equals("o")||sWord.substring(i,i+1).equals("u")){
        return i;
      } else if (sWord.substring(i,i+1).equals("q")){
        isQ = true;
        return i;
      }
    }
    return -1;
}
    
    public String pigLatin(String sWord) {
        //precondition: sWord is a valid String of length greater than 0
        //postcondition: returns the pig latin equivalent of sWord
        // more code should go here
      if (isQ==true){ //if its q
        return (sWord.substring(findFirstVowel(sWord)+2, sWord.length()) + sWord.substring(0,findFirstVowel(sWord)+2) + "ay");
      }else if (findFirstVowel(sWord)==0)
        return (sWord + "way");
      else if (findFirstVowel(sWord)==-1)
        return (sWord+"ay");
      else if (findFirstVowel(sWord)!=-1 && isQ == false && findFirstVowel(sWord)!=0){
        return (sWord.substring(findFirstVowel(sWord), sWord.length()) + sWord.substring(0,findFirstVowel(sWord)) + "ay");
      } else {
        return "ERROR!";
      }
    }
}//end PigLatin class
