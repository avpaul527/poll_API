package com.pollsAPI.polls.dto;

public class ChoiceCount {

    private Long countId;

    private int count;

    public ChoiceCount() {}

    public Long getCountId() {
        return countId;
    }

    public void setCountId(Long countId) {
        this.countId = countId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
