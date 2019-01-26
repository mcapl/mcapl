---
title: 'The MCAPL Framework including the Agent Infrastructure Layer and Agent Java Pathfinder'
tags:
- model-checking
- beliefs desires intentions model of agency
- agent programming languages
authors:
- name: Louise A. Dennis
orcid: 0000-0003-1426-1896
affiliation: "1"
affiliations:
- name: Department of Computer Science, University of Liverpool
index: 1
date: 3 February 2018
bibliography: paper.bib
---

# Summary

The MCAPL (Model-checking Agent Programming Languages) framework is a suite of tools for building interpreters for agent programming languages and verifying the correctness of programs running in these interpreters using the model checking technique.  It consists of the Agent Infrastructure Layer (AIL) toolkit for building interpreters for rational agent programming languages (BDI languages) as introduced by [@rao:92a] and the Agent JavaPathFinder (AJPF) model checker [@MCAPL_journal].  AJPF extends the JavaPathfinder (JPF) model checker [@VisserHBPL03] to prove Linear Temporal Logic properties of BDI programs.  The distribution also contains a number of programming languages implemented in the AIL.  Chief among these are Gwendolen [@dennis17gwen], the EASS variant of Gwendolen that can be used to program hybrid autonomous systems and GOAL [@GOAL01].

## Formal Verification and Model Checking

Formal verification is essentially the process of assessing whether a specification given in formal logic is satisfied on a particular formal description of the system in question.  Model checking [@Clarke00:MC] has proved an extremely successful approach to formal verification. Model checking takes an executable model of the system in question, defining all the model's possible
executions, and then checks a logical property against this model (and, hence, against all possible executions).

## BDI Agents and Programming Languages

The predominant view of rational agency is that encapsulated within the BDI model,  Here, `BDI' stands for _Beliefs_, _Desires_, and _Intentions_. Beliefs represent the agent's (possibly incomplete, possibly incorrect) information about itself, other agents, and its environment, desires represent the agent's long-term goals while intentions represent the goals that the agent is actively pursuing.  There are many different agent programming languages and agent platforms based, at least in part, on the BDI approach and these have been used in a wide range of applications, particularly for hybrid control of autonomous systems (where there is a strong requirement for verification).

The software is currently under development as part of the EPSRC funded Verifiable Autonomy Project ( EP/L024845/1)

The MCAPL framework has enabled research reported in a variety of papers [@dennis15:_two,@DBLP:journals/cacm/FisherDW13,@dennis14:_pract,@DALT10:abstraction,@Dennis2016,@MCAPL_journal,@Dennis2015,@dennis15:_towar_verif_ethic_robot_behav].  Examples from many of these publications appear in the software repository for the MCAPL  framework and are credited to the authors of those examples.

The MCAPL Framework can be found on Sourceforge [@Sourceforge]

# References
