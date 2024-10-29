package application;

import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Department obj = new Department(1, "books");


        Seller seller = new Seller(21,"Bob", "bob@gmail.com", 3000.0, new Date(),  obj );
        System.out.println(seller);

    }
}