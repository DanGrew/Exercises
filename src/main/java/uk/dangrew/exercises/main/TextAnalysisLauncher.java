
package uk.dangrew.exercises.main;

import uk.dangrew.exercises.algorithm.TextAnalyzer;
import uk.dangrew.exercises.io.WordFeed;
import uk.dangrew.exercises.report.SystemOutReporter;

import java.util.Optional;

/**
 * Entry point to the system.
 */
public class TextAnalysisLauncher {

   /**
    * Traditional launch method, taking program arguments and running analysis on the associated
    * text.
    * @param args program arguments.
    */
   public static void main( String[] args ) {
      Optional< WordFeed > wordFeed = new WordFeedProvider().buildWordFeed();
      if ( !wordFeed.isPresent() || !wordFeed.get().hasNext() ) {
         System.out.println( "Unable to read selected file. Aborting analysis." );
         return;
      }

      TextAnalyzer textAnalyzer = new TextAnalyzer();
      textAnalyzer.process( wordFeed.get() );
      textAnalyzer.report( new SystemOutReporter() );
   }

}
