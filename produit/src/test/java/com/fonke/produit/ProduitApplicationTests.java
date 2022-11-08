package com.fonke.produit;

import com.fonke.produit.entities.Categorie;
import com.fonke.produit.entities.Produit;
import com.fonke.produit.repository.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class ProduitApplicationTests {

    @Autowired
    private ProduitRepository produitRepository;


    @Test
    public void testCreateProduit() {
        Produit prod = new Produit("PS 4", 1200.000, new Date());
        produitRepository.save(prod);
    }

    @Test
    public void testUpdateProduit()
    {
        Produit p = produitRepository.findById(1L).get();
        p.setPrixProduit(1000.0);
        produitRepository.save(p);
    }

    @Test
    public void testDeleteProduit()
    {
        produitRepository.deleteById(1L);;
    }

    @Test
    public void testListerTousProduits()
    {
        List<Produit> prods = produitRepository.findAll();
        for (Produit p : prods)
        {
            System.out.println(p);
        }
    }

    @Test
    public void testFindByNom() {
        List<Produit> prods = produitRepository.findByNomProduit("PS 4");
        for (Produit p : prods) {
            System.out.println(p);
        }
    }

    @Test
    public void testFindByNomContains ()
    {
        List<Produit> prods=produitRepository.findByNomProduitContains("P");
        for (Produit p : prods)
        {
            System.out.println(p);
        }
    }

    @Test
    public void testfindByNomPrix()
    {
        List<Produit> prods = produitRepository.findByNomPrix("PS 4", 1000.0);
        for (Produit p : prods)
        {
            System.out.println(p);
        }
    }

    @Test
    public void testfindByCategorie()
    {
        Categorie cat = new Categorie();
        cat.setIdCat(1L);
        List<Produit> prods = produitRepository.findByCategorie(cat);
        for (Produit p : prods)
        {
            System.out.println(p);
        }
    }

    @Test
    public void findByCategorieIdCat()
    {
        List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
        for (Produit p : prods)
        {
            System.out.println(p);
        }
    }

    @Test
    public void testfindByOrderByNomProduitAsc()
    {
        List<Produit> prods =
                produitRepository.findByOrderByNomProduitAsc();
        for (Produit p : prods)
        {
            System.out.println(p);
        }
    }

    @Test
    public void testTrierProduitsNomsPrix()
    {
        List<Produit> prods = produitRepository.trierProduitsNomsPrix();
        for (Produit p : prods)
        {
            System.out.println(p);
        }
    }

}
