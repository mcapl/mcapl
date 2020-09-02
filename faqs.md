# Frequently Asked Questions
### Overview
##### Contributions
##### Assumptions
##### Gwendolen

### Definitions

### BDI
###### Do the post-conditions of an action also take into account the duration of the action itself and in what ways that can be expressed.

### Self-Model
###### Modelling the environment effectively can be complex, how will this be done?
###### Which concepts should the self- model include?


### Failure Detection
###### Specify formally and precisely what a persistent failure really is and what it may be the reasons to have such a failure.
###### Is there a notion of repeating an action a certain amount of times until that action is considered faulty? What does it mean for an action to be in a situation of "persistent failure"?
###### What about the order of the actions (e.g., an action can be faulty only if executed after another one)?
###### Is an action that persistently failed scraped from the model?
###### Are you talking about atomic actions?

### Verification
###### Incremental Verification
###### All the proposed states will add complexity to the model. How much would it cost to model check the behaviour of BDI autonomous agents using durative actions?
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
