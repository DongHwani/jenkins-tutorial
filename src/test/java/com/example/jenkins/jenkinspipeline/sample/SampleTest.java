package com.example.jenkins.jenkinspipeline.sample;

import com.example.jenkins.jenkinspipeline.member.Member;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class SampleTest {

    @ParameterizedTest
    @CsvSource(value = {"user1", "user2", "user3"})
    public void createInstance(String memberId) {
        //Given & When
        Member member = new Member(memberId);

        //Then
        assertThat(member).isEqualTo(new Member(memberId));
    }
}
