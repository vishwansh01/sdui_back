package com.sduiBackend.api.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface DataFetcherService {
    CompletableFuture<Optional<UserView>> fetchUserById(Long id);
    void processLinkedList(List<Long> ids);
}


