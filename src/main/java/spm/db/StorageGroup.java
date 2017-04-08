package spm.db;

/**
 * Created by kokoster on 08/04/2017.
 */
public class StorageGroup {
    private int id;
    private String name;

    public StorageGroup() {};

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
        return id + ": " + name;
    }
}
