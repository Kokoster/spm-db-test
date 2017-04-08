package spm.db;

/**
 * Created by kokoster on 07/04/2017.
 */
public class FEDirector {
    private int id;
    private String name;

    public FEDirector() {};

    public FEDirector(int id, String name) {
        this.id = id;
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

    @Override
    public String toString() {
        return id + " " + name;
    }
}
