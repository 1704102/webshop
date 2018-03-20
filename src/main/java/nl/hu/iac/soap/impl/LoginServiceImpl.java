package nl.hu.iac.soap.impl;

import java.util.ArrayList;

import javax.jws.WebService;

import nl.hu.iac.soap.wsinterface.AddFault;
import nl.hu.iac.soap.wsinterface.AddFault_Exception;
import nl.hu.iac.soap.wsinterface.AddRequest;
import nl.hu.iac.soap.wsinterface.AddResponse;
import nl.hu.iac.soap.wsinterface.LoginFault;
import nl.hu.iac.soap.wsinterface.LoginFault_Exception;
import nl.hu.iac.soap.wsinterface.LoginRequest;
import nl.hu.iac.soap.wsinterface.LoginResponse;
import nl.hu.iac.soap.wsinterface.LoginServiceInterface;

@WebService(endpointInterface = "nl.hu.iac.soap.wsinterface.LoginServiceInterface")
public class LoginServiceImpl implements LoginServiceInterface {

    //Lijst met accounts
    private static final ArrayList<Account> accounts = new ArrayList<Account>();

    @Override
    public LoginResponse checkCredentials(LoginRequest request) throws LoginFault_Exception {
        LoginResponse response = new LoginResponse();

        try {
            Account user = getUser(request.getUsername(),request.getEmail());

            // Check of de request overeenkomt met de accountgegevens
            if(user != null && user.getPassword().equals(request.getPassword())) {
                response.setSucces("Succesvol ingelogd!");
            } else {
                response.setSucces(user.getUsername() + user.getPassword() + "niet correct");

            }

            // Hier vangt hij de RuntimeException op en stuurt een foutmelding
        } catch (RuntimeException e) {
            e.printStackTrace();
            response.setSucces("Niet ingelogd.");
            LoginFault loginFault = new LoginFault();
            loginFault.setErrorCode((short) 1);
            loginFault.setMessage("De gegevens die u heeft ingevoerd zijn niet correct.");
            LoginFault_Exception fault = new LoginFault_Exception(
                    "Er ging iets mis bij het inloggen", loginFault);
            throw fault;
        }

        return response;
    }

    //Account toevoegen
    @Override
    public AddResponse addCredentials(AddRequest addRequest) throws AddFault_Exception {
        AddResponse response = new AddResponse();

        try{
            Account user = new Account();

            String username = addRequest.getUsername();
            String email = addRequest.getEmail();
            String password = addRequest.getPassword();

            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);

            accounts.add(user);

            response.setSucces("Succesvol geregistreerd!");
        } catch (RuntimeException e){
            AddFault fault = new AddFault();
            fault.setErrorCode((short) 1);
            fault.setMessage("De gegevens die u heeft ingevoerd zijn niet correct.");
            AddFault_Exception addfault = new AddFault_Exception("Er ging iets mis bij het registreren", fault);
            throw addfault;
        }

        return response;
    }

    private Account getUser(String username, String email){
        Account user = null;

        for(Account account : accounts){
            if(account.getUsername() != null && account.getUsername().equals(username)){
                return account;
            } else if (account.getEmail() != null && account.getEmail().equals(email)){
                return account;
            }
        }

        return user;
    }
}