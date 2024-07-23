package org.proleesh.sendemail.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JavaStackListener implements ApplicationListener<AvailabilityChangeEvent> {

    @Override
    public void onApplicationEvent(AvailabilityChangeEvent event) {
        log.info("listener event: " + event);
        if(ReadinessState.ACCEPTING_TRAFFIC == event.getState()){
            log.info("프로그램 실행 완료, 요청 받기 시작...");
        }
    }
}
