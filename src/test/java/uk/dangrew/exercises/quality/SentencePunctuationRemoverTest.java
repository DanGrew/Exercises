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

public class SentencePunctuationRemoverTest {

   private SentencePunctuationRemover systemUnderTest;

   @BeforeEach
   public void initialiseSystemUnderTest() {
      systemUnderTest = new SentencePunctuationRemover();
   }

   @Test
   public void shouldRemoveIndividualInstances() {
      assertThat( systemUnderTest.applyQualityMeasures( "morning." ), equalTo( "morning" ) );
      assertThat( systemUnderTest.applyQualityMeasures( "morning," ), equalTo( "morning" ) );
      assertThat( systemUnderTest.applyQualityMeasures( "morning:" ), equalTo( "morning" ) );
      assertThat( systemUnderTest.applyQualityMeasures( "morning;" ), equalTo( "morning" ) );
      assertThat( systemUnderTest.applyQualityMeasures( "morning?" ), equalTo( "morning" ) );
      assertThat( systemUnderTest.applyQualityMeasures( "morning!" ), equalTo( "morning" ) );
      assertThat( systemUnderTest.applyQualityMeasures( "{morning;" ), equalTo( "morning" ) );
      assertThat( systemUnderTest.applyQualityMeasures( "morning};" ), equalTo( "morning" ) );
      assertThat( systemUnderTest.applyQualityMeasures( "[morning;" ), equalTo( "morning" ) );
      assertThat( systemUnderTest.applyQualityMeasures( "morning];" ), equalTo( "morning" ) );
      assertThat( systemUnderTest.applyQualityMeasures( "(morning;" ), equalTo( "morning" ) );
      assertThat( systemUnderTest.applyQualityMeasures( "morning);" ), equalTo( "morning" ) );
   }

   @Test
   public void shouldRemoveAllInstances() {
      assertThat( systemUnderTest.applyQualityMeasures( ".morning." ), equalTo( "morning" ) );
      assertThat( systemUnderTest.applyQualityMeasures( ",morning;" ), equalTo( "morning" ) );
      assertThat( systemUnderTest.applyQualityMeasures( "{morning}" ), equalTo( "morning" ) );
      assertThat( systemUnderTest.applyQualityMeasures( "[morning]" ), equalTo( "morning" ) );
      assertThat( systemUnderTest.applyQualityMeasures( "(morning)" ), equalTo( "morning" ) );
   }

   @Test
   public void shouldNotRemovePunctuationIfContainsNumbers() {
      assertThat( systemUnderTest.applyQualityMeasures( "2.1" ), equalTo( "2.1" ) );
      assertThat( systemUnderTest.applyQualityMeasures( "version2.14" ), equalTo( "version2.14" ) );
   }

   @Test
   public void shouldSupportNullInput() {
      assertThat( systemUnderTest.applyQualityMeasures( null ), nullValue() );
   }
}