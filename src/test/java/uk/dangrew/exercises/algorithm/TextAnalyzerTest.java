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

package uk.dangrew.exercises.algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.dangrew.exercises.analysis.TextAnalysis;
import uk.dangrew.exercises.io.ListWordFeed;
import uk.dangrew.exercises.io.WordFeed;
import uk.dangrew.exercises.quality.QualityControl;
import uk.dangrew.exercises.report.Reporter;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;

@ExtendWith( MockitoExtension.class )
public class TextAnalyzerTest {

   @Mock
   private QualityControl qualityControl1;
   @Mock
   private QualityControl qualityControl2;
   @Mock
   private TextAnalysis analyzer1;
   @Mock
   private TextAnalysis analyzer2;

   private TextAnalyzer systemUnderTest;

   @BeforeEach
   public void initialiseSystemUnderTest() {
      systemUnderTest = new TextAnalyzer(
            asList( qualityControl1, qualityControl2 ),
            asList( analyzer1, analyzer2 )
      );
   }

   @Test
   public void shouldProcessEntireWordFeedOnAllAnalyzers() {
      doAnswer( AdditionalAnswers.returnsFirstArg() ).when( qualityControl1 ).applyQualityMeasures( anyString() );
      doAnswer( AdditionalAnswers.returnsFirstArg() ).when( qualityControl2 ).applyQualityMeasures( anyString() );

      List< String > words = asList( "first", "second", "third", "fourth" );
      WordFeed wordFeed = new ListWordFeed( words );
      systemUnderTest.process( wordFeed );

      InOrder order = inOrder( analyzer1, analyzer2 );
      for ( String word : words ) {
         order.verify( analyzer1 ).analyze( word );
         order.verify( analyzer2 ).analyze( word );
      }
   }

   @Test
   public void shouldReportMultipleAnalyzers() {
      Reporter reporter = mock( Reporter.class );
      systemUnderTest.report( reporter );

      InOrder order = inOrder( analyzer1, analyzer2 );
      order.verify( analyzer1 ).report( reporter );
      order.verify( analyzer2 ).report( reporter );
   }

   @Test
   public void shouldApplyQualityControlsBeforeAnalyzing() {
      String input = "anything";
      String firstQualityAnswer = "decent-quality";
      String secondQualityAnswer = "best-quality";
      
      when( qualityControl1.applyQualityMeasures( input ) ).thenReturn( firstQualityAnswer );
      when( qualityControl2.applyQualityMeasures( firstQualityAnswer ) ).thenReturn( secondQualityAnswer );

      systemUnderTest.process( new ListWordFeed( input ) );
      verify( analyzer1 ).analyze( secondQualityAnswer );
      verify( analyzer2 ).analyze( secondQualityAnswer );
   }
}
