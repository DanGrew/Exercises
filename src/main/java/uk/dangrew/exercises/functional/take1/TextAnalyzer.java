package uk.dangrew.exercises.functional.take1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toMap;

public class TextAnalyzer
{

    public Collection<String> analyze(String input){
        return analyze(singletonList(input));
    }

    public Collection<String> analyze(Collection<String> input){
        return analyze(input.stream());
    }

    public Collection<String> analyze(Stream<String> inputStream){
        final Collection<String> allWords = inputStream
                .map(this::identifyWords)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return analyzeWords(allWords);
    }

    public Collection<String> identifyWords(String input){
        return asList(
                input
                    .replace(".", "")
                    .split(" ")
        );
    }

    private Collection<String> analyzeWords(Collection<String> words)
    {
        final Map<Integer, Collection<String>> sizedWords = mapWordsToLengths(words);

        final Collection<String> result = new ArrayList<>();
        result.add(countTotalWords(sizedWords));
        result.addAll(countWordsOfAllLengths(sizedWords));

        return result;
    }

    private Map<Integer, Collection<String>> mapWordsToLengths(Collection<String> words){
        return words.stream()
                .collect(toMap(String::length, Arrays::asList, this::mergeWordsOfSameLength, TreeMap::new ));
    }

    private Collection<String> mergeWordsOfSameLength(Collection<String> first, Collection<String> second){
        //naff, needs to change
        return Stream.concat(first.stream(), second.stream())
                .collect(Collectors.toList());
    }

    private String countTotalWords(Map<Integer, Collection<String>> words){
        return "Word count = " + words.entrySet().stream()
                .map(Map.Entry::getValue)
                .mapToInt(Collection::size)
                .sum();
    }

    private String countWordsOfLength(Collection<String> words, int length){
        return String.format(
                "Number of words of length %d is %d",
                length,
                words.size()
        );
    }

    private Collection<String> countWordsOfAllLengths(Map<Integer, Collection<String>> words){
        return words.entrySet().stream()
                .map( entry -> countWordsOfLength(entry.getValue(), entry.getKey()))
                .collect(Collectors.toList());
    }
}
