package spm.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by kokoster on 08/04/2017.
 */

@Entity
@Table(name = "dwd_storagegroup")
public class StorageGroup {
    @Id
    @Column(name = "storagegroupkey")
    private int id;

    @Column(name = "storagegroupid")
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
