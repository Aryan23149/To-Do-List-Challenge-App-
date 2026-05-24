package com.example.ChallengeApp;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChallengeService {
    //private ArrayList<Challenge> challenge=new ArrayList<Challenge>();
    @Autowired
    private ChallengeRepository challengeRepository;
    private Long nextId=1L;
    @Autowired
    public ChallengeService(ChallengeRepository challengeRepository){
        this.challengeRepository=challengeRepository;
        Challenge challenge1=new Challenge(this.nextId++,"hello","first challenge");
        challengeRepository.save(challenge1);
    }
    public List<Challenge> getAllChallenges(){

        return challengeRepository.findAll();
    }
    public boolean addChallenge(Challenge c1){
        if(c1!=null) {
            c1.setId(this.nextId++);
            challengeRepository.save(c1);
            return true;
        }
        return false;
    }
    public Challenge getChallenge(String month){
        Optional<Challenge> challenge= challengeRepository.findByMonthIgnoreCase(month);
        return challenge.orElse(null);
    }
    public boolean updateChallenge(Long id,Challenge updatedChallenge){
        Optional<Challenge> challenge=challengeRepository.findById(id);
        if(challenge.isPresent()){
            Challenge challengeToUpdate= challenge.get();
            challengeToUpdate.setMonth(updatedChallenge.getMonth());
            challengeToUpdate.setDescription(updatedChallenge.getDescription());
            challengeRepository.save(challengeToUpdate);
            return true;
        }
        return false;
    }
    public boolean deleteChallenge(Long id){
        Optional<Challenge> challenge=challengeRepository.findById(id);
        if(challenge.isPresent()){
            challengeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
