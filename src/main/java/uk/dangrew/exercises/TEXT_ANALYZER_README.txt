INSTRUCTIONS
Maven project as requested. I've created a basic launcher 'TextAnalysisLauncher' which should let you select 
a file to analyze. Alternatively, you could look at the tests if you want more coded control.

BUILD
I'm not too familiar with Maven (my experience is with Gradle), so there might be
a few conventions not quite right with my quick set up that I'm unaware of. For what it's worth, I've used it
on my personal Jenkins server and it seems to have everything needed to run the test suite, so if you have 
any problems, do let me know.

REQUIREMENTS & DESIGN
The exercise requires a 'display' of the analysis. Simple solution - System.out. However, that would
never be used in production, so it would be one thing that definitely needed an alternative. I've opted for 
a simple interface here, very little effort and decouples the solution from the method of results output. 

There's no explicit mention of delimiter, and the example separates based on spaces. That has been assumed 
to be the requirement, that 'words' are split based on space.

There's no explicit requirements for running a file, or piece of text. I've opted for a simple file chooser, 
going with swing because it's included by default. Plenty of other options but this keeps it simple. Note there
are test cases which might provide a quicker method of quickly testing files or strings.

Implicit in the example is the removal of punctuation, specifically in the example full stops ("morning." 
has 8 characters but is clearly identified as 7 in the result). Assuming full stops, commas, colons, semi 
colons should be removed - sentence punctuation to be specific. 

There are multiple ways a 'word' could be interpreted. Considering other punctuation such as apostrophes, 
I would say "don't" has length 5, in that the apostrophe is counted. Therefore, apostrophes will not be 
changed. However, I could easily see this being a desirable, or configurable, so I'll follow the analysis
pattern and introduce an interface so that it could be easily modified in future. 

Spell checking and errors are important to consider. We could definitely do something such as breaking 
sentences up if the full stop hasn't got a space immediately after. However, then if we have numbers, then
we might incorrectly split the number into words "1.2" becoming "1" "2" which would be wrong. For simplicity,
this will not be accounted for making the assumption that the input text is well structured - correct spellings
and sentence structure. 

We need to consider numbers carefully. We definitely want to remove sentence punctuation for words, but
not for numbers. Simple cases - words only, remove; numbers only, don't. For a mixture, given the assumption
that the text has correct spelling and structure, it can be assumed correct and therefore left unchanged.
For example, "morning." -> "morning", "1.2" -> "1.2"; "version2.1" -> "version2.1". 

Extending the punctuation further, it's reasonable to expect other characters to be removed such as "?" and "!".
Also accounted for {}, [], () and <>.
Again, using the same assumption to ignore if containing numbers (expressions or notation for example).

I would consider dashes/hyphens to join actual words. For this exercise I'd consider two words joined by a hyphen
to be a single word. For example non-compliant.

Looking at the example provided - the daily bible - and * is used to style headings. We don't want those included
so * has been stripped out too.

There are more symbols, such as ~, @, &, %, etc. Some of these I could make the argument either way. For example,
@hotmail contains a word of length 7, or is a specific collection of characters to represent the overall email 
address as one word. The specification doesn't go into this much detail, it does however explicitly include & and so 
I would consider this a good point to get feedback from the client (or task setter). Given the design, I don't have 
concerns about accounting for these types of things so it's just a matter of implementing them as needed, if needed.

A thought on the design for these extra characters. It may be better to consider an opt in as opposed to opt out, 
meaning, instead of excluding characters, only include certain characters.

TESTING
Some objects are simple. I could test them. It's a question of value for the time it takes, 
and focus on the important aspects of the code. I've omitted some test cases based on this.

I've used 2 styles of integration test. The first is an "end to end" style ("E2E") which is used to test the 
start of a process (or sequence of steps) through to a later or last step. This test isn't concerned with
the source of the input and is simply trying to put realistic cases through that process. Not present here,
but I would consider stubbing in this sort of test to focus on the sequence of steps the test wants to prove.

The other integration test is a fuller test, exercising the entire system. At this scale of exercise, 
there's not much difference in the two tests, but the intention is that a real source of data, from a file 
containing real data, is supported and works as expected. For this test, I wouldn't expect much, if any, stubbing
other than of high level system interfaces, facades, etc.