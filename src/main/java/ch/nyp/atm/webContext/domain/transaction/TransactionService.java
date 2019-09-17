package ch.nyp.atm.webContext.domain.transaction;

import ch.nyp.atm.webContext.domain.transaction.dto.TransactionDTO;
import ch.nyp.atm.webContext.domain.user.User;
import ch.nyp.atm.webContext.domain.user.UserDetailsImpl;
import ch.nyp.atm.webContext.domain.user.UserService;
import ch.nyp.atm.webContext.domain.user.dto.UserATMDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private UserService service;
    private TransactionRepository repository;

    @Autowired
    public TransactionService(UserService service, TransactionRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    public UserATMDTO getCash() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return new UserATMDTO(service.findById(userDetails.getUser().getId()).getUsername(),service.findById(userDetails.getUser().getId()).getFirstName(),service.findById(userDetails.getUser().getId()).getLastName(),service.findById(userDetails.getUser().getId()).getCash());
    }

    public TransactionDTO depositCash(UserATMDTO user){
        Double depositCash = user.getCash();
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User newUser = service.findByUsername(userDetails.getUser().getUsername());
        newUser.setCash(newUser.getCash()+depositCash);

        service.save(newUser);

        Transaction transaction = new Transaction(newUser, newUser, depositCash, false, false, false, true);

        return new TransactionDTO(repository.save(transaction).getId(), new UserATMDTO(repository.save(transaction).getUser1().getUsername(), repository.save(transaction).getUser1().getFirstName(),repository.save(transaction).getUser1().getLastName(), repository.save(transaction).getUser1().getCash()), new UserATMDTO(repository.save(transaction).getUser2().getUsername(), repository.save(transaction).getUser2().getFirstName(), repository.save(transaction).getUser2().getLastName(), repository.save(transaction).getUser2().getCash()), repository.save(transaction).getAmount(), repository.save(transaction).getSent(), repository.save(transaction).getReceived(), repository.save(transaction).getWithdrawed(), repository.save(transaction).getDeposit());

    }

    public TransactionDTO withdrawCash(UserATMDTO user){
        Double withdrawCash = user.getCash();
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User newUser = service.findByUsername(userDetails.getUser().getUsername());
        if (newUser.getCash()-withdrawCash >= 0){
            newUser.setCash(newUser.getCash()-withdrawCash);
            service.save(newUser);
            Transaction transaction = new Transaction(newUser, newUser, withdrawCash, false, false, false, true);
            return new TransactionDTO(repository.save(transaction).getId(), new UserATMDTO(repository.save(transaction).getUser1().getUsername(), repository.save(transaction).getUser1().getFirstName(),repository.save(transaction).getUser1().getLastName(), repository.save(transaction).getUser1().getCash()), new UserATMDTO(repository.save(transaction).getUser2().getUsername(), repository.save(transaction).getUser2().getFirstName(), repository.save(transaction).getUser2().getLastName(), repository.save(transaction).getUser2().getCash()), repository.save(transaction).getAmount(), repository.save(transaction).getSent(), repository.save(transaction).getReceived(), repository.save(transaction).getWithdrawed(), repository.save(transaction).getDeposit());
        }else {
            return null;
        }




    }

}
