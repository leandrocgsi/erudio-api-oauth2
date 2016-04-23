package br.com.erudio.converter;

import ma.glasnost.orika.MapperFactory
import ma.glasnost.orika.impl.DefaultMapperFactory

class ObjectParser {

    private static final MapperFactory orikaMapper = new DefaultMapperFactory.Builder().build();
    
    static <O, D> D parseObjectInputToObjectOutput(O  originalObject, Class<D> destinationObject) {
        parser(destinationObject, originalObject);
    }

    static <O, D> List<D> parserListObjectInputToObjectOutput(List<O> originalObjects, Class<D> destinationObject) {
        List<D> destinationObjects = new ArrayList<D>();
        for (Object originalObject : originalObjects) destinationObjects.add(parser(destinationObject, originalObject));
        destinationObjects;
    }

    static <D> D parser(Class<D> destinationObject, Object originalObject) {
        orikaMapper.getMapperFacade().map(originalObject,destinationObject); 
    }
}