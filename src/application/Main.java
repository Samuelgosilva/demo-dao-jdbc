package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
/*

Connection conn = null; -> faz a conexao com o banco
Statement st = null; -> faz as consultas SQL pra buscar todos os departamentos no banco
ResultSet rs = null; -> é onde vai ser guardado os resultados das consultas, feitas no Statement st.
 */
public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

    }
}