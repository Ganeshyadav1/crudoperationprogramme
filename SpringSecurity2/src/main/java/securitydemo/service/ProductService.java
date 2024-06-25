package securitydemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import securitydemo.entity.Pruduct;
import securitydemo.reposi.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Pruduct> getAllProducts() {
	    return productRepository.findAll();
	}

	public Pruduct getProductById(Long id) {
	    return productRepository.findById(id).orElse(null);
	}
}
