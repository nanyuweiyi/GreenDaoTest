package com.example.tnn.greendaotest.util;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class CreateDaoEntity {

    public static void main(String[] args) throws Exception {

        Schema schema = new Schema(1, "com.example.tnn.greendaotest.dao");

        addNote(schema);
        addCard(schema);

        new DaoGenerator().generateAll(schema, "../GreenDaoTest/app/src/main/java/");
    }

    private static void addNote(Schema schema) {
        Entity note = schema.addEntity("UserInfo");
        note.addIdProperty();
        note.addStringProperty("name").notNull();
        note.addIntProperty("age");
    }
    private static void addCard(Schema schema) {
        Entity note = schema.addEntity("CardInfo");
        note.addIdProperty();
        note.addStringProperty("card").notNull();
        note.addIntProperty("num");
    }
}
