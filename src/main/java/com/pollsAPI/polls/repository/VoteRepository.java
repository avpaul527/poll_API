package com.pollsAPI.polls.repository;

import com.pollsAPI.polls.domain.Vote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VoteRepository extends CrudRepository<Vote, Long> {

    @Query(value= "select v.* from Choice c, Vote v where c.POLL_ID = ?1 and v.CHOICE_ID = c.CHOICE_ID",
            nativeQuery = true)
            public Iterable<Vote> findByPoll(Long pollId);

}
