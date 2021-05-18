
package uk.dangrew.exercises.analysis;

import uk.dangrew.exercises.report.Report;
import uk.dangrew.exercises.report.Reporter;

/**
 * Api for analyzing words and reporting some statistic(s) on those words.
 */
public interface TextAnalysis {

   /**
    * Consumes the word and analyzes it with regards to the assessment being made or statistic
    * being calculated.
    * @param word to consume and analyze.
    */
   public void analyze( String word );

   /**
    * Provides {@link Report}s to the given {@link Reporter} for all associated statistics analyzed.
    * @param reporter to report to.
    */
   public void report( Reporter reporter );
}
