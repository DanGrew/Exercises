
package uk.dangrew.exercises.main;

import uk.dangrew.exercises.algorithm.TextAnalyzer;
import uk.dangrew.exercises.io.ListWordFeed;
import uk.dangrew.exercises.report.SystemOutReporter;

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
      ListWordFeed wordFeed = new ListWordFeed(
            "Today",
            "I",
            "started",
            "a",
            "coding",
            "exercise!",
            "Maven",
            "was",
            "really",
            "fun..."
      );

      TextAnalyzer textAnalyzer = new TextAnalyzer();
      textAnalyzer.process( wordFeed );
      textAnalyzer.report( new SystemOutReporter() );
   }
}
