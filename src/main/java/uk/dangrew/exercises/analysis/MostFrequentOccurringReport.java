package uk.dangrew.exercises.analysis;

import uk.dangrew.exercises.report.Report;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Collections.unmodifiableCollection;

/**
 * Implementation of {@link Report} that provides the result of analyzing the most frequently
 * occurring word lengths.
 */
public class MostFrequentOccurringReport implements Report {

   private static final String MESSAGE_FORMAT =
         "The most frequently occurring word length is %s, for word lengths of %s";

   private final int mostFrequentLengthCount;
   private final Collection< Integer > wordLengths;

   /**
    * Constructs a new {@link MostFrequentOccurringReport}.
    * @param mostFrequentLengthCount number of times the most frequent word(s) occur.
    * @param wordLengths             word lengths that occur the most.
    */
   public MostFrequentOccurringReport(
         int mostFrequentLengthCount, Collection< Integer > wordLengths
   ) {
      this.mostFrequentLengthCount = mostFrequentLengthCount;
      this.wordLengths = unmodifiableCollection( wordLengths );
   }

   @Override
   public String getMessage() {
      String collatedWordLengths = wordLengths.stream()
            .map( Object::toString )
            .collect( Collectors.joining( " & " ) );
      return String.format( MESSAGE_FORMAT, mostFrequentLengthCount, collatedWordLengths );
   }

   @Override
   public boolean equals( Object o ) {
      if ( this == o ) {
         return true;
      }
      if ( o == null || getClass() != o.getClass() ) {
         return false;
      }
      MostFrequentOccurringReport that = ( MostFrequentOccurringReport ) o;
      return mostFrequentLengthCount == that.mostFrequentLengthCount &&
            Objects.equals( new HashSet<>( wordLengths ), new HashSet<>( that.wordLengths ) );
   }

   @Override
   public int hashCode() {
      return Objects.hash( mostFrequentLengthCount, wordLengths );
   }

   @Override
   public String toString() {
      return getMessage();
   }
}
