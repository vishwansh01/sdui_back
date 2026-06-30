package com.sduiBackend.api.interfaces;

import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface DataFetcherService {
    CompletableFuture<Optional<UserView>> fetchUserById(Long id);
    Flux<UserView> processLinkedList(List<Long> ids);
}


