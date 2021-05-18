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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.dangrew.exercises.report.Reporter;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;

@ExtendWith( MockitoExtension.class )
public class WordCounterTest {

   private List< String > sampleWords;

   @Mock
   private Reporter reporter;
   private WordCounter systemUnderTest;

   @BeforeEach
   public void initialiseSystemUnderTest() {
      systemUnderTest = new WordCounter();

      sampleWords = asList(
            "this",
            "is",
            "what",
            "sentences",
            "look",
            "like"
      );
   }

   @Test
   public void shouldAnalyzeNumberOfWordsForSingleWord() {
      systemUnderTest.analyze( "anything" );
      systemUnderTest.report( reporter );

      verify( reporter ).report( new TotalWordCountReport( 1 ) );
   }

   @Test
   public void shouldAnalyzeNumberOfWordsForMultipleWords() {
      sampleWords.forEach( systemUnderTest::analyze );
      systemUnderTest.report( reporter );

      verify( reporter ).report( new TotalWordCountReport( 6 ) );
   }

   @Test
   public void shouldAnalyzeAverageWordLengthForSingleWord() {
      systemUnderTest.analyze( "anything" );
      systemUnderTest.report( reporter );

      verify( reporter ).report( new AverageWordLengthReport( 1, 8 ) );
   }

   @Test
   public void shouldAnalyzeAverageWordLengthForMultipleWords() {
      sampleWords.forEach( systemUnderTest::analyze );
      systemUnderTest.report( reporter );

      verify( reporter ).report( new AverageWordLengthReport( 6, 27 ) );
   }

}