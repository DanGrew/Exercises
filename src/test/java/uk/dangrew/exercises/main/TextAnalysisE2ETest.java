// **************************************************
//                        GSDK                       
//           Graffica System Development Kit         
//                                                   
//  Release Version: {RELEASE_VERSION}               
//  Copyright: (c) Graffica Ltd {RELEASE_DATE}       
//                                                   
// **************************************************
//  This software is provided under the terms of the 
//        Graffica Software Licence Agreement        
//                                                   
//     THIS HEADER MUST NOT BE ALTERED OR REMOVED    
// **************************************************

package uk.dangrew.exercises.main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.dangrew.exercises.algorithm.TextAnalyzer;
import uk.dangrew.exercises.io.FileReader;
import uk.dangrew.exercises.io.ListWordFeed;
import uk.dangrew.exercises.io.WordFeed;
import uk.dangrew.exercises.report.StringBuilderReporter;
import uk.dangrew.exercises.report.SystemOutReporter;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TextAnalysisE2ETest {

   private StringBuilderReporter reporter;
   private TextAnalyzer systemUnderTest;

   @BeforeEach
   public void initialiseSystemUnderTest() {
      systemUnderTest = new TextAnalyzer();
      reporter = new StringBuilderReporter();
   }

   @Test
   public void shouldPassExerciseExample() {
      String input = "Hello world & good morning. The date is 18/05/2016";
      WordFeed wordFeed = new FileReader( new Scanner( input ) );

      systemUnderTest.process( wordFeed );
      systemUnderTest.report( reporter );
      systemUnderTest.report( new SystemOutReporter() );

      assertThat( reporter.getResult(), equalTo(
            "Word count = 9" +
                  "Average word length = 4.556" +
                  "Number of words of length 1 is 1" +
                  "Number of words of length 2 is 1" +
                  "Number of words of length 3 is 1" +
                  "Number of words of length 4 is 2" +
                  "Number of words of length 5 is 2" +
                  "Number of words of length 7 is 1" +
                  "Number of words of length 10 is 1" +
                  "The most frequently occurring word length is 2, for word lengths of 4 & 5"
      ) );
   }

   @Test
   public void shouldAnalyzeBasicTextFeed() {
      ListWordFeed wordFeed = new ListWordFeed(
            "Today",
            "I",
            "started",
            "a",
            "coding",
            "exercise!",
            "Maven",
            "was",
            "really",
            "fun..."
      );

      systemUnderTest.process( wordFeed );
      systemUnderTest.report( reporter );
      systemUnderTest.report( new SystemOutReporter() );

      assertThat( reporter.getResult(), equalTo(
            "Word count = 10" +
                  "Average word length = 4.5" +
                  "Number of words of length 1 is 2" +
                  "Number of words of length 3 is 2" +
                  "Number of words of length 5 is 2" +
                  "Number of words of length 6 is 2" +
                  "Number of words of length 7 is 1" +
                  "Number of words of length 8 is 1" +
                  "The most frequently occurring word length is 2," +
                  " for word lengths of 1 & 3 & 5 & 6" ) );
   }

   @Test
   public void shouldRemoveEmptyStringsOrPunctuationOnlyString() {
      ListWordFeed wordFeed = new ListWordFeed(
            "Something",
            "...",
            " to ",
            ", ,",
            "       think ",
            "about...",
            " . "
      );

      systemUnderTest.process( wordFeed );
      systemUnderTest.report( reporter );
      systemUnderTest.report( new SystemOutReporter() );

      assertThat( reporter.getResult(), equalTo(
            "Word count = 4" +
                  "Average word length = 5.25" +
                  "Number of words of length 2 is 1" +
                  "Number of words of length 5 is 2" +
                  "Number of words of length 9 is 1" +
                  "The most frequently occurring word length is 2, for word lengths of 5"
      ) );
   }

   @Test
   public void shouldRemoveSpeechMarks() {
      ListWordFeed wordFeed = new ListWordFeed(
            "He",
            "said",
            "\"I've",
            "had",
            "enough!\""
      );

      systemUnderTest.process( wordFeed );
      systemUnderTest.report( reporter );
      systemUnderTest.report( new SystemOutReporter() );

      assertThat( reporter.getResult(), equalTo(
            "Word count = 5" +
                  "Average word length = 3.8" +
                  "Number of words of length 2 is 1" +
                  "Number of words of length 3 is 1" +
                  "Number of words of length 4 is 2" +
                  "Number of words of length 6 is 1" +
                  "The most frequently occurring word length is 2, for word lengths of 4"
      ) );
   }

}