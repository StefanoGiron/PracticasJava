<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Entidades.Colaboradores" %>
<%@ page import="CapaNegocio.BSColaboradores" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Visualizar</title>
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<h1>DATOS DEL COLABORADOR</h1>
	<%
		String Id = request.getParameter("id");
		BSColaboradores ObjBD = new BSColaboradores();
		Colaboradores ObjC = new Colaboradores();
		ObjC = ObjBD.Buscar(Id);
	%>
	<table class="table">
		<tr>
			<td>DNI</td><td><%=ObjC.getId()%></td>
		</tr>
		<tr>
			<td>APELLIDOS</td><td><%=ObjC.getApellidos()%></td>
		</tr>
		<tr>
			<td>NOMBRES</td><td><%=ObjC.getNombres()%></td>
		</tr>
		<tr>
			<td>EDAD</td><td><%=ObjC.getEdad()%></td>
		</tr>
		<tr>
			<td>SEXO</td><td><%=ObjC.getSexo()%></td>
		</tr>
	</table>
	<a href=index.jsp>Regresar al Listado</a>
</body>
</html>