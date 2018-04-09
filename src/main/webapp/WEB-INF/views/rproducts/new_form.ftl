<@omschrijving for="naam">Create New Product</@omschrijving>

<h2>Create New Product:</h2>


<hr/>

<hr/>

<span class="message"><@flash name="values_missing"/></span>
<@form controller="rproducts" method="post">
<table>
    <tr>
        <td>Prijs:</td>
        <td>
            <input type="number" name="prijs" size="40" value="${(flasher.params.prijs)!""}"/>
            <span class="message">${(flasher.errors.prijs)!""}</span>
        </td>
    </tr>
    <tr>
        <td>Naam:</td>
        <td>
            <input type="text" name="naam" size="50" value="${(flasher.params.naam)!""}"/>
            <span class="message">${(flasher.errors.naam)!""}</span>
        </td>
    </tr>
    <tr>
        <td>Omschrijving:</td>
        <td>
            <textarea type="text" name="omschrijving" cols="200">${(flasher.params.omschrijving)!""}</textarea>
            <span class="message">${(flasher.errors.omschrijving)!""}</span>
        </td>
    </tr>
    <tr>
        <td>catagory:</td>
        <td>
            <textarea type="text" name="catagory" cols="500">${(flasher.params.catagory)!""}</textarea>
            <span class="message">${(flasher.errors.catagory)!""}</span>
        </td>
    </tr>
    <tr>
        <td>Plaatje:</td>
        <td>
            <textarea type="text" name="plaatje" cols="500">${(flasher.params.plaatje)!""}</textarea>
            <span class="message">${(flasher.errors.plaatje)!""}</span>
        </td>
    </tr>
    <tr>
        <td></td>

    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="Create"></td>
    </tr>
</table>



</@form>
