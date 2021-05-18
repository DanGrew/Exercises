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

      assertThat( reporter.getResult(), equalTo(
            "Word count = 793826." +
                  "Average word length = 4.243."
      ) );
   }

}