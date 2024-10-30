package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

/*

Connection conn = null; -> faz a conexao com o banco
Statement st = null; -> faz as consultas SQL pra buscar todos os departamentos no banco
ResultSet rs = null; -> é onde vai ser guardado os resultados das consultas, feitas no Statement st.
 */
public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("===TEST 1: seller findById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n===TEST 2: seller findByDepartment ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);

        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n===TEST 3: seller findByAll ====");
        list = sellerDao.findAll();
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n===TEST 4: seller insert ====");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", 4000.0, new Date(), department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n===TEST 5: seller update ====");
        seller = sellerDao.findById(1);
        seller.setName("Marta Cabral");
        seller.setEmail("marta@gmail.com");
        sellerDao.update(seller);
        System.out.println("Update completed!");

    }
}