package org.proleesh.sendemail.analyzer;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.web.server.PortInUseException;

public class PortInUseFailureAnalyzer extends AbstractFailureAnalyzer<PortInUseException> {
    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, PortInUseException cause) {
        return new FailureAnalysis("실행 포트: " + cause.getPort() + "가 이미 사용중입니다.",
                "해당 포트: " + cause.getPort() + "가 어디에서 사용하는지 체크하십시오. " +
                        "포트 소멸하는 방법: lsof -i tcp:"+ cause.getPort() + ", kill -9 <pid>", cause);
    }
}
