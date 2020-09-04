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
If an action is seen to have not achieved the expected post-conditions more than a specified limit of times, it is considered persistent failure.

###### Is there a notion of repeating an action a certain amount of times until that action is considered faulty? What does it mean for an action to be in a situation of "persistent failure"?
This parameter would be specified as a limit per action.
###### What about the order of the actions (e.g., an action can be faulty only if executed after another one)?
The reconfiguration of plans would be invoked after each failure is detected. Therefore, if after plan replacement the plan is still failing, it would be reconfigured again until it cannot be reconfigured anymore. This approach is possibly not the most effiecient approach although it would eventually achieve the desired result if this situation occurs.
###### Is an action that persistently failed scraped from the model?
This is undecided as of yet, although I can see that there could be problems keeping a failing action available for use whilst reconfiguring plans (resulting in reconfiguring a plan that includes a failing action).

###### Are you talking about atomic actions?
Actions with durations are indivisible and the post-conditions are instantaneous once completed and are therefore considered atomic.

### Verification
###### Incremental Verification
###### All the proposed states will add complexity to the model. How much would it cost to model check the behaviour of BDI autonomous agents using durative actions?
The states shouldn't add complexity to the model because they shouldn't add branches.
###### Will the verification be new?
We have not encountered this yet, although we would try to avoid having to perform a new verification. We would check to see if our previously verified safety properties are violated before considering reverification.

### Machine Learning
###### Do you need Machine Learning?
We have discussed if machine learning would be suitable and at the moment we believe so, although this could change as it is still future work. 
###### Are we considering modifying the learning strategy depending on whether an action is suspended or aborted?
This is something we will eventually consider.
###### What strategy can be used not to increase the problem complexity when learning new actions?
This is something we will eventually consider.
###### When a new action is learned, what is the degree of learning that is allowed? e.g. is it possible to discover new entities/predicates in the domain? Or will it be allowed to learn new actions/different actions by simply reusing the domain entities and the predicates that are already available?
This is something we will eventually consider.

### Planning
###### What strategies are you planning to explore to reduce the planning time and ensure that the modified actions that you explore lead you to a valid solution?
We have not considered this yet. 

###### What is the difference between reconfiguration and learning a new action?
Reconfiguration uses existing plans to find a solution to a failing plan, learning a new action creates a new action description to be used by the reconfiguration framework to find a solution to a failing plan that cannot be reconfigured.

### Examples
###### Better explain why the systems will no longer perform as expected.
Radiation, high temperatures, low temperatures, impact damage, or aging materials could affect the robot's mechanical parts. The robot's operating environment could also change the outcome of actions: extreme weather, different terrain, darkness.
###### The paper should discuss explicitly in which context learning from failures is feasible. - Where failure is serious – is the answer just to stop the system? And not use our approach?
Yes, where failure is serious the system should stop (or return to home). Our approach allows for graceful degradation in situations where stopping the system for repair would be less desirable. Our system could extend the life of an autonomous robot that would otherwise be costly to replace.

###### What other scenarios could the system work in?
1. A very applicable scenario would be the sticky wheel scenario. In this scenario, one wheel of a robot has been effected in such a way that it no longer performs as expected. This could be due to radiation, high temperatures, low temperatures, impact damage, or it could be due to aging materials. Either way, this would be detected by our system when we compare the expected post-conditions with the perceived post-conditions for a movement action. In short, we are hoping to learn a new action description to account for the offset caused by the sticky wheel.
2. Another scenario would be stacking and moving blocks with a robot arm. If we are unable to pick up a block (i.e. due to the block being slippery) we could reconfigure our plans to push the block instead. Although if this does not achieve the goal such as the block not being the bottom block, then we could attempt to learn a new orientation for the gripper to pick up the block. 
3. There are situations where learning actions would be dangerous, such as with a drone. Our proposed system would aid with graceful degradation of the robot, if there are no other options available such as if your robot is innaccessable or in an extremely remote location.

### Evaluation
###### How am I evaluating success?
This paper is largely an outline of the research that we will be doing but we have scope for simulating environments using the Robot Operating System (ROS) framework. We will be deploying our system in that environment to evaluate how it deals with various failures.
We are also hoping to deploy our system onto a physical robot. This would be in conjunction with the Robotics and AI in Nuclear Research Hub. It would most likely be the ClearPath robotics Husky, which is a four-wheeled unmanned ground vehicle.

### Combining Disciplines
###### What problems do you expect to encounter when combining verification and machine learning?
This is still part of future work but we have considered the use of safety envelopes to omit the risk of failure when learning. It is also entirely possible that an outcome from learning cannot be verified, in which case the system would fail, or we could consider lowering the requirements for the reconfiguration (Allow a replacement plan to have a greater duration than previously allowed).
We are looking to maintain certain safety properties, and the outcome from learning may not violate these properties.

### General
###### What do you mean by _____?
###### How does this relate to _____?
###### Is this approach similar to _____?
