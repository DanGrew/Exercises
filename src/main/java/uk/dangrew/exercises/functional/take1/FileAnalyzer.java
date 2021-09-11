package uk.dangrew.exercises.functional.take1;

import uk.dangrew.exercises.functional.Samples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Collection;

public class FileAnalyzer
{

    public Collection<String> analyze(String filename)
    {
        final var textAnalyzer = new TextAnalyzer();

        return textAnalyzer.analyze(
                //try resources
                new BufferedReader(new InputStreamReader(
                        Samples.class.getClassLoader().getResourceAsStream(filename)))
                        .lines()
        );
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        new FileAnalyzer()
                .analyze("exercise/bible.txt")
                .forEach(System.out::println);
    }
}
