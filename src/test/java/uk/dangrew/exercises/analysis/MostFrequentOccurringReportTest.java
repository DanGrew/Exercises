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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MostFrequentOccurringReportTest {

   private MostFrequentOccurringReport systemUnderTest;

   @BeforeEach
   public void initialiseSystemUnderTest() {
      systemUnderTest = new MostFrequentOccurringReport( 4, asList( 4, 5, 8 ) );
   }

   @Test
   public void shouldConcatenateResult() {
      assertThat( systemUnderTest.getMessage(), equalTo(
            "The most frequently occurring word length is 4, for word lengths of 4 & 5 & 8"
      ) );
   }
}