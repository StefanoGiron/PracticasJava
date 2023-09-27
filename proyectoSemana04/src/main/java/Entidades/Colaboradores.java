package Entidades;

public class Colaboradores {
	// Campos o atributos
	private String Id;
    private String Apellidos;
    private String Nombres;
    private int Edad;
    private char Sexo;
    
    // Métodos Constructores
	public Colaboradores() {
	}

	public Colaboradores(String id, String apellidos, String nombres, int edad, char sexo) {
		Id = id;
		Apellidos = apellidos;
		Nombres = nombres;
		Edad = edad;
		Sexo = sexo;
	}

	// Propiedades de Lectura y Escritura
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public char getSexo() {
		return Sexo;
	}

	public void setSexo(char sexo) {
		Sexo = sexo;
	}
    
}
