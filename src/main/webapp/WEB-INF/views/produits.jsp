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
		<f:form modelAttribute="produit" method="post" action="saveProd" enctype="multipart/form-data">
			<div class="form-group">
				<f:input path="idProduit" type="text" cssClass="form-control" />
				<f:errors path="idProduit" cssClass="errors"></f:errors>
			</div>
			<div class="form-group">
			<label for="exampleInputEmail1">Désignation:</label>
				<f:input path="designation"  cssClass="form-control" />
				<f:errors path="designation" cssClass="errors"></f:errors>
			</div>
			<div class="form-group">
			<label for="exampleInputEmail1">Description:</label>
				<f:textarea path="description" cssClass="form-control" ></f:textarea>
				<f:errors path="description" cssClass="errors"></f:errors>
			</div>
			<div class="form-group">
			<label for="exampleInputEmail1">Categorie:</label>
				<f:select path="categories.idCategorie" items="${categories}" itemValue="idCategorie" itemLabel="nomCategorie" cssClass="form-control" >
				</f:select>
				
			</div>
			<div class="form-group">
			<label for="exampleInputEmail1">Quantité:</label>
				<f:input path="qte" cssClass="form-control" />
				<f:errors path="qte" cssClass="errors"></f:errors>
			</div>
			<div class="form-group">
			<label for="exampleInputEmail1">Prix:</label>
				<f:input path="prix" cssClass="form-control" />
				<f:errors path="prix" cssClass="errors"></f:errors>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Photo:</label>
				<input type="file" name="file" />
			</div>
			<div class="form-group">
				<input type="submit"  value="Sauvegarder" Class="btn btn-success" />
			</div>
		</f:form>
		</div>
	<div class="col-md-10">
		<h1>liste des produits</h1>
		
		<table class="table table-striped">
          <tr><th>ID</th><th>Nom Produit</th><th>Designation</th><th>photo</th><th>Edition</th><th>Supprimer</th></tr>
          <c:if test="${not empty produits}">
				<c:forEach var="listValue" items="${produits}">
				 <tr><td>${listValue.idProduit}</td><td>${listValue.designation}</td>
					 <td>${listValue.description}</td>
					 <td><img alt="" width="65" height="65" src="photoProd?idP=${listValue.idProduit}"></td>
					 <td><a href="editeProd?idCat=${listValue.idProduit}"><img src="${pageContext.request.contextPath}/resources/img/edit.png" width="30" height="30"></a></td>
					 <td><a href="suppCat?idProd=${listValue.idProduit}"><img src="${pageContext.request.contextPath}/resources/img/delete.png" width="30" height="30"></a></td>	
				 </tr>
				</c:forEach>
		</c:if>
		</table>
		<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
	</div>
	</div>
</body>
</html>