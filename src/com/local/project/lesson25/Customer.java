package com.local.project.lesson25;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.time.LocalDate;
import java.util.List;

public class Customer implements Externalizable {
    private String fullName;
    private LocalDate birth;
    private List<Item> items;


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(fullName);
        out.writeObject(birth);
        out.writeObject(items);
    }


    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.birth = (LocalDate) in.readObject();
        this.items = (List<Item>) in.readObject();
    }
}
