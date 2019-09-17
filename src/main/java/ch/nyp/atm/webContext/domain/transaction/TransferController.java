package ch.nyp.atm.webContext.domain.transaction;

import ch.nyp.atm.webContext.domain.transaction.dto.TransactionDTO;
import ch.nyp.atm.webContext.domain.user.User;
import ch.nyp.atm.webContext.domain.user.dto.UserATMDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/transaction")
public class TransferController {

    private TransactionService transactionService;

    @Autowired
    public TransferController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }



    @GetMapping("/showCash")
    public @ResponseBody ResponseEntity<UserATMDTO> getCash(){
        return new ResponseEntity<>(transactionService.getCash(), HttpStatus.OK);
    }

    @PutMapping("/deposit")
    public @ResponseBody ResponseEntity<TransactionDTO> depositCash(@RequestBody UserATMDTO user){
        return new ResponseEntity<>(transactionService.depositCash(user), HttpStatus.CREATED);
    }

    @PutMapping("/withdraw")
    public @ResponseBody ResponseEntity<TransactionDTO> withdrawCash(@RequestBody UserATMDTO user){
        return new ResponseEntity<>(transactionService.depositCash(user), HttpStatus.CREATED);
    }

}
