package uk.dangrew.exercises.functional.take3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Analyzer
{

    public String analyzeFile(String fileName) throws IOException
    {
        try (BufferedReader inputStream = new BufferedReader(new FileReader(fileName)))
        {
            return analyzeInput(inputStream.lines());
        }
    }

    public String analyzeText(String text)
    {
        return analyzeInput(Stream.of(text));
    }

    private String analyzeInput(Stream<String> input)
    {
        final var analysis = new Analysis(input);

        final var result = new StringBuilder()
                .append(String.format("Word count = %d", analysis.getWordCount()))
                .append(String.format("Average word length = %f", analysis.getAverageWordLength()));

        analysis.getWordLengthToWordCounts().entrySet().stream()
                .map(entry -> String.format("Number of words of length %d is %d", entry.getKey(), entry.getValue()))
                .forEach(result::append);

        result.append(String.format(
                "The most frequently occurring word length is %d, for word lengths of %s",
                analysis.getMostFrequentWordCount(),
                analysis.getFrequentWordLengths().stream()
                        .map(Object::toString)
                        .collect(joining(" & ")))
        );
        return result.toString();
    }

    public static void main(String[] args) throws IOException
    {
        System.out.println("BIBLE");
        new Analyzer()
                .analyzeFile("/Users/dgrew/IdeaProjects/Setup/src/exercise/bible.txt");

        System.out.println();
        System.out.println("SHORT");
        new Analyzer()
                .analyzeFile("/Users/dgrew/IdeaProjects/Setup/src/exercise/short-sample.txt");
    }
}
