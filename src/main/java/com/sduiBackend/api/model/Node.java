package com.sduiBackend.api.model;

public class Node {
    public Long id;
    public Node next;

    public Node(Long id) {
        this.id = id;
        this.next = null;
    }
}
