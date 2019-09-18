package core;

import org.springframework.core.serializer.DefaultDeserializer;
import org.springframework.core.serializer.DefaultSerializer;
import org.springframework.core.type.classreading.AnnotationMetadataReadingVisitor;
import pojo.Person;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author pengfei.cheng
 * @description demo
 * @date 2019-09-18 09:59
 */
public class SpringCoreDemo<T> {

    public static void main(String[] args) {


        SpringCoreDemo<Person> personSpringCoreDemo = new SpringCoreDemo<>();


//        personSpringCoreDemo.serializer(personSpringCoreDemo.newPerson());


    }

    public Person newPerson() {
        Person person = new Person();
        person.setId("1");
        person.setName("dante");
        person.setGender("man");
        return person;
    }

    private void serializer(T obj) {
        DefaultSerializer defaultSerializer = new DefaultSerializer();
        DefaultDeserializer defaultDeserializer = new DefaultDeserializer();
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

            defaultSerializer.serialize(obj, byteArrayOutputStream);
            System.out.println(byteArrayOutputStream.size());
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            System.out.println(byteArrayOutputStream.size());
            Object deserialize = defaultDeserializer.deserialize(byteArrayInputStream);

            System.out.println(deserialize);
            System.out.println(deserialize instanceof Person);
            System.out.println(deserialize.equals(obj));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void type() {
        AnnotationMetadataReadingVisitor visitor = new AnnotationMetadataReadingVisitor();
    }
}
