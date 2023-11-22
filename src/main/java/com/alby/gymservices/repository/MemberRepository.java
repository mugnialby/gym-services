package com.alby.gymservices.repository;

import com.alby.gymservices.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    
    boolean existsByEmail(String email);

    Member findByEmail(String email);

    Member findByEmailAndPassword(String email, String password);

    Member findByEmailAndToken(String email, String token);
    
}
