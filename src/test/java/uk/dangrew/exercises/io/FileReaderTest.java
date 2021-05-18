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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith( MockitoExtension.class )
public class FileReaderTest {

   private Scanner scanner;
   private FileReader systemUnderTest;

   @BeforeEach
   public void initialiseSystemUnderTest() {
      scanner = new Scanner( "first second" );
      systemUnderTest = new FileReader( scanner );
   }

   @Test
   public void shouldDetermineIfNextPresentAndProvide() {
      assertThat( systemUnderTest.hasNext(), equalTo( true ) );
      assertThat( systemUnderTest.next(), equalTo( "first" ) );
      assertThat( systemUnderTest.hasNext(), equalTo( true ) );
      assertThat( systemUnderTest.next(), equalTo( "second" ) );
      assertThat( systemUnderTest.hasNext(), equalTo( false ) );
   }

}