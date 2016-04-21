package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;

class CrudController<T, K extends Serializable> {

    @Autowired
    protected CrudRepository<T, K> controllerRepository;

    @RequestMapping(path = "/{resourceId}", method = RequestMethod.GET)
    public HttpEntity<?> get(@PathVariable("resourceId") K resourceId) {
        T resource = controllerRepository.findOne(resourceId);
        if (resource == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(resource, HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<?> getAll() {
        Iterable<T> result = controllerRepository.findAll();
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public HttpEntity<?> getAll(@RequestParam(value = "dontuse", required = false) K dontuse) {  // Don't use. This is just here to workaround RequestMappingHandlerMapping issue
//        Iterable<T> result = controllerRepository.findAll();
//        return new ResponseEntity<Object>(result, HttpStatus.OK);
//    }

    @RequestMapping(method = RequestMethod.POST)
    public HttpEntity<?> create(@RequestBody @Valid T resource) {
        T savedResource = controllerRepository.save(resource);
        return new ResponseEntity<Object>(savedResource, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{resourceId}", method = RequestMethod.PUT)
    public HttpEntity<?> update(@PathVariable K resourceId, @RequestBody @Valid T resource) {
        T oldResource = controllerRepository.findOne(resourceId);
        if (oldResource == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        T updatedResource = controllerRepository.save(resource);

        return new ResponseEntity<Object>(updatedResource, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/{resourceId}", method = RequestMethod.DELETE)
    public HttpEntity<?> delete(@PathVariable K resourceId) {
        controllerRepository.delete(resourceId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
