package com.xa.backend;
// import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.xa.backend.entities.Category;
import com.xa.backend.entities.Product;
import com.xa.backend.entities.Variant;
import com.xa.backend.repositories.CategoryRepository;
import com.xa.backend.repositories.ProductRepository;
import com.xa.backend.repositories.VariantRepository;
@SpringBootApplication
public class backendApplication {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private VariantRepository variantRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(backendApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(){
		return args -> {
			// Category Seeding
			Category food = new Category("Food", "food", "All kinds of food", true);
			Category beverage = new Category("Beverage", "beverage", "All kinds of drinks", true);
			Category medicine = new Category("Medicine", "medicine", "All kinds of meds", false);
			// Category fastFood = new Category("Fast Food", "fast-food");
			categoryRepository.save(food);
			categoryRepository.save(beverage);
			categoryRepository.save(medicine);
			// categoryRepository.save(fastFood);

			// Faker faker = new Faker(new Locale("es"));
			// int categories = 5;
			// for (int i = 0; i < categories; i++) {
			// 	Category categorySeed = new Category(faker.name().fullName(), faker.internet().slug());
			// 	categoryRepository.save(categorySeed);
			// }

			Product indomie = new Product("Instant Noodle", "instant-noodle", "Delicious Instant Noodle", 1L, false);
			Product dairy = new Product("Dairy", "dairy", "Milk Processed Drinks", 2L, false);
			Product paracetamol = new Product("Paracetamol", "paracetamol", "Fever Meds", 3L, true);
			productRepository.save(indomie);
			productRepository.save(dairy);
			productRepository.save(paracetamol);

			Variant indomieGoreng = new Variant("Indomie Goreng", "indomie-goreng", "Delicious Instant Noodle", 1L, 3.50, 20.0, true);
			Variant indomieKuah = new Variant("Indomie Kuah", "indomie-kuah", "Delicious Instant Noodle", 1L, 3.50, 20.0, true);
			Variant bearbrand = new Variant("Bearbrand", "bearbrand", "Delicious milk", 2L, 7.50, 100.0, true);
			Variant paracetamolTablet = new Variant("Paracetamol Tablet", "paracetamol-tablet", "Fever Meds", 3L, 4.0, 40.0, true);

			variantRepository.save(indomieGoreng);
			variantRepository.save(indomieKuah);
			variantRepository.save(bearbrand);
			variantRepository.save(paracetamolTablet);
		};
	}
}
