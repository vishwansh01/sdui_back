package com.sduiBackend.api;

import com.sduiBackend.api.interfaces.DataFetcherService;
import com.sduiBackend.api.model.Node;
import com.sduiBackend.api.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final DataFetcherService dataFetcher;

    public UserController(DataFetcherService dataFetcher) {
        this.dataFetcher = dataFetcher;
    }

    @PostMapping("/users/process-list")
    public String processUserList(@RequestBody List<Long> ids) {
        // The controller simply hands off the head of the list to the service.
        // It doesn't know about threads, batches, or repositories.
        dataFetcher.processLinkedList(ids);
        return "Batch processing has been triggered successfully!";
    }
}
