package uk.dangrew.exercises.analysis;

import uk.dangrew.exercises.io.WordFeed;
import uk.dangrew.exercises.report.Report;

import java.util.Objects;

/**
 * Implementation of {@link Report} that captures the result of analyzing the word count of a
 * {@link WordFeed}.
 */
public class TotalWordCountReport implements Report {

   private static final String MESSAGE_FORMAT = "Word count = %d";

   private final int totalNumberOfWords;

   /**
    * Constructs a new {@link TotalWordCountReport}.
    * @param totalNumberOfWords resulting value from analysis.
    */
   public TotalWordCountReport( int totalNumberOfWords ) {
      this.totalNumberOfWords = totalNumberOfWords;
   }

   @Override
   public String getMessage() {
      return String.format( MESSAGE_FORMAT, totalNumberOfWords );
   }

   @Override
   public boolean equals( Object o ) {
      if ( this == o ) {
         return true;
      }
      if ( o == null || getClass() != o.getClass() ) {
         return false;
      }
      TotalWordCountReport that = ( TotalWordCountReport ) o;
      return totalNumberOfWords == that.totalNumberOfWords;
   }

   @Override
   public int hashCode() {
      return Objects.hash( totalNumberOfWords );
   }
}
