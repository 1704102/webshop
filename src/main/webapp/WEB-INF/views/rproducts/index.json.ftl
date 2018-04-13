[
<#list products as product>
    {
        "Prijs": "${product.prijs}",
        "Naam": "${product.naam}",
        "Omschrijving": "${product.omschrijving}"
        "Catagory": "${product.catagory}"
        "Plaatje": "${product.plaatje}"
 }
    <#if product_has_next>,</#if>
</#list>
]
