package dumbbell.hellospring;

import dumbbell.hellospring.repository.MemberRepository;
import dumbbell.hellospring.repository.MemoryMemberRepository;
import dumbbell.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
