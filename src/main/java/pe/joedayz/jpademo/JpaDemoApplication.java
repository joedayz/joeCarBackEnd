package pe.joedayz.jpademo;

import pe.joedayz.jpademo.domain.Car;
import pe.joedayz.jpademo.domain.Owner;
import pe.joedayz.jpademo.domain.User;
import pe.joedayz.jpademo.repository.CarRepository;
import pe.joedayz.jpademo.repository.OwnerRepository;
import pe.joedayz.jpademo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaDemoApplication {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			Owner owner1 = new Owner("John" , "Johnson");
			Owner owner2 = new Owner("Mary" , "Robinson");
			ownerRepository.save(owner1);
			ownerRepository.save(owner2);

			carRepository.save(new Car("Ford", "Mustang", "Red",
					"ADF-1121", 2017, 59000, owner1));
			carRepository.save(new Car("Nissan", "Leaf", "White",
					"SSJ-3002", 2014, 29000, owner2));
			carRepository.save(new Car("Toyota", "Prius", "Silver",
					"KKO-0212", 2018, 39000, owner2));

			//username: user pasword: user
			userRepository.save(new User("user", "$2a$04$QP61zm2Iim7gdVIZzEKf/ucdfgc5nRd6.GxdlhI2R7Q.arReHq9Bi", "USER"));

			//admin / admin
			userRepository.save(new User("admin", "$2a$04$AU33sJxuhyTChu9NE0l4wuZc0DSZce5G0bz3rUrQMluaMzuFjCVJi", "ADMIN"));
		};
	}
}

