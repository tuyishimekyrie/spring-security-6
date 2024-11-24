package com.kyrie.security.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Welcome API", description = "APIs for welcome page and security tokens")
@Slf4j
@RequiredArgsConstructor
public class WelcomeController {


    @Operation(
            summary = "Get welcome message",
            description = "Returns a welcome message along with basic system information"
    )
    @GetMapping("")
    public String welcome() {
        return "Welcome to Kyrie Security";
    }
    @Operation(
            summary = "Get CSRF token",
            description = "Returns the CSRF token for securing form submissions",
            security = @SecurityRequirement(name = "session")
    )
    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
