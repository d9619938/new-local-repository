package com.local.project.lesson19.nullsafe;

import java.util.Optional;
import java.util.Set;

public class RequestData {
    private String name;
    private String uri;
    private Set<String> scopes;

    public boolean isValid() {
        return Optional.of(this)
                .filter(request -> request.name != null /*&& request.uri != null*/)
                .filter(request -> request.uri != null)
                .filter(request -> !request.scopes.contains(null))
                .isPresent();
    }

    public Optional<String> getName(){
        return Optional.of(this)
                .filter(request -> request.scopes
                        .stream()
                        .noneMatch(s -> s.isEmpty() || s.isBlank()))
                .map(request -> request.name);
    }
}