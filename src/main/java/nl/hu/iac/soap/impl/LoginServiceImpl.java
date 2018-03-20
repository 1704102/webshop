package nl.hu.iac.soap.impl;

import com.webshop.Database.ProductDatabase;
import com.webshop.model.Customer;
import nl.hu.iac.soap.wsinterface.*;

import javax.jws.WebService;
import java.util.ArrayList;
import com.webshop.Database.DatabaseHelper;

@WebService(endpointInterface = "nl.hu.iac.soap.wsinterface.LoginServiceInterface")
public class LoginServiceImpl implements LoginServiceInterface {

    //Lijst met accounts
    ProductDatabase pDatabase = new ProductDatabase();
    private ArrayList<Customer> accounts = pDatabase.getCustomers();

    @Override
    public LoginResponse checkCredentials(LoginRequest request) throws LoginFault_Exception {
        LoginResponse response = new LoginResponse();


        try {
            Customer user = getUser(request.getUsername(), request.getPassword());

            // Check of de request overeenkomt met de accountgegevens
            if (user != null && user.getPassword().equals(request.getPassword())) {
                response.setSucces("Succesvol ingelogd!");
            } else {
                response.setSucces(user.getName() + user.getPassword() + "niet correct");

            }

            // Hier vangt hij de RuntimeException op en stuurt een foutmelding
        } catch (RuntimeException e) {
            e.printStackTrace();
            response.setSucces("Niet ingelogd.");
            LoginFault loginFault = new LoginFault();
            loginFault.setErrorCode((short) 1);
            loginFault.setMessage("De gegevens die u heeft ingevoerd zijn niet correct.");
            throw new LoginFault_Exception(
                    "Er ging iets mis bij het inloggen", loginFault);
        }

        return response;
    }

    //Account toevoegen
    @Override
    public AddResponse addCredentials(AddRequest addRequest) throws AddFault_Exception {
        AddResponse response = new AddResponse();

        try {
            Customer user = new Customer();

            String username = addRequest.getUsername();
            String password = addRequest.getPassword();

            user.setName(username);
            user.setPassword(password);
            pDatabase.addCustomer(user);
            accounts.add(user);

            response.setSucces("Succesvol geregistreerd!");
        } catch (RuntimeException e) {
            AddFault fault = new AddFault();
            fault.setErrorCode((short) 1);
            fault.setMessage("De gegevens die u heeft ingevoerd zijn niet correct.");
            throw new AddFault_Exception("Er ging iets mis bij het registreren", fault);
        }

        return response;
    }

    private Customer getUser(String username, String email) {
        Customer user = null;

        for (Customer account : accounts) {
            if (account.getName() != null && account.getName().equals(username)) {
                return account;
            }

            return user;
        }
        return null;
    }
}