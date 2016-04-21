# RequestMapping_Issue
This is a super simple Spring Rest service to demonstrate an issue I'm having with @RequestMapping

Normally, all 5 methods annotated with RequestMapping will get picked up and you will see logging output like this on startup:

```
2016-04-21 14:18:50.311  INFO 15928 --- [           main] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@6dd1ba5a: startup date [Thu Apr 21 14:18:37 MDT 2016]; root of context hierarchy
2016-04-21 14:18:50.598  INFO 15928 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/hats],methods=[GET]}" onto public org.springframework.http.HttpEntity<?> com.example.CrudController.getAll(K)
2016-04-21 14:18:50.610  INFO 15928 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/hats/{resourceId}],methods=[GET]}" onto public org.springframework.http.HttpEntity<?> com.example.CrudController.get(K)
2016-04-21 14:18:50.614  INFO 15928 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/hats/{resourceId}],methods=[PUT]}" onto public org.springframework.http.HttpEntity<?> com.example.CrudController.update(K,T)
2016-04-21 14:18:50.616  INFO 15928 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/hats/{resourceId}],methods=[DELETE]}" onto public org.springframework.http.HttpEntity<?> com.example.CrudController.delete(K)
2016-04-21 14:18:50.619  INFO 15928 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/hats],methods=[POST]}" onto public org.springframework.http.HttpEntity<?> com.example.CrudController.create(T)
```

However, if the comment out the getAll method with the dummy parameter and use the one with no parameters, it won't get picked up and you'll get logging output like this:

```
2016-04-21 14:18:50.311  INFO 15928 --- [           main] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@6dd1ba5a: startup date [Thu Apr 21 14:18:37 MDT 2016]; root of context hierarchy
2016-04-21 14:18:50.610  INFO 15928 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/hats/{resourceId}],methods=[GET]}" onto public org.springframework.http.HttpEntity<?> com.example.CrudController.get(K)
2016-04-21 14:18:50.614  INFO 15928 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/hats/{resourceId}],methods=[PUT]}" onto public org.springframework.http.HttpEntity<?> com.example.CrudController.update(K,T)
2016-04-21 14:18:50.616  INFO 15928 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/hats/{resourceId}],methods=[DELETE]}" onto public org.springframework.http.HttpEntity<?> com.example.CrudController.delete(K)
2016-04-21 14:18:50.619  INFO 15928 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/hats],methods=[POST]}" onto public org.springframework.http.HttpEntity<?> com.example.CrudController.create(T)
```
