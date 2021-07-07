package io.npee.core.member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
