package com.example.crud.Controller;

import com.example.crud.Entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal") //for
public class JournalEntryController {

    Map<Long, JournalEntry> JournalEntries = new HashMap<>(); //no database so it helps in keeping data //table

    @GetMapping
    public List<JournalEntry> getAll() {
        System.out.println("Data has been Recieved by the user"); //it is executed when the 'getAll' controller gets executed
        return new ArrayList<>(JournalEntries.values());
    }

    @PostMapping
    public String createEntry(@RequestBody JournalEntry myEntry) { //RequestBody is used for taking data from the request & turning it into a java Object which can be used in the code.
        //and "JournalEntry myEntry" is used for the data to be stored into the JournalEntries Hashmap("Map") using the variable myEntry instead of whole
        JournalEntries.put(myEntry.getId(), myEntry);
        System.out.println("Data has been Created");
        return "Data have been submitted";
    }

    @GetMapping("id/{myId}") //getting by ID number(path Variable) //localhost:8082/journal/id/myId(1, 2, 3, ..);
    public JournalEntry getJournalEntryById(@PathVariable Long myId){ //Pathvariable : ideates what'll be the path
        System.out.println("ID : " + myId + " has been Recieved by the user");
        return JournalEntries.get(myId); //get  //get : returns the value of the key //jou...get(id) says that the value
        //will be taken from the JournalEntries in this case
    }

    @DeleteMapping("id/{myId}") //deleting by ID number(path Variable) //localhost:8082/journal/id/myId(1, 2, 3, ..);
    public JournalEntry deleteJournalEntryById(@PathVariable Long myId){ //Pathvariable : ideates what'll be the path
        System.out.println("Data has been Deleted");
        return JournalEntries.remove(myId); //get  //remove : removes & returns the value of the key //jou...remove(id) says that the value
        //will be taken from the JournalEntries in this case and will get deleted/removed
    }

    @PutMapping("id/{id}")
    public JournalEntry updateJournalById(@PathVariable Long id, @RequestBody JournalEntry myEntry) {
        return JournalEntries.put(id, myEntry);
    }
}
