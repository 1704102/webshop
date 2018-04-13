package app.controllers;

import app.Model.Product;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.RESTful;

@RESTful
public class RproductsController extends AppController {
    public void index(){
        view("products", Product.findAll().orderBy("id"));
    }
    public void create(){
        boolean valid = true;

        Product p = new Product();
        p.fromMap(params1st());
        if (!p.isValid()){
            flash("errors", p.errors());
            valid = false;
        }
        if (!valid){
            flash("params", params1st());
            redirect("./rproducts/new_form");
            return;
        }
        p.saveIt();
        flash("Product saved", "Your product was saved");
        redirect("rproducts");
    }
    public void show(){
        Product p = (Product)Product.findById(param("id"));
        if (p == null){
            render("/system/404");
        }else{
            view("product", p);
        }
    }

    public void newForm(){

    }

    public void destroy(){
        Product.delete("id = ?", param("id"));
        flash("product_deleted", "Your product was deleted");
    }
}
