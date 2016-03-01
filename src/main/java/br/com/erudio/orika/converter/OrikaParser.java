package br.com.erudio.orika.converter;

import java.util.ArrayList;
import java.util.List;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrikaParser {

    private static final MapperFactory orikaMapper = new DefaultMapperFactory.Builder().build();
    
    public static <O, D> D parseObjectInputToObjectOutput(O  originalObject, Class<D> destinationObject) {
        return parser(destinationObject, originalObject);
    }

    public static <O, D> List<D> parserListObjectInputToObjectOutput(List<O> originalObjects, Class<D> destinationObject) {
        List<D> destinationObjects = new ArrayList<D>();
        for (Object originalObject : originalObjects) {
            destinationObjects.add(parser(destinationObject, originalObject));
        }
        return destinationObjects;
    }

    private static <D> D parser(Class<D> destinationObject, Object originalObject) {
        return orikaMapper.getMapperFacade().map(originalObject,destinationObject); 
    }
}
