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

package uk.dangrew.exercises.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ListWordFeedTest {

   private List< String > words;
   private ListWordFeed systemUnderTest;

   @BeforeEach
   public void initialiseSystemUnderTest() {
      words = asList( "first", "second", "third", "fourth" );

      systemUnderTest = new ListWordFeed( words );
   }

   @Test
   public void shouldIterateOverWords() {
      assertThat( systemUnderTest.hasNext(), equalTo( true ) );
      assertThat( systemUnderTest.next(), equalTo( words.get( 0 ) ) );
      assertThat( systemUnderTest.hasNext(), equalTo( true ) );
      assertThat( systemUnderTest.next(), equalTo( words.get( 1 ) ) );
      assertThat( systemUnderTest.hasNext(), equalTo( true ) );
      assertThat( systemUnderTest.next(), equalTo( words.get( 2 ) ) );
      assertThat( systemUnderTest.hasNext(), equalTo( true ) );
      assertThat( systemUnderTest.next(), equalTo( words.get( 3 ) ) );
      assertThat( systemUnderTest.hasNext(), equalTo( false ) );
   }

}