package ru.nikiforov.testManyToMany;

import ru.nikiforov.testManyToMany.entity.Child;
import ru.nikiforov.testManyToMany.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * todo Document type TestManyToMany
 */

public class TestManyToMany {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                                            .configure()
                                            .addAnnotatedClass(Child.class)
                                            .addAnnotatedClass(Section.class)
                                            .buildSessionFactory();

        Session session = null;

        try {
//            session = sessionFactory.getCurrentSession();
//
//            Section section1 = new Section("Football");
//            Child child1 = new Child("Max", 5);
//            Child child2 = new Child("Masha", 7);
//            Child child3 = new Child("Vasya", 6);
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//
//            session.beginTransaction();
//
//            session.save(section1);
//
//            session.getTransaction().commit();

//            session = sessionFactory.getCurrentSession();
//
//            Section section1 = new Section("Volleyball");
//            Section section2 = new Section("Chess");
//            Section section3 = new Section("Math");
//            Child child1 = new Child("Igor", 6);
//            child1.addSectionToChild(section1);
//            child1.addSectionToChild(section2);
//            child1.addSectionToChild(section3);
//
//            session.beginTransaction();
//
//            session.save(child1);
//
//            session.getTransaction().commit();

//            session = sessionFactory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 2);
//
//            System.out.println(section);
//            System.out.println(section.getChildList());
//
//            session.getTransaction().commit();

//            session = sessionFactory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Child child = session.get(Child.class, 7);
//
//            System.out.println(child);
//            System.out.println(child.getSectionList());
//
//            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            Child child = new Child("Vasya", 7);
            Section section = new Section("Dance");

            child.addSectionToChild(section);

            session.persist(child);

            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}