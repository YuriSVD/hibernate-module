import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Owner.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(DriveLicense.class)
                .getMetadataBuilder()
                .build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        /*DriveLicense driveLicense = new DriveLicense("Category B");
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", TypeOfCar.CUV, 300, 15000, 2010));
        cars.add(new Car("Audi", TypeOfCar.SEDAN, 270, 24000, 2015));
        Owner petro = new Owner("Petro", cars, driveLicense);
        session.save(petro);*/
        session.save(
                new Owner("Petro",
                        Arrays.asList(
                                new Car("BMW", TypeOfCar.CUV, 300, 15000, 2010),
                                new Car("Audi", TypeOfCar.SEDAN, 270, 24000, 2015),
                                new Car("Ford", TypeOfCar.PICKUP, 400, 30000, 2013)),
                new DriveLicense("Category B")));

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}