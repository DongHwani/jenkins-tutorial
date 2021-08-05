package com.example.jenkins.jenkinspipeline.member;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Member {

    private String memberId;

    public Member(String memberId) {
        this.memberId = memberId;
    }
}
