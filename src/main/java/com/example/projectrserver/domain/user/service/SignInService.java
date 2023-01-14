package com.example.projectrserver.domain.user.service;

import com.example.projectrserver.domain.user.domain.User;
import com.example.projectrserver.domain.user.domain.repository.UserRepository;
import com.example.projectrserver.domain.user.present.dto.SignUpDto;
import com.example.projectrserver.domain.user.present.dto.TokenResponse;
import com.example.projectrserver.global.security.jwt.JwtTokenProvider;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignInService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenResponse signIn(SignUpDto request) {
        User user = userRepository.save(
                User.builder()
                        .name(request.getName())
                        .build()
        );

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(user.getName()))
                .build();
    }
}
