package xyz.itshark.play.graphqlspringboot.example.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphQLException extends RuntimeException implements GraphQLError {
    private Map<String, Object> extensions = new HashMap<>();

    public GraphQLException(String message, String key, Object element) {
        super(message);
        extensions.put(key, element);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
