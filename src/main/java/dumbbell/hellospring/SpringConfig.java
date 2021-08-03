package dumbbell.hellospring;

import dumbbell.hellospring.repository.JdbcMemberRepository;
import dumbbell.hellospring.repository.JdbcTemplateMemberRepository;
import dumbbell.hellospring.repository.MemberRepository;
import dumbbell.hellospring.repository.MemoryMemberRepository;
import dumbbell.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
