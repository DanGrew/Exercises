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
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class AverageWordLengthReportTest {

   private AverageWordLengthReport systemUnderTest;


   @Test
   public void shouldProvideAverageToThreeDecimalPlaces() {
      systemUnderTest = new AverageWordLengthReport( 3.857 );
      assertThat( systemUnderTest.getMessage(), equalTo( "Average word length = 3.857" ) );
   }

   @Test
   public void shouldBeEqualToThreeDecimalPlaces() {
      assertThat( new AverageWordLengthReport( 3.857 ),
            equalTo( new AverageWordLengthReport( 3.857 ) ) );
      
      assertThat( new AverageWordLengthReport( 3.856 ),
            not(equalTo( new AverageWordLengthReport( 3.857 ) ) ));
      
      assertThat( new AverageWordLengthReport( 3.8571 ),
            equalTo( new AverageWordLengthReport( 3.8572 ) ) );
   }
}