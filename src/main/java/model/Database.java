package model;


import controller.GameController;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;

/**
 * {@code Database} Az adatbázisban való tárolásért, illetve lekérdezését felelős.
 */
public class Database {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("quiz-mysql");

    /**
     * {@code addUsertoDB()} Az adatbázishoz történő hozzáadásért felelős.
     * @param user A paraméterként apott usert adja hozzá az adatbázishoz.
     */
    public static void addUsertoDB(User user) {
        EntityManager em = emf.createEntityManager();
        User addeduser = User.builder().username(user.getUsername()).score(user.getScore()).build();
        try {
            em.getTransaction().begin();
            em.persist(addeduser);
            em.getTransaction().commit();
            System.out.println(addeduser);
        } finally {
            em.close();
        }


    }
    public static List<User> getUsers() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT u FROM User u ORDER BY u.id DESC", User.class).getResultList();
        } finally {
            em.close();
        }
    }
    public static List<User> getTopTen() {
        EntityManager em = emf.createEntityManager();
        try{
            return em.createQuery("SELECT u FROM User u ORDER BY u.score DESC", User.class)
                    .setMaxResults(10)
                    .getResultList();}
        finally {
           em.close();
        }
    }

}


