<@content for ="title">Restful Pruducts</@content>


<@link_to controller="products">All Products</@link_to> | <@link_to controller="rproducts" action="new_form">New Product</@link_to>
<span class="message"><@flash name="product_deleted"/></span>
<span class="message"><@flash name="product_saved"/></span>

<p></p>
Products:

<#if products?size == 0>
    no products found
    <#else>
    <@render partial="product" collection=products spacer="spacer"/>
</#if>