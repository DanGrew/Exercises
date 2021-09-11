package uk.dangrew.exercises.functional.take2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.joining;

public class Analyzer
{

    public Collection<String> analyzeFile(String fileName) throws IOException
    {
        try (BufferedReader inputStream = new BufferedReader(new FileReader(fileName))){
            return analyzeInput(inputStream.lines());
        }
    }

    public Collection<String> analyzeText(String text)
    {
        return analyzeInput(Stream.of(text));
    }

    private Collection<String> analyzeInput(Stream<String> input){
        final Map<Integer, Long> wordLengthToWordCounts = reduceLinesToWordCounts(input);

        final Collection<String> results = new ArrayList<>();
        results.add(produceWordCount(wordLengthToWordCounts));
        results.add(produceAverageWordCount(wordLengthToWordCounts));
        results.addAll(produceWordLengthCounts(wordLengthToWordCounts));
        results.add(produceFrequentWordLength(wordLengthToWordCounts));
        return results;
    }

    private Map<Integer, Long> reduceLinesToWordCounts(Stream<String> lines){
        return lines
                .map( line -> line.replaceAll("/.", "")) //need to account for formatted numbers
                .flatMap( line -> asList(line.split(" ")).stream())
                .map(String::length)
                .collect(Collectors.groupingBy(i -> i, counting()));
    }

    private String produceWordCount(Map<Integer, Long> wordLengthToWordCounts){
        return "Word count = " + wordLengthToWordCounts.values().stream()
                .mapToLong(v -> v)
                .sum();
    }

    private String produceAverageWordCount(Map<Integer, Long> wordLengthToWordCounts){
        return "Average word length = " + wordLengthToWordCounts.values().stream()
                .mapToLong(v -> v)
                .average()
                .orElse(0);
    }

    private Collection<String> produceWordLengthCounts(Map<Integer, Long> wordLengthToWordCounts){
        return wordLengthToWordCounts.entrySet().stream()
                .map( entry -> String.format("Number of words of length %d is %d", entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    private String produceFrequentWordLength(Map<Integer, Long> wordLengthToWordCounts){
        final Long max = wordLengthToWordCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .orElse(0L);

        final String result = wordLengthToWordCounts.entrySet().stream()
                .filter(entry -> Objects.equals(entry.getValue(), max))
                .map(Map.Entry::getKey)
                .map(Long::toString)
                .collect(joining(" & "));

        return String.format("The most frequently occurring word length is %d, for word lengths of %s", max, result);
    }

    public static void main(String[] args) throws IOException
    {
//        new Analyzer().analyzeFile("/Users/dgrew/IdeaProjects/Setup/src/exercise/short-sample.txt").forEach( System.out::println);;
        new Analyzer()
                .analyzeFile("/Users/dgrew/IdeaProjects/Setup/src/exercise/bible.txt")
                .forEach( System.out::println);

        //new Analyzer()
        //        .analyzeText("Hello world and good morning. The date is 18/05/2016")
        //        .forEach( System.out::println);
    }
}
