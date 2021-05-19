package uk.dangrew.exercises.analysis;

import uk.dangrew.exercises.report.Report;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 * Implementation of {@link Report} for providing the result of average word count.
 */
public class AverageWordLengthReport implements Report {

   private static final DecimalFormat RESULT_DECIMAL_FORMAT = new DecimalFormat( "#.###" );
   private static final String MESSAGE_FORMAT = "Average word length = %s";

   private final int totalNumberOfWords;
   private final long totalWordLength;

   private final double averageWordLength;

   /**
    * Constructs a new {@link AverageWordLengthReport}.
    * @param totalNumberOfWords total number of words in input text.
    * @param totalWordLength    total word length computed from analysis.
    */
   public AverageWordLengthReport( int totalNumberOfWords, long totalWordLength ) {
      this.totalNumberOfWords = totalNumberOfWords;
      this.totalWordLength = totalWordLength;

      if ( totalNumberOfWords == 0.0 ) {
         this.averageWordLength = 0.0;
      } else {
         this.averageWordLength = 1.0 * totalWordLength / totalNumberOfWords;
      }
   }

   /**
    * Access to the exact calculated average.
    * @return the value.
    */
   public double getCalculatedAverage() {
      return averageWordLength;
   }

   @Override
   public String getMessage() {
      return String.format( MESSAGE_FORMAT, RESULT_DECIMAL_FORMAT.format( averageWordLength ) );
   }

   @Override
   public boolean equals( Object o ) {
      if ( this == o ) {
         return true;
      }
      if ( o == null || getClass() != o.getClass() ) {
         return false;
      }
      AverageWordLengthReport that = ( AverageWordLengthReport ) o;
      return totalNumberOfWords == that.totalNumberOfWords &&
            totalWordLength == that.totalWordLength;
   }

   @Override
   public int hashCode() {
      return Objects.hash( totalNumberOfWords, totalWordLength );
   }
}
