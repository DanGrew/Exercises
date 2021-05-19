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

package uk.dangrew.exercises.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.dangrew.exercises.algorithm.TextAnalyzer;
import uk.dangrew.exercises.io.FileReader;
import uk.dangrew.exercises.io.WordFeed;
import uk.dangrew.exercises.report.StringBuilderReporter;
import uk.dangrew.exercises.report.SystemOutReporter;

import java.io.FileNotFoundException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TextAnalysisIT {

   private StringBuilderReporter reporter;
   private TextAnalyzer systemUnderTest;

   @BeforeEach
   public void initialiseSystemUnderTest() {
      systemUnderTest = new TextAnalyzer();
      reporter = new StringBuilderReporter();
   }

   @Test
   public void shouldAnalyzeBasicTextFeed() throws FileNotFoundException {
      WordFeed wordFeed = new FileReader(
            TextAnalysisIT.class.getResource( "bible_daily.txt" ).getFile()
      );

      systemUnderTest.process( wordFeed );
      systemUnderTest.report( reporter );
      systemUnderTest.report( new SystemOutReporter() );

      assertThat( reporter.getResult(), equalTo(
                  "Word count = 793824" +
                  "Average word length = 4.088" +
                  "Number of words of length 1 is 18639" +
                  "Number of words of length 2 is 131843" +
                  "Number of words of length 3 is 221259" +
                  "Number of words of length 4 is 175379" +
                  "Number of words of length 5 is 95573" +
                  "Number of words of length 6 is 52967" +
                  "Number of words of length 7 is 41493" +
                  "Number of words of length 8 is 25312" +
                  "Number of words of length 9 is 16852" +
                  "Number of words of length 10 is 7559" +
                  "Number of words of length 11 is 3884" +
                  "Number of words of length 12 is 1718" +
                  "Number of words of length 13 is 876" +
                  "Number of words of length 14 is 355" +
                  "Number of words of length 15 is 92" +
                  "Number of words of length 16 is 16" +
                  "Number of words of length 17 is 5" +
                  "Number of words of length 18 is 2" +
                  "The most frequently occurring word length is 221259, for word lengths of 3"
      ) );
   }

}