package ail.tracing;

import java.io.File;

import ail.tracing.explanations.WhyQuestions;

public class EventTableTestRig {
	final EventStorage storage;
	final WhyQuestions questions;
	
	
	public EventTableTestRig(File datafile) {
		storage = new EventStorage(datafile);
		questions = new WhyQuestions(storage);
		questions.process();
	}
	
	public EventStorage getStorage() {
		return storage;
	}
	
	public WhyQuestions getTrace() {
		return questions;
	}
}
