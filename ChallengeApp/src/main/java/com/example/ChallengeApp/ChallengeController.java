package com.example.ChallengeApp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
//@RequestMapping("/challenges")
@CrossOrigin(origins = "*")
public class ChallengeController {

    private ChallengeService challengeService;

    //@Autowired
    public ChallengeController(ChallengeService challengeService){
        this.challengeService=challengeService;
    }

    @GetMapping("/challenges")
    private ResponseEntity<List<Challenge>> getAllChallenges(){
        return new ResponseEntity<>(challengeService.getAllChallenges(),HttpStatus.OK);
    }
    @PostMapping("/challenges")
    public ResponseEntity<String> addChallenge(@RequestBody Challenge c1){
        boolean challengeadded=challengeService.addChallenge(c1);
        if(challengeadded){
            return new ResponseEntity<>("Challenge  Added Succesfully",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Challenge NOT Added Succesfully",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/challenges/{month}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable String month){
        Challenge c1=challengeService.getChallenge(month);
        if(c1!=null){
            return new ResponseEntity<>(c1, HttpStatus.OK);
        }
        return new ResponseEntity<>(c1, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/challenges/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id,@RequestBody Challenge updatedChallenge){
        boolean c1=challengeService.updateChallenge(id,updatedChallenge);
        if(c1) {
            return new ResponseEntity<>("Challenge updated Successfully", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Challenge not updated successfully",HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping("/challenges/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean c1=challengeService.deleteChallenge(id);
        if(c1){
            return new ResponseEntity<>("Challenge Deleted Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Challenge Not Deleted",HttpStatus.NOT_IMPLEMENTED);
    }

}
