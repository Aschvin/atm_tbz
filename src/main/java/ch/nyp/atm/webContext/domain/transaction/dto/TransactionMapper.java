package ch.nyp.atm.webContext.domain.transaction.dto;

import ch.nyp.atm.config.generic.DTOMapper;
import ch.nyp.atm.webContext.domain.transaction.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy= ReportingPolicy.IGNORE)
public interface TransactionMapper extends DTOMapper<Transaction, TransactionDTO> {
}
