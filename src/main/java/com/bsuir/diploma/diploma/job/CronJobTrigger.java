package com.bsuir.diploma.diploma.job;

public interface CronJobTrigger {
    default String getName() {
        return this.getClass().getSimpleName();
    }

    /**
     * Trigger job execution.
     * Caller code is not responsible for Thread creation for this job. If job is long to execute
     * and should run in separate thread, this is responsibility of implementor to create a new Thread in this method.
     * */
    void run();
}
