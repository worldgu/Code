package com.zero.Memento;


import java.io.*;

/**
 * @ClassName Main
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 23:46
 * @Version 1.0
 */
public class Main {

    private static final String FILE_PATH = "D:\\code\\text.ini";

    public static void main(String[] args) throws Exception {

        Person person = new Person();
        person.setName("春海");
        person.setAge(25);

        System.out.println(person.hashCode());

        serial(person);
        Person person1 = readFromFile();

        System.out.println(person1.hashCode() + "   " + person1.toString());

        Person person2 = new Person();
        person2.setName("春海");
        person2.setAge(24);
        System.out.println(person2.hashCode() + "   " + person2.toString());

    }

    private static void serial(Person person) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
        oos.writeObject(person);
        oos.close();
    }

    private static Person readFromFile() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
        return (Person) ois.readObject();
    }

}
