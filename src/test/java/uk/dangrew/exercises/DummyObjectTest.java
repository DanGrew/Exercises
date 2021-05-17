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

package uk.dangrew.exercises;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DummyObjectTest {
   
   private DummyObject systemUnderTest;
   
   @BeforeEach
   public void initialiseSystemUnderTest() {
      systemUnderTest = new DummyObject("Let's get going!");
   }
   
   @Test
   public void shouldProvideName() {
      assertThat(systemUnderTest.getName(), equalTo("Let's get going!"));
   }
   
}
