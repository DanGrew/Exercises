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

package uk.dangrew.exercises.analysis;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

public class AverageWordLengthReportTest {

   private AverageWordLengthReport systemUnderTest;

   @Test
   public void shouldProvideAverageWithDoublePrecision() {
      systemUnderTest = new AverageWordLengthReport( 2, 5 );
      assertThat( systemUnderTest.getCalculatedAverage(), closeTo( 2.5, 0.1 ) );
   }

   @Test
   public void shouldDefendAgainstNoWordsBeingProcessed() {
      systemUnderTest = new AverageWordLengthReport( 0, 100 );
      assertThat( systemUnderTest.getCalculatedAverage(), closeTo( 0, 0.1 ) );
   }

   @Test
   public void shouldProvideAverageToThreedDecimalPlaces() {
      systemUnderTest = new AverageWordLengthReport( 7, 27 );
      assertThat( systemUnderTest.getMessage(), equalTo( "Average word length = 3.857" ) );
   }

}