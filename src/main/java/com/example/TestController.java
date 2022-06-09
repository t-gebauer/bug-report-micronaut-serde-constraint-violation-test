package com.example;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.problem.violations.ConstraintViolationThrowableProblem;
import io.micronaut.serde.annotation.SerdeImport;
import org.zalando.problem.StatusType;

@Controller
@SerdeImport(ConstraintViolationThrowableProblem.class)
@SerdeImport(StatusType.class)
public class TestController {

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    public HttpResponse<Void> constraintViolation(@Body ConstraintViolationThrowableProblem problem) {
        System.out.println(problem.getTitle());
        return HttpResponse.ok();
    }

}
