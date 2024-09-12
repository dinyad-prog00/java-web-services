<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="m-10 flex justify-center">

<div class="w-1/2 h-full">
	
	<div class="m-5">
	
	<div class="grow  h-full">
	<div class="m-5 ml-10">
				<h1 class="text-xl mb-5 font-bold leading-tight tracking-tight text-gray-900 md:text-2xl dark:text-white">
                  Ajout adresse
              </h1>
              <hr class="mb-5"/>
			<div>
			
			<form class="space-y-4 md:space-y-6" action="/ecom/addadresse" method="post">
			<div>
                      <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Nom Prénom</label>
                      <input type="text" name="name" class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="Jean Coov" required="">
                  </div>
                  <div>
                      <label for="adresse" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Adresse</label>
                      <input type="text" name="adresse" id="adresse" class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="10 Rue Coll" required="">
                  </div>
                  <div class="flex w-full">
                  <div class="flex-1 mr-5">
                      <label for="ville" class=" block mb-2 text-sm font-medium text-gray-900 dark:text-white">Ville</label>
                      <input type="text" name="ville" id="ville" placeholder="Calais" class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required="">
                  </div >
                  <div class="flex-1">
                      <label for="cp" class="flex-1 block mb-2 text-sm font-medium text-gray-900 dark:text-white">Code postal</label>
                      <input type="text" name="cp" id="cp" placeholder="62100" class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required="">
                  </div>
                  </div>
                  
                  
                  <button type="submit" class="w-full text-white bg-blue-600 hover:bg-blue-700 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800">Ajouter</button>
                  
              </form>
		
			
		
		
		
		</div>
	</div>
	
	</div>
	</div>
</div>



</div>