<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body>

	<div class="container">
	  <c:if test="${exception!=null}">
	   <div class="alert alert-danger">${exception}</div>
	  </c:if>
	 
     <div class="col-md-6">
		<f:form modelAttribute="categorie" method="post" action="saveCat"
			enctype="multipart/form-data">
			<div class="form-group">
				<f:input path="idCategorie" type="hidden" cssClass="form-control" />
				<f:errors path="idCategorie" cssClass="errors"></f:errors>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Categorie:</label>
				<f:input path="nomCategorie"  cssClass="form-control" />
				<f:errors path="nomCategorie" cssClass="errors"></f:errors>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Description:</label>
				<f:textarea path="description"  cssClass="form-control"/>
				<f:errors path="description" cssClass="errors"></f:errors>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Photo:</label>
				<input type="file" name="file" />
				<c:if test="${categorie.idCategorie!=null}">
				<span><img alt="" width="65" height="65" src="photoCat?idCat=${categorie.idCategorie}"></span>
				</c:if>
			</div>
			<div class="form-group">
				<input type="submit"  value="Sauvegarder" Class="btn btn-success" />
			</div>
		</f:form>
		</div>
	<div class="col-md-10">
		<h1>liste des categories</h1>
		
		<table class="table table-striped">
          <tr><th>ID</th><th>Nom Categorie</th><th>Description</th><th>photo</th><th>Edition</th><th>Supprimer</th></tr>
          <c:if test="${not empty categories}">
				<c:forEach var="listValue" items="${categories}">
				 <tr><td>${listValue.idCategorie}</td><td>${listValue.nomCategorie}</td>
					 <td>${listValue.description}</td><td><img alt="" width="65" height="65" src="photoCat?idCat=${listValue.idCategorie}"></td>
					 <td><a href="editeCat?idCat=${listValue.idCategorie}"><img src="${pageContext.request.contextPath}/resources/img/edit.png" width="30" height="30"></a></td>
					 <td><a href="suppCat?idCat=${listValue.idCategorie}"><img src="${pageContext.request.contextPath}/resources/img/delete.png" width="30" height="30"></a></td>	
				 </tr>
				</c:forEach>
		</c:if>
		</table>
	</div>
	</div>
</body>
</html>