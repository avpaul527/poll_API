package com.pollsAPI.polls.repository;

import com.pollsAPI.polls.domain.Choice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoiceRepository extends CrudRepository<Choice, Long> {

}
