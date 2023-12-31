package application;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		//Department obj = new Department(1, "Books");
		//Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
		
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("==== 1 teste-fidnID");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("==== 2 seller-findDepart");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
			
		}

		System.out.println("==== 3 seller-findAll");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
			
		}

		
		System.out.println("==== 4 seller-insert");
		Seller newSwller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSwller);
		System.out.println("Insert new id: " + newSwller.getId());
		
		System.out.println("==== 5 seller-update");
		seller = sellerDao.findById(2);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("==== Update comleto");

		System.out.println("==== 6 seller-delete");
		System.out.println("Digite o codigo a ser excluido: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Deletado...");
		
		sc.close();
	}

}
