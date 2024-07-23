package org.proleesh.sendemail.analyzer;

import org.proleesh.sendemail.exception.JavaStackException;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

public class JavaStackFailureAnalyzer extends AbstractFailureAnalyzer<JavaStackException> {
    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, JavaStackException cause) {
        return new FailureAnalysis("Java Stack Exception.",
                "Please check again!!!", cause);
    }
}
