# Frequently Asked Questions
### Overview
##### Contributions
AREA 2020 Position Paper: Literature Review, System Architecture, Action Failure Monitoring algorithm. 

##### Assumptions
All perceptions are assumed to be correct.

##### Gwendolen
Cardoso et al.’s reconfigurability framework was developed to work with Gwendolen which we are looking to extend to handle situations where plans cant be replaced.
Dennis and Fisher described semantics that are suitable for adapting Gwendolen to handle actions with durations and failures in their 2014 paper.
We have scope for integrating our work with the Agent JavaPathfinder which is capable of model checking programs created in Gwendolen.

### Definitions

### BDI
###### Do the post-conditions of an action also take into account the duration of the action itself and in what ways that can be expressed.
Yes, the abort condition requires this. Action Descriptions contain: an action, it's pre-conditions and post-conditions, and a duration. Dennis and Fisher's semantics have suggested using time stamps to maintain this duration (i.e., "within 5 minutes")

### Self-Model
###### Modelling the environment effectively can be complex, how will this be done?
We do not assume that the environment is modelled perfectly (not sound and complete), although we do assume a perfect report of what we can receive. The environment description will be updated with perception. The system is meant for coping with innacuracy, not creating a complete model.

###### Which concepts should the self- model include?


### Failure Detection
###### Specify formally and precisely what a persistent failure really is and what it may be the reasons to have such a failure.
###### Is there a notion of repeating an action a certain amount of times until that action is considered faulty? What does it mean for an action to be in a situation of "persistent failure"?
###### What about the order of the actions (e.g., an action can be faulty only if executed after another one)?
###### Is an action that persistently failed scraped from the model?

###### Are you talking about atomic actions?
Actions with durations are not indivisible and instantaneous and are therefore not considered atomic.

### Verification
###### Incremental Verification
###### All the proposed states will add complexity to the model. How much would it cost to model check the behaviour of BDI autonomous agents using durative actions?
The states shouldn't add complexity to the model because they shouldn't add branches.
###### Will the verification be new?


### Machine Learning
###### Do you need Machine Learning?
###### Are we considering modifying the learning strategy depending on whether an action is suspended or aborted?
###### What strategy can be used not to increase the problem complexity when learning new actions?
###### When a new action is learned, what is the degree of learning that is allowed? e.g. is it possible to discover new entities/predicates in the domain? Or will it be allowed to learn new actions/different actions by simply reusing the domain entities and the predicates that are already available?

### Planning
###### What strategies are you planning to explore to reduce the planning time and ensure that the modified actions that you explore lead you to a valid solution?
###### What is the difference between reconfiguration and learning a new action?

### Examples
###### Better explain why the systems will no longer perform as expected.
###### The paper should discuss explicitly in which context learning from failures is feasible. - Where failure is serious – is the answer just to stop the system? And not use our approach?

### Evaluation
###### How am I evaluating success?

### General
###### What do you mean by _____?
###### How does this relate to _____?
###### Is this approach similar to _____?
