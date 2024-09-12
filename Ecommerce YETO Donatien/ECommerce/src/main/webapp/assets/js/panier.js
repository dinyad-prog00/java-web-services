const panierAction = (productId, opp, redirect)=> {
    

    // Axios POST request to add product to cart
    axios.post('/ecom/panier', {
        productId,
        opp
    },{
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    }
})
    .then(function(response) {
        window.location.href = redirect;
    })
    .catch(function(error) {
        // Handle errors
        console.error(error);
    });
};
