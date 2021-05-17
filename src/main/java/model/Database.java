package model;


import controller.GameController;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;

public class Database {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("quiz-mysql");

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
}


