package jpa;

import java.io.*;
import java.util.List;
import java.io.File;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.ws.rs.core.MediaType;
import javax.persistence.*;
import javax.print.attribute.standard.Media;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;



@Path("/Site")
public class SiteDao {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_Assignment");
	EntityManager em = null;
	public SiteDao() {
		em = factory.createEntityManager();
	} 
	
	// Post operation

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> createSite(Site site) {
		em.getTransaction().begin();
		em.persist(site);
		Query query = em.createNamedQuery("Site.findAll");
		List<Site> sites = query.getResultList();
		em.getTransaction().commit();
		return sites;
	}
	// Get operation
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Site findSite(@PathParam("id") int sId) {
		em.getTransaction().begin();
		Site site = em.find(Site.class,sId);
		em.getTransaction().commit();
		return site;
	}
	// get operation
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> findAllSites() {
		em.getTransaction().begin();
		Query query = em.createNamedQuery("Site.findAll");
		List<Site> sites = query.getResultList();
		em.getTransaction().commit();
		return sites;
	}
	//  put operation

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> updateSite(@PathParam("id") int sId, Site site) {
		
		em.getTransaction().begin();
		Site s = em.find(Site.class,sId);
		s.setName(site.getName());
		em.merge(s);
		Query query = em.createNamedQuery("Site.findAll");
		List<Site> sites = query.getResultList();
		em.getTransaction().commit();
		return sites;
	}

	// Delete operation
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> removeSite(@PathParam("id") int sId) {
		
		em.getTransaction().begin();
		Site site = em.find(Site.class, sId);
		em.remove(site);
		Query query = em.createNamedQuery("Site.findAll");
		List<Site> sites = query.getResultList();
		em.getTransaction().commit();
		return sites;
	}
	public static void main(String[] args) {
		// Creating Site Dao
		SiteDao sitedao = new SiteDao();
	    Site site = new Site();
	    site.setLatitude(77.5);
	    site.setLongitude(28.97);
	    site.setName("Site Name");
       // Creating Tower
		Tower tower = new Tower();
		tower.setName("Tower Name");
		tower.setHeight(10);
		tower.setSlides(20);
		tower.setSite(site);
		// Creating Equipment
		Equipment equipmentObj = new Equipment();
		equipmentObj.setBrand("Any Brand");
		equipmentObj.setDescription("Equipment Description");
		equipmentObj.setName("Equipment name");
		equipmentObj.setPrice(13);
		equipmentObj.setTower(tower);
		//Adding equipment to the equipment list
		List<Equipment> equipments = new ArrayList<Equipment>();
		equipments.add(equipmentObj);
		tower.setEquipments(equipments);
		//Adding tower to the tower list
		List<Tower> towers = new ArrayList<Tower>();
		towers.add(tower);
		site.setTowers(towers);		
	  List<Site> sites = sitedao.findAllSites();
	 // Iterating over the site list
	 for (Site s : sites) {
	    System.out.println(s.getId());
	 }
	}
}
