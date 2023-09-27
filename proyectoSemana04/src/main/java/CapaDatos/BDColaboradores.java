package CapaDatos;
import Entidades.Colaboradores;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class BDColaboradores {
	// Objetos para la conexion con MySQL
	private String Driver = "com.mysql.cj.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost/cibertec2023";
	private String Usuario = "root";
	private String Password = "root";
	
	// Objetos que operan con la BDD de MySQL
	private Connection Cn;
	private Statement Cmd;
	private CallableStatement Stmt;
	private ResultSet Rs;
	private ArrayList<Colaboradores> Lista;
	
	// Método Constructor
	public BDColaboradores() {
		try {
				Class.forName(Driver);
				Cn = DriverManager.getConnection(URL, Usuario, Password);
		} catch (Exception e) {
				System.out.println("ERROR:" + e.getMessage());
		}
	}
	
	// Método para listar los colaboradores
	public ArrayList<Colaboradores> Listar(){
		String SQL = "SELECT * FROM Colaboradores";
		Lista = new ArrayList<Colaboradores>();
		try {
				Cmd = Cn.createStatement();
				Rs = Cmd.executeQuery(SQL);
				while(Rs.next()) {
					Lista.add(new Colaboradores(Rs.getString("Id"),
								Rs.getString("Apellidos"),
								Rs.getString("Nombres"),
								Rs.getInt("Edad"),
								Rs.getString("Sexo").charAt(0)));
				}
				Rs.close();
		} catch (Exception e) {
				System.out.println("ERROR:" + e.getMessage());
		}
		return Lista;
	}
	
	// Método para buscar un colaborador
	public Colaboradores Buscar(String Id) {
		String SQL = "SELECT * FROM Colaboradores WHERE Id=?";
		Colaboradores ObjC = null;
		try {
				Stmt = Cn.prepareCall(SQL);
				Stmt.setString(1, Id);
				Rs = Stmt.executeQuery();
				if(Rs.next()) {
					ObjC = new Colaboradores(Rs.getString("Id"),
							Rs.getString("Apellidos"),
							Rs.getString("Nombres"),
							Rs.getInt("Edad"),
							Rs.getString("Sexo").charAt(0));
				}
				Rs.close();
		} catch (Exception e) {
				System.out.println("ERROR:" + e.getMessage());
		}
		return ObjC;
	}
	
	// Método para insertar colaboradores
	public void Insertar(Colaboradores ObjC) {
		String SQL = "insert into Colaboradores values(?,?,?,?,?)";
		try {
				Stmt = Cn.prepareCall(SQL);
				Stmt.setString(1, ObjC.getId());
				Stmt.setString(2, ObjC.getApellidos());
				Stmt.setString(3, ObjC.getNombres());
				Stmt.setInt(4, ObjC.getEdad());
				Stmt.setString(5, ObjC.getSexo() + "");
				Stmt.executeUpdate();			
		} catch (Exception e) {
				System.out.println("ERROR:" + e.getMessage());
		}
	}
	
	// Método para modificar colaboradores
	public void Modificar(Colaboradores ObjC) {
		String SQL = "update Colaboradores set Apellidos=?,Nombres=?,Edad=?,Sexo=? where Id=?";
		try {
				Stmt = Cn.prepareCall(SQL);				
				Stmt.setString(1, ObjC.getApellidos());
				Stmt.setString(2, ObjC.getNombres());
				Stmt.setInt(3, ObjC.getEdad());
				Stmt.setString(4, ObjC.getSexo() + "");
				Stmt.setString(5, ObjC.getId());
				Stmt.executeUpdate();			
		} catch (Exception e) {
				System.out.println("ERROR:" + e.getMessage());
		}
	}
	
	// Método para suprimir colaboradores
	public void Suprimir(String Id) {
		String SQL = "delete from Colaboradores where Id=?";
		try {
				Stmt = Cn.prepareCall(SQL);				
				Stmt.setString(5, Id);
				Stmt.executeUpdate();			
		} catch (Exception e) {
				System.out.println("ERROR:" + e.getMessage());
		}
	}
}
