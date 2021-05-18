package uk.dangrew.exercises.report;

import uk.dangrew.exercises.analysis.TextAnalysis;

/**
 * Api for defining a result of {@link TextAnalysis}, and accessing its data.
 */
public interface Report {

   /**
    * Provides a readable message of the report.
    * @return the string message.
    */
   public String getMessage();
}
