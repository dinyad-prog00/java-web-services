<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="m-10 flex justify-center">

<div class="w-2/3 h-full">
	
	<div class="m-5">
	
	<div class="grow  h-full">
	<div class="m-5 ml-10">
				<h1 class="text-xl mb-5 font-bold leading-tight tracking-tight text-gray-900 md:text-2xl dark:text-white">
                  Mes adresses
              </h1>
              <hr class="mb-5"/>
			<div>
		
			<div class="mb-5">
			<div class="flex">
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