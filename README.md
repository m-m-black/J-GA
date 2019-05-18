# J-GA
Simple Genetic Algorithm package, written in Java

Selection scheme: mating pool built from best-fit individuals

Crossover: randomly assigned single-point crossover, 2 parents

TODO

• Cost function

HOW TO RUN

Type "run" followed by a list of parameters, as follows:

> run [population size] [number of generations] [crossover rate] [mutation rate] [target phrase]

Target phrases will need to be hard coded in Main.setTarget().

Custom cost functions will need to be coded in Cost.assess().

Based on the cost function used, maxCost will need to be set in Population.select().

If comparison is used as the cost function i.e. each step is penalised by 1 if not matching, maxCost = length of target.

If error is used as the cost function i.e. each step adds absolute error to cost, maxCost = target.length * maximum error per step, 16 for a 4-bit representation.
