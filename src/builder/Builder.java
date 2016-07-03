/**
 * Copyright (c) 2016 Soheil Moayedi Azarpour
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Builder {

  public static void main(String[] args) {
    
    // Un-comment as needed.
    
    // One way of making a sentence.
    // makeSentenceOne();
    
    // Another way of making  sentence.
    // makeSentenceTwo();
    
    // Refactoing makeSentenceTwo() to more re-usable components.
    List categories = Arrays.asList(
      Arrays.asList("Steve"   , "Ada"       , "Gary"      , "Laurel"      , "Ellen"    ),
      Arrays.asList("gave"    , "bought"    , "received"  , "purchased"   , "wrapped"  ),
      Arrays.asList("a small" , "a pricy"   , "a cool"    , "a beautiful" , "a big"    ),
      Arrays.asList("present" , "bike"      , "car"       , "gift"        , "outfit"   ),
      Arrays.asList("today"   , "yesterday" , "last week" , "last month"  , "last year")
    );
    
    List<String> randomWords = Randomizer.fiveRandomWordsFromFiveArrays(categories);
    String sentence = Sentence.fromList(randomWords);
    System.out.printf("\n%s\n", sentence);
  }
  
  public static void makeSentenceOne() {
    // Pre-defined lists of words.
    String[] subjects = {"Steve", "Ada", "Gary", "Laurel", "Ellen"};
    String[] verbs = {"gave", "bought", "received", "purchased", "wrapped"};
    String[] adjectives = {"a small", "a pricy", "a cool", "a beautiful", "a big"};
    String[] objects = {"present", "bike", "car", "gift", "outfit"};
    String[] adverbs = {"today", "yesterday", "last week", "last month", "last year"};

    // Going to build a sentence with the following structure:
    // subject + verb + adjective + object + adverb.
    // For simplicity and better readability, an article is already 
    // included with adjectives, e.g. Steve bought an expensive present.
    //
    // Each list is added to categories in the order that 
    // want for the final sentence.
    ArrayList categories = new ArrayList();
    categories.add(Arrays.asList(subjects));
    categories.add(Arrays.asList(verbs));
    categories.add(Arrays.asList(adjectives));
    categories.add(Arrays.asList(objects));
    categories.add(Arrays.asList(adverbs));

    String sentence = "";
    for (int i = 0; i < 5; i++) {

      // Generate a new index each time. But since all arrays have
      // 5 elements, it's always between 0 and 5.
      int index = ThreadLocalRandom.current().nextInt(0, 5);
      List<String> words = (List) categories.get(i);
      String word = words.get(index);
      sentence += word + " ";
    }
    System.out.printf("\n%s\n", sentence);
  }

  public static void makeSentenceTwo() {
    // Pre-defined lists of words.
    List categories = Arrays.asList(
      Arrays.asList("Steve", "Ada", "Gary", "Laurel", "Ellen"),
      Arrays.asList("gave", "bought", "received", "purchased", "wrapped"),
      Arrays.asList("a small", "a pricy", "a cool", "a beautiful", "a big"),
      Arrays.asList("present", "bike", "car", "gift", "outfit"),
      Arrays.asList("today", "yesterday", "last week", "last month", "last year")
    );

    // Going to build a sentence with the following structure:
    // subject + verb + adjective + object + adverb.
    // For simplicity and better readability, an article is already 
    // included with adjectives, e.g. Steve bought an expensive present.
    //
    // Randomly selected words from sublists in categories
    // are added to 'sentence' array.
    List<String> sentence = new ArrayList();

    for (Object element : categories) {
      int index = ThreadLocalRandom.current().nextInt(0, 5);
      List<String> words = (List) element;
      String word = words.get(index);
      sentence.add(word);
    }

    // Concatenate all elements in 'sentence' array to make the final product.
    String product = String.join(" ", sentence);
    System.out.printf("\n%s\n", product);
  }
  
}