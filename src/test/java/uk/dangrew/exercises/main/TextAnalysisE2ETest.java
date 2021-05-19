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
import uk.dangrew.exercises.io.ListWordFeed;
import uk.dangrew.exercises.report.StringBuilderReporter;
import uk.dangrew.exercises.report.SystemOutReporter;

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
            "Word count = 10." +
            "Average word length = 4.9." ) );
   }

}