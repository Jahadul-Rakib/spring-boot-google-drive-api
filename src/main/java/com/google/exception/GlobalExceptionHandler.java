package com.google.exception;

import com.google.exception.DriveAccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DriveAccessDeniedException.class)
    public RedirectView notFoundException(final DriveAccessDeniedException e, RedirectAttributes attributes) throws IOException {
        e.getMessage();
        RedirectView redirectView = new RedirectView("/unauthorized",true);
        redirectView.addStaticAttribute("message",e.getMessage());
        attributes.addFlashAttribute("message", e.getMessage());
        return redirectView;
    }
}
