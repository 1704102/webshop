<div class="product">

    Prijs: <@link_to controller="rproducts"  id=product.id>${product.prijs}</@link_to> |
    Naam: ${product.naam}|
    Omschrijving: ${product.omschrijving} |
    Catagory: ${product.catagory} |
    Plaatje: ${product.plaatje}

</div>


<@form controller="rproducts" id=product.id  method="post">

    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="Delete">
</@form>
