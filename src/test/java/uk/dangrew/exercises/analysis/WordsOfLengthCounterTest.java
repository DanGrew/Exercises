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
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.dangrew.exercises.report.Reporter;

import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith( MockitoExtension.class )
public class WordsOfLengthCounterTest {

   private WordsOfLengthCounter systemUnderTest;
   @Mock
   private Reporter reporter;

   @BeforeEach
   public void initialiseSystemUnderTest() {
      systemUnderTest = new WordsOfLengthCounter();
   }

   @Test
   public void shouldReportNumberOfWordsWithLengthInOrder() {
      systemUnderTest.analyze( "x" );
      systemUnderTest.analyze( "xx" );
      systemUnderTest.analyze( "xxx" );
      systemUnderTest.analyze( "xxxx" );

      systemUnderTest.report( reporter );

      InOrder order = inOrder( reporter );
      order.verify( reporter ).report( new WordLengthReport( 1, 1 ) );
      order.verify( reporter ).report( new WordLengthReport( 2, 1 ) );
      order.verify( reporter ).report( new WordLengthReport( 3, 1 ) );
      order.verify( reporter ).report( new WordLengthReport( 4, 1 ) );
   }

   @Test
   public void shouldReportNumberOfWordsWithLengthWhenThereAreMultipleOfEach() {
      systemUnderTest.analyze( "x" );
      systemUnderTest.analyze( "x" );
      systemUnderTest.analyze( "xx" );
      systemUnderTest.analyze( "xxx" );
      systemUnderTest.analyze( "xxx" );
      systemUnderTest.analyze( "xxx" );
      systemUnderTest.analyze( "xxxx" );

      systemUnderTest.report( reporter );

      InOrder order = inOrder( reporter );
      order.verify( reporter ).report( new WordLengthReport( 1, 2 ) );
      order.verify( reporter ).report( new WordLengthReport( 2, 1 ) );
      order.verify( reporter ).report( new WordLengthReport( 3, 3 ) );
      order.verify( reporter ).report( new WordLengthReport( 4, 1 ) );
   }

   @Test
   public void shouldOnlyReportNumberOfWordsWithLengthWhenThereIsAtLeastOne() {
      systemUnderTest.analyze( "x" );
      systemUnderTest.analyze( "xxx" );

      systemUnderTest.report( reporter );

      InOrder order = inOrder( reporter );
      order.verify( reporter ).report( new WordLengthReport( 1, 1 ) );
      order.verify( reporter ).report( new WordLengthReport( 3, 1 ) );
      order.verify( reporter ).report( any( MostFrequentOccurringReport.class ) );
      verifyNoMoreInteractions( reporter );
   }

   @Test
   public void shouldReportMostFrequentOccuringWhenThereAreMultiple() {
      systemUnderTest.analyze( "x" );
      systemUnderTest.analyze( "x" );
      systemUnderTest.analyze( "xx" );
      systemUnderTest.analyze( "xxx" );
      systemUnderTest.analyze( "xxx" );

      systemUnderTest.report( reporter );

      verify( reporter ).report( new MostFrequentOccurringReport( 2, asList( 1, 3 ) ) );
   }

   @Test
   public void shouldReportMostFrequentOccuring() {
      systemUnderTest.analyze( "x" );
      systemUnderTest.analyze( "xx" );
      systemUnderTest.analyze( "xxx" );
      systemUnderTest.analyze( "xxx" );

      systemUnderTest.report( reporter );

      verify( reporter ).report( new MostFrequentOccurringReport( 2, asList( 3 ) ) );
   }
}