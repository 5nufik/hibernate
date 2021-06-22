package ru.nikiforov.testManyToMany.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * todo Document type Section
 */

@Entity
@Table(name = "sections")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
        name = "child_section" ,
        joinColumns = @JoinColumn(name = "section_id") ,
        inverseJoinColumns = @JoinColumn(name = "child_id")
    )
    private List<Child> childList;

    public Section() {
    }

    public Section(String name) {
        this.name = name;
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

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }

    public void addChildToSection(Child child) {
        if (childList == null)
            childList = new ArrayList<>();

        childList.add(child);
    }

    @Override
    public String toString() {
        return "Section{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}