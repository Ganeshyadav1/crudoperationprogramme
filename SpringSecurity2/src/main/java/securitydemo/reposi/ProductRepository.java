package securitydemo.reposi;

import org.springframework.data.jpa.repository.JpaRepository;

import securitydemo.entity.Pruduct;

public interface ProductRepository extends JpaRepository<Pruduct, Long> {
    // Define custom query methods if needed
}