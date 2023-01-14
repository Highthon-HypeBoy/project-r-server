package com.example.projectrserver.global.error.custom;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    EXPIRED_JWT(401, "jwt-401-1", "토큰 만료"),
    INVALID_JWT(401, "jwt-401-1", "토큰 인증 실패"),

    USER_NOT_FOUND(404, "user-404-1", "유저를 찾지 못함"),

    INTERNAL_SERVER_ERROR(500, "server-1", "서버에러");

    private final int status;
    private final String code;
    private final String message;
}