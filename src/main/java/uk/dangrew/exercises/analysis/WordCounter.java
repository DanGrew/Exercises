
package uk.dangrew.exercises.analysis;

import uk.dangrew.exercises.report.Report;
import uk.dangrew.exercises.report.Reporter;

/**
 * Implementation of {@link TextAnalysis} to provide a {@link Report} on the total number of 
 * words, and average word length.
 */
public class WordCounter implements TextAnalysis {

   private int totalNumberOfWords;
   private long totalWordLength;

   /**
     * Constructs a new {@link WordCounter}.
     */
   public WordCounter() {
      this.totalNumberOfWords = 0;
      this.totalWordLength = 0;
   }

   @Override
   public void analyze( String word ) {
      totalNumberOfWords++;
      totalWordLength += word.length();
   }

   @Override
   public void report( Reporter reporter ) {
      reporter.report( new TotalWordCountReport( totalNumberOfWords ) );
      reporter.report( new AverageWordLengthReport( totalNumberOfWords, totalWordLength ) );
   }
}
