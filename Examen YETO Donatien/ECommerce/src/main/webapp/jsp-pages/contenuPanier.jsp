
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
    @layer utilities {
    input[type="number"]::-webkit-inner-spin-button,
    input[type="number"]::-webkit-outer-spin-button {
      -webkit-appearance: none;
      margin: 0;
    }
  }
</style>
<c:if test="${empty userCart or empty userCart.items}">
<div class="w-full ">
		<h1 class=" ml-8 text-3xl font-extrabold tracking-tight text-slate-900 text-center mt-10 mb-5">Mon panier est vide</h1>
		<a href="/ecom/categories" class="block rounded-md border text-center border-transparent bg-indigo-600 px-8 py-3  font-medium text-white hover:bg-indigo-700">Voir notre selection</a>
        
   </div>
   </c:if>
   <c:if test="${not empty userCart and not empty userCart.items}">

<div class="max-w-5xl">
<h1 class=" ml-8 text-3xl font-extrabold tracking-tight text-slate-900 text-center mt-10 mb-5">Mon panier</h1>
   </div>

    
  
    <div class="mx-auto max-w-5xl justify-center px-6 md:flex md:space-x-6 xl:px-0">
    
      <div class="rounded-lg md:w-2/3">
      <c:forEach var="item" items="${userCart.items}">
        <div class="justify-between mb-6 rounded-lg bg-white p-6 shadow-sm border sm:flex sm:justify-start">
          <div class=" sm:flex sm:w-full sm:justify-between">
            <div class="mt-5 sm:mt-0">
              <h2 class="text-lg font-bold text-gray-900">${item.produit.name}</h2>
              <p class="mt-1 text-xs text-gray-700">${item.produit.description }</p>
              <span class="text-xs text-blue-900 cursor-pointer block mt-3 w-min" onClick ="panierAction(${item.produit.id},'delete','/ecom/panier')">Supprimer</span>
            </div>
            <div class="mt-4 flex justify-between sm:space-y-6 sm:mt-0 sm:block sm:space-x-6">
              <div class="flex items-center border-gray-100">
                <span class="cursor-pointer rounded-l bg-gray-100 py-1 px-3.5 duration-100 hover:bg-blue-500 hover:text-blue-50" onClick ="panierAction(${item.produit.id},'decrement','/ecom/panier')"> - </span>
                 <span class="bg-white py-1 px-3.5 text-xs duration-100"> ${item.qt} </span>
                <span class="cursor-pointer rounded-r bg-gray-100 py-1 px-3 duration-100 hover:bg-blue-500 hover:text-blue-50" onClick ="panierAction(${item.produit.id},'increment','/ecom/panier')"> + </span>
              </div>
              <div class="flex items-end  space-x-4">
                <p class="text-sm ml-auto">&euro;${item.produit.prix}</p>
                <!-- <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="h-5 w-5 cursor-pointer duration-150 hover:text-red-500">
                  <path stroke-linecap="round" stroke-linejoin="round" d="M6 18L18 6M6 6l12 12" />
                </svg> -->
              </div>
            </div>
          </div>
        </div>
        </c:forEach>
        </div>
       
      <!-- Sub total -->
      <div class="mt-6 h-full rounded-lg border bg-white p-6 shadow-md md:mt-0 md:w-1/3">
        <div class="mb-2 flex justify-between">
          <p class="text-gray-700">Sous Total</p>
          <p class="text-gray-700">&euro;${userCart.getSubTotalPrice() }</p>
        </div>
        <div class="flex justify-between">
          <p class="text-gray-700">Livraison</p>
          <p class="text-gray-700">&euro;${userCart.deliveryCost()}</p>
        </div>
        <hr class="my-4" />
        <div class="flex justify-between">
          <p class="text-lg font-bold">Total</p>
          <div class="">
            <p class="mb-1 text-lg font-bold">&euro;${userCart.getTotalPrice()}</p>
           <!--  <p class="text-sm text-gray-700">including VAT</p> -->
          </div>
        </div>
         <a href="/ecom/commanderesume" ><button class="mt-6 w-full rounded-md bg-blue-500 py-1.5 font-medium text-blue-50 hover:bg-blue-600">Valider et Payer</button></a>
      </div>
    </div>
     </c:if>
  






