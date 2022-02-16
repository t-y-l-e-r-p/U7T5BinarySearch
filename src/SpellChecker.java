import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class SpellChecker
{
  private ArrayList<String> dictionary;

  // constructor; uses try-catch syntax which we haven't discussed!
  public SpellChecker()
  {
    importDictionary();
  }

  public ArrayList<String> getDictionary()
  {
    return dictionary;
  }

  /** This uses LINEAR search to find a word in the dictionary ArrayList and also
    * prints out the number of words checked.
    *
    * Instead of returning the index the word is found, it simply returns TRUE
    * if the word is found, and FALSE otherwise.
  */
  public boolean linearSpellCheck(String word)
  {
    int numChecks = 0;
    
    for(int i=0; i < dictionary.size(); i++)
    {
      numChecks++;
      
      if (word.equals(dictionary.get(i)))
      {
        System.out.println("-- LINEAR SEARCH: Number of words checked (loops/runtime): " + numChecks);
        return true;
      }
    }

    System.out.println("-- LINEAR SEARCH: Number of words checked (loops/runtime): " + numChecks);
    return false;
  }
  
  /** This uses BINARY search to find a word in the dictionary ArrayList and also
    * prints out the number of words checked.
    *
    * Instead of returning the index the word is found, it simply returns TRUE
    * if the word is found, and FALSE otherwise.
  */


  // private helper method, called in the constructor, which loads the words
  // from the dictionary.txt text file into the "dictionary" instance variable!
  private void importDictionary()
  {
    String[] tmp = null;
    try
    {
      FileReader fileReader = new FileReader("src\\dictionary.txt");
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      ArrayList<String> lines = new ArrayList<String>();
      String line = null;

      while ((line = bufferedReader.readLine()) != null)
      {
        lines.add(line);
      }

      bufferedReader.close();
      tmp = lines.toArray(new String[lines.size()]);
      System.out.println("\nFile imported successfully!");
    }
    catch (IOException e)
    {
      System.out.println("Error importing file; unable to access "+ e.getMessage());
    }

    dictionary = new ArrayList<String>(Arrays.asList(tmp));
  }

  public boolean binarySpellCheck(String word)
  {
    int first = 0;
    int last = dictionary.size() - 1;
    int numChecks = 0;
    int middle;

    while (first <= last)
    {
      middle = (first + last) / 2;
      numChecks++;
      if (dictionary.get(middle).equals(word))
      {
        System.out.println("-- BINARY SEARCH: Number of words checked (loops/runtime): " + numChecks);
        return true;
      }
      else if (word.compareTo(dictionary.get(middle)) < 0)
      {
        last = middle - 1;
      }
      else
      {
        first = middle + 1;
      }
    }

    System.out.println("-- BINARY SEARCH: Number of words checked (loops/runtime): " + numChecks);
    return false; // STUB
  }

}