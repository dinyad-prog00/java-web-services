<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="">
	<div class="bg-white">
		<div>

			<div class="relative z-40 lg:hidden" role="dialog" aria-modal="true">

				<div class="fixed inset-0 bg-black bg-opacity-25"></div>

				<div class="fixed inset-0 z-40 flex">

					<div
						class="relative ml-auto flex h-full w-full max-w-xs flex-col overflow-y-auto bg-white py-4 pb-12 shadow-xl">
						<div class="flex items-center justify-between px-4">
							<h2 class="text-lg font-medium text-gray-900">Filters</h2>
							<button type="button"
								class="-mr-2 flex h-10 w-10 items-center justify-center rounded-md bg-white p-2 text-gray-400">
								<span class="sr-only">Close menu</span>
								<svg class="h-6 w-6" fill="none" viewBox="0 0 24 24"
									stroke-width="1.5" stroke="currentColor" aria-hidden="true">
                <path stroke-linecap="round" stroke-linejoin="round"
										d="M6 18L18 6M6 6l12 12" />
              </svg>
							</button>
						</div>


						<form class="mt-4 border-t border-gray-200">
							<h3 class="sr-only">Categories</h3>
							<ul role="list" class="px-2 py-3 font-medium text-gray-900">
								<c:forEach var="cat" items="${categories}">
									<li><a href="#" class="block px-2 py-3">${cat.name}</a></li>
								</c:forEach>
							</ul>
						</form>
					</div>
				</div>
			</div>

			<main class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
				<div
					class="flex items-baseline justify-between border-b border-gray-200 pb-6 pt-24">
					<h1 class="text-4xl font-bold tracking-tight text-gray-900">Notre
						catalogue</h1>

					<div class="flex items-center">
						<button type="button"
							class="-m-2 ml-5 p-2 text-gray-400 hover:text-gray-500 sm:ml-7">
							<span class="sr-only">View grid</span>
							<svg class="h-5 w-5" aria-hidden="true" viewBox="0 0 20 20"
								fill="currentColor">
              <path fill-rule="evenodd"
									d="M4.25 2A2.25 2.25 0 002 4.25v2.5A2.25 2.25 0 004.25 9h2.5A2.25 2.25 0 009 6.75v-2.5A2.25 2.25 0 006.75 2h-2.5zm0 9A2.25 2.25 0 002 13.25v2.5A2.25 2.25 0 004.25 18h2.5A2.25 2.25 0 009 15.75v-2.5A2.25 2.25 0 006.75 11h-2.5zm9-9A2.25 2.25 0 0011 4.25v2.5A2.25 2.25 0 0013.25 9h2.5A2.25 2.25 0 0018 6.75v-2.5A2.25 2.25 0 0015.75 2h-2.5zm0 9A2.25 2.25 0 0011 13.25v2.5A2.25 2.25 0 0013.25 18h2.5A2.25 2.25 0 0018 15.75v-2.5A2.25 2.25 0 0015.75 11h-2.5z"
									clip-rule="evenodd" />
            </svg>
						</button>
						<button type="button"
							class="-m-2 ml-4 p-2 text-gray-400 hover:text-gray-500 sm:ml-6 lg:hidden">
							<span class="sr-only">Filters</span>
							<svg class="h-5 w-5" aria-hidden="true" viewBox="0 0 20 20"
								fill="currentColor">
              <path fill-rule="evenodd"
									d="M2.628 1.601C5.028 1.206 7.49 1 10 1s4.973.206 7.372.601a.75.75 0 01.628.74v2.288a2.25 2.25 0 01-.659 1.59l-4.682 4.683a2.25 2.25 0 00-.659 1.59v3.037c0 .684-.31 1.33-.844 1.757l-1.937 1.55A.75.75 0 018 18.25v-5.757a2.25 2.25 0 00-.659-1.591L2.659 6.22A2.25 2.25 0 012 4.629V2.34a.75.75 0 01.628-.74z"
									clip-rule="evenodd" />
            </svg>
						</button>
					</div>
				</div>

				<section aria-labelledby="products-heading" class="pb-24 pt-6">
					<h2 id="products-heading" class="sr-only">Products</h2>

					<div class="grid grid-cols-1 gap-x-8 gap-y-10 lg:grid-cols-4">
						<!-- Filters -->
						<form class="hidden lg:block">



							<div class="border-b border-gray-200 py-2 pb-6">
								<h3 class="-my-3 flow-root">
									<!-- Expand/collapse section button -->
									<button type="button"
										class="flex w-full items-center justify-between bg-white py-3 text-sm text-gray-400 hover:text-gray-500"
										aria-controls="filter-section-1" aria-expanded="false">
										<span class="font-medium text-gray-900">Categorie</span> </span>
									</button>
								</h3>
								<!-- Filter section, show/hide based on section state. -->
								<div class="pt-6" id="filter-section-1">
									<div class="space-y-4">
										<c:forEach var="cat" items="${categories}">
											<%-- <div class="flex items-center">
											<input id="filter-category-0" name="category[]"
												value="new-arrivals" type="checkbox"
												class="h-4 w-4 rounded border-gray-300 text-indigo-600 focus:ring-indigo-500">
											<label for="filter-category-0"
												class="ml-3 text-sm text-gray-600">${cat.name}</label>
										</div> --%>
											<label for="filter-category-0"
												class="ml-3 text-gray-600 block"><a
												href="/ecom/categories?id=${cat.id}">
												
												<c:if test="${id == cat.id}">
														<span
															class="text-blue-900 font-black text-md">${cat.name }</span>
													</c:if> 
													<c:if test="${id != cat.id}">
														<span
															class="text-gray-900 text-sm">${cat.name }</span>
													</c:if>
												
												</a></label>
										</c:forEach>



									</div>
								</div>
							</div>

						</form>

						<!-- Product grid -->
						<div class="lg:col-span-3 flex flex-wrap">
							<!-- Your content -->
							<c:choose>
								<c:when test="${produits == null}">
									<p>Selectionnez une catégorie pour voir les produits!</p>
								</c:when>
								<c:when test="${empty produits}">
									<p>Aucun produits dans cette catégorie!</p>
								</c:when>
								<c:otherwise>
									<c:forEach var="p" items="${produits}">


										<div
											class="w-64 bg-white border border-gray-200 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700 m-2">
											<!--  <a href="#"> <img  class="rounded rounded-t-lg"
												src="https://www.dourgne.fr/wp-content/uploads/2021/04/Collecte-de-livres-dvd-et-cd.jpg"
												alt="product image" />
											</a>  -->
											<div class="px-5 pb-5">
												<a href="#">
														<h5
															class="text-xl mt-5 font-semibold tracking-tight text-gray-900">${p.name }</h5>
												</a>
												<div
													class="flex items-center mt-2.5 mb-5 font-normal text-gray-700">${p.description }</div>
												<div class="flex items-center justify-between">
													<span
														class="text-3xl font-bold text-gray-900 dark:text-white">&euro;${p.prix}</span>
													<a onClick ="panierAction(${p.id},'add','/ecom/categories')"
														class="cursor-pointer text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
														+ Panier</a>
												</div>
											</div>
										</div>

									</c:forEach>
								</c:otherwise>
							</c:choose>

						</div>
					</div>
				</section>
			</main>
		</div>
	</div>

</div>