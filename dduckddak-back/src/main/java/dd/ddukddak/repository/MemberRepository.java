package dd.ddukddak.repository;

import dd.ddukddak.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

  private final EntityManager em;

  @Transactional
  public void save(Member member){
    em.persist(member);
  }

  public List<Member> findAll(){
    return em.createQuery("select m from Member m", Member.class)
            .getResultList();
  }
}
