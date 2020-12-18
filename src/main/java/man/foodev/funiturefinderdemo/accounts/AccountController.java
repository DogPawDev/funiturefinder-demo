package man.foodev.funiturefinderdemo.accounts;


import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Controller
@RequestMapping(value = "/api/user")
public class AccountController {
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public AccountController(AccountRepository accountRepository, ModelMapper modelMapper) {
        this.accountRepository=accountRepository;
        this.modelMapper=modelMapper;
    }


    @GetMapping
    public ResponseEntity test( AccountDTO accountDTO ){
        Account account = modelMapper.map(accountDTO,Account.class);
        Account newAccount = this.accountRepository.save(account);
        URI createURI =  linkTo(AccountController.class).slash("{id}").toUri();

        return ResponseEntity.created(createURI).body(account);
    }

}
