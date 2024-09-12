<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="m-10 flex justify-center">

<div class="w-2/3 h-full">
	
	<div class="m-5">
	
	<div class="grow  h-full">
	<div class="m-5 ml-10">
				<h1 class="text-xl mb-5 font-bold leading-tight tracking-tight text-gray-900 md:text-2xl dark:text-white">
                  Résumé de ma commande
              </h1>
              <hr class="mb-5"/>
			<div>
		
			<div class="mb-5"><span class="block text-md font-bold leading-tight tracking-tight text-gray-900"> Commande  <span class="ml-5"> &euro;${userCart.getTotalPrice()} </span> </span>
				<div class="ml-5">
				<c:forEach var="item" items="${userCart.items}">
					<span class="mr-5 block my-5">${item.qt} X ${item.produit.name} (&euro;${item.produit.prix })</span>
	        </c:forEach>
	        <span class="mr-5 block my-5">Prix livraison (&euro;${userCart.deliveryCost()})</span>
				</div>
	        
			</div>
		
		<div class="mb-5"><span class="block text-md font-bold leading-tight tracking-tight text-gray-900"> Adresse de livraison </span> </span>
				<c:if test="${not empty adresse}">
				<div class="m-2 py-2 px-4 border rounded-xl">
					<span class="mr-5 block">${adresse.name }</span>
					<span class="mr-5 block">${adresse.adresse }</span>
					<span class="">${adresse.cp }</span> <span class="">${adresse.ville }</span>
					<a href="/ecom/adresse"><span class="text-blue-500 mt-2 block">Changer</span></a>
	        		</div>
	        		</c:if>
	        		<c:if test="${empty adresse}">
	        		<a href="/ecom/adresse"><span class="text-blue-500 mt-2 block">Choisir</span></a>
	        
	        		</c:if>
			</div>
			 <a href="/ecom/commande" ><button class="mt-6 w-full rounded-md bg-blue-500 py-1.5 font-medium text-blue-50 hover:bg-blue-600">Proceder au paiement</button></a>
      
		
		</div>
	</div>
	
	</div>
	</div>
</div>



</div>