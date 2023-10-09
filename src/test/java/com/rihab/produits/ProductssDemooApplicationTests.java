package com.rihab.produits;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rihab.produits.entities.Categorie;
import com.rihab.produits.entities.Produit;
import com.rihab.produits.repos.ProduitRepository;

@SpringBootTest
class ProductssDemooApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;

	@Test
	public void testCreateProduit() {
	Produit prod = new Produit("PC ASUS",2800.500,new Date());
	produitRepository.save(prod);
	}

	
	@Test
	public void testFindProduit()
	{
	Produit p = produitRepository.findById(1L).get();
		System.out.println(p);
	}

	
	@Test
	public void testUpdateProduit()
	{
	Produit p = produitRepository.findById(1L).get();
	p.setPrixProduit(3400.0);
	produitRepository.save(p);

	System.out.println(p);
	}
	
	
	@Test
	public void testDeleteProduit()
	{
		produitRepository.deleteById(1L);
	}
	
	
	@Test
	public void testFindAllProduits()
	{
		List<Produit> prods = produitRepository.findAll();

		for (Produit p:prods)
			 System.out.println(p);

	}

	
	@Test
	public void testFindProduitByNom()
	{
	List<Produit> prods = produitRepository.findByNomProduit("Pc hp");
			for(Produit p : prods)
			System.out.println(p);
	}


	@Test
	public void testFindProduitByNomContains()
	{
	List<Produit> prods = produitRepository.findByNomProduitContains("P");
	for(Produit p : prods)
	System.out.println(p);
	}
	
	
	@Test
	public void testFindByCategorie()
	{
		Categorie cat = new Categorie();
		cat.setIdCat(1L);
		List<Produit> prods = produitRepository.findByCategorie(cat);
			for(Produit p : prods)
				System.out.println(p);
		}
	
	

	@Test
	public void findByCategorie()
	{
		
		List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
			for(Produit p : prods)
				System.out.println(p);
		
	}
	

	@Test
	public void testFindByOrderByNomProduitAsc()
	{
	List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
			for(Produit p : prods)
			System.out.println(p);
	}
	

	@Test
	public void testTrierProduitsNomsPrix()
	{
	List<Produit> prods = produitRepository.trierProduitsNomsPrix();
			for(Produit p : prods)
			System.out.println(p);
	}
	
	
}
