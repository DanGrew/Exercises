
package uk.dangrew.exercises.report;

import uk.dangrew.exercises.analysis.TextAnalysis;

/**
 * Api for handling {@link Report}s produced by the defined {@link TextAnalysis} objects.
 */
public interface Reporter {

   /**
    * Reports the given {@link Report} produced by a {@link TextAnalysis}.
    * @param report to report on.
    */
   public void report( Report report );
}
