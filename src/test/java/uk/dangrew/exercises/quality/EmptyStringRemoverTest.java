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

package uk.dangrew.exercises.quality;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class EmptyStringRemoverTest {

   private EmptyStringRemover systemUnderTest;

   @BeforeEach
   public void initialiseSystemUnderTest() {
      systemUnderTest = new EmptyStringRemover();
   }

   @Test
   public void shouldSupportNullInput() {
      assertThat( systemUnderTest.applyQualityMeasures( null ), nullValue() );
   }

   @Test
   public void shouldRemoveEmptyString() {
      assertThat( systemUnderTest.applyQualityMeasures( "" ), nullValue() );
   }

   @Test
   public void shouldRemoveSpaceOnlyString() {
      assertThat( systemUnderTest.applyQualityMeasures( "   " ), nullValue() );
   }

   @Test
   public void shouldRemoveSpaceFromString() {
      assertThat(
            systemUnderTest.applyQualityMeasures( "  in-the-middle  " ),
            equalTo( "in-the-middle" )
      );
   }

   @Test
   public void shouldRetainOriginal() {
      assertThat( systemUnderTest.applyQualityMeasures( "anything" ), equalTo( "anything" ) );
   }
}