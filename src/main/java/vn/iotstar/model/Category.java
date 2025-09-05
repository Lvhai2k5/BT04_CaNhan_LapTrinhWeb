package vn.iotstar.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(length = 255)
    private String description;

    // ===== Constructors =====
    public Category() {}

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // ===== Getter & Setter =====
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // ===== toString() =====
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
