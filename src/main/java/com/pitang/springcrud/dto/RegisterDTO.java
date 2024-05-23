package com.pitang.springcrud.dto;

import com.pitang.springcrud.entity.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
