<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://cdn.tailwindcss.com"></script>
<title><%=request.getAttribute("pageTitle")%></title>

<!-- Ajoutez vos balises meta, liens CSS, etc. ici -->
</head>
<body>
	<c:if test="${pageTitle == 'Index'}">
        <c:set var="aclClass" value="bg-gray-900 text-white" />
        <c:set var="catClass" value="text-gray-300 hover:bg-gray-700 hover:text-white" />
    </c:if>
    <c:if test="${pageTitle == 'Categories'}">
        <c:set var="aclClass" value="text-gray-300 hover:bg-gray-700 hover:text-white" />
        <c:set var="catClass" value="bg-gray-900 text-white" />
    </c:if>
    
    <c:if test="${pageTitle != 'Categories' and pageTitle != 'Index'}">
        <c:set var="aclClass" value="text-gray-300 hover:bg-gray-700 hover:text-white" />
        <c:set var="catClass" value="text-gray-300 hover:bg-gray-700 hover:text-white" />
    </c:if>
    
	<header>
		<nav class="bg-gray-800">
			<div class="mx-auto max-w-7xl px-2 sm:px-6 lg:px-8">
				<div class="relative flex h-16 items-center justify-between">
					<div class="absolute inset-y-0 left-0 flex items-center sm:hidden">
						<!-- Mobile menu button-->
						<button type="button"
							class="relative inline-flex items-center justify-center rounded-md p-2 text-gray-400 hover:bg-gray-700 hover:text-white focus:outline-none focus:ring-2 focus:ring-inset focus:ring-white"
							aria-controls="mobile-menu" aria-expanded="false">
							<span class="absolute -inset-0.5"></span> <span class="sr-only">Open
								main menu</span>
							<!--
            Icon when menu is closed.

            Menu open: "hidden", Menu closed: "block"
          -->
							<svg class="block h-6 w-6" fill="none" viewBox="0 0 24 24"
								stroke-width="1.5" stroke="currentColor" aria-hidden="true">
            <path stroke-linecap="round" stroke-linejoin="round"
									d="M3.75 6.75h16.5M3.75 12h16.5m-16.5 5.25h16.5" />
          </svg>
							<!--
            Icon when menu is open.

            Menu open: "block", Menu closed: "hidden"
          -->
							<svg class="hidden h-6 w-6" fill="none" viewBox="0 0 24 24"
								stroke-width="1.5" stroke="currentColor" aria-hidden="true">
            <path stroke-linecap="round" stroke-linejoin="round"
									d="M6 18L18 6M6 6l12 12" />
          </svg>
						</button>
					</div>
					<div
						class="flex flex-1 items-center justify-center sm:items-stretch sm:justify-start">
						<div class="flex flex-shrink-0 items-center">
							<a href="/ecom">
							<span class="text-xl black text-white">WebCatalog</span>
							</a> 
						</div>
						<div class="hidden sm:ml-6 sm:block">
							<div class="flex space-x-4">
								<!-- Current: "bg-gray-900 text-white", Default: "text-gray-300 hover:bg-gray-700 hover:text-white" -->
								<a href="/ecom"
									class="${aclClass } text-white rounded-md px-3 py-2 text-sm font-medium"
									aria-current="page">Accueil</a> 
									<a href="/ecom/categories"
									class="${catClass }  rounded-md px-3 py-2 text-sm font-medium">Catalogue</a>
								<c:if test="${empty authenticated}">
									<a href="/ecom/login"
									class="text-gray-300 hover:bg-gray-700 hover:text-white rounded-md px-3 py-2 text-sm font-medium">Se connecter</a>
									<a href="/ecom/signup"
									class="text-gray-300 hover:bg-gray-700 hover:text-white rounded-md px-3 py-2 text-sm font-medium">S'inscrire</a>
									
									</c:if>
									<c:if test="${not empty authenticated}">
									<a href="/ecom/clienthome"
									class="text-gray-300 hover:bg-gray-700 hover:text-white rounded-md px-3 py-2 text-sm font-medium">Commandes</a>
									
									<a href="/ecom/logout"
									class="text-gray-300 hover:bg-gray-700 hover:text-white rounded-md px-3 py-2 text-sm font-medium">Se déconnecter</a>
									
									</c:if>
							</div>
						</div>
					</div>
					<div
						class="absoluate inset-y-0 right-0 flex items-center pr-2 sm:static sm:inset-auto sm:ml-6 sm:pr-0">
						<c:if test="${not empty authenticated}">
						<span class="text-gray-300  rounded-md px-3 py-2 text-sm font-medium">${user.name}</span>
						</c:if>
						<a href="/ecom/panier" 
							class="relative relative rounded-full bg-gray-800 p-1">
							
								<!-- <img src="/ecom/assets/img/schart2.png" width="60" alt="Symbols Grocery Cart" />  -->
								<img src="https://www.freeiconspng.com/uploads/grocery-cart-icon-8.png" width="55" alt="Symbols Grocery Cart" /> 
								<c:if test="${not empty userCart and not empty userCart.items}">
								<div class="absolute inline-flex items-center justify-center w-6 h-6 text-xs font-bold text-white bg-red-500 border-2 border-white rounded-full top-0 end-0 dark:border-gray-900">${userCart.countItem()}</div>
								</c:if>
							</a>
							
							
					</div>
				</div>
			</div>
		</nav>

	</header>

	<div class="">
		<!-- Contenu spécifique à chaque page -->
		<%
		String content = request.getAttribute("contentPage").toString();
		%>
		<jsp:include page="<%=content%>" />
	</div>

	<footer>
		<!-- Pied de page commun -->
		
	</footer>
	<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="/ecom/assets/js/panier.js"></script>
</body>
</html>
