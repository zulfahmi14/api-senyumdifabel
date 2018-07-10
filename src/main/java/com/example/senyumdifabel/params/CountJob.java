package com.example.senyumdifabel.params;

public class CountJob {
    protected Long saved;
    protected Long applied;
    protected Long interview;
    protected Long failed;

    public CountJob(){}

    public CountJob(Long saved, Long applied, Long interview, Long failed) {
        this.saved = saved;
        this.applied = applied;
        this.interview = interview;
        this.failed = failed;
    }

    public Long getSaved() {
        return saved;
    }

    public void setSaved(Long saved) {
        this.saved = saved;
    }

    public Long getApplied() {
        return applied;
    }

    public void setApplied(Long applied) {
        this.applied = applied;
    }

    public Long getInterview() {
        return interview;
    }

    public void setInterview(Long interview) {
        this.interview = interview;
    }

    public Long getFailed() {
        return failed;
    }

    public void setFailed(Long failed) {
        this.failed = failed;
    }
}
