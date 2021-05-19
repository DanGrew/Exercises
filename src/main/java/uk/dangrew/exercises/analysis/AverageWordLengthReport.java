package uk.dangrew.exercises.analysis;

import uk.dangrew.exercises.report.Report;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 * Implementation of {@link Report} for providing the result of average word count.
 */
public class AverageWordLengthReport implements Report {

   private static final double DECIMAL_PLACE_ACCURACY = 0.001;
   private static final DecimalFormat RESULT_DECIMAL_FORMAT = new DecimalFormat( "#.###" );
   private static final String MESSAGE_FORMAT = "Average word length = %s";

   private final double averageWordLength;

   /**
    * Constructs a new {@link AverageWordLengthReport}.
    * @param averageWordLength the average word length.
    */
   public AverageWordLengthReport( double averageWordLength ) {
      this.averageWordLength = averageWordLength;
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
      return doubleEquals( that.averageWordLength, averageWordLength );
   }

   @Override
   public int hashCode() {
      return Objects.hash( averageWordLength );
   }

   /**
    * Custom double equals just for the purposes of displaying the result.
    * @param first  to compare.
    * @param second to compare.
    * @return if they are equal given {@link #DECIMAL_PLACE_ACCURACY} as an error.
    */
   private static boolean doubleEquals( double first, double second ) {
      return Math.abs( first - second ) < DECIMAL_PLACE_ACCURACY;
   }
}
