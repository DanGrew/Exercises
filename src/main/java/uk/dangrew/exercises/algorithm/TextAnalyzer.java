
package uk.dangrew.exercises.algorithm;

import uk.dangrew.exercises.analysis.TextAnalysis;
import uk.dangrew.exercises.analysis.WordCounter;
import uk.dangrew.exercises.io.WordFeed;
import uk.dangrew.exercises.report.Reporter;

import java.util.Collection;

import static java.util.Arrays.asList;

/**
 * Provides the core logic for analyzing words and reporting results.
 */
public class TextAnalyzer {

   private Collection< TextAnalysis > analyzers;

   /**
    * Constructs a new {@link TextAnalyzer}.
    */
   public TextAnalyzer() {
      this( new WordCounter() );
   }

   /**
    * Constructs a new {@link TextAnalyzer}.
    * @param analyzers the different types of {@link TextAnalysis} that should be performed.
    */
   TextAnalyzer( TextAnalysis... analyzers ) {
      this.analyzers = asList( analyzers );
   }

   /**
    * Processes the given {@link WordFeed}, iterating over the words for however many are available.
    * @param wordFeed to iterate through.
    */
   public void process( WordFeed wordFeed ) {
      while ( wordFeed.hasNext() ) {
         String word = wordFeed.next();
         analyze( word );
      }
   }

   /**
    * Analyzes the given work, invoking each associated {@link TextAnalysis} in turn.
    * @param word to analyze.
    */
   private void analyze( String word ) {
      analyzers.forEach( analyzer -> analyzer.analyze( word ) );
   }

   /**
    * Reports the results of each {@link TextAnalysis} to the given {@link Reporter}.
    * @param reporter to report to.
    */
   public void report( Reporter reporter ) {
      analyzers.forEach( analyzer -> analyzer.report( reporter ) );
   }
}