package uk.dangrew.exercises.analysis;

import uk.dangrew.exercises.report.Report;
import uk.dangrew.exercises.report.Reporter;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.Comparator.naturalOrder;

/**
 * Implementation of {@link TextAnalysis} to analyze the length of words producing {@link Report}
 * s such as {@link WordLengthReport} and {@link MostFrequentOccurringReport}.
 */
public class WordsOfLengthCounter implements TextAnalysis {

   private final Map< Integer, Integer > lengthToCount;

   /**
    * Constructs a new {@link WordsOfLengthCounter}.
    */
   public WordsOfLengthCounter() {
      this.lengthToCount = new TreeMap<>();
   }

   @Override
   public void analyze( String word ) {
      int length = word.length();
      lengthToCount.putIfAbsent( length, 0 );

      Integer currentCount = lengthToCount.get( length );
      lengthToCount.put( length, currentCount + 1 );
   }

   @Override
   public void report( Reporter reporter ) {
      lengthToCount.entrySet().stream()
            .map( entry -> new WordLengthReport( entry.getKey(), entry.getValue() ) )
            .forEach( reporter::report );

      computeMostFrequentOccurringReport().ifPresent( reporter::report );
   }

   /**
    * Computes the most frequently occurring words report by finding the maximum frequency of
    * words, then identifying the words with that frequency.
    * @return the computed report or empty if it cannot be computed.
    */
   private Optional< MostFrequentOccurringReport > computeMostFrequentOccurringReport() {
      Optional< Integer > mostFrequentLength = lengthToCount.values().stream()
            .max( naturalOrder() );
      if ( mostFrequentLength.isEmpty() ) {
         return Optional.empty();
      }

      int rawMostFrequentLength = mostFrequentLength.get();
      List< Integer > frequentLengths = lengthToCount.entrySet().stream()
            .filter( entry -> entry.getValue() == rawMostFrequentLength )
            .map( Entry::getKey )
            .collect( Collectors.toList() );

      return Optional.of(
            new MostFrequentOccurringReport( mostFrequentLength.get(), frequentLengths ) );
   }
}
