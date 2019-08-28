package br.com.runescape.Entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Crafting{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "level", nullable = false)
    private int level;
    @Column(name = "xp", nullable = false)
    private long xp;

    public Crafting(String name, int level, long xp) {
        this.name = name;
        this.level = level;
        this.xp = xp;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public long getXp() {
        return xp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setXp(long xp) {
        this.xp = xp;
    }
}
