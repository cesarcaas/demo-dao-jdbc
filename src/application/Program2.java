package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== 1 teste-fidnID");

		Department dep = depDao.findById(3);
		System.out.println(dep);
		
		System.out.println("==== 2 department-findAllDepart");
		List<Department> list = depDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
			
		}

		System.out.println("==== 3 department-insert");
		Department newDep = new Department(null, "Bolas");
		//depDao.insert(newDep);
		System.out.println("Insert new id: " + newDep.getId());

		System.out.println("==== 4 department-update");
		newDep = depDao.findById(2);
		dep.setName("Martha Waine");
		depDao.update(newDep);
		System.out.println("==== Update comleto");

		System.out.println("==== 5 department-delete");
		System.out.println("Digite o codigo a ser excluido: ");
		int ido = sc.nextInt();
		depDao.deleteById(ido);
		System.out.println("Deletado...");

		sc.close();
	}

}
