package uk.dangrew.exercises.analysis;

import uk.dangrew.exercises.report.Report;

import java.util.Objects;

/**
 * Implementation of {@link Report} that provides the result of analyzing the number of words of
 * a given word length.
 */
public class WordLengthReport implements Report {

   private static final String MESSAGE_FORMAT = "Number of words of length %s is %s";

   private final int length;
   private final int count;

   /**
    * Constructs a new {@link WordLengthReport}.
    * @param length the length of the word.
    * @param count  the number of words with the length.
    */
   public WordLengthReport( int length, int count ) {
      this.length = length;
      this.count = count;
   }

   @Override
   public String getMessage() {
      return String.format( MESSAGE_FORMAT, length, count );
   }

   @Override
   public boolean equals( Object o ) {
      if ( this == o ) {
         return true;
      }
      if ( o == null || getClass() != o.getClass() ) {
         return false;
      }
      WordLengthReport that = ( WordLengthReport ) o;
      return length == that.length &&
            count == that.count;
   }

   @Override
   public int hashCode() {
      return Objects.hash( length, count );
   }
}
