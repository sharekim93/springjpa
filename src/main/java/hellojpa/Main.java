package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team  = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setName("hello");
//            member.setTeamId(team.getId());
            member.setTeam(team);
//            team.getMembers().add(member);
            em.persist(member);

//            Member findMember = em.find(Member.class, member.getId());
//            Team findTeam      = findMember.getTeam();
//
//            List<Member> members = findTeam.getMembers();
//            for(Member member1 : members){
//                System.out.println("member = " + member1);
//            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
