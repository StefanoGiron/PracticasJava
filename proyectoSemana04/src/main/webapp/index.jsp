<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Entidades.Colaboradores" %>
<%@ page import="CapaNegocio.BSColaboradores" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>CRUD</title>
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<%
		BSColaboradores ObjN = new BSColaboradores();
		ArrayList<Colaboradores> Lista = new ArrayList<>();
		Lista = ObjN.Listar();
	%>
	<h1>Mantenimiento de la tabla Colaboradores</h1>
	<table class="table">
		<tr>
			<th>Id</th>
			<th>Apellidos</th>
			<th>Nombres</th>
			<th>Edad</th>
			<th>Sexo</th>
			<th>Opciones</th>
		</tr>
		<% for(Colaboradores ObjC : Lista){
			String linkView = "<a href=view.jsp?id=" + ObjC.getId() + ">Ver</a>";
			String linkEdit = "<a href=edit.jsp?id=" + ObjC.getId() + ">Editar</a>";
			String linkDel = "<a href=del.jsp?id=" + ObjC.getId() + ">Suprimir</a>";
		%>
			<tr>
				<td><%=ObjC.getId()%></td>
				<td><%=ObjC.getApellidos()%></td>
				<td><%=ObjC.getNombres()%></td>
				<td><%=ObjC.getEdad()%></td>
				<td><%=ObjC.getSexo()%></td>
				<td><%=linkView%> | <%=linkEdit%> | <%=linkDel%></td>
			</tr>
		<% } %>
	</table>
	<a href=add.jsp>Registrar Colaborador</a>
</body>
</html>