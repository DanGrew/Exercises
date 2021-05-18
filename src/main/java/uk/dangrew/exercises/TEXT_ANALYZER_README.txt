INSTRUCTIONS
Maven project as requested. I'm not too familiar with Maven (my experience is with Gradle), so there might be
a few conventions not quite right with my quick set up that I'm unaware of. For what it's worth, I've used it
on my personal Jenkins server and it seems to have everything needed to run the test suite, so if you have 
any problems, do let me know.

REQUIREMENTS & DESIGN
The exercise simply requires a 'display' of the analysis. Simple solution - System.out. However, that would
never be used in production, so it would be one thing that definitely needed an alternative. I've opted for 
a simple interface here, very little effort and decouples the solution from the method of results output. 

There's no explicit mention of delimiter, and the example separates based on spaces. That has been assumed 
to be the requirement, that 'words' are split based on space.

There's no explicit requirements for running a file, or piece of text. I've opted for a simple file chooser, 
going with swing because it's included by default. Plenty of other options but this keeps it simple. Note there
are test cases which might provide a quicker method of quickly testing files or strings.

TESTING
Some objects are simple. I could test them. It's a question of value for the time it takes, 
and focus on the important aspects of the code. I've omitted some tests based on this.