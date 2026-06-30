package com.sduiBackend.api.services;

import com.sduiBackend.api.interfaces.DataFetcherService;
import com.sduiBackend.api.interfaces.UserView;
import com.sduiBackend.api.model.Node;
import com.sduiBackend.api.repository.UserRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class DataFetcherServiceImpl implements DataFetcherService {
    private final UserRepository userRepository;
    public DataFetcherServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    @Async
    public CompletableFuture<Optional<UserView>> fetchUserById(Long id){
        return CompletableFuture.completedFuture(userRepository.findById(id));
    }

    @Override
    public void processLinkedList(List<Long> ids){
        if (ids == null || ids.isEmpty()) return;
        Node head=new Node(ids.get(0));
        Node current=head;
        for(int i=1;i<ids.size();i++){
            current.next=new Node(ids.get(i));
            current=current.next;
        }
        current=head;
        while(current!=null){
            List<Long> batch=new ArrayList<>();
            for(int i=0;i<3 && current!=null;i++){
                batch.add(current.id);
                current=current.next;
            }
            List<CompletableFuture<Optional<UserView>>> data=batch.stream().map(this::fetchUserById).collect(Collectors.toList());
            CompletableFuture.allOf(data.toArray(new CompletableFuture[0])).join();
            for (CompletableFuture<Optional<UserView>> u : data) {
                u.join().ifPresent(user ->
                        System.out.println("Name: " + user.getName())
                );
            }
        }
    }
}
