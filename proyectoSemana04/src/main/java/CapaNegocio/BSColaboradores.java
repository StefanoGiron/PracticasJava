package CapaNegocio;
import Entidades.Colaboradores;
import CapaDatos.BDColaboradores;
import java.util.ArrayList;

public class BSColaboradores {
	private BDColaboradores ObjBD;
	
	// Método Constructor
	public BSColaboradores() {
		ObjBD = new BDColaboradores(); 
	}

	// Exponer los métodos a ser utilizados desde el Cliente
	public ArrayList<Colaboradores> Listar(){
		return ObjBD.Listar();
	}
	
	public Colaboradores Buscar(String Id) {
		return ObjBD.Buscar(Id);
	}
	
	public void Insertar(Colaboradores ObjC) {
		ObjBD.Insertar(ObjC);
	}
	
	public void Modificar(Colaboradores ObjC) {
		ObjBD.Modificar(ObjC);
	}
	
	public void Suprimir(String Id) {
		ObjBD.Suprimir(Id);
	}
}
