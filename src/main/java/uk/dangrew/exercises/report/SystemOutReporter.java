
package uk.dangrew.exercises.report;

/**
 * Implementation of {@link Reporter} that simply directs output to {@link System#out}.
 */
public class SystemOutReporter implements Reporter {

   @Override
   public void report( Report report ) {
      System.out.println( report.getMessage() );
   }
}
