package ru.nikiforov.testManyToMany.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * todo Document type Child
 */

@Entity
@Table(name = "children")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private int age;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
        name = "child_section" ,
        joinColumns = @JoinColumn(name = "child_id") ,
        inverseJoinColumns = @JoinColumn(name = "section_id")
    )
    private List<Section> sectionList;

    public Child() {
    }

    public Child(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    public void addSectionToChild(Section section) {
        if (sectionList == null)
            sectionList = new ArrayList<>();

        sectionList.add(section);
    }

    @Override
    public String toString() {
        return "Children{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}