package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection conn = null;//Objeto de conexão com o Banco de Dados

    public static Connection getConnection(){ //Método de conexão com o Banco de Dados
        if (conn == null){ // se o objeto estiver nulo, teremos que fazer a conexao
            try{
            Properties props = loadProperties(); // aqui pega as propriedades do método loadProperties().
            String url = props.getProperty("dburl"); // url do Banco de Dados
            conn = DriverManager.getConnection(url, props); // conectamos com o banco instanciando o objeto 'conn'.
        } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }
    public static void closeConnection(){ //metodo para fechar conexao com o Banco
        if(conn != null){
            try{
                conn.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
    private static Properties loadProperties(){ //esse método carrega as propriedades de conexão com o Banco que estao no arquivo 'db.properties'.
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs); // comando load faz a leitura da variavel 'fs' e guarda na variavel 'props'.
            return props; // depois retorna props. Isso pode gerar erro, portanto, faremos um catch abaixo.
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeStatement(Statement st){
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
