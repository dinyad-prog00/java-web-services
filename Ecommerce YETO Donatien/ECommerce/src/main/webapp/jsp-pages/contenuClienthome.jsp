<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="m-10">

<div class="flex h-full">
	<div class="w-1/6 h-full">
	<div class="m-5">
	<h1 class="text-xl mb-5 font-bold leading-tight tracking-tight text-gray-900 md:text-2xl dark:text-white">
                  Mes infos
              </h1>
              <hr class="mb-5"/>
	<div >
                      <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Nom Prenom</label>
                      <input disabled value="${user.name }" type="text" name="name" id="name" placeholder="Nom complet" class="mb-5 bg-white border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required="">
                  </div>
                 
                  <div>
                      <label for="email" class="block mb-2 text-sm font-mmb-5 edium text-gray-900 dark:text-white">Ton émail</label>
                      <input disabled value="${user.email }" type="email" name="email" id="email" class="mb-5  bg-white border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="nom@company.com" required="">
                  </div>
                   <div>
                      <label for="phone" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Téléphone</label>
                      <input disabled value="${user.telephone }" type="text" name="phone" id="name" placeholder="+33 6 00 00 00 00" class="mb-5 bg-white border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required="">
                  </div>
                  <div>
                      <label for="address" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Adresse complète</label>
                      <input disabled value="${user.adresse }" type="text" name="addresse" id="name" placeholder="00 Rue La vie, 62100 Calais, Apt 005 " class="mb-5 bg-white border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required="">
                  </div>
               
	</div>
	</div>
	<div class="grow  h-full">
	<div class="m-5 ml-10">
	<h1 class="text-xl mb-5 font-bold leading-tight tracking-tight text-gray-900 md:text-2xl dark:text-white">
                  Mes commandes
              </h1>
              <hr class="mb-5"/>
	<div>
	<c:forEach var="cmd" items="${commandes}">
		<li class="mb-8"><span class="block text-md font-bold leading-tight tracking-tight text-gray-900"> Commande #${cmd.no_confirmation} <span class="ml-5"> &euro;${cmd.montant } </span> 
		
		<span class=" ml-5 inline-flex items-center justify-center w-5 h-5 me-1 text-sm font-semibold text-green-700 bg-blue-100 rounded-full dark:bg-gray-700 dark:text-blue-400">
<svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
<path fill="currentColor" d="m18.774 8.245-.892-.893a1.5 1.5 0 0 1-.437-1.052V5.036a2.484 2.484 0 0 0-2.48-2.48H13.7a1.5 1.5 0 0 1-1.052-.438l-.893-.892a2.484 2.484 0 0 0-3.51 0l-.893.892a1.5 1.5 0 0 1-1.052.437H5.036a2.484 2.484 0 0 0-2.48 2.481V6.3a1.5 1.5 0 0 1-.438 1.052l-.892.893a2.484 2.484 0 0 0 0 3.51l.892.893a1.5 1.5 0 0 1 .437 1.052v1.264a2.484 2.484 0 0 0 2.481 2.481H6.3a1.5 1.5 0 0 1 1.052.437l.893.892a2.484 2.484 0 0 0 3.51 0l.893-.892a1.5 1.5 0 0 1 1.052-.437h1.264a2.484 2.484 0 0 0 2.481-2.48V13.7a1.5 1.5 0 0 1 .437-1.052l.892-.893a2.484 2.484 0 0 0 0-3.51Z"/>
<path fill="#fff" d="M8 13a1 1 0 0 1-.707-.293l-2-2a1 1 0 1 1 1.414-1.414l1.42 1.42 5.318-3.545a1 1 0 0 1 1.11 1.664l-6 4A1 1 0 0 1 8 13Z"/>
</svg>
<span class="sr-only">Icon description</span>
</span>
		
		<span class="text-green-600"> Validée</span> </span>
			<div class="mt-2">
			<c:forEach var="item" items="${cmd.getProduitCommandes()}">
				<span class="mr-5 ">${item.quantite} X ${item.produit.name} (&euro;${item.produit.prix })</span>
        </c:forEach></div>
        
		</li>
</c:forEach>
</div>
	</div>
	
	</div>
	<div class="m-5 w-5/12  ml-10">
				<h1 class="text-xl mb-5 font-bold leading-tight tracking-tight text-gray-900 md:text-2xl dark:text-white">
                  Mes adresses
              </h1>
              <hr class="mb-5"/>
			<div>
		
			<div class="mb-5">
			<div class="flex flex-wrap">
			<c:forEach var="add" items="${adresses}">
					<div class="m-2 py-2 px-4 border rounded-xl">
					<span class="mr-5 block">${add.name }</span>
					<span class="mr-5 block">${add.adresse }</span>
					<span class="">${add.cp }</span> <span class="">${add.ville }</span>
					<a href="/ecom/chooseadresse?add=${add.id}"><span class="text-blue-500 mt-2 block">Utiliser</span></a>
	        
	        		</div>
	        		<hr class="my-5"/>
	        </c:forEach>
	       </div>
		
		
			 <a href="/ecom/addadresse" ><button class="mt-6 w-full rounded-md bg-blue-500 py-1.5 font-medium text-blue-50 hover:bg-blue-600">Ajouter addresse</button></a>
      
		
		
	</div>
	
	</div>
	</div>
</div>



</div>