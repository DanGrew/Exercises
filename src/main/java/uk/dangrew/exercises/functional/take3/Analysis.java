package uk.dangrew.exercises.functional.take3;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.counting;

public class Analysis
{

    private final Map<Integer, Long> wordLengthToWordCounts;
    private final long wordCount;
    private final double averageWordLength;
    private final long mostFrequentWordCount;
    private final Collection<Integer> frequentWordLengths;

    public Analysis(String input)
    {
        this(Stream.of(input));
    }

    public Analysis(Stream<String> input)
    {
        this.wordLengthToWordCounts = reduceLinesToWordCounts(input);
        this.wordCount = calculateWordCount(wordLengthToWordCounts);
        this.averageWordLength = calculateAverageWordCount(wordLengthToWordCounts);
        this.mostFrequentWordCount = calculateMostFrequentCount(wordLengthToWordCounts);
        this.frequentWordLengths = calculateFrequentWordLength(wordLengthToWordCounts);
    }

    private Map<Integer, Long> reduceLinesToWordCounts(Stream<String> lines)
    {
        return lines
                .flatMap(line -> stream(line.split(" ")))
                .map(word -> {
                    //mistake here - still need to remove punctuation.
                    if (word.matches(".*\\d.*"))
                    {
                        return word;
                    }

                    return word.replaceAll("[?.,\"!]", "");//fix this
                })
                .filter(not(String::isEmpty))
                .map(String::length)
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(i -> i, counting()),
                        Collections::unmodifiableMap
                ));
    }

    private long calculateWordCount(Map<Integer, Long> wordLengthToWordCounts)
    {
        return wordLengthToWordCounts.values().stream()
                .mapToLong(Long::longValue)
                .sum();
    }

    private double calculateAverageWordCount(Map<Integer, Long> wordLengthToWordCounts)
    {
        return wordLengthToWordCounts.keySet().stream()
                .mapToLong(v -> v)
                .average()
                .orElse(0);
    }

    private long calculateMostFrequentCount(Map<Integer, Long> wordLengthToWordCounts)
    {
        return wordLengthToWordCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .orElse(0L);
    }

    private Collection<Integer> calculateFrequentWordLength(Map<Integer, Long> wordLengthToWordCounts)
    {
        return wordLengthToWordCounts.entrySet().stream()
                .filter(entry -> Objects.equals(entry.getValue(), mostFrequentWordCount))
                .map(Map.Entry::getKey)
                .collect(Collectors.toUnmodifiableList());
    }

    public Collection<Integer> getFrequentWordLengths()
    {
        return frequentWordLengths;
    }

    public Map<Integer, Long> getWordLengthToWordCounts()
    {
        return wordLengthToWordCounts;
    }

    public double getAverageWordLength()
    {
        return averageWordLength;
    }

    public long getMostFrequentWordCount()
    {
        return mostFrequentWordCount;
    }

    public long getWordCount()
    {
        return wordCount;
    }
}