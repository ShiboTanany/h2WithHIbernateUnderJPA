package com.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
        EntityManager em = emf.createEntityManager();


        try {

            em.getTransaction().begin();
            Address address = new Address("133", "33  ", "55", "55");
            Address address2 = new Address("134", "34  ", "55", "55");
            Address address3 = new Address("135", "35  ", "55", "55");
            em.persist(address);
            em.persist(address2);


            em.persist(new Student("shaaban", address));
            em.persist(new Student("Paul", address));
            em.persist(new Student("George", address));

            address3.setStudent(em.find(Student.class, new Long(3)));
            em.persist(address3);
            em.getTransaction().commit();
            //
            System.out.println("inserted ");
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            List<Student> s = em.createNamedQuery("EmailDomainTrust.getAllStudent", Student.class).getResultList();
            for (Student student : s
                    ) {
                System.out.println(student);
            }
            System.out.println("///////////////////////////////");
            List<Address> p = em.createNamedQuery("EmailDomainTrust.getAlladdress", Address.class).getResultList();
            for (Address address : p
                    ) {
                System.out.println(address);
            }
        }
    }
}
